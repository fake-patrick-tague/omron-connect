package com.google.android.gms.internal.fitness;

final class zzix
  implements zzii
{
  private final int flags;
  private final String info;
  private final Object[] zzaaf;
  private final zzik zzzy;
  
  zzix(zzik paramZzik, String paramString, Object[] paramArrayOfObject)
  {
    zzzy = paramZzik;
    info = paramString;
    zzaaf = paramArrayOfObject;
    int i = paramString.charAt(0);
    if (i < 55296)
    {
      flags = i;
      return;
    }
    int k = i & 0x1FFF;
    int j = 13;
    i = 1;
    int m;
    for (;;)
    {
      m = paramString.charAt(i);
      if (m < 55296) {
        break;
      }
      k |= (m & 0x1FFF) << j;
      j += 13;
      i += 1;
    }
    flags = (k | m << j);
  }
  
  public final int zzcs()
  {
    if ((flags & 0x1) == 1) {
      return zziw.zzaaw;
    }
    return zziw.zzaax;
  }
  
  public final boolean zzct()
  {
    return (flags & 0x2) == 2;
  }
  
  public final zzik zzcu()
  {
    return zzzy;
  }
  
  final String zzcz()
  {
    return info;
  }
  
  final Object[] zzda()
  {
    return zzaaf;
  }
}
