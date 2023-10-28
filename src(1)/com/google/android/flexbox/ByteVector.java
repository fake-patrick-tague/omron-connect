package com.google.android.flexbox;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import v7.v7.package_13.Log;

class ByteVector
{
  private long[] a;
  private final i b;
  int[] c;
  private boolean[] d;
  long[] x;
  
  ByteVector(i paramI)
  {
    b = paramI;
  }
  
  private int a(int paramInt1, FlexItem paramFlexItem, int paramInt2)
  {
    i localI = b;
    paramInt2 = localI.b(paramInt1, localI.getPaddingLeft() + b.getPaddingRight() + paramFlexItem.d() + paramFlexItem.b() + paramInt2, paramFlexItem.getWidth());
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i > paramFlexItem.readUnsignedShort()) {
      return View.MeasureSpec.makeMeasureSpec(paramFlexItem.readUnsignedShort(), View.MeasureSpec.getMode(paramInt2));
    }
    paramInt1 = paramInt2;
    if (i < paramFlexItem.getAttributeCount()) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getAttributeCount(), View.MeasureSpec.getMode(paramInt2));
    }
    return paramInt1;
  }
  
  private int a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramView.getMeasuredWidth();
    }
    return paramView.getMeasuredHeight();
  }
  
  private int a(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.b();
    }
    return paramFlexItem.c();
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b.getPaddingTop();
    }
    return b.add();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    long[] arrayOfLong = x;
    if (arrayOfLong != null) {
      arrayOfLong[paramInt1] = write(paramInt2, paramInt3);
    }
    arrayOfLong = a;
    if (arrayOfLong != null) {
      arrayOfLong[paramInt1] = write(paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    }
  }
  
  private void a(int paramInt1, int paramInt2, m paramM, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i4 = b;
    float f1 = g;
    if (f1 > 0.0F)
    {
      if (paramInt3 > i4) {
        return;
      }
      float f5 = (i4 - paramInt3) / f1;
      b = (paramInt4 + l);
      if (!paramBoolean) {
        k = Integer.MIN_VALUE;
      }
      int j = 0;
      int i = 0;
      int i1 = 0;
      f1 = 0.0F;
      while (j < c)
      {
        int i5 = f + j;
        View localView = b.c(i5);
        int k = i1;
        float f2 = f1;
        int m = j;
        int n = i;
        if (localView != null) {
          if (localView.getVisibility() == 8)
          {
            k = i1;
            f2 = f1;
            m = j;
            n = i;
          }
          else
          {
            FlexItem localFlexItem = (FlexItem)localView.getLayoutParams();
            k = b.f();
            long[] arrayOfLong;
            int i2;
            float f4;
            float f3;
            double d1;
            if ((k != 0) && (k != 1))
            {
              k = localView.getMeasuredHeight();
              arrayOfLong = a;
              if (arrayOfLong != null) {
                k = a(arrayOfLong[i5]);
              }
              n = localView.getMeasuredWidth();
              arrayOfLong = a;
              if (arrayOfLong != null) {
                n = b(arrayOfLong[i5]);
              }
              f2 = f1;
              i2 = k;
              int i3 = n;
              m = i;
              if (d[i5] == 0)
              {
                f2 = f1;
                i2 = k;
                i3 = n;
                m = i;
                if (localFlexItem.getRectF() > 0.0F)
                {
                  f4 = k - localFlexItem.getRectF() * f5;
                  f2 = f1;
                  f3 = f4;
                  if (j == c - 1)
                  {
                    f3 = f4 + f1;
                    f2 = 0.0F;
                  }
                  n = Math.round(f3);
                  k = n;
                  if (n < localFlexItem.height())
                  {
                    k = localFlexItem.height();
                    d[i5] = true;
                    g -= localFlexItem.getRectF();
                    m = 1;
                    f1 = f2;
                  }
                  else
                  {
                    f2 += f3 - n;
                    d1 = f2;
                    if (d1 > 1.0D)
                    {
                      k = n + 1;
                      f1 = f2 - 1.0F;
                      m = i;
                    }
                    else
                    {
                      f1 = f2;
                      m = i;
                      if (d1 < -1.0D)
                      {
                        k = n - 1;
                        f1 = f2 + 1.0F;
                        m = i;
                      }
                    }
                  }
                  i = a(paramInt1, localFlexItem, e);
                  k = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                  localView.measure(i, k);
                  i3 = localView.getMeasuredWidth();
                  i2 = localView.getMeasuredHeight();
                  a(i5, i, k, localView);
                  b.a(i5, localView);
                  f2 = f1;
                }
              }
              k = Math.max(i1, i3 + localFlexItem.d() + localFlexItem.b() + b.b(localView));
              b += i2 + localFlexItem.f() + localFlexItem.c();
              f1 = f2;
              i = m;
            }
            else
            {
              k = localView.getMeasuredWidth();
              arrayOfLong = a;
              if (arrayOfLong != null) {
                k = b(arrayOfLong[i5]);
              }
              m = localView.getMeasuredHeight();
              arrayOfLong = a;
              if (arrayOfLong != null) {
                m = a(arrayOfLong[i5]);
              }
              if ((d[i5] == 0) && (localFlexItem.getRectF() > 0.0F))
              {
                f4 = k - localFlexItem.getRectF() * f5;
                f2 = f1;
                f3 = f4;
                if (j == c - 1)
                {
                  f3 = f4 + f1;
                  f2 = 0.0F;
                }
                n = Math.round(f3);
                k = n;
                if (n < localFlexItem.getAttributeCount())
                {
                  k = localFlexItem.getAttributeCount();
                  d[i5] = true;
                  g -= localFlexItem.getRectF();
                  m = 1;
                  f1 = f2;
                }
                else
                {
                  f2 += f3 - n;
                  d1 = f2;
                  if (d1 > 1.0D)
                  {
                    k = n + 1;
                    f1 = f2 - 1.0F;
                    m = i;
                  }
                  else
                  {
                    f1 = f2;
                    m = i;
                    if (d1 < -1.0D)
                    {
                      k = n - 1;
                      f1 = f2 + 1.0F;
                      m = i;
                    }
                  }
                }
                i = b(paramInt2, localFlexItem, e);
                i2 = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                localView.measure(i2, i);
                k = localView.getMeasuredWidth();
                n = localView.getMeasuredHeight();
                a(i5, i2, i, localView);
                b.a(i5, localView);
                i = m;
              }
              else
              {
                n = m;
              }
              m = Math.max(i1, n + localFlexItem.f() + localFlexItem.c() + b.b(localView));
              b += k + localFlexItem.d() + localFlexItem.b();
              k = m;
            }
            k = Math.max(k, k);
            f2 = f1;
            m = j;
            n = i;
          }
        }
        j = m + 1;
        i1 = k;
        f1 = f2;
        i = n;
      }
      if ((i != 0) && (i4 != b)) {
        a(paramInt1, paramInt2, paramM, paramInt3, paramInt4, true);
      }
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int k = i;
    int n = paramView.getMeasuredHeight();
    int j = n;
    int i1 = localFlexItem.getAttributeCount();
    int m = 1;
    if (i < i1) {}
    for (i = localFlexItem.getAttributeCount();; i = localFlexItem.readUnsignedShort())
    {
      i1 = 1;
      k = i;
      i = i1;
      break label89;
      if (i <= localFlexItem.readUnsignedShort()) {
        break;
      }
    }
    i = 0;
    label89:
    if (n < localFlexItem.height())
    {
      i = localFlexItem.height();
    }
    else if (n > localFlexItem.width())
    {
      i = localFlexItem.width();
    }
    else
    {
      m = i;
      i = j;
    }
    if (m != 0)
    {
      j = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(j, i);
      a(paramInt, j, i, paramView);
      b.a(paramInt, paramView);
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - ((FlexItem)localObject).d() - ((FlexItem)localObject).b() - b.b(paramView), ((FlexItem)localObject).getAttributeCount()), ((FlexItem)localObject).readUnsignedShort());
    localObject = a;
    if (localObject != null) {
      paramInt1 = a(localObject[paramInt2]);
    } else {
      paramInt1 = paramView.getMeasuredHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    paramView.measure(i, paramInt1);
    a(paramInt2, i, paramInt1, paramView);
    b.a(paramInt2, paramView);
  }
  
  private void a(List paramList, m paramM, int paramInt1, int paramInt2)
  {
    e = paramInt2;
    b.b(paramM);
    v = paramInt1;
    paramList.add(paramM);
  }
  
  private boolean a(int paramInt1, int paramInt2, m paramM)
  {
    return (paramInt1 == paramInt2 - 1) && (paramM.e() != 0);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, FlexItem paramFlexItem, int paramInt5, int paramInt6, int paramInt7)
  {
    if (b.n() == 0) {
      return false;
    }
    if (paramFlexItem.visitFrame()) {
      return true;
    }
    if (paramInt1 == 0) {
      return false;
    }
    paramInt1 = b.l();
    if ((paramInt1 != -1) && (paramInt1 <= paramInt7 + 1)) {
      return false;
    }
    paramInt5 = b.b(paramView, paramInt5, paramInt6);
    paramInt1 = paramInt4;
    if (paramInt5 > 0) {
      paramInt1 = paramInt4 + paramInt5;
    }
    return paramInt2 < paramInt3 + paramInt1;
  }
  
  private int add(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.getHeight();
    }
    return paramFlexItem.getWidth();
  }
  
  private int add(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b.add();
    }
    return b.getPaddingTop();
  }
  
  private int b(int paramInt1, FlexItem paramFlexItem, int paramInt2)
  {
    i localI = b;
    paramInt2 = localI.a(paramInt1, localI.getPaddingTop() + b.getPaddingBottom() + paramFlexItem.f() + paramFlexItem.c() + paramInt2, paramFlexItem.getHeight());
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i > paramFlexItem.width()) {
      return View.MeasureSpec.makeMeasureSpec(paramFlexItem.width(), View.MeasureSpec.getMode(paramInt2));
    }
    paramInt1 = paramInt2;
    if (i < paramFlexItem.height()) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.height(), View.MeasureSpec.getMode(paramInt2));
    }
    return paramInt1;
  }
  
  private int b(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramView.getMeasuredHeight();
    }
    return paramView.getMeasuredWidth();
  }
  
  private int b(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.c();
    }
    return paramFlexItem.b();
  }
  
  private int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b.a();
    }
    return b.getPaddingBottom();
  }
  
  private void b(int paramInt)
  {
    boolean[] arrayOfBoolean = d;
    int i;
    if (arrayOfBoolean == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      d = new boolean[i];
      return;
    }
    if (arrayOfBoolean.length < paramInt)
    {
      int j = arrayOfBoolean.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      d = new boolean[i];
      return;
    }
    Arrays.fill(arrayOfBoolean, false);
  }
  
  private void b(int paramInt1, int paramInt2, m paramM, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    float f1 = i;
    if (f1 > 0.0F)
    {
      int i4 = b;
      if (paramInt3 < i4) {
        return;
      }
      float f5 = (paramInt3 - i4) / f1;
      b = (paramInt4 + l);
      if (!paramBoolean) {
        k = Integer.MIN_VALUE;
      }
      int n = 0;
      int i = 0;
      int i1 = 0;
      f1 = 0.0F;
      while (n < c)
      {
        int i5 = f + n;
        View localView = b.c(i5);
        float f2 = f1;
        int j = i1;
        int k = i;
        if (localView != null) {
          if (localView.getVisibility() == 8)
          {
            f2 = f1;
            j = i1;
            k = i;
          }
          else
          {
            FlexItem localFlexItem = (FlexItem)localView.getLayoutParams();
            j = b.f();
            long[] arrayOfLong;
            int m;
            int i2;
            int i3;
            float f4;
            float f3;
            double d1;
            if ((j != 0) && (j != 1))
            {
              j = localView.getMeasuredHeight();
              arrayOfLong = a;
              if (arrayOfLong != null) {
                j = a(arrayOfLong[i5]);
              }
              m = localView.getMeasuredWidth();
              arrayOfLong = a;
              if (arrayOfLong != null) {
                m = b(arrayOfLong[i5]);
              }
              f2 = f1;
              i2 = j;
              i3 = m;
              k = i;
              if (d[i5] == 0)
              {
                f2 = f1;
                i2 = j;
                i3 = m;
                k = i;
                if (localFlexItem.e() > 0.0F)
                {
                  f4 = j + localFlexItem.e() * f5;
                  f2 = f1;
                  f3 = f4;
                  if (n == c - 1)
                  {
                    f3 = f4 + f1;
                    f2 = 0.0F;
                  }
                  m = Math.round(f3);
                  k = m;
                  if (m > localFlexItem.width())
                  {
                    k = localFlexItem.width();
                    d[i5] = true;
                    i -= localFlexItem.e();
                    j = 1;
                    f1 = f2;
                  }
                  else
                  {
                    f1 = f2 + (f3 - m);
                    d1 = f1;
                    if (d1 > 1.0D) {
                      k = m + 1;
                    }
                    for (d1 -= 1.0D;; d1 += 1.0D)
                    {
                      f1 = (float)d1;
                      j = i;
                      break;
                      j = i;
                      if (d1 >= -1.0D) {
                        break;
                      }
                      k = m - 1;
                    }
                  }
                  i = a(paramInt1, localFlexItem, e);
                  k = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                  localView.measure(i, k);
                  i3 = localView.getMeasuredWidth();
                  i2 = localView.getMeasuredHeight();
                  a(i5, i, k, localView);
                  b.a(i5, localView);
                  f2 = f1;
                  k = j;
                }
              }
              i = Math.max(i1, i3 + localFlexItem.d() + localFlexItem.b() + b.b(localView));
              b += i2 + localFlexItem.f() + localFlexItem.c();
            }
            else
            {
              j = localView.getMeasuredWidth();
              arrayOfLong = a;
              if (arrayOfLong != null) {
                j = b(arrayOfLong[i5]);
              }
              m = localView.getMeasuredHeight();
              arrayOfLong = a;
              if (arrayOfLong != null) {
                m = a(arrayOfLong[i5]);
              }
              f2 = f1;
              i2 = j;
              i3 = m;
              k = i;
              if (d[i5] == 0)
              {
                f2 = f1;
                i2 = j;
                i3 = m;
                k = i;
                if (localFlexItem.e() > 0.0F)
                {
                  f4 = j + localFlexItem.e() * f5;
                  f2 = f1;
                  f3 = f4;
                  if (n == c - 1)
                  {
                    f3 = f4 + f1;
                    f2 = 0.0F;
                  }
                  m = Math.round(f3);
                  k = m;
                  if (m > localFlexItem.readUnsignedShort())
                  {
                    k = localFlexItem.readUnsignedShort();
                    d[i5] = true;
                    i -= localFlexItem.e();
                    j = 1;
                    f1 = f2;
                  }
                  else
                  {
                    f1 = f2 + (f3 - m);
                    d1 = f1;
                    if (d1 > 1.0D) {
                      k = m + 1;
                    }
                    for (d1 -= 1.0D;; d1 += 1.0D)
                    {
                      f1 = (float)d1;
                      j = i;
                      break;
                      j = i;
                      if (d1 >= -1.0D) {
                        break;
                      }
                      k = m - 1;
                    }
                  }
                  i = b(paramInt2, localFlexItem, e);
                  k = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                  localView.measure(k, i);
                  i2 = localView.getMeasuredWidth();
                  i3 = localView.getMeasuredHeight();
                  a(i5, k, i, localView);
                  b.a(i5, localView);
                  f2 = f1;
                  k = j;
                }
              }
              i = Math.max(i1, i3 + localFlexItem.f() + localFlexItem.c() + b.b(localView));
              b += i2 + localFlexItem.d() + localFlexItem.b();
            }
            k = Math.max(k, i);
            j = i;
          }
        }
        n += 1;
        f1 = f2;
        i1 = j;
        i = k;
      }
      if ((i != 0) && (i4 != b)) {
        b(paramInt1, paramInt2, paramM, paramInt3, paramInt4, true);
      }
    }
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - ((FlexItem)localObject).f() - ((FlexItem)localObject).c() - b.b(paramView), ((FlexItem)localObject).height()), ((FlexItem)localObject).width());
    localObject = a;
    if (localObject != null) {
      paramInt1 = b(localObject[paramInt2]);
    } else {
      paramInt1 = paramView.getMeasuredWidth();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    paramView.measure(paramInt1, i);
    a(paramInt2, paramInt1, i, paramView);
    b.a(paramInt2, paramView);
  }
  
  private int d(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.f();
    }
    return paramFlexItem.d();
  }
  
  private int d(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b.getPaddingBottom();
    }
    return b.a();
  }
  
  private int f(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.d();
    }
    return paramFlexItem.f();
  }
  
  private int toString(FlexItem paramFlexItem, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramFlexItem.getWidth();
    }
    return paramFlexItem.getHeight();
  }
  
  int a(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  void a(int paramInt)
  {
    if (paramInt >= b.c()) {
      return;
    }
    int j = b.f();
    m localM;
    Object localObject2;
    Object localObject3;
    if (b.m() == 4)
    {
      localObject1 = c;
      if (localObject1 != null) {
        paramInt = localObject1[paramInt];
      } else {
        paramInt = 0;
      }
      localObject1 = b.i();
      int k = ((List)localObject1).size();
      while (paramInt < k)
      {
        localM = (m)((List)localObject1).get(paramInt);
        int m = c;
        int i = 0;
        while (i < m)
        {
          int n = f + i;
          if (i < b.c())
          {
            localObject2 = b.c(n);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8))
            {
              localObject3 = (FlexItem)((View)localObject2).getLayoutParams();
              if ((((FlexItem)localObject3).n() == -1) || (((FlexItem)localObject3).n() == 4)) {
                if ((j != 0) && (j != 1))
                {
                  if ((j != 2) && (j != 3))
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("Invalid flex direction: ");
                    ((StringBuilder)localObject1).append(j);
                    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                  }
                  a((View)localObject2, k, n);
                }
                else
                {
                  b((View)localObject2, k, n);
                }
              }
            }
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    Object localObject1 = b.i().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localM = (m)((Iterator)localObject1).next();
      localObject2 = q.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        View localView = b.c(((Integer)localObject3).intValue());
        if ((j != 0) && (j != 1))
        {
          if ((j != 2) && (j != 3))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Invalid flex direction: ");
            ((StringBuilder)localObject1).append(j);
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
          }
          a(localView, k, ((Integer)localObject3).intValue());
        }
        else
        {
          b(localView, k, ((Integer)localObject3).intValue());
        }
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b(b.c());
    if (paramInt3 >= b.c()) {
      return;
    }
    int i = b.f();
    int j = b.f();
    int k;
    int m;
    if ((j != 0) && (j != 1))
    {
      if ((j != 2) && (j != 3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid flex direction: ");
        ((StringBuilder)localObject).append(i);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      j = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      if (j != 1073741824) {
        i = b.b();
      }
      k = b.getPaddingTop();
      m = b.getPaddingBottom();
      j = i;
    }
    else
    {
      j = View.MeasureSpec.getMode(paramInt1);
      i = View.MeasureSpec.getSize(paramInt1);
      if (j != 1073741824) {
        i = b.b();
      }
      k = b.getPaddingLeft();
      m = b.getPaddingRight();
      j = i;
    }
    k += m;
    i = 0;
    Object localObject = c;
    if (localObject != null) {
      i = localObject[paramInt3];
    }
    localObject = b.i();
    paramInt3 = ((List)localObject).size();
    while (i < paramInt3)
    {
      m localM = (m)((List)localObject).get(i);
      if (b < j) {
        b(paramInt1, paramInt2, localM, j, k, false);
      } else {
        a(paramInt1, paramInt2, localM, j, k, false);
      }
      i += 1;
    }
  }
  
  void a(View paramView, m paramM, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = b.m();
    if (localFlexItem.n() != -1) {
      i = localFlexItem.n();
    }
    int j = k;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {}
          }
          else
          {
            if (b.n() != 2)
            {
              i = Math.max(s - paramView.getBaseline(), localFlexItem.f());
              paramView.layout(paramInt1, paramInt2 + i, paramInt3, paramInt4 + i);
              return;
            }
            i = Math.max(s - paramView.getMeasuredHeight() + paramView.getBaseline(), localFlexItem.c());
            paramView.layout(paramInt1, paramInt2 - i, paramInt3, paramInt4 - i);
          }
        }
        else
        {
          paramInt4 = (j - paramView.getMeasuredHeight() + localFlexItem.f() - localFlexItem.c()) / 2;
          if (b.n() != 2)
          {
            paramInt2 += paramInt4;
            paramView.layout(paramInt1, paramInt2, paramInt3, paramView.getMeasuredHeight() + paramInt2);
            return;
          }
          paramInt2 -= paramInt4;
          paramView.layout(paramInt1, paramInt2, paramInt3, paramView.getMeasuredHeight() + paramInt2);
        }
      }
      else
      {
        if (b.n() != 2)
        {
          paramInt2 += j;
          paramView.layout(paramInt1, paramInt2 - paramView.getMeasuredHeight() - localFlexItem.c(), paramInt3, paramInt2 - localFlexItem.c());
          return;
        }
        paramView.layout(paramInt1, paramInt2 - j + paramView.getMeasuredHeight() + localFlexItem.f(), paramInt3, paramInt4 - j + paramView.getMeasuredHeight() + localFlexItem.f());
        return;
      }
    }
    if (b.n() != 2)
    {
      paramView.layout(paramInt1, paramInt2 + localFlexItem.f(), paramInt3, paramInt4 + localFlexItem.f());
      return;
    }
    paramView.layout(paramInt1, paramInt2 - localFlexItem.c(), paramInt3, paramInt4 - localFlexItem.c());
  }
  
  void a(View paramView, m paramM, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = b.m();
    if (localFlexItem.n() != -1) {
      i = localFlexItem.n();
    }
    int j = k;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i == 3) || (i == 4)) {}
        }
        else
        {
          paramM = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
          i = (j - paramView.getMeasuredWidth() + Log.getLayoutDirection(paramM) - Log.getMarginEnd(paramM)) / 2;
          if (!paramBoolean)
          {
            paramView.layout(paramInt1 + i, paramInt2, paramInt3 + i, paramInt4);
            return;
          }
          paramView.layout(paramInt1 - i, paramInt2, paramInt3 - i, paramInt4);
        }
      }
      else
      {
        if (!paramBoolean)
        {
          paramView.layout(paramInt1 + j - paramView.getMeasuredWidth() - localFlexItem.b(), paramInt2, paramInt3 + j - paramView.getMeasuredWidth() - localFlexItem.b(), paramInt4);
          return;
        }
        paramView.layout(paramInt1 - j + paramView.getMeasuredWidth() + localFlexItem.d(), paramInt2, paramInt3 - j + paramView.getMeasuredWidth() + localFlexItem.d(), paramInt4);
        return;
      }
    }
    if (!paramBoolean)
    {
      paramView.layout(paramInt1 + localFlexItem.d(), paramInt2, paramInt3 + localFlexItem.d(), paramInt4);
      return;
    }
    paramView.layout(paramInt1 - localFlexItem.b(), paramInt2, paramInt3 - localFlexItem.b(), paramInt4);
  }
  
  void a(Label paramLabel, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List paramList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a23 = a22\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  void a(Label paramLabel, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List paramList)
  {
    a(paramLabel, paramInt2, paramInt1, paramInt3, paramInt4, -1, paramList);
  }
  
  void add(int paramInt)
  {
    long[] arrayOfLong = x;
    int i;
    if (arrayOfLong == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      x = new long[i];
      return;
    }
    if (arrayOfLong.length < paramInt)
    {
      int j = arrayOfLong.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      x = Arrays.copyOf(arrayOfLong, i);
    }
  }
  
  void add(Label paramLabel, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List paramList)
  {
    a(paramLabel, paramInt1, paramInt2, paramInt3, 0, paramInt4, paramList);
  }
  
  int b(long paramLong)
  {
    return (int)paramLong;
  }
  
  void b(Label paramLabel, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List paramList)
  {
    a(paramLabel, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList);
  }
  
  void get(int paramInt)
  {
    int[] arrayOfInt = c;
    int i;
    if (arrayOfInt == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      c = new int[i];
      return;
    }
    if (arrayOfInt.length < paramInt)
    {
      int j = arrayOfInt.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      c = Arrays.copyOf(arrayOfInt, i);
    }
  }
  
  void get(List paramList, int paramInt)
  {
    int j = c[paramInt];
    int i = j;
    if (j == -1) {
      i = 0;
    }
    j = paramList.size() - 1;
    while (j >= i)
    {
      paramList.remove(j);
      j -= 1;
    }
    paramList = c;
    i = paramList.length - 1;
    if (paramInt > i) {
      Arrays.fill(paramList, -1);
    } else {
      Arrays.fill(paramList, paramInt, i, -1);
    }
    paramList = x;
    i = paramList.length - 1;
    if (paramInt > i)
    {
      Arrays.fill(paramList, 0L);
      return;
    }
    Arrays.fill(paramList, paramInt, i, 0L);
  }
  
  void putByte(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0);
  }
  
  void putShort()
  {
    a(0);
  }
  
  long write(int paramInt1, int paramInt2)
  {
    long l = paramInt2;
    return paramInt1 & 0xFFFFFFFF | l << 32;
  }
  
  void write(int paramInt)
  {
    long[] arrayOfLong = a;
    int i;
    if (arrayOfLong == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      a = new long[i];
      return;
    }
    if (arrayOfLong.length < paramInt)
    {
      int j = arrayOfLong.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      a = Arrays.copyOf(arrayOfLong, i);
    }
  }
  
  void write(Label paramLabel, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List paramList)
  {
    a(paramLabel, paramInt2, paramInt1, paramInt3, 0, paramInt4, paramList);
  }
}
