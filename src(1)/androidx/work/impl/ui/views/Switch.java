package androidx.work.impl.ui.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Log;
import androidx.work.impl.m.f.d;
import androidx.work.impl.utils.asm.f;

public abstract class Switch<T>
  extends d<T>
{
  private static final String b = Log.getInstance("BrdcstRcvrCnstrntTrckr");
  private final BroadcastReceiver receiver = new ReminderAlarm(this);
  
  public Switch(Context paramContext, f paramF)
  {
    super(paramContext, paramF);
  }
  
  public void a()
  {
    Log.get().append(b, String.format("%s: unregistering receiver", new Object[] { getClass().getSimpleName() }), new Throwable[0]);
    context.unregisterReceiver(receiver);
  }
  
  public abstract IntentFilter init();
  
  public abstract void init(Context paramContext, Intent paramIntent);
  
  public void onCreate()
  {
    Log.get().append(b, String.format("%s: registering receiver", new Object[] { getClass().getSimpleName() }), new Throwable[0]);
    context.registerReceiver(receiver, init());
  }
}
