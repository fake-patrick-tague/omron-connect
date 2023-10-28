package com.google.android.gms.tasks;

public class TaskCompletionSource<TResult>
{
  private final AbstractDataSource this$0 = new AbstractDataSource();
  
  public TaskCompletionSource() {}
  
  public TaskCompletionSource(CancellationToken paramCancellationToken)
  {
    paramCancellationToken.onCanceledRequested(new TwitterAdapter(this));
  }
  
  public Task getTask()
  {
    return this$0;
  }
  
  public void setException(Exception paramException)
  {
    this$0.close(paramException);
  }
  
  public void setResult(Object paramObject)
  {
    this$0.close(paramObject);
  }
  
  public boolean trySetException(Exception paramException)
  {
    return this$0.get(paramException);
  }
  
  public boolean trySetResult(Object paramObject)
  {
    return this$0.get(paramObject);
  }
}
