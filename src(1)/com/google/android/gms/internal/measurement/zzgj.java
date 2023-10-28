package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgj
  extends zzke
  implements zzlm
{
  private static final zzgj b;
  private zzkk f = zzke.zzbB();
  private int key;
  private int query;
  
  static
  {
    zzgj localZzgj = new zzgj();
    b = localZzgj;
    zzke.zzbJ(zzgj.class, localZzgj);
  }
  
  private zzgj() {}
  
  public static zzgi getByteBuffer()
  {
    return (zzgi)b.zzbx();
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
          return new zzgi(null);
        }
        return new zzgj();
      }
      return zzke.zzbI(b, "\001\002\000\001\001\002\002\000\001\000\001?\000\002\024", new Object[] { "zze", "zzf", "zzg" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final long get(int paramInt)
  {
    return f.getValue(paramInt);
  }
  
  public final boolean getInteger()
  {
    return (query & 0x1) != 0;
  }
  
  public final List getValue()
  {
    return f;
  }
  
  public final int indexOf()
  {
    return key;
  }
  
  public final int length()
  {
    return f.size();
  }
}
