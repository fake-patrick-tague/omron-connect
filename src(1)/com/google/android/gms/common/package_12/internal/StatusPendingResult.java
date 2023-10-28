package com.google.android.gms.common.package_12.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.package_12.GoogleApiClient;

@KeepForSdk
public class StatusPendingResult
  extends com.google.android.gms.common.api.internal.BasePendingResult<Status>
{
  public StatusPendingResult(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public StatusPendingResult(GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
}
