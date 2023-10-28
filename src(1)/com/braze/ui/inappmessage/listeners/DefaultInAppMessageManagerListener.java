package com.braze.ui.inappmessage.listeners;

import android.content.Context;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageThemeable;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.BrazeInAppMessageManager.Companion;
import com.braze.ui.inappmessage.InAppMessageManagerBase;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.support.ViewUtils;
import kotlin.x.d.i;

public class DefaultInAppMessageManagerListener
  implements IInAppMessageManagerListener
{
  public DefaultInAppMessageManagerListener() {}
  
  public InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage paramIInAppMessage)
  {
    i.e(paramIInAppMessage, "inAppMessage");
    if ((paramIInAppMessage instanceof IInAppMessageThemeable))
    {
      Context localContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext();
      if ((localContext != null) && (ViewUtils.isDeviceInNightMode(localContext))) {
        ((IInAppMessageThemeable)paramIInAppMessage).enableDarkTheme();
      }
    }
    return InAppMessageOperation.DISPLAY_NOW;
  }
}
