package androidx.work.impl.background.systemalarm;

import android.app.Service;
import android.content.Intent;
import androidx.lifecycle.SyncService;
import androidx.work.Log;
import androidx.work.impl.utils.Collection;

public class SystemAlarmService
  extends SyncService
  implements Item
{
  private static final String c = Log.getInstance("SystemAlarmService");
  private f a;
  private boolean notification;
  
  public SystemAlarmService() {}
  
  private void d()
  {
    f localF = new f(this);
    a = localF;
    localF.c(this);
  }
  
  public void onCreate()
  {
    super.onCreate();
    d();
    notification = false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    notification = true;
    a.e();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (notification)
    {
      Log.get().a(c, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
      a.e();
      d();
      notification = false;
    }
    if (paramIntent != null) {
      a.a(paramIntent, paramInt2);
    }
    return 3;
  }
  
  public void updateNotification()
  {
    notification = true;
    Log.get().append(c, "All commands completed in dispatcher", new Throwable[0]);
    Collection.save();
    stopSelf();
  }
}
