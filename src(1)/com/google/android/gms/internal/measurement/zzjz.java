package com.google.android.gms.internal.measurement;

final class zzjz
  implements zzlj
{
  private static final zzjz time = new zzjz();
  
  private zzjz() {}
  
  public static zzjz getMilliseconds()
  {
    return time;
  }
  
  public final boolean contains(Class paramClass)
  {
    return zzke.class.isAssignableFrom(paramClass);
  }
  
  public final zzli get(Class paramClass)
  {
    if (zzke.class.isAssignableFrom(paramClass)) {
      try
      {
        Object localObject = zzke.zzbz(paramClass.asSubclass(zzke.class)).Decode(3, null, null);
        return (zzli)localObject;
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Unable to get message info for ".concat(paramClass.getName()), localException);
      }
    }
    throw new IllegalArgumentException("Unsupported message type: ".concat(paramClass.getName()));
  }
}
