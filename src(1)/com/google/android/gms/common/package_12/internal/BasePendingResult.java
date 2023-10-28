package com.google.android.gms.common.package_12.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.zas;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Releasable;
import com.google.android.gms.common.package_12.ResultTransform;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.TransformedResult;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.Logger;
import com.google.android.gms.internal.base.zaq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
@KeepName
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.Result>
  extends PendingResult<R>
{
  static final ThreadLocal<Boolean> guard = new BitmapHunter.1();
  private final ArrayList<com.google.android.gms.common.api.PendingResult.StatusListener> args = new ArrayList();
  private boolean cancelled = false;
  private R data;
  private final Object delegate = new Object();
  private volatile com.google.android.gms.common.api.internal.zada<R> head;
  private ICancelToken key;
  @KeepName
  private zas mResultGuardian;
  private com.google.android.gms.common.api.ResultCallback<? super R> next;
  private final CountDownLatch ready = new CountDownLatch(1);
  protected final WeakReference<com.google.android.gms.common.api.GoogleApiClient> request;
  private boolean result;
  private boolean state;
  private final AtomicReference<com.google.android.gms.common.api.internal.zadb> status = new AtomicReference();
  protected final com.google.android.gms.common.api.internal.BasePendingResult.CallbackHandler<R> this$0;
  private Status type;
  private volatile boolean value;
  
  BasePendingResult()
  {
    this$0 = new CallbackHandler(Looper.getMainLooper());
    request = new WeakReference(null);
  }
  
  protected BasePendingResult(Looper paramLooper)
  {
    this$0 = new CallbackHandler(paramLooper);
    request = new WeakReference(null);
  }
  
  protected BasePendingResult(com.google.android.gms.common.package_12.GoogleApiClient paramGoogleApiClient)
  {
    Looper localLooper;
    if (paramGoogleApiClient != null) {
      localLooper = paramGoogleApiClient.getLooper();
    } else {
      localLooper = Looper.getMainLooper();
    }
    this$0 = new CallbackHandler(localLooper);
    request = new WeakReference(paramGoogleApiClient);
  }
  
  protected BasePendingResult(CallbackHandler paramCallbackHandler)
  {
    this$0 = ((CallbackHandler)Preconditions.checkNotNull(paramCallbackHandler, "CallbackHandler must not be null"));
    request = new WeakReference(null);
  }
  
  public static void decode(com.google.android.gms.common.package_12.Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {
      try
      {
        ((Releasable)paramResult).release();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        paramResult = String.valueOf(paramResult);
        paramResult.length();
        Log.w("BasePendingResult", "Unable to release ".concat(paramResult), localRuntimeException);
      }
    }
  }
  
  private final com.google.android.gms.common.package_12.Result set()
  {
    Object localObject = delegate;
    try
    {
      Preconditions.checkState(value ^ true, "Result has already been consumed.");
      Preconditions.checkState(isReady(), "Result is not ready.");
      com.google.android.gms.common.package_12.Result localResult = data;
      data = null;
      next = null;
      value = true;
      localObject = (zadb)status.getAndSet(null);
      if (localObject != null) {
        unknownFields.data.remove(this);
      }
      return (com.google.android.gms.common.package_12.Result)Preconditions.checkNotNull(localResult);
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private final void set(com.google.android.gms.common.package_12.Result paramResult)
  {
    data = paramResult;
    type = paramResult.getStatus();
    key = null;
    ready.countDown();
    if (state)
    {
      next = null;
    }
    else
    {
      paramResult = next;
      if (paramResult == null)
      {
        if ((data instanceof Releasable)) {
          mResultGuardian = new Row(this, null);
        }
      }
      else
      {
        this$0.removeMessages(2);
        this$0.add(paramResult, set());
      }
    }
    paramResult = args;
    int j = paramResult.size();
    int i = 0;
    while (i < j)
    {
      ((com.google.android.gms.common.package_12.PendingResult.StatusListener)paramResult.get(i)).onComplete(type);
      i += 1;
    }
    args.clear();
  }
  
  public final void addStatusListener(com.google.android.gms.common.package_12.PendingResult.StatusListener paramStatusListener)
  {
    boolean bool;
    if (paramStatusListener != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Callback cannot be null.");
    Object localObject = delegate;
    try
    {
      if (isReady()) {
        paramStatusListener.onComplete(type);
      } else {
        args.add(paramStatusListener);
      }
      return;
    }
    catch (Throwable paramStatusListener)
    {
      throw paramStatusListener;
    }
  }
  
  public final com.google.android.gms.common.package_12.Result await()
  {
    Preconditions.checkNotMainThread("await must not be called on the UI thread");
    boolean bool2 = value;
    boolean bool1 = true;
    Preconditions.checkState(bool2 ^ true, "Result has already been consumed");
    if (head != null) {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "Cannot await if then() has been called.");
    CountDownLatch localCountDownLatch = ready;
    try
    {
      localCountDownLatch.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
    Preconditions.checkState(isReady(), "Result is not ready.");
    return set();
  }
  
  public final com.google.android.gms.common.package_12.Result await(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L) {
      Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
    }
    boolean bool2 = value;
    boolean bool1 = true;
    Preconditions.checkState(bool2 ^ true, "Result has already been consumed.");
    if (head != null) {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "Cannot await if then() has been called.");
    CountDownLatch localCountDownLatch = ready;
    try
    {
      bool1 = localCountDownLatch.await(paramLong, paramTimeUnit);
      if (bool1) {
        break label90;
      }
      paramTimeUnit = Status.RESULT_TIMEOUT;
      forceFailureUnlessReady(paramTimeUnit);
    }
    catch (InterruptedException paramTimeUnit)
    {
      for (;;) {}
    }
    forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
    label90:
    Preconditions.checkState(isReady(), "Result is not ready.");
    return set();
  }
  
  public final void call()
  {
    boolean bool3 = cancelled;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3) {
      if (((Boolean)guard.get()).booleanValue()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    cancelled = bool1;
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/google/android/gms/common/package_12/internal/BasePendingResult:delegate	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 215	com/google/android/gms/common/package_12/internal/BasePendingResult:state	Z
    //   11: ifne +54 -> 65
    //   14: aload_0
    //   15: getfield 163	com/google/android/gms/common/package_12/internal/BasePendingResult:value	Z
    //   18: ifeq +6 -> 24
    //   21: goto +44 -> 65
    //   24: aload_0
    //   25: getfield 210	com/google/android/gms/common/package_12/internal/BasePendingResult:key	Lcom/google/android/gms/common/internal/ICancelToken;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +9 -> 39
    //   33: aload_2
    //   34: invokeinterface 311 1 0
    //   39: aload_0
    //   40: getfield 157	com/google/android/gms/common/package_12/internal/BasePendingResult:data	Lcom/google/android/gms/common/package_12/Result;
    //   43: invokestatic 313	com/google/android/gms/common/package_12/internal/BasePendingResult:decode	(Lcom/google/android/gms/common/package_12/Result;)V
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 215	com/google/android/gms/common/package_12/internal/BasePendingResult:state	Z
    //   51: aload_0
    //   52: aload_0
    //   53: getstatic 316	com/google/android/gms/common/package_12/Status:RESULT_CANCELED	Lcom/google/android/gms/common/package_12/Status;
    //   56: invokevirtual 320	com/google/android/gms/common/package_12/internal/BasePendingResult:createFailedResult	(Lcom/google/android/gms/common/package_12/Status;)Lcom/google/android/gms/common/package_12/Result;
    //   59: invokespecial 322	com/google/android/gms/common/package_12/internal/BasePendingResult:set	(Lcom/google/android/gms/common/package_12/Result;)V
    //   62: aload_1
    //   63: monitorexit
    //   64: return
    //   65: aload_1
    //   66: monitorexit
    //   67: return
    //   68: astore_2
    //   69: aload_1
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    //   73: astore_2
    //   74: goto -35 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	BasePendingResult
    //   4	66	1	localObject	Object
    //   28	6	2	localICancelToken	ICancelToken
    //   68	4	2	localThrowable	Throwable
    //   73	1	2	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   7	21	68	java/lang/Throwable
    //   24	29	68	java/lang/Throwable
    //   33	39	68	java/lang/Throwable
    //   39	64	68	java/lang/Throwable
    //   65	67	68	java/lang/Throwable
    //   69	71	68	java/lang/Throwable
    //   33	39	73	android/os/RemoteException
  }
  
  protected abstract com.google.android.gms.common.package_12.Result createFailedResult(Status paramStatus);
  
  public final void forceFailureUnlessReady(Status paramStatus)
  {
    Object localObject = delegate;
    try
    {
      if (!isReady())
      {
        setResult(createFailedResult(paramStatus));
        result = true;
      }
      return;
    }
    catch (Throwable paramStatus)
    {
      throw paramStatus;
    }
  }
  
  public final boolean isCanceled()
  {
    Object localObject = delegate;
    try
    {
      boolean bool = state;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final boolean isCancelled()
  {
    Object localObject = delegate;
    try
    {
      if (((com.google.android.gms.common.package_12.GoogleApiClient)request.get() == null) || (!cancelled)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final boolean isReady()
  {
    return ready.getCount() == 0L;
  }
  
  public final void next(zadb paramZadb)
  {
    status.set(paramZadb);
  }
  
  protected final void setCancelToken(ICancelToken paramICancelToken)
  {
    Object localObject = delegate;
    try
    {
      key = paramICancelToken;
      return;
    }
    catch (Throwable paramICancelToken)
    {
      throw paramICancelToken;
    }
  }
  
  public final void setResult(com.google.android.gms.common.package_12.Result paramResult)
  {
    Object localObject = delegate;
    try
    {
      if ((!result) && (!state))
      {
        isReady();
        Preconditions.checkState(isReady() ^ true, "Results have already been set");
        Preconditions.checkState(value ^ true, "Result has already been consumed");
        set(paramResult);
        return;
      }
      decode(paramResult);
      return;
    }
    catch (Throwable paramResult)
    {
      throw paramResult;
    }
  }
  
  public final void setResultCallback(com.google.android.gms.common.package_12.ResultCallback paramResultCallback)
  {
    Object localObject = delegate;
    if (paramResultCallback == null) {}
    try
    {
      next = null;
      return;
    }
    catch (Throwable paramResultCallback)
    {
      boolean bool2;
      throw paramResultCallback;
    }
    bool2 = value;
    boolean bool1 = true;
    Preconditions.checkState(bool2 ^ true, "Result has already been consumed.");
    if (head == null) {
      break label47;
    }
    for (;;)
    {
      label47:
      Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
      if (isCanceled()) {
        return;
      }
      if (isReady()) {
        this$0.add(paramResultCallback, set());
      } else {
        next = paramResultCallback;
      }
      return;
      bool1 = false;
    }
  }
  
  public final void setResultCallback(com.google.android.gms.common.package_12.ResultCallback paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    Object localObject = delegate;
    if (paramResultCallback == null) {}
    try
    {
      next = null;
      return;
    }
    catch (Throwable paramResultCallback)
    {
      boolean bool2;
      throw paramResultCallback;
    }
    bool2 = value;
    boolean bool1 = true;
    Preconditions.checkState(bool2 ^ true, "Result has already been consumed.");
    if (head == null) {
      break label50;
    }
    for (;;)
    {
      label50:
      Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
      if (isCanceled()) {
        return;
      }
      if (isReady())
      {
        this$0.add(paramResultCallback, set());
      }
      else
      {
        next = paramResultCallback;
        paramResultCallback = this$0;
        paramLong = paramTimeUnit.toMillis(paramLong);
        paramResultCallback.sendMessageDelayed(paramResultCallback.obtainMessage(2, this), paramLong);
      }
      return;
      bool1 = false;
    }
  }
  
  public final TransformedResult then(ResultTransform paramResultTransform)
  {
    Preconditions.checkState(value ^ true, "Result has already been consumed.");
    Object localObject = delegate;
    for (;;)
    {
      try
      {
        zada localZada = head;
        boolean bool2 = false;
        if (localZada == null)
        {
          bool1 = true;
          Preconditions.checkState(bool1, "Cannot call then() twice.");
          bool1 = bool2;
          if (next == null) {
            bool1 = true;
          }
          Preconditions.checkState(bool1, "Cannot call then() if callbacks are set.");
          Preconditions.checkState(state ^ true, "Cannot call then() if result was canceled.");
          cancelled = true;
          head = new zada(request);
          paramResultTransform = head.then(paramResultTransform);
          if (isReady()) {
            this$0.add(head, set());
          } else {
            next = head;
          }
          return paramResultTransform;
        }
      }
      catch (Throwable paramResultTransform)
      {
        throw paramResultTransform;
      }
      boolean bool1 = false;
    }
  }
  
  @VisibleForTesting
  public class CallbackHandler<R extends com.google.android.gms.common.api.Result>
    extends zaq
  {
    public CallbackHandler()
    {
      super();
    }
    
    public CallbackHandler()
    {
      super();
    }
    
    public final void add(com.google.android.gms.common.package_12.ResultCallback paramResultCallback, com.google.android.gms.common.package_12.Result paramResult)
    {
      int i = BasePendingResult.sizeinbits;
      sendMessage(obtainMessage(1, new Pair((com.google.android.gms.common.package_12.ResultCallback)Preconditions.checkNotNull(paramResultCallback), paramResult)));
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = what;
      if (i != 1)
      {
        if (i != 2)
        {
          paramMessage = new StringBuilder(45);
          paramMessage.append("Don't know how to handle message: ");
          paramMessage.append(i);
          localObject = new Exception();
          Log.wtf("BasePendingResult", paramMessage.toString(), (Throwable)localObject);
          return;
        }
        ((BasePendingResult)obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
        return;
      }
      Object localObject = (Pair)obj;
      paramMessage = (com.google.android.gms.common.package_12.ResultCallback)first;
      localObject = (com.google.android.gms.common.package_12.Result)second;
      try
      {
        paramMessage.onResult((com.google.android.gms.common.package_12.Result)localObject);
        return;
      }
      catch (RuntimeException paramMessage)
      {
        BasePendingResult.decode((com.google.android.gms.common.package_12.Result)localObject);
        throw paramMessage;
      }
    }
  }
}
