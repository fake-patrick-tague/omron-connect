package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

public final class zzaa
{
  private final Map data;
  private String name;
  private final long value;
  
  public zzaa(String paramString, long paramLong, Map paramMap)
  {
    name = paramString;
    value = paramLong;
    paramString = new HashMap();
    data = paramString;
    if (paramMap != null) {
      paramString.putAll(paramMap);
    }
  }
  
  public final Object addToCache(String paramString)
  {
    if (data.containsKey(paramString)) {
      return data.get(paramString);
    }
    return null;
  }
  
  public final void addToCache(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      data.remove(paramString);
      return;
    }
    data.put(paramString, paramObject);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzaa)) {
      return false;
    }
    paramObject = (zzaa)paramObject;
    if (value != value) {
      return false;
    }
    if (!name.equals(name)) {
      return false;
    }
    return data.equals(data);
  }
  
  public final zzaa get()
  {
    return new zzaa(name, value, new HashMap(data));
  }
  
  public final Map getData()
  {
    return data;
  }
  
  public final String getName()
  {
    return name;
  }
  
  public final int hashCode()
  {
    int i = name.hashCode();
    long l = value;
    return (i * 31 + (int)(l ^ l >>> 32)) * 31 + data.hashCode();
  }
  
  public final long intValue()
  {
    return value;
  }
  
  public final void newCategory(String paramString)
  {
    name = paramString;
  }
  
  public final String toString()
  {
    String str1 = name;
    long l = value;
    String str2 = data.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{name='");
    localStringBuilder.append(str1);
    localStringBuilder.append("', timestamp=");
    localStringBuilder.append(l);
    localStringBuilder.append(", params=");
    localStringBuilder.append(str2);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
