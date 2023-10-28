package com.google.android.gms.common.package_12.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.Api.Client;
import java.util.Map;

final class zabt
  implements Runnable
{
  zabt(zabu paramZabu, ConnectionResult paramConnectionResult) {}
  
  public final void run()
  {
    Object localObject = this$0;
    localObject = (zabq)GoogleApiManager.get(this$0).get(zabu.access$getMHandler((zabu)localObject));
    if (localObject == null) {
      return;
    }
    if (val$t.isSuccess())
    {
      zabu.access$getLaunchGame(this$0, true);
      if (zabu.access$getMCamera(this$0).requiresSignIn())
      {
        zabu.access$getChangeCurrent(this$0);
        return;
      }
      zabu localZabu = this$0;
      try
      {
        zabu.access$getMCamera(localZabu).getRemoteService(null, zabu.access$getMCamera(localZabu).getScopesForConnectionlessNonSignIn());
        return;
      }
      catch (SecurityException localSecurityException)
      {
        Log.e("GoogleApiManager", "Failed to get service from broker. ", localSecurityException);
        zabu.access$getMCamera(this$0).disconnect("Failed to get service from broker.");
        ((zabq)localObject).next(new ConnectionResult(10), null);
        return;
      }
    }
    ((zabq)localObject).next(val$t, null);
  }
}
