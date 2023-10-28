package com.google.android.gms.internal.fitness;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzgp
{
  private static volatile boolean zzus;
  private static boolean zzut;
  private static volatile zzgp zzuu;
  private static final zzgp zzuv = new zzgp(true);
  private final Map<Object, Object> zzuw;
  
  zzgp()
  {
    zzuw = new HashMap();
  }
  
  private zzgp(boolean paramBoolean)
  {
    zzuw = Collections.emptyMap();
  }
  
  public static zzgp zzbf()
  {
    Object localObject = zzuu;
    if (localObject == null) {
      try
      {
        zzgp localZzgp = zzuu;
        localObject = localZzgp;
        if (localZzgp == null)
        {
          localObject = zzuv;
          zzuu = (zzgp)localObject;
        }
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return localThrowable;
  }
}
