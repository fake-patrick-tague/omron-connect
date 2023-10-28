package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import androidx.work.Log;

public class Context
{
  private static final String g = Log.getInstance("PackageManagerHelper");
  
  public static void get(android.content.Context paramContext, Class paramClass, boolean paramBoolean)
  {
    String str1 = "enabled";
    try
    {
      Object localObject1 = paramContext.getPackageManager();
      paramContext = new ComponentName(paramContext, paramClass.getName());
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      ((PackageManager)localObject1).setComponentEnabledSetting(paramContext, i, 1);
      localObject1 = Log.get();
      localObject2 = g;
      str2 = paramClass.getName();
      if (paramBoolean) {
        paramContext = "enabled";
      } else {
        paramContext = "disabled";
      }
      paramContext = String.format("%s %s", new Object[] { str2, paramContext });
      ((Log)localObject1).append((String)localObject2, paramContext, new Throwable[0]);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = Log.get();
      String str2 = g;
      paramClass = paramClass.getName();
      if (paramBoolean) {
        paramContext = str1;
      } else {
        paramContext = "disabled";
      }
      ((Log)localObject2).append(str2, String.format("%s could not be %s", new Object[] { paramClass, paramContext }), (Throwable[])new Throwable[] { localException });
    }
  }
}
