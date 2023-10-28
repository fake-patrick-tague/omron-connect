package com.braze.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import androidx.core.package_10.ClassWriter;
import androidx.core.package_10.m.a.a;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.models.push.BrazeNotificationPayload.ActionButton;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.IntentUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler.Companion;
import java.util.Iterator;
import java.util.List;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class BrazeNotificationActionUtils
{
  public static final BrazeNotificationActionUtils INSTANCE = new BrazeNotificationActionUtils();
  
  private BrazeNotificationActionUtils() {}
  
  public static final void addNotificationActions(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    if (paramBrazeNotificationPayload.getContext() == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, addNotificationActions.1.INSTANCE, 3, null);
      return;
    }
    Object localObject = paramBrazeNotificationPayload.getActionButtons();
    if (((List)localObject).isEmpty())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, addNotificationActions.2.INSTANCE, 3, null);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BrazeNotificationPayload.ActionButton localActionButton = (BrazeNotificationPayload.ActionButton)((Iterator)localObject).next();
      BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
      BrazeNotificationActionUtils localBrazeNotificationActionUtils = INSTANCE;
      BrazeLogger.brazelog$default(localBrazeLogger, localBrazeNotificationActionUtils, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(localActionButton)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Adding action button: ");
          localStringBuilder.append(BrazeNotificationActionUtils.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      localBrazeNotificationActionUtils.addNotificationAction(paramClassWriter, paramBrazeNotificationPayload, localActionButton);
    }
  }
  
  public static final void handleNotificationActionClicked(Context paramContext, Intent paramIntent)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "intent");
    try
    {
      Object localObject2 = paramIntent.getStringExtra("braze_action_type");
      int j = 0;
      boolean bool;
      if (localObject2 != null)
      {
        bool = g.o((CharSequence)localObject2);
        if (!bool)
        {
          i = 0;
          break label49;
        }
      }
      int i = 1;
      label49:
      if (i != 0)
      {
        paramContext = BrazeLogger.INSTANCE;
        paramIntent = INSTANCE;
        localObject1 = BrazeLogger.Priority.PREPARED;
        localObject2 = handleNotificationActionClicked.1.INSTANCE;
        BrazeLogger.brazelog$default(paramContext, paramIntent, (BrazeLogger.Priority)localObject1, null, (a)localObject2, 2, null);
        return;
      }
      i = paramIntent.getIntExtra("nid", -1);
      Object localObject1 = INSTANCE;
      ((BrazeNotificationActionUtils)localObject1).logNotificationActionClicked(paramContext, paramIntent, (String)localObject2);
      if (localObject2 != null)
      {
        int k = ((String)localObject2).hashCode();
        if (k != -1424488370)
        {
          if (k != -1209677674)
          {
            if (k != -1209647192) {
              break label381;
            }
            bool = ((String)localObject2).equals("ab_open");
            if (!bool) {
              break label381;
            }
          }
          else
          {
            bool = ((String)localObject2).equals("ab_none");
            if (!bool) {
              break label381;
            }
            BrazeNotificationUtils.cancelNotification(paramContext, i);
          }
        }
        else
        {
          bool = ((String)localObject2).equals("ab_uri");
          if (!bool) {
            break label381;
          }
        }
        BrazeNotificationUtils.cancelNotification(paramContext, i);
        bool = i.a(localObject2, "ab_uri");
        if (bool)
        {
          localObject2 = paramIntent.getExtras();
          if (localObject2 != null)
          {
            bool = ((BaseBundle)localObject2).containsKey("braze_action_uri");
            if (bool == true)
            {
              i = 1;
              break label251;
            }
          }
          i = 0;
          label251:
          if (i != 0)
          {
            paramIntent.putExtra("uri", paramIntent.getStringExtra("braze_action_uri"));
            localObject2 = paramIntent.getExtras();
            i = j;
            if (localObject2 != null)
            {
              bool = ((BaseBundle)localObject2).containsKey("braze_action_use_webview");
              i = j;
              if (bool == true) {
                i = 1;
              }
            }
            if (i == 0) {
              break label326;
            }
            paramIntent.putExtra("ab_use_webview", paramIntent.getStringExtra("braze_action_use_webview"));
            break label326;
          }
        }
        paramIntent.removeExtra("uri");
        label326:
        BrazeNotificationUtils.sendNotificationOpenedBroadcast(paramContext, paramIntent);
        bool = new BrazeConfigurationProvider(paramContext).getDoesHandlePushDeepLinksAutomatically();
        if (bool)
        {
          BrazeNotificationUtils.routeUserWithNotificationOpenedIntent(paramContext, paramIntent);
          return;
        }
        paramContext = BrazeLogger.INSTANCE;
        paramIntent = BrazeLogger.Priority.g;
        localObject2 = handleNotificationActionClicked.2.INSTANCE;
        BrazeLogger.brazelog$default(paramContext, localObject1, paramIntent, null, (a)localObject2, 2, null);
        return;
      }
      label381:
      paramContext = BrazeLogger.INSTANCE;
      paramIntent = BrazeLogger.Priority.PREPARED;
      localObject2 = handleNotificationActionClicked.3.INSTANCE;
      BrazeLogger.brazelog$default(paramContext, localObject1, paramIntent, null, (a)localObject2, 2, null);
      return;
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, paramContext, handleNotificationActionClicked.4.INSTANCE);
    }
  }
  
  public final void addNotificationAction(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload, BrazeNotificationPayload.ActionButton paramActionButton)
  {
    i.e(paramClassWriter, "notificationBuilder");
    i.e(paramBrazeNotificationPayload, "payload");
    i.e(paramActionButton, "actionButton");
    Object localObject = paramBrazeNotificationPayload.getContext();
    if (localObject == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, addNotificationAction.1.INSTANCE, 3, null);
      return;
    }
    Bundle localBundle = new Bundle(paramBrazeNotificationPayload.getNotificationExtras());
    paramActionButton.putIntoBundle(localBundle);
    paramBrazeNotificationPayload = paramActionButton.getType();
    int i = 0x8000000 | IntentUtils.getImmutablePendingIntentFlags();
    if (i.a("ab_none", paramBrazeNotificationPayload))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramBrazeNotificationPayload)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Adding notification action with type: ");
          localStringBuilder.append(BrazeNotificationActionUtils.this);
          localStringBuilder.append("Setting intent class to notification receiver: ");
          localStringBuilder.append(BrazeNotificationUtils.getNotificationReceiverClass());
          return localStringBuilder.toString();
        }
      }, 2, null);
      paramBrazeNotificationPayload = new Intent("com.braze.action.BRAZE_ACTION_CLICKED").setClass((Context)localObject, BrazeNotificationUtils.getNotificationReceiverClass());
      i.d(paramBrazeNotificationPayload, "Intent(Constants.BRAZE_A?ceiverClass\n            )");
      paramBrazeNotificationPayload.putExtras(localBundle);
      localObject = PendingIntent.getBroadcast((Context)localObject, IntentUtils.getRequestCode(), paramBrazeNotificationPayload, i);
      paramBrazeNotificationPayload = (BrazeNotificationPayload)localObject;
      i.d(localObject, "getBroadcast(\n          ?IntentFlags\n            )");
    }
    else
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramBrazeNotificationPayload)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Adding notification action with type: ");
          localStringBuilder.append(BrazeNotificationActionUtils.this);
          localStringBuilder.append(" Setting intent class to trampoline activity");
          return localStringBuilder.toString();
        }
      }, 2, null);
      paramBrazeNotificationPayload = new Intent("com.braze.action.BRAZE_ACTION_CLICKED").setClass((Context)localObject, NotificationTrampolineActivity.class);
      i.d(paramBrazeNotificationPayload, "Intent(Constants.BRAZE_A?lineActivity::class.java)");
      paramBrazeNotificationPayload.setFlags(paramBrazeNotificationPayload.getFlags() | BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_ACTION_WITH_DEEPLINK));
      paramBrazeNotificationPayload.putExtras(localBundle);
      localObject = PendingIntent.getActivity((Context)localObject, IntentUtils.getRequestCode(), paramBrazeNotificationPayload, i);
      paramBrazeNotificationPayload = (BrazeNotificationPayload)localObject;
      i.d(localObject, "getActivity(\n           ?IntentFlags\n            )");
    }
    paramBrazeNotificationPayload = new m.a.a(0, paramActionButton.getText(), paramBrazeNotificationPayload);
    paramBrazeNotificationPayload.a(new Bundle(localBundle));
    paramClassWriter.a(paramBrazeNotificationPayload.a());
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(localBundle)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Added action with bundle: ");
        localStringBuilder.append(BrazeNotificationActionUtils.this);
        return localStringBuilder.toString();
      }
    }, 2, null);
  }
  
  public final void logNotificationActionClicked(Context paramContext, Intent paramIntent, String paramString)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "intent");
    String str = paramIntent.getStringExtra("cid");
    paramIntent = paramIntent.getStringExtra("braze_action_id");
    Braze.Companion.getInstance(paramContext).logPushNotificationActionClicked(str, paramIntent, paramString);
  }
}
