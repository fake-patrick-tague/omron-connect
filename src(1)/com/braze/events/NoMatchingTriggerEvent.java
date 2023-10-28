package com.braze.events;

import kotlin.x.d.i;

public final class NoMatchingTriggerEvent
{
  private final String sourceEventType;
  
  public NoMatchingTriggerEvent(String paramString)
  {
    sourceEventType = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof NoMatchingTriggerEvent)) {
      return false;
    }
    paramObject = (NoMatchingTriggerEvent)paramObject;
    return i.a(sourceEventType, sourceEventType);
  }
  
  public int hashCode()
  {
    return sourceEventType.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NoMatchingTriggerEvent(sourceEventType=");
    localStringBuilder.append(sourceEventType);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}
