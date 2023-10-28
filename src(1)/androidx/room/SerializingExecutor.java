package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class SerializingExecutor
  implements Executor
{
  private final Executor executor;
  private Runnable loader;
  private final ArrayDeque<Runnable> pool = new ArrayDeque();
  
  SerializingExecutor(Executor paramExecutor)
  {
    executor = paramExecutor;
  }
  
  void execute()
  {
    try
    {
      Runnable localRunnable = (Runnable)pool.poll();
      loader = localRunnable;
      if (localRunnable != null) {
        executor.execute(localRunnable);
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
    try
    {
      pool.offer(new AsyncExecutor.1(this, paramRunnable));
      if (loader == null) {
        execute();
      }
      return;
    }
    catch (Throwable paramRunnable)
    {
      throw paramRunnable;
    }
  }
}
