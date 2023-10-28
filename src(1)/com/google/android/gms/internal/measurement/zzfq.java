package com.google.android.gms.internal.measurement;

public final class zzfq
  extends zzke
  implements zzlm
{
  private static final zzfq b;
  private long count;
  private int state;
  private int y;
  
  static
  {
    zzfq localZzfq = new zzfq();
    b = localZzfq;
    zzke.zzbJ(zzfq.class, localZzfq);
  }
  
  private zzfq() {}
  
  public static zzfp getByteBuffer()
  {
    return (zzfp)b.zzbx();
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
            return b;
          }
          return new zzfp(null);
        }
        return new zzfq();
      }
      return zzke.zzbI(b, "\001\002\000\001\001\002\002\000\000\000\001?\000\002?\001", new Object[] { "zze", "zzf", "zzg" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean isMounted()
  {
    return (y & 0x1) != 0;
  }
  
  public final long length()
  {
    return count;
  }
  
  public final int next()
  {
    return state;
  }
  
  public final boolean skipChar()
  {
    return (y & 0x2) != 0;
  }
}
