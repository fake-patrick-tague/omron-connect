package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgq
  extends zzke
  implements zzlm
{
  private static final zzgq spinner;
  private int TYPE_DIALOG;
  private zzkl objects = zzke.zzbD();
  private String offset = "";
  
  static
  {
    zzgq localZzgq = new zzgq();
    spinner = localZzgq;
    zzke.zzbJ(zzgq.class, localZzgq);
  }
  
  private zzgq() {}
  
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
          return new zzgp(null);
        }
        return new zzgq();
      }
      return zzke.zzbI(spinner, "\001\002\000\001\001\002\002\000\001\000\001?\000\002\033", new Object[] { "zze", "zzf", "zzg", zzgx.class });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final List get()
  {
    return objects;
  }
  
  public final String parseDate()
  {
    return offset;
  }
}
