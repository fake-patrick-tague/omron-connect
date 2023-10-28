package com.google.android.gms.measurement.internal;

final class zzkk
  extends zzap
{
  zzkk(zzkl paramZzkl, zzgt paramZzgt)
  {
    super(paramZzgt);
  }
  
  public final void doFetch()
  {
    db.update();
    db.this$0.zzay().next().append("Starting upload from DelayedRunnable");
    db.this$0.doInBackground();
  }
}
