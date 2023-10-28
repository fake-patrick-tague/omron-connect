package androidx.concurrent.futures;

import java.util.concurrent.Executor;

public enum DirectExecutor
  implements Executor
{
  static
  {
    DirectExecutor localDirectExecutor = new DirectExecutor("INSTANCE", 0);
    vcard = localDirectExecutor;
    c = new DirectExecutor[] { localDirectExecutor };
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
