package com.braze.ui.inappmessage.listeners;

import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.inappmessage.InAppMessageCloser;

public abstract interface IInAppMessageViewLifecycleListener
{
  public abstract void afterClosed(IInAppMessage paramIInAppMessage);
  
  public abstract void afterOpened(View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract void beforeClosed(View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract void beforeOpened(View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract void onButtonClicked(InAppMessageCloser paramInAppMessageCloser, MessageButton paramMessageButton, IInAppMessageImmersive paramIInAppMessageImmersive);
  
  public abstract void onClicked(InAppMessageCloser paramInAppMessageCloser, View paramView, IInAppMessage paramIInAppMessage);
  
  public abstract void onDismissed(View paramView, IInAppMessage paramIInAppMessage);
}
