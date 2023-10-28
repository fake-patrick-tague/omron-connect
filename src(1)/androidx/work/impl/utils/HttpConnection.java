package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class HttpConnection
  implements Executor
{
  private final Object address;
  private final Executor executor;
  private volatile Runnable listener;
  private final ArrayDeque<g.a> pool;
  
  public HttpConnection(Executor paramExecutor)
  {
    executor = paramExecutor;
    pool = new ArrayDeque();
    address = new Object();
  }
  
  void execute()
  {
    Object localObject = address;
    try
    {
      Runnable localRunnable = (Runnable)pool.poll();
      listener = localRunnable;
      if (localRunnable != null) {
        executor.execute(listener);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    Object localObject = address;
    try
    {
      pool.add(new AsyncExecutor.1(this, paramRunnable));
      if (listener == null) {
        execute();
      }
      return;
    }
    catch (Throwable paramRunnable)
    {
      throw paramRunnable;
    }
  }
  
  public boolean get()
  {
    Object localObject = address;
    for (;;)
    {
      try
      {
        if (!pool.isEmpty())
        {
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
}
