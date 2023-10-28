package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

public abstract class SyncService
  extends Service
{
  private Binder binder;
  final ExecutorService executor = Timer.getExitingExecutorService();
  private int lastStartId;
  private final Object lock = new Object();
  private int runningTasks = 0;
  
  public SyncService() {}
  
  private void finishTask(Intent paramIntent)
  {
    if (paramIntent != null) {
      Notifier.start(paramIntent);
    }
    paramIntent = lock;
    try
    {
      int i = runningTasks - 1;
      runningTasks = i;
      if (i == 0) {
        stopSelfResultHook(lastStartId);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private Task processIntent(Intent paramIntent)
  {
    if (handleIntentOnMainThread(paramIntent)) {
      return Tasks.forResult(null);
    }
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    executor.execute(new MonthListView.1(this, paramIntent, localTaskCompletionSource));
    return localTaskCompletionSource.getTask();
  }
  
  protected abstract Intent getStartCommandIntent(Intent paramIntent);
  
  public abstract void handleIntent(Intent paramIntent);
  
  public boolean handleIntentOnMainThread(Intent paramIntent)
  {
    return false;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3)) {
        Log.d("EnhancedIntentService", "Service received bind request");
      }
      if (binder == null) {
        binder = new Logger(new k0.a(this));
      }
      paramIntent = binder;
      return paramIntent;
    }
    catch (Throwable paramIntent)
    {
      throw paramIntent;
    }
  }
  
  public void onDestroy()
  {
    executor.shutdown();
    super.onDestroy();
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject = lock;
    try
    {
      lastStartId = paramInt2;
      runningTasks += 1;
      localObject = getStartCommandIntent(paramIntent);
      if (localObject == null)
      {
        finishTask(paramIntent);
        return 2;
      }
      localObject = processIntent((Intent)localObject);
      if (((Task)localObject).isComplete())
      {
        finishTask(paramIntent);
        return 2;
      }
      ((Task)localObject).addOnCompleteListener(Scheduler.lock, new LoginActivity.1(this, paramIntent));
      return 3;
    }
    catch (Throwable paramIntent)
    {
      throw paramIntent;
    }
  }
  
  boolean stopSelfResultHook(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
}
