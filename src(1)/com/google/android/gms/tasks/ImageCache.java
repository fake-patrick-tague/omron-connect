package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class ImageCache
  implements Object
{
  private final java.lang.Object mContext = new java.lang.Object();
  private OnCompleteListener queue;
  private final Executor request;
  
  public ImageCache(Executor paramExecutor, OnCompleteListener paramOnCompleteListener)
  {
    request = paramExecutor;
    queue = paramOnCompleteListener;
  }
  
  public final void clear()
  {
    java.lang.Object localObject = mContext;
    try
    {
      queue = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void run(Task paramTask)
  {
    java.lang.Object localObject = mContext;
    try
    {
      if (queue == null) {
        return;
      }
      request.execute(new ImageLoaderEngine.1(this, paramTask));
      return;
    }
    catch (Throwable paramTask)
    {
      throw paramTask;
    }
  }
}
