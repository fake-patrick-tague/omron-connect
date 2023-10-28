package androidx.transition;

import android.view.View;

class Plot
  extends PagerSlidingTabStrip
{
  private static boolean e;
  
  Plot() {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (e)
    {
      try
      {
        paramView.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      catch (NoSuchMethodError paramView)
      {
        for (;;) {}
      }
      e = false;
      return;
    }
  }
}
