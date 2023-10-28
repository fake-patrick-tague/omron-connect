package com.google.android.gms.internal.measurement;

final class zzjp
{
  private final Object object;
  private final int property;
  
  zzjp(Object paramObject, int paramInt)
  {
    object = paramObject;
    property = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzjp)) {
      return false;
    }
    paramObject = (zzjp)paramObject;
    return (object == object) && (property == property);
  }
  
  public final int hashCode()
  {
    return System.identityHashCode(object) * 65535 + property;
  }
}
