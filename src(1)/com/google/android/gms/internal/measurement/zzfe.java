package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfe
  extends zzke
  implements zzlm
{
  private static final zzfe singleton;
  private int TYPE_DIALOG;
  private zzkl due = zzke.zzbD();
  private int internal;
  private zzkl items = zzke.zzbD();
  private zzkl list = zzke.zzbD();
  private boolean mEmpty;
  private zzkl mItems = zzke.zzbD();
  private long mPos;
  private String mString = "";
  private String name = "";
  private zzkl pos = zzke.zzbD();
  private String title = "";
  
  static
  {
    zzfe localZzfe = new zzfe();
    singleton = localZzfe;
    zzke.zzbJ(zzfe.class, localZzfe);
  }
  
  private zzfe() {}
  
  public static zzfd negate()
  {
    return (zzfd)singleton.zzbx();
  }
  
  public static zzfe negated()
  {
    return singleton;
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
          return new zzfd(null);
        }
        return new zzfe();
      }
      return zzke.zzbI(singleton, "\001\013\000\001\001\013\013\000\005\000\001?\000\002?\001\003?\002\004\033\005\033\006\033\007?\003\b?\004\t\033\n\033\013?\005", new Object[] { "zze", "zzf", "zzg", "zzh", "zzi", zzfi.class, "zzj", zzfc.class, "zzk", zzeh.class, "zzl", "zzm", "zzn", zzgs.class, "zzo", zzfa.class, "zzp" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean add()
  {
    return (internal & 0x2) != 0;
  }
  
  public final zzfc createEntry(int paramInt)
  {
    return (zzfc)list.get(paramInt);
  }
  
  public final boolean equals()
  {
    return (internal & 0x1) != 0;
  }
  
  public final List get()
  {
    return pos;
  }
  
  public final List getAllItems()
  {
    return mItems;
  }
  
  public final String getCaption()
  {
    return title;
  }
  
  public final List getContentValues()
  {
    return due;
  }
  
  public final List getRoster()
  {
    return items;
  }
  
  public final String getString()
  {
    return mString;
  }
  
  public final long getZ()
  {
    return mPos;
  }
  
  public final boolean isEmpty()
  {
    return mEmpty;
  }
  
  public final int remove()
  {
    return list.size();
  }
  
  public final int write()
  {
    return items.size();
  }
}
