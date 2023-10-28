package com.google.android.gms.measurement.internal;

final class zzjc
  extends zzap
{
  zzjc(zzjs paramZzjs, zzgt paramZzgt)
  {
    super(paramZzgt);
  }
  
  public final void doFetch()
  {
    zzjs localZzjs = query;
    localZzjs.append();
    if (!localZzjs.add()) {
      return;
    }
    this$0.zzay().next().append("Inactivity, disconnecting from the service");
    localZzjs.clear();
  }
}
