package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzaq
  implements zzap
{
  private final String data;
  private final ArrayList records;
  
  public zzaq(String paramString, List paramList)
  {
    data = paramString;
    paramString = new ArrayList();
    records = paramString;
    paramString.addAll(paramList);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzaq)) {
      return false;
    }
    paramObject = (zzaq)paramObject;
    String str = data;
    if (str != null)
    {
      if (!str.equals(data)) {
        return false;
      }
    }
    else if (data != null) {
      return false;
    }
    return records.equals(records);
  }
  
  public final Double get()
  {
    throw new IllegalStateException("Statement cannot be cast as Double");
  }
  
  public final String getKey()
  {
    return data;
  }
  
  public final String getValue()
  {
    throw new IllegalStateException("Statement cannot be cast as String");
  }
  
  public final int hashCode()
  {
    String str = data;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + records.hashCode();
  }
  
  public final zzap multiply()
  {
    return this;
  }
  
  public final ArrayList remove()
  {
    return records;
  }
  
  public final Iterator toXml()
  {
    return null;
  }
  
  public final Boolean value()
  {
    throw new IllegalStateException("Statement cannot be cast as Boolean");
  }
  
  public final zzap zzbN(String paramString, Headers paramHeaders, List paramList)
  {
    throw new IllegalStateException("Statement is not an evaluated entity");
  }
}
