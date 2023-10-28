package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzej
  extends zzke
  implements zzlm
{
  private static final zzej singleton;
  private boolean CALDAV;
  private boolean b7;
  private zzkl data = zzke.zzbD();
  private int hoursAgo;
  private zzeq parameter;
  private boolean serieid;
  private boolean showIcons;
  private String type = "";
  private int value;
  
  static
  {
    zzej localZzej = new zzej();
    singleton = localZzej;
    zzke.zzbJ(zzej.class, localZzej);
  }
  
  private zzej() {}
  
  public static zzei getViewId()
  {
    return (zzei)singleton.zzbx();
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
          return new zzei(null);
        }
        return new zzej();
      }
      return zzke.zzbI(singleton, "\001\b\000\001\001\b\b\000\001\000\001?\000\002?\001\003\033\004?\002\005?\003\006?\004\007?\005\b?\006", new Object[] { "zze", "zzf", "zzg", "zzh", zzel.class, "zzi", "zzj", "zzk", "zzl", "zzm" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean add()
  {
    return (value & 0x8) != 0;
  }
  
  public final boolean addElement()
  {
    return (value & 0x1) != 0;
  }
  
  public final boolean doSearch()
  {
    return b7;
  }
  
  public final int format()
  {
    return hoursAgo;
  }
  
  public final List get()
  {
    return data;
  }
  
  public final String getEntry()
  {
    return type;
  }
  
  public final zzel getInputStream(int paramInt)
  {
    return (zzel)data.get(paramInt);
  }
  
  public final zzeq getParameter()
  {
    zzeq localZzeq2 = parameter;
    zzeq localZzeq1 = localZzeq2;
    if (localZzeq2 == null) {
      localZzeq1 = zzeq.method_7();
    }
    return localZzeq1;
  }
  
  public final boolean getSerieId()
  {
    return serieid;
  }
  
  public final boolean isMovable()
  {
    return (value & 0x40) != 0;
  }
  
  public final boolean parseInt()
  {
    return CALDAV;
  }
  
  public final int size()
  {
    return data.size();
  }
}
