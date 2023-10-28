package com.google.android.gms.internal.fitness;

final class zzhz
  implements zzih
{
  private zzih[] zzzs;
  
  zzhz(zzih... paramVarArgs)
  {
    zzzs = paramVarArgs;
  }
  
  public final zzii get(Class paramClass)
  {
    zzih[] arrayOfZzih = zzzs;
    int j = arrayOfZzih.length;
    int i = 0;
    while (i < j)
    {
      zzih localZzih = arrayOfZzih[i];
      if (localZzih.isAssignableFrom(paramClass)) {
        return localZzih.get(paramClass);
      }
      i += 1;
    }
    paramClass = paramClass.getName();
    if (paramClass.length() != 0) {
      paramClass = "No factory is available for message type: ".concat(paramClass);
    } else {
      paramClass = new String("No factory is available for message type: ");
    }
    throw new UnsupportedOperationException(paramClass);
  }
  
  public final boolean isAssignableFrom(Class paramClass)
  {
    zzih[] arrayOfZzih = zzzs;
    int j = arrayOfZzih.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfZzih[i].isAssignableFrom(paramClass)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}
