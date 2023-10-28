package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;

public class ClassReader
  extends b
{
  private OrientationHelper memoizedClassIdValue;
  private OrientationHelper value;
  
  public ClassReader() {}
  
  private int a(View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - (paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2);
  }
  
  private View a(RecyclerView.o paramO, OrientationHelper paramOrientationHelper)
  {
    int n = paramO.getChildCount();
    Object localObject = null;
    if (n == 0) {
      return null;
    }
    int i1 = paramOrientationHelper.getStartAfterPadding();
    int i2 = paramOrientationHelper.getTotalSpace() / 2;
    int j = Integer.MAX_VALUE;
    int i = 0;
    while (i < n)
    {
      View localView = paramO.getChildAt(i);
      int m = Math.abs(paramOrientationHelper.getDecoratedStart(localView) + paramOrientationHelper.getDecoratedMeasurement(localView) / 2 - (i1 + i2));
      int k = j;
      if (m < j)
      {
        localObject = localView;
        k = m;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  private boolean a(RecyclerView.o paramO)
  {
    int i = paramO.getItemCount();
    if ((paramO instanceof RecyclerView.x.b))
    {
      paramO = ((RecyclerView.x.b)paramO).onSaveInstanceState(i - 1);
      if ((paramO != null) && ((x < 0.0F) || (y < 0.0F))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(RecyclerView.o paramO, int paramInt1, int paramInt2)
  {
    if (paramO.canScrollHorizontally()) {
      return paramInt1 > 0;
    }
    return paramInt2 > 0;
  }
  
  private OrientationHelper readClass(RecyclerView.o paramO)
  {
    OrientationHelper localOrientationHelper = memoizedClassIdValue;
    if ((localOrientationHelper == null) || (mLayoutManager != paramO)) {
      memoizedClassIdValue = OrientationHelper.read(paramO);
    }
    return memoizedClassIdValue;
  }
  
  private OrientationHelper readInt(RecyclerView.o paramO)
  {
    OrientationHelper localOrientationHelper = value;
    if ((localOrientationHelper == null) || (mLayoutManager != paramO)) {
      value = OrientationHelper.valueOf(paramO);
    }
    return value;
  }
  
  private OrientationHelper readLong(RecyclerView.o paramO)
  {
    if (paramO.canScrollVertically()) {
      return readInt(paramO);
    }
    if (paramO.canScrollHorizontally()) {
      return readClass(paramO);
    }
    return null;
  }
  
  public int a(RecyclerView.o paramO, int paramInt1, int paramInt2)
  {
    int i2 = paramO.getItemCount();
    if (i2 == 0) {
      return -1;
    }
    OrientationHelper localOrientationHelper = readLong(paramO);
    if (localOrientationHelper == null) {
      return -1;
    }
    int j = Integer.MIN_VALUE;
    int m = Integer.MAX_VALUE;
    int i3 = paramO.getChildCount();
    int k = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    while (k < i3)
    {
      View localView = paramO.getChildAt(k);
      int i1;
      Object localObject4;
      if (localView == null)
      {
        i1 = m;
        localObject4 = localObject2;
      }
      else
      {
        int n = a(localView, localOrientationHelper);
        int i = j;
        Object localObject3 = localObject1;
        if (n <= 0)
        {
          i = j;
          localObject3 = localObject1;
          if (n > j)
          {
            localObject3 = localView;
            i = n;
          }
        }
        j = i;
        i1 = m;
        localObject4 = localObject2;
        localObject1 = localObject3;
        if (n >= 0)
        {
          j = i;
          i1 = m;
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (n < m)
          {
            localObject1 = localObject3;
            localObject4 = localView;
            i1 = n;
            j = i;
          }
        }
      }
      k += 1;
      m = i1;
      localObject2 = localObject4;
    }
    boolean bool = b(paramO, paramInt1, paramInt2);
    if ((bool) && (localObject2 != null)) {
      return paramO.getPosition(localObject2);
    }
    if ((!bool) && (localObject1 != null)) {
      return paramO.getPosition(localObject1);
    }
    if (bool) {
      localObject2 = localObject1;
    }
    if (localObject2 == null) {
      return -1;
    }
    paramInt2 = paramO.getPosition(localObject2);
    if (a(paramO) == bool) {
      paramInt1 = -1;
    } else {
      paramInt1 = 1;
    }
    paramInt1 = paramInt2 + paramInt1;
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= i2) {
        return -1;
      }
      return paramInt1;
    }
    return -1;
  }
  
  public int[] a(RecyclerView.o paramO, View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramO.canScrollHorizontally()) {
      arrayOfInt[0] = a(paramView, readClass(paramO));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramO.canScrollVertically())
    {
      arrayOfInt[1] = a(paramView, readInt(paramO));
      return arrayOfInt;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  public View b(RecyclerView.o paramO)
  {
    if (paramO.canScrollVertically()) {
      return a(paramO, readInt(paramO));
    }
    if (paramO.canScrollHorizontally()) {
      return a(paramO, readClass(paramO));
    }
    return null;
  }
  
  protected RecyclerView.x close(RecyclerView.o paramO)
  {
    if (!(paramO instanceof RecyclerView.x.b)) {
      return null;
    }
    return new StaggeredGridLayoutManager.2(this, c.getContext());
  }
}
