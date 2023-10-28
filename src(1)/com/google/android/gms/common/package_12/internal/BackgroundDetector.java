package com.google.android.gms.common.package_12.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
public final class BackgroundDetector
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final BackgroundDetector lock = new BackgroundDetector();
  private final ArrayList listeners = new ArrayList();
  private boolean root = false;
  private final AtomicBoolean running = new AtomicBoolean();
  private final AtomicBoolean this$0 = new AtomicBoolean();
  
  private BackgroundDetector() {}
  
  public static BackgroundDetector getInstance()
  {
    return lock;
  }
  
  private final void info(boolean paramBoolean)
  {
    BackgroundDetector localBackgroundDetector = lock;
    try
    {
      Iterator localIterator = listeners.iterator();
      while (localIterator.hasNext()) {
        ((BackgroundStateChangeListener)localIterator.next()).onBackgroundStateChanged(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static void initialize(Application paramApplication)
  {
    BackgroundDetector localBackgroundDetector = lock;
    try
    {
      if (!root)
      {
        paramApplication.registerActivityLifecycleCallbacks(localBackgroundDetector);
        paramApplication.registerComponentCallbacks(localBackgroundDetector);
        root = true;
      }
      return;
    }
    catch (Throwable paramApplication)
    {
      throw paramApplication;
    }
  }
  
  public void addListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    BackgroundDetector localBackgroundDetector = lock;
    try
    {
      listeners.add(paramBackgroundStateChangeListener);
      return;
    }
    catch (Throwable paramBackgroundStateChangeListener)
    {
      throw paramBackgroundStateChangeListener;
    }
  }
  
  public boolean isInBackground()
  {
    return this$0.get();
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = this$0.compareAndSet(true, false);
    running.set(true);
    if (bool) {
      info(false);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    boolean bool = this$0.compareAndSet(true, false);
    running.set(true);
    if (bool) {
      info(false);
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (this$0.compareAndSet(false, true)))
    {
      running.set(true);
      info(true);
    }
  }
  
  public boolean readCurrentStateIfPossible(boolean paramBoolean)
  {
    if (!running.get()) {
      if (PlatformVersion.isAtLeastJellyBean())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
        if ((!running.getAndSet(true)) && (importance > 100)) {
          this$0.set(true);
        }
      }
      else
      {
        return paramBoolean;
      }
    }
    return isInBackground();
  }
  
  @KeepForSdk
  public abstract interface BackgroundStateChangeListener
  {
    public abstract void onBackgroundStateChanged(boolean paramBoolean);
  }
}
