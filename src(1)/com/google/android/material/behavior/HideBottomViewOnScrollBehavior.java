package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import org.org.org.ui.utils.AnimationUtils;

public class HideBottomViewOnScrollBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private ViewPropertyAnimator animator;
  private int flags = 0;
  private int mFlags = 0;
  private int visibility = 2;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void toggle(View paramView, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    animator = paramView.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new a());
  }
  
  public void hide(View paramView)
  {
    if (visibility == 1) {
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = animator;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramView.clearAnimation();
    }
    visibility = 1;
    toggle(paramView, mFlags + flags, 175L, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    mFlags = (paramView.getMeasuredHeight() + bottomMargin);
    return super.onLayoutChild(paramCoordinatorLayout, paramView, paramInt);
  }
  
  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    if (paramInt2 > 0)
    {
      hide(paramView1);
      return;
    }
    if (paramInt2 < 0) {
      show(paramView1);
    }
  }
  
  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    return paramInt1 == 2;
  }
  
  public void show(View paramView)
  {
    if (visibility == 2) {
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = animator;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramView.clearAnimation();
    }
    visibility = 2;
    toggle(paramView, 0, 225L, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
  }
  
  public void show(View paramView, int paramInt)
  {
    flags = paramInt;
    if (visibility == 1) {
      paramView.setTranslationY(mFlags + paramInt);
    }
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      HideBottomViewOnScrollBehavior.access$setRunningAnimation(HideBottomViewOnScrollBehavior.this, null);
    }
  }
}
