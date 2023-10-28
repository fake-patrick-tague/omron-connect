package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.work.Log;
import androidx.work.impl.f;

public class RescheduleReceiver
  extends BroadcastReceiver
{
  private static final String a = Log.getInstance("RescheduleReceiver");
  
  public RescheduleReceiver() {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.get().append(a, String.format("Received intent %s", new Object[] { paramIntent }), new Throwable[0]);
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        f.a(paramContext).a(goAsync());
        return;
      }
      catch (IllegalStateException paramContext)
      {
        Log.get().get(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", (Throwable[])new Throwable[] { paramContext });
        return;
      }
    }
    paramContext.startService(b.makeInitIntent(paramContext));
  }
}
