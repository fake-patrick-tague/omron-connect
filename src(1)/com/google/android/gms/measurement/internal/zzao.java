package com.google.android.gms.measurement.internal;

final class zzao
  implements Runnable
{
  zzao(zzap paramZzap, zzgt paramZzgt) {}
  
  public final void run()
  {
    fetcher.zzaw();
    if (zzab.remove())
    {
      fetcher.zzaz().append(this);
      return;
    }
    boolean bool = priority.equals();
    zzap.b(priority, 0L);
    if (bool) {
      priority.doFetch();
    }
  }
}
