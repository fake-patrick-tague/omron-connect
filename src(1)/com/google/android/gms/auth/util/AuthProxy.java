package com.google.android.gms.auth.util;

import com.google.android.gms.auth.api.AuthProxyOptions;
import com.google.android.gms.auth.util.proxy.ProxyApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzar;

@KeepForSdk
public final class AuthProxy
{
  @KeepForSdk
  public static final Api<AuthProxyOptions> FIXED;
  @KeepForSdk
  public static final ProxyApi ProxyApi = new zzar();
  private static final com.google.android.gms.common.api.Api.ClientKey<zzak> zzah;
  private static final Api.AbstractClientBuilder<zzak, AuthProxyOptions> zzai;
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    zzah = localClientKey;
    MathArrays.OrderDirection localOrderDirection = new MathArrays.OrderDirection();
    zzai = localOrderDirection;
    FIXED = new Attribute("Auth.PROXY_API", localOrderDirection, localClientKey);
  }
  
  public AuthProxy() {}
}
