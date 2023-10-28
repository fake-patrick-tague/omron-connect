package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzdw
  extends zzdt
{
  zzdw(zzed paramZzed, Bundle paramBundle, Activity paramActivity)
  {
    super(this$0, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    Bundle localBundle1;
    if (inverse != null)
    {
      Bundle localBundle2 = new Bundle();
      localBundle1 = localBundle2;
      if (inverse.containsKey("com.google.app_measurement.screen_service"))
      {
        Object localObject = inverse.get("com.google.app_measurement.screen_service");
        localBundle1 = localBundle2;
        if ((localObject instanceof Bundle))
        {
          localBundle2.putBundle("com.google.app_measurement.screen_service", (Bundle)localObject);
          localBundle1 = localBundle2;
        }
      }
    }
    else
    {
      localBundle1 = null;
    }
    ((zzcc)Preconditions.checkNotNull(zzee.append(low.this$0))).onActivityCreated(ObjectWrapper.wrap(high), localBundle1, high);
  }
}
