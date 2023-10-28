package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Intent;
import androidx.work.Log;

public class ConstraintProxyUpdateReceiver
  extends BroadcastReceiver
{
  static final String b = Log.getInstance("ConstrntProxyUpdtRecvr");
  
  public ConstraintProxyUpdateReceiver() {}
  
  public static Intent createIntent(android.content.Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Intent localIntent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
    localIntent.setComponent(new ComponentName(paramContext, ConstraintProxyUpdateReceiver.class));
    localIntent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", paramBoolean1).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", paramBoolean2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", paramBoolean3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", paramBoolean4);
    return localIntent;
  }
  
  public void onReceive(final android.content.Context paramContext, final Intent paramIntent)
  {
    if (paramIntent != null) {
      localObject = paramIntent.getAction();
    } else {
      localObject = null;
    }
    if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(localObject))
    {
      Log.get().append(b, String.format("Ignoring unknown action %s", new Object[] { localObject }), new Throwable[0]);
      return;
    }
    Object localObject = goAsync();
    androidx.work.impl.f.a(paramContext).i().get(new a(paramIntent, paramContext, (BroadcastReceiver.PendingResult)localObject));
  }
  
  class a
    implements Runnable
  {
    a(Intent paramIntent, android.content.Context paramContext, BroadcastReceiver.PendingResult paramPendingResult) {}
    
    public void run()
    {
      Object localObject = this;
      try
      {
        Intent localIntent = paramIntent;
        a localA = this;
        localObject = localA;
        boolean bool1 = localIntent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
        localObject = localA;
        localIntent = paramIntent;
        localObject = localA;
        boolean bool2 = localIntent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
        localObject = localA;
        localIntent = paramIntent;
        localObject = localA;
        boolean bool3 = localIntent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
        localObject = localA;
        localIntent = paramIntent;
        localObject = localA;
        boolean bool4 = localIntent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
        localObject = localA;
        Log.get().append(ConstraintProxyUpdateReceiver.b, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) }), new Throwable[0]);
        localObject = localA;
        androidx.work.impl.utils.Context.get(paramContext, ConstraintProxy.BatteryNotLowProxy.class, bool1);
        localObject = localA;
        androidx.work.impl.utils.Context.get(paramContext, ConstraintProxy.BatteryChargingProxy.class, bool2);
        localObject = localA;
        androidx.work.impl.utils.Context.get(paramContext, ConstraintProxy.StorageNotLowProxy.class, bool3);
        localObject = localA;
        androidx.work.impl.utils.Context.get(paramContext, ConstraintProxy.NetworkStateProxy.class, bool4);
        d.finish();
        return;
      }
      catch (Throwable localThrowable)
      {
        d.finish();
        throw localThrowable;
      }
    }
  }
}
