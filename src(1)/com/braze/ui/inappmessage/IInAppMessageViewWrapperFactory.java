package com.braze.ui.inappmessage;

import android.view.View;
import android.view.animation.Animation;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import java.util.List;

public abstract interface IInAppMessageViewWrapperFactory
{
  public abstract IInAppMessageViewWrapper createInAppMessageViewWrapper(View paramView1, IInAppMessage paramIInAppMessage, IInAppMessageViewLifecycleListener paramIInAppMessageViewLifecycleListener, BrazeConfigurationProvider paramBrazeConfigurationProvider, Animation paramAnimation1, Animation paramAnimation2, View paramView2);
  
  public abstract IInAppMessageViewWrapper createInAppMessageViewWrapper(View paramView1, IInAppMessage paramIInAppMessage, IInAppMessageViewLifecycleListener paramIInAppMessageViewLifecycleListener, BrazeConfigurationProvider paramBrazeConfigurationProvider, Animation paramAnimation1, Animation paramAnimation2, View paramView2, List paramList, View paramView3);
}
