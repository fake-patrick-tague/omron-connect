package com.braze.ui.inappmessage.listeners;

import android.net.Uri;
import android.os.BaseBundle;
import android.os.Bundle;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.enums.Channel;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.BundleUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler.Companion;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.BrazeInAppMessageManager.Companion;
import com.braze.ui.inappmessage.InAppMessageManagerBase;
import java.util.Iterator;
import java.util.Set;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public class DefaultInAppMessageWebViewClientListener
  implements IInAppMessageWebViewClientListener
{
  public static final Companion Companion = new Companion(null);
  
  public DefaultInAppMessageWebViewClientListener() {}
  
  private final BrazeInAppMessageManager getInAppMessageManager()
  {
    return BrazeInAppMessageManager.Companion.getInstance();
  }
  
  public void onCloseAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    i.e(paramIInAppMessage, "inAppMessage");
    i.e(paramString, "url");
    i.e(paramBundle, "queryBundle");
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, onCloseAction.1.INSTANCE, 3, null);
    Companion.logHtmlInAppMessageClick(paramIInAppMessage, paramBundle);
    getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(true);
    getInAppMessageManager().getHtmlInAppMessageActionListener().onCloseClicked(paramIInAppMessage, paramString, paramBundle);
  }
  
  public void onCustomEventAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    i.e(paramIInAppMessage, "inAppMessage");
    i.e(paramString, "url");
    i.e(paramBundle, "queryBundle");
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, onCustomEventAction.1.INSTANCE, 3, null);
    if (getInAppMessageManager().getActivity() == null)
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.PREPARED, null, onCustomEventAction.2.INSTANCE, 2, null);
      return;
    }
    if (!getInAppMessageManager().getHtmlInAppMessageActionListener().onCustomEventFired(paramIInAppMessage, paramString, paramBundle))
    {
      paramString = Companion;
      paramIInAppMessage = paramString.parseCustomEventNameFromQueryBundle(paramBundle);
      int i;
      if ((paramIInAppMessage != null) && (!g.o(paramIInAppMessage))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return;
      }
      paramString = paramString.parsePropertiesFromQueryBundle(paramBundle);
      paramBundle = getInAppMessageManager().getActivity();
      if (paramBundle != null) {
        Braze.Companion.getInstance(paramBundle).logCustomEvent(paramIInAppMessage, paramString);
      }
    }
  }
  
  public void onNewsfeedAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle)
  {
    i.e(paramIInAppMessage, "inAppMessage");
    i.e(paramString, "url");
    i.e(paramBundle, "queryBundle");
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, onNewsfeedAction.1.INSTANCE, 3, null);
    if (getInAppMessageManager().getActivity() == null)
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.PREPARED, null, onNewsfeedAction.2.INSTANCE, 2, null);
      return;
    }
    Companion.logHtmlInAppMessageClick(paramIInAppMessage, paramBundle);
    if (!getInAppMessageManager().getHtmlInAppMessageActionListener().onNewsfeedClicked(paramIInAppMessage, paramString, paramBundle))
    {
      paramIInAppMessage.setAnimateOut(false);
      getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
      paramIInAppMessage = new NewsfeedAction(BundleUtils.toBundle(paramIInAppMessage.getExtras()), Channel.INAPP_MESSAGE);
      paramString = getInAppMessageManager().getActivity();
      if (paramString != null) {
        BrazeDeeplinkHandler.Companion.getInstance().gotoNewsFeed(paramString, paramIInAppMessage);
      }
    }
  }
  
  public void onOtherUrlAction(IInAppMessage paramIInAppMessage, final String paramString, Bundle paramBundle)
  {
    i.e(paramIInAppMessage, "inAppMessage");
    i.e(paramString, "url");
    i.e(paramBundle, "queryBundle");
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, onOtherUrlAction.1.INSTANCE, 3, null);
    if (getInAppMessageManager().getActivity() == null)
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.PREPARED, null, new j(paramString)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Can't perform other url action because the cached activity is null. Url: ");
          localStringBuilder.append(DefaultInAppMessageWebViewClientListener.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    Object localObject = Companion;
    ((Companion)localObject).logHtmlInAppMessageClick(paramIInAppMessage, paramBundle);
    if (getInAppMessageManager().getHtmlInAppMessageActionListener().onOtherUrlAction(paramIInAppMessage, paramString, paramBundle))
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramString)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("HTML message action listener handled url in onOtherUrlAction. Doing nothing further. Url: ");
          localStringBuilder.append(DefaultInAppMessageWebViewClientListener.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    boolean bool = ((Companion)localObject).parseUseWebViewFromQueryBundle(paramIInAppMessage, paramBundle);
    localObject = BundleUtils.toBundle(paramIInAppMessage.getExtras());
    ((Bundle)localObject).putAll(paramBundle);
    paramBundle = BrazeDeeplinkHandler.Companion;
    localObject = paramBundle.getInstance().createUriActionFromUrlString(paramString, (Bundle)localObject, bool, Channel.INAPP_MESSAGE);
    if (localObject == null)
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.PREPARED, null, new j(paramString)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("UriAction is null. Not passing any URI to BrazeDeeplinkHandler. Url: ");
          localStringBuilder.append(DefaultInAppMessageWebViewClientListener.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    Uri localUri = ((UriAction)localObject).getUri();
    if (BrazeFileUtils.isLocalUri(localUri))
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.PREPARED, null, new j(localUri)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Not passing local uri to BrazeDeeplinkHandler. Got local uri: ");
          localStringBuilder.append(DefaultInAppMessageWebViewClientListener.this);
          localStringBuilder.append(" for url: ");
          localStringBuilder.append(paramString);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    paramIInAppMessage.setAnimateOut(false);
    getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
    paramIInAppMessage = getInAppMessageManager().getActivity();
    if (paramIInAppMessage != null) {
      paramBundle.getInstance().gotoUri(paramIInAppMessage, (UriAction)localObject);
    }
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    public final void logHtmlInAppMessageClick(IInAppMessage paramIInAppMessage, Bundle paramBundle)
    {
      i.e(paramIInAppMessage, "inAppMessage");
      i.e(paramBundle, "queryBundle");
      if (paramBundle.containsKey("abButtonId"))
      {
        paramIInAppMessage = (IInAppMessageHtml)paramIInAppMessage;
        paramBundle = paramBundle.getString("abButtonId");
        if (paramBundle != null) {
          paramIInAppMessage.logButtonClick(paramBundle);
        }
      }
      else if (paramIInAppMessage.getMessageType() == MessageType.HTML_FULL)
      {
        paramIInAppMessage.logClick();
      }
    }
    
    public final String parseCustomEventNameFromQueryBundle(Bundle paramBundle)
    {
      i.e(paramBundle, "queryBundle");
      return paramBundle.getString("name");
    }
    
    public final BrazeProperties parsePropertiesFromQueryBundle(Bundle paramBundle)
    {
      i.e(paramBundle, "queryBundle");
      BrazeProperties localBrazeProperties = new BrazeProperties();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if (!i.a(str1, "name"))
        {
          String str2 = paramBundle.getString(str1, null);
          int i;
          if ((str2 != null) && (!g.o(str2))) {
            i = 0;
          } else {
            i = 1;
          }
          if (i == 0)
          {
            i.d(str1, "key");
            localBrazeProperties.addProperty(str1, str2);
          }
        }
      }
      return localBrazeProperties;
    }
    
    public final boolean parseUseWebViewFromQueryBundle(IInAppMessage paramIInAppMessage, Bundle paramBundle)
    {
      i.e(paramIInAppMessage, "inAppMessage");
      i.e(paramBundle, "queryBundle");
      boolean bool1;
      int i;
      if (paramBundle.containsKey("abDeepLink"))
      {
        bool1 = Boolean.parseBoolean(paramBundle.getString("abDeepLink"));
        i = 1;
      }
      else
      {
        bool1 = false;
        i = 0;
      }
      boolean bool2;
      if (paramBundle.containsKey("abExternalOpen"))
      {
        bool2 = Boolean.parseBoolean(paramBundle.getString("abExternalOpen"));
        i = 1;
      }
      else
      {
        bool2 = false;
      }
      boolean bool3 = paramIInAppMessage.getOpenUriInWebView();
      if (i != 0) {
        return (!bool1) && (!bool2);
      }
      return bool3;
    }
  }
}
