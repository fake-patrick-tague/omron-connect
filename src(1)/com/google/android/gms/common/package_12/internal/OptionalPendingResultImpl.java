package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.PendingResult.StatusListener;
import com.google.android.gms.common.package_12.ResultCallback;
import com.google.android.gms.common.package_12.ResultTransform;
import com.google.android.gms.common.package_12.TransformedResult;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends com.google.android.gms.common.api.Result>
  extends OptionalPendingResult<R>
{
  private final com.google.android.gms.common.api.internal.BasePendingResult<R> condition;
  
  public OptionalPendingResultImpl(PendingResult paramPendingResult)
  {
    condition = ((BasePendingResult)paramPendingResult);
  }
  
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    condition.addStatusListener(paramStatusListener);
  }
  
  public final com.google.android.gms.common.package_12.Result await()
  {
    return condition.await();
  }
  
  public final com.google.android.gms.common.package_12.Result await(long paramLong, TimeUnit paramTimeUnit)
  {
    return condition.await(paramLong, paramTimeUnit);
  }
  
  public final void cancel()
  {
    condition.cancel();
  }
  
  public final com.google.android.gms.common.package_12.Result getResponses()
  {
    if (condition.isReady())
    {
      TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
      return condition.await(0L, localTimeUnit);
    }
    throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
  }
  
  public final boolean isCanceled()
  {
    return condition.isCanceled();
  }
  
  public final boolean isDone()
  {
    return condition.isReady();
  }
  
  public final void setResultCallback(ResultCallback paramResultCallback)
  {
    condition.setResultCallback(paramResultCallback);
  }
  
  public final void setResultCallback(ResultCallback paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    condition.setResultCallback(paramResultCallback, paramLong, paramTimeUnit);
  }
  
  public final TransformedResult then(ResultTransform paramResultTransform)
  {
    return condition.then(paramResultTransform);
  }
}
