package com.google.android.gms.internal.fitness;

public class zzhp
{
  private static final zzgp zztx = ;
  private zzfx zzze;
  private volatile zzik zzzf;
  private volatile zzfx zzzg;
  
  public zzhp() {}
  
  private final zzik xor(zzik paramZzik)
  {
    if (zzzf == null) {
      try
      {
        if (zzzf != null) {
          break label46;
        }
        zzzf = paramZzik;
        zzzg = zzfx.zzub;
      }
      catch (Throwable paramZzik)
      {
        throw paramZzik;
      }
    }
    label46:
    return zzzf;
  }
  
  public final zzik addValue(zzik paramZzik)
  {
    zzik localZzik = zzzf;
    zzze = null;
    zzzg = null;
    zzzf = paramZzik;
    return localZzik;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzhp)) {
      return false;
    }
    paramObject = (zzhp)paramObject;
    zzik localZzik1 = zzzf;
    zzik localZzik2 = zzzf;
    if ((localZzik1 == null) && (localZzik2 == null)) {
      return zzam().equals(paramObject.zzam());
    }
    if ((localZzik1 != null) && (localZzik2 != null)) {
      return localZzik1.equals(localZzik2);
    }
    if (localZzik1 != null) {
      return localZzik1.equals(paramObject.xor(localZzik1.zzbu()));
    }
    return xor(localZzik2.zzbu()).equals(localZzik2);
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final zzfx zzam()
  {
    if (zzzg != null) {
      return zzzg;
    }
    try
    {
      if (zzzg != null)
      {
        localZzfx = zzzg;
        return localZzfx;
      }
      if (zzzf == null) {
        zzzg = zzfx.zzub;
      } else {
        zzzg = zzzf.zzam();
      }
      zzfx localZzfx = zzzg;
      return localZzfx;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final int zzbp()
  {
    if (zzzg != null) {
      return zzzg.size();
    }
    if (zzzf != null) {
      return zzzf.zzbp();
    }
    return 0;
  }
}
