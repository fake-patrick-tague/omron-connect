package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import c.e.g;
import com.google.android.gms.internal.cloudmessaging.SymmLQ.State;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import v7.util.SimpleArrayMap;

public class Task
{
  private static final Executor TAG = Direction.E;
  private static final Pattern TAG_PATTERN = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
  private static int flags;
  private static PendingIntent target;
  private final Context context;
  private final g<String, TaskCompletionSource<Bundle>> index = new SimpleArrayMap();
  private Element path;
  private final ScheduledExecutorService scheduler;
  private Messenger service;
  private Messenger state;
  private final Channel this$0;
  
  public Task(Context paramContext)
  {
    context = paramContext;
    this$0 = new Channel(paramContext);
    state = new Messenger(new zzaa(this, Looper.getMainLooper()));
    paramContext = new ScheduledThreadPoolExecutor(1);
    paramContext.setKeepAliveTime(60L, TimeUnit.SECONDS);
    paramContext.allowCoreThreadTimeOut(true);
    scheduler = paramContext;
  }
  
  private final com.google.android.gms.tasks.Task execute(Bundle paramBundle)
  {
    String str = getContent();
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localObject1 = index;
    for (;;)
    {
      try
      {
        index.put(str, localTaskCompletionSource);
        localObject1 = new Intent();
        ((Intent)localObject1).setPackage("com.google.android.gms");
        if (this$0.start() == 2) {
          ((Intent)localObject1).setAction("com.google.iid.TOKEN_REQUEST");
        } else {
          ((Intent)localObject1).setAction("com.google.android.c2dm.intent.REGISTER");
        }
        ((Intent)localObject1).putExtras(paramBundle);
        init(context, (Intent)localObject1);
        paramBundle = new StringBuilder(String.valueOf(str).length() + 5);
        paramBundle.append("|ID|");
        paramBundle.append(str);
        paramBundle.append("|");
        ((Intent)localObject1).putExtra("kid", paramBundle.toString());
        if (Log.isLoggable("Rpc", 3))
        {
          paramBundle = String.valueOf(((Intent)localObject1).getExtras());
          localObject2 = new StringBuilder(paramBundle.length() + 8);
          ((StringBuilder)localObject2).append("Sending ");
          ((StringBuilder)localObject2).append(paramBundle);
          Log.d("Rpc", ((StringBuilder)localObject2).toString());
        }
        ((Intent)localObject1).putExtra("google.messenger", state);
        if ((service != null) || (path != null))
        {
          paramBundle = Message.obtain();
          obj = localObject1;
          localObject2 = service;
          if (localObject2 == null) {}
        }
      }
      catch (Throwable paramBundle)
      {
        Object localObject2;
        throw paramBundle;
      }
      try
      {
        ((Messenger)localObject2).send(paramBundle);
      }
      catch (RemoteException paramBundle) {}
    }
    localObject2 = path;
    ((Element)localObject2).add(paramBundle);
    break label334;
    if (Log.isLoggable("Rpc", 3)) {
      Log.d("Rpc", "Messenger failed, fallback to startService");
    }
    if (this$0.start() == 2) {
      context.sendBroadcast((Intent)localObject1);
    } else {
      context.startService((Intent)localObject1);
    }
    label334:
    paramBundle = scheduler.schedule(new FileUtils.23(localTaskCompletionSource), 30L, TimeUnit.SECONDS);
    localTaskCompletionSource.getTask().addOnCompleteListener(TAG, new Pair(this, str, paramBundle));
    return localTaskCompletionSource.getTask();
  }
  
  private static boolean get(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("google.messenger"));
  }
  
  private static String getContent()
  {
    try
    {
      int i = flags;
      flags = i + 1;
      String str = Integer.toString(i);
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private static void init(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (target == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        target = SymmLQ.State.init(paramContext, 0, localIntent, SymmLQ.State.y);
      }
      paramIntent.putExtra("app", target);
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private final void update(String paramString, Bundle paramBundle)
  {
    SimpleArrayMap localSimpleArrayMap = index;
    try
    {
      TaskCompletionSource localTaskCompletionSource = (TaskCompletionSource)index.remove(paramString);
      if (localTaskCompletionSource == null)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "Missing callback for ".concat(paramString);
        } else {
          paramString = new String("Missing callback for ");
        }
        Log.w("Rpc", paramString);
        return;
      }
      localTaskCompletionSource.setResult(paramBundle);
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public com.google.android.gms.tasks.Task send(Bundle paramBundle)
  {
    if (this$0.init() < 12000000)
    {
      if (this$0.start() != 0) {
        return execute(paramBundle).continueWithTask(TAG, new Task.3(this, paramBundle));
      }
      return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
    }
    return Logger.get(context).get(1, paramBundle).continueWith(TAG, Part.LOG);
  }
}
