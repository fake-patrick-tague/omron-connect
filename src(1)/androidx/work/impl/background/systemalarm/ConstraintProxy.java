package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Log;
import androidx.work.NetworkType;
import androidx.work.i;
import androidx.work.impl.asm.h;
import java.util.Iterator;
import java.util.List;

abstract class ConstraintProxy
  extends BroadcastReceiver
{
  private static final String a = Log.getInstance("ConstraintProxy");
  
  ConstraintProxy() {}
  
  static void a(Context paramContext, List paramList)
  {
    paramList = paramList.iterator();
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5;
    boolean bool7;
    boolean bool8;
    boolean bool6;
    do
    {
      do
      {
        do
        {
          do
          {
            bool5 = bool4;
            bool7 = bool3;
            bool8 = bool2;
            bool6 = bool1;
            if (!paramList.hasNext()) {
              break;
            }
            i localI = nextb;
            bool5 = bool4 | localI.c();
            bool7 = bool3 | localI.g();
            bool8 = bool2 | localI.a();
            int i;
            if (localI.p() != NetworkType.c) {
              i = 1;
            } else {
              i = 0;
            }
            bool6 = bool1 | i;
            bool4 = bool5;
            bool3 = bool7;
            bool2 = bool8;
            bool1 = bool6;
          } while (!bool5);
          bool4 = bool5;
          bool3 = bool7;
          bool2 = bool8;
          bool1 = bool6;
        } while (!bool7);
        bool4 = bool5;
        bool3 = bool7;
        bool2 = bool8;
        bool1 = bool6;
      } while (!bool8);
      bool4 = bool5;
      bool3 = bool7;
      bool2 = bool8;
      bool1 = bool6;
    } while (!bool6);
    paramContext.sendBroadcast(ConstraintProxyUpdateReceiver.createIntent(paramContext, bool5, bool7, bool8, bool6));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.get().append(a, String.format("onReceive : %s", new Object[] { paramIntent }), new Throwable[0]);
    paramContext.startService(b.a(paramContext));
  }
  
  public static class BatteryChargingProxy
    extends ConstraintProxy
  {
    public BatteryChargingProxy() {}
  }
  
  public static class BatteryNotLowProxy
    extends ConstraintProxy
  {
    public BatteryNotLowProxy() {}
  }
  
  public static class NetworkStateProxy
    extends ConstraintProxy
  {
    public NetworkStateProxy() {}
  }
  
  public static class StorageNotLowProxy
    extends ConstraintProxy
  {
    public StorageNotLowProxy() {}
  }
}
