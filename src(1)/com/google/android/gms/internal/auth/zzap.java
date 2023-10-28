package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.util.AuthProxy;
import com.google.android.gms.common.package_12.GoogleApiClient;

abstract class zzap
  extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<ProxyApi.ProxyResult, zzak>
{
  public zzap(GoogleApiClient paramGoogleApiClient)
  {
    super(AuthProxy.FIXED, paramGoogleApiClient);
  }
  
  protected abstract void removeAccount(Context paramContext, zzan paramZzan)
    throws RemoteException;
}
