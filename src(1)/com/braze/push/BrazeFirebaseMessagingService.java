package com.braze.push;

import android.content.Context;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public class BrazeFirebaseMessagingService
  extends FirebaseMessagingService
{
  public static final Companion Companion = new Companion(null);
  
  public static final boolean handleBrazeRemoteMessage(Context paramContext, RemoteMessage paramRemoteMessage)
  {
    return Companion.handleBrazeRemoteMessage(paramContext, paramRemoteMessage);
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    public final boolean handleBrazeRemoteMessage(Context paramContext, RemoteMessage paramRemoteMessage)
    {
      i.e(paramContext, "context");
      i.e(paramRemoteMessage, "remoteMessage");
      if (!isBrazePushNotification(paramRemoteMessage))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, new j(paramRemoteMessage)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Remote message did not originate from Braze. Not consuming remote message: ");
            localStringBuilder.append(BrazeFirebaseMessagingService.Companion.this);
            return localStringBuilder.toString();
          }
        }, 2, null);
        return false;
      }
      Object localObject1 = paramRemoteMessage.getData();
      i.d(localObject1, "remoteMessage.data");
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, new j((Map)localObject1)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Got remote message from FCM: ");
          localStringBuilder.append(BrazeFirebaseMessagingService.Companion.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      paramRemoteMessage = new Intent("firebase_messaging_service_routing_action");
      Bundle localBundle = new Bundle();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(str)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Adding bundle item from FCM remote data with key: ");
            localStringBuilder.append(BrazeFirebaseMessagingService.Companion.this);
            localStringBuilder.append(" and value: ");
            localStringBuilder.append($value);
            return localStringBuilder.toString();
          }
        }, 2, null);
        localBundle.putString(str, (String)localObject2);
      }
      paramRemoteMessage.putExtras(localBundle);
      BrazePushReceiver.Companion.handleReceivedIntent$default(BrazePushReceiver.Companion, paramContext, paramRemoteMessage, false, 4, null);
      return true;
    }
    
    public final boolean isBrazePushNotification(RemoteMessage paramRemoteMessage)
    {
      i.e(paramRemoteMessage, "remoteMessage");
      paramRemoteMessage = paramRemoteMessage.getData();
      i.d(paramRemoteMessage, "remoteMessage.data");
      return i.a("true", paramRemoteMessage.get("_ab"));
    }
  }
}
