package com.braze.ui.inappmessage.jsinterface;

import android.content.Context;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.PermissionUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.BrazeInAppMessageManager.Companion;
import com.braze.ui.inappmessage.InAppMessageManagerBase;
import java.math.BigDecimal;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import org.json.JSONObject;

public final class InAppMessageJavascriptInterface
{
  private final Context context;
  private final IInAppMessageHtml inAppMessage;
  private final InAppMessageUserJavascriptInterface user;
  
  public InAppMessageJavascriptInterface(Context paramContext, IInAppMessageHtml paramIInAppMessageHtml)
  {
    context = paramContext;
    inAppMessage = paramIInAppMessageHtml;
    user = new InAppMessageUserJavascriptInterface(paramContext);
  }
  
  public final void changeUser(String paramString1, String paramString2)
  {
    i.e(paramString1, "userId");
    Braze.Companion.getInstance(context).changeUser(paramString1, paramString2);
  }
  
  public final InAppMessageUserJavascriptInterface getUser()
  {
    return user;
  }
  
  public final void logButtonClick(String paramString)
  {
    if (paramString != null) {
      inAppMessage.logButtonClick(paramString);
    }
  }
  
  public final void logClick()
  {
    inAppMessage.logClick();
  }
  
  public final void logCustomEventWithJSON(String paramString1, String paramString2)
  {
    paramString2 = parseProperties(paramString2);
    Braze.Companion.getInstance(context).logCustomEvent(paramString1, paramString2);
  }
  
  public final void logPurchaseWithJSON(String paramString1, double paramDouble, String paramString2, int paramInt, String paramString3)
  {
    paramString3 = parseProperties(paramString3);
    Braze.Companion.getInstance(context).logPurchase(paramString1, paramString2, new BigDecimal(String.valueOf(paramDouble)), paramInt, paramString3);
  }
  
  public final BrazeProperties parseProperties(String paramString)
  {
    if (paramString != null) {
      try
      {
        boolean bool = i.a(paramString, "undefined");
        if (!bool)
        {
          bool = i.a(paramString, "null");
          if (!bool)
          {
            BrazeProperties localBrazeProperties = new BrazeProperties(new JSONObject(paramString));
            return localBrazeProperties;
          }
        }
      }
      catch (Exception localException)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localException, new j(paramString)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Failed to parse properties JSON String: ");
            localStringBuilder.append(InAppMessageJavascriptInterface.this);
            return localStringBuilder.toString();
          }
        });
      }
    }
    return null;
  }
  
  public final void requestImmediateDataFlush()
  {
    Braze.Companion.getInstance(context).requestImmediateDataFlush();
  }
  
  public final void requestPushPermission()
  {
    BrazeInAppMessageManager.Companion localCompanion = BrazeInAppMessageManager.Companion;
    localCompanion.getInstance().setShouldNextUnregisterBeSkipped(true);
    PermissionUtils.requestPushPermissionPrompt(localCompanion.getInstance().getActivity());
  }
}
