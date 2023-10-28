package com.braze.ui.inappmessage.factories;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.R.layout;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView;
import com.braze.ui.inappmessage.views.InAppMessageHtmlView;
import com.braze.ui.support.ViewUtils;
import java.util.Objects;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public class DefaultInAppMessageHtmlViewFactory
  implements IInAppMessageViewFactory
{
  private final IInAppMessageWebViewClientListener inAppMessageWebViewClientListener;
  
  public DefaultInAppMessageHtmlViewFactory(IInAppMessageWebViewClientListener paramIInAppMessageWebViewClientListener)
  {
    inAppMessageWebViewClientListener = paramIInAppMessageWebViewClientListener;
  }
  
  public InAppMessageHtmlView createInAppMessageView(Activity paramActivity, IInAppMessage paramIInAppMessage)
  {
    i.e(paramActivity, "activity");
    i.e(paramIInAppMessage, "inAppMessage");
    Object localObject2 = paramActivity.getApplicationContext();
    Object localObject1 = paramActivity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_html, null);
    Objects.requireNonNull(localObject1, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageHtmlView");
    localObject1 = (InAppMessageHtmlView)localObject1;
    i.d(localObject2, "context");
    if ((new BrazeConfigurationProvider((Context)localObject2).isTouchModeRequiredForHtmlInAppMessages()) && (ViewUtils.isDeviceNotInTouchMode((View)localObject1)))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, createInAppMessageView.1.INSTANCE, 2, null);
      return null;
    }
    paramIInAppMessage = (InAppMessageHtml)paramIInAppMessage;
    localObject2 = new InAppMessageJavascriptInterface((Context)localObject2, paramIInAppMessage);
    InAppMessageHtmlBaseView.setWebViewContent$default((InAppMessageHtmlBaseView)localObject1, paramIInAppMessage.getMessage(), null, 2, null);
    paramActivity = paramActivity.getApplicationContext();
    i.d(paramActivity, "activity.applicationContext");
    ((InAppMessageHtmlBaseView)localObject1).setInAppMessageWebViewClient(new InAppMessageWebViewClient(paramActivity, paramIInAppMessage, inAppMessageWebViewClientListener));
    paramActivity = ((InAppMessageHtmlBaseView)localObject1).getMessageWebView();
    if (paramActivity != null) {
      paramActivity.addJavascriptInterface(localObject2, "brazeInternalBridge");
    }
    return localObject1;
  }
}
