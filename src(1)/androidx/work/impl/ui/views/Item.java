package androidx.work.impl.ui.views;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Log;
import androidx.work.impl.m.f.c;
import androidx.work.impl.utils.asm.f;

public class Item
  extends c<Boolean>
{
  private static final String type = Log.getInstance("BatteryNotLowTracker");
  
  public Item(Context paramContext, f paramF)
  {
    super(paramContext, paramF);
  }
  
  public IntentFilter init()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
    localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
    return localIntentFilter;
  }
  
  public void init(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {
      return;
    }
    Log.get().append(type, String.format("Received %s", new Object[] { paramIntent.getAction() }), new Throwable[0]);
    paramContext = paramIntent.getAction();
    paramContext.hashCode();
    if (!paramContext.equals("android.intent.action.BATTERY_OKAY"))
    {
      if (!paramContext.equals("android.intent.action.BATTERY_LOW")) {
        return;
      }
      add(Boolean.FALSE);
      return;
    }
    add(Boolean.TRUE);
  }
  
  public Boolean load()
  {
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    localObject = context.registerReceiver(null, (IntentFilter)localObject);
    boolean bool = false;
    if (localObject == null)
    {
      Log.get().get(type, "getInitialState - null intent received", new Throwable[0]);
      return null;
    }
    int i = ((Intent)localObject).getIntExtra("status", -1);
    int j = ((Intent)localObject).getIntExtra("level", -1);
    int k = ((Intent)localObject).getIntExtra("scale", -1);
    float f = j / k;
    if ((i == 1) || (f > 0.15F)) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
}
