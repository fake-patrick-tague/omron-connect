package androidx.work.impl.ui.views;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import androidx.work.Log;
import androidx.work.impl.m.b;
import androidx.work.impl.m.f.d;
import androidx.work.impl.ui.Handle;
import androidx.work.impl.utils.asm.f;
import v7.v7.view.Account;

public class Label
  extends d<b>
{
  static final String p = Log.getInstance("NetworkStateTracker");
  private final ConnectivityManager c = (ConnectivityManager)context.getSystemService("connectivity");
  private AndroidRouter.ConnectivityBroadcastReceiver d;
  private CheckBox e;
  
  public Label(Context paramContext, f paramF)
  {
    super(paramContext, paramF);
    if (b())
    {
      e = new CheckBox(this);
      return;
    }
    d = new AndroidRouter.ConnectivityBroadcastReceiver(this);
  }
  
  private static boolean b()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public void a()
  {
    if (b())
    {
      try
      {
        Object localObject1 = Log.get();
        Object localObject2 = p;
        ((Log)localObject1).append((String)localObject2, "Unregistering network callback", new Throwable[0]);
        localObject1 = c;
        localObject2 = e;
        ((ConnectivityManager)localObject1).unregisterNetworkCallback((ConnectivityManager.NetworkCallback)localObject2);
        return;
      }
      catch (SecurityException localSecurityException) {}catch (IllegalArgumentException localIllegalArgumentException) {}
      Log.get().get(p, "Received exception while unregistering network callback", new Throwable[] { localIllegalArgumentException });
      return;
    }
    Log.get().append(p, "Unregistering broadcast receiver", new Throwable[0]);
    context.unregisterReceiver(d);
  }
  
  boolean execute()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    Object localObject = c;
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetwork();
      ConnectivityManager localConnectivityManager = c;
      localObject = localConnectivityManager.getNetworkCapabilities((Network)localObject);
      if (localObject != null)
      {
        boolean bool = ((NetworkCapabilities)localObject).hasCapability(16);
        if (bool) {
          return true;
        }
      }
    }
    catch (SecurityException localSecurityException)
    {
      Log.get().get(p, "Unable to validate active network", (Throwable[])new Throwable[] { localSecurityException });
    }
    return false;
  }
  
  public Handle getEntry()
  {
    return search();
  }
  
  public void onCreate()
  {
    if (b())
    {
      try
      {
        Object localObject1 = Log.get();
        Object localObject2 = p;
        ((Log)localObject1).append((String)localObject2, "Registering network callback", new Throwable[0]);
        localObject1 = c;
        localObject2 = e;
        ((ConnectivityManager)localObject1).registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)localObject2);
        return;
      }
      catch (SecurityException localSecurityException) {}catch (IllegalArgumentException localIllegalArgumentException) {}
      Log.get().get(p, "Received exception while registering network callback", new Throwable[] { localIllegalArgumentException });
      return;
    }
    Log.get().append(p, "Registering broadcast receiver", new Throwable[0]);
    context.registerReceiver(d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  Handle search()
  {
    NetworkInfo localNetworkInfo = c.getActiveNetworkInfo();
    boolean bool2 = true;
    boolean bool1;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = execute();
    boolean bool4 = Account.send(c);
    if ((localNetworkInfo == null) || (localNetworkInfo.isRoaming())) {
      bool2 = false;
    }
    return new Handle(bool1, bool3, bool4, bool2);
  }
}
