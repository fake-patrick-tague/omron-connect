package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import org.org.org.ui.R.id;
import org.org.org.ui.R.styleable;
import v7.v7.package_13.Log;
import v7.v7.package_13.ViewCompat;

public class FlowLayout
  extends ViewGroup
{
  private boolean debugDraw = false;
  private int mDividerHeight;
  private int mDividerWidth;
  private int offsetX;
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    readStyleParameters(paramContext, paramAttributeSet);
  }
  
  private static int min(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != Integer.MIN_VALUE)
    {
      if (paramInt2 != 1073741824) {
        return paramInt3;
      }
      return paramInt1;
    }
    return Math.min(paramInt3, paramInt1);
  }
  
  private void readStyleParameters(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout_LayoutParams, 0, 0);
    mDividerHeight = paramContext.getDimensionPixelSize(R.styleable.FlowLayout_LayoutParams_layout_newLine, 0);
    mDividerWidth = paramContext.getDimensionPixelSize(R.styleable.FlowLayout_LayoutParams_android_layout_gravity, 0);
    paramContext.recycle();
  }
  
  public int b(View paramView)
  {
    paramView = paramView.getTag(R.id.y);
    if (!(paramView instanceof Integer)) {
      return -1;
    }
    return ((Integer)paramView).intValue();
  }
  
  protected int getItemSpacing()
  {
    return mDividerWidth;
  }
  
  protected int getLineSpacing()
  {
    return mDividerHeight;
  }
  
  protected int getRowCount()
  {
    return offsetX;
  }
  
  public boolean isDebugDraw()
  {
    return debugDraw;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0)
    {
      offsetX = 0;
      return;
    }
    offsetX = 1;
    int i;
    if (ViewCompat.getLayoutDirection(this) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramInt2 = getPaddingRight();
    } else {
      paramInt2 = getPaddingLeft();
    }
    if (i != 0) {
      j = getPaddingLeft();
    } else {
      j = getPaddingRight();
    }
    paramInt4 = getPaddingTop();
    int k = paramInt4;
    int i2 = paramInt3 - paramInt1 - j;
    int j = 0;
    paramInt3 = paramInt2;
    paramInt1 = paramInt4;
    while (j < getChildCount())
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8)
      {
        localView.setTag(R.id.y, Integer.valueOf(-1));
      }
      else
      {
        Object localObject = localView.getLayoutParams();
        int m;
        int n;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          m = Log.getLayoutDirection((ViewGroup.MarginLayoutParams)localObject);
          n = Log.getMarginEnd((ViewGroup.MarginLayoutParams)localObject);
        }
        else
        {
          n = 0;
          m = 0;
        }
        int i3 = localView.getMeasuredWidth();
        int i1 = paramInt3;
        paramInt4 = paramInt1;
        if (!debugDraw)
        {
          i1 = paramInt3;
          paramInt4 = paramInt1;
          if (paramInt3 + m + i3 > i2)
          {
            paramInt4 = mDividerHeight + k;
            offsetX += 1;
            i1 = paramInt2;
          }
        }
        localView.setTag(R.id.y, Integer.valueOf(offsetX - 1));
        paramInt1 = i1 + m;
        paramInt3 = localView.getMeasuredWidth() + paramInt1;
        k = localView.getMeasuredHeight() + paramInt4;
        if (i != 0) {
          localView.layout(i2 - paramInt3, paramInt4, i2 - i1 - m, k);
        } else {
          localView.layout(paramInt1, paramInt4, paramInt3, k);
        }
        paramInt3 = i1 + (m + n + localView.getMeasuredWidth() + mDividerWidth);
        paramInt1 = paramInt4;
      }
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i9 = View.MeasureSpec.getSize(paramInt2);
    int i10 = View.MeasureSpec.getMode(paramInt2);
    int n;
    if ((i8 != Integer.MIN_VALUE) && (i8 != 1073741824)) {
      n = Integer.MAX_VALUE;
    } else {
      n = i6;
    }
    int m = getPaddingLeft();
    int j = getPaddingTop();
    int i2 = j;
    int i11 = getPaddingRight();
    int i1 = 0;
    int i = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      int i4;
      if (localView.getVisibility() == 8)
      {
        i4 = j;
      }
      else
      {
        measureChild(localView, paramInt1, paramInt2);
        Object localObject = localView.getLayoutParams();
        int i3;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          i4 = leftMargin + 0;
          i3 = rightMargin + 0;
        }
        else
        {
          i4 = 0;
          i3 = 0;
        }
        int i5 = m;
        int k = j;
        if (m + i4 + localView.getMeasuredWidth() > n - i11)
        {
          i5 = m;
          k = j;
          if (!isDebugDraw())
          {
            i5 = getPaddingLeft();
            k = mDividerHeight + i2;
          }
        }
        m = i5 + i4 + localView.getMeasuredWidth();
        int i7 = k + localView.getMeasuredHeight();
        j = i;
        if (m > i) {
          j = m;
        }
        i5 += i4 + i3 + localView.getMeasuredWidth() + mDividerWidth;
        m = i5;
        i = j;
        i2 = i7;
        i4 = k;
        if (i1 == getChildCount() - 1)
        {
          i = j + i3;
          i4 = k;
          i2 = i7;
          m = i5;
        }
      }
      i1 += 1;
      j = i4;
    }
    paramInt1 = getPaddingRight();
    paramInt2 = getPaddingBottom();
    setMeasuredDimension(min(i6, i8, i + paramInt1), min(i9, i10, i2 + paramInt2));
  }
  
  protected void setItemSpacing(int paramInt)
  {
    mDividerWidth = paramInt;
  }
  
  protected void setLineSpacing(int paramInt)
  {
    mDividerHeight = paramInt;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    debugDraw = paramBoolean;
  }
}
