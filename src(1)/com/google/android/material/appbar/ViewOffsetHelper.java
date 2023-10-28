package com.google.android.material.appbar;

import android.view.View;
import v7.v7.package_13.ViewCompat;

class ViewOffsetHelper
{
  private boolean c = true;
  private boolean f = true;
  private int mLayoutLeft;
  private int mLayoutTop;
  private int mOffsetLeft;
  private int mOffsetTop;
  private final View mView;
  
  public ViewOffsetHelper(View paramView)
  {
    mView = paramView;
  }
  
  public int getLeftAndRightOffset()
  {
    return mLayoutTop;
  }
  
  public int getTopAndBottomOffset()
  {
    return mOffsetTop;
  }
  
  void onViewLayout()
  {
    mLayoutTop = mView.getTop();
    mLayoutLeft = mView.getLeft();
  }
  
  public boolean setLeftAndRightOffset(int paramInt)
  {
    if ((c) && (mOffsetLeft != paramInt))
    {
      mOffsetLeft = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }
  
  public boolean setTopAndBottomOffset(int paramInt)
  {
    if ((f) && (mOffsetTop != paramInt))
    {
      mOffsetTop = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }
  
  void updateOffsets()
  {
    View localView = mView;
    ViewCompat.offsetTopAndBottom(localView, mOffsetTop - (localView.getTop() - mLayoutTop));
    localView = mView;
    ViewCompat.offsetLeftAndRight(localView, mOffsetLeft - (localView.getLeft() - mLayoutLeft));
  }
}
