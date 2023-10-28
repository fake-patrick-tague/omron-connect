package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzau
  implements zzap
{
  public zzau() {}
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    return paramObject instanceof zzau;
  }
  
  public final Double get()
  {
    return Double.valueOf(NaN.0D);
  }
  
  public final String getValue()
  {
    return "undefined";
  }
  
  public final zzap multiply()
  {
    return zzap.this$0;
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
    throw new IllegalStateException(String.format("Undefined has no function %s", new Object[] { paramString }));
  }
}
