package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzgi
  implements Runnable
{
  zzgi(zzgq paramZzgq, Item paramItem) {}
  
  public final void run()
  {
    zzgq.getInstance(id).write();
    zzkz localZzkz = zzgq.getInstance(id);
    Item localItem = key;
    localZzkz.zzaz().append();
    localZzkz.add();
    Preconditions.checkNotEmpty(name);
    zzai localZzai1 = zzai.parse(url);
    zzai localZzai2 = localZzkz.get(name);
    localZzkz.zzay().next().append("Setting consent, package, consent", name, localZzai1);
    localZzkz.put(name, localZzai1);
    if (localZzai1.get(localZzai2)) {
      localZzkz.load(localItem);
    }
  }
}
