package com.google.android.gms.internal.measurement;

public final class zzeq
  extends zzke
  implements zzlm
{
  private static final zzeq time;
  private int alias;
  private String major = "";
  private String minor = "";
  private int pass;
  private boolean showIcons;
  private String uuid = "";
  
  static
  {
    zzeq localZzeq = new zzeq();
    time = localZzeq;
    zzke.zzbJ(zzeq.class, localZzeq);
  }
  
  private zzeq() {}
  
  public static zzeq method_7()
  {
    return time;
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
            return time;
          }
          return new zzem(null);
        }
        return new zzeq();
      }
      paramObject1 = zzeo.services;
      return zzke.zzbI(time, "\001\005\000\001\001\005\005\000\000\000\001?\000\002?\001\003?\002\004?\003\005?\004", new Object[] { "zze", "zzf", paramObject1, "zzg", "zzh", "zzi", "zzj" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean equals()
  {
    return (alias & 0x10) != 0;
  }
  
  public final String getMajor()
  {
    return major;
  }
  
  public final String getMinor()
  {
    return minor;
  }
  
  public final String getUUID()
  {
    return uuid;
  }
  
  public final boolean hasAlias()
  {
    return (alias & 0x1) != 0;
  }
  
  public final boolean isSigned()
  {
    return (alias & 0x4) != 0;
  }
  
  public final boolean next()
  {
    return (alias & 0x8) != 0;
  }
  
  public final boolean passwordInput()
  {
    return showIcons;
  }
  
  public final boolean set()
  {
    return (alias & 0x2) != 0;
  }
  
  public final int testConnection()
  {
    int i = zzep.testConnection(pass);
    if (i == 0) {
      return 1;
    }
    return i;
  }
}
