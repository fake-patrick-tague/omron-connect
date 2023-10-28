package com.google.android.gms.internal.auth;

import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.Status;

final class MinimalHttpClient
  extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<com.google.android.gms.common.api.Result, zzr>
{
  MinimalHttpClient(BaseResource paramBaseResource, Attribute paramAttribute, GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    super(paramAttribute, paramGoogleApiClient);
  }
  
  protected final com.google.android.gms.common.package_12.Result createFailedResult(Status paramStatus)
  {
    return new TextureManager(paramStatus);
  }
}
