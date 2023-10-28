package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class Session
  implements ServiceConnection
{
  final Queue<zzp<?>> buffer;
  int count;
  final SparseArray<zzp<?>> data;
  final Messenger index;
  Board value;
  
  final void clear()
  {
    try
    {
      if ((count == 2) && (buffer.isEmpty()) && (data.size() == 0))
      {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
          Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
        }
        count = 3;
        ConnectionTracker.getInstance().unbindService(Logger.e(this$0), this);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  final void clear(int paramInt, String paramString, Throwable paramThrowable)
  {
    try
    {
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        String str = String.valueOf(paramString);
        if (str.length() != 0) {
          str = "Disconnected: ".concat(str);
        } else {
          str = new String("Disconnected: ");
        }
        Log.d("MessengerIpcClient", str);
      }
      int i = count;
      if (i != 0)
      {
        if ((i != 1) && (i != 2))
        {
          if (i != 3) {
            return;
          }
          count = 4;
          return;
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
          Log.v("MessengerIpcClient", "Unbinding service");
        }
        count = 4;
        ConnectionTracker.getInstance().unbindService(Logger.e(this$0), this);
        paramString = new JSONObject(paramInt, paramString, paramThrowable);
        paramThrowable = buffer.iterator();
        while (paramThrowable.hasNext()) {
          ((Item)paramThrowable.next()).init(paramString);
        }
        buffer.clear();
        paramInt = 0;
        while (paramInt < data.size())
        {
          ((Item)data.valueAt(paramInt)).init(paramString);
          paramInt += 1;
        }
        data.clear();
        return;
      }
      throw new IllegalStateException();
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  final void close(int paramInt, String paramString)
  {
    try
    {
      clear(paramInt, paramString, null);
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (Log.isLoggable("MessengerIpcClient", 2)) {
      Log.v("MessengerIpcClient", "Service connected");
    }
    Logger.error(this$0).execute(new MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1(this, paramIBinder));
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("MessengerIpcClient", 2)) {
      Log.v("MessengerIpcClient", "Service disconnected");
    }
    Logger.error(this$0).execute(new SpiceManager(this));
  }
  
  final void remove()
  {
    try
    {
      if (count == 1)
      {
        close(1, "Timed out while binding");
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  final void start()
  {
    Logger.error(this$0).execute(new GameThread(this));
  }
  
  final boolean start(Item paramItem)
  {
    for (;;)
    {
      try
      {
        int i = count;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2) {
              return false;
            }
            buffer.add(paramItem);
            start();
            return true;
          }
          buffer.add(paramItem);
          return true;
        }
        buffer.add(paramItem);
        if (count == 0)
        {
          bool = true;
          Preconditions.checkState(bool);
          if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
          }
          count = 1;
          paramItem = new Intent("com.google.android.c2dm.intent.REGISTER");
          paramItem.setPackage("com.google.android.gms");
          try
          {
            ConnectionTracker localConnectionTracker = ConnectionTracker.getInstance();
            Logger localLogger = this$0;
            bool = localConnectionTracker.bindService(Logger.e(localLogger), paramItem, this, 1);
            if (!bool) {
              close(0, "Unable to bind to service");
            } else {
              Logger.error(this$0).schedule(new AsyncContinuation.1(this), 30L, TimeUnit.SECONDS);
            }
          }
          catch (SecurityException paramItem)
          {
            clear(0, "Unable to bind to service", paramItem);
          }
          return true;
        }
      }
      catch (Throwable paramItem)
      {
        throw paramItem;
      }
      boolean bool = false;
    }
  }
  
  final void write(int paramInt)
  {
    try
    {
      Item localItem = (Item)data.get(paramInt);
      if (localItem != null)
      {
        StringBuilder localStringBuilder = new StringBuilder(31);
        localStringBuilder.append("Timing out request: ");
        localStringBuilder.append(paramInt);
        Log.w("MessengerIpcClient", localStringBuilder.toString());
        data.remove(paramInt);
        localItem.init(new JSONObject(3, "Timed out waiting for response", null));
        clear();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
