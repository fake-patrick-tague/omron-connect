package com.google.firebase.messaging;

import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

public class FirebaseMessagingService
  extends SyncService
{
  private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);
  
  public FirebaseMessagingService() {}
  
  private boolean alreadyReceivedMessage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = recentlyReceivedMessageIds;
    if (((Queue)localObject).contains(paramString))
    {
      if (Log.isLoggable("FirebaseMessaging", 3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Received duplicate message: ");
        ((StringBuilder)localObject).append(paramString);
        Log.d("FirebaseMessaging", ((StringBuilder)localObject).toString());
      }
      return true;
    }
    if (((Queue)localObject).size() >= 10) {
      ((Queue)localObject).remove();
    }
    ((Queue)localObject).add(paramString);
    return false;
  }
  
  private void dispatchMessage(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    ((BaseBundle)localObject1).remove("androidx.content.wakelockid");
    if (Context.get((Bundle)localObject1))
    {
      Object localObject3 = new Context((Bundle)localObject1);
      localObject2 = Timer.getExecutor();
      localObject3 = new Frame(this, (Context)localObject3, (ExecutorService)localObject2);
      try
      {
        boolean bool = ((Frame)localObject3).a();
        if (bool)
        {
          ((ExecutorService)localObject2).shutdown();
          return;
        }
        ((ExecutorService)localObject2).shutdown();
        if (h.a(paramIntent)) {
          h.getItem(paramIntent);
        }
      }
      catch (Throwable paramIntent)
      {
        ((ExecutorService)localObject2).shutdown();
        throw paramIntent;
      }
    }
    onMessageReceived(new RemoteMessage((Bundle)localObject1));
  }
  
  private String getMessageId(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("google.message_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramIntent.getStringExtra("message_id");
    }
    return str1;
  }
  
  private void handleMessageIntent(Intent paramIntent)
  {
    if (!alreadyReceivedMessage(paramIntent.getStringExtra("google.message_id"))) {
      passMessageIntentToSdk(paramIntent);
    }
  }
  
  private void passMessageIntentToSdk(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("message_type");
    String str1 = str2;
    if (str2 == null) {
      str1 = "gcm";
    }
    int i = -1;
    switch (str1.hashCode())
    {
    default: 
      break;
    case 814800675: 
      if (str1.equals("send_event")) {
        i = 3;
      }
      break;
    case 814694033: 
      if (str1.equals("send_error")) {
        i = 2;
      }
      break;
    case 102161: 
      if (str1.equals("gcm")) {
        i = 1;
      }
      break;
    case -2062414158: 
      if (str1.equals("deleted_messages")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      paramIntent = new StringBuilder();
      paramIntent.append("Received message with unknown type: ");
      paramIntent.append(str1);
      Log.w("FirebaseMessaging", paramIntent.toString());
      return;
    case 3: 
      onMessageSent(paramIntent.getStringExtra("google.message_id"));
      return;
    case 2: 
      onSendError(getMessageId(paramIntent), new InvalidPatternException(paramIntent.getStringExtra("error")));
      return;
    case 1: 
      h.f(paramIntent);
      dispatchMessage(paramIntent);
      return;
    }
    onDeletedMessages();
  }
  
  protected Intent getStartCommandIntent(Intent paramIntent)
  {
    return Label.a().doInBackground();
  }
  
  public void handleIntent(Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if ((!"com.google.android.c2dm.intent.RECEIVE".equals(localObject)) && (!"com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(localObject)))
    {
      if ("com.google.firebase.messaging.NEW_TOKEN".equals(localObject))
      {
        onNewToken(paramIntent.getStringExtra("token"));
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown intent action: ");
      ((StringBuilder)localObject).append(paramIntent.getAction());
      Log.d("FirebaseMessaging", ((StringBuilder)localObject).toString());
      return;
    }
    handleMessageIntent(paramIntent);
  }
  
  public void onDeletedMessages() {}
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onNewToken(String paramString) {}
  
  public void onSendError(String paramString, Exception paramException) {}
}
