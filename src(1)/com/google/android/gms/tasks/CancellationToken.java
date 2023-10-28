package com.google.android.gms.tasks;

public abstract class CancellationToken
{
  public CancellationToken() {}
  
  public abstract boolean isCancellationRequested();
  
  public abstract CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener);
}
