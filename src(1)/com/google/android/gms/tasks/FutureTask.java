package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class FutureTask
  implements Runnable
{
  FutureTask(AbstractDataSource paramAbstractDataSource, Callable paramCallable) {}
  
  public final void run()
  {
    AbstractDataSource localAbstractDataSource = this$0;
    Callable localCallable = callable;
    try
    {
      localAbstractDataSource.close(localCallable.call());
      return;
    }
    catch (Throwable localThrowable)
    {
      this$0.close(new RuntimeException(localThrowable));
      return;
    }
    catch (Exception localException)
    {
      this$0.close(localException);
    }
  }
}
