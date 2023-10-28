package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class LifecycleHandler
  implements Application.ActivityLifecycleCallbacks
{
  LifecycleHandler() {}
  
  static void registerIn(Activity paramActivity)
  {
    paramActivity.registerActivityLifecycleCallbacks(new LifecycleHandler());
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityPostCreated(Activity paramActivity, Bundle paramBundle)
  {
    BaseFragment.onCreateOptionsMenu(paramActivity, Lifecycle.Event.ON_CREATE);
  }
  
  public void onActivityPostResumed(Activity paramActivity)
  {
    BaseFragment.onCreateOptionsMenu(paramActivity, Lifecycle.Event.ON_RESUME);
  }
  
  public void onActivityPostStarted(Activity paramActivity)
  {
    BaseFragment.onCreateOptionsMenu(paramActivity, Lifecycle.Event.ON_START);
  }
  
  public void onActivityPreDestroyed(Activity paramActivity)
  {
    BaseFragment.onCreateOptionsMenu(paramActivity, Lifecycle.Event.ON_DESTROY);
  }
  
  public void onActivityPrePaused(Activity paramActivity)
  {
    BaseFragment.onCreateOptionsMenu(paramActivity, Lifecycle.Event.ON_PAUSE);
  }
  
  public void onActivityPreStopped(Activity paramActivity)
  {
    BaseFragment.onCreateOptionsMenu(paramActivity, Lifecycle.Event.ON_STOP);
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}
