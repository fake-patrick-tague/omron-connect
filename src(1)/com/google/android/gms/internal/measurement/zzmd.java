package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzmd
  implements Map.Entry, Comparable
{
  private final Comparable key;
  private Object val;
  
  zzmd(zzmj paramZzmj, Comparable paramComparable, Object paramObject)
  {
    key = paramComparable;
    val = paramObject;
  }
  
  private static final boolean isEqualKey(Object paramObject1, Object paramObject2)
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
    return (isEqualKey(key, paramObject.getKey())) && (isEqualKey(val, paramObject.getValue()));
  }
  
  public final Comparable get()
  {
    return key;
  }
  
  public final Object getValue()
  {
    return val;
  }
  
  public final int hashCode()
  {
    Object localObject = key;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = val;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public final Object setValue(Object paramObject)
  {
    zzmj.access$getCheckMutable(this$0);
    Object localObject = val;
    val = paramObject;
    return localObject;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(key);
    String str2 = String.valueOf(val);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}
