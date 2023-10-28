package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class Comment
  implements Object
{
  private final Executor id;
  private final java.lang.Object key = new java.lang.Object();
  private OnCanceledListener value;
  
  public Comment(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    id = paramExecutor;
    value = paramOnCanceledListener;
  }
  
  public final void clear()
  {
    java.lang.Object localObject = key;
    try
    {
      value = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void run(Task paramTask)
  {
    if (paramTask.isCanceled())
    {
      paramTask = key;
      try
      {
        if (value == null) {
          return;
        }
        id.execute(new Channel(this));
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
}
