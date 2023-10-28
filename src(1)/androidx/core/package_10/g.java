package androidx.core.package_10;

import android.app.AppOpsManager;
import android.content.Context;

class g
{
  static int c(AppOpsManager paramAppOpsManager, String paramString1, String paramString2)
  {
    return paramAppOpsManager.noteProxyOpNoThrow(paramString1, paramString2);
  }
  
  static Object getService(Context paramContext, Class paramClass)
  {
    return paramContext.getSystemService(paramClass);
  }
  
  static int noteProxyOp(AppOpsManager paramAppOpsManager, String paramString1, String paramString2)
  {
    return paramAppOpsManager.noteProxyOp(paramString1, paramString2);
  }
  
  static String permissionToOp(String paramString)
  {
    return AppOpsManager.permissionToOp(paramString);
  }
}
