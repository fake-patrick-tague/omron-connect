package com.braze.ui.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.Animation;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.enums.inappmessage.Orientation;
import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;
import com.braze.events.SdkDataWipeEvent;
import com.braze.models.IPutIntoJson;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageImmersiveBase;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.JsonUtils;
import com.braze.support.PermissionUtils;
import com.braze.ui.actions.brazeactions.BrazeActionUtils;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer;
import com.braze.ui.inappmessage.views.IInAppMessageImmersiveView;
import com.braze.ui.inappmessage.views.IInAppMessageView;
import com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView;
import com.braze.ui.support.ViewUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.t;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import org.json.JSONObject;

public class BrazeInAppMessageManager
  extends InAppMessageManagerBase
{
  public static final Companion Companion = new Companion(null);
  private static volatile BrazeInAppMessageManager instance;
  private static final ReentrantLock instanceLock = new ReentrantLock();
  private IInAppMessage carryoverInAppMessage;
  private BrazeConfigurationProvider configurationProvider;
  public final AtomicBoolean displayingInAppMessage = new AtomicBoolean(false);
  private final Map<IInAppMessage, InAppMessageEvent> inAppMessageEventMap = new LinkedHashMap();
  private IEventSubscriber<InAppMessageEvent> inAppMessageEventSubscriber;
  private final Stack<IInAppMessage> inAppMessageStack = new Stack();
  private final IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener = new DefaultInAppMessageViewLifecycleListener();
  private IInAppMessageViewWrapper inAppMessageViewWrapper;
  private Integer originalOrientation;
  private IEventSubscriber<SdkDataWipeEvent> sdkDataWipeEventSubscriber;
  private IInAppMessage unregisteredInAppMessage;
  
  public BrazeInAppMessageManager() {}
  
  private final IEventSubscriber createInAppMessageEventSubscriber()
  {
    return new Scanner(this);
  }
  
  private static final void createInAppMessageEventSubscriber$lambda-8(BrazeInAppMessageManager paramBrazeInAppMessageManager, InAppMessageEvent paramInAppMessageEvent)
  {
    i.e(paramBrazeInAppMessageManager, "this$0");
    i.e(paramInAppMessageEvent, "event");
    IInAppMessage localIInAppMessage = paramInAppMessageEvent.getInAppMessage();
    inAppMessageEventMap.put(localIInAppMessage, paramInAppMessageEvent);
    paramBrazeInAppMessageManager.addInAppMessage(localIInAppMessage);
  }
  
  private static final void displayInAppMessage$lambda-7(IInAppMessageViewWrapper paramIInAppMessageViewWrapper, BrazeInAppMessageManager paramBrazeInAppMessageManager, Activity paramActivity)
  {
    i.e(paramBrazeInAppMessageManager, "this$0");
    if (paramIInAppMessageViewWrapper != null)
    {
      BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
      j local1 = displayInAppMessage.14.1.INSTANCE;
      try
      {
        BrazeLogger.brazelog$default(localBrazeLogger, paramBrazeInAppMessageManager, null, null, local1, 3, null);
        paramIInAppMessageViewWrapper.open(paramActivity);
        return;
      }
      catch (Exception paramIInAppMessageViewWrapper)
      {
        BrazeLogger.INSTANCE.brazelog(paramBrazeInAppMessageManager, BrazeLogger.Priority.this$0, paramIInAppMessageViewWrapper, displayInAppMessage.14.2.INSTANCE);
      }
    }
  }
  
  private static final void ensureSubscribedToInAppMessageEvents$lambda-1(BrazeInAppMessageManager paramBrazeInAppMessageManager, SdkDataWipeEvent paramSdkDataWipeEvent)
  {
    i.e(paramBrazeInAppMessageManager, "this$0");
    i.e(paramSdkDataWipeEvent, "it");
    inAppMessageStack.clear();
    carryoverInAppMessage = null;
    unregisteredInAppMessage = null;
  }
  
  public static final BrazeInAppMessageManager getInstance()
  {
    return Companion.getInstance();
  }
  
  public void addInAppMessage(IInAppMessage paramIInAppMessage)
  {
    if (paramIInAppMessage != null)
    {
      inAppMessageStack.push(paramIInAppMessage);
      requestDisplayInAppMessage();
    }
  }
  
  public void displayInAppMessage(IInAppMessage paramIInAppMessage, boolean paramBoolean)
  {
    i.e(paramIInAppMessage, "inAppMessage");
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramIInAppMessage)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Attempting to display in-app message with payload: ");
        localStringBuilder.append(JsonUtils.getPrettyPrintedString((JSONObject)forJsonPut()));
        return localStringBuilder.toString();
      }
    }, 2, null);
    if (!displayingInAppMessage.compareAndSet(false, true))
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, displayInAppMessage.2.INSTANCE, 3, null);
      inAppMessageStack.push(paramIInAppMessage);
      return;
    }
    Object localObject1;
    try
    {
      Activity localActivity = mActivity;
      if (localActivity != null)
      {
        if (!paramBoolean)
        {
          long l1 = paramIInAppMessage.getExpirationTimestamp();
          if (l1 > 0L)
          {
            long l2 = System.currentTimeMillis();
            if (l2 > l1)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("In-app message is expired. Doing nothing. Expiration: ");
              ((StringBuilder)localObject1).append(l1);
              ((StringBuilder)localObject1).append(". Current time: ");
              ((StringBuilder)localObject1).append(l2);
              throw new Exception(((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, displayInAppMessage.3.INSTANCE, 3, null);
          }
        }
        else
        {
          BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, displayInAppMessage.4.INSTANCE, 3, null);
        }
        paramBoolean = verifyOrientationStatus(paramIInAppMessage);
        if (paramBoolean)
        {
          paramBoolean = paramIInAppMessage.isControl();
          if (paramBoolean)
          {
            BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, displayInAppMessage.5.INSTANCE, 3, null);
            paramIInAppMessage.logImpression();
            resetAfterInAppMessageClose();
            return;
          }
          paramBoolean = BrazeActionUtils.containsInvalidBrazeAction(paramIInAppMessage);
          Object localObject2;
          if (paramBoolean)
          {
            localObject1 = (InAppMessageEvent)inAppMessageEventMap.get(paramIInAppMessage);
            localObject2 = BrazeLogger.Priority.g;
            BrazeLogger.brazelog$default(localBrazeLogger, this, (BrazeLogger.Priority)localObject2, null, displayInAppMessage.6.INSTANCE, 2, null);
            if (localObject1 != null)
            {
              BrazeLogger.brazelog$default(localBrazeLogger, this, (BrazeLogger.Priority)localObject2, null, displayInAppMessage.7.INSTANCE, 2, null);
              localObject2 = localActivity.getApplicationContext();
              i.d(localObject2, "activity.applicationContext");
              BrazeInternal.retryInAppMessage((Context)localObject2, (InAppMessageEvent)localObject1);
            }
            resetAfterInAppMessageClose();
            return;
          }
          paramBoolean = BrazeActionUtils.containsAnyPushPermissionBrazeActions(paramIInAppMessage);
          if (paramBoolean)
          {
            paramBoolean = PermissionUtils.wouldPushPermissionPromptDisplay(localActivity);
            if (!paramBoolean)
            {
              localObject1 = (InAppMessageEvent)inAppMessageEventMap.get(paramIInAppMessage);
              localObject2 = BrazeLogger.Priority.g;
              BrazeLogger.brazelog$default(localBrazeLogger, this, (BrazeLogger.Priority)localObject2, null, displayInAppMessage.8.INSTANCE, 2, null);
              if (localObject1 != null)
              {
                BrazeLogger.brazelog$default(localBrazeLogger, this, (BrazeLogger.Priority)localObject2, null, displayInAppMessage.9.INSTANCE, 2, null);
                localObject2 = localActivity.getApplicationContext();
                i.d(localObject2, "activity.applicationContext");
                BrazeInternal.retryInAppMessage((Context)localObject2, (InAppMessageEvent)localObject1);
              }
              resetAfterInAppMessageClose();
              return;
            }
          }
          localObject1 = getInAppMessageViewFactory(paramIInAppMessage);
          if (localObject1 != null)
          {
            View localView = ((IInAppMessageViewFactory)localObject1).createInAppMessageView(localActivity, paramIInAppMessage);
            if (localView != null)
            {
              localObject1 = localView.getParent();
              if (localObject1 == null)
              {
                localObject1 = configurationProvider;
                if (localObject1 != null)
                {
                  localObject2 = getInAppMessageAnimationFactory().getOpeningAnimation(paramIInAppMessage);
                  Object localObject3 = getInAppMessageAnimationFactory().getClosingAnimation(paramIInAppMessage);
                  IInAppMessageViewWrapperFactory localIInAppMessageViewWrapperFactory = getInAppMessageViewWrapperFactory();
                  paramBoolean = localView instanceof IInAppMessageImmersiveView;
                  Object localObject6;
                  Object localObject4;
                  Object localObject5;
                  List localList;
                  if (paramBoolean)
                  {
                    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, displayInAppMessage.10.INSTANCE, 3, null);
                    localObject6 = (IInAppMessageImmersiveView)localView;
                    int i = ((InAppMessageImmersiveBase)paramIInAppMessage).getMessageButtons().size();
                    localObject4 = inAppMessageViewLifecycleListener;
                    localObject5 = ((IInAppMessageView)localObject6).getMessageClickableView();
                    localList = ((IInAppMessageImmersiveView)localObject6).getMessageButtonViews(i);
                    localObject6 = ((IInAppMessageImmersiveView)localObject6).getMessageCloseButtonView();
                  }
                  try
                  {
                    localObject2 = localIInAppMessageViewWrapperFactory.createInAppMessageViewWrapper(localView, paramIInAppMessage, (IInAppMessageViewLifecycleListener)localObject4, (BrazeConfigurationProvider)localObject1, (Animation)localObject2, (Animation)localObject3, (View)localObject5, localList, (View)localObject6);
                    break label739;
                    paramBoolean = localView instanceof IInAppMessageView;
                    if (paramBoolean)
                    {
                      localObject4 = displayInAppMessage.11.INSTANCE;
                      BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, (a)localObject4, 3, null);
                      localObject5 = (IInAppMessageView)localView;
                      localObject4 = inAppMessageViewLifecycleListener;
                      localObject5 = ((IInAppMessageView)localObject5).getMessageClickableView();
                      localObject2 = localIInAppMessageViewWrapperFactory.createInAppMessageViewWrapper(localView, paramIInAppMessage, (IInAppMessageViewLifecycleListener)localObject4, (BrazeConfigurationProvider)localObject1, (Animation)localObject2, (Animation)localObject3, (View)localObject5);
                    }
                    else
                    {
                      localObject4 = displayInAppMessage.12.INSTANCE;
                      BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, (a)localObject4, 3, null);
                      localObject4 = inAppMessageViewLifecycleListener;
                      localObject2 = localIInAppMessageViewWrapperFactory.createInAppMessageViewWrapper(localView, paramIInAppMessage, (IInAppMessageViewLifecycleListener)localObject4, (BrazeConfigurationProvider)localObject1, (Animation)localObject2, (Animation)localObject3, localView);
                    }
                    label739:
                    localObject1 = paramIInAppMessage;
                    inAppMessageViewWrapper = ((IInAppMessageViewWrapper)localObject2);
                    paramBoolean = localView instanceof InAppMessageHtmlBaseView;
                    if (paramBoolean)
                    {
                      localObject3 = displayInAppMessage.13.INSTANCE;
                      paramIInAppMessage = (IInAppMessage)localObject1;
                      localObject1 = paramIInAppMessage;
                    }
                  }
                  catch (Throwable localThrowable1)
                  {
                    localObject1 = paramIInAppMessage;
                    paramIInAppMessage = localThrowable1;
                  }
                }
              }
            }
          }
        }
      }
      try
      {
        BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, (a)localObject3, 3, null);
        localObject1 = paramIInAppMessage;
        ((InAppMessageHtmlBaseView)localView).setHtmlPageFinishedListener(new LogActivity.1((IInAppMessageViewWrapper)localObject2, this, localActivity));
        return;
      }
      catch (Throwable paramIInAppMessage) {}
      if (localObject2 == null) {
        return;
      }
      ((IInAppMessageViewWrapper)localObject2).open(localActivity);
      return;
      localObject1 = paramIInAppMessage;
      throw new Exception("configurationProvider is null. The in-app message will not be displayed and will not beput back on the stack.");
      IInAppMessage localIInAppMessage = paramIInAppMessage;
      localObject1 = localIInAppMessage;
      paramIInAppMessage.logDisplayFailure(InAppMessageFailureType.DISPLAY_VIEW_GENERATION);
      localObject1 = localIInAppMessage;
      throw new Exception("The in-app message view returned from the IInAppMessageViewFactory already has a parent. This is a sign that the view is being reused. The IInAppMessageViewFactory method createInAppMessageViewmust return a new view without a parent. The in-app message will not be displayed and will not be put back on the stack.");
      localIInAppMessage = paramIInAppMessage;
      localObject1 = localIInAppMessage;
      paramIInAppMessage.logDisplayFailure(InAppMessageFailureType.DISPLAY_VIEW_GENERATION);
      localObject1 = localIInAppMessage;
      throw new Exception("The in-app message view returned from the IInAppMessageViewFactory was null. The in-app message will not be displayed and will not be put back on the stack.");
      localIInAppMessage = paramIInAppMessage;
      localObject1 = localIInAppMessage;
      paramIInAppMessage.logDisplayFailure(InAppMessageFailureType.DISPLAY_VIEW_GENERATION);
      localObject1 = localIInAppMessage;
      throw new Exception("ViewFactory from getInAppMessageViewFactory was null.");
      localObject1 = paramIInAppMessage;
      throw new Exception("Current orientation did not match specified orientation for in-app message. Doing nothing.");
      localIInAppMessage = paramIInAppMessage;
      localObject1 = localIInAppMessage;
      carryoverInAppMessage = paramIInAppMessage;
      localObject1 = localIInAppMessage;
      throw new Exception("No Activity is currently registered to receive in-app messages. Registering in-app message as carry-over in-app message. It will automatically be displayed when the next Activity registers to receive in-app messages.");
    }
    catch (Throwable localThrowable2)
    {
      localObject1 = paramIInAppMessage;
      paramIInAppMessage = localThrowable2;
    }
    BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramIInAppMessage, new j((IInAppMessage)localObject1)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not display in-app message with payload: ");
        localStringBuilder.append(JsonUtils.getPrettyPrintedString((JSONObject)forJsonPut()));
        return localStringBuilder.toString();
      }
    });
    resetAfterInAppMessageClose();
  }
  
  public void ensureSubscribedToInAppMessageEvents(Context paramContext)
  {
    i.e(paramContext, "context");
    if (inAppMessageEventSubscriber != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, ensureSubscribedToInAppMessageEvents.1.INSTANCE, 3, null);
      Braze.Companion.getInstance(paramContext).removeSingleSubscription(inAppMessageEventSubscriber, InAppMessageEvent.class);
    }
    Object localObject = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default((BrazeLogger)localObject, this, null, null, ensureSubscribedToInAppMessageEvents.2.INSTANCE, 3, null);
    IEventSubscriber localIEventSubscriber = createInAppMessageEventSubscriber();
    Braze.Companion localCompanion = Braze.Companion;
    localCompanion.getInstance(paramContext).subscribeToNewInAppMessages(localIEventSubscriber);
    inAppMessageEventSubscriber = localIEventSubscriber;
    if (sdkDataWipeEventSubscriber != null)
    {
      BrazeLogger.brazelog$default((BrazeLogger)localObject, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, ensureSubscribedToInAppMessageEvents.4.INSTANCE, 2, null);
      localCompanion.getInstance(paramContext).removeSingleSubscription(sdkDataWipeEventSubscriber, SdkDataWipeEvent.class);
    }
    BrazeLogger.brazelog$default((BrazeLogger)localObject, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, ensureSubscribedToInAppMessageEvents.5.INSTANCE, 2, null);
    localObject = new News(this);
    localCompanion.getInstance(paramContext).addSingleSynchronousSubscription((IEventSubscriber)localObject, SdkDataWipeEvent.class);
    sdkDataWipeEventSubscriber = ((IEventSubscriber)localObject);
  }
  
  public final Stack getInAppMessageStack()
  {
    return inAppMessageStack;
  }
  
  public void hideCurrentlyDisplayingInAppMessage(boolean paramBoolean)
  {
    setShouldNextUnregisterBeSkipped(false);
    IInAppMessageViewWrapper localIInAppMessageViewWrapper = inAppMessageViewWrapper;
    if (localIInAppMessageViewWrapper != null)
    {
      if (paramBoolean) {
        inAppMessageViewLifecycleListener.onDismissed(localIInAppMessageViewWrapper.getInAppMessageView(), localIInAppMessageViewWrapper.getInAppMessage());
      }
      localIInAppMessageViewWrapper.close();
    }
  }
  
  public void registerInAppMessageManager(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, registerInAppMessageManager.1.INSTANCE, 2, null);
      return;
    }
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramActivity)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Registering InAppMessageManager with activity: ");
        localStringBuilder.append(getLocalClassName());
        return localStringBuilder.toString();
      }
    }, 2, null);
    mActivity = paramActivity;
    if (mApplicationContext == null)
    {
      paramActivity = paramActivity.getApplicationContext();
      mApplicationContext = paramActivity;
      if (paramActivity == null)
      {
        BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.PREPARED, null, registerInAppMessageManager.3.INSTANCE, 2, null);
        return;
      }
    }
    if (configurationProvider == null)
    {
      paramActivity = mApplicationContext;
      if (paramActivity != null) {
        paramActivity = new BrazeConfigurationProvider(paramActivity);
      } else {
        paramActivity = null;
      }
      configurationProvider = paramActivity;
    }
    paramActivity = carryoverInAppMessage;
    if (paramActivity != null)
    {
      if (paramActivity != null)
      {
        BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, registerInAppMessageManager.5.1.INSTANCE, 3, null);
        paramActivity.setAnimateIn(false);
        displayInAppMessage(paramActivity, true);
      }
      carryoverInAppMessage = null;
    }
    else
    {
      paramActivity = unregisteredInAppMessage;
      if (paramActivity != null)
      {
        BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, registerInAppMessageManager.6.1.INSTANCE, 3, null);
        addInAppMessage(paramActivity);
        unregisteredInAppMessage = null;
      }
    }
    paramActivity = mApplicationContext;
    if (paramActivity != null) {
      ensureSubscribedToInAppMessageEvents(paramActivity);
    }
  }
  
  public boolean requestDisplayInAppMessage()
  {
    if (mActivity == null) {
      localObject1 = inAppMessageStack;
    }
    try
    {
      bool = ((Stack)localObject1).empty();
      if (!bool)
      {
        localObject1 = BrazeLogger.INSTANCE;
        localObject2 = BrazeLogger.Priority.PREPARED;
        localObject3 = requestDisplayInAppMessage.1.INSTANCE;
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, (a)localObject3, 2, null);
        localObject1 = inAppMessageStack;
        localObject1 = ((Stack)localObject1).pop();
        unregisteredInAppMessage = ((IInAppMessage)localObject1);
        return false;
      }
      localObject1 = BrazeLogger.INSTANCE;
      localObject2 = requestDisplayInAppMessage.2.INSTANCE;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, null, null, (a)localObject2, 3, null);
      return false;
    }
    catch (Exception localException)
    {
      boolean bool;
      Object localObject2;
      Object localObject3;
      int i;
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localException, requestDisplayInAppMessage.8.INSTANCE);
    }
    Object localObject1 = displayingInAppMessage;
    bool = ((AtomicBoolean)localObject1).get();
    if (bool)
    {
      localObject1 = BrazeLogger.INSTANCE;
      localObject2 = requestDisplayInAppMessage.3.INSTANCE;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, null, null, (a)localObject2, 3, null);
      return false;
    }
    localObject1 = inAppMessageStack;
    bool = ((Stack)localObject1).isEmpty();
    if (bool)
    {
      localObject1 = BrazeLogger.INSTANCE;
      localObject2 = requestDisplayInAppMessage.4.INSTANCE;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, null, null, (a)localObject2, 3, null);
      return false;
    }
    localObject1 = inAppMessageStack;
    localObject1 = ((Stack)localObject1).pop();
    localObject2 = (IInAppMessage)localObject1;
    bool = ((IInAppMessage)localObject2).isControl();
    if (!bool)
    {
      localObject1 = getInAppMessageManagerListener();
      i.d(localObject2, "inAppMessage");
      localObject1 = ((IInAppMessageManagerListener)localObject1).beforeInAppMessageDisplayed((IInAppMessage)localObject2);
    }
    else
    {
      localObject1 = BrazeLogger.INSTANCE;
      localObject3 = requestDisplayInAppMessage.inAppMessageOperation.1.INSTANCE;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, null, null, (a)localObject3, 3, null);
      localObject1 = getControlInAppMessageManagerListener();
      i.d(localObject2, "inAppMessage");
      localObject1 = ((IInAppMessageManagerListener)localObject1).beforeInAppMessageDisplayed((IInAppMessage)localObject2);
    }
    localObject3 = WhenMappings.$EnumSwitchMapping$0;
    i = ((Enum)localObject1).ordinal();
    i = localObject3[i];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject1 = BrazeLogger.INSTANCE;
          localObject2 = requestDisplayInAppMessage.7.INSTANCE;
          BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, null, null, (a)localObject2, 3, null);
          return false;
        }
      }
      else
      {
        localObject1 = BrazeLogger.INSTANCE;
        localObject3 = requestDisplayInAppMessage.6.INSTANCE;
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, null, null, (a)localObject3, 3, null);
        localObject1 = inAppMessageStack;
        ((Stack)localObject1).push(localObject2);
        return false;
      }
    }
    else
    {
      localObject1 = BrazeLogger.INSTANCE;
      localObject3 = requestDisplayInAppMessage.5.INSTANCE;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, null, null, (a)localObject3, 3, null);
    }
    BackgroundInAppMessagePreparer.prepareInAppMessageForDisplay((IInAppMessage)localObject2);
    return true;
    return false;
  }
  
  public void resetAfterInAppMessageClose()
  {
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, resetAfterInAppMessageClose.1.INSTANCE, 2, null);
    inAppMessageViewWrapper = null;
    Activity localActivity = mActivity;
    Integer localInteger = originalOrientation;
    displayingInAppMessage.set(false);
    if ((localActivity != null) && (localInteger != null))
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, new j(localInteger)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Setting requested orientation to original orientation ");
          localStringBuilder.append(BrazeInAppMessageManager.this);
          return localStringBuilder.toString();
        }
      }, 3, null);
      ViewUtils.setActivityRequestedOrientation(localActivity, localInteger.intValue());
      originalOrientation = null;
    }
  }
  
  public void unregisterInAppMessageManager(Activity paramActivity)
  {
    if (getShouldNextUnregisterBeSkipped())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new j(paramActivity)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Skipping unregistration due to setShouldNextUnregisterBeSkipped being true. Activity: ");
          Object localObject = BrazeInAppMessageManager.this;
          if (localObject != null) {
            localObject = ((Activity)localObject).getLocalClassName();
          } else {
            localObject = null;
          }
          localStringBuilder.append((String)localObject);
          return localStringBuilder.toString();
        }
      }, 3, null);
      setShouldNextUnregisterBeSkipped(false);
      return;
    }
    if (paramActivity == null) {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, unregisterInAppMessageManager.2.INSTANCE, 2, null);
    } else {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramActivity)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unregistering InAppMessageManager from activity: ");
          localStringBuilder.append(getLocalClassName());
          return localStringBuilder.toString();
        }
      }, 2, null);
    }
    paramActivity = inAppMessageViewWrapper;
    if (paramActivity != null)
    {
      View localView = paramActivity.getInAppMessageView();
      if ((localView instanceof InAppMessageHtmlBaseView))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, unregisterInAppMessageManager.4.INSTANCE, 3, null);
        ((InAppMessageHtmlBaseView)localView).setHtmlPageFinishedListener(null);
      }
      ViewUtils.removeViewFromParent(localView);
      if (paramActivity.isAnimatingClose())
      {
        inAppMessageViewLifecycleListener.afterClosed(paramActivity.getInAppMessage());
        paramActivity = null;
      }
      else
      {
        paramActivity = paramActivity.getInAppMessage();
      }
      carryoverInAppMessage = paramActivity;
      inAppMessageViewWrapper = null;
    }
    else
    {
      carryoverInAppMessage = null;
    }
    mActivity = null;
    displayingInAppMessage.set(false);
  }
  
  public boolean verifyOrientationStatus(IInAppMessage paramIInAppMessage)
  {
    i.e(paramIInAppMessage, "inAppMessage");
    Activity localActivity = mActivity;
    paramIInAppMessage = paramIInAppMessage.getOrientation();
    if (localActivity == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, verifyOrientationStatus.1.INSTANCE, 2, null);
      return true;
    }
    if (ViewUtils.isRunningOnTablet(localActivity))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, verifyOrientationStatus.2.INSTANCE, 3, null);
      return true;
    }
    if (paramIInAppMessage == Orientation.VERTICAL)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, verifyOrientationStatus.3.INSTANCE, 3, null);
      return true;
    }
    if (ViewUtils.isCurrentOrientationValid(getResourcesgetConfigurationorientation, paramIInAppMessage))
    {
      if (originalOrientation == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, verifyOrientationStatus.4.INSTANCE, 3, null);
        originalOrientation = Integer.valueOf(localActivity.getRequestedOrientation());
        ViewUtils.setActivityRequestedOrientation(localActivity, 14);
        return true;
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    public final BrazeInAppMessageManager getInstance()
    {
      if (BrazeInAppMessageManager.access$getInstance$cp() != null)
      {
        localObject1 = BrazeInAppMessageManager.access$getInstance$cp();
        Objects.requireNonNull(localObject1, "null cannot be cast to non-null type com.braze.ui.inappmessage.BrazeInAppMessageManager");
        return localObject1;
      }
      Object localObject1 = BrazeInAppMessageManager.access$getInstanceLock$cp();
      ((Lock)localObject1).lock();
      try
      {
        Object localObject2 = BrazeInAppMessageManager.access$getInstance$cp();
        if (localObject2 == null)
        {
          localObject2 = BrazeInAppMessageManager.Companion;
          BrazeInAppMessageManager.access$setInstance$cp(new BrazeInAppMessageManager());
        }
        localObject2 = t.a;
        ((Lock)localObject1).unlock();
        localObject1 = BrazeInAppMessageManager.access$getInstance$cp();
        Objects.requireNonNull(localObject1, "null cannot be cast to non-null type com.braze.ui.inappmessage.BrazeInAppMessageManager");
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        ((Lock)localObject1).unlock();
        throw localThrowable;
      }
    }
  }
}
