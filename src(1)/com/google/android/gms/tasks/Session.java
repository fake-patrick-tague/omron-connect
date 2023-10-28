package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class Session
  implements Object
{
  private final java.lang.Object data = new java.lang.Object();
  private OnFailureListener id;
  private final Executor socket;
  
  public Session(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    socket = paramExecutor;
    id = paramOnFailureListener;
  }
  
  public final void clear()
  {
    java.lang.Object localObject = data;
    try
    {
      id = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void run(Task paramTask)
  {
    if ((!paramTask.isSuccessful()) && (!paramTask.isCanceled()))
    {
      java.lang.Object localObject = data;
      try
      {
        if (id == null) {
          return;
        }
        socket.execute(new Parallel.TaskRunnable(this, paramTask));
        return;
      }
      catch (Throwable paramTask)
      {
        throw paramTask;
      }
    }
  }
}
