package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.package_12.PendingResult.StatusListener;
import com.google.android.gms.common.package_12.ResultCallback;
import com.google.android.gms.common.package_12.ResultTransform;
import com.google.android.gms.common.package_12.TransformedResult;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public abstract class PendingResultFacade<A extends com.google.android.gms.common.api.Result, B extends com.google.android.gms.common.api.Result>
  extends PendingResult<B>
{
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final com.google.android.gms.common.package_12.Result await()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final com.google.android.gms.common.package_12.Result await(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void cancel()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final boolean isCanceled()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void setResultCallback(ResultCallback paramResultCallback)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void setResultCallback(ResultCallback paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final TransformedResult then(ResultTransform paramResultTransform)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
