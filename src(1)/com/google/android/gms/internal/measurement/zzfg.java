package com.google.android.gms.internal.measurement;

public final class zzfg
  extends zzke
  implements zzlm
{
  private static final zzfg spinner;
  private int TYPE_DIALOG;
  private String severity = "";
  private String urgency = "";
  
  static
  {
    zzfg localZzfg = new zzfg();
    spinner = localZzfg;
    zzke.zzbJ(zzfg.class, localZzfg);
  }
  
  private zzfg() {}
  
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
          return new zzff(null);
        }
        return new zzfg();
      }
      return zzke.zzbI(spinner, "\001\002\000\001\001\002\002\000\000\000\001?\000\002?\001", new Object[] { "zze", "zzf", "zzg" });
    }
    return Byte.valueOf((byte)1);
  }
}
