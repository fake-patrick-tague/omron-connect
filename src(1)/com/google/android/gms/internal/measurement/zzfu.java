package com.google.android.gms.internal.measurement;

public final class zzfu
  extends zzke
  implements zzlm
{
  private static final zzfu CACHE;
  private int modCount;
  private long size;
  private String value = "";
  
  static
  {
    zzfu localZzfu = new zzfu();
    CACHE = localZzfu;
    zzke.zzbJ(zzfu.class, localZzfu);
  }
  
  private zzfu() {}
  
  public static zzft of()
  {
    return (zzft)CACHE.zzbx();
  }
  
  protected final Object Decode(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramInt -= 1;
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return CACHE;
          }
          return new zzft(null);
        }
        return new zzfu();
      }
      return zzke.zzbI(CACHE, "\001\002\000\001\001\002\002\000\000\000\001?\000\002?\001", new Object[] { "zze", "zzf", "zzg" });
    }
    return Byte.valueOf((byte)1);
  }
}
