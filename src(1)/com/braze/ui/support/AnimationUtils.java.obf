package com.braze.ui.support;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import kotlin.x.d.i;

public final class AnimationUtils
{
  private static final Interpolator accelerateInterpolator = new AccelerateInterpolator();
  private static final Interpolator decelerateInterpolator = new DecelerateInterpolator();
  
  public static final Animation createVerticalAnimation(float paramFloat1, float paramFloat2, long paramLong, boolean paramBoolean)
  {
    return setAnimationParams(new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, paramFloat1, 1, paramFloat2), paramLong, paramBoolean);
  }
  
  public static final Animation setAnimationParams(Animation paramAnimation, long paramLong, boolean paramBoolean)
  {
    i.e(paramAnimation, "animation");
    paramAnimation.setDuration(paramLong);
    if (paramBoolean)
    {
      paramAnimation.setInterpolator(accelerateInterpolator);
      return paramAnimation;
    }
    paramAnimation.setInterpolator(decelerateInterpolator);
    return paramAnimation;
  }
}
