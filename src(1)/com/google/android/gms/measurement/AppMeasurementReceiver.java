package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzfh;
import com.google.android.gms.measurement.internal.zzfh.zza;
import v7.level.view.WakefulBroadcastReceiver;

public final class AppMeasurementReceiver
  extends WakefulBroadcastReceiver
  implements zzfh.zza
{
  private zzfh alarm;
  
  public AppMeasurementReceiver() {}
  
  public BroadcastReceiver.PendingResult doGoAsync()
  {
    return goAsync();
  }
  
  public void doStartService(Context paramContext, Intent paramIntent)
  {
    WakefulBroadcastReceiver.startWakefulService(paramContext, paramIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (alarm == null) {
      alarm = new zzfh(this);
    }
    alarm.setAlarm(paramContext, paramIntent);
  }
}
