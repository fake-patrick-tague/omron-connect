package com.braze.push;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import androidx.core.package_10.ClassWriter;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.BrazeInternal;
import com.braze.Constants;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.IBrazeNotificationFactory;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.Channel;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.models.push.BrazeNotificationPayload.PushStoryPage;
import com.braze.push.support.HtmlUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.IntentUtils;
import com.braze.support.JsonUtils;
import com.braze.support.PermissionUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler.Companion;
import com.braze.ui.actions.UriAction;
import com.braze.ui.support.UriUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.k;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class BrazeNotificationUtils
{
  public static final BrazeNotificationUtils INSTANCE = new BrazeNotificationUtils();
  private static final String filter = BrazeLogger.getBrazeLogTag(BrazeNotificationUtils.class);
  
  private BrazeNotificationUtils() {}
  
  public static final void cancelNotification(Context paramContext, int paramInt)
  {
    i.e(paramContext, "context");
    Object localObject = BrazeLogger.INSTANCE;
    BrazeNotificationUtils localBrazeNotificationUtils = INSTANCE;
    try
    {
      BrazeLogger.brazelog$default((BrazeLogger)localObject, localBrazeNotificationUtils, null, null, new j(paramInt)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cancelling notification action with id: ");
          localStringBuilder.append($notificationId);
          return localStringBuilder.toString();
        }
      }, 3, null);
      localObject = new Intent("com.braze.action.CANCEL_NOTIFICATION").setClass(paramContext, getNotificationReceiverClass());
      i.d(localObject, "Intent(Constants.BRAZE_C?otificationReceiverClass)");
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      ((Intent)localObject).putExtra("nid", paramInt);
      IntentUtils.addComponentAndSendBroadcast(paramContext, (Intent)localObject);
      return;
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, paramContext, cancelNotification.2.INSTANCE);
    }
  }
  
  public static final IBrazeNotificationFactory getActiveNotificationFactory()
  {
    IBrazeNotificationFactory localIBrazeNotificationFactory = Braze.Companion.getCustomBrazeNotificationFactory();
    if (localIBrazeNotificationFactory == null) {
      return BrazeNotificationFactory.Companion.getInstance();
    }
    return localIBrazeNotificationFactory;
  }
  
  public static final int getNotificationId(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramBrazeNotificationPayload, "payload");
    Object localObject = paramBrazeNotificationPayload.getCustomNotificationId();
    if (localObject != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, new j((Integer)localObject)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Using notification id provided in the message's extras bundle: ");
          localStringBuilder.append(BrazeNotificationUtils.this);
          return localStringBuilder.toString();
        }
      }, 3, null);
      return ((Integer)localObject).intValue();
    }
    localObject = "";
    String str = paramBrazeNotificationPayload.getTitleText();
    if (str != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    str = paramBrazeNotificationPayload.getContentText();
    paramBrazeNotificationPayload = (BrazeNotificationPayload)localObject;
    if (str != null)
    {
      paramBrazeNotificationPayload = new StringBuilder();
      paramBrazeNotificationPayload.append((String)localObject);
      paramBrazeNotificationPayload.append(str);
      paramBrazeNotificationPayload = paramBrazeNotificationPayload.toString();
    }
    int i;
    if (paramBrazeNotificationPayload == null) {
      i = 0;
    } else {
      i = paramBrazeNotificationPayload.hashCode();
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, new j(i)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Message without notification id provided in the extras bundle received. Using a hash of the message: ");
        localStringBuilder.append($notificationId);
        return localStringBuilder.toString();
      }
    }, 3, null);
    return i;
  }
  
  public static final int getNotificationPriority(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramBrazeNotificationPayload, "payload");
    Integer localInteger = paramBrazeNotificationPayload.getNotificationPriorityInt();
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getNotificationPriorityInt();
    if (paramBrazeNotificationPayload != null)
    {
      int j = paramBrazeNotificationPayload.intValue();
      int i;
      if ((-2 <= j) && (j < 3)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return j;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, new j(localInteger)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Received invalid notification priority ");
          localStringBuilder.append(BrazeNotificationUtils.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
    }
    return 0;
  }
  
  public static final Class getNotificationReceiverClass()
  {
    if (Constants.isAmazonDevice()) {
      return BrazeAmazonDeviceMessagingReceiver.class;
    }
    return BrazePushReceiver.class;
  }
  
  public static final String getOrCreateNotificationChannelId(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramBrazeNotificationPayload, "payload");
    Object localObject3 = paramBrazeNotificationPayload.getNotificationChannelId();
    if (Build.VERSION.SDK_INT < 26)
    {
      if (localObject3 == null) {
        return "com_appboy_default_notification_channel";
      }
    }
    else
    {
      Object localObject2 = paramBrazeNotificationPayload.getContext();
      BrazeConfigurationProvider localBrazeConfigurationProvider = paramBrazeNotificationPayload.getConfigurationProvider();
      Object localObject1 = null;
      if (localObject2 != null) {
        paramBrazeNotificationPayload = ((Context)localObject2).getSystemService("notification");
      } else {
        paramBrazeNotificationPayload = null;
      }
      Objects.requireNonNull(paramBrazeNotificationPayload, "null cannot be cast to non-null type android.app.NotificationManager");
      localObject2 = (NotificationManager)paramBrazeNotificationPayload;
      if (localObject3 != null)
      {
        if (((NotificationManager)localObject2).getNotificationChannel((String)localObject3) != null)
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, new j((String)localObject3)
          {
            public final String invoke()
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Found notification channel in extras with id: ");
              localStringBuilder.append(BrazeNotificationUtils.this);
              return localStringBuilder.toString();
            }
          }, 3, null);
          return localObject3;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, new j((String)localObject3)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Notification channel from extras is invalid. No channel found with id: ");
            localStringBuilder.append(BrazeNotificationUtils.this);
            return localStringBuilder.toString();
          }
        }, 3, null);
      }
      if (((NotificationManager)localObject2).getNotificationChannel("com_appboy_default_notification_channel") != null) {
        break label217;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, getOrCreateNotificationChannelId.3.INSTANCE, 3, null);
      if (localBrazeConfigurationProvider != null) {
        paramBrazeNotificationPayload = localBrazeConfigurationProvider.getDefaultNotificationChannelName();
      } else {
        paramBrazeNotificationPayload = null;
      }
      localObject3 = new NotificationChannel("com_appboy_default_notification_channel", paramBrazeNotificationPayload, 3);
      paramBrazeNotificationPayload = localObject1;
      if (localBrazeConfigurationProvider != null) {
        paramBrazeNotificationPayload = localBrazeConfigurationProvider.getDefaultNotificationChannelDescription();
      }
      ((NotificationChannel)localObject3).setDescription(paramBrazeNotificationPayload);
      ((NotificationManager)localObject2).createNotificationChannel((NotificationChannel)localObject3);
      return "com_appboy_default_notification_channel";
    }
    return localObject3;
    label217:
    return "com_appboy_default_notification_channel";
  }
  
  private final PendingIntent getPushActionPendingIntent(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramString = new Intent(paramString).setClass(paramContext, NotificationTrampolineActivity.class);
    i.d(paramString, "Intent(action).setClass(?lineActivity::class.java)");
    if (paramBundle != null) {
      paramString.putExtras(paramBundle);
    }
    int i = IntentUtils.getImmutablePendingIntentFlags();
    paramContext = PendingIntent.getActivity(paramContext, IntentUtils.getRequestCode(), paramString, 0x40000000 | i);
    i.d(paramContext, "getActivity(context, get? pushActionIntent, flags)");
    return paramContext;
  }
  
  public static final NotificationChannel getValidNotificationChannel(NotificationManager paramNotificationManager, Bundle paramBundle)
  {
    i.e(paramNotificationManager, "notificationManager");
    if (paramBundle == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, getValidNotificationChannel.1.INSTANCE, 3, null);
      return null;
    }
    paramBundle = paramBundle.getString("ab_nc", null);
    int i;
    if ((paramBundle != null) && (!g.o(paramBundle))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      NotificationChannel localNotificationChannel = paramNotificationManager.getNotificationChannel(paramBundle);
      if (localNotificationChannel != null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, new j(paramBundle)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Found notification channel in extras with id: ");
            localStringBuilder.append(BrazeNotificationUtils.this);
            return localStringBuilder.toString();
          }
        }, 3, null);
        return localNotificationChannel;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, new j(paramBundle)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Notification channel from extras is invalid, no channel found with id: ");
          localStringBuilder.append(BrazeNotificationUtils.this);
          return localStringBuilder.toString();
        }
      }, 3, null);
    }
    paramNotificationManager = paramNotificationManager.getNotificationChannel("com_appboy_default_notification_channel");
    if (paramNotificationManager != null) {
      return paramNotificationManager;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, getValidNotificationChannel.4.INSTANCE, 3, null);
    return null;
  }
  
  public static final void handleCancelNotificationAction(Context paramContext, Intent paramIntent)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "intent");
    try
    {
      boolean bool = paramIntent.hasExtra("nid");
      if (bool)
      {
        int i = paramIntent.getIntExtra("nid", -1);
        paramIntent = BrazeLogger.INSTANCE;
        BrazeNotificationUtils localBrazeNotificationUtils = INSTANCE;
        BrazeLogger.brazelog$default(paramIntent, localBrazeNotificationUtils, null, null, new j(i)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Cancelling notification action with id: ");
            localStringBuilder.append($notificationId);
            return localStringBuilder.toString();
          }
        }, 3, null);
        paramContext = paramContext.getSystemService("notification");
        if (paramContext != null)
        {
          paramContext = (NotificationManager)paramContext;
          paramContext.cancel("appboy_notification", i);
          return;
        }
        paramContext = new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, paramContext, handleCancelNotificationAction.2.INSTANCE);
    }
  }
  
  public static final void handleContentCardsSerializedCardIfPresent(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramBrazeNotificationPayload, "payload");
    final String str1 = paramBrazeNotificationPayload.getContentCardSyncData();
    String str2 = paramBrazeNotificationPayload.getContentCardSyncUserId();
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getContext();
    if ((str1 != null) && (paramBrazeNotificationPayload != null))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, new j(str2)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Push contains associated Content Cards card. User id: ");
          localStringBuilder.append(BrazeNotificationUtils.this);
          localStringBuilder.append(" Card data: ");
          localStringBuilder.append(str1);
          return localStringBuilder.toString();
        }
      }, 3, null);
      BrazeInternal.addSerializedContentCardToStorage(paramBrazeNotificationPayload, str1, str2);
    }
  }
  
  public static final void handleNotificationDeleted(Context paramContext, Intent paramIntent)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "intent");
    Object localObject1 = BrazeLogger.INSTANCE;
    BrazeNotificationUtils localBrazeNotificationUtils = INSTANCE;
    Object localObject2 = handleNotificationDeleted.1.INSTANCE;
    try
    {
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, localBrazeNotificationUtils, null, null, (a)localObject2, 3, null);
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        localObject1 = new BrazeNotificationPayload(paramIntent, null, paramContext, null, 10, null);
        localObject2 = BrazeNotificationBroadcastType.DELETED;
        localBrazeNotificationUtils.sendPushActionIntent(paramContext, (BrazeNotificationBroadcastType)localObject2, paramIntent, (BrazeNotificationPayload)localObject1);
        return;
      }
      localObject1 = BrazeNotificationBroadcastType.DELETED;
      sendPushActionIntent$default(localBrazeNotificationUtils, paramContext, (BrazeNotificationBroadcastType)localObject1, paramIntent, null, 8, null);
      return;
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, paramContext, handleNotificationDeleted.2.INSTANCE);
    }
  }
  
  public static final void handleNotificationOpened(Context paramContext, Intent paramIntent)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "intent");
    Object localObject = Braze.Companion;
    try
    {
      ((Braze.Companion)localObject).getInstance(paramContext).logPushNotificationOpened(paramIntent);
      localObject = INSTANCE;
      sendNotificationOpenedBroadcast(paramContext, paramIntent);
      boolean bool = new BrazeConfigurationProvider(paramContext).getDoesHandlePushDeepLinksAutomatically();
      if (bool)
      {
        routeUserWithNotificationOpenedIntent(paramContext, paramIntent);
        return;
      }
      paramContext = BrazeLogger.INSTANCE;
      paramIntent = BrazeLogger.Priority.g;
      j local1 = handleNotificationOpened.1.INSTANCE;
      BrazeLogger.brazelog$default(paramContext, localObject, paramIntent, null, local1, 2, null);
      return;
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, paramContext, handleNotificationOpened.2.INSTANCE);
    }
  }
  
  public static final void handlePushStoryPageClicked(Context paramContext, Intent paramIntent)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "intent");
    Object localObject1 = Braze.Companion;
    try
    {
      ((Braze.Companion)localObject1).getInstance(paramContext).logPushStoryPageClicked(paramIntent.getStringExtra("braze_campaign_id"), paramIntent.getStringExtra("braze_story_page_id"));
      BrazeConfigurationProvider localBrazeConfigurationProvider = new BrazeConfigurationProvider(paramContext);
      int j = 0;
      int i = paramIntent.getIntExtra("nid", 0);
      boolean bool = localBrazeConfigurationProvider.getDoesPushStoryDismissOnClick();
      if ((bool) && (i != 0)) {
        cancelNotification(paramContext, i);
      }
      localObject1 = paramIntent.getStringExtra("braze_action_uri");
      if (localObject1 != null)
      {
        bool = g.o((CharSequence)localObject1);
        if (!bool)
        {
          i = 0;
          break label118;
        }
      }
      i = 1;
      label118:
      if (i == 0)
      {
        paramIntent.putExtra("uri", paramIntent.getStringExtra("braze_action_uri"));
        localObject2 = paramIntent.getStringExtra("braze_action_use_webview");
        if (localObject2 != null)
        {
          bool = g.o((CharSequence)localObject2);
          i = j;
          if (!bool) {}
        }
        else
        {
          i = 1;
        }
        if (i == 0) {
          paramIntent.putExtra("ab_use_webview", (String)localObject2);
        }
      }
      else
      {
        paramIntent.removeExtra("uri");
      }
      Object localObject2 = INSTANCE;
      sendNotificationOpenedBroadcast(paramContext, paramIntent);
      bool = localBrazeConfigurationProvider.getDoesHandlePushDeepLinksAutomatically();
      if (bool)
      {
        routeUserWithNotificationOpenedIntent(paramContext, paramIntent);
        return;
      }
      paramContext = BrazeLogger.INSTANCE;
      paramIntent = BrazeLogger.Priority.g;
      BrazeLogger.brazelog$default(paramContext, localObject2, paramIntent, null, new j((String)localObject1)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Not handling deep links automatically, skipping deep link handling for '");
          localStringBuilder.append(BrazeNotificationUtils.this);
          localStringBuilder.append('\'');
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, paramContext, handlePushStoryPageClicked.2.INSTANCE);
    }
  }
  
  public static final boolean isBrazePushMessage(Intent paramIntent)
  {
    i.e(paramIntent, "<this>");
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return false;
    }
    return g.n("true", paramIntent.getString("_ab"), true);
  }
  
  public static final boolean isNotificationMessage(Intent paramIntent)
  {
    i.e(paramIntent, "intent");
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return false;
    }
    return (paramIntent.containsKey("t")) && (paramIntent.containsKey("a"));
  }
  
  public static final boolean isValidNotificationVisibility(int paramInt)
  {
    if ((paramInt != -1) && (paramInt != 0)) {
      return paramInt == 1;
    }
    return true;
  }
  
  public static final void prefetchBitmapsIfNewlyReceivedStoryPush(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramBrazeNotificationPayload, "payload");
    Context localContext = paramBrazeNotificationPayload.getContext();
    if (localContext == null) {
      return;
    }
    if (paramBrazeNotificationPayload.isPushStory())
    {
      if (!paramBrazeNotificationPayload.isNewlyReceivedPushStory()) {
        return;
      }
      Object localObject2 = paramBrazeNotificationPayload.getPushStoryPages();
      Object localObject1 = new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((BrazeNotificationPayload.PushStoryPage)((Iterator)localObject2).next()).getBitmapUrl();
        if (str != null) {
          ((Collection)localObject1).add(str);
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j((String)localObject2)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Pre-fetching bitmap at URL: ");
            localStringBuilder.append(BrazeNotificationUtils.this);
            return localStringBuilder.toString();
          }
        }, 2, null);
        Braze.Companion.getInstance(localContext).getImageLoader().getPushBitmapFromUrl(localContext, paramBrazeNotificationPayload.getBrazeExtras(), (String)localObject2, BrazeViewBounds.NOTIFICATION_ONE_IMAGE_STORY);
      }
      paramBrazeNotificationPayload.setNewlyReceivedPushStory(false);
    }
  }
  
  public static final boolean refreshFeatureFlagsIfAppropriate(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramBrazeNotificationPayload, "payload");
    Context localContext = paramBrazeNotificationPayload.getContext();
    if ((paramBrazeNotificationPayload.getShouldRefreshFeatureFlags()) && (localContext != null))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, refreshFeatureFlagsIfAppropriate.1.INSTANCE, 3, null);
      BrazeInternal.refreshFeatureFlags(localContext);
      return true;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.$EnumSwitchMapping$0, null, refreshFeatureFlagsIfAppropriate.2.INSTANCE, 2, null);
    return false;
  }
  
  public static final boolean requestGeofenceRefreshIfAppropriate(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramBrazeNotificationPayload, "payload");
    Context localContext = paramBrazeNotificationPayload.getContext();
    if ((paramBrazeNotificationPayload.getShouldSyncGeofences()) && (localContext != null))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, requestGeofenceRefreshIfAppropriate.1.INSTANCE, 3, null);
      BrazeInternal.requestGeofenceRefresh(localContext, true);
      return true;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, requestGeofenceRefreshIfAppropriate.2.INSTANCE, 3, null);
    return false;
  }
  
  public static final void routeUserWithNotificationOpenedIntent(Context paramContext, Intent paramIntent)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "intent");
    Object localObject2 = paramIntent.getBundleExtra("extra");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    ((BaseBundle)localObject1).putString("cid", paramIntent.getStringExtra("cid"));
    localObject2 = INSTANCE;
    ((BaseBundle)localObject1).putString("source", "Appboy");
    String str = paramIntent.getStringExtra("uri");
    int i;
    if ((str != null) && (!g.o(str))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      final boolean bool = g.n("true", paramIntent.getStringExtra("ab_use_webview"), true);
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, localObject2, null, null, new j(str)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Found a deep link: ");
          localStringBuilder.append(BrazeNotificationUtils.this);
          localStringBuilder.append(". Use webview set to: ");
          localStringBuilder.append(bool);
          return localStringBuilder.toString();
        }
      }, 3, null);
      ((BaseBundle)localObject1).putString("uri", str);
      ((BaseBundle)localObject1).putBoolean("ab_use_webview", bool);
      paramIntent = BrazeDeeplinkHandler.Companion;
      localObject1 = paramIntent.getInstance().createUriActionFromUrlString(str, (Bundle)localObject1, bool, Channel.PUSH);
      if (localObject1 != null) {
        paramIntent.getInstance().gotoUri(paramContext, (UriAction)localObject1);
      }
    }
    else
    {
      paramIntent = UriUtils.getMainActivityIntent(paramContext, (Bundle)localObject1);
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, localObject2, null, null, new j(paramIntent)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Push notification had no deep link. Opening main activity: ");
          localStringBuilder.append(BrazeNotificationUtils.this);
          return localStringBuilder.toString();
        }
      }, 3, null);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public static final void sendNotificationOpenedBroadcast(Context paramContext, Intent paramIntent)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "intent");
    Object localObject = BrazeLogger.INSTANCE;
    BrazeNotificationUtils localBrazeNotificationUtils = INSTANCE;
    BrazeLogger.brazelog$default((BrazeLogger)localObject, localBrazeNotificationUtils, null, null, sendNotificationOpenedBroadcast.1.INSTANCE, 3, null);
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      localObject = new BrazeNotificationPayload(paramIntent, null, paramContext, null, 10, null);
      localBrazeNotificationUtils.sendPushActionIntent(paramContext, BrazeNotificationBroadcastType.OPENED, paramIntent, (BrazeNotificationPayload)localObject);
      return;
    }
    sendPushActionIntent$default(localBrazeNotificationUtils, paramContext, BrazeNotificationBroadcastType.OPENED, paramIntent, null, 8, null);
  }
  
  private final void sendPushActionIntent(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramIntent)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Sending push action intent: ");
        localStringBuilder.append(BrazeNotificationUtils.this);
        return localStringBuilder.toString();
      }
    }, 2, null);
    if (paramBundle != null) {
      paramIntent.putExtras(paramBundle);
    }
    IntentUtils.addComponentAndSendBroadcast(paramContext, paramIntent);
  }
  
  private final void sendPushActionIntent(Context paramContext, BrazeNotificationBroadcastType paramBrazeNotificationBroadcastType, Bundle paramBundle, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    int i = WhenMappings.$EnumSwitchMapping$0[paramBrazeNotificationBroadcastType.ordinal()];
    Intent localIntent2;
    Intent localIntent1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localIntent2 = new Intent("com.braze.push.intent.NOTIFICATION_DELETED").setPackage(paramContext.getPackageName());
          localIntent1 = localIntent2;
          i.d(localIntent2, "{\n                Intent?ackageName)\n            }");
        }
        else
        {
          throw ((Throwable)new k());
        }
      }
      else
      {
        localIntent2 = new Intent("com.braze.push.intent.NOTIFICATION_RECEIVED").setPackage(paramContext.getPackageName());
        localIntent1 = localIntent2;
        i.d(localIntent2, "{\n                Intent?ackageName)\n            }");
      }
    }
    else
    {
      localIntent2 = new Intent("com.braze.push.intent.NOTIFICATION_OPENED").setPackage(paramContext.getPackageName());
      localIntent1 = localIntent2;
      i.d(localIntent2, "{\n                Intent?ackageName)\n            }");
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramBrazeNotificationBroadcastType)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Sending Braze broadcast receiver intent for ");
        localStringBuilder.append(BrazeNotificationUtils.this);
        return localStringBuilder.toString();
      }
    }, 2, null);
    sendPushActionIntent(paramContext, localIntent1, paramBundle);
    if (paramBrazeNotificationPayload != null) {
      BrazeInternal.INSTANCE.publishBrazePushAction(paramContext, paramBrazeNotificationBroadcastType.getBrazePushEventType(), paramBrazeNotificationPayload);
    }
  }
  
  public static final void sendPushMessageReceivedBroadcast(Context paramContext, Bundle paramBundle, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramContext, "context");
    i.e(paramBundle, "notificationExtras");
    i.e(paramBrazeNotificationPayload, "payload");
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeNotificationUtils localBrazeNotificationUtils = INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, localBrazeNotificationUtils, null, null, sendPushMessageReceivedBroadcast.1.INSTANCE, 3, null);
    localBrazeNotificationUtils.sendPushActionIntent(paramContext, BrazeNotificationBroadcastType.RECEIVED, paramBundle, paramBrazeNotificationPayload);
  }
  
  public static final void setAccentColorIfPresentAndSupported(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    Integer localInteger = paramBrazeNotificationPayload.getAccentColor();
    if (localInteger != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setAccentColorIfPresentAndSupported.1.INSTANCE, 3, null);
      paramClassWriter.b(localInteger.intValue());
      return;
    }
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getConfigurationProvider();
    if (paramBrazeNotificationPayload != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setAccentColorIfPresentAndSupported.2.1.INSTANCE, 3, null);
      paramClassWriter.b(paramBrazeNotificationPayload.getDefaultNotificationAccentColor());
    }
  }
  
  public static final void setCategoryIfPresentAndSupported(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    if (Build.VERSION.SDK_INT < 21)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setCategoryIfPresentAndSupported.1.INSTANCE, 3, null);
      return;
    }
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getNotificationCategory();
    if (paramBrazeNotificationPayload != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setCategoryIfPresentAndSupported.2.INSTANCE, 3, null);
      paramClassWriter.b(paramBrazeNotificationPayload);
      return;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setCategoryIfPresentAndSupported.3.INSTANCE, 3, null);
  }
  
  public static final void setContentIfPresent(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setContentIfPresent.1.INSTANCE, 3, null);
    String str = paramBrazeNotificationPayload.getContentText();
    if (str == null) {
      return;
    }
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getConfigurationProvider();
    if (paramBrazeNotificationPayload == null) {
      return;
    }
    paramClassWriter.a(HtmlUtils.getHtmlSpannedTextIfEnabled(str, paramBrazeNotificationPayload));
  }
  
  public static final void setContentIntentIfPresent(Context paramContext, ClassWriter paramClassWriter, Bundle paramBundle)
  {
    i.e(paramContext, "context");
    i.e(paramClassWriter, "notificationBuilder");
    BrazeNotificationUtils localBrazeNotificationUtils = INSTANCE;
    try
    {
      paramClassWriter.b(localBrazeNotificationUtils.getPushActionPendingIntent(paramContext, "com.braze.action.BRAZE_PUSH_CLICKED", paramBundle));
      return;
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, paramContext, setContentIntentIfPresent.1.INSTANCE);
    }
  }
  
  public static final void setDeleteIntent(Context paramContext, ClassWriter paramClassWriter, Bundle paramBundle)
  {
    i.e(paramContext, "context");
    i.e(paramClassWriter, "notificationBuilder");
    try
    {
      Intent localIntent = new Intent("com.braze.action.BRAZE_PUSH_DELETED").setClass(paramContext, getNotificationReceiverClass());
      i.d(localIntent, "Intent(Constants.BRAZE_P?otificationReceiverClass)");
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      int i = IntentUtils.getImmutablePendingIntentFlags();
      paramClassWriter.put(PendingIntent.getBroadcast(paramContext, IntentUtils.getRequestCode(), localIntent, 0x40000000 | i));
      return;
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, paramContext, setDeleteIntent.1.INSTANCE);
    }
  }
  
  public static final boolean setLargeIconIfPresentAndSupported(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    if (paramBrazeNotificationPayload.isPushStory())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setLargeIconIfPresentAndSupported.1.INSTANCE, 3, null);
      return false;
    }
    Context localContext = paramBrazeNotificationPayload.getContext();
    if (localContext == null) {
      return false;
    }
    BrazeConfigurationProvider localBrazeConfigurationProvider = paramBrazeNotificationPayload.getConfigurationProvider();
    if (localBrazeConfigurationProvider == null) {
      return false;
    }
    Object localObject1 = BrazeLogger.INSTANCE;
    Object localObject2 = INSTANCE;
    j local2 = setLargeIconIfPresentAndSupported.2.INSTANCE;
    try
    {
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, localObject2, null, null, local2, 3, null);
      paramBrazeNotificationPayload = paramBrazeNotificationPayload.getLargeIcon();
      if (paramBrazeNotificationPayload != null)
      {
        localObject1 = Braze.Companion;
        localObject1 = ((Braze.Companion)localObject1).getInstance(localContext).getImageLoader();
        localObject2 = BrazeViewBounds.NOTIFICATION_LARGE_ICON;
        paramClassWriter.put(((IBrazeImageLoader)localObject1).getPushBitmapFromUrl(localContext, null, paramBrazeNotificationPayload, (BrazeViewBounds)localObject2));
        return true;
      }
      paramBrazeNotificationPayload = setLargeIconIfPresentAndSupported.4.INSTANCE;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, localObject2, null, null, paramBrazeNotificationPayload, 3, null);
      int i = localBrazeConfigurationProvider.getLargeNotificationIconResourceId();
      if (i != 0)
      {
        paramClassWriter.put(BitmapFactory.decodeResource(localContext.getResources(), i));
        return true;
      }
      paramClassWriter = setLargeIconIfPresentAndSupported.5.INSTANCE;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, localObject2, null, null, paramClassWriter, 3, null);
    }
    catch (Exception paramClassWriter)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, paramClassWriter, setLargeIconIfPresentAndSupported.6.INSTANCE);
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setLargeIconIfPresentAndSupported.7.INSTANCE, 3, null);
    return false;
  }
  
  public static final void setNotificationBadgeNumberIfPresent(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    if (Build.VERSION.SDK_INT < 26)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setNotificationBadgeNumberIfPresent.1.INSTANCE, 3, null);
      return;
    }
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getNotificationBadgeNumber();
    if (paramBrazeNotificationPayload != null) {
      paramClassWriter.a(paramBrazeNotificationPayload.intValue());
    }
  }
  
  public static final void setNotificationDurationAlarm(Context paramContext, Class paramClass, int paramInt1, int paramInt2)
  {
    i.e(paramContext, "context");
    paramClass = new Intent(paramContext, paramClass);
    paramClass.setAction("com.braze.action.CANCEL_NOTIFICATION");
    paramClass.putExtra("nid", paramInt1);
    paramClass = PendingIntent.getBroadcast(paramContext, 0, paramClass, IntentUtils.getImmutablePendingIntentFlags() | 0x8000000);
    paramContext = paramContext.getSystemService("alarm");
    Objects.requireNonNull(paramContext, "null cannot be cast to non-null type android.app.AlarmManager");
    paramContext = (AlarmManager)paramContext;
    if (paramInt2 >= 1000)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, new j(paramInt2)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Setting Notification duration alarm for ");
          localStringBuilder.append($durationInMillis);
          localStringBuilder.append(" ms");
          return localStringBuilder.toString();
        }
      }, 3, null);
      paramContext.set(3, SystemClock.elapsedRealtime() + paramInt2, paramClass);
    }
  }
  
  public static final void setPriorityIfPresentAndSupported(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setPriorityIfPresentAndSupported.1.INSTANCE, 3, null);
    paramClassWriter.put(getNotificationPriority(paramBrazeNotificationPayload));
  }
  
  public static final void setPublicVersionIfPresentAndSupported(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    Object localObject = paramBrazeNotificationPayload.getContext();
    BrazeConfigurationProvider localBrazeConfigurationProvider = paramBrazeNotificationPayload.getConfigurationProvider();
    if (Build.VERSION.SDK_INT < 21)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setPublicVersionIfPresentAndSupported.1.INSTANCE, 3, null);
      return;
    }
    if ((localObject != null) && (paramBrazeNotificationPayload.getPublicNotificationExtras() != null))
    {
      if (localBrazeConfigurationProvider == null) {
        return;
      }
      BrazeNotificationUtils localBrazeNotificationUtils = INSTANCE;
      String str = getOrCreateNotificationChannelId(paramBrazeNotificationPayload);
      paramBrazeNotificationPayload = JsonUtils.parseJsonObjectIntoBundle(paramBrazeNotificationPayload.getPublicNotificationExtras());
      if (paramBrazeNotificationPayload.isEmpty()) {
        return;
      }
      paramBrazeNotificationPayload = new BrazeNotificationPayload(paramBrazeNotificationPayload, null, (Context)localObject, localBrazeConfigurationProvider, 2, null);
      localObject = new ClassWriter((Context)localObject, str);
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, localBrazeNotificationUtils, null, null, new j(paramBrazeNotificationPayload)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Setting public version of notification with payload: ");
          localStringBuilder.append(BrazeNotificationUtils.this);
          return localStringBuilder.toString();
        }
      }, 3, null);
      setContentIfPresent((ClassWriter)localObject, paramBrazeNotificationPayload);
      setTitleIfPresent((ClassWriter)localObject, paramBrazeNotificationPayload);
      setSummaryTextIfPresentAndSupported((ClassWriter)localObject, paramBrazeNotificationPayload);
      setSmallIcon(localBrazeConfigurationProvider, (ClassWriter)localObject);
      setAccentColorIfPresentAndSupported((ClassWriter)localObject, paramBrazeNotificationPayload);
      paramClassWriter.put(((ClassWriter)localObject).get());
    }
  }
  
  public static final void setSetShowWhen(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    if (paramBrazeNotificationPayload.isPushStory())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setSetShowWhen.1.INSTANCE, 3, null);
      paramClassWriter.visitAnnotation(false);
    }
  }
  
  public static final int setSmallIcon(BrazeConfigurationProvider paramBrazeConfigurationProvider, ClassWriter paramClassWriter)
  {
    i.e(paramBrazeConfigurationProvider, "appConfigurationProvider");
    i.e(paramClassWriter, "notificationBuilder");
    int j = paramBrazeConfigurationProvider.getSmallNotificationIconResourceId();
    int i = j;
    if (j == 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setSmallIcon.1.INSTANCE, 3, null);
      i = paramBrazeConfigurationProvider.getApplicationIconResourceId();
    }
    else
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setSmallIcon.2.INSTANCE, 3, null);
    }
    paramClassWriter.get(i);
    return i;
  }
  
  public static final void setSoundIfPresentAndSupported(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getNotificationSound();
    if (paramBrazeNotificationPayload == null) {
      return;
    }
    if (i.a(paramBrazeNotificationPayload, "d"))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setSoundIfPresentAndSupported.1.INSTANCE, 3, null);
      paramClassWriter.add(1);
      return;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setSoundIfPresentAndSupported.2.INSTANCE, 3, null);
    paramClassWriter.get(Uri.parse(paramBrazeNotificationPayload));
  }
  
  public static final void setSummaryTextIfPresentAndSupported(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getSummaryText();
    if (paramBrazeNotificationPayload != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setSummaryTextIfPresentAndSupported.1.INSTANCE, 3, null);
      paramClassWriter.put(paramBrazeNotificationPayload);
      return;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setSummaryTextIfPresentAndSupported.2.INSTANCE, 3, null);
  }
  
  public static final void setTickerIfPresent(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setTickerIfPresent.1.INSTANCE, 3, null);
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getTitleText();
    if (paramBrazeNotificationPayload == null) {
      return;
    }
    paramClassWriter.get(paramBrazeNotificationPayload);
  }
  
  public static final void setTitleIfPresent(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setTitleIfPresent.1.INSTANCE, 3, null);
    String str = paramBrazeNotificationPayload.getTitleText();
    if (str == null) {
      return;
    }
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getConfigurationProvider();
    if (paramBrazeNotificationPayload == null) {
      return;
    }
    paramClassWriter.b(HtmlUtils.getHtmlSpannedTextIfEnabled(str, paramBrazeNotificationPayload));
  }
  
  public static final void setVisibilityIfPresentAndSupported(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    if (Build.VERSION.SDK_INT < 21)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, setVisibilityIfPresentAndSupported.1.INSTANCE, 3, null);
      return;
    }
    paramBrazeNotificationPayload = paramBrazeNotificationPayload.getNotificationVisibility();
    if (paramBrazeNotificationPayload != null)
    {
      BrazeNotificationUtils localBrazeNotificationUtils = INSTANCE;
      if (isValidNotificationVisibility(paramBrazeNotificationPayload.intValue()))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, localBrazeNotificationUtils, null, null, setVisibilityIfPresentAndSupported.2.INSTANCE, 3, null);
        paramClassWriter.c(paramBrazeNotificationPayload.intValue());
        return;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, localBrazeNotificationUtils, BrazeLogger.Priority.PREPARED, null, new j(paramBrazeNotificationPayload)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Received invalid notification visibility ");
          localStringBuilder.append(BrazeNotificationUtils.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
    }
  }
  
  public static final boolean wakeScreenIfAppropriate(Context paramContext, BrazeConfigurationProvider paramBrazeConfigurationProvider, Bundle paramBundle)
  {
    i.e(paramContext, "context");
    i.e(paramBrazeConfigurationProvider, "configurationProvider");
    return wakeScreenIfAppropriate(new BrazeNotificationPayload(paramBundle, null, paramContext, paramBrazeConfigurationProvider, 2, null));
  }
  
  public static final boolean wakeScreenIfAppropriate(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramBrazeNotificationPayload, "payload");
    Context localContext = paramBrazeNotificationPayload.getContext();
    if (localContext == null) {
      return false;
    }
    Object localObject2 = paramBrazeNotificationPayload.getConfigurationProvider();
    if (localObject2 == null) {
      return false;
    }
    Object localObject1 = paramBrazeNotificationPayload.getNotificationExtras();
    if (PermissionUtils.hasPermission(localContext, "android.permission.WAKE_LOCK"))
    {
      if (!((BrazeConfigurationProvider)localObject2).isPushWakeScreenForNotificationEnabled()) {
        return false;
      }
      try
      {
        localObject2 = localContext.getSystemService("uimode");
        if (localObject2 != null)
        {
          localObject2 = (UiModeManager)localObject2;
          int i = ((UiModeManager)localObject2).getCurrentModeType();
          if (i == 4)
          {
            localObject2 = BrazeLogger.INSTANCE;
            BrazeNotificationUtils localBrazeNotificationUtils = INSTANCE;
            j local1 = wakeScreenIfAppropriate.1.INSTANCE;
            BrazeLogger.brazelog$default((BrazeLogger)localObject2, localBrazeNotificationUtils, null, null, local1, 3, null);
            return false;
          }
        }
        else
        {
          localObject2 = new NullPointerException("null cannot be cast to non-null type android.app.UiModeManager");
          throw ((Throwable)localObject2);
        }
      }
      catch (Exception localException)
      {
        BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, localException, wakeScreenIfAppropriate.2.INSTANCE);
        if (Build.VERSION.SDK_INT >= 26)
        {
          paramBrazeNotificationPayload = localContext.getSystemService("notification");
          Objects.requireNonNull(paramBrazeNotificationPayload, "null cannot be cast to non-null type android.app.NotificationManager");
          NotificationManager localNotificationManager = (NotificationManager)paramBrazeNotificationPayload;
          paramBrazeNotificationPayload = INSTANCE;
          localObject1 = getValidNotificationChannel(localNotificationManager, (Bundle)localObject1);
          if (localObject1 == null)
          {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, paramBrazeNotificationPayload, null, null, wakeScreenIfAppropriate.3.INSTANCE, 3, null);
            return false;
          }
          if (((NotificationChannel)localObject1).getImportance() == 1)
          {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, paramBrazeNotificationPayload, null, null, new j((NotificationChannel)localObject1)
            {
              public final String invoke()
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Not acquiring wake-lock for Android O+ notification with importance: ");
                localStringBuilder.append(getImportance());
                return localStringBuilder.toString();
              }
            }, 3, null);
            return false;
          }
        }
        else if (getNotificationPriority(paramBrazeNotificationPayload) == -2)
        {
          return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, wakeScreenIfAppropriate.5.INSTANCE, 3, null);
        paramBrazeNotificationPayload = localContext.getSystemService("power");
        Objects.requireNonNull(paramBrazeNotificationPayload, "null cannot be cast to non-null type android.os.PowerManager");
        paramBrazeNotificationPayload = ((PowerManager)paramBrazeNotificationPayload).newWakeLock(268435482, filter);
        paramBrazeNotificationPayload.acquire();
        paramBrazeNotificationPayload.release();
        return true;
      }
    }
    return false;
  }
  
  private static enum BrazeNotificationBroadcastType
  {
    private final BrazePushEventType brazePushEventType;
    
    static
    {
      DELETED = new BrazeNotificationBroadcastType("DELETED", 2, BrazePushEventType.NOTIFICATION_DELETED);
    }
    
    private BrazeNotificationBroadcastType(BrazePushEventType paramBrazePushEventType)
    {
      brazePushEventType = paramBrazePushEventType;
    }
    
    public final BrazePushEventType getBrazePushEventType()
    {
      return brazePushEventType;
    }
  }
}
