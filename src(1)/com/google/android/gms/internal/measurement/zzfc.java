package com.google.android.gms.internal.measurement;

public final class zzfc
  extends zzke
  implements zzlm
{
  private static final zzfc spinner;
  private boolean LOGGING;
  private int empty;
  private boolean is3D;
  private int modCount;
  private String value = "";
  
  static
  {
    zzfc localZzfc = new zzfc();
    spinner = localZzfc;
    zzke.zzbJ(zzfc.class, localZzfc);
  }
  
  private zzfc() {}
  
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
            return spinner;
          }
          return new zzfb(null);
        }
        return new zzfc();
      }
      return zzke.zzbI(spinner, "\001\004\000\001\001\004\004\000\000\000\001?\000\002?\001\003?\002\004?\003", new Object[] { "zze", "zzf", "zzg", "zzh", "zzi" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final int empty()
  {
    return empty;
  }
  
  public final boolean get()
  {
    return (modCount & 0x2) != 0;
  }
  
  public final String getStringValue()
  {
    return value;
  }
  
  public final boolean is3D()
  {
    return is3D;
  }
  
  public final boolean isEmpty()
  {
    return (modCount & 0x4) != 0;
  }
  
  public final boolean newSession()
  {
    return LOGGING;
  }
  
  public final boolean next()
  {
    return (modCount & 0x8) != 0;
  }
}
