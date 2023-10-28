package com.braze.models.inappmessage;

import com.braze.enums.inappmessage.MessageType;
import com.braze.support.JsonUtils;
import java.util.List;
import java.util.Map;
import kotlin.collections.a0;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.c;

public class InAppMessageHtml
  extends InAppMessageHtmlBase
{
  public static final a Companion = new a(null);
  private List<String> assetUrls = kotlin.collections.i.d();
  private JSONObject messageFields;
  private Map<String, String> remotePathToLocalAssetMap = a0.d();
  
  public InAppMessageHtml()
  {
    messageFields = new JSONObject();
    assetUrls = kotlin.collections.i.d();
  }
  
  public InAppMessageHtml(JSONObject paramJSONObject, c paramC)
  {
    this(paramJSONObject, paramC, paramJSONObject.optJSONObject("message_fields"), JsonUtils.convertStringJsonArrayToList(paramJSONObject.optJSONArray("asset_urls")));
  }
  
  private InAppMessageHtml(JSONObject paramJSONObject1, c paramC, JSONObject paramJSONObject2, List paramList)
  {
    super(paramJSONObject1, paramC);
    messageFields = paramJSONObject2;
    assetUrls = paramList;
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
  
  public Map getLocalPrefetchedAssetPaths()
  {
    return remotePathToLocalAssetMap;
  }
  
  public MessageType getMessageType()
  {
    return MessageType.HTML;
  }
  
  public List getRemoteAssetPathsForPrefetch()
  {
    return assetUrls;
  }
  
  public void setLocalPrefetchedAssetPaths(Map paramMap)
  {
    kotlin.x.d.i.e(paramMap, "remotePathToLocalAssetMap");
    remotePathToLocalAssetMap = paramMap;
  }
  
  public static final class a
  {
    private a() {}
  }
}
