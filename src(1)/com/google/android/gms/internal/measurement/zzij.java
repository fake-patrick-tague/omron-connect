package com.google.android.gms.internal.measurement;

import java.util.Objects;

final class zzij
  implements zzih
{
  volatile zzih w;
  Object y;
  volatile boolean z;
  
  zzij(zzih paramZzih)
  {
    Objects.requireNonNull(paramZzih);
    w = paramZzih;
  }
  
  public final Object dotProduct()
  {
    if (!z) {
      try
      {
        if (!z)
        {
          Object localObject = w;
          localObject.getClass();
          localObject = ((zzih)localObject).dotProduct();
          y = localObject;
          z = true;
          w = null;
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return y;
  }
  
  public final String toString()
  {
    zzih localZzih = w;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Suppliers.memoize(");
    Object localObject = localZzih;
    if (localZzih == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<supplier that returned ");
      ((StringBuilder)localObject).append(y);
      ((StringBuilder)localObject).append(">");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}
