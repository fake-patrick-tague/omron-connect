package androidx.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

class XYPlot
{
  private static boolean K;
  
  static MenuItem a(ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new h(paramViewGroup);
    }
    return o.a(paramViewGroup);
  }
  
  static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29)
    {
      paramViewGroup.suppressLayout(paramBoolean);
      return;
    }
    if (i >= 18)
    {
      b(paramViewGroup, paramBoolean);
      return;
    }
    LayoutManager.init(paramViewGroup, paramBoolean);
  }
  
  private static void b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (K)
    {
      try
      {
        paramViewGroup.suppressLayout(paramBoolean);
        return;
      }
      catch (NoSuchMethodError paramViewGroup)
      {
        for (;;) {}
      }
      K = false;
      return;
    }
  }
}
