package androidx.appcompat.app;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

class SerializingExecutor
  implements Executor
{
  final Executor executor;
  private final Object internalLock = new Object();
  Runnable isThreadScheduled;
  final Queue<Runnable> waitQueue = new ArrayDeque();
  
  SerializingExecutor(Executor paramExecutor)
  {
    executor = paramExecutor;
  }
  
  protected void execute()
  {
    Object localObject = internalLock;
    try
    {
      Runnable localRunnable = (Runnable)waitQueue.poll();
      isThreadScheduled = localRunnable;
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
    Object localObject = internalLock;
    try
    {
      waitQueue.add(new FileUtils.23(this, paramRunnable));
      if (isThreadScheduled == null) {
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
