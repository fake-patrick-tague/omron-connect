package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result>
{
  public static final Executor THREAD_POOL_EXECUTOR;
  private static volatile Executor sDefaultExecutor;
  private static f sHandler;
  private static final BlockingQueue<Runnable> sPoolWorkQueue;
  private static final ThreadFactory sThreadFactory;
  final AtomicBoolean callable = new AtomicBoolean();
  final AtomicBoolean mCancelled = new AtomicBoolean();
  private final FutureTask<Result> mFuture;
  private volatile Status mStatus = Status.PENDING;
  private final g<Params, Result> mWorker;
  
  static
  {
    Object localObject = new a();
    sThreadFactory = (ThreadFactory)localObject;
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(10);
    sPoolWorkQueue = localLinkedBlockingQueue;
    localObject = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, localLinkedBlockingQueue, (ThreadFactory)localObject);
    THREAD_POOL_EXECUTOR = (Executor)localObject;
    sDefaultExecutor = (Executor)localObject;
  }
  
  ModernAsyncTask()
  {
    b localB = new b();
    mWorker = localB;
    mFuture = new c(localB);
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (sHandler == null) {
        sHandler = new f();
      }
      f localF = sHandler;
      return localF;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    mCancelled.set(true);
    return mFuture.cancel(paramBoolean);
  }
  
  protected abstract Object doInBackground(Object... paramVarArgs);
  
  void execute(Object paramObject)
  {
    if (!callable.get()) {
      post(paramObject);
    }
  }
  
  public final ModernAsyncTask executeOnExecutor(Executor paramExecutor, Object... paramVarArgs)
  {
    if (mStatus != Status.PENDING)
    {
      int i = d.$SwitchMap$android$support$v4$content$ModernAsyncTask$Status[mStatus.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
      }
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    mStatus = Status.RUNNING;
    onPreExecute();
    mWorker.mParams = paramVarArgs;
    paramExecutor.execute(mFuture);
    return this;
  }
  
  void finish(Object paramObject)
  {
    if (get()) {
      onCancelled(paramObject);
    } else {
      onPostExecute(paramObject);
    }
    mStatus = Status.FINISHED;
  }
  
  public final boolean get()
  {
    return mCancelled.get();
  }
  
  protected void onCancelled() {}
  
  protected void onCancelled(Object paramObject)
  {
    onCancelled();
  }
  
  protected void onPostExecute(Object paramObject) {}
  
  protected void onPreExecute() {}
  
  protected void onProgressUpdate(Object... paramVarArgs) {}
  
  Object post(Object paramObject)
  {
    getHandler().obtainMessage(1, new e(this, new Object[] { paramObject })).sendToTarget();
    return paramObject;
  }
  
  public static enum Status
  {
    static
    {
      Status localStatus1 = new Status("PENDING", 0);
      PENDING = localStatus1;
      Status localStatus2 = new Status("RUNNING", 1);
      RUNNING = localStatus2;
      Status localStatus3 = new Status("FINISHED", 2);
      FINISHED = localStatus3;
      $VALUES = new Status[] { localStatus1, localStatus2, localStatus3 };
    }
  }
  
  static final class a
    implements ThreadFactory
  {
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    
    a() {}
    
    public Thread newThread(Runnable paramRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ModernAsyncTask #");
      localStringBuilder.append(threadNumber.getAndIncrement());
      return new Thread(paramRunnable, localStringBuilder.toString());
    }
  }
  
  class b
    extends ModernAsyncTask.g<Params, Result>
  {
    b() {}
    
    public Object call()
      throws Exception
    {
      callable.set(true);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      try
      {
        Process.setThreadPriority(10);
        localObject1 = localObject2;
        localObject2 = doInBackground(mParams);
        localObject1 = localObject2;
        Binder.flushPendingCommands();
        post(localObject2);
        return localObject2;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          mCancelled.set(true);
          throw localThrowable1;
        }
        catch (Throwable localThrowable2)
        {
          post(localObject1);
          throw localThrowable2;
        }
      }
    }
  }
  
  class c
    extends FutureTask<Result>
  {
    c(Callable paramCallable)
    {
      super();
    }
    
    protected void done()
    {
      try
      {
        Object localObject = get();
        ModernAsyncTask localModernAsyncTask = ModernAsyncTask.this;
        localModernAsyncTask.execute(localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException("An error occurred while executing doInBackground()", localThrowable);
        execute(null);
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        throw new RuntimeException("An error occurred while executing doInBackground()", localExecutionException.getCause());
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.w("AsyncTask", localInterruptedException);
        return;
      }
      catch (CancellationException localCancellationException)
      {
        for (;;) {}
      }
    }
  }
  
  private static class e<Data>
  {
    final Data[] mData;
    final ModernAsyncTask mTask;
    
    e(ModernAsyncTask paramModernAsyncTask, Object... paramVarArgs)
    {
      mTask = paramModernAsyncTask;
      mData = paramVarArgs;
    }
  }
  
  private static class f
    extends Handler
  {
    f()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      ModernAsyncTask.e localE = (ModernAsyncTask.e)obj;
      int i = what;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        mTask.onProgressUpdate(mData);
        return;
      }
      mTask.finish(mData[0]);
    }
  }
  
  private static abstract class g<Params, Result>
    implements Callable<Result>
  {
    Params[] mParams;
    
    g() {}
  }
}
