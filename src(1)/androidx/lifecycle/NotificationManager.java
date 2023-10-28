package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

class NotificationManager
{
  private static AtomicBoolean running = new AtomicBoolean(false);
  
  static void init(Context paramContext)
  {
    if (running.getAndSet(true)) {
      return;
    }
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksAdapter());
  }
}
