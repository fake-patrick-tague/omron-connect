package com.braze.ui.inappmessage.listeners;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

public class SwipeDismissTouchListener
  implements View.OnTouchListener
{
  private final long mAnimationTime;
  private final DismissCallbacks mCallbacks;
  private float mDownX;
  private float mDownY;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final int mSlop;
  private boolean mSwiping;
  private int mSwipingSlop;
  private final Object mToken;
  private float mTranslationX;
  private VelocityTracker mVelocityTracker;
  private final View mView;
  private int mViewWidth = 1;
  
  public SwipeDismissTouchListener(View paramView, Object paramObject, DismissCallbacks paramDismissCallbacks)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramView.getContext());
    mSlop = localViewConfiguration.getScaledTouchSlop();
    mMinFlingVelocity = (localViewConfiguration.getScaledMinimumFlingVelocity() * 16);
    mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    mAnimationTime = paramView.getContext().getResources().getInteger(17694720);
    mView = paramView;
    mToken = paramObject;
    mCallbacks = paramDismissCallbacks;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.offsetLocation(mTranslationX, 0.0F);
    if (mViewWidth < 2) {
      mViewWidth = mView.getWidth();
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      int j = 1;
      int k = 1;
      float f1;
      float f2;
      float f3;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
          if (mVelocityTracker == null) {
            return false;
          }
          mView.animate().translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
          mVelocityTracker.recycle();
          mVelocityTracker = null;
          mTranslationX = 0.0F;
          mDownX = 0.0F;
          mDownY = 0.0F;
          mSwiping = false;
          return false;
        }
        paramView = mVelocityTracker;
        if (paramView == null) {
          return false;
        }
        paramView.addMovement(paramMotionEvent);
        f1 = paramMotionEvent.getRawX() - mDownX;
        f2 = paramMotionEvent.getRawY();
        f3 = mDownY;
        if ((Math.abs(f1) > mSlop) && (Math.abs(f2 - f3) < Math.abs(f1) / 2.0F))
        {
          mSwiping = true;
          if (f1 > 0.0F) {
            i = mSlop;
          } else {
            i = -mSlop;
          }
          mSwipingSlop = i;
          mView.getParent().requestDisallowInterceptTouchEvent(true);
          paramView = MotionEvent.obtain(paramMotionEvent);
          paramView.setAction(paramMotionEvent.getActionIndex() << 8 | 0x3);
          mView.onTouchEvent(paramView);
          paramView.recycle();
        }
        if (mSwiping)
        {
          mTranslationX = f1;
          mView.setTranslationX(f1 - mSwipingSlop);
          return true;
        }
      }
      else
      {
        if (mVelocityTracker == null) {
          return false;
        }
        f1 = paramMotionEvent.getRawX() - mDownX;
        mVelocityTracker.addMovement(paramMotionEvent);
        mVelocityTracker.computeCurrentVelocity(1000);
        f2 = mVelocityTracker.getXVelocity();
        f3 = Math.abs(f2);
        float f4 = Math.abs(mVelocityTracker.getYVelocity());
        if ((Math.abs(f1) > mViewWidth / 2) && (mSwiping))
        {
          if (f1 > 0.0F) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else if ((mMinFlingVelocity <= f3) && (f3 <= mMaxFlingVelocity) && (f4 < f3) && (mSwiping))
        {
          if (f2 < 0.0F) {
            i = 1;
          } else {
            i = 0;
          }
          if (f1 < 0.0F) {
            j = 1;
          } else {
            j = 0;
          }
          if (i == j) {
            i = 1;
          } else {
            i = 0;
          }
          if (mVelocityTracker.getXVelocity() > 0.0F) {
            j = k;
          } else {
            j = 0;
          }
          k = j;
          j = i;
          i = k;
        }
        else
        {
          i = 0;
          j = 0;
        }
        if (j != 0)
        {
          paramView = mView.animate();
          if (i != 0) {
            i = mViewWidth;
          } else {
            i = -mViewWidth;
          }
          paramView.translationX(i).alpha(0.0F).setDuration(mAnimationTime).setListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              performDismiss();
            }
          });
        }
        else if (mSwiping)
        {
          mView.animate().translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
        }
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mTranslationX = 0.0F;
        mDownX = 0.0F;
        mDownY = 0.0F;
        mSwiping = false;
        return false;
      }
    }
    else
    {
      mDownX = paramMotionEvent.getRawX();
      mDownY = paramMotionEvent.getRawY();
      if (mCallbacks.canDismiss(mToken))
      {
        paramView = VelocityTracker.obtain();
        mVelocityTracker = paramView;
        paramView.addMovement(paramMotionEvent);
      }
    }
    return false;
  }
  
  public void performDismiss()
  {
    final ViewGroup.LayoutParams localLayoutParams = mView.getLayoutParams();
    final int i = mView.getHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, 1 }).setDuration(mAnimationTime);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        mCallbacks.onDismiss(mView, mToken);
        mView.setAlpha(1.0F);
        mView.setTranslationX(0.0F);
        localLayoutParamsheight = i;
        mView.setLayoutParams(localLayoutParams);
      }
    });
    localValueAnimator.addUpdateListener(new SwipeDismissTouchListener.3(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public static abstract interface DismissCallbacks
  {
    public abstract boolean canDismiss(Object paramObject);
    
    public abstract void onDismiss(View paramView, Object paramObject);
  }
}
