package com.google.android.gms.tasks;

public abstract interface SuccessContinuation<TResult, TContinuationResult>
{
  public abstract Task then(Object paramObject)
    throws Exception;
}
