package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import java.util.List;
import v7.v7.package_13.GravityCompat;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.f;
import v7.v7.widget.MathUtils;

abstract class HeaderScrollingViewBehavior
  extends ViewOffsetBehavior<View>
{
  private int mOverlayTop;
  final Rect mTempRect1 = new Rect();
  final Rect mTempRect2 = new Rect();
  private int mVerticalLayoutGap = 0;
  
  public HeaderScrollingViewBehavior() {}
  
  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int resolveGravity(int paramInt)
  {
    if (paramInt == 0) {
      return 8388659;
    }
    return paramInt;
  }
  
  abstract View findFirstDependency(List paramList);
  
  final int getOverlapPixelsForOffset(View paramView)
  {
    if (mOverlayTop == 0) {
      return 0;
    }
    float f = getOverlapRatioForOffset(paramView);
    int i = mOverlayTop;
    return MathUtils.constrain((int)(f * i), 0, i);
  }
  
  abstract float getOverlapRatioForOffset(View paramView);
  
  public final int getOverlayTop()
  {
    return mOverlayTop;
  }
  
  int getScrollRange(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  final int getVerticalLayoutGap()
  {
    return mVerticalLayoutGap;
  }
  
  protected void layoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
    if (localView != null)
    {
      CoordinatorLayout.e localE = (CoordinatorLayout.e)paramView.getLayoutParams();
      Rect localRect = mTempRect1;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + leftMargin, localView.getBottom() + topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - bottomMargin);
      f localF = paramCoordinatorLayout.getLastWindowInsets();
      if ((localF != null) && (ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramView)))
      {
        left += localF.getHeight();
        right -= localF.getWidth();
      }
      paramCoordinatorLayout = mTempRect2;
      GravityCompat.apply(resolveGravity(gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = getOverlapPixelsForOffset(localView);
      paramView.layout(left, top - paramInt, right, bottom - paramInt);
      mVerticalLayoutGap = (top - localView.getBottom());
      return;
    }
    super.layoutChild(paramCoordinatorLayout, paramView, paramInt);
    mVerticalLayoutGap = 0;
  }
  
  protected boolean onMeasureChild()
  {
    return false;
  }
  
  public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = getLayoutParamsheight;
    if ((k == -1) || (k == -2))
    {
      View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
      if (localView != null)
      {
        int j = View.MeasureSpec.getSize(paramInt3);
        int i = j;
        if (j > 0)
        {
          paramInt3 = i;
          if (ViewCompat.getFitsSystemWindows(localView))
          {
            f localF = paramCoordinatorLayout.getLastWindowInsets();
            paramInt3 = i;
            if (localF != null) {
              paramInt3 = j + (localF.getSystemWindowInsetTop() + localF.size());
            }
          }
        }
        else
        {
          paramInt3 = paramCoordinatorLayout.getHeight();
        }
        paramInt3 += getScrollRange(localView);
        i = localView.getMeasuredHeight();
        if (onMeasureChild()) {
          paramView.setTranslationY(-i);
        } else {
          paramInt3 -= i;
        }
        if (k == -1) {
          i = 1073741824;
        } else {
          i = Integer.MIN_VALUE;
        }
        paramCoordinatorLayout.onMeasureChild(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt3, i), paramInt4);
        return true;
      }
    }
    return false;
  }
  
  public final void setOverlayTop(int paramInt)
  {
    mOverlayTop = paramInt;
  }
}
