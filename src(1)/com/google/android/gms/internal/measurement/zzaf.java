package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzaf
  implements zzap
{
  private final boolean value;
  
  public zzaf(Boolean paramBoolean)
  {
    if (paramBoolean == null) {}
    for (boolean bool = false;; bool = paramBoolean.booleanValue())
    {
      value = bool;
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzaf)) {
      return false;
    }
    paramObject = (zzaf)paramObject;
    return value == value;
  }
  
  public final Double get()
  {
    double d;
    if (true != value) {
      d = 0.0D;
    } else {
      d = 1.0D;
    }
    return Double.valueOf(d);
  }
  
  public final String getValue()
  {
    return Boolean.toString(value);
  }
  
  public final int hashCode()
  {
    return Boolean.valueOf(value).hashCode();
  }
  
  public final zzap multiply()
  {
    return new zzaf(Boolean.valueOf(value));
  }
  
  public final String toString()
  {
    return String.valueOf(value);
  }
  
  public final Iterator toXml()
  {
    return null;
  }
  
  public final Boolean value()
  {
    return Boolean.valueOf(value);
  }
  
  public final zzap zzbN(String paramString, Headers paramHeaders, List paramList)
  {
    if ("toString".equals(paramString)) {
      return new zzat(Boolean.toString(value));
    }
    throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[] { Boolean.toString(value), paramString }));
  }
}
