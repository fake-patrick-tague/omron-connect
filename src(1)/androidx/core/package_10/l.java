package androidx.core.package_10;

import android.app.AppOpsManager;
import android.content.Context;

class l
{
  static int a(AppOpsManager paramAppOpsManager, String paramString1, int paramInt, String paramString2)
  {
    if (paramAppOpsManager == null) {
      return 1;
    }
    return paramAppOpsManager.checkOpNoThrow(paramString1, paramInt, paramString2);
  }
  
  static AppOpsManager a(Context paramContext)
  {
    return (AppOpsManager)paramContext.getSystemService(AppOpsManager.class);
  }
  
  static String b(Context paramContext)
  {
    return paramContext.getOpPackageName();
  }
}
