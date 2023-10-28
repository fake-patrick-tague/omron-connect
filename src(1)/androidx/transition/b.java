package androidx.transition;

import android.os.Build.VERSION;
import android.view.View;

class b
  extends Plot
{
  private static boolean h;
  
  b() {}
  
  public void a(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT == 28)
    {
      super.a(paramView, paramInt);
      return;
    }
    if (h)
    {
      try
      {
        paramView.setTransitionVisibility(paramInt);
        return;
      }
      catch (NoSuchMethodError paramView)
      {
        for (;;) {}
      }
      h = false;
      return;
    }
  }
}
