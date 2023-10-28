package com.google.android.gms.internal.measurement;

public final class zzfo
  extends zzke
  implements zzlm
{
  private static final zzfo title;
  private zzgh buf;
  private int handler;
  private boolean history;
  private int text;
  private zzgh writer;
  
  static
  {
    zzfo localZzfo = new zzfo();
    title = localZzfo;
    zzke.zzbJ(zzfo.class, localZzfo);
  }
  
  private zzfo() {}
  
  public static zzfn depth()
  {
    return (zzfn)title.zzbx();
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
            return title;
          }
          return new zzfn(null);
        }
        return new zzfo();
      }
      return zzke.zzbI(title, "\001\004\000\001\001\004\004\000\000\000\001?\000\002?\001\003?\002\004?\003", new Object[] { "zze", "zzf", "zzg", "zzh", "zzi" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean equals()
  {
    return history;
  }
  
  public final zzgh get()
  {
    zzgh localZzgh2 = buf;
    zzgh localZzgh1 = localZzgh2;
    if (localZzgh2 == null) {
      localZzgh1 = zzgh.writer();
    }
    return localZzgh1;
  }
  
  public final int getValue()
  {
    return text;
  }
  
  public final boolean match()
  {
    return (handler & 0x4) != 0;
  }
  
  public final boolean next()
  {
    return (handler & 0x8) != 0;
  }
  
  public final boolean remove()
  {
    return (handler & 0x1) != 0;
  }
  
  public final zzgh writer()
  {
    zzgh localZzgh2 = writer;
    zzgh localZzgh1 = localZzgh2;
    if (localZzgh2 == null) {
      localZzgh1 = zzgh.writer();
    }
    return localZzgh1;
  }
}
