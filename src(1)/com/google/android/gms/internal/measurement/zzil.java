package com.google.android.gms.internal.measurement;

import java.io.Serializable;

public final class zzil
{
  public static zzih getLocale(Object paramObject)
  {
    return new zzik(paramObject);
  }
  
  public static zzih toLowerCase(zzih paramZzih)
  {
    if (!(paramZzih instanceof zzij))
    {
      if ((paramZzih instanceof zzii)) {
        return paramZzih;
      }
      if ((paramZzih instanceof Serializable)) {
        return new zzii(paramZzih);
      }
      return new zzij(paramZzih);
    }
    return paramZzih;
  }
}
