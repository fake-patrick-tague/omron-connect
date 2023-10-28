package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import v7.v7.package_13.ViewCompat;

public class Fade
  extends Visibility
{
  public Fade(int paramInt)
  {
    add(paramInt);
  }
  
  private static float a(Label paramLabel, float paramFloat)
  {
    float f = paramFloat;
    if (paramLabel != null)
    {
      paramLabel = (Float)m.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramLabel != null) {
        f = paramLabel.floatValue();
      }
    }
    return f;
  }
  
  private Animator a(final View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    Item.set(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, Item.c, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new b(paramView));
    next(new a(paramView));
    return localObjectAnimator;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, Label paramLabel1, Label paramLabel2)
  {
    Item.set(paramView);
    return a(paramView, a(paramLabel1, 1.0F), 0.0F);
  }
  
  public Animator b(ViewGroup paramViewGroup, View paramView, Label paramLabel1, Label paramLabel2)
  {
    float f1 = 0.0F;
    float f2 = a(paramLabel1, 0.0F);
    if (f2 != 1.0F) {
      f1 = f2;
    }
    return a(paramView, f1, 1.0F);
  }
  
  public void draw(Label paramLabel)
  {
    super.draw(paramLabel);
    m.put("android:fade:transitionAlpha", Float.valueOf(Item.d(a)));
  }
  
  class a
    extends ActionMenuItemView
  {
    a(View paramView) {}
    
    public void c(Transition paramTransition)
    {
      Item.set(paramView, 1.0F);
      Item.b(paramView);
      paramTransition.recycle(this);
    }
  }
  
  private static class b
    extends AnimatorListenerAdapter
  {
    private boolean mCancelled = false;
    private final View this$0;
    
    b(View paramView)
    {
      this$0 = paramView;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      Item.set(this$0, 1.0F);
      if (mCancelled) {
        this$0.setLayerType(0, null);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if ((ViewCompat.shouldRunOnHWLayer(this$0)) && (this$0.getLayerType() == 0))
      {
        mCancelled = true;
        this$0.setLayerType(2, null);
      }
    }
  }
}
