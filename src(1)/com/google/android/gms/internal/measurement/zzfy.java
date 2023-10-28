package com.google.android.gms.internal.measurement;

public final class zzfy
  extends zzke
  implements zzlm
{
  private static final zzfy spinner;
  private int TYPE_DIALOG;
  private zzfm field_8;
  private String severity = "";
  private String urgency = "";
  
  static
  {
    zzfy localZzfy = new zzfy();
    spinner = localZzfy;
    zzke.zzbJ(zzfy.class, localZzfy);
  }
  
  private zzfy() {}
  
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
          return new zzfx(null);
        }
        return new zzfy();
      }
      return zzke.zzbI(spinner, "\001\003\000\001\001\003\003\000\000\000\001?\000\002?\001\003?\002", new Object[] { "zze", "zzf", "zzg", "zzh" });
    }
    return Byte.valueOf((byte)1);
  }
}
