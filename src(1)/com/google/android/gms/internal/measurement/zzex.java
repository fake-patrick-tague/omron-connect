package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzex
  extends zzke
  implements zzlm
{
  private static final zzex time;
  private boolean _count;
  private zzkl children = zzke.zzbD();
  private int datatype;
  private int genre;
  private String name = "";
  
  static
  {
    zzex localZzex = new zzex();
    time = localZzex;
    zzke.zzbJ(zzex.class, localZzex);
  }
  
  private zzex() {}
  
  public static zzex time()
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
          return new zzet(null);
        }
        return new zzex();
      }
      paramObject1 = zzev.services;
      return zzke.zzbI(time, "\001\004\000\001\001\004\004\000\001\000\001?\000\002?\001\003?\002\004\032", new Object[] { "zze", "zzf", paramObject1, "zzg", "zzh", "zzi" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean count()
  {
    return _count;
  }
  
  public final int getCardinality()
  {
    return children.size();
  }
  
  public final String getName()
  {
    return name;
  }
  
  public final List list()
  {
    return children;
  }
  
  public final int next()
  {
    int i = zzew.convert(genre);
    if (i == 0) {
      return 1;
    }
    return i;
  }
  
  public final boolean read()
  {
    return (datatype & 0x1) != 0;
  }
  
  public final boolean validate()
  {
    return (datatype & 0x2) != 0;
  }
  
  public final boolean write()
  {
    return (datatype & 0x4) != 0;
  }
}
