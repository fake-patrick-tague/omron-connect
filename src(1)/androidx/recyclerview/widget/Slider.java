package androidx.recyclerview.widget;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import v7.v7.menu.TraceCompat;

final class Slider
  implements Runnable
{
  static final ThreadLocal<j> id = new ThreadLocal();
  static Comparator<j.c> type = new HeapElement.1();
  private ArrayList<j.c> a = new ArrayList();
  ArrayList<RecyclerView> l = new ArrayList();
  long value;
  long y;
  
  Slider() {}
  
  private RecyclerView.b0 a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    if (findViewHolderForPosition(paramRecyclerView, paramInt)) {
      return null;
    }
    RecyclerView.u localU = mRecycler;
    try
    {
      paramRecyclerView.onEnterLayoutOrScroll();
      RecyclerView.b0 localB0 = localU.getViewForPosition(paramInt, false, paramLong);
      if (localB0 != null)
      {
        boolean bool = localB0.isBound();
        if (bool)
        {
          bool = localB0.isInvalid();
          if (!bool)
          {
            localU.recycleView(itemView);
            break label80;
          }
        }
        localU.a(localB0, false);
      }
      label80:
      paramRecyclerView.scrollByInternal(false);
      return localB0;
    }
    catch (Throwable localThrowable)
    {
      paramRecyclerView.scrollByInternal(false);
      throw localThrowable;
    }
  }
  
  private void a()
  {
    Object localObject2 = l;
    Object localObject1 = this;
    int n = ((ArrayList)localObject2).size();
    int i = 0;
    int k;
    for (int j = 0; i < n; j = k)
    {
      localObject2 = l;
      localObject2 = (RecyclerView)((ArrayList)localObject2).get(i);
      k = j;
      if (((View)localObject2).getWindowVisibility() == 0)
      {
        h.run((RecyclerView)localObject2, false);
        k = j + h.a;
      }
      i += 1;
    }
    localObject2 = a;
    ((ArrayList)localObject2).ensureCapacity(j);
    j = 0;
    i = 0;
    while (j < n)
    {
      localObject2 = l;
      RecyclerView localRecyclerView = (RecyclerView)((ArrayList)localObject2).get(j);
      int m;
      if (localRecyclerView.getWindowVisibility() != 0)
      {
        m = i;
        localObject2 = localObject1;
      }
      else
      {
        Item localItem = h;
        int i1 = Math.abs(b) + Math.abs(d);
        k = 0;
        for (;;)
        {
          m = i;
          localObject2 = localObject1;
          if (k >= a * 2) {
            break;
          }
          if (i >= a.size())
          {
            localObject2 = new Coordinate();
            a.add(localObject2);
          }
          else
          {
            localObject2 = (Coordinate)a.get(i);
          }
          int[] arrayOfInt = c;
          m = arrayOfInt[(k + 1)];
          boolean bool;
          if (m <= i1) {
            bool = true;
          } else {
            bool = false;
          }
          c = bool;
          z = i1;
          x = m;
          y = localRecyclerView;
          p = arrayOfInt[k];
          i += 1;
          k += 2;
        }
      }
      j += 1;
      i = m;
      localObject1 = localObject2;
    }
    Collections.sort(a, type);
  }
  
  private void add(Coordinate paramCoordinate, long paramLong)
  {
    long l1;
    if (c) {
      l1 = Long.MAX_VALUE;
    } else {
      l1 = paramLong;
    }
    paramCoordinate = a(y, p, l1);
    if ((paramCoordinate != null) && (mNestedRecyclerView != null) && (paramCoordinate.isBound()) && (!paramCoordinate.isInvalid())) {
      run((RecyclerView)mNestedRecyclerView.get(), paramLong);
    }
  }
  
  static boolean findViewHolderForPosition(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.b0 localB0 = RecyclerView.getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
      if ((mPosition == paramInt) && (!localB0.isInvalid())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void run(RecyclerView paramRecyclerView, long paramLong)
  {
    if (paramRecyclerView == null) {
      return;
    }
    if ((mDataSetHasChangedAfterLayout) && (mChildHelper.getUnfilteredChildCount() != 0)) {
      paramRecyclerView.setAdapterInternal();
    }
    Item localItem = h;
    localItem.run(paramRecyclerView, true);
    if (a != 0) {
      try
      {
        TraceCompat.beginSection("RV Nested Prefetch");
        mState.dispatchLayoutStep1(mAdapter);
        int i = 0;
        for (;;)
        {
          int j = a;
          if (i >= j * 2) {
            break;
          }
          a(paramRecyclerView, c[i], paramLong);
          i += 2;
        }
        TraceCompat.beginSection();
        return;
      }
      catch (Throwable paramRecyclerView)
      {
        TraceCompat.beginSection();
        throw paramRecyclerView;
      }
    }
  }
  
  private void write(long paramLong)
  {
    int i = 0;
    while (i < a.size())
    {
      Coordinate localCoordinate = (Coordinate)a.get(i);
      if (y == null) {
        return;
      }
      add(localCoordinate, paramLong);
      localCoordinate.add();
      i += 1;
    }
  }
  
  void draw(long paramLong)
  {
    a();
    write(paramLong);
  }
  
  public void draw(RecyclerView paramRecyclerView)
  {
    l.remove(paramRecyclerView);
  }
  
  public void run()
  {
    try
    {
      TraceCompat.beginSection("RV Prefetch");
      boolean bool = l.isEmpty();
      if (bool) {}
      do
      {
        y = 0L;
        TraceCompat.beginSection();
        return;
        int j = l.size();
        int i = 0;
        for (l1 = 0L; i < j; l1 = l2)
        {
          RecyclerView localRecyclerView = (RecyclerView)l.get(i);
          int k = localRecyclerView.getWindowVisibility();
          l2 = l1;
          if (k == 0) {
            l2 = Math.max(localRecyclerView.getDrawingTime(), l1);
          }
          i += 1;
        }
      } while (l1 == 0L);
      long l1 = TimeUnit.MILLISECONDS.toNanos(l1);
      long l2 = value;
      draw(l1 + l2);
      y = 0L;
      TraceCompat.beginSection();
      return;
    }
    catch (Throwable localThrowable)
    {
      y = 0L;
      TraceCompat.beginSection();
      throw localThrowable;
    }
  }
  
  public void start(RecyclerView paramRecyclerView)
  {
    l.add(paramRecyclerView);
  }
  
  void start(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (y == 0L))
    {
      y = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    h.a(paramInt1, paramInt2);
  }
}
