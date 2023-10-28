package com.braze.models.inappmessage;

import android.graphics.Color;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.SlideFrom;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.JsonUtils;
import kotlin.x.c.a;
import kotlin.x.d.j;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.Entry;
import protect.package_9.c;

public final class InAppMessageSlideup
  extends InAppMessageWithImageBase
{
  public static final Companion Companion = new Companion(null);
  private int chevronColor = Color.parseColor("#9B9B9B");
  private SlideFrom slideFrom = SlideFrom.BOTTOM;
  
  public InAppMessageSlideup()
  {
    setMessageTextAlign(TextAlign.START);
  }
  
  public InAppMessageSlideup(JSONObject paramJSONObject, c paramC)
  {
    this(paramJSONObject, paramC, (SlideFrom)JsonUtils.optEnum(paramJSONObject, "slide_from", SlideFrom.class, SlideFrom.BOTTOM), paramJSONObject.optInt("close_btn_color"));
  }
  
  private InAppMessageSlideup(JSONObject paramJSONObject, c paramC, SlideFrom paramSlideFrom, int paramInt)
  {
    super(paramJSONObject, paramC);
    if (paramSlideFrom != null) {
      slideFrom = paramSlideFrom;
    }
    chevronColor = paramInt;
    setCropType((CropType)JsonUtils.optEnum(paramJSONObject, "crop_type", CropType.class, CropType.FIT_CENTER));
    setMessageTextAlign((TextAlign)JsonUtils.optEnum(paramJSONObject, "text_align_message", TextAlign.class, TextAlign.START));
  }
  
  public void enableDarkTheme()
  {
    super.enableDarkTheme();
    Entry localEntry = getInAppMessageDarkThemeWrapper();
    if (localEntry == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.BEGIN, null, a.CHANGE, 2, null);
      return;
    }
    Integer localInteger = localEntry.getAnchor();
    if (((localInteger == null) || (localInteger.intValue() != -1)) && (localEntry.getAnchor() != null)) {
      chevronColor = localEntry.getAnchor().intValue();
    }
  }
  
  public JSONObject forJsonPut()
  {
    JSONObject localJSONObject = getJsonObject();
    if (localJSONObject != null) {
      return localJSONObject;
    }
    localJSONObject = super.forJsonPut();
    SlideFrom localSlideFrom = slideFrom;
    try
    {
      localJSONObject.put("slide_from", localSlideFrom.toString());
      int i = chevronColor;
      localJSONObject.put("close_btn_color", i);
      localJSONObject.put("type", getMessageType().name());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localJSONException, b.SingleTap);
    }
    return localJSONObject;
  }
  
  public final int getChevronColor()
  {
    return chevronColor;
  }
  
  public MessageType getMessageType()
  {
    return MessageType.SLIDEUP;
  }
  
  public final SlideFrom getSlideFrom()
  {
    return slideFrom;
  }
  
  public static final class Companion
  {
    private Companion() {}
  }
  
  static final class a
    extends j
    implements a<String>
  {
    public static final a CHANGE = new a();
    
    a()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot apply dark theme with a null themes wrapper";
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    public static final b SingleTap = new b();
    
    b()
    {
      super();
    }
    
    public final String getText()
    {
      return "Error creating JSON.";
    }
  }
}
