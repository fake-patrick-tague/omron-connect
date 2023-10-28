package com.google.android.gms.measurement.internal;

final class zzgm
  implements Runnable
{
  zzgm(zzgq paramZzgq, zzlc paramZzlc, Item paramItem) {}
  
  public final void run()
  {
    zzgq.getInstance(params).write();
    if (context.get() == null)
    {
      zzgq.getInstance(params).load(context, db);
      return;
    }
    zzgq.getInstance(params).execute(context, db);
  }
}
