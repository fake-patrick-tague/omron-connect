package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Objects;

final class zzii
  implements Serializable, zzih
{
  final zzih w;
  transient Object y;
  volatile transient boolean z;
  
  zzii(zzih paramZzih)
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
          Object localObject = w.dotProduct();
          y = localObject;
          z = true;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Suppliers.memoize(");
    Object localObject;
    if (z)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<supplier that returned ");
      ((StringBuilder)localObject).append(y);
      ((StringBuilder)localObject).append(">");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = w;
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}
