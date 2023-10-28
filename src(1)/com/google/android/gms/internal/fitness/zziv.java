package com.google.android.gms.internal.fitness;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zziv
{
  private static final zziv zzaat = new zziv();
  private final zziz zzaau = new zzhx();
  private final ConcurrentMap<Class<?>, zzja<?>> zzaav = new ConcurrentHashMap();
  
  private zziv() {}
  
  public static zziv zzcy()
  {
    return zzaat;
  }
  
  public final zzja a(Class paramClass)
  {
    zzhc.get(paramClass, "messageType");
    zzja localZzja2 = (zzja)zzaav.get(paramClass);
    zzja localZzja1 = localZzja2;
    if (localZzja2 == null)
    {
      localZzja1 = zzaau.getIdentifier(paramClass);
      zzhc.get(paramClass, "messageType");
      zzhc.get(localZzja1, "schema");
      paramClass = (zzja)zzaav.putIfAbsent(paramClass, localZzja1);
      if (paramClass != null) {
        return paramClass;
      }
    }
    return localZzja1;
  }
  
  public final zzja a(Object paramObject)
  {
    return a(paramObject.getClass());
  }
}
