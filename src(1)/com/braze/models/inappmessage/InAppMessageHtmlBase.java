package com.braze.models.inappmessage;

import com.braze.enums.inappmessage.MessageType;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import org.json.JSONObject;
import protect.package_9.BarFormatter;
import protect.package_9.ClassWriter;
import protect.package_9.MethodWriter;
import protect.package_9.c;
import protect.package_9.p;

public abstract class InAppMessageHtmlBase
  extends InAppMessageBase
  implements IInAppMessageHtml
{
  private String buttonIdClicked;
  private String localAssetsDirectoryUrl;
  private boolean wasButtonClickLogged;
  
  protected InAppMessageHtmlBase()
  {
    setOpenUriInWebView(true);
  }
  
  public InAppMessageHtmlBase(JSONObject paramJSONObject, c paramC)
  {
    super(paramJSONObject, paramC, false, false, 12, null);
    setOpenUriInWebView(paramJSONObject.optBoolean("use_webview", true));
  }
  
  public String getLocalAssetsDirectoryUrl()
  {
    return localAssetsDirectoryUrl;
  }
  
  public boolean logButtonClick(String paramString)
  {
    i.e(paramString, "buttonId");
    final String str = getTriggerId();
    c localC = getBrazeManager();
    int i;
    if ((str != null) && (str.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new a(paramString), 3, null);
      return false;
    }
    if (g.o(paramString))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, b.components, 2, null);
      return false;
    }
    if ((wasButtonClickLogged) && (getMessageType() != MessageType.HTML))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, c.components, 2, null);
      return false;
    }
    if (localC == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, d.cn, 2, null);
      return false;
    }
    p localP = ClassWriter.o.c(str, paramString);
    if (localP != null) {
      localC.a(localP);
    }
    buttonIdClicked = paramString;
    wasButtonClickLogged = true;
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new e(paramString, str), 3, null);
    return true;
  }
  
  public void onAfterClosed()
  {
    super.onAfterClosed();
    if (wasButtonClickLogged)
    {
      Object localObject = getTriggerId();
      int j = 0;
      int i;
      if ((localObject != null) && (!g.o((CharSequence)localObject))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject = buttonIdClicked;
        if (localObject != null)
        {
          i = j;
          if (!g.o((CharSequence)localObject)) {}
        }
        else
        {
          i = 1;
        }
        if (i == 0)
        {
          localObject = getBrazeManager();
          if (localObject != null) {
            ((c)localObject).a(new BarFormatter(getTriggerId(), buttonIdClicked));
          }
        }
      }
    }
  }
  
  public void setLocalAssetsDirectoryUrl(String paramString)
  {
    localAssetsDirectoryUrl = paramString;
  }
  
  public void setLocalPrefetchedAssetPaths(Map paramMap)
  {
    i.e(paramMap, "remotePathToLocalAssetMap");
    if ((paramMap.isEmpty() ^ true))
    {
      paramMap = paramMap.values().toArray(new String[0]);
      Objects.requireNonNull(paramMap, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
      setLocalAssetsDirectoryUrl(((String[])paramMap)[0]);
    }
  }
  
  static final class a
    extends j
    implements a<String>
  {
    a(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Trigger id not found (this is expected for test sends). Not logging html in-app message button click for id: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    public static final b components = new b();
    
    b()
    {
      super();
    }
    
    public final String getText()
    {
      return "Button Id was null or blank for this html in-app message. Ignoring.";
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    public static final c components = new c();
    
    c()
    {
      super();
    }
    
    public final String getText()
    {
      return "Button click already logged for this html in-app message. Ignoring.";
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    public static final d cn = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot log an html in-app message button click because the BrazeManager is null.";
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    e(String paramString1, String paramString2)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Logged button click for button id: ");
      localStringBuilder.append(mOrderBy);
      localStringBuilder.append(" and trigger id: ");
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
  }
}
