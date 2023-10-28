package com.google.android.gms.common.package_12;

import android.os.Looper;

final class SearchableActivity<R extends com.google.android.gms.common.api.Result>
  extends com.google.android.gms.common.api.internal.BasePendingResult<R>
{
  private final R lastResult;
  
  public SearchableActivity(Result paramResult)
  {
    super(Looper.getMainLooper());
    lastResult = paramResult;
  }
  
  protected final Result createFailedResult(Status paramStatus)
  {
    if (paramStatus.getStatusCode() == lastResult.getStatus().getStatusCode()) {
      return lastResult;
    }
    throw new UnsupportedOperationException("Creating failed results is not supported");
  }
}
