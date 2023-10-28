package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzlf
  extends LinkedHashMap
{
  private static final zzlf exact;
  private boolean y = true;
  
  static
  {
    zzlf localZzlf = new zzlf();
    exact = localZzlf;
    y = false;
  }
  
  private zzlf() {}
  
  private zzlf(Map paramMap)
  {
    super(paramMap);
  }
  
  private static int hash(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return zzkm.b((byte[])paramObject);
    }
    if (!(paramObject instanceof zzkg)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  public static zzlf isExact()
  {
    return exact;
  }
  
  private final void next()
  {
    if (y) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final boolean a()
  {
    return y;
  }
  
  public final void clear()
  {
    next();
    super.clear();
  }
  
  public final Set entrySet()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    return super.entrySet();
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (this != paramObject)
      {
        if (size() == paramObject.size())
        {
          Iterator localIterator = entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (Map.Entry)localIterator.next();
            if (!paramObject.containsKey(((Map.Entry)localObject2).getKey())) {
              break label160;
            }
            Object localObject1 = ((Map.Entry)localObject2).getValue();
            localObject2 = paramObject.get(((Map.Entry)localObject2).getKey());
            boolean bool;
            if (((localObject1 instanceof byte[])) && ((localObject2 instanceof byte[]))) {
              bool = Arrays.equals((byte[])localObject1, (byte[])localObject2);
            } else {
              bool = localObject1.equals(localObject2);
            }
            if (!bool) {
              break label160;
            }
          }
        }
      }
      else {
        return true;
      }
    }
    label160:
    return false;
  }
  
  public final zzlf getValue()
  {
    if (isEmpty()) {
      return new zzlf();
    }
    return new zzlf(this);
  }
  
  public final void grow()
  {
    y = false;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int j = hash(localEntry.getKey());
      i += (hash(localEntry.getValue()) ^ j);
    }
    return i;
  }
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    next();
    zzkm.get(paramObject1);
    zzkm.get(paramObject2);
    return super.put(paramObject1, paramObject2);
  }
  
  public final void putAll(zzlf paramZzlf)
  {
    next();
    if (!paramZzlf.isEmpty()) {
      putAll(paramZzlf);
    }
  }
  
  public final void putAll(Map paramMap)
  {
    next();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzkm.get(localObject);
      zzkm.get(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final Object remove(Object paramObject)
  {
    next();
    return super.remove(paramObject);
  }
}
