package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public final class zzbt
{
  private static final Method a;
  private static final Method b;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject2 = null;
    if (i >= 24) {
      localObject1 = Integer.TYPE;
    }
    try
    {
      localObject1 = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[] { JobInfo.class, String.class, localObject1, String.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;) {}
    }
    if (Log.isLoggable("JobSchedulerCompat", 6)) {
      Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
    }
    Object localObject1 = null;
    a = (Method)localObject1;
    localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      localObject1 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      for (;;) {}
    }
    localObject1 = localObject2;
    if (Log.isLoggable("JobSchedulerCompat", 6))
    {
      Log.e("JobSchedulerCompat", "No myUserId method available");
      localObject1 = localObject2;
    }
    b = (Method)localObject1;
  }
  
  public static int get(Context paramContext, JobInfo paramJobInfo, String paramString1, String paramString2)
  {
    paramString1 = (JobScheduler)paramContext.getSystemService("jobscheduler");
    Objects.requireNonNull(paramString1);
    if ((a != null) && (paramContext.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0))
    {
      paramContext = b;
      if (paramContext != null)
      {
        try
        {
          paramContext = paramContext.invoke(UserHandle.class, new Object[0]);
          paramContext = (Integer)paramContext;
          if (paramContext == null) {
            break label94;
          }
          i = paramContext.intValue();
        }
        catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}
        if (Log.isLoggable("JobSchedulerCompat", 6)) {
          Log.e("JobSchedulerCompat", "myUserId invocation illegal", paramContext);
        }
      }
      label94:
      int i = 0;
      paramContext = a;
      if (paramContext != null)
      {
        try
        {
          paramContext = paramContext.invoke(paramString1, new Object[] { paramJobInfo, "com.google.android.gms", Integer.valueOf(i), "UploadAlarm" });
          paramContext = (Integer)paramContext;
          if (paramContext == null) {
            break label181;
          }
          i = paramContext.intValue();
          return i;
        }
        catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}
        Log.e("UploadAlarm", "error calling scheduleAsPackage", paramContext);
      }
      else
      {
        return paramString1.schedule(paramJobInfo);
      }
    }
    else
    {
      return paramString1.schedule(paramJobInfo);
    }
    label181:
    return 0;
  }
}
