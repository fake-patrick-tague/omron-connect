package com.google.android.gms.internal.fitness;

import java.lang.reflect.Constructor;

final class zzgq
{
  private static final zzgo<?> zzux = new zzgr();
  private static final zzgo<?> zzuy = zzbg();
  
  private static zzgo zzbg()
  {
    try
    {
      Object localObject = Class.forName("com.google.protobuf.ExtensionSchemaFull");
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[0]);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      return (zzgo)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  static zzgo zzbh()
  {
    return zzux;
  }
  
  static zzgo zzbi()
  {
    zzgo localZzgo = zzuy;
    if (localZzgo != null) {
      return localZzgo;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
}
