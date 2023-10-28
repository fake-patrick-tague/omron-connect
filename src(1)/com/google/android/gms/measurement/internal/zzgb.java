package com.google.android.gms.measurement.internal;

final class zzgb
  implements Runnable
{
  zzgb(zzgq paramZzgq, zzac paramZzac) {}
  
  public final void run()
  {
    zzgq.getInstance(id).write();
    if (number.context.get() == null)
    {
      zzgq.getInstance(id).encode(number);
      return;
    }
    zzgq.getInstance(id).write(number);
  }
}
