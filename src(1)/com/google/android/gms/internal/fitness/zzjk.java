package com.google.android.gms.internal.fitness;

import java.util.Map.Entry;

final class zzjk
  implements Comparable<zzjk>, Map.Entry<K, V>
{
  private V value;
  private final K zzabp;
  
  zzjk(zzjb paramZzjb, Comparable paramComparable, Object paramObject)
  {
    zzabp = paramComparable;
    value = paramObject;
  }
  
  zzjk(zzjb paramZzjb, Map.Entry paramEntry)
  {
    this(paramZzjb, (Comparable)paramEntry.getKey(), paramEntry.getValue());
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    return (equals(zzabp, paramObject.getKey())) && (equals(value, paramObject.getValue()));
  }
  
  public final Object getValue()
  {
    return value;
  }
  
  public final int hashCode()
  {
    Object localObject = zzabp;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = value;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public final Object setValue(Object paramObject)
  {
    zzjb.setAnswer(zzabl);
    Object localObject = value;
    value = paramObject;
    return localObject;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(zzabp);
    String str2 = String.valueOf(value);
    StringBuilder localStringBuilder = new StringBuilder(str1.length() + 1 + str2.length());
    localStringBuilder.append(str1);
    localStringBuilder.append("=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}
