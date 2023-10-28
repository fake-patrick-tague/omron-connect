package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.tasks.CaptureActivityHandler;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks
{
  private Tasks() {}
  
  public static Object await(Task paramTask)
    throws ExecutionException, InterruptedException
  {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    if (paramTask.isComplete()) {
      return execute(paramTask);
    }
    zzad localZzad = new zzad(null);
    createNew(paramTask, localZzad);
    localZzad.await();
    return execute(paramTask);
  }
  
  public static Object await(Task paramTask, long paramLong, TimeUnit paramTimeUnit)
    throws ExecutionException, InterruptedException, TimeoutException
  {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete()) {
      return execute(paramTask);
    }
    zzad localZzad = new zzad(null);
    createNew(paramTask, localZzad);
    if (localZzad.await(paramLong, paramTimeUnit)) {
      return execute(paramTask);
    }
    throw new TimeoutException("Timed out waiting for Task");
  }
  
  public static Task call(Callable paramCallable)
  {
    return call(TaskExecutors.MAIN_THREAD, paramCallable);
  }
  
  public static Task call(Executor paramExecutor, Callable paramCallable)
  {
    Preconditions.checkNotNull(paramExecutor, "Executor must not be null");
    Preconditions.checkNotNull(paramCallable, "Callback must not be null");
    AbstractDataSource localAbstractDataSource = new AbstractDataSource();
    paramExecutor.execute(new FutureTask(localAbstractDataSource, paramCallable));
    return localAbstractDataSource;
  }
  
  private static void createNew(Task paramTask, zzae paramZzae)
  {
    Executor localExecutor = TaskExecutors.executor;
    paramTask.addOnSuccessListener(localExecutor, paramZzae);
    paramTask.addOnFailureListener(localExecutor, paramZzae);
    paramTask.addOnCanceledListener(localExecutor, paramZzae);
  }
  
  private static Object execute(Task paramTask)
    throws ExecutionException
  {
    if (paramTask.isSuccessful()) {
      return paramTask.getResult();
    }
    if (paramTask.isCanceled()) {
      throw new CancellationException("Task is already canceled");
    }
    throw new ExecutionException(paramTask.getException());
  }
  
  public static Task forCanceled()
  {
    AbstractDataSource localAbstractDataSource = new AbstractDataSource();
    localAbstractDataSource.close();
    return localAbstractDataSource;
  }
  
  public static Task forException(Exception paramException)
  {
    AbstractDataSource localAbstractDataSource = new AbstractDataSource();
    localAbstractDataSource.close(paramException);
    return localAbstractDataSource;
  }
  
  public static Task forResult(Object paramObject)
  {
    AbstractDataSource localAbstractDataSource = new AbstractDataSource();
    localAbstractDataSource.close(paramObject);
    return localAbstractDataSource;
  }
  
  public static Task whenAll(Collection paramCollection)
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      Object localObject = paramCollection.iterator();
      while (((Iterator)localObject).hasNext()) {
        Objects.requireNonNull((Task)((Iterator)localObject).next(), "null tasks are not accepted");
      }
      localObject = new AbstractDataSource();
      zzaf localZzaf = new zzaf(paramCollection.size(), (AbstractDataSource)localObject);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        createNew((Task)paramCollection.next(), localZzaf);
      }
      return localObject;
    }
    return forResult(null);
  }
  
  public static Task whenAll(Task... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      return whenAll(Arrays.asList(paramVarArgs));
    }
    return forResult(null);
  }
  
  public static Task whenAllComplete(Collection paramCollection)
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      Task localTask = whenAll(paramCollection);
      paramCollection = new zzab(paramCollection);
      return localTask.continueWithTask(TaskExecutors.MAIN_THREAD, paramCollection);
    }
    return forResult(Collections.emptyList());
  }
  
  public static Task whenAllComplete(Task... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      return whenAllComplete(Arrays.asList(paramVarArgs));
    }
    return forResult(Collections.emptyList());
  }
  
  public static Task whenAllSuccess(Collection paramCollection)
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      Task localTask = whenAll(paramCollection);
      paramCollection = new zzaa(paramCollection);
      return localTask.continueWith(TaskExecutors.MAIN_THREAD, paramCollection);
    }
    return forResult(Collections.emptyList());
  }
  
  public static Task whenAllSuccess(Task... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      return whenAllSuccess(Arrays.asList(paramVarArgs));
    }
    return forResult(Collections.emptyList());
  }
  
  public static Task withTimeout(Task paramTask, long paramLong, TimeUnit paramTimeUnit)
  {
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Timeout must be positive");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    Notifier localNotifier = new Notifier();
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource(localNotifier);
    CaptureActivityHandler localCaptureActivityHandler = new CaptureActivityHandler(Looper.getMainLooper());
    localCaptureActivityHandler.postDelayed(new Futures.TimeoutFuture.Fire(localTaskCompletionSource), paramTimeUnit.toMillis(paramLong));
    paramTask.addOnCompleteListener(new LoginActivity.1(localCaptureActivityHandler, localTaskCompletionSource, localNotifier));
    return localTaskCompletionSource.getTask();
  }
}
