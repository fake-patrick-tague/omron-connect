package com.google.android.gms.common.package_12.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.signin.Connection;
import java.util.concurrent.locks.Lock;

final class zaat
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final void onConnected(Bundle paramBundle)
  {
    paramBundle = (ClientSettings)Preconditions.checkNotNull(zaaw.access$getData(this$0));
    ((Connection)Preconditions.checkNotNull(zaaw.access$getConnection(this$0))).add(new zaar(this$0));
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zaaw.access$getLock(this$0).lock();
    try
    {
      boolean bool = zaaw.f(this$0, paramConnectionResult);
      if (bool)
      {
        zaaw.ignore(this$0);
        zaaw.access$getLog(this$0);
      }
      else
      {
        zaaw.append(this$0, paramConnectionResult);
      }
      zaaw.access$getLock(this$0).unlock();
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      zaaw.access$getLock(this$0).unlock();
      throw paramConnectionResult;
    }
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}
