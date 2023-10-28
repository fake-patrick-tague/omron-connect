package com.google.android.gms.internal.fitness;

import java.lang.reflect.Method;

final class zzhx
  implements zziz
{
  private static final zzih zzzp = new zzia();
  private final zzih zzzo;
  
  public zzhx()
  {
    this(new zzhz(new zzih[] { zzgz.zzbv(), zzcl() }));
  }
  
  private zzhx(zzih paramZzih)
  {
    zzzo = ((zzih)zzhc.get(paramZzih, "messageInfoFactory"));
  }
  
  private static boolean checkCallback(zzii paramZzii)
  {
    return paramZzii.zzcs() == zziw.zzaaw;
  }
  
  private static zzih zzcl()
  {
    try
    {
      Object localObject = Class.forName("com.google.protobuf.DescriptorMessageInfoFactory");
      localObject = ((Class)localObject).getDeclaredMethod("getInstance", new Class[0]);
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      return (zzih)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return zzzp;
  }
  
  public final zzja getIdentifier(Class paramClass)
  {
    zzjc.getField(paramClass);
    zzii localZzii = zzzo.get(paramClass);
    if (localZzii.zzct())
    {
      if (zzgy.class.isAssignableFrom(paramClass)) {
        return zzin.removeBody(zzjc.zzdj(), zzgq.zzbh(), localZzii.zzcu());
      }
      return zzin.removeBody(zzjc.zzdh(), zzgq.zzbi(), localZzii.zzcu());
    }
    if (zzgy.class.isAssignableFrom(paramClass))
    {
      if (checkCallback(localZzii)) {
        return zzio.decode(paramClass, localZzii, zzir.zzcw(), zzhu.zzck(), zzjc.zzdj(), zzgq.zzbh(), zzif.zzcq());
      }
      return zzio.decode(paramClass, localZzii, zzir.zzcw(), zzhu.zzck(), zzjc.zzdj(), null, zzif.zzcq());
    }
    if (checkCallback(localZzii)) {
      return zzio.decode(paramClass, localZzii, zzir.zzcv(), zzhu.zzcj(), zzjc.zzdh(), zzgq.zzbi(), zzif.zzcp());
    }
    return zzio.decode(paramClass, localZzii, zzir.zzcv(), zzhu.zzcj(), zzjc.zzdi(), null, zzif.zzcp());
  }
}
