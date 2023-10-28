package com.google.android.gms.internal.fitness;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzie<K, V>
  extends LinkedHashMap<K, V>
{
  private static final zzie zzzv;
  private boolean zztv = true;
  
  static
  {
    zzie localZzie = new zzie();
    zzzv = localZzie;
    zztv = false;
  }
  
  private zzie() {}
  
  private zzie(Map paramMap)
  {
    super(paramMap);
  }
  
  private static int hash(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return zzhc.hashCode((byte[])paramObject);
    }
    if (!(paramObject instanceof zzhb)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  private final void zzco()
  {
    if (zztv) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    zzco();
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
        if (size() != paramObject.size()) {}
        for (;;)
        {
          i = 0;
          break label165;
          Iterator localIterator = entrySet().iterator();
          boolean bool;
          do
          {
            if (!localIterator.hasNext()) {
              break label163;
            }
            Object localObject2 = (Map.Entry)localIterator.next();
            if (!paramObject.containsKey(((Map.Entry)localObject2).getKey())) {
              break;
            }
            Object localObject1 = ((Map.Entry)localObject2).getValue();
            localObject2 = paramObject.get(((Map.Entry)localObject2).getKey());
            if (((localObject1 instanceof byte[])) && ((localObject2 instanceof byte[]))) {
              bool = Arrays.equals((byte[])localObject1, (byte[])localObject2);
            } else {
              bool = localObject1.equals(localObject2);
            }
          } while (bool);
        }
      }
      label163:
      int i = 1;
      label165:
      if (i != 0) {
        return true;
      }
    }
    return false;
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
  
  public final boolean isMutable()
  {
    return zztv;
  }
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    zzco();
    zzhc.checkNotNull(paramObject1);
    zzhc.checkNotNull(paramObject2);
    return super.put(paramObject1, paramObject2);
  }
  
  public final void putAll(Map paramMap)
  {
    zzco();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzhc.checkNotNull(localObject);
      zzhc.checkNotNull(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final Object remove(Object paramObject)
  {
    zzco();
    return super.remove(paramObject);
  }
  
  public final void setProperties(zzie paramZzie)
  {
    zzco();
    if (!paramZzie.isEmpty()) {
      putAll(paramZzie);
    }
  }
  
  public final void zzar()
  {
    zztv = false;
  }
  
  public final zzie zzcn()
  {
    if (isEmpty()) {
      return new zzie();
    }
    return new zzie(this);
  }
}
