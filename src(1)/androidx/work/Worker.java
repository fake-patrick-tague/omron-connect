package androidx.work;

import androidx.work.impl.utils.futures.b;
import java.util.concurrent.Executor;

public abstract class Worker
  extends ListenableWorker
{
  b<ListenableWorker.a> instance;
  
  public Worker(android.content.Context paramContext, WorkerParameters paramWorkerParameters)
  {
    super(paramContext, paramWorkerParameters);
  }
  
  public final com.google.common.util.concurrent.Object get()
  {
    instance = androidx.work.impl.utils.futures.Context.getInstance();
    build().execute(new a());
    return instance;
  }
  
  public abstract ListenableWorker.a run();
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      try
      {
        ListenableWorker.a localA = run();
        instance.get(localA);
        return;
      }
      catch (Throwable localThrowable)
      {
        instance.get(localThrowable);
      }
    }
  }
}
