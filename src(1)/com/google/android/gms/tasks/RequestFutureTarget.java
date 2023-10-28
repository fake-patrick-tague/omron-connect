package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class RequestFutureTarget
  implements Object
{
  private final Executor client;
  private final java.lang.Object handler = new java.lang.Object();
  private OnSuccessListener request;
  
  public RequestFutureTarget(Executor paramExecutor, OnSuccessListener paramOnSuccessListener)
  {
    client = paramExecutor;
    request = paramOnSuccessListener;
  }
  
  public final void clear()
  {
    java.lang.Object localObject = handler;
    try
    {
      request = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void run(Task paramTask)
  {
    if (paramTask.isSuccessful())
    {
      java.lang.Object localObject = handler;
      try
      {
        if (request == null) {
          return;
        }
        client.execute(new Reader(this, paramTask));
        return;
      }
      catch (Throwable paramTask)
      {
        throw paramTask;
      }
    }
  }
}
