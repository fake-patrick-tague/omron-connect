package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzjy;
import com.google.android.gms.measurement.internal.zzjz;
import v7.level.view.WakefulBroadcastReceiver;

public final class AppMeasurementService
  extends Service
  implements zzjy
{
  private zzjz o;
  
  public AppMeasurementService() {}
  
  private final zzjz d()
  {
    if (o == null) {
      o = new zzjz(this);
    }
    return o;
  }
  
  public final void cleanup(Intent paramIntent)
  {
    WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return d().onBind(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    d().onVCardReceived();
  }
  
  public void onDestroy()
  {
    d().transformBody();
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    d().updateDisplay(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    d().handleMethod(paramIntent, paramInt1, paramInt2);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    d().isConnected(paramIntent);
    return true;
  }
  
  public final void removeTask(JobParameters paramJobParameters, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean start(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
}
