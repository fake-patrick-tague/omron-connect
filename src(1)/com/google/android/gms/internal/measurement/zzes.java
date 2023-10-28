package com.google.android.gms.internal.measurement;

public final class zzes
  extends zzke
  implements zzlm
{
  private static final zzes singleton;
  private boolean formatted;
  private String mString = "";
  private zzel ms;
  private boolean newData;
  private int prices;
  private boolean set;
  private int title;
  
  static
  {
    zzes localZzes = new zzes();
    singleton = localZzes;
    zzke.zzbJ(zzes.class, localZzes);
  }
  
  private zzes() {}
  
  public static zzer getViewId()
  {
    return (zzer)singleton.zzbx();
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
          return new zzer(null);
        }
        return new zzes();
      }
      return zzke.zzbI(singleton, "\001\006\000\001\001\006\006\000\000\000\001?\000\002?\001\003?\002\004?\003\005?\004\006?\005", new Object[] { "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean convert()
  {
    return newData;
  }
  
  public final boolean format()
  {
    return formatted;
  }
  
  public final zzel get()
  {
    zzel localZzel2 = ms;
    zzel localZzel1 = localZzel2;
    if (localZzel2 == null) {
      localZzel1 = zzel.getTime();
    }
    return localZzel1;
  }
  
  public final boolean getContent()
  {
    return set;
  }
  
  public final int getData()
  {
    return prices;
  }
  
  public final String getString()
  {
    return mString;
  }
  
  public final boolean prepare()
  {
    return (title & 0x1) != 0;
  }
  
  public final boolean refresh()
  {
    return (title & 0x20) != 0;
  }
}
