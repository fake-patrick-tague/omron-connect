package androidx.work.impl.utils.futures;

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
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFuture<V>
  implements c<V>
{
  private static final Object NULL;
  static final boolean id;
  private static final Logger log;
  static final TreeMap this$0;
  volatile Label c;
  volatile Waiter next;
  volatile Object value;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a1 = a0\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  protected AbstractFuture() {}
  
  private Label a(Label paramLabel)
  {
    Label localLabel2;
    do
    {
      localLabel2 = c;
    } while (!this$0.get(this, localLabel2, Label.i));
    Label localLabel1 = paramLabel;
    for (paramLabel = localLabel2; paramLabel != null; paramLabel = localLabel2)
    {
      localLabel2 = c;
      c = localLabel1;
      localLabel1 = paramLabel;
    }
    return localLabel1;
  }
  
  private static CancellationException cancellationExceptionWithCause(String paramString, Throwable paramThrowable)
  {
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    return paramString;
  }
  
  private void complete()
  {
    Waiter localWaiter;
    do
    {
      localWaiter = next;
    } while (!this$0.get(this, localWaiter, Waiter.data));
    while (localWaiter != null)
    {
      localWaiter.unpark();
      localWaiter = next;
    }
  }
  
  static Object create(Object paramObject)
  {
    Objects.requireNonNull(paramObject);
    return paramObject;
  }
  
  static void execute(AbstractFuture paramAbstractFuture)
  {
    Object localObject2 = null;
    Object localObject1 = paramAbstractFuture;
    paramAbstractFuture = (AbstractFuture)localObject2;
    ((AbstractFuture)localObject1).complete();
    ((AbstractFuture)localObject1).debug();
    for (localObject1 = ((AbstractFuture)localObject1).a(paramAbstractFuture);; localObject1 = paramAbstractFuture)
    {
      if (localObject1 == null) {
        return;
      }
      paramAbstractFuture = c;
      localObject2 = runnable;
      if ((localObject2 instanceof Job))
      {
        localObject2 = (Job)localObject2;
        localObject1 = log;
        if (value != localObject2) {
          continue;
        }
        Object localObject3 = get(this$0);
        if (!this$0.get((AbstractFuture)localObject1, localObject2, localObject3)) {
          continue;
        }
        break;
      }
      executeListener((Runnable)localObject2, executor);
    }
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
      if ((localObject1 instanceof Pair))
      {
        localObject2 = (Pair)localObject1;
        paramObject = localObject1;
        if (value)
        {
          if (exception != null) {
            return new Pair(false, exception);
          }
          return Pair.c;
        }
      }
    }
    else
    {
      boolean bool = paramObject.isCancelled();
      if (((id ^ true) & bool)) {
        return Pair.c;
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
        return new AsyncHttpClient(paramObject);
      }
      catch (CancellationException localCancellationException)
      {
        if (!bool)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get() threw CancellationException, despite reporting isCancelled() == false: ");
          ((StringBuilder)localObject2).append(paramObject);
          return new AsyncHttpClient(new IllegalArgumentException(((StringBuilder)localObject2).toString(), localCancellationException));
        }
        return new Pair(false, localCancellationException);
      }
      catch (ExecutionException paramObject)
      {
        return new AsyncHttpClient(paramObject.getCause());
      }
    }
    return paramObject;
  }
  
  private static Object get(Future paramFuture)
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
  
  private void get(Waiter paramWaiter)
  {
    thread = null;
    paramWaiter = next;
    if (paramWaiter == Waiter.data) {
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
        if (!this$0.get(this, paramWaiter, localWaiter)) {
          break;
        }
      }
      label82:
      paramWaiter = localWaiter;
    }
  }
  
  private Object getDoneValue(Object paramObject)
    throws ExecutionException
  {
    if (!(paramObject instanceof Pair))
    {
      if (!(paramObject instanceof AsyncHttpClient))
      {
        if (paramObject == NULL) {
          return null;
        }
      }
      else {
        throw new ExecutionException(cause);
      }
    }
    else {
      throw cancellationExceptionWithCause("Task was cancelled.", exception);
    }
    return paramObject;
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
    create(paramRunnable);
    create(paramExecutor);
    Object localObject = c;
    if (localObject != Label.i)
    {
      Label localLabel2 = new Label(paramRunnable, paramExecutor);
      Label localLabel1;
      do
      {
        c = ((Label)localObject);
        if (this$0.get(this, (Label)localObject, localLabel2)) {
          return;
        }
        localLabel1 = c;
        localObject = localLabel1;
      } while (localLabel1 != Label.i);
    }
    executeListener(paramRunnable, paramExecutor);
  }
  
  protected void cancel() {}
  
  protected boolean cancel(com.google.common.util.concurrent.Object paramObject)
  {
    create(paramObject);
    Object localObject2 = value;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramObject.isDone())
      {
        paramObject = get(paramObject);
        if (this$0.get(this, null, paramObject))
        {
          execute(this);
          return true;
        }
        return false;
      }
      localObject1 = new Job(this, paramObject);
      if (this$0.get(this, null, localObject1)) {
        try
        {
          paramObject.addListener((Runnable)localObject1, DirectExecutor.options);
          return true;
        }
        catch (Throwable paramObject) {}
      }
    }
    try
    {
      paramObject = new AsyncHttpClient(paramObject);
    }
    catch (Throwable paramObject)
    {
      for (;;) {}
    }
    paramObject = AsyncHttpClient.log;
    this$0.get(this, localObject1, paramObject);
    return true;
    localObject1 = value;
    if ((localObject1 instanceof Pair))
    {
      paramObject.cancel(value);
      return false;
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
    if ((i | localObject1 instanceof Job) != 0)
    {
      Pair localPair;
      if (id) {
        localPair = new Pair(paramBoolean, new CancellationException("Future.cancel() was called."));
      } else if (paramBoolean) {
        localPair = Pair.a;
      } else {
        localPair = Pair.c;
      }
      boolean bool = false;
      AbstractFuture localAbstractFuture = this;
      Object localObject2;
      do
      {
        while (this$0.get(localAbstractFuture, localObject1, localPair))
        {
          if (paramBoolean) {
            localAbstractFuture.cancel();
          }
          execute(localAbstractFuture);
          if (!(localObject1 instanceof Job)) {
            break label209;
          }
          localObject1 = this$0;
          if ((localObject1 instanceof AbstractFuture))
          {
            localAbstractFuture = (AbstractFuture)localObject1;
            localObject1 = value;
            if (localObject1 == null) {
              i = 1;
            } else {
              i = 0;
            }
            if ((i | localObject1 instanceof Job) == 0) {
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
      } while ((localObject2 instanceof Job));
      return bool;
    }
    return false;
    label209:
    return true;
  }
  
  protected void debug() {}
  
  protected String execute()
  {
    Object localObject = value;
    if ((localObject instanceof Job))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFuture=[");
      localStringBuilder.append(set(this$0));
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
      if ((i & (localObject instanceof Job ^ true)) != 0) {
        return getDoneValue(localObject);
      }
      localObject = next;
      if (localObject != Waiter.data)
      {
        Waiter localWaiter2 = new Waiter();
        Waiter localWaiter1;
        do
        {
          localWaiter2.setNext((Waiter)localObject);
          if (this$0.get(this, (Waiter)localObject, localWaiter2))
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
            } while ((i & (localObject instanceof Job ^ true)) == 0);
            return getDoneValue(localObject);
            get(localWaiter2);
            throw new InterruptedException();
          }
          localWaiter1 = next;
          localObject = localWaiter1;
        } while (localWaiter1 != Waiter.data);
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
      if ((i & (localObject1 instanceof Job ^ true)) != 0) {
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
        localObject1 = next;
        if (localObject1 != Waiter.data)
        {
          localObject3 = new Waiter();
          do
          {
            ((Waiter)localObject3).setNext((Waiter)localObject1);
            if (this$0.get(this, (Waiter)localObject1, (Waiter)localObject3))
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
                if ((i & (localObject1 instanceof Job ^ true)) != 0) {
                  return getDoneValue(localObject1);
                }
                l2 = l3 - System.nanoTime();
                l1 = l2;
              } while (l2 >= 1000L);
              get((Waiter)localObject3);
              break;
              get((Waiter)localObject3);
              throw new InterruptedException();
            }
            localObject2 = next;
            localObject1 = localObject2;
          } while (localObject2 != Waiter.data);
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
        if ((i & (localObject1 instanceof Job ^ true)) != 0) {
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
  
  protected boolean get(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = NULL;
    }
    if (this$0.get(this, null, localObject))
    {
      execute(this);
      return true;
    }
    return false;
  }
  
  protected boolean get(Throwable paramThrowable)
  {
    paramThrowable = new AsyncHttpClient((Throwable)create(paramThrowable));
    if (this$0.get(this, null, paramThrowable))
    {
      execute(this);
      return true;
    }
    return false;
  }
  
  public final boolean isCancelled()
  {
    return value instanceof Pair;
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
    return (localObject instanceof Job ^ true) & i;
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
        String str1 = execute();
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
  
  final class Waiter
  {
    static final Waiter data = new Waiter(false);
    volatile Waiter next;
    volatile Thread thread;
    
    Waiter()
    {
      AbstractFuture.this$0.putThread(this, Thread.currentThread());
    }
    
    Waiter() {}
    
    void setNext(Waiter paramWaiter)
    {
      AbstractFuture.this$0.putNext(this, paramWaiter);
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
