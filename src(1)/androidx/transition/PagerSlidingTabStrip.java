package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class PagerSlidingTabStrip
  extends Frame
{
  private static boolean e;
  private static boolean y;
  
  PagerSlidingTabStrip() {}
  
  public void a(View paramView, Matrix paramMatrix)
  {
    if (e)
    {
      try
      {
        paramView.transformMatrixToGlobal(paramMatrix);
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
  
  public void draw(View paramView, Matrix paramMatrix)
  {
    if (y)
    {
      try
      {
        paramView.transformMatrixToLocal(paramMatrix);
        return;
      }
      catch (NoSuchMethodError paramView)
      {
        for (;;) {}
      }
      y = false;
      return;
    }
  }
}
