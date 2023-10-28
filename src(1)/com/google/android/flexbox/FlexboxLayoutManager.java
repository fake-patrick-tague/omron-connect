package com.google.android.flexbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.o.d;
import androidx.recyclerview.widget.RecyclerView.u;
import androidx.recyclerview.widget.RecyclerView.x;
import androidx.recyclerview.widget.RecyclerView.x.b;
import androidx.recyclerview.widget.RecyclerView.y;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager
  extends RecyclerView.o
  implements i, RecyclerView.x.b
{
  private static final Rect z = new Rect();
  private c a;
  private Label b = new Label();
  private OrientationHelper c;
  private final ByteVector d = new ByteVector(this);
  private RecyclerView.u e;
  private boolean f;
  private int g = Integer.MIN_VALUE;
  private int h = -1;
  private boolean i;
  private int j;
  private int k = Integer.MIN_VALUE;
  private int l;
  private int m;
  private boolean mAvailable;
  private final Context mContext;
  private OrientationHelper n;
  private SparseArray<View> o = new SparseArray();
  private int p = -1;
  private int q = -1;
  private int r;
  private View right;
  private SavedState s;
  private int v = Integer.MIN_VALUE;
  private RecyclerView.y w;
  private List<b> x = new ArrayList();
  private b y = new b(null);
  
  public FlexboxLayoutManager(Context paramContext)
  {
    this(paramContext, 0, 1);
  }
  
  public FlexboxLayoutManager(Context paramContext, int paramInt1, int paramInt2)
  {
    initialize(paramInt1);
    reset(paramInt2);
    set(4);
    setAutoMeasureEnabled(true);
    mContext = paramContext;
  }
  
  public FlexboxLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = RecyclerView.o.getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = orientation;
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1) {
        if (reverseLayout) {
          initialize(3);
        } else {
          initialize(2);
        }
      }
    }
    else if (reverseLayout) {
      initialize(1);
    } else {
      initialize(0);
    }
    reset(1);
    set(4);
    setAutoMeasureEnabled(true);
    mContext = paramContext;
  }
  
  private int a(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY, boolean paramBoolean)
  {
    int i1;
    if ((!getValue()) && (i))
    {
      i1 = c.getEndAfterPadding() - paramInt;
      if (i1 > 0) {
        i1 = b(-i1, paramU, paramY);
      } else {
        return 0;
      }
    }
    else
    {
      i1 = paramInt - c.getStartAfterPadding();
      if (i1 <= 0) {
        break label109;
      }
      i1 = -b(i1, paramU, paramY);
    }
    if (paramBoolean)
    {
      paramInt = paramInt + i1 - c.getStartAfterPadding();
      if (paramInt > 0)
      {
        c.offsetChildren(-paramInt);
        return i1 - paramInt;
        label109:
        return 0;
      }
    }
    return i1;
  }
  
  private int a(RecyclerView.u paramU, RecyclerView.y paramY, c paramC)
  {
    if (c.toString(paramC) != Integer.MIN_VALUE)
    {
      if (c.a(paramC) < 0) {
        c.c(paramC, c.toString(paramC) + c.a(paramC));
      }
      f(paramU, paramC);
    }
    int i3 = c.a(paramC);
    int i1 = c.a(paramC);
    int i2 = 0;
    boolean bool = getValue();
    while (((i1 > 0) || (c.g(a))) && (c.a(paramC, paramY, x)))
    {
      m localM = (m)x.get(c.c(paramC));
      c.a(paramC, f);
      i2 += d(localM, paramC);
      if ((!bool) && (i)) {
        c.b(paramC, c.newUTF8(paramC) - localM.c() * c.i(paramC));
      } else {
        c.b(paramC, c.newUTF8(paramC) + localM.c() * c.i(paramC));
      }
      i1 -= localM.c();
    }
    c.finish(paramC, c.a(paramC) - i2);
    if (c.toString(paramC) != Integer.MIN_VALUE)
    {
      c.c(paramC, c.toString(paramC) + i2);
      if (c.a(paramC) < 0) {
        c.c(paramC, c.toString(paramC) + c.a(paramC));
      }
      f(paramU, paramC);
    }
    return i3 - c.a(paramC);
  }
  
  private int a(m paramM, c paramC)
  {
    int i6 = getPaddingLeft();
    int i3 = getPaddingRight();
    int i5 = getWidth();
    int i1 = c.newUTF8(paramC);
    int i2 = i1;
    if (c.i(paramC) == -1) {
      i2 = i1 - k;
    }
    int i4 = c.e(paramC);
    i1 = j;
    float f2;
    float f3;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 == 5)
              {
                i1 = c;
                if (i1 != 0) {
                  f1 = (i5 - b) / (i1 + 1);
                } else {
                  f1 = 0.0F;
                }
                f2 = i6 + f1;
                f3 = i5 - i3 - f1;
                break label376;
              }
              paramM = new StringBuilder();
              paramM.append("Invalid justifyContent is set: ");
              paramM.append(j);
              throw new IllegalStateException(paramM.toString());
            }
            i1 = c;
            if (i1 != 0) {
              f1 = (i5 - b) / i1;
            } else {
              f1 = 0.0F;
            }
            f2 = i6;
            f3 = f1 / 2.0F;
            f2 += f3;
            f3 = i5 - i3 - f3;
            break label376;
          }
          f2 = i6;
          i1 = c;
          if (i1 != 1) {
            f1 = i1 - 1;
          } else {
            f1 = 1.0F;
          }
          f1 = (i5 - b) / f1;
          f3 = i5 - i3;
          break label376;
        }
        f1 = i6;
        i1 = b;
        f2 = f1 + (i5 - i1) / 2.0F;
        f3 = i5 - i3 - (i5 - i1) / 2.0F;
      }
      else
      {
        i1 = b;
        f2 = i5 - i1 + i3;
        f1 = 0.0F;
        f3 = i1 - i6;
        break label376;
      }
    }
    else
    {
      f2 = i6;
      f3 = i5 - i3;
    }
    float f1 = 0.0F;
    label376:
    f2 -= b.scrollBy(y);
    f3 -= b.scrollBy(y);
    float f4 = Math.max(f1, 0.0F);
    i1 = 0;
    i5 = paramM.a();
    i3 = i4;
    f1 = f3;
    while (i3 < i4 + i5)
    {
      View localView = next(i3);
      if (localView != null)
      {
        if (c.i(paramC) == 1)
        {
          calculateItemDecorationsForChild(localView, z);
          addView(localView);
        }
        else
        {
          calculateItemDecorationsForChild(localView, z);
          addView(localView, i1);
          i1 += 1;
        }
        Object localObject = d;
        long l1 = x[i3];
        i6 = ((ByteVector)localObject).b(l1);
        int i7 = d.a(l1);
        localObject = (LayoutParams)localView.getLayoutParams();
        if (shouldMeasureChild(localView, i6, i7, (RecyclerView.LayoutParams)localObject)) {
          localView.measure(i6, i7);
        }
        f2 += leftMargin + c(localView);
        f1 -= rightMargin + next(localView);
        i6 = i2 + f(localView);
        if (i) {
          d.a(localView, paramM, Math.round(f1) - localView.getMeasuredWidth(), i6, Math.round(f1), i6 + localView.getMeasuredHeight());
        } else {
          d.a(localView, paramM, Math.round(f2), i6, Math.round(f2) + localView.getMeasuredWidth(), i6 + localView.getMeasuredHeight());
        }
        float f5 = localView.getMeasuredWidth() + rightMargin + next(localView);
        f3 = localView.getMeasuredWidth() + leftMargin + c(localView);
        f2 += f5 + f4;
        f1 -= f3 + f4;
      }
      i3 += 1;
    }
    c.get(paramC, c.c(paramC) + c.i(a));
    return paramM.c();
  }
  
  private View a(View paramView, m paramM)
  {
    boolean bool = getValue();
    int i2 = c;
    int i1 = 1;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      paramM = paramView;
      if (localView != null) {
        if (localView.getVisibility() == 8)
        {
          paramM = paramView;
        }
        else
        {
          if ((i) && (!bool))
          {
            paramM = paramView;
            if (c.getDecoratedEnd(paramView) >= c.getDecoratedEnd(localView)) {
              break label111;
            }
          }
          else
          {
            paramM = paramView;
            if (c.getDecoratedStart(paramView) <= c.getDecoratedStart(localView)) {
              break label111;
            }
          }
          paramM = localView;
        }
      }
      label111:
      i1 += 1;
      paramView = paramM;
    }
    return paramView;
  }
  
  private void a(int paramInt)
  {
    int i3 = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
    int i4 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
    int i5 = getWidth();
    int i6 = getHeight();
    boolean bool = getValue();
    int i1 = 1;
    int i2 = 1;
    if (bool)
    {
      i1 = g;
      if ((i1 == Integer.MIN_VALUE) || (i1 == i5)) {
        i2 = 0;
      }
      if (c.g(a)) {
        i1 = mContext.getResources().getDisplayMetrics().heightPixels;
      } else {
        i1 = c.a(a);
      }
    }
    else
    {
      i2 = v;
      if ((i2 != Integer.MIN_VALUE) && (i2 != i6)) {
        i2 = i1;
      } else {
        i2 = 0;
      }
      if (c.g(a)) {
        i1 = mContext.getResources().getDisplayMetrics().widthPixels;
      } else {
        i1 = c.a(a);
      }
    }
    g = i5;
    v = i6;
    i5 = p;
    if ((i5 == -1) && ((h != -1) || (i2 != 0)))
    {
      if (b.b(y)) {
        return;
      }
      x.clear();
      b.b();
      if (getValue()) {
        d.add(b, i3, i4, i1, b.a(y), x);
      } else {
        d.write(b, i3, i4, i1, b.a(y), x);
      }
      x = b.f;
      d.putByte(i3, i4);
      d.putShort();
      b localB = y;
      b.a(localB, d.c[b.a(localB)]);
      c.get(a, b.c(y));
      return;
    }
    if (i5 != -1) {
      i2 = Math.min(i5, b.a(y));
    } else {
      i2 = b.a(y);
    }
    b.b();
    if (getValue())
    {
      if (x.size() > 0)
      {
        d.get(x, i2);
        d.a(b, i3, i4, i1, i2, b.a(y), x);
      }
      else
      {
        d.get(paramInt);
        d.b(b, i3, i4, i1, 0, x);
      }
    }
    else if (x.size() > 0)
    {
      d.get(x, i2);
      d.a(b, i4, i3, i1, i2, b.a(y), x);
    }
    else
    {
      d.get(paramInt);
      d.a(b, i3, i4, i1, 0, x);
    }
    x = b.f;
    d.a(i3, i4, i2);
    d.a(i2);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    c.d(a, paramInt1);
    boolean bool = getValue();
    int i4 = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
    int i5 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
    int i2 = 0;
    int i3 = 0;
    int i1;
    if ((!bool) && (i)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject2;
    if (paramInt1 == 1)
    {
      localObject1 = getChildAt(getChildCount() - 1);
      c.b(a, c.getDecoratedEnd((View)localObject1));
      paramInt1 = getPosition((View)localObject1);
      i2 = d.c[paramInt1];
      localObject1 = b((View)localObject1, (m)x.get(i2));
      c.f(a, 1);
      localObject2 = a;
      c.a((c)localObject2, paramInt1 + c.d((c)localObject2));
      if (d.c.length <= c.e(a))
      {
        c.get(a, -1);
      }
      else
      {
        localObject2 = a;
        c.get((c)localObject2, d.c[c.e(localObject2)]);
      }
      if (i1 != 0)
      {
        c.b(a, c.getDecoratedStart((View)localObject1));
        c.c(a, -c.getDecoratedStart((View)localObject1) + c.getStartAfterPadding());
        localObject1 = a;
        paramInt1 = i3;
        if (c.toString((c)localObject1) >= 0) {
          paramInt1 = c.toString(a);
        }
        c.c((c)localObject1, paramInt1);
      }
      else
      {
        c.b(a, c.getDecoratedEnd((View)localObject1));
        c.c(a, c.getDecoratedEnd((View)localObject1) - c.getEndAfterPadding());
      }
      if (((c.c(a) == -1) || (c.c(a) > x.size() - 1)) && (c.e(a) <= c()))
      {
        paramInt1 = paramInt2 - c.toString(a);
        b.b();
        if (paramInt1 > 0)
        {
          if (bool) {
            d.b(b, i4, i5, paramInt1, c.e(a), x);
          } else {
            d.a(b, i4, i5, paramInt1, c.e(a), x);
          }
          d.a(i4, i5, c.e(a));
          d.a(c.e(a));
        }
      }
    }
    else
    {
      localObject1 = getChildAt(0);
      c.b(a, c.getDecoratedStart((View)localObject1));
      i4 = getPosition((View)localObject1);
      paramInt1 = d.c[i4];
      localObject1 = a((View)localObject1, (m)x.get(paramInt1));
      c.f(a, 1);
      i3 = d.c[i4];
      paramInt1 = i3;
      if (i3 == -1) {
        paramInt1 = 0;
      }
      if (paramInt1 > 0)
      {
        localObject2 = (m)x.get(paramInt1 - 1);
        c.a(a, i4 - ((m)localObject2).a());
      }
      else
      {
        c.a(a, -1);
      }
      localObject2 = a;
      if (paramInt1 > 0) {
        paramInt1 -= 1;
      } else {
        paramInt1 = 0;
      }
      c.get((c)localObject2, paramInt1);
      if (i1 != 0)
      {
        c.b(a, c.getDecoratedEnd((View)localObject1));
        c.c(a, c.getDecoratedEnd((View)localObject1) - c.getEndAfterPadding());
        localObject1 = a;
        paramInt1 = i2;
        if (c.toString((c)localObject1) >= 0) {
          paramInt1 = c.toString(a);
        }
        c.c((c)localObject1, paramInt1);
      }
      else
      {
        c.b(a, c.getDecoratedStart((View)localObject1));
        c.c(a, -c.getDecoratedStart((View)localObject1) + c.getStartAfterPadding());
      }
    }
    Object localObject1 = a;
    c.finish((c)localObject1, paramInt2 - c.toString((c)localObject1));
  }
  
  private void a(RecyclerView.u paramU, int paramInt1, int paramInt2)
  {
    while (paramInt2 >= paramInt1)
    {
      removeAndRecycleViewAt(paramInt2, paramU);
      paramInt2 -= 1;
    }
  }
  
  private void a(RecyclerView.u paramU, c paramC)
  {
    if (c.toString(paramC) < 0) {
      return;
    }
    int i5 = getChildCount();
    if (i5 == 0) {
      return;
    }
    Object localObject1 = getChildAt(0);
    int i3 = d.c[getPosition(localObject1)];
    int i2 = -1;
    if (i3 == -1) {
      return;
    }
    localObject1 = (m)x.get(i3);
    int i1 = 0;
    int i4;
    for (;;)
    {
      i4 = i2;
      if (i1 >= i5) {
        break;
      }
      View localView = getChildAt(i1);
      i4 = i2;
      if (!isEmpty(localView, c.toString(paramC))) {
        break;
      }
      i4 = i3;
      Object localObject2 = localObject1;
      if (v == getPosition(localView))
      {
        if (i3 >= x.size() - 1)
        {
          i4 = i1;
          break;
        }
        i4 = i3 + c.i(paramC);
        localObject2 = (m)x.get(i4);
        i2 = i1;
      }
      i1 += 1;
      i3 = i4;
      localObject1 = localObject2;
    }
    a(paramU, 0, i4);
  }
  
  private void a(b paramB, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      visitEnd();
    } else {
      c.b(a, false);
    }
    if ((!getValue()) && (i)) {
      c.finish(a, right.getWidth() - b.f(paramB) - c.getStartAfterPadding());
    } else {
      c.finish(a, b.f(paramB) - c.getStartAfterPadding());
    }
    c.a(a, b.a(paramB));
    c.f(a, 1);
    c.d(a, -1);
    c.b(a, b.f(paramB));
    c.c(a, Integer.MIN_VALUE);
    c.get(a, b.c(paramB));
    if ((paramBoolean1) && (b.c(paramB) > 0) && (x.size() > b.c(paramB)))
    {
      paramB = (m)x.get(b.c(paramB));
      c.add(a);
      c localC = a;
      c.a(localC, c.e(localC) - paramB.a());
    }
  }
  
  private boolean a(View paramView, int paramInt)
  {
    if ((!getValue()) && (i)) {
      return c.getDecoratedEnd(paramView) <= paramInt;
    }
    return c.getDecoratedStart(paramView) >= c.getEnd() - paramInt;
  }
  
  private int b(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      clear();
      c localC = a;
      int i2 = 1;
      c.f(localC, true);
      int i1;
      if ((!getValue()) && (i)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        if (paramInt < 0) {}
      }
      else {
        while (paramInt <= 0)
        {
          i2 = -1;
          break;
        }
      }
      int i3 = Math.abs(paramInt);
      a(i2, i3);
      int i4 = c.toString(a) + a(paramU, paramY, a);
      if (i4 < 0) {
        return 0;
      }
      if (i1 != 0)
      {
        if (i3 > i4) {
          paramInt = -i2 * i4;
        }
      }
      else if (i3 > i4) {
        paramInt = i2 * i4;
      }
      c.offsetChildren(-paramInt);
      c.doFinal(a, paramInt);
      return paramInt;
    }
    return 0;
  }
  
  private int b(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY, boolean paramBoolean)
  {
    int i1;
    if ((!getValue()) && (i)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      i1 = paramInt - c.getStartAfterPadding();
      if (i1 > 0) {
        i1 = b(i1, paramU, paramY);
      } else {
        return 0;
      }
    }
    else
    {
      i1 = c.getEndAfterPadding() - paramInt;
      if (i1 <= 0) {
        break label125;
      }
      i1 = -b(-i1, paramU, paramY);
    }
    if (paramBoolean)
    {
      paramInt = c.getEndAfterPadding() - (paramInt + i1);
      if (paramInt > 0)
      {
        c.offsetChildren(paramInt);
        return paramInt + i1;
      }
    }
    else
    {
      return i1;
      label125:
      return 0;
    }
    return i1;
  }
  
  private int b(m paramM, c paramC)
  {
    int i8 = getPaddingTop();
    int i6 = getPaddingBottom();
    int i7 = getHeight();
    int i4 = c.newUTF8(paramC);
    int i2 = i4;
    int i1 = c.newUTF8(paramC);
    int i3 = i1;
    if (c.i(paramC) == -1)
    {
      i3 = k;
      i2 = i4 - i3;
      i3 = i1 + i3;
    }
    int i5 = c.e(paramC);
    i1 = j;
    float f2;
    float f3;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 == 5)
              {
                i1 = c;
                if (i1 != 0) {
                  f1 = (i7 - b) / (i1 + 1);
                } else {
                  f1 = 0.0F;
                }
                f2 = i8 + f1;
                f3 = i7 - i6 - f1;
                break label397;
              }
              paramM = new StringBuilder();
              paramM.append("Invalid justifyContent is set: ");
              paramM.append(j);
              throw new IllegalStateException(paramM.toString());
            }
            i1 = c;
            if (i1 != 0) {
              f1 = (i7 - b) / i1;
            } else {
              f1 = 0.0F;
            }
            f2 = i8;
            f3 = f1 / 2.0F;
            f2 += f3;
            f3 = i7 - i6 - f3;
            break label397;
          }
          f2 = i8;
          i1 = c;
          if (i1 != 1) {
            f1 = i1 - 1;
          } else {
            f1 = 1.0F;
          }
          f1 = (i7 - b) / f1;
          f3 = i7 - i6;
          break label397;
        }
        f1 = i8;
        i1 = b;
        f2 = f1 + (i7 - i1) / 2.0F;
        f3 = i7 - i6 - (i7 - i1) / 2.0F;
      }
      else
      {
        i1 = b;
        f2 = i7 - i1 + i6;
        f1 = 0.0F;
        f3 = i1 - i8;
        break label397;
      }
    }
    else
    {
      f2 = i8;
      f3 = i7 - i6;
    }
    float f1 = 0.0F;
    label397:
    f2 -= b.scrollBy(y);
    f3 -= b.scrollBy(y);
    float f4 = Math.max(f1, 0.0F);
    i1 = 0;
    i6 = paramM.a();
    i4 = i5;
    f1 = f3;
    while (i4 < i5 + i6)
    {
      View localView = next(i4);
      if (localView != null)
      {
        Object localObject = d;
        long l1 = x[i4];
        i7 = ((ByteVector)localObject).b(l1);
        i8 = d.a(l1);
        localObject = (LayoutParams)localView.getLayoutParams();
        if (shouldMeasureChild(localView, i7, i8, (RecyclerView.LayoutParams)localObject)) {
          localView.measure(i7, i8);
        }
        f2 += topMargin + f(localView);
        f1 -= rightMargin + a(localView);
        if (c.i(paramC) == 1)
        {
          calculateItemDecorationsForChild(localView, z);
          addView(localView);
        }
        else
        {
          calculateItemDecorationsForChild(localView, z);
          addView(localView, i1);
          i1 += 1;
        }
        i7 = i2 + c(localView);
        i8 = i3 - next(localView);
        boolean bool = i;
        if (bool)
        {
          if (f) {
            d.a(localView, paramM, bool, i8 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), i8, Math.round(f1));
          } else {
            d.a(localView, paramM, bool, i8 - localView.getMeasuredWidth(), Math.round(f2), i8, Math.round(f2) + localView.getMeasuredHeight());
          }
        }
        else if (f) {
          d.a(localView, paramM, bool, i7, Math.round(f1) - localView.getMeasuredHeight(), i7 + localView.getMeasuredWidth(), Math.round(f1));
        } else {
          d.a(localView, paramM, bool, i7, Math.round(f2), i7 + localView.getMeasuredWidth(), Math.round(f2) + localView.getMeasuredHeight());
        }
        float f5 = localView.getMeasuredHeight() + topMargin + a(localView);
        f3 = localView.getMeasuredHeight() + bottomMargin + f(localView);
        f2 += f5 + f4;
        f1 -= f3 + f4;
      }
      i4 += 1;
    }
    c.get(paramC, c.c(paramC) + c.i(a));
    return paramM.c();
  }
  
  private View b(int paramInt)
  {
    View localView = findReferenceChild(0, getChildCount(), paramInt);
    if (localView == null) {
      return null;
    }
    paramInt = getPosition(localView);
    paramInt = d.c[paramInt];
    if (paramInt == -1) {
      return null;
    }
    return a(localView, (m)x.get(paramInt));
  }
  
  private View b(View paramView, m paramM)
  {
    boolean bool = getValue();
    int i1 = getChildCount() - 2;
    int i2 = getChildCount();
    int i3 = c;
    while (i1 > i2 - i3 - 1)
    {
      View localView = getChildAt(i1);
      paramM = paramView;
      if (localView != null) {
        if (localView.getVisibility() == 8)
        {
          paramM = paramView;
        }
        else
        {
          if ((i) && (!bool))
          {
            paramM = paramView;
            if (c.getDecoratedStart(paramView) <= c.getDecoratedStart(localView)) {
              break label127;
            }
          }
          else
          {
            paramM = paramView;
            if (c.getDecoratedEnd(paramView) >= c.getDecoratedEnd(localView)) {
              break label127;
            }
          }
          paramM = localView;
        }
      }
      label127:
      i1 -= 1;
      paramView = paramM;
    }
    return paramView;
  }
  
  private void b(RecyclerView.u paramU, c paramC)
  {
    if (c.toString(paramC) < 0) {
      return;
    }
    c.getEnd();
    c.toString(paramC);
    int i1 = getChildCount();
    int i2 = i1;
    if (i1 == 0) {
      return;
    }
    int i5 = i1 - 1;
    Object localObject1 = getChildAt(i5);
    int i3 = d.c[getPosition(localObject1)];
    if (i3 == -1) {
      return;
    }
    localObject1 = (m)x.get(i3);
    i1 = i5;
    int i4;
    for (;;)
    {
      i4 = i2;
      if (i1 < 0) {
        break;
      }
      View localView = getChildAt(i1);
      i4 = i2;
      if (!a(localView, c.toString(paramC))) {
        break;
      }
      i4 = i3;
      Object localObject2 = localObject1;
      if (f == getPosition(localView))
      {
        if (i3 <= 0)
        {
          i4 = i1;
          break;
        }
        i4 = i3 + c.i(paramC);
        localObject2 = (m)x.get(i4);
        i2 = i1;
      }
      i1 -= 1;
      i3 = i4;
      localObject1 = localObject2;
    }
    a(paramU, i4, i5);
  }
  
  private void b(b paramB, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      visitEnd();
    } else {
      c.b(a, false);
    }
    if ((!getValue()) && (i)) {
      c.finish(a, b.f(paramB) - getPaddingRight());
    } else {
      c.finish(a, c.getEndAfterPadding() - b.f(paramB));
    }
    c.a(a, b.a(paramB));
    c.f(a, 1);
    c.d(a, 1);
    c.b(a, b.f(paramB));
    c.c(a, Integer.MIN_VALUE);
    c.get(a, b.c(paramB));
    if ((paramBoolean1) && (x.size() > 1) && (b.c(paramB) >= 0) && (b.c(paramB) < x.size() - 1))
    {
      paramB = (m)x.get(b.c(paramB));
      c.b(a);
      c localC = a;
      c.a(localC, c.e(localC) + paramB.a());
    }
  }
  
  private boolean b(RecyclerView.y paramY, b paramB)
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i2 == 0) {
      return false;
    }
    View localView;
    if (b.b(paramB)) {
      localView = toString(paramY.getItemCount());
    } else {
      localView = b(paramY.getItemCount());
    }
    if (localView != null)
    {
      b.b(paramB, localView);
      if ((!paramY.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        if ((c.getDecoratedStart(localView) >= c.getEndAfterPadding()) || (c.getDecoratedEnd(localView) < c.getStartAfterPadding())) {
          i1 = 1;
        }
        if (i1 != 0)
        {
          if (b.b(paramB)) {
            i1 = c.getEndAfterPadding();
          } else {
            i1 = c.getStartAfterPadding();
          }
          b.d(paramB, i1);
          return true;
        }
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  private boolean b(RecyclerView.y paramY, b paramB, SavedState paramSavedState)
  {
    boolean bool2 = paramY.isPreLayout();
    boolean bool1 = false;
    if (!bool2)
    {
      int i1 = h;
      if (i1 == -1) {
        return false;
      }
      if ((i1 >= 0) && (i1 < paramY.getItemCount()))
      {
        b.b(paramB, h);
        b.a(paramB, d.c[b.a(paramB)]);
        SavedState localSavedState = s;
        if ((localSavedState != null) && (SavedState.b(localSavedState, paramY.getItemCount())))
        {
          b.d(paramB, c.getStartAfterPadding() + SavedState.c(paramSavedState));
          b.f(paramB, true);
          b.a(paramB, -1);
          return true;
        }
        if (k == Integer.MIN_VALUE)
        {
          paramY = findViewByPosition(h);
          if (paramY != null)
          {
            if (c.getDecoratedMeasurement(paramY) > c.getTotalSpace())
            {
              b.g(paramB);
              return true;
            }
            if (c.getDecoratedStart(paramY) - c.getStartAfterPadding() < 0)
            {
              b.d(paramB, c.getStartAfterPadding());
              b.b(paramB, false);
              return true;
            }
            if (c.getEndAfterPadding() - c.getDecoratedEnd(paramY) < 0)
            {
              b.d(paramB, c.getEndAfterPadding());
              b.b(paramB, true);
              return true;
            }
            if (b.b(paramB)) {
              i1 = c.getDecoratedEnd(paramY) + c.getTotalSpaceChange();
            } else {
              i1 = c.getDecoratedStart(paramY);
            }
            b.d(paramB, i1);
            return true;
          }
          if (getChildCount() > 0)
          {
            i1 = getPosition(getChildAt(0));
            if (h < i1) {
              bool1 = true;
            }
            b.b(paramB, bool1);
          }
          b.g(paramB);
          return true;
        }
        if ((!getValue()) && (i))
        {
          b.d(paramB, k - c.getEndPadding());
          return true;
        }
        b.d(paramB, c.getStartAfterPadding() + k);
        return true;
      }
      h = -1;
      k = Integer.MIN_VALUE;
    }
    return false;
  }
  
  private void c(RecyclerView.y paramY, b paramB)
  {
    if (b(paramY, paramB, s)) {
      return;
    }
    if (b(paramY, paramB)) {
      return;
    }
    b.g(paramB);
    b.b(paramB, 0);
    b.a(paramB, 0);
  }
  
  private int calculateDxToMakeVisible(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return getDecoratedLeft(paramView) - leftMargin;
  }
  
  private int calculateDyToMakeVisible(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return getDecoratedBottom(paramView) + bottomMargin;
  }
  
  private void clear()
  {
    if (c != null) {
      return;
    }
    if (getValue())
    {
      if (l == 0)
      {
        c = OrientationHelper.read(this);
        n = OrientationHelper.valueOf(this);
        return;
      }
      c = OrientationHelper.valueOf(this);
      n = OrientationHelper.read(this);
      return;
    }
    if (l == 0)
    {
      c = OrientationHelper.valueOf(this);
      n = OrientationHelper.read(this);
      return;
    }
    c = OrientationHelper.read(this);
    n = OrientationHelper.valueOf(this);
  }
  
  private int computeScrollExtent(RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int i1 = paramY.getItemCount();
    clear();
    View localView1 = b(i1);
    View localView2 = toString(i1);
    if ((paramY.getItemCount() != 0) && (localView1 != null))
    {
      if (localView2 == null) {
        return 0;
      }
      i1 = c.getDecoratedEnd(localView2);
      int i2 = c.getDecoratedStart(localView1);
      return Math.min(c.getTotalSpace(), i1 - i2);
    }
    return 0;
  }
  
  private int computeScrollOffset(RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int i1 = paramY.getItemCount();
    View localView1 = b(i1);
    View localView2 = toString(i1);
    if ((paramY.getItemCount() != 0) && (localView1 != null))
    {
      if (localView2 == null) {
        return 0;
      }
      int i3 = getPosition(localView1);
      int i2 = getPosition(localView2);
      i1 = Math.abs(c.getDecoratedEnd(localView2) - c.getDecoratedStart(localView1));
      paramY = d.c;
      i3 = paramY[i3];
      if (i3 != 0)
      {
        if (i3 == -1) {
          return 0;
        }
        i2 = paramY[i2];
        float f1 = i1 / (i2 - i3 + 1);
        return Math.round(i3 * f1 + (c.getStartAfterPadding() - c.getDecoratedStart(localView1)));
      }
    }
    return 0;
  }
  
  private int computeScrollRange(RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int i1 = paramY.getItemCount();
    View localView1 = b(i1);
    View localView2 = toString(i1);
    if ((paramY.getItemCount() != 0) && (localView1 != null))
    {
      if (localView2 == null) {
        return 0;
      }
      i1 = findLastVisibleItemPosition();
      int i2 = getPosition();
      return (int)(Math.abs(c.getDecoratedEnd(localView2) - c.getDecoratedStart(localView1)) / (i2 - i1 + 1) * paramY.getItemCount());
    }
    return 0;
  }
  
  private int d(m paramM, c paramC)
  {
    if (getValue()) {
      return a(paramM, paramC);
    }
    return b(paramM, paramC);
  }
  
  private void d()
  {
    int i1 = getLayoutDirection();
    int i2 = m;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            i = false;
            f = false;
            return;
          }
          if (i1 == 1) {
            bool1 = true;
          }
          i = bool1;
          if (l == 2) {
            i = (bool1 ^ true);
          }
          f = true;
          return;
        }
        if (i1 == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        i = bool1;
        if (l == 2) {
          i = (bool1 ^ true);
        }
        f = false;
        return;
      }
      if (i1 != 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      i = bool1;
      bool1 = bool2;
      if (l == 2) {
        bool1 = true;
      }
      f = bool1;
      return;
    }
    if (i1 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    i = bool1;
    bool1 = bool3;
    if (l == 2) {
      bool1 = true;
    }
    f = bool1;
  }
  
  private void execute()
  {
    x.clear();
    b.setLine(y);
    b.scrollBy(y, 0);
  }
  
  private void f(RecyclerView.u paramU, c paramC)
  {
    if (!c.f(paramC)) {
      return;
    }
    if (c.i(paramC) == -1)
    {
      b(paramU, paramC);
      return;
    }
    a(paramU, paramC);
  }
  
  private View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1;
    if (paramInt2 > paramInt1) {
      i1 = 1;
    } else {
      i1 = -1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (hitTest(localView, paramBoolean)) {
        return localView;
      }
      paramInt1 += i1;
    }
    return null;
  }
  
  private View findReferenceChild(int paramInt1, int paramInt2, int paramInt3)
  {
    clear();
    postChangeCurrentByOneFromLongPress();
    int i2 = c.getStartAfterPadding();
    int i3 = c.getEndAfterPadding();
    int i1;
    if (paramInt2 > paramInt1) {
      i1 = 1;
    } else {
      i1 = -1;
    }
    Object localObject2 = null;
    Object localObject4;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject4)
    {
      View localView = getChildAt(paramInt1);
      int i4 = getPosition(localView);
      Object localObject3 = localObject2;
      localObject4 = localObject1;
      if (i4 >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (i4 < paramInt3) {
          if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localView;
              localObject3 = localObject2;
            }
          }
          else
          {
            if ((c.getDecoratedStart(localView) >= i2) && (c.getDecoratedEnd(localView) <= i3)) {
              return localView;
            }
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject2 == null)
            {
              localObject3 = localView;
              localObject4 = localObject1;
            }
          }
        }
      }
      paramInt1 += i1;
      localObject2 = localObject3;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    return localObject1;
  }
  
  private View getChildAt()
  {
    return getChildAt(0);
  }
  
  private int getDecoratedEnd(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return getDecoratedRight(paramView) + rightMargin;
  }
  
  private int getDecoratedStart(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return getDecoratedTop(paramView) - topMargin;
  }
  
  private boolean hitTest(View paramView, boolean paramBoolean)
  {
    int i2 = getPaddingLeft();
    int i4 = getPaddingTop();
    int i3 = getWidth() - getPaddingRight();
    int i5 = getHeight() - getPaddingBottom();
    int i8 = calculateDxToMakeVisible(paramView);
    int i6 = getDecoratedStart(paramView);
    int i9 = getDecoratedEnd(paramView);
    int i7 = calculateDyToMakeVisible(paramView);
    int i1;
    if ((i2 <= i8) && (i3 >= i9)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i8 < i3) && (i9 < i2)) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    if ((i4 <= i6) && (i5 >= i7)) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if ((i6 < i5) && (i7 < i4)) {
      i4 = 0;
    } else {
      i4 = 1;
    }
    if (paramBoolean) {
      return (i1 != 0) && (i3 != 0);
    }
    return (i2 != 0) && (i4 != 0);
  }
  
  private boolean isEmpty(View paramView, int paramInt)
  {
    if ((!getValue()) && (i)) {
      return c.getEnd() - c.getDecoratedStart(paramView) <= paramInt;
    }
    return c.getDecoratedEnd(paramView) <= paramInt;
  }
  
  private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
      return false;
    }
    if (i1 != Integer.MIN_VALUE)
    {
      if (i1 != 0)
      {
        if (i1 != 1073741824) {
          return false;
        }
        if (paramInt2 != paramInt1) {}
      }
      else
      {
        return true;
      }
    }
    else if (paramInt2 >= paramInt1) {
      return true;
    }
    return false;
  }
  
  private void postChangeCurrentByOneFromLongPress()
  {
    if (a == null) {
      a = new c(null);
    }
  }
  
  private int scrollBy(int paramInt)
  {
    int i1 = getChildCount();
    int i3 = 0;
    if (i1 != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      clear();
      boolean bool = getValue();
      View localView = right;
      if (bool) {
        i1 = localView.getWidth();
      } else {
        i1 = localView.getHeight();
      }
      int i2;
      if (bool) {
        i2 = getWidth();
      } else {
        i2 = getHeight();
      }
      if (getLayoutDirection() == 1) {
        i3 = 1;
      }
      if (i3 != 0)
      {
        i3 = Math.abs(paramInt);
        if (paramInt < 0) {
          paramInt = Math.min(i2 + b.scrollBy(y) - i1, i3);
        } else {
          if (b.scrollBy(y) + paramInt <= 0) {
            break label186;
          }
        }
      }
      for (paramInt = b.scrollBy(y);; paramInt = b.scrollBy(y))
      {
        return -paramInt;
        if (paramInt > 0) {
          return Math.min(i2 - b.scrollBy(y) - i1, paramInt);
        }
        if (b.scrollBy(y) + paramInt >= 0) {
          return paramInt;
        }
      }
      label186:
      return paramInt;
    }
    return 0;
  }
  
  private boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    return (paramView.isLayoutRequested()) || (!findValidDrawClaim()) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, height));
  }
  
  private View toString(int paramInt)
  {
    View localView = findReferenceChild(getChildCount() - 1, -1, paramInt);
    if (localView == null) {
      return null;
    }
    paramInt = getPosition(localView);
    paramInt = d.c[paramInt];
    return b(localView, (m)x.get(paramInt));
  }
  
  private void visit(int paramInt)
  {
    if (paramInt >= getPosition()) {
      return;
    }
    int i1 = getChildCount();
    d.add(i1);
    d.write(i1);
    d.get(i1);
    if (paramInt >= d.c.length) {
      return;
    }
    p = paramInt;
    View localView = getChildAt();
    if (localView == null) {
      return;
    }
    h = getPosition(localView);
    if ((!getValue()) && (i))
    {
      k = (c.getDecoratedEnd(localView) + c.getEndPadding());
      return;
    }
    k = (c.getDecoratedStart(localView) - c.getStartAfterPadding());
  }
  
  private void visitEnd()
  {
    int i1;
    if (getValue()) {
      i1 = getHeightMode();
    } else {
      i1 = getWidthMode();
    }
    c localC = a;
    boolean bool;
    if ((i1 != 0) && (i1 != Integer.MIN_VALUE)) {
      bool = false;
    } else {
      bool = true;
    }
    c.b(localC, bool);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), paramInt2, paramInt3, canScrollVertically());
  }
  
  public void a(int paramInt, View paramView)
  {
    o.put(paramInt, paramView);
  }
  
  public int b()
  {
    int i2 = x.size();
    int i1 = 0;
    if (i2 == 0) {
      return 0;
    }
    i2 = Integer.MIN_VALUE;
    int i3 = x.size();
    while (i1 < i3)
    {
      i2 = Math.max(i2, x.get(i1)).b);
      i1 += 1;
    }
    return i2;
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), paramInt2, paramInt3, canScrollHorizontally());
  }
  
  public int b(View paramView)
  {
    int i1;
    if (getValue()) {
      i1 = f(paramView);
    }
    for (int i2 = a(paramView);; i2 = next(paramView))
    {
      return i1 + i2;
      i1 = c(paramView);
    }
  }
  
  public int b(View paramView, int paramInt1, int paramInt2)
  {
    if (getValue()) {
      paramInt1 = c(paramView);
    }
    for (paramInt2 = next(paramView);; paramInt2 = a(paramView))
    {
      return paramInt1 + paramInt2;
      paramInt1 = f(paramView);
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, m paramM)
  {
    calculateItemDecorationsForChild(paramView, z);
    if (getValue())
    {
      paramInt1 = c(paramView) + next(paramView);
      b += paramInt1;
      l += paramInt1;
      return;
    }
    paramInt1 = f(paramView) + a(paramView);
    b += paramInt1;
    l += paramInt1;
  }
  
  public void b(RecyclerView paramRecyclerView)
  {
    super.b(paramRecyclerView);
    right = ((View)paramRecyclerView.getParent());
  }
  
  public void b(m paramM) {}
  
  public int c()
  {
    return w.getItemCount();
  }
  
  public View c(int paramInt)
  {
    return next(paramInt);
  }
  
  public boolean canScrollHorizontally()
  {
    return (!getValue()) || (getWidth() > right.getWidth());
  }
  
  public boolean canScrollVertically()
  {
    return (getValue()) || (getHeight() > right.getHeight());
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.y paramY)
  {
    return computeScrollExtent(paramY);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.y paramY)
  {
    return computeScrollOffset(paramY);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.y paramY)
  {
    return computeScrollRange(paramY);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.y paramY)
  {
    return computeScrollExtent(paramY);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.y paramY)
  {
    return computeScrollOffset(paramY);
  }
  
  public int computeVerticalScrollRange(RecyclerView.y paramY)
  {
    return computeScrollRange(paramY);
  }
  
  public int f()
  {
    return m;
  }
  
  public int findLastVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public int getPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public boolean getValue()
  {
    int i1 = m;
    if (i1 != 0) {
      return i1 == 1;
    }
    return true;
  }
  
  public List i()
  {
    return x;
  }
  
  public void initialize(int paramInt)
  {
    if (m != paramInt)
    {
      removeAllViews();
      m = paramInt;
      c = null;
      n = null;
      execute();
      requestLayout();
    }
  }
  
  public int l()
  {
    return q;
  }
  
  public int m()
  {
    return r;
  }
  
  public int n()
  {
    return l;
  }
  
  public View next(int paramInt)
  {
    View localView = (View)o.get(paramInt);
    if (localView != null) {
      return localView;
    }
    return e.getViewForPosition(paramInt);
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onItemsAdded(paramRecyclerView, paramInt1, paramInt2);
    visit(paramInt1);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onItemsMoved(paramRecyclerView, paramInt1, paramInt2, paramInt3);
    visit(Math.min(paramInt1, paramInt2));
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    visit(paramInt1);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2, paramObject);
    visit(paramInt1);
  }
  
  public void onLayoutChildren(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    removeAllViews();
  }
  
  public void onLayoutChildren(RecyclerView.u paramU, RecyclerView.y paramY)
  {
    e = paramU;
    w = paramY;
    int i1 = paramY.getItemCount();
    if ((i1 == 0) && (paramY.isPreLayout())) {
      return;
    }
    d();
    clear();
    postChangeCurrentByOneFromLongPress();
    d.add(i1);
    d.write(i1);
    d.get(i1);
    c.f(a, false);
    SavedState localSavedState = s;
    if ((localSavedState != null) && (SavedState.b(localSavedState, i1))) {
      h = SavedState.b(s);
    }
    if ((!b.access$getF(y)) || (h != -1) || (s != null))
    {
      b.setLine(y);
      c(paramY, y);
      b.a(y, true);
    }
    detachAndScrapAttachedViews(paramU);
    if (b.b(y)) {
      a(y, false, true);
    } else {
      b(y, false, true);
    }
    a(i1);
    int i2;
    if (b.b(y))
    {
      a(paramU, paramY, a);
      i1 = c.newUTF8(a);
      b(y, true, false);
      a(paramU, paramY, a);
      i2 = c.newUTF8(a);
    }
    else
    {
      a(paramU, paramY, a);
      i2 = c.newUTF8(a);
      a(y, true, false);
      a(paramU, paramY, a);
      i1 = c.newUTF8(a);
    }
    if (getChildCount() > 0)
    {
      if (b.b(y))
      {
        a(i1 + b(i2, paramU, paramY, true), paramU, paramY, false);
        return;
      }
      b(i2 + a(i1, paramU, paramY, true), paramU, paramY, false);
    }
  }
  
  public void onLayoutChildren(RecyclerView.y paramY)
  {
    super.onLayoutChildren(paramY);
    s = null;
    h = -1;
    k = Integer.MIN_VALUE;
    p = -1;
    b.setLine(y);
    o.clear();
  }
  
  public void onLayoutChildren(RecyclerView paramRecyclerView, RecyclerView.u paramU)
  {
    super.onLayoutChildren(paramRecyclerView, paramU);
    if (mAvailable)
    {
      removeAndRecycleAllViews(paramU);
      paramU.clear();
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      s = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public PointF onSaveInstanceState(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      paramInt = -1;
    } else {
      paramInt = 1;
    }
    if (getValue()) {
      return new PointF(0.0F, paramInt);
    }
    return new PointF(paramInt, 0.0F);
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (s != null) {
      return new SavedState(s, null);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      View localView = getChildAt();
      SavedState.a(localSavedState, getPosition(localView));
      SavedState.d(localSavedState, c.getDecoratedStart(localView) - c.getStartAfterPadding());
      return localSavedState;
    }
    SavedState.a(localSavedState);
    return localSavedState;
  }
  
  public void reset(int paramInt)
  {
    if (paramInt != 2)
    {
      int i1 = l;
      if (i1 != paramInt)
      {
        if ((i1 == 0) || (paramInt == 0))
        {
          removeAllViews();
          execute();
        }
        l = paramInt;
        c = null;
        n = null;
        requestLayout();
      }
    }
    else
    {
      throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (!getValue())
    {
      paramInt = b(paramInt, paramU, paramY);
      o.clear();
      return paramInt;
    }
    paramInt = scrollBy(paramInt);
    paramU = y;
    b.scrollBy(paramU, b.scrollBy(paramU) + paramInt);
    n.offsetChildren(-paramInt);
    return paramInt;
  }
  
  public void scrollToPosition(int paramInt)
  {
    h = paramInt;
    k = Integer.MIN_VALUE;
    SavedState localSavedState = s;
    if (localSavedState != null) {
      SavedState.a(localSavedState);
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (getValue())
    {
      paramInt = b(paramInt, paramU, paramY);
      o.clear();
      return paramInt;
    }
    paramInt = scrollBy(paramInt);
    paramU = y;
    b.scrollBy(paramU, b.scrollBy(paramU) + paramInt);
    n.offsetChildren(-paramInt);
    return paramInt;
  }
  
  public void set(int paramInt)
  {
    int i1 = r;
    if (i1 != paramInt)
    {
      if ((i1 == 4) || (paramInt == 4))
      {
        removeAllViews();
        execute();
      }
      r = paramInt;
      requestLayout();
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.y paramY, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext());
    paramRecyclerView.d(paramInt);
    a(paramRecyclerView);
  }
  
  public void xor(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.xor(paramRecyclerView, paramInt1, paramInt2);
    visit(paramInt1);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
    private float bearing = 0.0F;
    private int circleRadius = 16777215;
    private boolean linearProgress;
    private int mLac;
    private int mPosition = -1;
    private int mSignal;
    private float mSpeed = -1.0F;
    private int rimColor = 16777215;
    private float speed = 1.0F;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(-2);
      bearing = paramParcel.readFloat();
      speed = paramParcel.readFloat();
      mPosition = paramParcel.readInt();
      mSpeed = paramParcel.readFloat();
      mLac = paramParcel.readInt();
      mSignal = paramParcel.readInt();
      rimColor = paramParcel.readInt();
      circleRadius = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      linearProgress = bool;
      bottomMargin = paramParcel.readInt();
      leftMargin = paramParcel.readInt();
      rightMargin = paramParcel.readInt();
      topMargin = paramParcel.readInt();
      height = paramParcel.readInt();
      width = paramParcel.readInt();
    }
    
    public int b()
    {
      return rightMargin;
    }
    
    public int c()
    {
      return bottomMargin;
    }
    
    public int d()
    {
      return leftMargin;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public float e()
    {
      return bearing;
    }
    
    public int f()
    {
      return topMargin;
    }
    
    public int getAttributeCount()
    {
      return mLac;
    }
    
    public int getHeight()
    {
      return height;
    }
    
    public float getRectF()
    {
      return speed;
    }
    
    public int getWidth()
    {
      return width;
    }
    
    public float h()
    {
      return mSpeed;
    }
    
    public int height()
    {
      return mSignal;
    }
    
    public int n()
    {
      return mPosition;
    }
    
    public int readUnsignedShort()
    {
      return rimColor;
    }
    
    public boolean visitFrame()
    {
      return linearProgress;
    }
    
    public int width()
    {
      return circleRadius;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeFloat(bearing);
      paramParcel.writeFloat(speed);
      paramParcel.writeInt(mPosition);
      paramParcel.writeFloat(mSpeed);
      paramParcel.writeInt(mLac);
      paramParcel.writeInt(mSignal);
      paramParcel.writeInt(rimColor);
      paramParcel.writeInt(circleRadius);
      paramParcel.writeByte((byte)linearProgress);
      paramParcel.writeInt(bottomMargin);
      paramParcel.writeInt(leftMargin);
      paramParcel.writeInt(rightMargin);
      paramParcel.writeInt(topMargin);
      paramParcel.writeInt(height);
      paramParcel.writeInt(width);
    }
    
    static final class a
      implements Parcelable.Creator<FlexboxLayoutManager.LayoutParams>
    {
      a() {}
      
      public FlexboxLayoutManager.LayoutParams[] a(int paramInt)
      {
        return new FlexboxLayoutManager.LayoutParams[paramInt];
      }
      
      public FlexboxLayoutManager.LayoutParams readDate(Parcel paramParcel)
      {
        return new FlexboxLayoutManager.LayoutParams(paramParcel);
      }
    }
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    private int b;
    private int c;
    
    SavedState() {}
    
    private SavedState(Parcel paramParcel)
    {
      c = paramParcel.readInt();
      b = paramParcel.readInt();
    }
    
    private SavedState(SavedState paramSavedState)
    {
      c = c;
      b = b;
    }
    
    private void b()
    {
      c = -1;
    }
    
    private boolean b(int paramInt)
    {
      int i = c;
      return (i >= 0) && (i < paramInt);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SavedState{mAnchorPosition=");
      localStringBuilder.append(c);
      localStringBuilder.append(", mAnchorOffset=");
      localStringBuilder.append(b);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(c);
      paramParcel.writeInt(b);
    }
    
    static final class a
      implements Parcelable.Creator<FlexboxLayoutManager.SavedState>
    {
      a() {}
      
      public FlexboxLayoutManager.SavedState[] a(int paramInt)
      {
        return new FlexboxLayoutManager.SavedState[paramInt];
      }
      
      public FlexboxLayoutManager.SavedState readDate(Parcel paramParcel)
      {
        return new FlexboxLayoutManager.SavedState(paramParcel, null);
      }
    }
  }
  
  private class b
  {
    private boolean d;
    private boolean f;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int x = 0;
    
    private b() {}
    
    private void b()
    {
      int m;
      if ((!getValue()) && (FlexboxLayoutManager.f(FlexboxLayoutManager.this)))
      {
        if (d) {
          m = FlexboxLayoutManager.c(FlexboxLayoutManager.this).getEndAfterPadding();
        } else {
          m = getWidth() - FlexboxLayoutManager.c(FlexboxLayoutManager.this).getStartAfterPadding();
        }
        i = m;
        return;
      }
      if (d) {
        m = FlexboxLayoutManager.c(FlexboxLayoutManager.this).getEndAfterPadding();
      } else {
        m = FlexboxLayoutManager.c(FlexboxLayoutManager.this).getStartAfterPadding();
      }
      i = m;
    }
    
    private void b(View paramView)
    {
      if ((!getValue()) && (FlexboxLayoutManager.f(FlexboxLayoutManager.this)))
      {
        if (d) {
          i = (FlexboxLayoutManager.c(FlexboxLayoutManager.this).getDecoratedStart(paramView) + FlexboxLayoutManager.c(FlexboxLayoutManager.this).getTotalSpaceChange());
        } else {
          i = FlexboxLayoutManager.c(FlexboxLayoutManager.this).getDecoratedEnd(paramView);
        }
      }
      else if (d) {
        i = (FlexboxLayoutManager.c(FlexboxLayoutManager.this).getDecoratedEnd(paramView) + FlexboxLayoutManager.c(FlexboxLayoutManager.this).getTotalSpaceChange());
      } else {
        i = FlexboxLayoutManager.c(FlexboxLayoutManager.this).getDecoratedStart(paramView);
      }
      j = getPosition(paramView);
      int n = 0;
      h = false;
      paramView = bc;
      int m = j;
      if (m == -1) {
        m = 0;
      }
      int i1 = paramView[m];
      m = n;
      if (i1 != -1) {
        m = i1;
      }
      k = m;
      if (FlexboxLayoutManager.access$getAllItems(FlexboxLayoutManager.this).size() > k) {
        j = access$getAllItemsgetk)).f;
      }
    }
    
    private void d()
    {
      j = -1;
      k = -1;
      i = Integer.MIN_VALUE;
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool1 = false;
      f = false;
      h = false;
      if (getValue())
      {
        if (FlexboxLayoutManager.d(FlexboxLayoutManager.this) == 0)
        {
          if (FlexboxLayoutManager.access$getM(FlexboxLayoutManager.this) == 1) {
            bool1 = true;
          }
          d = bool1;
          return;
        }
        bool1 = bool2;
        if (FlexboxLayoutManager.d(FlexboxLayoutManager.this) == 2) {
          bool1 = true;
        }
        d = bool1;
        return;
      }
      if (FlexboxLayoutManager.d(FlexboxLayoutManager.this) == 0)
      {
        bool1 = bool3;
        if (FlexboxLayoutManager.access$getM(FlexboxLayoutManager.this) == 3) {
          bool1 = true;
        }
        d = bool1;
        return;
      }
      bool1 = bool4;
      if (FlexboxLayoutManager.d(FlexboxLayoutManager.this) == 2) {
        bool1 = true;
      }
      d = bool1;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AnchorInfo{mPosition=");
      localStringBuilder.append(j);
      localStringBuilder.append(", mFlexLinePosition=");
      localStringBuilder.append(k);
      localStringBuilder.append(", mCoordinate=");
      localStringBuilder.append(i);
      localStringBuilder.append(", mPerpendicularCoordinate=");
      localStringBuilder.append(x);
      localStringBuilder.append(", mLayoutFromEnd=");
      localStringBuilder.append(d);
      localStringBuilder.append(", mValid=");
      localStringBuilder.append(f);
      localStringBuilder.append(", mAssignedFromSavedState=");
      localStringBuilder.append(h);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  private static class c
  {
    private int a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f = 1;
    private int g;
    private boolean h;
    private int i;
    private int j = 1;
    
    private c() {}
    
    private boolean a(RecyclerView.y paramY, List paramList)
    {
      int k = d;
      if ((k >= 0) && (k < paramY.getItemCount()))
      {
        k = i;
        if ((k >= 0) && (k < paramList.size())) {
          return true;
        }
      }
      return false;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LayoutState{mAvailable=");
      localStringBuilder.append(e);
      localStringBuilder.append(", mFlexLinePosition=");
      localStringBuilder.append(i);
      localStringBuilder.append(", mPosition=");
      localStringBuilder.append(d);
      localStringBuilder.append(", mOffset=");
      localStringBuilder.append(a);
      localStringBuilder.append(", mScrollingOffset=");
      localStringBuilder.append(c);
      localStringBuilder.append(", mLastScrollDelta=");
      localStringBuilder.append(g);
      localStringBuilder.append(", mItemDirection=");
      localStringBuilder.append(f);
      localStringBuilder.append(", mLayoutDirection=");
      localStringBuilder.append(j);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
