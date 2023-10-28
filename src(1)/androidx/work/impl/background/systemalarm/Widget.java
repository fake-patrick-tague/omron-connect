package androidx.work.impl.background.systemalarm;

import android.content.Intent;

class Widget
  implements Runnable
{
  private final f b;
  private final Intent i;
  private final int j;
  
  Widget(f paramF, Intent paramIntent, int paramInt)
  {
    b = paramF;
    i = paramIntent;
    j = paramInt;
  }
  
  public void run()
  {
    b.a(i, j);
  }
}
