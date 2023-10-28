package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.Clock;

final class zzkf
  extends zzap
{
  zzkf(zzkg paramZzkg, zzgt paramZzgt)
  {
    super(paramZzgt);
  }
  
  public final void doFetch()
  {
    zzkg localZzkg = db;
    this$0.append();
    localZzkg.update(false, false, this$0.this$0.zzav().elapsedRealtime());
    this$0.this$0.a().execute(this$0.this$0.zzav().elapsedRealtime());
  }
}
