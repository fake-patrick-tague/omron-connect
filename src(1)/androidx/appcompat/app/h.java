package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;

class h
  extends InactivityTimer
{
  private final PowerManager h;
  
  h(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7, Context paramContext)
  {
    super(paramAppCompatDelegateImplV7);
    h = ((PowerManager)paramContext.getApplicationContext().getSystemService("power"));
  }
  
  public int a()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (Format.isPowerSaveMode(h))) {
      return 2;
    }
    return 1;
  }
  
  public void d()
  {
    a.d();
  }
  
  IntentFilter init()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
      return localIntentFilter;
    }
    return null;
  }
}
