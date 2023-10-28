package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.work.p;

public class x
  implements p
{
  private final Handler h = v7.v7.menu.x.a(Looper.getMainLooper());
  
  public x() {}
  
  public void a(long paramLong, Runnable paramRunnable)
  {
    h.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(Runnable paramRunnable)
  {
    h.removeCallbacks(paramRunnable);
  }
}
