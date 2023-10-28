package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.SyncService;
import androidx.work.Log;

public class SystemForegroundService
  extends SyncService
  implements ByteVector
{
  private static final String TAG = Log.getInstance("SystemFgService");
  private static SystemForegroundService thread = null;
  b c;
  private Handler h;
  private boolean running;
  NotificationManager this$0;
  
  public SystemForegroundService() {}
  
  private void a()
  {
    h = new Handler(Looper.getMainLooper());
    this$0 = ((NotificationManager)getApplicationContext().getSystemService("notification"));
    b localB = new b(getApplicationContext());
    c = localB;
    localB.a(this);
  }
  
  public void a(final int paramInt)
  {
    h.post(new c(paramInt));
  }
  
  public void a(final int paramInt1, final int paramInt2, final Notification paramNotification)
  {
    h.post(new a(paramInt1, paramNotification, paramInt2));
  }
  
  public void a(final int paramInt, final Notification paramNotification)
  {
    h.post(new b(paramInt, paramNotification));
  }
  
  public void onCreate()
  {
    super.onCreate();
    thread = this;
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c.a();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (running)
    {
      Log.get().a(TAG, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
      c.a();
      a();
      running = false;
    }
    if (paramIntent != null) {
      c.close(paramIntent);
    }
    return 3;
  }
  
  public void stop()
  {
    running = true;
    Log.get().append(TAG, "All commands completed.", new Throwable[0]);
    if (Build.VERSION.SDK_INT >= 26) {
      stopForeground(true);
    }
    thread = null;
    stopSelf();
  }
  
  class a
    implements Runnable
  {
    a(int paramInt1, Notification paramNotification, int paramInt2) {}
    
    public void run()
    {
      if (Build.VERSION.SDK_INT >= 29)
      {
        startForeground(paramInt1, paramNotification, paramInt2);
        return;
      }
      startForeground(paramInt1, paramNotification);
    }
  }
  
  class b
    implements Runnable
  {
    b(int paramInt, Notification paramNotification) {}
    
    public void run()
    {
      this$0.notify(paramInt, paramNotification);
    }
  }
  
  class c
    implements Runnable
  {
    c(int paramInt) {}
    
    public void run()
    {
      this$0.cancel(paramInt);
    }
  }
}
