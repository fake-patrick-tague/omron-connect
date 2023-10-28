package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import org.org.org.ui.R.id;
import v7.v7.package_13.ActionMenuItemView;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.util.Position;

final class MaterialCalendarGridView
  extends GridView
{
  private final boolean d;
  private final Calendar v = Log.getInstance();
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (d.a(getContext()))
    {
      setNextFocusLeftId(R.id.a);
      setNextFocusRightId(R.id.header);
    }
    d = d.d(getContext());
    v7.v7.package_13.ViewCompat.a(this, new a());
  }
  
  private static boolean areEqual(Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4)
  {
    if ((paramLong1 != null) && (paramLong2 != null) && (paramLong3 != null))
    {
      if (paramLong4 == null) {
        return true;
      }
      if (paramLong3.longValue() <= paramLong2.longValue()) {
        return paramLong4.longValue() < paramLong1.longValue();
      }
    }
    return true;
  }
  
  private static int drawLabel(View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private void initialize(int paramInt, Rect paramRect)
  {
    if (paramInt == 33)
    {
      setSelection(a().next());
      return;
    }
    if (paramInt == 130)
    {
      setSelection(a().a());
      return;
    }
    super.onFocusChanged(true, paramInt, paramRect);
  }
  
  public h a()
  {
    return (h)super.getAdapter();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a().notifyDataSetChanged();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    h localH = a();
    Object localObject1 = a;
    a localA = f;
    Long localLong1 = localH.get(localH.a());
    Long localLong2 = localH.get(localH.next());
    Iterator localIterator = ((DateSelector)localObject1).equals().iterator();
    for (;;)
    {
      localObject1 = this;
      if (!localIterator.hasNext()) {
        break;
      }
      Position localPosition = (Position)localIterator.next();
      Object localObject2 = a;
      if (localObject2 != null) {
        if (x != null)
        {
          long l1 = ((Long)localObject2).longValue();
          long l2 = ((Long)x).longValue();
          if (!areEqual(localLong1, localLong2, Long.valueOf(l1), Long.valueOf(l2)))
          {
            boolean bool = com.google.android.material.internal.ViewCompat.a(this);
            int i;
            int n;
            if (l1 < localLong1.longValue())
            {
              i = localH.a();
              n = i;
              if (localH.a(i)) {
                i = 0;
              } else if (!bool) {
                i = ((ViewGroup)localObject1).getChildAt(i - 1).getRight();
              } else {
                i = ((ViewGroup)localObject1).getChildAt(i - 1).getLeft();
              }
            }
            else
            {
              v.setTimeInMillis(l1);
              i = localH.getCount(v.get(5));
              n = i;
              i = drawLabel(((ViewGroup)localObject1).getChildAt(i));
            }
            int j;
            int i1;
            if (l2 > localLong2.longValue())
            {
              j = Math.min(localH.next(), getChildCount() - 1);
              i1 = j;
              if (localH.equals(j)) {
                j = getWidth();
              } else if (!bool) {
                j = ((ViewGroup)localObject1).getChildAt(j).getRight();
              } else {
                j = ((ViewGroup)localObject1).getChildAt(j).getLeft();
              }
            }
            else
            {
              v.setTimeInMillis(l2);
              j = localH.getCount(v.get(5));
              i1 = j;
              j = drawLabel(((ViewGroup)localObject1).getChildAt(j));
            }
            int i2 = (int)localH.getItemId(n);
            int i4 = (int)localH.getItemId(i1);
            while (i2 <= i4)
            {
              int m = getNumColumns() * i2;
              int i3 = getNumColumns() + m - 1;
              localObject1 = getChildAt(m);
              int i5 = ((View)localObject1).getTop();
              int i6 = a.size();
              int i7 = ((View)localObject1).getBottom();
              int i8 = a.a();
              int k;
              if (!bool)
              {
                if (m > n) {
                  k = 0;
                } else {
                  k = i;
                }
                if (i1 > i3)
                {
                  i3 = getWidth();
                  m = k;
                  k = i3;
                }
                else
                {
                  i3 = j;
                  m = k;
                  k = i3;
                }
              }
              else
              {
                if (i1 > i3) {
                  k = 0;
                } else {
                  k = j;
                }
                if (m > n) {
                  m = getWidth();
                } else {
                  m = i;
                }
                i3 = k;
                k = m;
                m = i3;
              }
              paramCanvas.drawRect(m, i5 + i6, k, i7 - i8, k);
              i2 += 1;
            }
          }
        }
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean)
    {
      initialize(paramInt, paramRect);
      return;
    }
    super.onFocusChanged(false, paramInt, paramRect);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!super.onKeyDown(paramInt, paramKeyEvent)) {
      return false;
    }
    if (getSelectedItemPosition() != -1)
    {
      if (getSelectedItemPosition() >= a().a()) {
        return true;
      }
      if (19 == paramInt)
      {
        setSelection(a().a());
        return true;
      }
      return false;
    }
    return true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (d)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
      getLayoutParamsheight = getMeasuredHeight();
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof h))
    {
      super.setAdapter(paramListAdapter);
      return;
    }
    throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[] { MaterialCalendarGridView.class.getCanonicalName(), h.class.getCanonicalName() }));
  }
  
  public void setSelection(int paramInt)
  {
    if (paramInt < a().a())
    {
      super.setSelection(a().a());
      return;
    }
    super.setSelection(paramInt);
  }
  
  class a
    extends ActionMenuItemView
  {
    a() {}
    
    public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.a(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setParent(null);
    }
  }
}
