package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzan
  implements zzap
{
  public zzan() {}
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    return paramObject instanceof zzan;
  }
  
  public final Double get()
  {
    return Double.valueOf(0.0D);
  }
  
  public final String getValue()
  {
    return "null";
  }
  
  public final int hashCode()
  {
    return 1;
  }
  
  public final zzap multiply()
  {
    return zzap.items;
  }
  
  public final Iterator toXml()
  {
    return null;
  }
  
  public final Boolean value()
  {
    return Boolean.FALSE;
  }
  
  public final zzap zzbN(String paramString, Headers paramHeaders, List paramList)
  {
    throw new IllegalStateException(String.format("null has no function %s", new Object[] { paramString }));
  }
}
