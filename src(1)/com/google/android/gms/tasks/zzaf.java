package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

final class zzaf<T>
  implements zzae<T>
{
  private final int active;
  private int current;
  private Exception error;
  private boolean old;
  private int request;
  private final AbstractDataSource this$0;
  private final Object type = new Object();
  private int url;
  
  public zzaf(int paramInt, AbstractDataSource paramAbstractDataSource)
  {
    active = paramInt;
    this$0 = paramAbstractDataSource;
  }
  
  private final void close()
  {
    if (request + url + current == active)
    {
      if (error != null)
      {
        AbstractDataSource localAbstractDataSource = this$0;
        int i = url;
        int j = active;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append(" out of ");
        localStringBuilder.append(j);
        localStringBuilder.append(" underlying tasks failed");
        localAbstractDataSource.close(new ExecutionException(localStringBuilder.toString(), error));
        return;
      }
      if (old)
      {
        this$0.close();
        return;
      }
      this$0.close(null);
    }
  }
  
  public final void onCanceled()
  {
    Object localObject = type;
    try
    {
      current += 1;
      old = true;
      close();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void onFailure(Exception paramException)
  {
    Object localObject = type;
    try
    {
      url += 1;
      error = paramException;
      close();
      return;
    }
    catch (Throwable paramException)
    {
      throw paramException;
    }
  }
  
  public final void onSuccess(Object paramObject)
  {
    paramObject = type;
    try
    {
      request += 1;
      close();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
