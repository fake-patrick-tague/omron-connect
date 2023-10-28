package com.braze.models.inappmessage;

import android.graphics.Color;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.a0.f;
import kotlin.collections.x;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.c.l;
import kotlin.x.d.j;
import kotlin.z.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.BarFormatter;
import protect.package_9.ClassWriter;
import protect.package_9.Entry;
import protect.package_9.MethodWriter;
import protect.package_9.Name;

public abstract class InAppMessageImmersiveBase
  extends InAppMessageWithImageBase
  implements IInAppMessageImmersive
{
  public static final a Companion = new a(null);
  private String buttonIdClicked;
  private int closeButtonColor = Color.parseColor("#9B9B9B");
  private Integer frameColor;
  private String header;
  private TextAlign headerTextAlign = TextAlign.CENTER;
  private int headerTextColor = Color.parseColor("#333333");
  private ImageStyle imageStyle = ImageStyle.HORIZONTAL;
  private List<? extends MessageButton> messageButtons = kotlin.collections.i.d();
  private boolean wasButtonClickLogged;
  
  protected InAppMessageImmersiveBase() {}
  
  public InAppMessageImmersiveBase(JSONObject paramJSONObject, protect.package_9.c paramC)
  {
    this(paramJSONObject, paramC, str, j, k, (ImageStyle)localObject1, (TextAlign)localObject2, (TextAlign)localObject3);
    localObject2 = paramJSONObject.optJSONArray("btns");
    paramC = Name.fromJSON(paramJSONObject);
    localObject1 = new ArrayList();
    if (localObject2 == null) {
      paramJSONObject = kotlin.collections.i.d().iterator();
    } else {
      paramJSONObject = f.i(f.f(kotlin.collections.i.n((Iterable)d.g(0, ((JSONArray)localObject2).length())), new f((JSONArray)localObject2)), new g((JSONArray)localObject2)).iterator();
    }
    paramJSONObject = kotlin.collections.i.j(paramJSONObject);
    while (paramJSONObject.hasNext())
    {
      localObject2 = (x)paramJSONObject.next();
      ((List)localObject1).add(new MessageButton((JSONObject)((x)localObject2).b(), paramC.optJSONObject(((x)localObject2).a())));
    }
    setMessageButtons((List)localObject1);
  }
  
  private InAppMessageImmersiveBase(JSONObject paramJSONObject, protect.package_9.c paramC, String paramString, int paramInt1, int paramInt2, ImageStyle paramImageStyle, TextAlign paramTextAlign1, TextAlign paramTextAlign2)
  {
    super(paramJSONObject, paramC);
    setHeader(paramString);
    setHeaderTextColor(paramInt1);
    setCloseButtonColor(paramInt2);
    if (paramJSONObject.has("frame_color")) {
      setFrameColor(Integer.valueOf(paramJSONObject.optInt("frame_color")));
    }
    setImageStyle(paramImageStyle);
    setHeaderTextAlign(paramTextAlign1);
    setMessageTextAlign(paramTextAlign2);
  }
  
  public void enableDarkTheme()
  {
    super.enableDarkTheme();
    Object localObject = getInAppMessageDarkThemeWrapper();
    if (localObject == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, b.PLAYING, 3, null);
      return;
    }
    if (((Entry)localObject).compare() != null) {
      setFrameColor(((Entry)localObject).compare());
    }
    if (((Entry)localObject).getAnchor() != null) {
      setCloseButtonColor(((Entry)localObject).getAnchor().intValue());
    }
    if (((Entry)localObject).getDimension() != null) {
      setHeaderTextColor(((Entry)localObject).getDimension().intValue());
    }
    localObject = getMessageButtons().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((MessageButton)((Iterator)localObject).next()).enableDarkTheme();
    }
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
      localJSONObject.putOpt("header", getHeader());
      localJSONObject.put("header_text_color", getHeaderTextColor());
      localJSONObject.put("close_btn_color", getCloseButtonColor());
      localJSONObject.putOpt("image_style", getImageStyle().toString());
      localJSONObject.putOpt("text_align_header", getHeaderTextAlign().toString());
      Object localObject1 = getFrameColor();
      if (localObject1 != null) {
        localJSONObject.put("frame_color", ((Number)localObject1).intValue());
      }
      localObject1 = new JSONArray();
      Iterator localIterator = getMessageButtons().iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        Object localObject2 = localIterator.next();
        localObject2 = (MessageButton)localObject2;
        ((JSONArray)localObject1).put(((MessageButton)localObject2).forJsonPut());
      }
      localJSONObject.put("btns", localObject1);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public int getCloseButtonColor()
  {
    return closeButtonColor;
  }
  
  public Integer getFrameColor()
  {
    return frameColor;
  }
  
  public String getHeader()
  {
    return header;
  }
  
  public TextAlign getHeaderTextAlign()
  {
    return headerTextAlign;
  }
  
  public int getHeaderTextColor()
  {
    return headerTextColor;
  }
  
  public ImageStyle getImageStyle()
  {
    return imageStyle;
  }
  
  public List getMessageButtons()
  {
    return messageButtons;
  }
  
  public boolean logButtonClick(MessageButton paramMessageButton)
  {
    kotlin.x.d.i.e(paramMessageButton, "messageButton");
    protect.package_9.c localC = getBrazeManager();
    String str = getTriggerId();
    int i;
    if ((str != null) && (!g.o(str))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, c.PLAYING, 3, null);
      return false;
    }
    if (wasButtonClickLogged)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, d.components, 2, null);
      return false;
    }
    if (localC == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, e.cn, 2, null);
      return false;
    }
    buttonIdClicked = paramMessageButton.getStringId();
    paramMessageButton = ClassWriter.o.a(str, paramMessageButton);
    if (paramMessageButton != null) {
      localC.a(paramMessageButton);
    }
    wasButtonClickLogged = true;
    return true;
  }
  
  public void onAfterClosed()
  {
    super.onAfterClosed();
    protect.package_9.c localC = getBrazeManager();
    if (wasButtonClickLogged)
    {
      String str = getTriggerId();
      int j = 0;
      int i;
      if ((str != null) && (!g.o(str))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        str = buttonIdClicked;
        if (str != null)
        {
          i = j;
          if (!g.o(str)) {}
        }
        else
        {
          i = 1;
        }
        if ((i == 0) && (localC != null)) {
          localC.a(new BarFormatter(getTriggerId(), buttonIdClicked));
        }
      }
    }
  }
  
  public void setCloseButtonColor(int paramInt)
  {
    closeButtonColor = paramInt;
  }
  
  public void setFrameColor(Integer paramInteger)
  {
    frameColor = paramInteger;
  }
  
  public void setHeader(String paramString)
  {
    header = paramString;
  }
  
  public void setHeaderTextAlign(TextAlign paramTextAlign)
  {
    kotlin.x.d.i.e(paramTextAlign, "<set-?>");
    headerTextAlign = paramTextAlign;
  }
  
  public void setHeaderTextColor(int paramInt)
  {
    headerTextColor = paramInt;
  }
  
  public void setImageStyle(ImageStyle paramImageStyle)
  {
    kotlin.x.d.i.e(paramImageStyle, "<set-?>");
    imageStyle = paramImageStyle;
  }
  
  public void setMessageButtons(List paramList)
  {
    kotlin.x.d.i.e(paramList, "<set-?>");
    messageButtons = paramList;
  }
  
  public static final class a
  {
    private a() {}
  }
  
  static final class b
    extends j
    implements a<String>
  {
    public static final b PLAYING = new b();
    
    b()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot apply dark theme with a null themes wrapper";
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    public static final c PLAYING = new c();
    
    c()
    {
      super();
    }
    
    public final String getText()
    {
      return "Trigger id not found (this is expected for test sends). Not logging button click.";
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    public static final d components = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "Button click already logged for this message. Ignoring.";
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    public static final e cn = new e();
    
    e()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot log a button click because the BrazeManager is null.";
    }
  }
  
  public static final class f
    extends j
    implements l<Integer, Boolean>
  {
    public f(JSONArray paramJSONArray)
    {
      super();
    }
    
    public final Boolean get(int paramInt)
    {
      return Boolean.valueOf(baseArgs.opt(paramInt) instanceof JSONObject);
    }
  }
  
  public static final class g
    extends j
    implements l<Integer, JSONObject>
  {
    public g(JSONArray paramJSONArray)
    {
      super();
    }
    
    public final Object get(int paramInt)
    {
      Object localObject = protocols.get(paramInt);
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type org.json.JSONObject");
      return (JSONObject)localObject;
    }
  }
}
