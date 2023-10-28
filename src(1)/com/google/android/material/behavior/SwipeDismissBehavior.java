package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.Label;
import v7.v7.package_13.asm.d;
import v7.v7.package_13.asm.o;
import v7.view.asm.ViewDragHelper;
import v7.view.asm.ViewDragHelper.Callback;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  int d = 2;
  float mAlphaEndSwipeDistance = 0.5F;
  float mAlphaStartSwipeDistance = 0.0F;
  private final ViewDragHelper.Callback mDragCallback = new a();
  float mDragDismissThreshold = 0.5F;
  private boolean mIgnoreEvents;
  private float mSensitivity = 0.0F;
  private boolean mSensitivitySet;
  ViewDragHelper mViewDragHelper;
  c this$0;
  
  public SwipeDismissBehavior() {}
  
  private void b(View paramView)
  {
    ViewCompat.a(paramView, 1048576);
    if (a(paramView)) {
      ViewCompat.a(paramView, Label.C, null, new b());
    }
  }
  
  static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  private void ensureViewDragHelper(ViewGroup paramViewGroup)
  {
    if (mViewDragHelper == null)
    {
      if (mSensitivitySet) {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, mSensitivity, mDragCallback);
      } else {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, mDragCallback);
      }
      mViewDragHelper = paramViewGroup;
    }
  }
  
  static float fraction(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  public boolean a(View paramView)
  {
    return true;
  }
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = mIgnoreEvents;
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        mIgnoreEvents = false;
      }
    }
    else
    {
      boolean bool2 = paramCoordinatorLayout.isPointInChildBounds(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = bool2;
      mIgnoreEvents = bool2;
    }
    if (bool1)
    {
      ensureViewDragHelper(paramCoordinatorLayout);
      return mViewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramView, paramInt);
    if (ViewCompat.getImportantForAccessibility(paramView) == 0)
    {
      ViewCompat.get(paramView, 1);
      b(paramView);
    }
    return bool;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    paramCoordinatorLayout = mViewDragHelper;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.processTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void setEndAlphaSwipeDistance(float paramFloat)
  {
    mAlphaEndSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setListener(int paramInt)
  {
    d = paramInt;
  }
  
  public void setStartAlphaSwipeDistance(float paramFloat)
  {
    mAlphaStartSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }
  
  class a
    extends ViewDragHelper.Callback
  {
    private int mActivePointerId = -1;
    private int mOriginalCapturedViewLeft;
    
    a() {}
    
    private boolean shouldDismiss(View paramView, float paramFloat)
    {
      boolean bool = paramFloat < 0.0F;
      int i;
      int k;
      if (bool)
      {
        if (ViewCompat.getLayoutDirection(paramView) == 1) {
          i = 1;
        } else {
          i = 0;
        }
        k = d;
        if (k == 2) {
          return true;
        }
        if (k == 0)
        {
          if (i != 0 ? paramFloat < 0.0F : bool) {
            return true;
          }
        }
        else if ((k == 1) && (i != 0 ? bool : paramFloat < 0.0F)) {
          return true;
        }
      }
      else
      {
        i = paramView.getLeft();
        int j = mOriginalCapturedViewLeft;
        k = Math.round(paramView.getWidth() * mDragDismissThreshold);
        if (Math.abs(i - j) >= k) {
          return true;
        }
      }
      return false;
    }
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      if (ViewCompat.getLayoutDirection(paramView) == 1) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      int i = d;
      if (i == 0)
      {
        if (paramInt2 != 0)
        {
          i = mOriginalCapturedViewLeft - paramView.getWidth();
          paramInt2 = mOriginalCapturedViewLeft;
        }
        else
        {
          i = mOriginalCapturedViewLeft;
        }
      }
      else
      {
        for (paramInt2 = paramView.getWidth();; paramInt2 = paramView.getWidth())
        {
          paramInt2 += i;
          break label137;
          if (i != 1) {
            break label114;
          }
          if (paramInt2 == 0) {
            break;
          }
          i = mOriginalCapturedViewLeft;
        }
        i = mOriginalCapturedViewLeft - paramView.getWidth();
        paramInt2 = mOriginalCapturedViewLeft;
        break label137;
        label114:
        i = mOriginalCapturedViewLeft - paramView.getWidth();
        paramInt2 = mOriginalCapturedViewLeft;
        paramInt2 = paramView.getWidth() + paramInt2;
      }
      label137:
      return SwipeDismissBehavior.min(i, paramInt1, paramInt2);
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return paramView.getWidth();
    }
    
    public void onViewCaptured(View paramView, int paramInt)
    {
      mActivePointerId = paramInt;
      mOriginalCapturedViewLeft = paramView.getLeft();
      paramView = paramView.getParent();
      if (paramView != null) {
        paramView.requestDisallowInterceptTouchEvent(true);
      }
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      SwipeDismissBehavior.c localC = this$0;
      if (localC != null) {
        localC.setVisibility(paramInt);
      }
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      float f1 = mOriginalCapturedViewLeft + paramView.getWidth() * mAlphaStartSwipeDistance;
      float f2 = mOriginalCapturedViewLeft + paramView.getWidth() * mAlphaEndSwipeDistance;
      float f3 = paramInt1;
      if (f3 <= f1)
      {
        paramView.setAlpha(1.0F);
        return;
      }
      if (f3 >= f2)
      {
        paramView.setAlpha(0.0F);
        return;
      }
      paramView.setAlpha(SwipeDismissBehavior.clamp(0.0F, 1.0F - SwipeDismissBehavior.fraction(f1, f2, f3), 1.0F));
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      mActivePointerId = -1;
      int i = paramView.getWidth();
      boolean bool;
      if (shouldDismiss(paramView, paramFloat1))
      {
        int j = paramView.getLeft();
        int k = mOriginalCapturedViewLeft;
        if (j < k) {
          i = k - i;
        } else {
          i = k + i;
        }
        bool = true;
      }
      else
      {
        i = mOriginalCapturedViewLeft;
        bool = false;
      }
      if (mViewDragHelper.settleCapturedViewAt(i, paramView.getTop()))
      {
        ViewCompat.postOnAnimation(paramView, new SwipeDismissBehavior.d(SwipeDismissBehavior.this, paramView, bool));
        return;
      }
      if (bool)
      {
        SwipeDismissBehavior.c localC = this$0;
        if (localC != null) {
          localC.create(paramView);
        }
      }
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      int i = mActivePointerId;
      return ((i == -1) || (i == paramInt)) && (a(paramView));
    }
  }
  
  class b
    implements d
  {
    b() {}
    
    public boolean b(View paramView, o paramO)
    {
      boolean bool = a(paramView);
      int k = 0;
      if (bool)
      {
        if (ViewCompat.getLayoutDirection(paramView) == 1) {
          j = 1;
        } else {
          j = 0;
        }
        int m = d;
        int i;
        if ((m != 0) || (j == 0))
        {
          i = k;
          if (m == 1)
          {
            i = k;
            if (j != 0) {}
          }
        }
        else
        {
          i = 1;
        }
        k = paramView.getWidth();
        int j = k;
        if (i != 0) {
          j = -k;
        }
        ViewCompat.offsetLeftAndRight(paramView, j);
        paramView.setAlpha(0.0F);
        paramO = this$0;
        if (paramO != null)
        {
          paramO.create(paramView);
          return true;
        }
      }
      else
      {
        return false;
      }
      return true;
    }
  }
  
  public static abstract interface c
  {
    public abstract void create(View paramView);
    
    public abstract void setVisibility(int paramInt);
  }
  
  private class d
    implements Runnable
  {
    private final View c;
    private final boolean d;
    
    d(View paramView, boolean paramBoolean)
    {
      c = paramView;
      d = paramBoolean;
    }
    
    public void run()
    {
      Object localObject = mViewDragHelper;
      if ((localObject != null) && (((ViewDragHelper)localObject).continueSettling(true)))
      {
        ViewCompat.postOnAnimation(c, this);
        return;
      }
      if (d)
      {
        localObject = this$0;
        if (localObject != null) {
          ((SwipeDismissBehavior.c)localObject).create(c);
        }
      }
    }
  }
}
