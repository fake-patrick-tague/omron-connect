package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzbq;

public final class zzff
  implements ServiceConnection
{
  private final String preferencesName;
  
  zzff(zzfg paramZzfg, String paramString)
  {
    preferencesName = paramString;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (paramIBinder != null) {
      try
      {
        paramComponentName = zzbq.asInterface(paramIBinder);
        if (paramComponentName == null)
        {
          log.this$0.zzay().hasNext().append("Install Referrer Service implementation was not found");
          return;
        }
        log.this$0.zzay().next().append("Install Referrer Service connected");
        paramIBinder = log.this$0.zzaz();
        paramIBinder.append(new zzfe(this, paramComponentName, this));
        return;
      }
      catch (RuntimeException paramComponentName)
      {
        log.this$0.zzay().hasNext().append("Exception occurred while calling Install Referrer API", paramComponentName);
        return;
      }
    }
    log.this$0.zzay().hasNext().append("Install Referrer connection returned with null binder");
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    log.this$0.zzay().next().append("Install Referrer Service disconnected");
  }
}
