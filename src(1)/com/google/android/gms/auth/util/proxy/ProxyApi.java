package com.google.android.gms.auth.util.proxy;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.Result;

@KeepForSdk
public abstract interface ProxyApi
{
  public abstract PendingResult getSpatulaHeader(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest);
  
  @KeepForSdk
  public abstract interface ProxyResult
    extends Result
  {
    public abstract ProxyResponse getResponse();
  }
  
  @KeepForSdk
  public abstract interface SpatulaHeaderResult
    extends Result
  {
    public abstract String getSpatulaHeader();
  }
}
