package com.braze.events;

import com.braze.models.IPutIntoJson;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;
import kotlin.x.d.i;
import org.json.JSONObject;
import protect.package_9.Label;
import protect.package_9.MethodVisitor;

public final class InAppMessageEvent
{
  private final IInAppMessage inAppMessage;
  private final Label triggerAction;
  private final MethodVisitor triggerEvent;
  private final String userId;
  
  public InAppMessageEvent(MethodVisitor paramMethodVisitor, Label paramLabel, IInAppMessage paramIInAppMessage, String paramString)
  {
    triggerEvent = paramMethodVisitor;
    triggerAction = paramLabel;
    inAppMessage = paramIInAppMessage;
    userId = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof InAppMessageEvent)) {
      return false;
    }
    paramObject = (InAppMessageEvent)paramObject;
    if (!i.a(triggerEvent, triggerEvent)) {
      return false;
    }
    if (!i.a(triggerAction, triggerAction)) {
      return false;
    }
    if (!i.a(inAppMessage, inAppMessage)) {
      return false;
    }
    return i.a(userId, userId);
  }
  
  public final IInAppMessage getInAppMessage()
  {
    return inAppMessage;
  }
  
  public final Label getTriggerAction()
  {
    return triggerAction;
  }
  
  public final MethodVisitor getTriggerEvent()
  {
    return triggerEvent;
  }
  
  public int hashCode()
  {
    int j = triggerEvent.hashCode();
    int k = triggerAction.hashCode();
    int m = inAppMessage.hashCode();
    String str = userId;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public String toString()
  {
    return JsonUtils.getPrettyPrintedString((JSONObject)inAppMessage.forJsonPut());
  }
}
