package com.google.android.gms.measurement.internal;

final class zzgp
  implements Runnable
{
  zzgp(zzgq paramZzgq, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public final void run()
  {
    Object localObject = data;
    if (localObject == null)
    {
      zzgq.getInstance(id).add(account, null);
      return;
    }
    localObject = new zzik(type, (String)localObject, state);
    zzgq.getInstance(id).add(account, (zzik)localObject);
  }
}
