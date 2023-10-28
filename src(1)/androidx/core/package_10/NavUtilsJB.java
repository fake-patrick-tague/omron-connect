package androidx.core.package_10;

import android.app.Activity;
import android.content.Intent;

class NavUtilsJB
{
  static Intent getParentActivityIntent(Activity paramActivity)
  {
    return paramActivity.getParentActivityIntent();
  }
  
  static boolean navigateUpTo(Activity paramActivity, Intent paramIntent)
  {
    return paramActivity.navigateUpTo(paramIntent);
  }
  
  static boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
  {
    return paramActivity.shouldUpRecreateTask(paramIntent);
  }
}
