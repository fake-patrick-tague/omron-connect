package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzam
  implements zzap, zzal
{
  final Map data = new HashMap();
  
  public zzam() {}
  
  public final void add(String paramString, zzap paramZzap)
  {
    if (paramZzap == null)
    {
      data.remove(paramString);
      return;
    }
    data.put(paramString, paramZzap);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzam)) {
      return false;
    }
    paramObject = (zzam)paramObject;
    return data.equals(data);
  }
  
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
  
  public final List getHeaderValues()
  {
    return new ArrayList(data.keySet());
  }
  
  public final String getValue()
  {
    return "[object Object]";
  }
  
  public final boolean has(String paramString)
  {
    return data.containsKey(paramString);
  }
  
  public final int hashCode()
  {
    return data.hashCode();
  }
  
  public final zzap multiply()
  {
    zzam localZzam = new zzam();
    Iterator localIterator = data.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof zzal)) {
        data.put((String)localEntry.getKey(), (zzap)localEntry.getValue());
      } else {
        data.put((String)localEntry.getKey(), ((zzap)localEntry.getValue()).multiply());
      }
    }
    return localZzam;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    if (!data.isEmpty())
    {
      Iterator localIterator = data.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(String.format("%s: %s,", new Object[] { str, data.get(str) }));
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf(","));
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final Iterator toXml()
  {
    return zzaj.toString(data);
  }
  
  public final Boolean value()
  {
    return Boolean.TRUE;
  }
  
  public zzap zzbN(String paramString, Headers paramHeaders, List paramList)
  {
    if ("toString".equals(paramString)) {
      return new zzat(toString());
    }
    return zzaj.parse(this, new zzat(paramString), paramHeaders, paramList);
  }
}
