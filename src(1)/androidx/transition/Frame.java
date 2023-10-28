package androidx.transition;

import android.view.View;

class Frame
  extends a
{
  private static boolean h;
  
  Frame() {}
  
  public float a(View paramView)
  {
    if (h) {}
    try
    {
      float f = paramView.getTransitionAlpha();
      return f;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;) {}
    }
    h = false;
    return paramView.getAlpha();
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (h) {}
    try
    {
      paramView.setTransitionAlpha(paramFloat);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;) {}
    }
    h = false;
    paramView.setAlpha(paramFloat);
  }
  
  public void b(View paramView) {}
  
  public void set(View paramView) {}
}
