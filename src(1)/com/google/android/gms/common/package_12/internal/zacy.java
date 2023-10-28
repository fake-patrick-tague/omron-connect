package com.google.android.gms.common.package_12.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.ResultTransform;
import java.lang.ref.WeakReference;

final class zacy
  implements Runnable
{
  zacy(zada paramZada, Result paramResult) {}
  
  public final void run()
  {
    Object localObject1 = BasePendingResult.guard;
    Object localObject2 = Boolean.TRUE;
    GoogleApiClient localGoogleApiClient;
    for (;;)
    {
      try
      {
        ((ThreadLocal)localObject1).set(localObject2);
        localObject2 = ((ResultTransform)Preconditions.checkNotNull(zada.access$getResult(this$0))).onSuccess(val$result);
        zada localZada = this$0;
        zada.access$getMHandler(localZada).sendMessage(zada.access$getMHandler(localZada).obtainMessage(0, localObject2));
        ((ThreadLocal)localObject1).set(Boolean.FALSE);
        zada.setResult(this$0, val$result);
        localObject1 = (GoogleApiClient)zada.access$getMImageView(this$0).get();
        if (localObject1 == null) {
          break;
        }
        ((GoogleApiClient)localObject1).get(this$0);
        return;
      }
      catch (Throwable localThrowable) {}catch (RuntimeException localRuntimeException)
      {
        localObject2 = this$0;
        zada.access$getMHandler((zada)localObject2).sendMessage(zada.access$getMHandler((zada)localObject2).obtainMessage(1, localRuntimeException));
        BasePendingResult.guard.set(Boolean.FALSE);
        zada.setResult(this$0, val$result);
        localGoogleApiClient = (GoogleApiClient)zada.access$getMImageView(this$0).get();
        if (localGoogleApiClient == null) {
          return;
        }
      }
    }
    return;
    BasePendingResult.guard.set(Boolean.FALSE);
    zada.setResult(this$0, val$result);
    localObject2 = (GoogleApiClient)zada.access$getMImageView(this$0).get();
    if (localObject2 != null) {
      ((GoogleApiClient)localObject2).get(this$0);
    }
    throw localGoogleApiClient;
  }
}
