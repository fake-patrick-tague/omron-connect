package androidx.appcompat.app;

import android.content.IntentFilter;

class d
  extends InactivityTimer
{
  private final TwilightManager f;
  
  d(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7, TwilightManager paramTwilightManager)
  {
    super(paramAppCompatDelegateImplV7);
    f = paramTwilightManager;
  }
  
  public int a()
  {
    if (f.isNight()) {
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
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    return localIntentFilter;
  }
}
