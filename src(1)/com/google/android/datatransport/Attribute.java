package com.google.android.datatransport;

import java.util.Objects;

final class Attribute<T>
  extends c<T>
{
  private final T a;
  private final Priority b;
  private final Integer c;
  
  Attribute(Integer paramInteger, Object paramObject, Priority paramPriority)
  {
    c = paramInteger;
    Objects.requireNonNull(paramObject, "Null payload");
    a = paramObject;
    Objects.requireNonNull(paramPriority, "Null priority");
    b = paramPriority;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      Integer localInteger = c;
      if ((localInteger == null ? paramObject.getName() == null : localInteger.equals(paramObject.getName())) && (a.equals(paramObject.getValue())) && (b.equals(paramObject.getGroupId()))) {
        return true;
      }
    }
    return false;
  }
  
  public Priority getGroupId()
  {
    return b;
  }
  
  public Integer getName()
  {
    return c;
  }
  
  public Object getValue()
  {
    return a;
  }
  
  public int hashCode()
  {
    Integer localInteger = c;
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.hashCode();
    }
    return ((i ^ 0xF4243) * 1000003 ^ a.hashCode()) * 1000003 ^ b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{code=");
    localStringBuilder.append(c);
    localStringBuilder.append(", payload=");
    localStringBuilder.append(a);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
