package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfs
  extends zzke
  implements zzlm
{
  private static final zzfs time;
  private zzkl current = zzke.zzbD();
  private long element;
  private String l = "";
  private int modulus;
  private int size;
  private long val;
  
  static
  {
    zzfs localZzfs = new zzfs();
    time = localZzfs;
    zzke.zzbJ(zzfs.class, localZzfs);
  }
  
  private zzfs() {}
  
  public static zzfr getKey()
  {
    return (zzfr)time.zzbx();
  }
  
  private final void readValue()
  {
    zzkl localZzkl = current;
    if (!localZzkl.get()) {
      current = zzke.zzbE(localZzkl);
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
            return time;
          }
          return new zzfr(null);
        }
        return new zzfs();
      }
      return zzke.zzbI(time, "\001\005\000\001\001\005\005\000\001\000\001\033\002?\000\003?\001\004?\002\005?\003", new Object[] { "zze", "zzf", zzfw.class, "zzg", "zzh", "zzi", "zzj" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean equals()
  {
    return (size & 0x2) != 0;
  }
  
  public final boolean execute()
  {
    return (size & 0x8) != 0;
  }
  
  public final List get()
  {
    return current;
  }
  
  public final zzfw getEdge(int paramInt)
  {
    return (zzfw)current.get(paramInt);
  }
  
  public final int getSize()
  {
    return modulus;
  }
  
  public final String getValue()
  {
    return l;
  }
  
  public final boolean hasNext()
  {
    return (size & 0x4) != 0;
  }
  
  public final int length()
  {
    return current.size();
  }
  
  public final long next()
  {
    return element;
  }
  
  public final long read()
  {
    return val;
  }
}
