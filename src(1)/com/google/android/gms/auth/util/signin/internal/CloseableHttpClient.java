package com.google.android.gms.auth.util.signin.internal;

import com.google.android.gms.auth.api.signin.internal.zbe;
import com.google.android.gms.auth.util.Auth;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.package_12.GoogleApiClient;

abstract class CloseableHttpClient<R extends Result>
  extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<R, zbe>
{
  public CloseableHttpClient(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.GOOGLE_SIGN_IN_API, paramGoogleApiClient);
  }
}
