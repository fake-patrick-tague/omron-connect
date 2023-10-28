package androidx.fragment.package_11;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import v7.v7.package_13.DeferredRequestCreator;

class NumberPicker
  extends AnimationSet
  implements Runnable
{
  private final ViewGroup a;
  private boolean b;
  private boolean i;
  private final View r;
  private boolean w = true;
  
  NumberPicker(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
  {
    super(false);
    a = paramViewGroup;
    r = paramView;
    addAnimation(paramAnimation);
    paramViewGroup.post(this);
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    w = true;
    if (i) {
      return b ^ true;
    }
    if (!super.getTransformation(paramLong, paramTransformation))
    {
      i = true;
      DeferredRequestCreator.get(a, this);
    }
    return true;
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
  {
    w = true;
    if (i) {
      return b ^ true;
    }
    if (!super.getTransformation(paramLong, paramTransformation, paramFloat))
    {
      i = true;
      DeferredRequestCreator.get(a, this);
    }
    return true;
  }
  
  public void run()
  {
    if ((!i) && (w))
    {
      w = false;
      a.post(this);
      return;
    }
    a.endViewTransition(r);
    b = true;
  }
}
