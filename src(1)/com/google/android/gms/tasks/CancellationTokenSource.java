package com.google.android.gms.tasks;

public class CancellationTokenSource
{
  private final Notifier this$0 = new Notifier();
  
  public CancellationTokenSource() {}
  
  public void cancel()
  {
    this$0.finish();
  }
  
  public CancellationToken getToken()
  {
    return this$0;
  }
}
