package androidx.core.package_10;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build.VERSION;

public final class Attribute
{
  public static int a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      AppOpsManager localAppOpsManager = l.a(paramContext);
      int i = l.a(localAppOpsManager, paramString1, Binder.getCallingUid(), paramString2);
      if (i != 0) {
        return i;
      }
      return l.a(localAppOpsManager, paramString1, paramInt, l.b(paramContext));
    }
    return a(paramContext, paramString1, paramString2);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return g.c((AppOpsManager)g.getService(paramContext, AppOpsManager.class), paramString1, paramString2);
    }
    return 1;
  }
  
  public static String a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return g.permissionToOp(paramString);
    }
    return null;
  }
}
