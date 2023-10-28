package com.braze.models.inappmessage;

import android.graphics.Color;
import android.net.Uri;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.DismissType;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.Orientation;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.JsonUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.a0;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.j;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.BarFormatter;
import protect.package_9.ClassWriter;
import protect.package_9.Entry;
import protect.package_9.Level;
import protect.package_9.MethodWriter;
import protect.package_9.Name;
import protect.package_9.c;
import protect.package_9.p;

public abstract class InAppMessageBase
  implements IInAppMessage, IInAppMessageThemeable
{
  public static final a Companion = new a(null);
  private boolean animateIn;
  private boolean animateOut;
  private int backgroundColor;
  private c brazeManager;
  private final AtomicBoolean clickLogged;
  private CropType cropType;
  private DismissType dismissType;
  private final AtomicBoolean displayFailureLogged;
  private int durationInMilliseconds;
  private long expirationTimestamp;
  private Map<String, String> extras = a0.d();
  private String icon;
  private int iconBackgroundColor;
  private int iconColor;
  private final AtomicBoolean impressionLogged;
  private Entry inAppMessageDarkThemeWrapper;
  private ClickAction internalClickAction = ClickAction.NONE;
  private Uri internalUri;
  private JSONObject jsonObject;
  private String message;
  private TextAlign messageTextAlign;
  private int messageTextColor;
  private boolean openUriInWebView;
  private Orientation orientation;
  
  public InAppMessageBase()
  {
    animateIn = true;
    animateOut = true;
    dismissType = DismissType.AUTO_DISMISS;
    durationInMilliseconds = 5000;
    orientation = Orientation.VERTICAL;
    cropType = CropType.FIT_CENTER;
    messageTextAlign = TextAlign.CENTER;
    expirationTimestamp = -1L;
    iconBackgroundColor = Color.parseColor("#ff0073d5");
    messageTextColor = Color.parseColor("#555555");
    backgroundColor = -1;
    iconColor = -1;
    impressionLogged = new AtomicBoolean(false);
    clickLogged = new AtomicBoolean(false);
    displayFailureLogged = new AtomicBoolean(false);
  }
  
  public InAppMessageBase(JSONObject paramJSONObject, c paramC, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    animateIn = true;
    animateOut = true;
    dismissType = DismissType.AUTO_DISMISS;
    durationInMilliseconds = 5000;
    localObject1 = Orientation.VERTICAL;
    orientation = ((Orientation)localObject1);
    cropType = CropType.FIT_CENTER;
    messageTextAlign = TextAlign.CENTER;
    expirationTimestamp = -1L;
    iconBackgroundColor = Color.parseColor("#ff0073d5");
    messageTextColor = Color.parseColor("#555555");
    backgroundColor = -1;
    iconColor = -1;
    int j = 0;
    impressionLogged = new AtomicBoolean(false);
    clickLogged = new AtomicBoolean(false);
    displayFailureLogged = new AtomicBoolean(false);
    jsonObject = paramJSONObject;
    brazeManager = paramC;
    setMessage(paramJSONObject.optString("message"));
    setAnimateIn(paramJSONObject.optBoolean("animate_in", true));
    setAnimateOut(paramJSONObject.optBoolean("animate_out", true));
    setDurationInMilliseconds(paramJSONObject.optInt("duration"));
    setIcon(paramJSONObject.optString("icon"));
    paramC = Level.this$0;
    try
    {
      paramC = paramJSONObject.getString("orientation");
      kotlin.x.d.i.d(paramC, "jsonObject.getString(key)");
      localObject2 = Locale.US;
      kotlin.x.d.i.d(localObject2, "US");
      localObject2 = paramC.toUpperCase((Locale)localObject2);
      kotlin.x.d.i.d(localObject2, "this as java.lang.String).toUpperCase(locale)");
      localObject3 = Orientation.values();
      m = localObject3.length;
      i = 0;
      while (i < m)
      {
        paramC = localObject3[i];
        i += 1;
        boolean bool = kotlin.x.d.i.a(paramC.name(), localObject2);
        if (bool) {
          break label328;
        }
      }
      paramC = new NoSuchElementException("Array contains no element matching the predicate.");
      throw paramC;
    }
    catch (Exception paramC)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        int m;
        int i;
        label328:
        paramC = (c)localObject1;
      }
    }
    setOrientation(paramC);
    setOpenUriInWebView(paramJSONObject.optBoolean("use_webview", false));
    setIconBackgroundColor(paramJSONObject.optInt("icon_bg_color"));
    setMessageTextColor(paramJSONObject.optInt("text_color"));
    setBackgroundColor(paramJSONObject.optInt("bg_color"));
    setIconColor(paramJSONObject.optInt("icon_color"));
    impressionLogged.set(paramBoolean1);
    clickLogged.set(paramBoolean2);
    setExtras(JsonUtils.convertJSONObjectToMap(paramJSONObject.optJSONObject("extras")));
    localObject2 = paramJSONObject.optString("uri");
    paramC = ClickAction.NONE;
    localObject1 = Level.this$0;
    try
    {
      localObject1 = paramJSONObject.getString("click_action");
      kotlin.x.d.i.d(localObject1, "jsonObject.getString(key)");
      localObject3 = Locale.US;
      kotlin.x.d.i.d(localObject3, "US");
      localObject3 = ((String)localObject1).toUpperCase((Locale)localObject3);
      kotlin.x.d.i.d(localObject3, "this as java.lang.String).toUpperCase(locale)");
      ClickAction[] arrayOfClickAction = ClickAction.values();
      m = arrayOfClickAction.length;
      i = 0;
      while (i < m)
      {
        localObject1 = arrayOfClickAction[i];
        i += 1;
        paramBoolean1 = kotlin.x.d.i.a(((Enum)localObject1).name(), localObject3);
        if (paramBoolean1)
        {
          paramC = (c)localObject1;
          break label553;
        }
      }
      localObject1 = new NoSuchElementException("Array contains no element matching the predicate.");
      throw ((Throwable)localObject1);
    }
    catch (Exception localException1)
    {
      label553:
      for (;;) {}
    }
    if (paramC == ClickAction.FUTURE)
    {
      i = k;
      if (localObject2 != null) {
        if (g.o((CharSequence)localObject2)) {
          i = k;
        } else {
          i = 0;
        }
      }
      if (i == 0) {
        internalUri = Uri.parse((String)localObject2);
      }
    }
    internalClickAction = paramC;
    paramC = DismissType.AUTO_DISMISS;
    localObject1 = Level.this$0;
    try
    {
      localObject1 = paramJSONObject.getString("message_close");
      kotlin.x.d.i.d(localObject1, "jsonObject.getString(key)");
      localObject2 = Locale.US;
      kotlin.x.d.i.d(localObject2, "US");
      localObject2 = ((String)localObject1).toUpperCase((Locale)localObject2);
      kotlin.x.d.i.d(localObject2, "this as java.lang.String).toUpperCase(locale)");
      localObject3 = DismissType.values();
      k = localObject3.length;
      i = j;
      while (i < k)
      {
        localObject1 = localObject3[i];
        i += 1;
        paramBoolean1 = kotlin.x.d.i.a(((Enum)localObject1).name(), localObject2);
        if (paramBoolean1)
        {
          paramC = (c)localObject1;
          break label731;
        }
      }
      localObject1 = new NoSuchElementException("Array contains no element matching the predicate.");
      throw ((Throwable)localObject1);
    }
    catch (Exception localException2)
    {
      label731:
      for (;;) {}
    }
    localObject1 = paramC;
    if (paramC == DismissType.SWIPE) {
      localObject1 = DismissType.MANUAL;
    }
    setDismissType((DismissType)localObject1);
    inAppMessageDarkThemeWrapper = Name.copy(paramJSONObject);
  }
  
  public void enableDarkTheme()
  {
    Entry localEntry = inAppMessageDarkThemeWrapper;
    if (localEntry == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, d.PLAYING, 3, null);
      return;
    }
    if (localEntry.getValue() != null) {
      setBackgroundColor(localEntry.getValue().intValue());
    }
    if (localEntry.getDesc() != null) {
      setIconColor(localEntry.getDesc().intValue());
    }
    if (localEntry.getIcon() != null) {
      setIconBackgroundColor(localEntry.getIcon().intValue());
    }
    if (localEntry.getSecond() != null) {
      setMessageTextColor(localEntry.getSecond().intValue());
    }
  }
  
  public JSONObject forJsonPut()
  {
    JSONObject localJSONObject = jsonObject;
    if (localJSONObject != null) {
      return localJSONObject;
    }
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("message", getMessage());
      localJSONObject.put("duration", getDurationInMilliseconds());
      localJSONObject.putOpt("trigger_id", getTriggerId());
      localJSONObject.putOpt("click_action", getClickAction().toString());
      localJSONObject.putOpt("message_close", getDismissType().toString());
      Uri localUri = getUri();
      if (localUri != null) {
        localJSONObject.put("uri", String.valueOf(getUri()));
      }
      localJSONObject.put("use_webview", getOpenUriInWebView());
      localJSONObject.put("animate_in", getAnimateIn());
      localJSONObject.put("animate_out", getAnimateOut());
      localJSONObject.put("bg_color", getBackgroundColor());
      localJSONObject.put("text_color", getMessageTextColor());
      localJSONObject.put("icon_color", getIconColor());
      localJSONObject.put("icon_bg_color", getIconBackgroundColor());
      localJSONObject.putOpt("icon", getIcon());
      localJSONObject.putOpt("crop_type", getCropType().toString());
      localJSONObject.putOpt("orientation", getOrientation().toString());
      localJSONObject.putOpt("text_align_message", getMessageTextAlign().toString());
      localJSONObject.putOpt("is_control", Boolean.valueOf(isControl()));
      boolean bool = getExtras().isEmpty();
      if ((bool ^ true))
      {
        localJSONObject.put("extras", getExtras());
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localJSONException, e.SingleTap);
    }
    return localJSONObject;
  }
  
  public boolean getAnimateIn()
  {
    return animateIn;
  }
  
  public boolean getAnimateOut()
  {
    return animateOut;
  }
  
  public int getBackgroundColor()
  {
    return backgroundColor;
  }
  
  public final c getBrazeManager()
  {
    return brazeManager;
  }
  
  public ClickAction getClickAction()
  {
    return internalClickAction;
  }
  
  public CropType getCropType()
  {
    return cropType;
  }
  
  public DismissType getDismissType()
  {
    return dismissType;
  }
  
  public int getDurationInMilliseconds()
  {
    return durationInMilliseconds;
  }
  
  public long getExpirationTimestamp()
  {
    return expirationTimestamp;
  }
  
  public Map getExtras()
  {
    return extras;
  }
  
  public String getIcon()
  {
    return icon;
  }
  
  public int getIconBackgroundColor()
  {
    return iconBackgroundColor;
  }
  
  public int getIconColor()
  {
    return iconColor;
  }
  
  public final Entry getInAppMessageDarkThemeWrapper()
  {
    return inAppMessageDarkThemeWrapper;
  }
  
  public final JSONObject getJsonObject()
  {
    return jsonObject;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public TextAlign getMessageTextAlign()
  {
    return messageTextAlign;
  }
  
  public int getMessageTextColor()
  {
    return messageTextColor;
  }
  
  public boolean getOpenUriInWebView()
  {
    return openUriInWebView;
  }
  
  public Orientation getOrientation()
  {
    return orientation;
  }
  
  public List getRemoteAssetPathsForPrefetch()
  {
    return kotlin.collections.i.d();
  }
  
  public final String getTriggerId()
  {
    JSONObject localJSONObject = jsonObject;
    if (localJSONObject != null) {
      return localJSONObject.optString("trigger_id");
    }
    return null;
  }
  
  public Uri getUri()
  {
    return internalUri;
  }
  
  public boolean isControl()
  {
    JSONObject localJSONObject = jsonObject;
    return (localJSONObject != null) && (localJSONObject.optBoolean("is_control") == true);
  }
  
  public boolean logClick()
  {
    Object localObject = getTriggerId();
    int i;
    if ((localObject != null) && (!g.o((CharSequence)localObject))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, f.PLAYING, 3, null);
      return false;
    }
    c localC = brazeManager;
    if (localC == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, g.PLAYING, 2, null);
      return false;
    }
    if ((clickLogged.get()) && (getMessageType() != MessageType.HTML))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, h.components, 2, null);
      return false;
    }
    if (displayFailureLogged.get())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, i.components, 2, null);
      return false;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, j.C, 2, null);
    localObject = ClassWriter.o.getItem((String)localObject);
    if (localObject != null) {
      localC.a((p)localObject);
    }
    clickLogged.set(true);
    return true;
  }
  
  public boolean logDisplayFailure(InAppMessageFailureType paramInAppMessageFailureType)
  {
    kotlin.x.d.i.e(paramInAppMessageFailureType, "failureType");
    String str = getTriggerId();
    int i;
    if ((str != null) && (!g.o(str))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, k.PLAYING, 3, null);
      return false;
    }
    c localC = brazeManager;
    if (localC == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, l.PLAYING, 2, null);
      return false;
    }
    if (displayFailureLogged.get())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, m.components, 2, null);
      return false;
    }
    if (clickLogged.get())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, n.components, 2, null);
      return false;
    }
    if (impressionLogged.get())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, o.d, 2, null);
      return false;
    }
    paramInAppMessageFailureType = ClassWriter.o.a(str, paramInAppMessageFailureType);
    if (paramInAppMessageFailureType != null) {
      localC.a(paramInAppMessageFailureType);
    }
    displayFailureLogged.set(true);
    return true;
  }
  
  public boolean logImpression()
  {
    Object localObject = getTriggerId();
    int i;
    if ((localObject != null) && (!g.o((CharSequence)localObject))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.BEGIN, null, p.CHANGE, 2, null);
      return false;
    }
    c localC = brazeManager;
    if (localC == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, q.PLAYING, 2, null);
      return false;
    }
    if (impressionLogged.get())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, r.components, 2, null);
      return false;
    }
    if (displayFailureLogged.get())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, s.d, 2, null);
      return false;
    }
    localObject = ClassWriter.o.d((String)localObject);
    if (localObject != null) {
      localC.a((p)localObject);
    }
    impressionLogged.set(true);
    return true;
  }
  
  public void onAfterClosed()
  {
    String str = getTriggerId();
    if (clickLogged.get())
    {
      int i;
      if ((str != null) && (str.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        c localC = brazeManager;
        if (localC != null) {
          localC.a(new BarFormatter(str));
        }
      }
    }
  }
  
  public void setAnimateIn(boolean paramBoolean)
  {
    animateIn = paramBoolean;
  }
  
  public void setAnimateOut(boolean paramBoolean)
  {
    animateOut = paramBoolean;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    backgroundColor = paramInt;
  }
  
  public void setCropType(CropType paramCropType)
  {
    kotlin.x.d.i.e(paramCropType, "<set-?>");
    cropType = paramCropType;
  }
  
  public void setDismissType(DismissType paramDismissType)
  {
    kotlin.x.d.i.e(paramDismissType, "<set-?>");
    dismissType = paramDismissType;
  }
  
  public void setDurationInMilliseconds(int paramInt)
  {
    if (paramInt < 999)
    {
      durationInMilliseconds = 5000;
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new b(paramInt), 3, null);
      return;
    }
    durationInMilliseconds = paramInt;
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new c(paramInt), 3, null);
  }
  
  public void setExpirationTimestamp(long paramLong)
  {
    expirationTimestamp = paramLong;
  }
  
  public void setExtras(Map paramMap)
  {
    kotlin.x.d.i.e(paramMap, "<set-?>");
    extras = paramMap;
  }
  
  public void setIcon(String paramString)
  {
    icon = paramString;
  }
  
  public void setIconBackgroundColor(int paramInt)
  {
    iconBackgroundColor = paramInt;
  }
  
  public void setIconColor(int paramInt)
  {
    iconColor = paramInt;
  }
  
  public void setLocalPrefetchedAssetPaths(Map paramMap)
  {
    kotlin.x.d.i.e(paramMap, "remotePathToLocalAssetMap");
  }
  
  public void setMessage(String paramString)
  {
    message = paramString;
  }
  
  public void setMessageTextAlign(TextAlign paramTextAlign)
  {
    kotlin.x.d.i.e(paramTextAlign, "<set-?>");
    messageTextAlign = paramTextAlign;
  }
  
  public void setMessageTextColor(int paramInt)
  {
    messageTextColor = paramInt;
  }
  
  public void setOpenUriInWebView(boolean paramBoolean)
  {
    openUriInWebView = paramBoolean;
  }
  
  public void setOrientation(Orientation paramOrientation)
  {
    kotlin.x.d.i.e(paramOrientation, "<set-?>");
    orientation = paramOrientation;
  }
  
  public static final class a
  {
    private a() {}
  }
  
  static final class b
    extends j
    implements a<String>
  {
    b(int paramInt)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested in-app message duration ");
      localStringBuilder.append(src);
      localStringBuilder.append(" is lower than the minimum of 999. Defaulting to 5000 milliseconds.");
      return localStringBuilder.toString();
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    c(int paramInt)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Set in-app message duration to ");
      localStringBuilder.append(labels);
      localStringBuilder.append(" milliseconds.");
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    public static final d PLAYING = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot apply dark theme with a null themes wrapper";
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    public static final e SingleTap = new e();
    
    e()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to construct json for in-app message";
    }
  }
  
  static final class f
    extends j
    implements a<String>
  {
    public static final f PLAYING = new f();
    
    f()
    {
      super();
    }
    
    public final String getText()
    {
      return "Trigger id not found (this is expected for test sends). Not logging in-app message click.";
    }
  }
  
  static final class g
    extends j
    implements a<String>
  {
    public static final g PLAYING = new g();
    
    g()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot log an in-app message click because the BrazeManager is null.";
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    public static final h components = new h();
    
    h()
    {
      super();
    }
    
    public final String getText()
    {
      return "Click already logged for this in-app message. Ignoring.";
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    public static final i components = new i();
    
    i()
    {
      super();
    }
    
    public final String getText()
    {
      return "Display failure already logged for this in-app message. Ignoring.";
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    public static final j C = new j();
    
    j()
    {
      super();
    }
    
    public final String getText()
    {
      return "Logging click on in-app message";
    }
  }
  
  static final class k
    extends j
    implements a<String>
  {
    public static final k PLAYING = new k();
    
    k()
    {
      super();
    }
    
    public final String getText()
    {
      return "Trigger id not found (this is expected for test sends). Not logging in-app message display failure.";
    }
  }
  
  static final class l
    extends j
    implements a<String>
  {
    public static final l PLAYING = new l();
    
    l()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot log an in-app message display failure because the BrazeManager is null.";
    }
  }
  
  static final class m
    extends j
    implements a<String>
  {
    public static final m components = new m();
    
    m()
    {
      super();
    }
    
    public final String getText()
    {
      return "Display failure already logged for this in-app message. Ignoring.";
    }
  }
  
  static final class n
    extends j
    implements a<String>
  {
    public static final n components = new n();
    
    n()
    {
      super();
    }
    
    public final String getText()
    {
      return "Click already logged for this in-app message. Ignoring.";
    }
  }
  
  static final class o
    extends j
    implements a<String>
  {
    public static final o d = new o();
    
    o()
    {
      super();
    }
    
    public final String getText()
    {
      return "Impression already logged for this in-app message. Ignoring.";
    }
  }
  
  static final class p
    extends j
    implements a<String>
  {
    public static final p CHANGE = new p();
    
    p()
    {
      super();
    }
    
    public final String getText()
    {
      return "Trigger id not found (this is expected for test sends). Not logging in-app message impression.";
    }
  }
  
  static final class q
    extends j
    implements a<String>
  {
    public static final q PLAYING = new q();
    
    q()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot log an in-app message impression because the BrazeManager is null.";
    }
  }
  
  static final class r
    extends j
    implements a<String>
  {
    public static final r components = new r();
    
    r()
    {
      super();
    }
    
    public final String getText()
    {
      return "Impression already logged for this in-app message. Ignoring.";
    }
  }
  
  static final class s
    extends j
    implements a<String>
  {
    public static final s d = new s();
    
    s()
    {
      super();
    }
    
    public final String getText()
    {
      return "Display failure already logged for this in-app message. Ignoring.";
    }
  }
}
