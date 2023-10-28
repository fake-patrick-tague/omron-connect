package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;

public final class zzjz
{
  private final Context this$0;
  
  public zzjz(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this$0 = paramContext;
  }
  
  private final zzeo iterator()
  {
    return zzfy.getInstance(this$0, null, null).zzay();
  }
  
  public final void e(Runnable paramRunnable)
  {
    zzkz localZzkz = zzkz.getInstance(this$0);
    localZzkz.zzaz().append(new zzjx(this, localZzkz, paramRunnable));
  }
  
  public final int handleMethod(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzfy localZzfy = zzfy.getInstance(this$0, null, null);
    zzeo localZzeo = localZzfy.zzay();
    if (paramIntent == null)
    {
      localZzeo.hasNext().append("AppMeasurementService started with null intent");
      return 2;
    }
    String str = paramIntent.getAction();
    localZzfy.zzaw();
    localZzeo.next().append("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      e(new zzjw(this, paramInt2, localZzeo, paramIntent));
    }
    return 2;
  }
  
  public final boolean isConnected(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      iterator().iterator().append("onUnbind called with null intent");
      return true;
    }
    paramIntent = paramIntent.getAction();
    iterator().next().append("onUnbind called for intent. action", paramIntent);
    return true;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      iterator().iterator().append("onBind called with null intent");
      return null;
    }
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(paramIntent)) {
      return new zzgq(zzkz.getInstance(this$0), null);
    }
    iterator().hasNext().append("onBind received unknown action", paramIntent);
    return null;
  }
  
  public final void onVCardReceived()
  {
    zzfy localZzfy = zzfy.getInstance(this$0, null, null);
    zzeo localZzeo = localZzfy.zzay();
    localZzfy.zzaw();
    localZzeo.next().append("Local AppMeasurementService is starting up");
  }
  
  public final void transformBody()
  {
    zzfy localZzfy = zzfy.getInstance(this$0, null, null);
    zzeo localZzeo = localZzfy.zzay();
    localZzfy.zzaw();
    localZzeo.next().append("Local AppMeasurementService is shutting down");
  }
  
  public final boolean updateContent(JobParameters paramJobParameters)
  {
    zzfy localZzfy = zzfy.getInstance(this$0, null, null);
    zzeo localZzeo = localZzfy.zzay();
    String str = paramJobParameters.getExtras().getString("action");
    localZzfy.zzaw();
    localZzeo.next().append("Local AppMeasurementJobService called. action", str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      e(new zzjv(this, localZzeo, paramJobParameters));
    }
    return true;
  }
  
  public final void updateDisplay(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      iterator().iterator().append("onRebind called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    iterator().next().append("onRebind called. action", paramIntent);
  }
}
