package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.util.AuthProxy;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.Status;

abstract class zzaq
  extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult, zzak>
{
  public zzaq(GoogleApiClient paramGoogleApiClient)
  {
    super(AuthProxy.FIXED, paramGoogleApiClient);
  }
  
  protected static com.google.android.gms.auth.util.proxy.ProxyApi.SpatulaHeaderResult getStation(Status paramStatus)
  {
    return new zzax(paramStatus);
  }
  
  protected abstract void e(Context paramContext, zzan paramZzan)
    throws RemoteException;
}
