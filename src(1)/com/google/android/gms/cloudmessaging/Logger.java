package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.Type;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class Logger
{
  private static Logger INSTANCE;
  private final Context e;
  private final ScheduledExecutorService level;
  private Session parent = new Session(this, null);
  private int state = 1;
  
  Logger(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    level = paramScheduledExecutorService;
    e = paramContext.getApplicationContext();
  }
  
  private final Task call(Item paramItem)
  {
    try
    {
      Object localObject;
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        localObject = String.valueOf(paramItem);
        StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 9);
        localStringBuilder.append("Queueing ");
        localStringBuilder.append((String)localObject);
        Log.d("MessengerIpcClient", localStringBuilder.toString());
      }
      if (!parent.start(paramItem))
      {
        localObject = new Session(this, null);
        parent = ((Session)localObject);
        ((Session)localObject).start(paramItem);
      }
      paramItem = this$0.getTask();
      return paramItem;
    }
    catch (Throwable paramItem)
    {
      throw paramItem;
    }
  }
  
  public static Logger get(Context paramContext)
  {
    try
    {
      if (INSTANCE == null)
      {
        Type.getValue();
        INSTANCE = new Logger(paramContext, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
      }
      paramContext = INSTANCE;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private final int getState()
  {
    try
    {
      int i = state;
      state = (i + 1);
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Task get(int paramInt, Bundle paramBundle)
  {
    return call(new Route(getState(), 1, paramBundle));
  }
  
  public final Task save(int paramInt, Bundle paramBundle)
  {
    return call(new Category(getState(), 2, paramBundle));
  }
}
