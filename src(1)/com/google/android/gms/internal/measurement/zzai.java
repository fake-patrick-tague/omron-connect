package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class zzai
  implements zzap, zzal
{
  protected final Map data = new HashMap();
  protected final String value;
  
  public zzai(String paramString)
  {
    value = paramString;
  }
  
  public final void add(String paramString, zzap paramZzap)
  {
    if (paramZzap == null)
    {
      data.remove(paramString);
      return;
    }
    data.put(paramString, paramZzap);
  }
  
  public final String booleanValue()
  {
    return value;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzai)) {
      return false;
    }
    paramObject = (zzai)paramObject;
    String str = value;
    if (str != null) {
      return str.equals(value);
    }
    return false;
  }
  
  public abstract zzap get(Headers paramHeaders, List paramList);
  
  public final zzap get(String paramString)
  {
    if (data.containsKey(paramString)) {
      return (zzap)data.get(paramString);
    }
    return zzap.this$0;
  }
  
  public final Double get()
  {
    return Double.valueOf(NaN.0D);
  }
  
  public final String getValue()
  {
    return value;
  }
  
  public final boolean has(String paramString)
  {
    return data.containsKey(paramString);
  }
  
  public final int hashCode()
  {
    String str = value;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public zzap multiply()
  {
    return this;
  }
  
  public final Iterator toXml()
  {
    return zzaj.toString(data);
  }
  
  public final Boolean value()
  {
    return Boolean.TRUE;
  }
  
  public final zzap zzbN(String paramString, Headers paramHeaders, List paramList)
  {
    if ("toString".equals(paramString)) {
      return new zzat(value);
    }
    return zzaj.parse(this, new zzat(paramString), paramHeaders, paramList);
  }
}
