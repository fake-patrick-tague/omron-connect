package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.util.proxy.ProxyApi;
import com.google.android.gms.auth.util.proxy.ProxyRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;

public final class zzar
  implements ProxyApi
{
  public zzar() {}
  
  public final PendingResult getSpatulaHeader(GoogleApiClient paramGoogleApiClient)
  {
    Preconditions.checkNotNull(paramGoogleApiClient);
    return paramGoogleApiClient.execute(new zzau(this, paramGoogleApiClient));
  }
  
  public final PendingResult performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest)
  {
    Preconditions.checkNotNull(paramGoogleApiClient);
    Preconditions.checkNotNull(paramProxyRequest);
    return paramGoogleApiClient.execute(new zzas(this, paramGoogleApiClient, paramProxyRequest));
  }
}
