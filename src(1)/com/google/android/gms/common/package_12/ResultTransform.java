package com.google.android.gms.common.package_12;

import com.google.android.gms.common.package_12.internal.zacp;

public abstract class ResultTransform<R extends com.google.android.gms.common.api.Result, S extends com.google.android.gms.common.api.Result>
{
  public ResultTransform() {}
  
  public final PendingResult createFailedResult(Status paramStatus)
  {
    return new zacp(paramStatus);
  }
  
  public Status onFailure(Status paramStatus)
  {
    return paramStatus;
  }
  
  public abstract PendingResult onSuccess(Result paramResult);
}
