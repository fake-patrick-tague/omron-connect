package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Intent;

public abstract interface zzjy
{
  public abstract void cleanup(Intent paramIntent);
  
  public abstract void removeTask(JobParameters paramJobParameters, boolean paramBoolean);
  
  public abstract boolean start(int paramInt);
}
