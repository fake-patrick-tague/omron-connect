package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.Log;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class Frame
{
  private static final String b = Log.getInstance("ProcessUtils");
  
  private Frame() {}
  
  public static boolean a(Context paramContext, androidx.work.f paramF)
  {
    String str = execute(paramContext);
    if (!TextUtils.isEmpty(paramF.c())) {
      return TextUtils.equals(str, paramF.c());
    }
    return TextUtils.equals(str, getApplicationInfoprocessName);
  }
  
  public static String execute(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return Application.getProcessName();
    }
    try
    {
      Object localObject2 = Class.forName("android.app.ActivityThread", false, f.class.getClassLoader());
      Object localObject1;
      if (i >= 18)
      {
        localObject1 = ((Class)localObject2).getDeclaredMethod("currentProcessName", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
      }
      else
      {
        localObject1 = ((Class)localObject2).getDeclaredMethod("currentActivityThread", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject2 = ((Class)localObject2).getDeclaredMethod("getProcessName", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(((Method)localObject1).invoke(null, new Object[0]), new Object[0]);
      }
      boolean bool = localObject1 instanceof String;
      if (bool)
      {
        localObject1 = (String)localObject1;
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.get().append(b, "Unable to check ActivityThread for processName", new Throwable[] { localThrowable });
      i = Process.myPid();
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningAppProcesses();
        if ((paramContext != null) && (!paramContext.isEmpty()))
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if (pid == i) {
              return processName;
            }
          }
        }
      }
    }
    return null;
  }
}
