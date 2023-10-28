package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

public final class StateListAnimator
{
  private final Animator.AnimatorListener mAnimationListener = new GlowPadView.2(this);
  private Tuple mLastMatch = null;
  ValueAnimator mRunningAnimation = null;
  private final ArrayList<d.b> mTuples = new ArrayList();
  
  public StateListAnimator() {}
  
  private void cancel()
  {
    ValueAnimator localValueAnimator = mRunningAnimation;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      mRunningAnimation = null;
    }
  }
  
  private void start(Tuple paramTuple)
  {
    paramTuple = mAnimation;
    mRunningAnimation = paramTuple;
    paramTuple.start();
  }
  
  public void append(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new Tuple(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(mAnimationListener);
    mTuples.add(paramArrayOfInt);
  }
  
  public void setState(int[] paramArrayOfInt)
  {
    int j = mTuples.size();
    int i = 0;
    while (i < j)
    {
      localTuple = (Tuple)mTuples.get(i);
      if (StateSet.stateSetMatches(mSpecs, paramArrayOfInt))
      {
        paramArrayOfInt = localTuple;
        break label55;
      }
      i += 1;
    }
    paramArrayOfInt = null;
    label55:
    Tuple localTuple = mLastMatch;
    if (paramArrayOfInt == localTuple) {
      return;
    }
    if (localTuple != null) {
      cancel();
    }
    mLastMatch = paramArrayOfInt;
    if (paramArrayOfInt != null) {
      start(paramArrayOfInt);
    }
  }
  
  public void start()
  {
    ValueAnimator localValueAnimator = mRunningAnimation;
    if (localValueAnimator != null)
    {
      localValueAnimator.end();
      mRunningAnimation = null;
    }
  }
  
  class Tuple
  {
    final ValueAnimator mAnimation;
    
    Tuple(ValueAnimator paramValueAnimator)
    {
      mAnimation = paramValueAnimator;
    }
  }
}
