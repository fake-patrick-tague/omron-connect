package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncService
  extends Service
  implements d
{
  private final MinMaxPriorityQueue this$0 = new MinMaxPriorityQueue(this);
  
  public SyncService() {}
  
  public Lifecycle getLifecycle()
  {
    return this$0.elementData();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    this$0.create();
    return null;
  }
  
  public void onCreate()
  {
    this$0.add();
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this$0.setResult();
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    this$0.offer();
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}
