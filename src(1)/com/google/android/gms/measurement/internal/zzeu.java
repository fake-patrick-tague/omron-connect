package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class zzeu
  extends zzkn
{
  public zzeu(zzkz paramZzkz)
  {
    super(paramZzkz);
  }
  
  protected final boolean registerAlarm()
  {
    return false;
  }
  
  public final boolean send()
  {
    size();
    ConnectivityManager localConnectivityManager = (ConnectivityManager)this$0.zzau().getSystemService("connectivity");
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localConnectivityManager != null) {}
    try
    {
      localObject1 = localConnectivityManager.getActiveNetworkInfo();
      return (localObject1 != null) && (((NetworkInfo)localObject1).isConnected());
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
}
