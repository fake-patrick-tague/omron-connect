package com.alivecor.mapsforge.record;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class Zoomer
{
  private final int mAnimationDurationMillis;
  private float mCurrentZoom;
  private float mEndZoom;
  private boolean mFinished = true;
  private final Interpolator mInterpolator = new DecelerateInterpolator();
  private long mStartRTC;
  
  public Zoomer(Context paramContext)
  {
    mAnimationDurationMillis = paramContext.getResources().getInteger(17694720);
  }
  
  public void abortAnimation()
  {
    mFinished = true;
    mCurrentZoom = mEndZoom;
  }
  
  public boolean computeZoom()
  {
    if (mFinished) {
      return false;
    }
    long l = SystemClock.elapsedRealtime() - mStartRTC;
    int i = mAnimationDurationMillis;
    if (l >= i)
    {
      mFinished = true;
      mCurrentZoom = mEndZoom;
      return false;
    }
    float f = (float)l * 1.0F / i;
    mCurrentZoom = (mEndZoom * mInterpolator.getInterpolation(f));
    return true;
  }
  
  public void forceFinished(boolean paramBoolean)
  {
    mFinished = paramBoolean;
  }
  
  public float getCurrZoom()
  {
    return mCurrentZoom;
  }
  
  public void startZoom(float paramFloat)
  {
    mStartRTC = SystemClock.elapsedRealtime();
    mEndZoom = paramFloat;
    mFinished = false;
    mCurrentZoom = 1.0F;
  }
}
