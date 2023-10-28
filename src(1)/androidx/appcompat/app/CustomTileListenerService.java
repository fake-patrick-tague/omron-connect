package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.IBinder;

public final class CustomTileListenerService
  extends Service
{
  public CustomTileListenerService() {}
  
  public static ServiceInfo evaluate(Context paramContext)
    throws PackageManager.NameNotFoundException
  {
    int i;
    if (Build.VERSION.SDK_INT >= 24) {
      i = Renderer.getMaxLineLength() | 0x80;
    } else {
      i = 640;
    }
    return paramContext.getPackageManager().getServiceInfo(new ComponentName(paramContext, m.class), i);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    throw new UnsupportedOperationException();
  }
}
