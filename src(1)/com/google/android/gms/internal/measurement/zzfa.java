package com.google.android.gms.internal.measurement;

public final class zzfa
  extends zzke
  implements zzlm
{
  private static final zzfa spinner;
  private int TYPE_DIALOG;
  private String mFilename = "";
  private zzkl mTime = zzke.zzbD();
  private boolean showIcons;
  
  static
  {
    zzfa localZzfa = new zzfa();
    spinner = localZzfa;
    zzke.zzbJ(zzfa.class, localZzfa);
  }
  
  private zzfa() {}
  
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
          return new zzez(null);
        }
        return new zzfa();
      }
      return zzke.zzbI(spinner, "\001\003\000\001\001\003\003\000\001\000\001?\000\002\033\003?\001", new Object[] { "zze", "zzf", "zzg", zzfg.class, "zzh" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final String getFilename()
  {
    return mFilename;
  }
}
