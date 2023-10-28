package com.google.android.gms.fitness;

import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;

@Deprecated
public abstract interface ConfigApi
{
  public abstract PendingResult createCustomDataType(GoogleApiClient paramGoogleApiClient, DataTypeCreateRequest paramDataTypeCreateRequest);
  
  public abstract PendingResult disableFit(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult readDataType(GoogleApiClient paramGoogleApiClient, String paramString);
}
