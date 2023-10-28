package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;

final class zzik
  implements Serializable, zzih
{
  final Object x;
  
  zzik(Object paramObject)
  {
    x = paramObject;
  }
  
  public final Object dotProduct()
  {
    return x;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof zzik))
    {
      Object localObject = (zzik)paramObject;
      paramObject = x;
      localObject = x;
      return (paramObject == localObject) || (paramObject.equals(localObject));
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { x });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Suppliers.ofInstance(");
    localStringBuilder.append(x);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}
