package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

class ConnectionManager
{
  static Intent execute(Context paramContext, BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler, int paramInt)
  {
    if (((paramInt & 0x4) != 0) && (paramString == null)) {
      return paramContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter, ContextCompat.get(paramContext), paramHandler);
    }
    return paramContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler, paramInt & 0x1);
  }
  
  static ComponentName start(Context paramContext, Intent paramIntent)
  {
    return paramContext.startForegroundService(paramIntent);
  }
}
