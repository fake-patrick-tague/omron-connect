package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class zzjp
  implements Runnable
{
  zzjp(zzjr paramZzjr) {}
  
  public final void run()
  {
    zzjs localZzjs = val$mPath.this$0;
    Context localContext = this$0.zzau();
    val$mPath.this$0.this$0.zzaw();
    zzjs.addTo(localZzjs, new ComponentName(localContext, "com.google.android.gms.measurement.AppMeasurementService"));
  }
}
