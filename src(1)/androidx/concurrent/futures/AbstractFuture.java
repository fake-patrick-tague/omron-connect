package androidx.concurrent.futures;

import com.google.common.util.concurrent.c;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFuture<V>
  implements c<V>
{
  static final AtomicHelper ATOMIC_HELPER;
  private static final Object NULL;
  static final boolean id;
  private static final Logger log;
  volatile Listener listeners;
  volatile Object value;
  volatile Waiter waiters;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a1 = a0\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  protected AbstractFuture() {}
  
  private Listener addListener(Listener paramListener)
  {
    Listener localListener2;
    do
    {
      localListener2 = listeners;
    } while (!ATOMIC_HELPER.casListeners(this, localListener2, Listener.TOMBSTONE));
    Listener localListener1 = paramListener;
    for (paramListener = localListener2; paramListener != null; paramListener = localListener2)
    {
      localListener2 = next;
      next = localListener1;
      localListener1 = paramListener;
    }
    return localListener1;
  }
  
  static void cancel(AbstractFuture paramAbstractFuture)
  {
    Object localObject2 = null;
    Object localObject1 = paramAbstractFuture;
    paramAbstractFuture = (AbstractFuture)localObject2;
    ((AbstractFuture)localObject1).removeWaiter();
    ((AbstractFuture)localObject1).cancel();
    for (localObject1 = ((AbstractFuture)localObject1).addListener(paramAbstractFuture);; localObject1 = paramAbstractFuture)
    {
      if (localObject1 == null) {
        return;
      }
      paramAbstractFuture = next;
      localObject2 = task;
      if ((localObject2 instanceof SetFuture))
      {
        localObject2 = (SetFuture)localObject2;
        localObject1 = this$0;
        if (value != localObject2) {
          continue;
        }
        Object localObject3 = get(value);
        if (!ATOMIC_HELPER.casValue((AbstractFuture)localObject1, localObject2, localObject3)) {
          continue;
        }
        break;
      }
      executeListener((Runnable)localObject2, value);
    }
  }
  
  private static CancellationException cancellationExceptionWithCause(String paramString, Throwable paramThrowable)
  {
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    return paramString;
  }
  
  private static void executeListener(Runnable paramRunnable, Executor paramExecutor)
  {
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Logger localLogger = log;
      Level localLevel = Level.SEVERE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RuntimeException while executing runnable ");
      localStringBuilder.append(paramRunnable);
      localStringBuilder.append(" with executor ");
      localStringBuilder.append(paramExecutor);
      localLogger.log(localLevel, localStringBuilder.toString(), localRuntimeException);
    }
  }
  
  static Object get(com.google.common.util.concurrent.Object paramObject)
  {
    Object localObject1;
    Object localObject2;
    if ((paramObject instanceof AbstractFuture))
    {
      localObject1 = value;
      paramObject = localObject1;
      if ((localObject1 instanceof Type))
      {
        localObject2 = (Type)localObject1;
        paramObject = localObject1;
        if (this$0)
        {
          if (exception != null) {
            return new Type(false, exception);
          }
          return Type.value;
        }
      }
    }
    else
    {
      boolean bool = paramObject.isCancelled();
      if (((id ^ true) & bool)) {
        return Type.value;
      }
      try
      {
        localObject1 = get(paramObject);
        paramObject = localObject1;
        if (localObject1 == null)
        {
          paramObject = NULL;
          return paramObject;
        }
      }
      catch (Throwable paramObject)
      {
        return new Failure();
      }
      catch (CancellationException localCancellationException)
      {
        if (!bool)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get() threw CancellationException, despite reporting isCancelled() == false: ");
          ((StringBuilder)localObject2).append(paramObject);
          return new Failure(new IllegalArgumentException(((StringBuilder)localObject2).toString(), localCancellationException));
        }
        return new Type(false, localCancellationException);
      }
      catch (ExecutionException paramObject)
      {
        return new Failure(paramObject.getCause());
      }
    }
    return paramObject;
  }
  
  static Object get(Object paramObject)
  {
    Objects.requireNonNull(paramObject);
    return paramObject;
  }
  
  static Object get(Future paramFuture)
    throws ExecutionException
  {
    int i = 0;
    try
    {
      Object localObject = paramFuture.get();
      if (i != 0)
      {
        Thread.currentThread().interrupt();
        return localObject;
      }
    }
    catch (Throwable paramFuture)
    {
      for (;;)
      {
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        throw paramFuture;
        i = 1;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
      return localInterruptedException;
    }
  }
  
  private Object getDoneValue(Object paramObject)
    throws ExecutionException
  {
    if (!(paramObject instanceof Type))
    {
      if (!(paramObject instanceof Failure))
      {
        if (paramObject == NULL) {
          return null;
        }
      }
      else {
        throw new ExecutionException(exception);
      }
    }
    else {
      throw cancellationExceptionWithCause("Task was cancelled.", exception);
    }
    return paramObject;
  }
  
  private void removeWaiter()
  {
    Waiter localWaiter;
    do
    {
      localWaiter = waiters;
    } while (!ATOMIC_HELPER.casWaiters(this, localWaiter, Waiter.TOMBSTONE));
    while (localWaiter != null)
    {
      localWaiter.unpark();
      localWaiter = next;
    }
  }
  
  private void removeWaiter(Waiter paramWaiter)
  {
    thread = null;
    paramWaiter = waiters;
    if (paramWaiter == Waiter.TOMBSTONE) {
      return;
    }
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      if (paramWaiter == null) {
        return;
      }
      Waiter localWaiter = next;
      if (thread != null)
      {
        localObject2 = paramWaiter;
      }
      else
      {
        if (localObject1 != null)
        {
          next = localWaiter;
          localObject2 = localObject1;
          if (thread != null) {
            break label82;
          }
          break;
        }
        localObject2 = localObject1;
        if (!ATOMIC_HELPER.casWaiters(this, paramWaiter, localWaiter)) {
          break;
        }
      }
      label82:
      paramWaiter = localWaiter;
    }
  }
  
  private String set(Object paramObject)
  {
    if (paramObject == this) {
      return "this future";
    }
    return String.valueOf(paramObject);
  }
  
  private void set(StringBuilder paramStringBuilder)
  {
    try
    {
      Object localObject = get(this);
      paramStringBuilder.append("SUCCESS, result=[");
      paramStringBuilder.append(set(localObject));
      paramStringBuilder.append("]");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramStringBuilder.append("UNKNOWN, cause=[");
      paramStringBuilder.append(localRuntimeException.getClass());
      paramStringBuilder.append(" thrown from get()]");
      return;
      paramStringBuilder.append("CANCELLED");
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      paramStringBuilder.append("FAILURE, cause=[");
      paramStringBuilder.append(localExecutionException.getCause());
      paramStringBuilder.append("]");
      return;
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
  }
  
  public final void addListener(Runnable paramRunnable, Executor paramExecutor)
  {
    get(paramRunnable);
    get(paramExecutor);
    Object localObject = listeners;
    if (localObject != Listener.TOMBSTONE)
    {
      Listener localListener2 = new Listener(paramRunnable, paramExecutor);
      Listener localListener1;
      do
      {
        next = ((Listener)localObject);
        if (ATOMIC_HELPER.casListeners(this, (Listener)localObject, localListener2)) {
          return;
        }
        localListener1 = listeners;
        localObject = localListener1;
      } while (localListener1 != Listener.TOMBSTONE);
    }
    executeListener(paramRunnable, paramExecutor);
  }
  
  protected void cancel() {}
  
  protected boolean cancel(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = NULL;
    }
    if (ATOMIC_HELPER.casValue(this, null, localObject))
    {
      cancel(this);
      return true;
    }
    return false;
  }
  
  protected boolean cancel(Throwable paramThrowable)
  {
    paramThrowable = new Failure((Throwable)get(paramThrowable));
    if (ATOMIC_HELPER.casValue(this, null, paramThrowable))
    {
      cancel(this);
      return true;
    }
    return false;
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    Object localObject1 = value;
    int i;
    if (localObject1 == null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i | localObject1 instanceof SetFuture) != 0)
    {
      Type localType;
      if (id) {
        localType = new Type(paramBoolean, new CancellationException("Future.cancel() was called."));
      } else if (paramBoolean) {
        localType = Type.type;
      } else {
        localType = Type.value;
      }
      boolean bool = false;
      AbstractFuture localAbstractFuture = this;
      Object localObject2;
      do
      {
        while (ATOMIC_HELPER.casValue(localAbstractFuture, localObject1, localType))
        {
          if (paramBoolean) {
            localAbstractFuture.interruptTask();
          }
          cancel(localAbstractFuture);
          if (!(localObject1 instanceof SetFuture)) {
            break label209;
          }
          localObject1 = value;
          if ((localObject1 instanceof AbstractFuture))
          {
            localAbstractFuture = (AbstractFuture)localObject1;
            localObject1 = value;
            if (localObject1 == null) {
              i = 1;
            } else {
              i = 0;
            }
            if ((i | localObject1 instanceof SetFuture) == 0) {
              break label209;
            }
            bool = true;
          }
          else
          {
            ((Future)localObject1).cancel(paramBoolean);
            return true;
          }
        }
        localObject2 = value;
        localObject1 = localObject2;
      } while ((localObject2 instanceof SetFuture));
      return bool;
    }
    return false;
    label209:
    return true;
  }
  
  public final Object get()
    throws InterruptedException, ExecutionException
  {
    if (!Thread.interrupted())
    {
      Object localObject = value;
      int i;
      if (localObject != null) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i & (localObject instanceof SetFuture ^ true)) != 0) {
        return getDoneValue(localObject);
      }
      localObject = waiters;
      if (localObject != Waiter.TOMBSTONE)
      {
        Waiter localWaiter2 = new Waiter();
        Waiter localWaiter1;
        do
        {
          localWaiter2.setNext((Waiter)localObject);
          if (ATOMIC_HELPER.casWaiters(this, (Waiter)localObject, localWaiter2))
          {
            do
            {
              LockSupport.park(this);
              if (Thread.interrupted()) {
                break;
              }
              localObject = value;
              if (localObject != null) {
                i = 1;
              } else {
                i = 0;
              }
            } while ((i & (localObject instanceof SetFuture ^ true)) == 0);
            return getDoneValue(localObject);
            removeWaiter(localWaiter2);
            throw new InterruptedException();
          }
          localWaiter1 = waiters;
          localObject = localWaiter1;
        } while (localWaiter1 != Waiter.TOMBSTONE);
      }
      return getDoneValue(value);
    }
    throw new InterruptedException();
  }
  
  public final Object get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException, ExecutionException
  {
    long l4 = paramTimeUnit.toNanos(paramLong);
    long l1 = l4;
    if (!Thread.interrupted())
    {
      Object localObject1 = value;
      int i;
      if (localObject1 != null) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i & (localObject1 instanceof SetFuture ^ true)) != 0) {
        return getDoneValue(localObject1);
      }
      long l3;
      if (l4 > 0L) {
        l3 = System.nanoTime() + l4;
      } else {
        l3 = 0L;
      }
      long l2 = l1;
      if (l4 >= 1000L)
      {
        localObject1 = waiters;
        if (localObject1 != Waiter.TOMBSTONE)
        {
          localObject3 = new Waiter();
          do
          {
            ((Waiter)localObject3).setNext((Waiter)localObject1);
            if (ATOMIC_HELPER.casWaiters(this, (Waiter)localObject1, (Waiter)localObject3))
            {
              do
              {
                LockSupport.parkNanos(this, l1);
                if (Thread.interrupted()) {
                  break;
                }
                localObject1 = value;
                if (localObject1 != null) {
                  i = 1;
                } else {
                  i = 0;
                }
                if ((i & (localObject1 instanceof SetFuture ^ true)) != 0) {
                  return getDoneValue(localObject1);
                }
                l2 = l3 - System.nanoTime();
                l1 = l2;
              } while (l2 >= 1000L);
              removeWaiter((Waiter)localObject3);
              break;
              removeWaiter((Waiter)localObject3);
              throw new InterruptedException();
            }
            localObject2 = waiters;
            localObject1 = localObject2;
          } while (localObject2 != Waiter.TOMBSTONE);
        }
        return getDoneValue(value);
      }
      while (l2 > 0L)
      {
        localObject1 = value;
        if (localObject1 != null) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i & (localObject1 instanceof SetFuture ^ true)) != 0) {
          return getDoneValue(localObject1);
        }
        if (!Thread.interrupted()) {
          l2 = l3 - System.nanoTime();
        } else {
          throw new InterruptedException();
        }
      }
      Object localObject3 = toString();
      Object localObject2 = paramTimeUnit.toString();
      localObject1 = Locale.ROOT;
      String str = ((String)localObject2).toLowerCase((Locale)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Waited ");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramTimeUnit.toString().toLowerCase((Locale)localObject1));
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (l2 + 1000L < 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" (plus ");
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = localObject2;
        l1 = -l2;
        paramLong = paramTimeUnit.convert(l1, TimeUnit.NANOSECONDS);
        l1 -= paramTimeUnit.toNanos(paramLong);
        boolean bool = paramLong < 0L;
        if ((bool) && (l1 <= 1000L)) {
          i = 0;
        } else {
          i = 1;
        }
        paramTimeUnit = (TimeUnit)localObject1;
        if (bool)
        {
          paramTimeUnit = new StringBuilder();
          paramTimeUnit.append((String)localObject2);
          paramTimeUnit.append(paramLong);
          paramTimeUnit.append(" ");
          paramTimeUnit.append(str);
          localObject1 = paramTimeUnit.toString();
          paramTimeUnit = (TimeUnit)localObject1;
          if (i != 0)
          {
            paramTimeUnit = new StringBuilder();
            paramTimeUnit.append((String)localObject1);
            paramTimeUnit.append(",");
            paramTimeUnit = paramTimeUnit.toString();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramTimeUnit);
          ((StringBuilder)localObject1).append(" ");
          paramTimeUnit = ((StringBuilder)localObject1).toString();
        }
        localObject1 = paramTimeUnit;
        if (i != 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramTimeUnit);
          ((StringBuilder)localObject1).append(l1);
          ((StringBuilder)localObject1).append(" nanoseconds ");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        paramTimeUnit = new StringBuilder();
        paramTimeUnit.append((String)localObject1);
        paramTimeUnit.append("delay)");
        localObject1 = paramTimeUnit.toString();
      }
      if (isDone())
      {
        paramTimeUnit = new StringBuilder();
        paramTimeUnit.append((String)localObject1);
        paramTimeUnit.append(" but future completed as timeout expired");
        throw new TimeoutException(paramTimeUnit.toString());
      }
      paramTimeUnit = new StringBuilder();
      paramTimeUnit.append((String)localObject1);
      paramTimeUnit.append(" for ");
      paramTimeUnit.append((String)localObject3);
      throw new TimeoutException(paramTimeUnit.toString());
    }
    throw new InterruptedException();
  }
  
  protected void interruptTask() {}
  
  public final boolean isCancelled()
  {
    return value instanceof Type;
  }
  
  public final boolean isDone()
  {
    Object localObject = value;
    int i;
    if (localObject != null) {
      i = 1;
    } else {
      i = 0;
    }
    return (localObject instanceof SetFuture ^ true) & i;
  }
  
  protected String parse()
  {
    Object localObject = value;
    if ((localObject instanceof SetFuture))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFuture=[");
      localStringBuilder.append(set(value));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((this instanceof ScheduledFuture))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remaining delay=[");
      ((StringBuilder)localObject).append(((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS));
      ((StringBuilder)localObject).append(" ms]");
      return ((StringBuilder)localObject).toString();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(super.toString());
    localStringBuilder1.append("[status=");
    if (isCancelled())
    {
      localStringBuilder1.append("CANCELLED");
    }
    else if (isDone())
    {
      set(localStringBuilder1);
    }
    else
    {
      String str2;
      try
      {
        String str1 = parse();
      }
      catch (RuntimeException localRuntimeException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Exception thrown from implementation: ");
        localStringBuilder2.append(localRuntimeException.getClass());
        str2 = localStringBuilder2.toString();
      }
      if ((str2 != null) && (!str2.isEmpty()))
      {
        localStringBuilder1.append("PENDING, info=[");
        localStringBuilder1.append(str2);
        localStringBuilder1.append("]");
      }
      else if (isDone())
      {
        set(localStringBuilder1);
      }
      else
      {
        localStringBuilder1.append("PENDING");
      }
    }
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
  
  protected final boolean wasInterrupted()
  {
    Object localObject = value;
    return ((localObject instanceof Type)) && (this$0);
  }
  
  abstract class AtomicHelper
  {
    private AtomicHelper() {}
    
    abstract boolean casListeners(AbstractFuture paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2);
    
    abstract boolean casValue(AbstractFuture paramAbstractFuture, Object paramObject1, Object paramObject2);
    
    abstract boolean casWaiters(AbstractFuture paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2);
    
    abstract void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2);
    
    abstract void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread);
  }
  
  final class Failure
  {
    static final Failure FALLBACK_INSTANCE = new Failure(new a.d.a("Failure occurred while trying to finish a future."));
    final Throwable exception;
    
    Failure()
    {
      exception = ((Throwable)AbstractFuture.get(this$1));
    }
  }
  
  final class Listener
  {
    static final Listener TOMBSTONE = new Listener(null, null);
    Listener next;
    final Executor value;
    
    Listener(Executor paramExecutor)
    {
      value = paramExecutor;
    }
  }
  
  final class SafeAtomicHelper
    extends AbstractFuture.AtomicHelper
  {
    final AtomicReferenceFieldUpdater<a, a.e> listenersUpdater;
    final AtomicReferenceFieldUpdater<a, Object> valueUpdater;
    final AtomicReferenceFieldUpdater<a.i, a.i> waiterNextUpdater;
    final AtomicReferenceFieldUpdater<a, a.i> waitersUpdater;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater4)
    {
      super();
      waiterNextUpdater = paramAtomicReferenceFieldUpdater1;
      waitersUpdater = paramAtomicReferenceFieldUpdater2;
      listenersUpdater = paramAtomicReferenceFieldUpdater3;
      valueUpdater = paramAtomicReferenceFieldUpdater4;
    }
    
    boolean casListeners(AbstractFuture paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2)
    {
      return listenersUpdater.compareAndSet(paramAbstractFuture, paramListener1, paramListener2);
    }
    
    boolean casValue(AbstractFuture paramAbstractFuture, Object paramObject1, Object paramObject2)
    {
      return valueUpdater.compareAndSet(paramAbstractFuture, paramObject1, paramObject2);
    }
    
    boolean casWaiters(AbstractFuture paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      return waitersUpdater.compareAndSet(paramAbstractFuture, paramWaiter1, paramWaiter2);
    }
    
    void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      waiterNextUpdater.lazySet(paramWaiter1, paramWaiter2);
    }
    
    void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
    {
      lazySet(paramWaiter, paramThread);
    }
  }
  
  final class SetFuture<V>
    implements Runnable
  {
    final a<V> this$0;
    final c<? extends V> value;
    
    public void run()
    {
      if (this$0.value != this) {
        return;
      }
      Object localObject = AbstractFuture.get(value);
      if (AbstractFuture.ATOMIC_HELPER.casValue(this$0, this, localObject)) {
        AbstractFuture.cancel(this$0);
      }
    }
  }
  
  final class UnsafeAtomicHelper
    extends AbstractFuture.AtomicHelper
  {
    UnsafeAtomicHelper()
    {
      super();
    }
    
    boolean casListeners(AbstractFuture paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2)
    {
      try
      {
        if (listeners == paramListener1)
        {
          listeners = paramListener2;
          return true;
        }
        return false;
      }
      catch (Throwable paramListener1)
      {
        throw paramListener1;
      }
    }
    
    boolean casValue(AbstractFuture paramAbstractFuture, Object paramObject1, Object paramObject2)
    {
      try
      {
        if (value == paramObject1)
        {
          value = paramObject2;
          return true;
        }
        return false;
      }
      catch (Throwable paramObject1)
      {
        throw paramObject1;
      }
    }
    
    boolean casWaiters(AbstractFuture paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      try
      {
        if (waiters == paramWaiter1)
        {
          waiters = paramWaiter2;
          return true;
        }
        return false;
      }
      catch (Throwable paramWaiter1)
      {
        throw paramWaiter1;
      }
    }
    
    void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      next = paramWaiter2;
    }
    
    void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
    {
      thread = paramThread;
    }
  }
  
  final class Waiter
  {
    static final Waiter TOMBSTONE = new Waiter(false);
    volatile Waiter next;
    volatile Thread thread;
    
    Waiter()
    {
      AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }
    
    Waiter() {}
    
    void setNext(Waiter paramWaiter)
    {
      AbstractFuture.ATOMIC_HELPER.putNext(this, paramWaiter);
    }
    
    void unpark()
    {
      Thread localThread = thread;
      if (localThread != null)
      {
        thread = null;
        LockSupport.unpark(localThread);
      }
    }
  }
}
