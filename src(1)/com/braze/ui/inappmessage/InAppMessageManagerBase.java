package com.braze.ui.inappmessage;

import android.app.Activity;
import android.content.Context;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageAnimationFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageFullViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageHtmlFullViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageHtmlViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageModalViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageSlideupViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageViewWrapperFactory;
import com.braze.ui.inappmessage.listeners.DefaultHtmlInAppMessageActionListener;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public class InAppMessageManagerBase
{
  private IInAppMessageManagerListener customControlInAppMessageManagerListener;
  private IHtmlInAppMessageActionListener customHtmlInAppMessageActionListener;
  private IInAppMessageAnimationFactory customInAppMessageAnimationFactory;
  private IInAppMessageManagerListener customInAppMessageManagerListener;
  private IInAppMessageViewFactory customInAppMessageViewFactory;
  private IInAppMessageViewWrapperFactory customInAppMessageViewWrapperFactory;
  private final IHtmlInAppMessageActionListener defaultHtmlInAppMessageActionListener;
  private final IInAppMessageManagerListener defaultInAppMessageManagerListener;
  private final IInAppMessageViewWrapperFactory defaultInAppMessageViewWrapperFactory;
  private boolean doesBackButtonDismissInAppMessageViewField = true;
  private boolean doesClickOutsideModalViewDismissInAppMessageViewField;
  private final IInAppMessageAnimationFactory inAppMessageAnimationFactoryField;
  private final IInAppMessageViewFactory inAppMessageFullViewFactory;
  private final IInAppMessageViewFactory inAppMessageHtmlFullViewFactory;
  private final IInAppMessageViewFactory inAppMessageHtmlViewFactory;
  private final IInAppMessageViewFactory inAppMessageModalViewFactory;
  private final IInAppMessageViewFactory inAppMessageSlideupViewFactory;
  private final IInAppMessageWebViewClientListener inAppMessageWebViewClientListener;
  protected Activity mActivity;
  protected Context mApplicationContext;
  private boolean shouldNextUnregisterBeSkipped;
  
  public InAppMessageManagerBase()
  {
    DefaultInAppMessageWebViewClientListener localDefaultInAppMessageWebViewClientListener = new DefaultInAppMessageWebViewClientListener();
    inAppMessageWebViewClientListener = localDefaultInAppMessageWebViewClientListener;
    defaultHtmlInAppMessageActionListener = new DefaultHtmlInAppMessageActionListener();
    inAppMessageSlideupViewFactory = new DefaultInAppMessageSlideupViewFactory();
    inAppMessageModalViewFactory = new DefaultInAppMessageModalViewFactory();
    inAppMessageFullViewFactory = new DefaultInAppMessageFullViewFactory();
    inAppMessageHtmlFullViewFactory = new DefaultInAppMessageHtmlFullViewFactory(localDefaultInAppMessageWebViewClientListener);
    inAppMessageHtmlViewFactory = new DefaultInAppMessageHtmlViewFactory(localDefaultInAppMessageWebViewClientListener);
    inAppMessageAnimationFactoryField = new DefaultInAppMessageAnimationFactory();
    defaultInAppMessageManagerListener = new DefaultInAppMessageManagerListener();
    defaultInAppMessageViewWrapperFactory = new DefaultInAppMessageViewWrapperFactory();
  }
  
  public Activity getActivity()
  {
    return mActivity;
  }
  
  public Context getApplicationContext()
  {
    return mApplicationContext;
  }
  
  public IInAppMessageManagerListener getControlInAppMessageManagerListener()
  {
    IInAppMessageManagerListener localIInAppMessageManagerListener2 = customControlInAppMessageManagerListener;
    IInAppMessageManagerListener localIInAppMessageManagerListener1 = localIInAppMessageManagerListener2;
    if (localIInAppMessageManagerListener2 == null) {
      localIInAppMessageManagerListener1 = defaultInAppMessageManagerListener;
    }
    return localIInAppMessageManagerListener1;
  }
  
  public IInAppMessageViewFactory getDefaultInAppMessageViewFactory(IInAppMessage paramIInAppMessage)
  {
    i.e(paramIInAppMessage, "inAppMessage");
    MessageType localMessageType = paramIInAppMessage.getMessageType();
    int i = WhenMappings.$EnumSwitchMapping$0[localMessageType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new j(paramIInAppMessage)
              {
                public final String invoke()
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("Failed to find view factory for in-app message with type: ");
                  localStringBuilder.append(getMessageType());
                  return localStringBuilder.toString();
                }
              }, 2, null);
              return null;
            }
            return inAppMessageHtmlViewFactory;
          }
          return inAppMessageHtmlFullViewFactory;
        }
        return inAppMessageFullViewFactory;
      }
      return inAppMessageModalViewFactory;
    }
    return inAppMessageSlideupViewFactory;
  }
  
  public boolean getDoesBackButtonDismissInAppMessageView()
  {
    return doesBackButtonDismissInAppMessageViewField;
  }
  
  public boolean getDoesClickOutsideModalViewDismissInAppMessageView()
  {
    return doesClickOutsideModalViewDismissInAppMessageViewField;
  }
  
  public IHtmlInAppMessageActionListener getHtmlInAppMessageActionListener()
  {
    IHtmlInAppMessageActionListener localIHtmlInAppMessageActionListener2 = customHtmlInAppMessageActionListener;
    IHtmlInAppMessageActionListener localIHtmlInAppMessageActionListener1 = localIHtmlInAppMessageActionListener2;
    if (localIHtmlInAppMessageActionListener2 == null) {
      localIHtmlInAppMessageActionListener1 = defaultHtmlInAppMessageActionListener;
    }
    return localIHtmlInAppMessageActionListener1;
  }
  
  public IInAppMessageAnimationFactory getInAppMessageAnimationFactory()
  {
    IInAppMessageAnimationFactory localIInAppMessageAnimationFactory2 = customInAppMessageAnimationFactory;
    IInAppMessageAnimationFactory localIInAppMessageAnimationFactory1 = localIInAppMessageAnimationFactory2;
    if (localIInAppMessageAnimationFactory2 == null) {
      localIInAppMessageAnimationFactory1 = inAppMessageAnimationFactoryField;
    }
    return localIInAppMessageAnimationFactory1;
  }
  
  public IInAppMessageManagerListener getInAppMessageManagerListener()
  {
    IInAppMessageManagerListener localIInAppMessageManagerListener2 = customInAppMessageManagerListener;
    IInAppMessageManagerListener localIInAppMessageManagerListener1 = localIInAppMessageManagerListener2;
    if (localIInAppMessageManagerListener2 == null) {
      localIInAppMessageManagerListener1 = defaultInAppMessageManagerListener;
    }
    return localIInAppMessageManagerListener1;
  }
  
  public IInAppMessageViewFactory getInAppMessageViewFactory(IInAppMessage paramIInAppMessage)
  {
    i.e(paramIInAppMessage, "inAppMessage");
    IInAppMessageViewFactory localIInAppMessageViewFactory2 = customInAppMessageViewFactory;
    IInAppMessageViewFactory localIInAppMessageViewFactory1 = localIInAppMessageViewFactory2;
    if (localIInAppMessageViewFactory2 == null) {
      localIInAppMessageViewFactory1 = getDefaultInAppMessageViewFactory(paramIInAppMessage);
    }
    return localIInAppMessageViewFactory1;
  }
  
  public IInAppMessageViewWrapperFactory getInAppMessageViewWrapperFactory()
  {
    IInAppMessageViewWrapperFactory localIInAppMessageViewWrapperFactory2 = customInAppMessageViewWrapperFactory;
    IInAppMessageViewWrapperFactory localIInAppMessageViewWrapperFactory1 = localIInAppMessageViewWrapperFactory2;
    if (localIInAppMessageViewWrapperFactory2 == null) {
      localIInAppMessageViewWrapperFactory1 = defaultInAppMessageViewWrapperFactory;
    }
    return localIInAppMessageViewWrapperFactory1;
  }
  
  public boolean getShouldNextUnregisterBeSkipped()
  {
    return shouldNextUnregisterBeSkipped;
  }
  
  public void setCustomInAppMessageManagerListener(IInAppMessageManagerListener paramIInAppMessageManagerListener)
  {
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, setCustomInAppMessageManagerListener.1.INSTANCE, 3, null);
    customInAppMessageManagerListener = paramIInAppMessageManagerListener;
  }
  
  public void setShouldNextUnregisterBeSkipped(boolean paramBoolean)
  {
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new j(paramBoolean)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Setting setShouldNextUnregisterBeSkipped to ");
        localStringBuilder.append($shouldSkip);
        return localStringBuilder.toString();
      }
    }, 3, null);
    shouldNextUnregisterBeSkipped = paramBoolean;
  }
}
