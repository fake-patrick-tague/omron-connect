package androidx.work.impl.workers;

import android.text.TextUtils;
import androidx.work.Label;
import androidx.work.ListenableWorker;
import androidx.work.ListenableWorker.a;
import androidx.work.Log;
import androidx.work.Pair;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.i;
import androidx.work.impl.ui.a;
import androidx.work.impl.utils.futures.b;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public class ConstraintTrackingWorker
  extends ListenableWorker
  implements a
{
  private static final String c = Log.getInstance("ConstraintTrkngWrkr");
  b<ListenableWorker.a> a;
  private ListenableWorker b;
  final Object i;
  private WorkerParameters input;
  volatile boolean s;
  
  public ConstraintTrackingWorker(android.content.Context paramContext, WorkerParameters paramWorkerParameters)
  {
    super(paramContext, paramWorkerParameters);
    input = paramWorkerParameters;
    i = new Object();
    s = false;
    a = androidx.work.impl.utils.futures.Context.getInstance();
  }
  
  public void a(List paramList) {}
  
  public boolean a()
  {
    ListenableWorker localListenableWorker = b;
    return (localListenableWorker != null) && (localListenableWorker.a());
  }
  
  public void b(List paramList)
  {
    Log.get().append(c, String.format("Constraints changed for %s", new Object[] { paramList }), new Throwable[0]);
    paramList = i;
    try
    {
      s = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public WorkDatabase c()
  {
    return androidx.work.impl.f.a(b()).a();
  }
  
  public androidx.work.impl.utils.asm.f f()
  {
    return androidx.work.impl.f.a(b()).i();
  }
  
  public com.google.common.util.concurrent.Object get()
  {
    build().execute(new a());
    return a;
  }
  
  public void pack()
  {
    super.pack();
    ListenableWorker localListenableWorker = b;
    if ((localListenableWorker != null) && (!localListenableWorker.equals())) {
      b.onPostInit();
    }
  }
  
  void reset()
  {
    a.get(ListenableWorker.a.crossProduct());
  }
  
  void run()
  {
    Object localObject1 = d().getText("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.get().get(c, "No worker to delegate to.", new Throwable[0]);
      reset();
      return;
    }
    Object localObject2 = remove().create(b(), (String)localObject1, input);
    b = ((ListenableWorker)localObject2);
    if (localObject2 == null)
    {
      Log.get().append(c, "No worker to delegate to.", new Throwable[0]);
      reset();
      return;
    }
    localObject2 = c().a().a(e().toString());
    if (localObject2 == null)
    {
      reset();
      return;
    }
    androidx.work.impl.ui.f localF = new androidx.work.impl.ui.f(b(), f(), this);
    localF.a(Collections.singletonList(localObject2));
    if (localF.a(e().toString()))
    {
      Log.get().append(c, String.format("Constraints met for delegate %s", new Object[] { localObject1 }), new Throwable[0]);
      try
      {
        localObject2 = b.get();
        ((com.google.common.util.concurrent.Object)localObject2).addListener(new b((com.google.common.util.concurrent.Object)localObject2), build());
        return;
      }
      catch (Throwable localThrowable2)
      {
        Log localLog = Log.get();
        localObject2 = c;
        localLog.append((String)localObject2, String.format("Delegated worker %s threw exception in startWork.", new Object[] { localObject1 }), new Throwable[] { localThrowable2 });
        localObject1 = i;
        try
        {
          if (s)
          {
            Log.get().append((String)localObject2, "Constraints were unmet, Retrying.", new Throwable[0]);
            s();
          }
          else
          {
            reset();
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          throw localThrowable1;
        }
      }
    }
    Log.get().append(c, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[] { localObject1 }), new Throwable[0]);
    s();
  }
  
  void s()
  {
    a.get(ListenableWorker.a.d());
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      ConstraintTrackingWorker.this.run();
    }
  }
  
  class b
    implements Runnable
  {
    b(com.google.common.util.concurrent.Object paramObject) {}
    
    public void run()
    {
      Object localObject = i;
      try
      {
        if (s) {
          s();
        } else {
          a.cancel(b);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
}
