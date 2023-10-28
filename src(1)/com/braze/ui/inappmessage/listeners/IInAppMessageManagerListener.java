package com.braze.ui.inappmessage.listeners;

import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.inappmessage.InAppMessageCloser;
import com.braze.ui.inappmessage.InAppMessageOperation;

public abstract interface IInAppMessageManagerListener
{
  public abstract void afterInAppMessageViewClosed(IInAppMessage paramIInAppMessage);
  
  public abstract void afterInAppMessageViewOpened(View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage paramIInAppMessage);
  
  public abstract void beforeInAppMessageViewClosed(View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract void beforeInAppMessageViewOpened(View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract boolean onInAppMessageButtonClicked(IInAppMessage paramIInAppMessage, MessageButton paramMessageButton);
  
  public abstract boolean onInAppMessageButtonClicked(IInAppMessage paramIInAppMessage, MessageButton paramMessageButton, InAppMessageCloser paramInAppMessageCloser);
  
  public abstract boolean onInAppMessageClicked(IInAppMessage paramIInAppMessage);
  
  public abstract boolean onInAppMessageClicked(IInAppMessage paramIInAppMessage, InAppMessageCloser paramInAppMessageCloser);
  
  public abstract void onInAppMessageDismissed(IInAppMessage paramIInAppMessage);
}
