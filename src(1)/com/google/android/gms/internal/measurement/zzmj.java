package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzmj
  extends AbstractMap
{
  private List entryList;
  private volatile zzmh entrySet;
  private Map fields;
  private boolean isImmutable;
  private final int maxArraySize;
  private Map overflowEntries;
  
  private final int binarySearchInArray(Comparable paramComparable)
  {
    int k = entryList.size() - 1;
    int m = 0;
    int i = k;
    int j = m;
    if (k >= 0)
    {
      i = paramComparable.compareTo(((zzmd)entryList.get(k)).get());
      if (i > 0) {
        return -(k + 2);
      }
      if (i != 0)
      {
        i = k;
        j = m;
      }
      else
      {
        return k;
      }
    }
    while (j <= i)
    {
      k = (j + i) / 2;
      m = paramComparable.compareTo(((zzmd)entryList.get(k)).get());
      if (m < 0) {
        i = k - 1;
      } else if (m > 0) {
        j = k + 1;
      } else {
        return k;
      }
    }
    return -(j + 1);
  }
  
  private final void checkMutable()
  {
    if (!isImmutable) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private final SortedMap getOverflowEntriesMutable()
  {
    checkMutable();
    if ((overflowEntries.isEmpty()) && (!(overflowEntries instanceof TreeMap)))
    {
      TreeMap localTreeMap = new TreeMap();
      overflowEntries = localTreeMap;
      fields = ((TreeMap)localTreeMap).descendingMap();
    }
    return (SortedMap)overflowEntries;
  }
  
  private final Object put(int paramInt)
  {
    checkMutable();
    Object localObject = ((zzmd)entryList.remove(paramInt)).getValue();
    if (!overflowEntries.isEmpty())
    {
      Iterator localIterator = getOverflowEntriesMutable().entrySet().iterator();
      List localList = entryList;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localList.add(new zzmd(this, (Comparable)localEntry.getKey(), localEntry.getValue()));
      localIterator.remove();
    }
    return localObject;
  }
  
  public final void clear()
  {
    checkMutable();
    if (!entryList.isEmpty()) {
      entryList.clear();
    }
    if (!overflowEntries.isEmpty()) {
      overflowEntries.clear();
    }
  }
  
  public final boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    return (binarySearchInArray(paramObject) >= 0) || (overflowEntries.containsKey(paramObject));
  }
  
  public final Set entrySet()
  {
    if (entrySet == null) {
      entrySet = new zzmh(this, null);
    }
    return entrySet;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzmj)) {
      return super.equals(paramObject);
    }
    paramObject = (zzmj)paramObject;
    int j = size();
    if (j != paramObject.size()) {
      return false;
    }
    int k = getValue();
    if (k == paramObject.getValue())
    {
      int i = 0;
      while (i < k)
      {
        if (!get(i).equals(paramObject.get(i))) {
          return false;
        }
        i += 1;
      }
      if (k != j) {
        return overflowEntries.equals(overflowEntries);
      }
      return true;
    }
    return entrySet().equals(paramObject.entrySet());
  }
  
  public final Object get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = binarySearchInArray(paramObject);
    if (i >= 0) {
      return ((zzmd)entryList.get(i)).getValue();
    }
    return overflowEntries.get(paramObject);
  }
  
  public final Map.Entry get(int paramInt)
  {
    return (Map.Entry)entryList.get(paramInt);
  }
  
  public final Iterable getOverflowEntries()
  {
    if (overflowEntries.isEmpty()) {
      return zzmc.entrySet();
    }
    return overflowEntries.entrySet();
  }
  
  public final int getValue()
  {
    return entryList.size();
  }
  
  public final int hashCode()
  {
    int k = getValue();
    int j = 0;
    int i = 0;
    while (j < k)
    {
      i += ((zzmd)entryList.get(j)).hashCode();
      j += 1;
    }
    j = i;
    if (overflowEntries.size() > 0) {
      j = i + overflowEntries.hashCode();
    }
    return j;
  }
  
  public final boolean isImmutable()
  {
    return isImmutable;
  }
  
  public void makeImmutable()
  {
    if (!isImmutable)
    {
      Map localMap;
      if (overflowEntries.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(overflowEntries);
      }
      overflowEntries = localMap;
      if (fields.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(fields);
      }
      fields = localMap;
      isImmutable = true;
    }
  }
  
  public final Object put(Comparable paramComparable, Object paramObject)
  {
    checkMutable();
    int i = binarySearchInArray(paramComparable);
    if (i >= 0) {
      return ((zzmd)entryList.get(i)).setValue(paramObject);
    }
    checkMutable();
    if ((entryList.isEmpty()) && (!(entryList instanceof ArrayList))) {
      entryList = new ArrayList(maxArraySize);
    }
    i = -(i + 1);
    if (i >= maxArraySize) {
      return getOverflowEntriesMutable().put(paramComparable, paramObject);
    }
    int j = entryList.size();
    int k = maxArraySize;
    if (j == k)
    {
      zzmd localZzmd = (zzmd)entryList.remove(k - 1);
      getOverflowEntriesMutable().put(localZzmd.get(), localZzmd.getValue());
    }
    entryList.add(i, new zzmd(this, paramComparable, paramObject));
    return null;
  }
  
  public final Object remove(Object paramObject)
  {
    checkMutable();
    paramObject = (Comparable)paramObject;
    int i = binarySearchInArray(paramObject);
    if (i >= 0) {
      return put(i);
    }
    if (overflowEntries.isEmpty()) {
      return null;
    }
    return overflowEntries.remove(paramObject);
  }
  
  public final int size()
  {
    return entryList.size() + overflowEntries.size();
  }
}
