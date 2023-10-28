package androidx.work.impl.ui.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ReminderAlarm
  extends BroadcastReceiver
{
  ReminderAlarm(Switch paramSwitch) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null) {
      handler.init(paramContext, paramIntent);
    }
  }
}
