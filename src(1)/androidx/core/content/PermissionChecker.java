package androidx.core.content;

import android.content.pm.PackageManager;
import android.os.Process;
import androidx.core.package_10.Attribute;

public final class PermissionChecker
{
  public static int checkPermission(android.content.Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) == -1) {
      return -1;
    }
    String str = Attribute.a(paramString1);
    if (str == null) {
      return 0;
    }
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = paramContext.getPackageManager().getPackagesForUid(paramInt2);
      if (paramString1 != null)
      {
        if (paramString1.length <= 0) {
          return -1;
        }
        paramString1 = paramString1[0];
      }
      else
      {
        return -1;
      }
    }
    paramInt1 = Process.myUid();
    paramString2 = paramContext.getPackageName();
    if ((paramInt1 == paramInt2) && (v7.v7.util.Context.equals(paramString2, paramString1))) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      paramInt1 = Attribute.a(paramContext, paramInt2, str, paramString1);
    } else {
      paramInt1 = Attribute.a(paramContext, str, paramString1);
    }
    if (paramInt1 == 0) {
      return 0;
    }
    return -2;
  }
  
  public static int checkSelfPermission(android.content.Context paramContext, String paramString)
  {
    return checkPermission(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
  }
}
