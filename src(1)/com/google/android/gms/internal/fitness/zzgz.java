package com.google.android.gms.internal.fitness;

final class zzgz
  implements zzih
{
  private static final zzgz zzxw = new zzgz();
  
  private zzgz() {}
  
  public static zzgz zzbv()
  {
    return zzxw;
  }
  
  public final zzii get(Class paramClass)
  {
    if (!zzgy.class.isAssignableFrom(paramClass))
    {
      paramClass = paramClass.getName();
      if (paramClass.length() != 0) {
        paramClass = "Unsupported message type: ".concat(paramClass);
      } else {
        paramClass = new String("Unsupported message type: ");
      }
      throw new IllegalArgumentException(paramClass);
    }
    try
    {
      Object localObject = zzgy.setField(paramClass.asSubclass(zzgy.class));
      int i = zzgy.zze.zzyf;
      localObject = ((zzgy)localObject).getAsString(i, null, null);
      return (zzii)localObject;
    }
    catch (Exception localException)
    {
      paramClass = paramClass.getName();
      if (paramClass.length() != 0) {
        paramClass = "Unable to get message info for ".concat(paramClass);
      } else {
        paramClass = new String("Unable to get message info for ");
      }
      throw new RuntimeException(paramClass, localException);
    }
  }
  
  public final boolean isAssignableFrom(Class paramClass)
  {
    return zzgy.class.isAssignableFrom(paramClass);
  }
}
