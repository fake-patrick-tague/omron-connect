package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzlr
{
  private static final zzlq BINARY = new zzlq();
  private static final zzlq STRING;
  
  static
  {
    try
    {
      localObject = Class.forName("com.google.protobuf.NewInstanceSchemaFull");
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[0]);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      localObject = (zzlq)localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = null;
    STRING = (zzlq)localObject;
  }
  
  static zzlq getType()
  {
    return BINARY;
  }
  
  static zzlq valueOf()
  {
    return STRING;
  }
}
