package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ContextWrapper;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.Log;
import androidx.work.WorkerParameters.a;
import androidx.work.impl.ClassWriter;
import androidx.work.impl.f;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService
  extends JobService
  implements androidx.work.impl.Object
{
  private static final String p = Log.getInstance("SystemJobService");
  private f b;
  private final Map<String, JobParameters> c = new HashMap();
  
  public SystemJobService() {}
  
  private static String getString(JobParameters paramJobParameters)
  {
    try
    {
      paramJobParameters = paramJobParameters.getExtras();
      if (paramJobParameters != null)
      {
        boolean bool = paramJobParameters.containsKey("EXTRA_WORK_SPEC_ID");
        if (bool)
        {
          paramJobParameters = paramJobParameters.getString("EXTRA_WORK_SPEC_ID");
          return paramJobParameters;
        }
      }
    }
    catch (NullPointerException paramJobParameters)
    {
      for (;;) {}
    }
    return null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Log.get().append(p, String.format("%s executed on JobScheduler", new Object[] { paramString }), new Throwable[0]);
    Map localMap = c;
    try
    {
      paramString = (JobParameters)c.remove(paramString);
      if (paramString != null)
      {
        jobFinished(paramString, paramBoolean);
        return;
      }
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    try
    {
      f localF = f.a(getApplicationContext());
      b = localF;
      localF.get().a(this);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    if (Application.class.equals(getApplication().getClass()))
    {
      Log.get().add(p, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
      return;
    }
    throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    f localF = b;
    if (localF != null) {
      localF.get().get(this);
    }
  }
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    if (b == null)
    {
      Log.get().append(p, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
      jobFinished(paramJobParameters, true);
      return false;
    }
    String str = getString(paramJobParameters);
    if (TextUtils.isEmpty(str))
    {
      Log.get().get(p, "WorkSpec id not found!", new Throwable[0]);
      return false;
    }
    Object localObject = c;
    try
    {
      if (c.containsKey(str))
      {
        Log.get().append(p, String.format("Job is already being executed by SystemJobService: %s", new Object[] { str }), new Throwable[0]);
        return false;
      }
      Log.get().append(p, String.format("onStartJob for %s", new Object[] { str }), new Throwable[0]);
      c.put(str, paramJobParameters);
      localObject = null;
      int i = Build.VERSION.SDK_INT;
      if (i >= 24)
      {
        WorkerParameters.a localA = new WorkerParameters.a();
        if (paramJobParameters.getTriggeredContentUris() != null) {
          allTags = Arrays.asList(paramJobParameters.getTriggeredContentUris());
        }
        if (paramJobParameters.getTriggeredContentAuthorities() != null) {
          allStartTags = Arrays.asList(paramJobParameters.getTriggeredContentAuthorities());
        }
        localObject = localA;
        if (i >= 28)
        {
          mNetwork = paramJobParameters.getNetwork();
          localObject = localA;
        }
      }
      b.b(str, (WorkerParameters.a)localObject);
      return true;
    }
    catch (Throwable paramJobParameters)
    {
      throw paramJobParameters;
    }
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    if (b == null)
    {
      Log.get().append(p, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
      return true;
    }
    String str = getString(paramJobParameters);
    if (TextUtils.isEmpty(str))
    {
      Log.get().get(p, "WorkSpec id not found!", new Throwable[0]);
      return false;
    }
    Log.get().append(p, String.format("onStopJob for %s", new Object[] { str }), new Throwable[0]);
    paramJobParameters = c;
    try
    {
      c.remove(str);
      b.c(str);
      return b.get().execute(str) ^ true;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
