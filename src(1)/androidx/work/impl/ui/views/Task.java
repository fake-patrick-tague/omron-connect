package androidx.work.impl.ui.views;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import androidx.work.Log;
import androidx.work.impl.m.f.c;
import androidx.work.impl.utils.asm.f;

public class Task
  extends c<Boolean>
{
  private static final String target = Log.getInstance("BatteryChrgTracker");
  
  public Task(Context paramContext, f paramF)
  {
    super(paramContext, paramF);
  }
  
  private boolean load(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = paramIntent.getIntExtra("status", -1);
      if (i == 2) {
        break label40;
      }
      if (i == 5) {
        return true;
      }
    }
    while (paramIntent.getIntExtra("plugged", 0) == 0)
    {
      int i;
      return false;
    }
    label40:
    return true;
  }
  
  public Boolean call()
  {
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    localObject = context.registerReceiver(null, (IntentFilter)localObject);
    if (localObject == null)
    {
      Log.get().get(target, "getInitialState - null intent received", new Throwable[0]);
      return null;
    }
    return Boolean.valueOf(load((Intent)localObject));
  }
  
  public IntentFilter init()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    if (Build.VERSION.SDK_INT >= 23)
    {
      localIntentFilter.addAction("android.os.action.CHARGING");
      localIntentFilter.addAction("android.os.action.DISCHARGING");
      return localIntentFilter;
    }
    localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
    localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
    return localIntentFilter;
  }
  
  public void init(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    paramIntent = Log.get();
    String str = target;
    int i = 1;
    paramIntent.append(str, String.format("Received %s", new Object[] { paramContext }), new Throwable[0]);
    switch (paramContext.hashCode())
    {
    default: 
      break;
    }
    do
    {
      do
      {
        do
        {
          i = -1;
          break;
        } while (!paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED"));
        i = 3;
        break;
      } while (!paramContext.equals("android.os.action.CHARGING"));
      i = 2;
      break;
      if (paramContext.equals("android.os.action.DISCHARGING")) {
        break;
      }
    } while ((goto 95) || (!paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")));
    i = 0;
    switch (i)
    {
    default: 
      return;
    case 3: 
      add(Boolean.TRUE);
      return;
    case 2: 
      add(Boolean.TRUE);
      return;
    case 1: 
      add(Boolean.FALSE);
      return;
    }
    add(Boolean.FALSE);
  }
}
