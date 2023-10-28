package com.braze.ui.inappmessage.listeners;

import android.os.Bundle;
import com.braze.models.inappmessage.IInAppMessage;

public abstract interface IInAppMessageWebViewClientListener
{
  public abstract void onCloseAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
  
  public abstract void onCustomEventAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
  
  public abstract void onNewsfeedAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
  
  public abstract void onOtherUrlAction(IInAppMessage paramIInAppMessage, String paramString, Bundle paramBundle);
}
