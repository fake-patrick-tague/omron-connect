package com.google.android.gms.tasks;

public abstract interface Continuation<TResult, TContinuationResult>
{
  public abstract Object then(Task paramTask)
    throws Exception;
}
