package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzjt
{
  private static final zzjr INSENSITIVE = new zzjs();
  private static final zzjr SYSTEM;
  
  static
  {
    try
    {
      localObject = Class.forName("com.google.protobuf.ExtensionSchemaFull");
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[0]);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      localObject = (zzjr)localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = null;
    SYSTEM = (zzjr)localObject;
  }
  
  static zzjr forName()
  {
    return INSENSITIVE;
  }
  
  static zzjr get()
  {
    zzjr localZzjr = SYSTEM;
    if (localZzjr != null) {
      return localZzjr;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
}
