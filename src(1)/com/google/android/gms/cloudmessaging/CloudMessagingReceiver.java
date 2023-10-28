package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.Type;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class CloudMessagingReceiver
  extends BroadcastReceiver
{
  private final ExecutorService myPool;
  
  public CloudMessagingReceiver()
  {
    Type.getValue();
    Object localObject = new NamedThreadFactory("firebase-iid-executor");
    localObject = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), (ThreadFactory)localObject);
    ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    myPool = Executors.unconfigurableExecutorService((ExecutorService)localObject);
  }
  
  private final int create(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getExtras() == null) {
      return 500;
    }
    Object localObject = paramIntent.getStringExtra("google.message_id");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = Tasks.forResult(null);
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("google.message_id", (String)localObject);
      localObject = Logger.get(paramContext).save(2, localBundle);
    }
    int i = onMessageReceive(paramContext, new CloudMessage(paramIntent));
    paramContext = TimeUnit.SECONDS;
    try
    {
      long l = paramContext.toMillis(1L);
      paramContext = TimeUnit.MILLISECONDS;
      Tasks.await((Task)localObject, l, paramContext);
      return i;
    }
    catch (TimeoutException paramContext) {}catch (InterruptedException paramContext) {}catch (ExecutionException paramContext) {}
    paramContext = String.valueOf(paramContext);
    paramIntent = new StringBuilder(paramContext.length() + 20);
    paramIntent.append("Message ack failed: ");
    paramIntent.append(paramContext);
    Log.w("CloudMessagingReceiver", paramIntent.toString());
    return i;
  }
  
  private final int send(Context paramContext, Intent paramIntent)
  {
    Object localObject = (PendingIntent)paramIntent.getParcelableExtra("pending_intent");
    if (localObject != null) {}
    try
    {
      ((PendingIntent)localObject).send();
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      Bundle localBundle;
      for (;;) {}
    }
    Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
    localBundle = paramIntent.getExtras();
    localObject = localBundle;
    if (localBundle != null) {
      localBundle.remove("pending_intent");
    } else {
      localObject = new Bundle();
    }
    if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(paramIntent.getAction()))
    {
      onNotificationDismissed(paramContext, (Bundle)localObject);
      return -1;
    }
    Log.e("CloudMessagingReceiver", "Unknown notification action");
    return 500;
  }
  
  protected Executor getBroadcastExecutor()
  {
    return myPool;
  }
  
  protected abstract int onMessageReceive(Context paramContext, CloudMessage paramCloudMessage);
  
  protected void onNotificationDismissed(Context paramContext, Bundle paramBundle) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    boolean bool = isOrderedBroadcast();
    BroadcastReceiver.PendingResult localPendingResult = goAsync();
    getBroadcastExecutor().execute(new Device(this, paramIntent, paramContext, bool, localPendingResult));
  }
  
  public static final class IntentActionKeys
  {
    public static final String NOTIFICATION_DISMISS = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
    public static final String NOTIFICATION_OPEN = "com.google.firebase.messaging.NOTIFICATION_OPEN";
    
    private IntentActionKeys() {}
  }
  
  public static final class IntentKeys
  {
    public static final String PENDING_INTENT = "pending_intent";
    public static final String WRAPPED_INTENT = "wrapped_intent";
    
    private IntentKeys() {}
  }
}
