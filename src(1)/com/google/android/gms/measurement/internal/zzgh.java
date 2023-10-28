package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzgh
  implements Runnable
{
  zzgh(zzgq paramZzgq, Item paramItem) {}
  
  public final void run()
  {
    zzgq.getInstance(val$activity).write();
    zzkz localZzkz = zzgq.getInstance(val$activity);
    Item localItem = val$item;
    localZzkz.zzaz().append();
    localZzkz.add();
    Preconditions.checkNotEmpty(name);
    localZzkz.get(localItem);
  }
}
