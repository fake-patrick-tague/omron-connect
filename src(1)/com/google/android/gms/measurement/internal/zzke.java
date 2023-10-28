package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.util.Clock;

final class zzke
{
  private zzkd timer;
  
  zzke(zzki paramZzki) {}
  
  final void connectionClosed()
  {
    this$0.append();
    zzkd localZzkd = timer;
    if (localZzkd != null) {
      zzki.access$getA(this$0).removeCallbacks(localZzkd);
    }
    this$0.this$0.put().resource.put(false);
  }
  
  final void init(long paramLong)
  {
    timer = new zzkd(this, this$0.this$0.zzav().currentTimeMillis(), paramLong);
    zzki.access$getA(this$0).postDelayed(timer, 2000L);
  }
}
