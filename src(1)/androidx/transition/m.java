package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

public class m
{
  private Runnable q;
  private ViewGroup r;
  
  public static m a(ViewGroup paramViewGroup)
  {
    return (m)paramViewGroup.getTag(R.id.bottom);
  }
  
  static void b(ViewGroup paramViewGroup, m paramM)
  {
    paramViewGroup.setTag(R.id.bottom, paramM);
  }
  
  public void a()
  {
    if (a(r) == this)
    {
      Runnable localRunnable = q;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
}
