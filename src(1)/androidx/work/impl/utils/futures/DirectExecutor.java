package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

 enum DirectExecutor
  implements Executor
{
  static
  {
    DirectExecutor localDirectExecutor = new DirectExecutor("INSTANCE", 0);
    options = localDirectExecutor;
    values = new DirectExecutor[] { localDirectExecutor };
  }
  
  public void execute(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public String toString()
  {
    return "DirectExecutor";
  }
}
