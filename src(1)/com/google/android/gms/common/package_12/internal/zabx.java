package com.google.android.gms.common.package_12.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zabx
  extends BroadcastReceiver
{
  private final zabw mCallBack;
  Context sContext;
  
  public zabx(zabw paramZabw)
  {
    mCallBack = paramZabw;
  }
  
  public final void close()
  {
    try
    {
      Context localContext = sContext;
      if (localContext != null) {
        localContext.unregisterReceiver(this);
      }
      sContext = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void init(Context paramContext)
  {
    sContext = paramContext;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getData();
    if (paramContext != null) {
      paramContext = paramContext.getSchemeSpecificPart();
    } else {
      paramContext = null;
    }
    if ("com.google.android.gms".equals(paramContext))
    {
      mCallBack.run();
      close();
    }
  }
}
