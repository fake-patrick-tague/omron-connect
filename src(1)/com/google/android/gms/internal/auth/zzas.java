package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.util.proxy.ProxyRequest;
import com.google.android.gms.common.package_12.GoogleApiClient;

final class zzas
  extends zzap
{
  zzas(zzar paramZzar, GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void removeAccount(Context paramContext, zzan paramZzan)
    throws RemoteException
  {
    paramZzan.lock(new zzat(this), zzce);
  }
}
