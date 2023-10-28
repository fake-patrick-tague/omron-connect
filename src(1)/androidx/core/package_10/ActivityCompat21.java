package androidx.core.package_10;

import android.app.Activity;
import android.app.SharedElementCallback;

class ActivityCompat21
{
  static void finishAfterTransition(Activity paramActivity)
  {
    paramActivity.finishAfterTransition();
  }
  
  static void postponeEnterTransition(Activity paramActivity)
  {
    paramActivity.postponeEnterTransition();
  }
  
  static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    paramActivity.setEnterSharedElementCallback(paramSharedElementCallback);
  }
  
  static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    paramActivity.setExitSharedElementCallback(paramSharedElementCallback);
  }
  
  static void startPostponedEnterTransition(Activity paramActivity)
  {
    paramActivity.startPostponedEnterTransition();
  }
}
