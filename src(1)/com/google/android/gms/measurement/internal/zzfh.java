package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfh
{
  private final zzfh.zza alarmManager;
  
  public zzfh(zzfh.zza paramZza)
  {
    Preconditions.checkNotNull(paramZza);
    alarmManager = paramZza;
  }
  
  public final void setAlarm(Context paramContext, Intent paramIntent)
  {
    zzfy localZzfy = zzfy.getInstance(paramContext, null, null);
    zzeo localZzeo = localZzfy.zzay();
    if (paramIntent == null)
    {
      localZzeo.hasNext().append("Receiver called with null intent");
      return;
    }
    localZzfy.zzaw();
    paramIntent = paramIntent.getAction();
    localZzeo.next().append("Local receiver got", paramIntent);
    if ("com.google.android.gms.measurement.UPLOAD".equals(paramIntent))
    {
      paramIntent = new Intent().setClassName(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
      paramIntent.setAction("com.google.android.gms.measurement.UPLOAD");
      localZzeo.next().append("Starting wakeful intent.");
      alarmManager.doStartService(paramContext, paramIntent);
      return;
    }
    if ("com.android.vending.INSTALL_REFERRER".equals(paramIntent)) {
      localZzeo.hasNext().append("Install Referrer Broadcasts are deprecated");
    }
  }
}
