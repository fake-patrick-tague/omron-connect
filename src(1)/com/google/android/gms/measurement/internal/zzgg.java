package com.google.android.gms.measurement.internal;

final class zzgg
  implements Runnable
{
  zzgg(zzgq paramZzgq, Item paramItem) {}
  
  public final void run()
  {
    zzgq.getInstance(id).write();
    zzgq.getInstance(id).load(key);
  }
}
