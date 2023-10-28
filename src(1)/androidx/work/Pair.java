package androidx.work;

import android.content.Context;
import java.lang.reflect.Constructor;

public abstract class Pair
{
  private static final String name = Log.getInstance("WorkerFactory");
  
  public Pair() {}
  
  public static Pair create()
  {
    return new IndexEvents.Entry();
  }
  
  public final ListenableWorker create(Context paramContext, String paramString, WorkerParameters paramWorkerParameters)
  {
    Object localObject4 = getKey(paramContext, paramString, paramWorkerParameters);
    Object localObject1 = localObject4;
    Object localObject2 = localObject1;
    Object localObject3;
    if (localObject4 == null)
    {
      localObject4 = null;
      try
      {
        localObject2 = Class.forName(paramString).asSubclass(ListenableWorker.class);
        localObject4 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        Log localLog = Log.get();
        String str = name;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid class: ");
        localStringBuilder.append(paramString);
        localLog.get(str, localStringBuilder.toString(), new Throwable[] { localThrowable });
      }
      localObject3 = localObject1;
      if (localObject4 != null) {
        try
        {
          localObject3 = (ListenableWorker)((Class)localObject4).getDeclaredConstructor(new Class[] { Context.class, WorkerParameters.class }).newInstance(new Object[] { paramContext, paramWorkerParameters });
        }
        catch (Throwable paramContext)
        {
          paramWorkerParameters = Log.get();
          localObject3 = name;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("Could not instantiate ");
          ((StringBuilder)localObject4).append(paramString);
          paramWorkerParameters.get((String)localObject3, ((StringBuilder)localObject4).toString(), new Throwable[] { paramContext });
          localObject3 = localObject1;
        }
      }
    }
    if (localObject3 != null)
    {
      if (!((ListenableWorker)localObject3).post()) {
        return localObject3;
      }
      throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", new Object[] { getClass().getName(), paramString }));
    }
    return localObject3;
  }
  
  public abstract ListenableWorker getKey(Context paramContext, String paramString, WorkerParameters paramWorkerParameters);
}
