package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgs
  extends zzke
  implements zzlm
{
  private static final zzgs spinner;
  private int TYPE_DIALOG;
  private zzkl bbox = zzke.zzbD();
  private zzgo contextNode;
  
  static
  {
    zzgs localZzgs = new zzgs();
    spinner = localZzgs;
    zzke.zzbJ(zzgs.class, localZzgs);
  }
  
  private zzgs() {}
  
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
          return new zzgr(null);
        }
        return new zzgs();
      }
      return zzke.zzbI(spinner, "\001\002\000\001\001\002\002\000\001\000\001\033\002?\000", new Object[] { "zze", "zzf", zzgx.class, "zzg" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final zzgo getContextRef()
  {
    zzgo localZzgo2 = contextNode;
    zzgo localZzgo1 = localZzgo2;
    if (localZzgo2 == null) {
      localZzgo1 = zzgo.access$getWebView();
    }
    return localZzgo1;
  }
  
  public final List intersect()
  {
    return bbox;
  }
}
