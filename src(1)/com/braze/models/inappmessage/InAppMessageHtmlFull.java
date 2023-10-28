package com.braze.models.inappmessage;

import com.braze.enums.inappmessage.MessageType;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.c;

public final class InAppMessageHtmlFull
  extends InAppMessageZippedAssetHtmlBase
{
  public InAppMessageHtmlFull() {}
  
  public InAppMessageHtmlFull(JSONObject paramJSONObject, c paramC)
  {
    super(paramJSONObject, paramC);
  }
  
  public JSONObject forJsonPut()
  {
    JSONObject localJSONObject = getJsonObject();
    if (localJSONObject != null) {
      return localJSONObject;
    }
    localJSONObject = super.forJsonPut();
    try
    {
      localJSONObject.put("type", getMessageType().name());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public MessageType getMessageType()
  {
    return MessageType.HTML_FULL;
  }
}
