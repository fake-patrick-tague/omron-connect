package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private int mTempLeftRightOffset = 0;
  private int mTempTopBottomOffset = 0;
  private ViewOffsetHelper mViewOffsetHelper;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getTopAndBottomOffset()
  {
    ViewOffsetHelper localViewOffsetHelper = mViewOffsetHelper;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.getTopAndBottomOffset();
    }
    return 0;
  }
  
  protected void layoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    paramCoordinatorLayout.onLayoutChild(paramView, paramInt);
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    layoutChild(paramCoordinatorLayout, paramView, paramInt);
    if (mViewOffsetHelper == null) {
      mViewOffsetHelper = new ViewOffsetHelper(paramView);
    }
    mViewOffsetHelper.onViewLayout();
    mViewOffsetHelper.updateOffsets();
    paramInt = mTempTopBottomOffset;
    if (paramInt != 0)
    {
      mViewOffsetHelper.setTopAndBottomOffset(paramInt);
      mTempTopBottomOffset = 0;
    }
    paramInt = mTempLeftRightOffset;
    if (paramInt != 0)
    {
      mViewOffsetHelper.setLeftAndRightOffset(paramInt);
      mTempLeftRightOffset = 0;
    }
    return true;
  }
  
  public boolean setTopAndBottomOffset(int paramInt)
  {
    ViewOffsetHelper localViewOffsetHelper = mViewOffsetHelper;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.setTopAndBottomOffset(paramInt);
    }
    mTempTopBottomOffset = paramInt;
    return false;
  }
}
