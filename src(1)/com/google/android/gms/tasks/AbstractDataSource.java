package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class AbstractDataSource<TResult>
  extends Task<TResult>
{
  private Exception exception;
  private boolean index;
  private final Object lock = new Object();
  private volatile boolean state;
  private final ByteBufferOutput table = new ByteBufferOutput();
  private Object value;
  
  AbstractDataSource() {}
  
  private final void delete()
  {
    if (!index) {
      return;
    }
    throw DuplicateTaskCompletionException.onPostExecute(this);
  }
  
  private final void get()
  {
    Preconditions.checkState(index, "Task is not yet complete");
  }
  
  private final void recycle()
  {
    if (!state) {
      return;
    }
    throw new CancellationException("Task is already canceled.");
  }
  
  private final void unblock()
  {
    Object localObject = lock;
    try
    {
      if (!index) {
        return;
      }
      table.flush(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Task addOnCanceledListener(Activity paramActivity, OnCanceledListener paramOnCanceledListener)
  {
    paramOnCanceledListener = new Comment(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    table.reserve(paramOnCanceledListener);
    LocationFragment.onCreate(paramActivity).onStop(paramOnCanceledListener);
    unblock();
    return this;
  }
  
  public final Task addOnCanceledListener(OnCanceledListener paramOnCanceledListener)
  {
    addOnCanceledListener(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    return this;
  }
  
  public final Task addOnCanceledListener(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    table.reserve(new Comment(paramExecutor, paramOnCanceledListener));
    unblock();
    return this;
  }
  
  public final Task addOnCompleteListener(Activity paramActivity, OnCompleteListener paramOnCompleteListener)
  {
    paramOnCompleteListener = new ImageCache(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    table.reserve(paramOnCompleteListener);
    LocationFragment.onCreate(paramActivity).onStop(paramOnCompleteListener);
    unblock();
    return this;
  }
  
  public final Task addOnCompleteListener(OnCompleteListener paramOnCompleteListener)
  {
    Executor localExecutor = TaskExecutors.MAIN_THREAD;
    table.reserve(new ImageCache(localExecutor, paramOnCompleteListener));
    unblock();
    return this;
  }
  
  public final Task addOnCompleteListener(Executor paramExecutor, OnCompleteListener paramOnCompleteListener)
  {
    table.reserve(new ImageCache(paramExecutor, paramOnCompleteListener));
    unblock();
    return this;
  }
  
  public final Task addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener)
  {
    paramOnFailureListener = new Session(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    table.reserve(paramOnFailureListener);
    LocationFragment.onCreate(paramActivity).onStop(paramOnFailureListener);
    unblock();
    return this;
  }
  
  public final Task addOnFailureListener(OnFailureListener paramOnFailureListener)
  {
    addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    return this;
  }
  
  public final Task addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    table.reserve(new Session(paramExecutor, paramOnFailureListener));
    unblock();
    return this;
  }
  
  public final Task addOnSuccessListener(Activity paramActivity, OnSuccessListener paramOnSuccessListener)
  {
    paramOnSuccessListener = new RequestFutureTarget(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    table.reserve(paramOnSuccessListener);
    LocationFragment.onCreate(paramActivity).onStop(paramOnSuccessListener);
    unblock();
    return this;
  }
  
  public final Task addOnSuccessListener(OnSuccessListener paramOnSuccessListener)
  {
    addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    return this;
  }
  
  public final Task addOnSuccessListener(Executor paramExecutor, OnSuccessListener paramOnSuccessListener)
  {
    table.reserve(new RequestFutureTarget(paramExecutor, paramOnSuccessListener));
    unblock();
    return this;
  }
  
  public final void close(Exception paramException)
  {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    Object localObject = lock;
    try
    {
      delete();
      index = true;
      exception = paramException;
      table.flush(this);
      return;
    }
    catch (Throwable paramException)
    {
      throw paramException;
    }
  }
  
  public final void close(Object paramObject)
  {
    Object localObject = lock;
    try
    {
      delete();
      index = true;
      value = paramObject;
      table.flush(this);
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public final boolean close()
  {
    Object localObject = lock;
    try
    {
      if (index) {
        return false;
      }
      index = true;
      state = true;
      table.flush(this);
      return true;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Task continueWith(Continuation paramContinuation)
  {
    return continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final Task continueWith(Executor paramExecutor, Continuation paramContinuation)
  {
    AbstractDataSource localAbstractDataSource = new AbstractDataSource();
    table.reserve(new Connection(paramExecutor, paramContinuation, localAbstractDataSource));
    unblock();
    return localAbstractDataSource;
  }
  
  public final Task continueWithTask(Continuation paramContinuation)
  {
    return continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final Task continueWithTask(Executor paramExecutor, Continuation paramContinuation)
  {
    AbstractDataSource localAbstractDataSource = new AbstractDataSource();
    table.reserve(new MainActivity.2.1(paramExecutor, paramContinuation, localAbstractDataSource));
    unblock();
    return localAbstractDataSource;
  }
  
  public final boolean get(Exception paramException)
  {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    Object localObject = lock;
    try
    {
      if (index) {
        return false;
      }
      index = true;
      exception = paramException;
      table.flush(this);
      return true;
    }
    catch (Throwable paramException)
    {
      throw paramException;
    }
  }
  
  public final boolean get(Object paramObject)
  {
    Object localObject = lock;
    try
    {
      if (index) {
        return false;
      }
      index = true;
      value = paramObject;
      table.flush(this);
      return true;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public final Exception getException()
  {
    Object localObject = lock;
    try
    {
      Exception localException = exception;
      return localException;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Object getResult()
  {
    Object localObject1 = lock;
    try
    {
      get();
      recycle();
      Object localObject2 = exception;
      if (localObject2 == null)
      {
        localObject2 = value;
        return localObject2;
      }
      throw new RuntimeExecutionException((Throwable)localObject2);
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Object getResult(Class paramClass)
    throws Throwable
  {
    Object localObject = lock;
    try
    {
      get();
      recycle();
      if (!paramClass.isInstance(exception))
      {
        paramClass = exception;
        if (paramClass == null)
        {
          paramClass = value;
          return paramClass;
        }
        throw new RuntimeExecutionException(paramClass);
      }
      throw ((Throwable)paramClass.cast(exception));
    }
    catch (Throwable paramClass)
    {
      throw paramClass;
    }
  }
  
  public final boolean isCanceled()
  {
    return state;
  }
  
  public final boolean isComplete()
  {
    Object localObject = lock;
    try
    {
      boolean bool = index;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final boolean isSuccessful()
  {
    Object localObject = lock;
    try
    {
      boolean bool3 = index;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (!state)
        {
          bool1 = bool2;
          if (exception == null) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Task onSuccessTask(SuccessContinuation paramSuccessContinuation)
  {
    Executor localExecutor = TaskExecutors.MAIN_THREAD;
    AbstractDataSource localAbstractDataSource = new AbstractDataSource();
    table.reserve(new SearchFragment.2(localExecutor, paramSuccessContinuation, localAbstractDataSource));
    unblock();
    return localAbstractDataSource;
  }
  
  public final Task onSuccessTask(Executor paramExecutor, SuccessContinuation paramSuccessContinuation)
  {
    AbstractDataSource localAbstractDataSource = new AbstractDataSource();
    table.reserve(new SearchFragment.2(paramExecutor, paramSuccessContinuation, localAbstractDataSource));
    unblock();
    return localAbstractDataSource;
  }
}
