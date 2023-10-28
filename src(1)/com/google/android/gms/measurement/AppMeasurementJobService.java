package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzjy;
import com.google.android.gms.measurement.internal.zzjz;

public final class AppMeasurementJobService
  extends JobService
  implements zzjy
{
  private zzjz logger;
  
  public AppMeasurementJobService() {}
  
  private final zzjz info()
  {
    if (logger == null) {
      logger = new zzjz(this);
    }
    return logger;
  }
  
  public final void cleanup(Intent paramIntent) {}
  
  public void onCreate()
  {
    super.onCreate();
    info().onVCardReceived();
  }
  
  public void onDestroy()
  {
    info().transformBody();
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    info().updateDisplay(paramIntent);
  }
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    info().updateContent(paramJobParameters);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    info().isConnected(paramIntent);
    return true;
  }
  
  public final void removeTask(JobParameters paramJobParameters, boolean paramBoolean)
  {
    jobFinished(paramJobParameters, false);
  }
  
  public final boolean start(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}
