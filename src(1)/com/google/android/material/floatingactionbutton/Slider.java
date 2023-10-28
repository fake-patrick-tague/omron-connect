package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import java.util.List;
import org.org.org.ui.utils.Attribute;

abstract interface Slider
{
  public abstract void clear();
  
  public abstract List create();
  
  public abstract Attribute isDragging();
  
  public abstract void onAnimationStart(Animator paramAnimator);
  
  public abstract void resume(ExtendedFloatingActionButton.f paramF);
  
  public abstract void setBackgroundColor();
  
  public abstract AnimatorSet setDuration();
  
  public abstract void setPriority(Attribute paramAttribute);
  
  public abstract boolean setPriority();
  
  public abstract void start();
}
