package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.package_12.GoogleApiClient;

abstract class Response<R extends Result>
  extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<R, zzq>
{
  public Response(GoogleApiClient paramGoogleApiClient)
  {
    super(SpecialListsDueProperty.Unit.FIXED, paramGoogleApiClient);
  }
}
