package com.google.android.gms.internal.measurement;

public final class zzgl
  extends zzke
  implements zzlm
{
  private static final zzgl h;
  private int c;
  private String e = "";
  private String i = "";
  private float mCoeffX;
  private long n;
  private double s;
  private long y;
  
  static
  {
    zzgl localZzgl = new zzgl();
    h = localZzgl;
    zzke.zzbJ(zzgl.class, localZzgl);
  }
  
  private zzgl() {}
  
  public static zzgk valueOf()
  {
    return (zzgk)h.zzbx();
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
            return h;
          }
          return new zzgk(null);
        }
        return new zzgl();
      }
      return zzke.zzbI(h, "\001\006\000\001\001\006\006\000\000\000\001?\000\002?\001\003?\002\004?\003\005?\004\006?\005", new Object[] { "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean a()
  {
    return (c & 0x4) != 0;
  }
  
  public final boolean execute()
  {
    return (c & 0x1) != 0;
  }
  
  public final long getKey()
  {
    return y;
  }
  
  public final double getValue()
  {
    return s;
  }
  
  public final String intValue()
  {
    return i;
  }
  
  public final long length()
  {
    return n;
  }
  
  public final boolean match()
  {
    return (c & 0x8) != 0;
  }
  
  public final String next()
  {
    return e;
  }
  
  public final boolean remove()
  {
    return (c & 0x20) != 0;
  }
}
