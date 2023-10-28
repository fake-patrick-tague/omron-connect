package com.braze.models.inappmessage;

import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.MessageType;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.x.d.i;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.Level;
import protect.package_9.c;

public class InAppMessageFull
  extends InAppMessageImmersiveBase
{
  public InAppMessageFull()
  {
    setCropType(CropType.CENTER_CROP);
  }
  
  public InAppMessageFull(JSONObject paramJSONObject, c paramC)
  {
    super(paramJSONObject, paramC);
    paramC = CropType.CENTER_CROP;
    Object localObject = Level.this$0;
    try
    {
      paramJSONObject = paramJSONObject.getString("crop_type");
      i.d(paramJSONObject, "jsonObject.getString(key)");
      localObject = Locale.US;
      i.d(localObject, "US");
      localObject = paramJSONObject.toUpperCase((Locale)localObject);
      i.d(localObject, "this as java.lang.String).toUpperCase(locale)");
      CropType[] arrayOfCropType = CropType.values();
      int i = 0;
      int j = arrayOfCropType.length;
      while (i < j)
      {
        paramJSONObject = arrayOfCropType[i];
        i += 1;
        boolean bool = i.a(paramJSONObject.name(), localObject);
        if (bool) {
          break label125;
        }
      }
      paramJSONObject = new NoSuchElementException("Array contains no element matching the predicate.");
      throw paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        label125:
        paramJSONObject = paramC;
      }
    }
    setCropType(paramJSONObject);
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
    return MessageType.FULL;
  }
}
