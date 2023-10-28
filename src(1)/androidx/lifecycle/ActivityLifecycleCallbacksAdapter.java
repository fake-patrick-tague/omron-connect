package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;

class ActivityLifecycleCallbacksAdapter
  extends MainApp.1
{
  ActivityLifecycleCallbacksAdapter() {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    BaseFragment.showDialog(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}
