package com.google.android.gms.internal.fitness;

final class zzfv
{
  private static final Class<?> zzty = findClass("libcore.io.Memory");
  private static final boolean zztz;
  
  static
  {
    boolean bool;
    if (findClass("org.robolectric.Robolectric") != null) {
      bool = true;
    } else {
      bool = false;
    }
    zztz = bool;
  }
  
  private static Class findClass(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  static boolean zzat()
  {
    return (zzty != null) && (!zztz);
  }
  
  static Class zzau()
  {
    return zzty;
  }
}
