package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;

final class AsynchronousEventListenerDecorator
  implements zzgz
{
  public final zzci handler;
  
  AsynchronousEventListenerDecorator(AppMeasurementDynamiteService paramAppMeasurementDynamiteService, zzci paramZzci)
  {
    handler = paramZzci;
  }
  
  public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    zzci localZzci = handler;
    try
    {
      localZzci.sendHit(paramString1, paramString2, paramBundle, paramLong);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramString2 = eventListener.mFolder;
      if (paramString2 != null) {
        paramString2.zzay().hasNext().append("Event listener threw exception", paramString1);
      }
    }
  }
}
