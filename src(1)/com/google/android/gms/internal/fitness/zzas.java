package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient;

abstract class zzas
  extends zzaq<com.google.android.gms.common.api.Status>
{
  zzas(GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected com.google.android.gms.common.package_12.Status parse(com.google.android.gms.common.package_12.Status paramStatus)
  {
    Preconditions.checkArgument(paramStatus.isSuccess() ^ true);
    return paramStatus;
  }
}
