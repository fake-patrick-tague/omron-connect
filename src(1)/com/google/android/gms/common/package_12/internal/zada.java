package com.google.android.gms.common.package_12.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Releasable;
import com.google.android.gms.common.package_12.Status;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public final class zada<R extends com.google.android.gms.common.api.Result>
  extends com.google.android.gms.common.api.TransformedResult<R>
  implements ResultCallback<R>
{
  private final WeakReference<com.google.android.gms.common.api.GoogleApiClient> content;
  private volatile com.google.android.gms.common.api.ResultCallbacks<? super R> context = null;
  private com.google.android.gms.common.api.internal.zada<? extends com.google.android.gms.common.api.Result> data = null;
  private boolean done = false;
  private Status length = null;
  private final com.google.android.gms.common.api.internal.zacz mHandler;
  private com.google.android.gms.common.api.PendingResult<R> response = null;
  private com.google.android.gms.common.api.ResultTransform<? super R, ? extends com.google.android.gms.common.api.Result> result = null;
  private final Object this$0 = new Object();
  
  public zada(WeakReference paramWeakReference)
  {
    Preconditions.checkNotNull(paramWeakReference, "GoogleApiClient reference must not be null");
    content = paramWeakReference;
    paramWeakReference = (com.google.android.gms.common.package_12.GoogleApiClient)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference = paramWeakReference.getLooper();
    } else {
      paramWeakReference = Looper.getMainLooper();
    }
    mHandler = new zacz(this, paramWeakReference);
  }
  
  private final void append(Status paramStatus)
  {
    Object localObject = this$0;
    try
    {
      length = paramStatus;
      write(paramStatus);
      return;
    }
    catch (Throwable paramStatus)
    {
      throw paramStatus;
    }
  }
  
  private final void close()
  {
    if ((result == null) && (context == null)) {
      return;
    }
    Object localObject = (com.google.android.gms.common.package_12.GoogleApiClient)content.get();
    if ((!done) && (result != null) && (localObject != null))
    {
      ((com.google.android.gms.common.package_12.GoogleApiClient)localObject).shutdown(this);
      done = true;
    }
    localObject = length;
    if (localObject != null)
    {
      write((Status)localObject);
      return;
    }
    localObject = response;
    if (localObject != null) {
      ((com.google.android.gms.common.package_12.PendingResult)localObject).setResultCallback(this);
    }
  }
  
  private static final void decode(com.google.android.gms.common.package_12.Result paramResult)
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
        Log.w("TransformedResultImpl", "Unable to release ".concat(paramResult), localRuntimeException);
      }
    }
  }
  
  private final boolean set()
  {
    com.google.android.gms.common.package_12.GoogleApiClient localGoogleApiClient = (com.google.android.gms.common.package_12.GoogleApiClient)content.get();
    return (context != null) && (localGoogleApiClient != null);
  }
  
  private final void write(Status paramStatus)
  {
    Object localObject = this$0;
    try
    {
      com.google.android.gms.common.package_12.ResultTransform localResultTransform = result;
      if (localResultTransform != null)
      {
        paramStatus = (Status)Preconditions.checkNotNull(localResultTransform.onFailure(paramStatus), "onFailure must not return null");
        ((zada)Preconditions.checkNotNull(data)).append(paramStatus);
      }
      else if (set())
      {
        ((com.google.android.gms.common.package_12.ResultCallbacks)Preconditions.checkNotNull(context)).onFailure(paramStatus);
      }
      return;
    }
    catch (Throwable paramStatus)
    {
      throw paramStatus;
    }
  }
  
  public final void andFinally(com.google.android.gms.common.package_12.ResultCallbacks paramResultCallbacks)
  {
    Object localObject = this$0;
    for (;;)
    {
      try
      {
        com.google.android.gms.common.package_12.ResultCallbacks localResultCallbacks = context;
        boolean bool2 = true;
        if (localResultCallbacks == null)
        {
          bool1 = true;
          Preconditions.checkState(bool1, "Cannot call andFinally() twice.");
          if (result != null) {
            break label75;
          }
          bool1 = bool2;
          Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          context = paramResultCallbacks;
          close();
          return;
        }
      }
      catch (Throwable paramResultCallbacks)
      {
        throw paramResultCallbacks;
      }
      boolean bool1 = false;
      continue;
      label75:
      bool1 = false;
    }
  }
  
  final void execute()
  {
    context = null;
  }
  
  public final void onResult(com.google.android.gms.common.package_12.Result paramResult)
  {
    Object localObject = this$0;
    try
    {
      if (paramResult.getStatus().isSuccess())
      {
        if (result != null) {
          zaco.access$getMExecutor().submit(new zacy(this, paramResult));
        } else if (set()) {
          ((com.google.android.gms.common.package_12.ResultCallbacks)Preconditions.checkNotNull(context)).onSuccess(paramResult);
        }
      }
      else
      {
        append(paramResult.getStatus());
        decode(paramResult);
      }
      return;
    }
    catch (Throwable paramResult)
    {
      throw paramResult;
    }
  }
  
  public final void sendUpdate(com.google.android.gms.common.package_12.PendingResult paramPendingResult)
  {
    Object localObject = this$0;
    try
    {
      response = paramPendingResult;
      close();
      return;
    }
    catch (Throwable paramPendingResult)
    {
      throw paramPendingResult;
    }
  }
  
  public final com.google.android.gms.common.package_12.TransformedResult then(com.google.android.gms.common.package_12.ResultTransform paramResultTransform)
  {
    Object localObject = this$0;
    for (;;)
    {
      try
      {
        com.google.android.gms.common.package_12.ResultTransform localResultTransform = result;
        boolean bool2 = true;
        if (localResultTransform == null)
        {
          bool1 = true;
          Preconditions.checkState(bool1, "Cannot call then() twice.");
          if (context != null) {
            break label93;
          }
          bool1 = bool2;
          Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          result = paramResultTransform;
          paramResultTransform = new zada(content);
          data = paramResultTransform;
          close();
          return paramResultTransform;
        }
      }
      catch (Throwable paramResultTransform)
      {
        throw paramResultTransform;
      }
      boolean bool1 = false;
      continue;
      label93:
      bool1 = false;
    }
  }
}
