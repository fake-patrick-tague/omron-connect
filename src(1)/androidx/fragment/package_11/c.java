package androidx.fragment.package_11;

import android.animation.Animator;
import android.view.animation.Animation;

class c
{
  public final Animator a;
  public final Animation d;
  
  c(Animator paramAnimator)
  {
    d = null;
    a = paramAnimator;
    if (paramAnimator != null) {
      return;
    }
    throw new IllegalStateException("Animator cannot be null");
  }
  
  c(Animation paramAnimation)
  {
    d = paramAnimation;
    a = null;
    if (paramAnimation != null) {
      return;
    }
    throw new IllegalStateException("Animation cannot be null");
  }
}
