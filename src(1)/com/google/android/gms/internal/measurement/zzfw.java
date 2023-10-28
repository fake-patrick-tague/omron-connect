package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfw
  extends zzke
  implements zzlm
{
  private static final zzfw name;
  private long currentTime;
  private zzkl delegate = zzke.zzbD();
  private String label = "";
  private float last;
  private String provider = "";
  private int value;
  private double x;
  
  static
  {
    zzfw localZzfw = new zzfw();
    name = localZzfw;
    zzke.zzbJ(zzfw.class, localZzfw);
  }
  
  private zzfw() {}
  
  public static zzfv get()
  {
    return (zzfv)name.zzbx();
  }
  
  private final void writeAttribute()
  {
    zzkl localZzkl = delegate;
    if (!localZzkl.get()) {
      delegate = zzke.zzbE(localZzkl);
    }
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
            return name;
          }
          return new zzfv(null);
        }
        return new zzfw();
      }
      return zzke.zzbI(name, "\001\006\000\001\001\006\006\000\001\000\001?\000\002?\001\003?\002\004?\003\005?\004\006\033", new Object[] { "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzfw.class });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean add()
  {
    return (value & 0x2) != 0;
  }
  
  public final boolean booleanValue()
  {
    return (value & 0x10) != 0;
  }
  
  public final long currentTimeMillis()
  {
    return currentTime;
  }
  
  public final List delegate()
  {
    return delegate;
  }
  
  public final float getKey()
  {
    return last;
  }
  
  public final String getLabel()
  {
    return label;
  }
  
  public final String getValue()
  {
    return provider;
  }
  
  public final boolean isBufferFull()
  {
    return (value & 0x1) != 0;
  }
  
  public final boolean remove()
  {
    return (value & 0x4) != 0;
  }
  
  public final boolean sendChar()
  {
    return (value & 0x8) != 0;
  }
  
  public final int size()
  {
    return delegate.size();
  }
  
  public final double split()
  {
    return x;
  }
}
