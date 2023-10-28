package com.google.android.gms.internal.measurement;

public final class zzfi
  extends zzke
  implements zzlm
{
  private static final zzfi spinner;
  private int TYPE_DIALOG;
  private String mImagePath = "";
  private String unit = "";
  
  static
  {
    zzfi localZzfi = new zzfi();
    spinner = localZzfi;
    zzke.zzbJ(zzfi.class, localZzfi);
  }
  
  private zzfi() {}
  
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
          return new zzfh(null);
        }
        return new zzfi();
      }
      return zzke.zzbI(spinner, "\001\002\000\001\001\002\002\000\000\000\001?\000\002?\001", new Object[] { "zze", "zzf", "zzg" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final String getImagePath()
  {
    return mImagePath;
  }
  
  public final String getTemperatureUnit()
  {
    return unit;
  }
}
