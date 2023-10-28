package com.google.android.gms.common.package_12.internal;

import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class ActivityLifecycleObserver
{
  public ActivityLifecycleObserver() {}
  
  public static final ActivityLifecycleObserver run(Activity paramActivity)
  {
    return new BitmapManager(Action.execute(paramActivity));
  }
  
  public abstract ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable);
}
