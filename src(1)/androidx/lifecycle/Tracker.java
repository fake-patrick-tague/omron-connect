package androidx.lifecycle;

import android.app.Application;
import android.os.Handler;

public class Tracker
  implements d
{
  private static final Tracker $assertionsDisabled = new Tracker();
  private boolean a = true;
  private Runnable b = new MonthByWeekFragment.2(this);
  Context c = new Main(this);
  private final f f = new f(this);
  private Handler handler;
  private int i = 0;
  private int state = 0;
  private boolean x = true;
  
  private Tracker() {}
  
  public static d equals()
  {
    return $assertionsDisabled;
  }
  
  static void send(android.content.Context paramContext)
  {
    $assertionsDisabled.close(paramContext);
  }
  
  void a()
  {
    int j = i + 1;
    i = j;
    if (j == 1)
    {
      if (x)
      {
        f.append(Lifecycle.Event.ON_RESUME);
        x = false;
        return;
      }
      handler.removeCallbacks(b);
    }
  }
  
  void close()
  {
    int j = state + 1;
    state = j;
    if ((j == 1) && (a))
    {
      f.append(Lifecycle.Event.ON_START);
      a = false;
    }
  }
  
  void close(android.content.Context paramContext)
  {
    handler = new Handler();
    f.append(Lifecycle.Event.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksWrapper(this));
  }
  
  void connect()
  {
    state -= 1;
    reset();
  }
  
  void f()
  {
    if (i == 0)
    {
      x = true;
      f.append(Lifecycle.Event.ON_PAUSE);
    }
  }
  
  public Lifecycle getLifecycle()
  {
    return f;
  }
  
  void init()
  {
    int j = i - 1;
    i = j;
    if (j == 0) {
      handler.postDelayed(b, 700L);
    }
  }
  
  void reset()
  {
    if ((state == 0) && (x))
    {
      f.append(Lifecycle.Event.ON_STOP);
      a = true;
    }
  }
}
