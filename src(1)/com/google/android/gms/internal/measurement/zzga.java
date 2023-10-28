package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzga
  extends zzke
  implements zzlm
{
  private static final zzga singleton;
  private zzkl context = zzke.zzbD();
  
  static
  {
    zzga localZzga = new zzga();
    singleton = localZzga;
    zzke.zzbJ(zzga.class, localZzga);
  }
  
  private zzga() {}
  
  public static zzfz subtract()
  {
    return (zzfz)singleton.zzbx();
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
            return singleton;
          }
          return new zzfz(null);
        }
        return new zzga();
      }
      return zzke.zzbI(singleton, "\001\001\000\000\001\001\001\000\001\000\001\033", new Object[] { "zze", zzgc.class });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final zzgc getResource(int paramInt)
  {
    return (zzgc)context.get(0);
  }
  
  public final List listFiles()
  {
    return context;
  }
}
