package com.google.android.gms.internal.measurement;

public final class zzfm
  extends zzke
  implements zzlm
{
  private static final zzfm spinner;
  private int TYPE_DIALOG;
  private String certainty = "";
  private String contactId = "";
  private String displayName = "";
  private String effective = "";
  private String expires = "";
  private String severity = "";
  private String urgency = "";
  
  static
  {
    zzfm localZzfm = new zzfm();
    spinner = localZzfm;
    zzke.zzbJ(zzfm.class, localZzfm);
  }
  
  private zzfm() {}
  
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
          return new zzfl(null);
        }
        return new zzfm();
      }
      return zzke.zzbI(spinner, "\001\007\000\001\001\007\007\000\000\000\001?\000\002?\001\003?\002\004?\003\005?\004\006?\005\007?\006", new Object[] { "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl" });
    }
    return Byte.valueOf((byte)1);
  }
}
