package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;

public final class zzcw
  implements ConfigApi
{
  public zzcw() {}
  
  public final PendingResult createCustomDataType(GoogleApiClient paramGoogleApiClient, DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    return paramGoogleApiClient.execute(new zzcz(this, paramGoogleApiClient, paramDataTypeCreateRequest));
  }
  
  public final PendingResult disableFit(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.execute(new zzdb(this, paramGoogleApiClient));
  }
  
  public final PendingResult readDataType(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.enqueue(new zzcy(this, paramGoogleApiClient, paramString));
  }
}
