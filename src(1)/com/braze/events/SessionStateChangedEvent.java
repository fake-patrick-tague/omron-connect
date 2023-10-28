package com.braze.events;

import kotlin.x.d.i;

public final class SessionStateChangedEvent
{
  private final ChangeType eventType;
  private final String sessionId;
  
  public SessionStateChangedEvent(String paramString, ChangeType paramChangeType)
  {
    sessionId = paramString;
    eventType = paramChangeType;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SessionStateChangedEvent)) {
      return false;
    }
    paramObject = (SessionStateChangedEvent)paramObject;
    if (!i.a(sessionId, sessionId)) {
      return false;
    }
    return eventType == eventType;
  }
  
  public int hashCode()
  {
    return sessionId.hashCode() * 31 + eventType.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SessionStateChangedEvent{sessionId='");
    localStringBuilder.append(sessionId);
    localStringBuilder.append("', eventType='");
    localStringBuilder.append(eventType);
    localStringBuilder.append("'}'");
    return localStringBuilder.toString();
  }
  
  public static enum ChangeType
  {
    static
    {
      SESSION_ENDED = new ChangeType("SESSION_ENDED", 1);
    }
  }
}
