package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgh
  extends zzke
  implements zzlm
{
  private static final zzgh TAG;
  private zzkk buffer = zzke.zzbB();
  private zzkk data = zzke.zzbB();
  private zzkl items = zzke.zzbD();
  private zzkl score = zzke.zzbD();
  
  static
  {
    zzgh localZzgh = new zzgh();
    TAG = localZzgh;
    zzke.zzbJ(zzgh.class, localZzgh);
  }
  
  private zzgh() {}
  
  private final void getFileList()
  {
    zzkl localZzkl = items;
    if (!localZzkl.get()) {
      items = zzke.zzbE(localZzkl);
    }
  }
  
  public static zzgg getName()
  {
    return (zzgg)TAG.zzbx();
  }
  
  private final void rewrite()
  {
    zzkl localZzkl = score;
    if (!localZzkl.get()) {
      score = zzke.zzbE(localZzkl);
    }
  }
  
  public static zzgh writer()
  {
    return TAG;
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
            return TAG;
          }
          return new zzgg(null);
        }
        return new zzgh();
      }
      return zzke.zzbI(TAG, "\001\004\000\000\001\004\004\000\004\000\001\025\002\025\003\033\004\033", new Object[] { "zze", "zzf", "zzg", zzfq.class, "zzh", zzgj.class });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final int add()
  {
    return score.size();
  }
  
  public final zzgj format(int paramInt)
  {
    return (zzgj)score.get(paramInt);
  }
  
  public final List get()
  {
    return score;
  }
  
  public final zzfq getItemId(int paramInt)
  {
    return (zzfq)items.get(paramInt);
  }
  
  public final int getNumberOfColumns()
  {
    return data.size();
  }
  
  public final List getResources()
  {
    return items;
  }
  
  public final int next()
  {
    return buffer.size();
  }
  
  public final List read()
  {
    return data;
  }
  
  public final int register()
  {
    return items.size();
  }
  
  public final List remove()
  {
    return buffer;
  }
}
