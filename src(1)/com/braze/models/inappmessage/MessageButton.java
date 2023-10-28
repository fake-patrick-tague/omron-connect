package com.braze.models.inappmessage;

import android.graphics.Color;
import android.net.Uri;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.j;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.Vector3D;

public class MessageButton
  implements IPutIntoJson<JSONObject>, IInAppMessageThemeable
{
  public static final a Companion = new a(null);
  private static final String TAG = BrazeLogger.getBrazeLogTag(MessageButton.class);
  private int Id = -1;
  private int backgroundColor;
  private int borderColor;
  private ClickAction clickAction = ClickAction.NONE;
  private Vector3D darkTheme;
  private JSONObject jsonObject;
  private boolean openUriInWebview;
  private String text;
  private int textColor;
  private Uri uri;
  
  public MessageButton()
  {
    int i = Color.parseColor("#1B78CF");
    backgroundColor = i;
    textColor = -1;
    borderColor = i;
  }
  
  public MessageButton(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    this(paramJSONObject1, paramJSONObject2, j, (ClickAction)localObject1, (String)localObject2, (String)localObject3, paramJSONObject1.optInt("bg_color"), paramJSONObject1.optInt("text_color"), paramJSONObject1.optBoolean("use_webview", false), paramJSONObject1.optInt("border_color"));
  }
  
  private MessageButton(JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt1, ClickAction paramClickAction, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    int i = Color.parseColor("#1B78CF");
    backgroundColor = i;
    textColor = -1;
    borderColor = i;
    jsonObject = paramJSONObject1;
    Id = paramInt1;
    clickAction = paramClickAction;
    if (paramClickAction == ClickAction.FUTURE)
    {
      if ((paramString1 != null) && (!g.o(paramString1))) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      if (paramInt1 == 0) {
        uri = Uri.parse(paramString1);
      }
    }
    text = paramString2;
    backgroundColor = paramInt2;
    textColor = paramInt3;
    openUriInWebview = paramBoolean;
    borderColor = paramInt4;
    if (paramJSONObject2 != null) {
      paramJSONObject1 = new Vector3D(paramJSONObject2);
    } else {
      paramJSONObject1 = null;
    }
    darkTheme = paramJSONObject1;
  }
  
  public void enableDarkTheme()
  {
    Vector3D localVector3D = darkTheme;
    if (localVector3D == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, null, null, b.G5, 6, null);
      return;
    }
    if (localVector3D.length() != null) {
      backgroundColor = localVector3D.length().intValue();
    }
    if (localVector3D.getZ() != null) {
      textColor = localVector3D.getZ().intValue();
    }
    if (localVector3D.getSecond() != null) {
      borderColor = localVector3D.getSecond().intValue();
    }
  }
  
  public JSONObject forJsonPut()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = Id;
      localJSONObject.put("id", i);
      Object localObject = clickAction;
      localJSONObject.put("click_action", ((Enum)localObject).toString());
      localObject = uri;
      if (localObject != null) {
        localJSONObject.put("uri", String.valueOf(localObject));
      }
      localObject = text;
      localJSONObject.putOpt("text", localObject);
      i = backgroundColor;
      localJSONObject.put("bg_color", i);
      i = textColor;
      localJSONObject.put("text_color", i);
      boolean bool = openUriInWebview;
      localJSONObject.put("use_webview", bool);
      i = borderColor;
      localJSONObject.put("border_color", i);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    return jsonObject;
  }
  
  public final int getBackgroundColor()
  {
    return backgroundColor;
  }
  
  public final int getBorderColor()
  {
    return borderColor;
  }
  
  public final ClickAction getClickAction()
  {
    return clickAction;
  }
  
  public final boolean getOpenUriInWebview()
  {
    return openUriInWebview;
  }
  
  public final String getStringId()
  {
    return String.valueOf(Id);
  }
  
  public final String getText()
  {
    return text;
  }
  
  public final int getTextColor()
  {
    return textColor;
  }
  
  public final Uri getUri()
  {
    return uri;
  }
  
  public static final class a
  {
    private a() {}
  }
  
  static final class b
    extends j
    implements a<String>
  {
    public static final b G5 = new b();
    
    b()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot apply dark theme with a null themes wrapper";
    }
  }
}
