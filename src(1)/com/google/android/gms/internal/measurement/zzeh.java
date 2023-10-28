package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzeh
  extends zzke
  implements zzlm
{
  private static final zzeh spinner;
  private int TYPE_DIALOG;
  private zzkl added = zzke.zzbD();
  private boolean showIcons;
  private int type;
  private boolean untitled;
  private zzkl values = zzke.zzbD();
  
  static
  {
    zzeh localZzeh = new zzeh();
    spinner = localZzeh;
    zzke.zzbJ(zzeh.class, localZzeh);
  }
  
  private zzeh() {}
  
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
            return spinner;
          }
          return new zzeg(null);
        }
        return new zzeh();
      }
      return zzke.zzbI(spinner, "\001\005\000\001\001\005\005\000\002\000\001?\000\002\033\003\033\004?\001\005?\002", new Object[] { "zze", "zzf", "zzg", zzes.class, "zzh", zzej.class, "zzi", "zzj" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean deleteDirectory()
  {
    return (type & 0x1) != 0;
  }
  
  public final int download()
  {
    return added.size();
  }
  
  public final int get()
  {
    return values.size();
  }
  
  public final List getAll()
  {
    return values;
  }
  
  public final int getNumAlbum()
  {
    return TYPE_DIALOG;
  }
  
  public final List isAdded()
  {
    return added;
  }
  
  public final zzes makeRequest(int paramInt)
  {
    return (zzes)values.get(paramInt);
  }
  
  public final zzej openConnection(int paramInt)
  {
    return (zzej)added.get(paramInt);
  }
}
