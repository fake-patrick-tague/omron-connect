package androidx.core.package_10;

import android.app.Activity;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;

class ActivityCompatApi23
{
  static void remainder(Object paramObject)
  {
    ((SharedElementCallback.OnSharedElementsReadyListener)paramObject).onSharedElementsReady();
  }
  
  static void requestPermissions(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    paramActivity.requestPermissions(paramArrayOfString, paramInt);
  }
  
  static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString)
  {
    return paramActivity.shouldShowRequestPermissionRationale(paramString);
  }
}
