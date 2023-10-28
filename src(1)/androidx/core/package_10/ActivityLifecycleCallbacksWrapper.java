package androidx.core.package_10;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class ActivityLifecycleCallbacksWrapper
  implements Application.ActivityLifecycleCallbacks
{
  private boolean b = false;
  Object c;
  private boolean e = false;
  private boolean f = false;
  private Activity mCallback;
  private final int x;
  
  ActivityLifecycleCallbacksWrapper(Activity paramActivity)
  {
    mCallback = paramActivity;
    x = paramActivity.hashCode();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (mCallback == paramActivity)
    {
      mCallback = null;
      f = true;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((f) && (!b) && (!e) && (Type.a(c, x, paramActivity)))
    {
      b = true;
      c = null;
    }
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (mCallback == paramActivity) {
      e = true;
    }
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}
