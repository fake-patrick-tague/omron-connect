package com.google.android.gms.common.package_12.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.package_12.ApiException;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zacd<T>
  implements OnCompleteListener<T>
{
  private final int account;
  private final long context;
  private final GoogleApiManager this$0;
  private final com.google.android.gms.common.api.internal.ApiKey<?> type;
  private final long user;
  
  zacd(GoogleApiManager paramGoogleApiManager, int paramInt, ApiKey paramApiKey, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    this$0 = paramGoogleApiManager;
    account = paramInt;
    type = paramApiKey;
    user = paramLong1;
    context = paramLong2;
  }
  
  private static ConnectionTelemetryConfiguration command(zabq paramZabq, BaseGmsClient paramBaseGmsClient, int paramInt)
  {
    paramBaseGmsClient = paramBaseGmsClient.getTelemetryConfiguration();
    if ((paramBaseGmsClient != null) && (paramBaseGmsClient.getMethodInvocationTelemetryEnabled()))
    {
      int[] arrayOfInt = paramBaseGmsClient.getMethodInvocationMethodKeyAllowlist();
      if (arrayOfInt == null)
      {
        arrayOfInt = paramBaseGmsClient.getMethodInvocationMethodKeyDisallowlist();
        if ((arrayOfInt != null) && (ArrayUtils.contains(arrayOfInt, paramInt))) {
          return null;
        }
      }
      else if (!ArrayUtils.contains(arrayOfInt, paramInt))
      {
        return null;
      }
      if (paramZabq.recv() < paramBaseGmsClient.getMaxMethodInvocationsLogged()) {
        return paramBaseGmsClient;
      }
    }
    return null;
  }
  
  static zacd e(GoogleApiManager paramGoogleApiManager, int paramInt, ApiKey paramApiKey)
  {
    if (!paramGoogleApiManager.next()) {
      return null;
    }
    Object localObject1 = RootTelemetryConfigManager.getInstance().getConfig();
    boolean bool1;
    if (localObject1 != null)
    {
      if (!((RootTelemetryConfiguration)localObject1).getMethodInvocationTelemetryEnabled()) {
        return null;
      }
      boolean bool2 = ((RootTelemetryConfiguration)localObject1).getMethodTimingTelemetryEnabled();
      localObject1 = paramGoogleApiManager.get(paramApiKey);
      bool1 = bool2;
      if (localObject1 != null)
      {
        if (!(((zabq)localObject1).getContext() instanceof BaseGmsClient)) {
          return null;
        }
        Object localObject2 = (BaseGmsClient)((zabq)localObject1).getContext();
        bool1 = bool2;
        if (((BaseGmsClient)localObject2).hasConnectionInfo())
        {
          bool1 = bool2;
          if (!((BaseGmsClient)localObject2).isConnecting())
          {
            localObject2 = command((zabq)localObject1, (BaseGmsClient)localObject2, paramInt);
            if (localObject2 == null) {
              return null;
            }
            ((zabq)localObject1).clear();
            bool1 = ((ConnectionTelemetryConfiguration)localObject2).getMethodTimingTelemetryEnabled();
          }
        }
      }
    }
    else
    {
      bool1 = true;
    }
    long l1;
    if (bool1) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = 0L;
    }
    long l2;
    if (bool1) {
      l2 = SystemClock.elapsedRealtime();
    } else {
      l2 = 0L;
    }
    return new zacd(paramGoogleApiManager, paramInt, paramApiKey, l1, l2, null, null);
  }
  
  public final void onComplete(Task paramTask)
  {
    if (!this$0.next()) {
      return;
    }
    Object localObject = RootTelemetryConfigManager.getInstance().getConfig();
    if ((localObject != null) && (!((RootTelemetryConfiguration)localObject).getMethodInvocationTelemetryEnabled())) {
      return;
    }
    zabq localZabq = this$0.get(type);
    if (localZabq != null)
    {
      if (!(localZabq.getContext() instanceof BaseGmsClient)) {
        return;
      }
      BaseGmsClient localBaseGmsClient = (BaseGmsClient)localZabq.getContext();
      long l1 = user;
      int m = 1;
      int i2 = 0;
      int i;
      if (l1 > 0L) {
        i = 1;
      } else {
        i = 0;
      }
      int i4 = localBaseGmsClient.getGCoreServiceId();
      boolean bool2;
      int k;
      int n;
      boolean bool1;
      if (localObject != null)
      {
        bool2 = i & ((RootTelemetryConfiguration)localObject).getMethodTimingTelemetryEnabled();
        k = ((RootTelemetryConfiguration)localObject).getBatchPeriodMillis();
        int i3 = ((RootTelemetryConfiguration)localObject).getMaxMethodInvocationsInBatch();
        n = ((RootTelemetryConfiguration)localObject).getVersion();
        bool1 = bool2;
        i = i3;
        if (localBaseGmsClient.hasConnectionInfo())
        {
          bool1 = bool2;
          i = i3;
          if (!localBaseGmsClient.isConnecting())
          {
            localObject = command(localZabq, localBaseGmsClient, account);
            if (localObject == null) {
              return;
            }
            if ((((ConnectionTelemetryConfiguration)localObject).getMethodTimingTelemetryEnabled()) && (user > 0L)) {
              i = m;
            } else {
              i = 0;
            }
            m = ((ConnectionTelemetryConfiguration)localObject).getMaxMethodInvocationsLogged();
            bool1 = i;
            i = m;
          }
        }
        bool2 = bool1;
        m = i;
      }
      else
      {
        n = 0;
        m = 100;
        k = 5000;
        bool2 = i;
      }
      localObject = this$0;
      int j;
      if (paramTask.isSuccessful())
      {
        bool1 = false;
        i = i2;
      }
      else
      {
        if (paramTask.isCanceled()) {}
        for (i = 100;; i = 101)
        {
          j = -1;
          break;
          paramTask = paramTask.getException();
          if ((paramTask instanceof ApiException))
          {
            paramTask = ((ApiException)paramTask).getStatus();
            i = paramTask.getStatusCode();
            paramTask = paramTask.getConnectionResult();
            if (paramTask == null) {
              j = -1;
            } else {
              j = paramTask.getErrorCode();
            }
            break;
          }
        }
      }
      long l2;
      int i1;
      if (bool2)
      {
        l2 = user;
        l1 = System.currentTimeMillis();
        i1 = (int)(SystemClock.elapsedRealtime() - context);
      }
      else
      {
        l2 = 0L;
        l1 = 0L;
        i1 = -1;
      }
      ((GoogleApiManager)localObject).showToast(new MethodInvocation(account, i, j, l2, l1, null, null, i4, i1), n, k, m);
    }
  }
}
