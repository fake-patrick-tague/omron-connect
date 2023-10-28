package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzlh
{
  private static final zzlg ONLY;
  private static final zzlg RECONNECT = new zzlg();
  
  static
  {
    try
    {
      localObject = Class.forName("com.google.protobuf.MapFieldSchemaFull");
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[0]);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      localObject = (zzlg)localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = null;
    ONLY = (zzlg)localObject;
  }
  
  static zzlg forName()
  {
    return RECONNECT;
  }
  
  static zzlg valueOf()
  {
    return ONLY;
  }
}
