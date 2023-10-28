package com.google.android.gms.common.package_12;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.internal.BasePendingResult;
import com.google.android.gms.common.package_12.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.package_12.internal.StatusPendingResult;

public final class PendingResults
{
  private PendingResults() {}
  
  public static PendingResult canceledPendingResult()
  {
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    localStatusPendingResult.cancel();
    return localStatusPendingResult;
  }
  
  public static PendingResult canceledPendingResult(Result paramResult)
  {
    Preconditions.checkNotNull(paramResult, "Result must not be null");
    boolean bool;
    if (paramResult.getStatus().getStatusCode() == 16) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Status code must be CommonStatusCodes.CANCELED");
    paramResult = new SearchableActivity(paramResult);
    paramResult.cancel();
    return paramResult;
  }
  
  public static PendingResult immediateFailedResult(Result paramResult, GoogleApiClient paramGoogleApiClient)
  {
    Preconditions.checkNotNull(paramResult, "Result must not be null");
    Preconditions.checkArgument(paramResult.getStatus().isSuccess() ^ true, "Status code must not be SUCCESS");
    paramGoogleApiClient = new AboutActivity.2(paramGoogleApiClient, paramResult);
    paramGoogleApiClient.setResult(paramResult);
    return paramGoogleApiClient;
  }
  
  public static OptionalPendingResult immediatePendingResult(Result paramResult)
  {
    Preconditions.checkNotNull(paramResult, "Result must not be null");
    LogActivity.1 local1 = new LogActivity.1(null);
    local1.setResult(paramResult);
    return new OptionalPendingResultImpl(local1);
  }
  
  public static OptionalPendingResult immediatePendingResult(Result paramResult, GoogleApiClient paramGoogleApiClient)
  {
    Preconditions.checkNotNull(paramResult, "Result must not be null");
    paramGoogleApiClient = new LogActivity.1(paramGoogleApiClient);
    paramGoogleApiClient.setResult(paramResult);
    return new OptionalPendingResultImpl(paramGoogleApiClient);
  }
  
  public static PendingResult immediatePendingResult(Status paramStatus)
  {
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    localStatusPendingResult.setResult(paramStatus);
    return localStatusPendingResult;
  }
  
  public static PendingResult immediatePendingResult(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    paramGoogleApiClient = new StatusPendingResult(paramGoogleApiClient);
    paramGoogleApiClient.setResult(paramStatus);
    return paramGoogleApiClient;
  }
}
