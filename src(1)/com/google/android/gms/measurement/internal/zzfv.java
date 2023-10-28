package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfv
  extends zzgs
{
  private static final AtomicLong count = new AtomicLong(Long.MIN_VALUE);
  private final Thread.UncaughtExceptionHandler connections = new zzfs(this, "Thread death: Uncaught exception on worker thread");
  private zzfu executor;
  private final BlockingQueue handler = new LinkedBlockingQueue();
  private final Object lock = new Object();
  private final Semaphore mIsAvailable = new Semaphore(2);
  private volatile boolean mentioned;
  private final PriorityBlockingQueue this$0 = new PriorityBlockingQueue();
  private final Thread.UncaughtExceptionHandler timer = new zzfs(this, "Thread death: Uncaught exception on network thread");
  private zzfu updater;
  
  zzfv(zzfy paramZzfy)
  {
    super(paramZzfy);
  }
  
  private final void put(zzft paramZzft)
  {
    Object localObject = lock;
    try
    {
      this$0.add(paramZzft);
      paramZzft = executor;
      if (paramZzft == null)
      {
        paramZzft = new zzfu(this, "Measurement Worker", this$0);
        executor = paramZzft;
        paramZzft.setUncaughtExceptionHandler(connections);
        executor.start();
      }
      else
      {
        paramZzft.stop();
      }
      return;
    }
    catch (Throwable paramZzft)
    {
      throw paramZzft;
    }
  }
  
  public final void append()
  {
    if (Thread.currentThread() == executor) {
      return;
    }
    throw new IllegalStateException("Call expected from worker thread");
  }
  
  public final void append(Runnable paramRunnable)
    throws IllegalStateException
  {
    size();
    Preconditions.checkNotNull(paramRunnable);
    put(new zzft(this, paramRunnable, false, "Task exception on worker thread"));
  }
  
  final Object get(AtomicReference paramAtomicReference, long paramLong, String paramString, Runnable paramRunnable)
  {
    try
    {
      this$0.zzaz().append(paramRunnable);
    }
    catch (Throwable paramString)
    {
      label52:
      StringBuilder localStringBuilder;
      throw paramString;
    }
    try
    {
      paramAtomicReference.wait(paramLong);
      paramAtomicReference = paramAtomicReference.get();
      if (paramAtomicReference != null) {
        return paramAtomicReference;
      }
      this$0.zzay().hasNext().append("Timed out waiting for ".concat(paramString));
      return paramAtomicReference;
    }
    catch (InterruptedException paramRunnable)
    {
      break label52;
    }
    paramRunnable = this$0.zzay().hasNext();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Interrupted waiting for ");
    localStringBuilder.append(paramString);
    paramRunnable.append(localStringBuilder.toString());
    return null;
    return paramAtomicReference;
  }
  
  public final Future get(Callable paramCallable)
    throws IllegalStateException
  {
    size();
    Preconditions.checkNotNull(paramCallable);
    paramCallable = new zzft(this, paramCallable, true, "Task exception on worker thread");
    if (Thread.currentThread() == executor)
    {
      paramCallable.run();
      return paramCallable;
    }
    put(paramCallable);
    return paramCallable;
  }
  
  protected final boolean parse()
  {
    return false;
  }
  
  public final boolean put()
  {
    return Thread.currentThread() == executor;
  }
  
  public final void run(Runnable paramRunnable)
    throws IllegalStateException
  {
    size();
    Preconditions.checkNotNull(paramRunnable);
    Object localObject = new zzft(this, paramRunnable, false, "Task exception on network thread");
    paramRunnable = lock;
    try
    {
      handler.add(localObject);
      localObject = updater;
      if (localObject == null)
      {
        localObject = new zzfu(this, "Measurement Network", handler);
        updater = ((zzfu)localObject);
        ((Thread)localObject).setUncaughtExceptionHandler(timer);
        updater.start();
      }
      else
      {
        ((zzfu)localObject).stop();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Future submit(Callable paramCallable)
    throws IllegalStateException
  {
    size();
    Preconditions.checkNotNull(paramCallable);
    paramCallable = new zzft(this, paramCallable, false, "Task exception on worker thread");
    if (Thread.currentThread() == executor)
    {
      if (!this$0.isEmpty()) {
        this$0.zzay().hasNext().append("Callable skipped the worker queue.");
      }
      paramCallable.run();
      return paramCallable;
    }
    put(paramCallable);
    return paramCallable;
  }
  
  public final void synchronize(Runnable paramRunnable)
    throws IllegalStateException
  {
    size();
    Preconditions.checkNotNull(paramRunnable);
    put(new zzft(this, paramRunnable, true, "Task exception on worker thread"));
  }
  
  public final void zzax()
  {
    if (Thread.currentThread() == updater) {
      return;
    }
    throw new IllegalStateException("Call expected from network thread");
  }
}
