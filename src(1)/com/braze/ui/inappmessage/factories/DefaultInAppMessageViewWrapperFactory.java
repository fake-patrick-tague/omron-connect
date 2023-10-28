package com.braze.ui.inappmessage.factories;

import android.view.View;
import android.view.animation.Animation;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper;
import com.braze.ui.inappmessage.IInAppMessageViewWrapper;
import com.braze.ui.inappmessage.IInAppMessageViewWrapperFactory;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import java.util.List;
import kotlin.x.d.i;

public class DefaultInAppMessageViewWrapperFactory
  implements IInAppMessageViewWrapperFactory
{
  public DefaultInAppMessageViewWrapperFactory() {}
  
  public IInAppMessageViewWrapper createInAppMessageViewWrapper(View paramView1, IInAppMessage paramIInAppMessage, IInAppMessageViewLifecycleListener paramIInAppMessageViewLifecycleListener, BrazeConfigurationProvider paramBrazeConfigurationProvider, Animation paramAnimation1, Animation paramAnimation2, View paramView2)
  {
    i.e(paramView1, "inAppMessageView");
    i.e(paramIInAppMessage, "inAppMessage");
    i.e(paramIInAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
    i.e(paramBrazeConfigurationProvider, "configurationProvider");
    return new DefaultInAppMessageViewWrapper(paramView1, paramIInAppMessage, paramIInAppMessageViewLifecycleListener, paramBrazeConfigurationProvider, paramAnimation1, paramAnimation2, paramView2, null, null, 384, null);
  }
  
  public IInAppMessageViewWrapper createInAppMessageViewWrapper(View paramView1, IInAppMessage paramIInAppMessage, IInAppMessageViewLifecycleListener paramIInAppMessageViewLifecycleListener, BrazeConfigurationProvider paramBrazeConfigurationProvider, Animation paramAnimation1, Animation paramAnimation2, View paramView2, List paramList, View paramView3)
  {
    i.e(paramView1, "inAppMessageView");
    i.e(paramIInAppMessage, "inAppMessage");
    i.e(paramIInAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
    i.e(paramBrazeConfigurationProvider, "configurationProvider");
    return new DefaultInAppMessageViewWrapper(paramView1, paramIInAppMessage, paramIInAppMessageViewLifecycleListener, paramBrazeConfigurationProvider, paramAnimation1, paramAnimation2, paramView2, paramList, paramView3);
  }
}
