package androidx.lifecycle;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;

class ActivityLifecycleCallbacksWrapper
  extends MainApp.1
{
  ActivityLifecycleCallbacksWrapper(Tracker paramTracker) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 29) {
      BaseFragment.onActivityCreated(paramActivity).onActivityCreated(this$0.c);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    this$0.init();
  }
  
  public void onActivityPreCreated(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity.registerActivityLifecycleCallbacks(new v.c.a(this));
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this$0.connect();
  }
}
