package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Label;
import androidx.transition.Transition;
import java.util.Map;

public class LayoutManager
  extends Transition
{
  public LayoutManager() {}
  
  private void a(Label paramLabel)
  {
    Object localObject = a;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      m.put("android:textscale:scale", Float.valueOf(((View)localObject).getScaleX()));
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, Label paramLabel1, Label paramLabel2)
  {
    if ((paramLabel1 != null) && (paramLabel2 != null) && ((a instanceof TextView)))
    {
      paramViewGroup = a;
      if (!(paramViewGroup instanceof TextView)) {
        return null;
      }
      paramViewGroup = (TextView)paramViewGroup;
      paramLabel1 = m;
      paramLabel2 = m;
      Object localObject = paramLabel1.get("android:textscale:scale");
      float f2 = 1.0F;
      float f1;
      if (localObject != null) {
        f1 = ((Float)paramLabel1.get("android:textscale:scale")).floatValue();
      } else {
        f1 = 1.0F;
      }
      if (paramLabel2.get("android:textscale:scale") != null) {
        f2 = ((Float)paramLabel2.get("android:textscale:scale")).floatValue();
      }
      if (f1 == f2) {
        return null;
      }
      paramLabel1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
      paramLabel1.addUpdateListener(new BaseDismissAnimation.5(this, paramViewGroup));
      return paramLabel1;
    }
    return null;
  }
  
  public void draw(Label paramLabel)
  {
    a(paramLabel);
  }
  
  public void write(Label paramLabel)
  {
    a(paramLabel);
  }
}
