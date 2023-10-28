package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzlt
{
  private static final zzlt collection = new zzlt();
  private final ConcurrentMap nodeList = new ConcurrentHashMap();
  private final zzlx nodes = new zzld();
  
  private zzlt() {}
  
  public static zzlt decorated()
  {
    return collection;
  }
  
  public final zzlw get(Class paramClass)
  {
    zzkm.get(paramClass, "messageType");
    zzlw localZzlw = (zzlw)nodeList.get(paramClass);
    if (localZzlw == null)
    {
      localZzlw = nodes.get(paramClass);
      zzkm.get(paramClass, "messageType");
      zzkm.get(localZzlw, "schema");
      paramClass = (zzlw)nodeList.putIfAbsent(paramClass, localZzlw);
      if (paramClass == null) {
        return localZzlw;
      }
      return paramClass;
    }
    return localZzlw;
  }
}
