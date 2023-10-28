package com.google.android.gms.stats;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import v7.level.view.WakefulBroadcastReceiver;

@KeepForSdk
@ShowFirstParty
public abstract class GCoreWakefulBroadcastReceiver
  extends WakefulBroadcastReceiver
{
  public GCoreWakefulBroadcastReceiver() {}
  
  public static boolean completeWakefulIntent(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
  }
}
