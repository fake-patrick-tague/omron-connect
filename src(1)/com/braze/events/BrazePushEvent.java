package com.braze.events;

import com.braze.enums.BrazePushEventType;
import com.braze.models.push.BrazeNotificationPayload;
import kotlin.x.d.i;

public final class BrazePushEvent
{
  private final BrazePushEventType eventType;
  private final BrazeNotificationPayload notificationPayload;
  
  public BrazePushEvent(BrazePushEventType paramBrazePushEventType, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    eventType = paramBrazePushEventType;
    notificationPayload = paramBrazeNotificationPayload;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof BrazePushEvent)) {
      return false;
    }
    paramObject = (BrazePushEvent)paramObject;
    if (eventType != eventType) {
      return false;
    }
    return i.a(notificationPayload, notificationPayload);
  }
  
  public int hashCode()
  {
    return eventType.hashCode() * 31 + notificationPayload.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BrazePushEvent(eventType=");
    localStringBuilder.append(eventType);
    localStringBuilder.append(", notificationPayload=");
    localStringBuilder.append(notificationPayload);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}
