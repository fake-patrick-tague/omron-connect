package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import v7.v7.package_13.ViewCompat;

abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private int mActivePointerId = -1;
  private Runnable mFlingRunnable;
  private boolean mIsBeingDragged;
  private int mLastMotionY;
  OverScroller mScroller;
  private int mTouchSlop = -1;
  private VelocityTracker mVelocityTracker;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ensureVelocityTracker()
  {
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  abstract boolean canDragView(View paramView);
  
  final boolean fling(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, float paramFloat)
  {
    Runnable localRunnable = mFlingRunnable;
    if (localRunnable != null)
    {
      paramView.removeCallbacks(localRunnable);
      mFlingRunnable = null;
    }
    if (mScroller == null) {
      mScroller = new OverScroller(paramView.getContext());
    }
    mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (mScroller.computeScrollOffset())
    {
      paramCoordinatorLayout = new a(paramCoordinatorLayout, paramView);
      mFlingRunnable = paramCoordinatorLayout;
      ViewCompat.postOnAnimation(paramView, paramCoordinatorLayout);
      return true;
    }
    onFlingFinished(paramCoordinatorLayout, paramView);
    return false;
  }
  
  abstract int getMaxDragOffset(View paramView);
  
  abstract int getTopBottomOffsetForScrollingSibling();
  
  abstract void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, View paramView);
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (mTouchSlop < 0) {
      mTouchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    if ((paramMotionEvent.getActionMasked() == 2) && (mIsBeingDragged))
    {
      i = mActivePointerId;
      if (i == -1) {
        return false;
      }
      i = paramMotionEvent.findPointerIndex(i);
      if (i == -1) {
        return false;
      }
      i = (int)paramMotionEvent.getY(i);
      if (Math.abs(i - mLastMotionY) > mTouchSlop)
      {
        mLastMotionY = i;
        return true;
      }
    }
    if (paramMotionEvent.getActionMasked() == 0)
    {
      mActivePointerId = -1;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      boolean bool;
      if ((canDragView(paramView)) && (paramCoordinatorLayout.isPointInChildBounds(paramView, i, j))) {
        bool = true;
      } else {
        bool = false;
      }
      mIsBeingDragged = bool;
      if (bool)
      {
        mLastMotionY = j;
        mActivePointerId = paramMotionEvent.getPointerId(0);
        ensureVelocityTracker();
        paramCoordinatorLayout = mScroller;
        if ((paramCoordinatorLayout != null) && (!paramCoordinatorLayout.isFinished()))
        {
          mScroller.abortAnimation();
          return true;
        }
      }
    }
    paramCoordinatorLayout = mVelocityTracker;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label202;
        }
        if (i == 6)
        {
          if (paramMotionEvent.getActionIndex() == 0) {
            i = 1;
          } else {
            i = 0;
          }
          mActivePointerId = paramMotionEvent.getPointerId(i);
          mLastMotionY = ((int)(paramMotionEvent.getY(i) + 0.5F));
        }
      }
      else
      {
        i = paramMotionEvent.findPointerIndex(mActivePointerId);
        if (i == -1) {
          return false;
        }
        i = (int)paramMotionEvent.getY(i);
        j = mLastMotionY;
        mLastMotionY = i;
        scroll(paramCoordinatorLayout, paramView, j - i, getMaxDragOffset(paramView), 0);
      }
      j = 0;
      break label241;
    }
    else
    {
      VelocityTracker localVelocityTracker = mVelocityTracker;
      if (localVelocityTracker != null)
      {
        localVelocityTracker.addMovement(paramMotionEvent);
        mVelocityTracker.computeCurrentVelocity(1000);
        float f = mVelocityTracker.getYVelocity(mActivePointerId);
        fling(paramCoordinatorLayout, paramView, -scroll(paramView), 0, f);
        i = 1;
        break label205;
      }
    }
    label202:
    i = 0;
    label205:
    mIsBeingDragged = false;
    mActivePointerId = -1;
    paramCoordinatorLayout = mVelocityTracker;
    int j = i;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.recycle();
      mVelocityTracker = null;
      j = i;
    }
    label241:
    paramCoordinatorLayout = mVelocityTracker;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    if (!mIsBeingDragged) {
      return j != 0;
    }
    return true;
  }
  
  abstract int scroll(View paramView);
  
  final int scroll(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramView, getTopBottomOffsetForScrollingSibling() - paramInt1, paramInt2, paramInt3);
  }
  
  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramView, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  abstract int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3);
  
  private class a
    implements Runnable
  {
    private final V mLayout;
    private final CoordinatorLayout mParent;
    
    a(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      mParent = paramCoordinatorLayout;
      mLayout = paramView;
    }
    
    public void run()
    {
      if (mLayout != null)
      {
        Object localObject = mScroller;
        if (localObject != null)
        {
          if (((OverScroller)localObject).computeScrollOffset())
          {
            localObject = HeaderBehavior.this;
            ((HeaderBehavior)localObject).setHeaderTopBottomOffset(mParent, mLayout, mScroller.getCurrY());
            ViewCompat.postOnAnimation(mLayout, this);
            return;
          }
          onFlingFinished(mParent, mLayout);
        }
      }
    }
  }
}
