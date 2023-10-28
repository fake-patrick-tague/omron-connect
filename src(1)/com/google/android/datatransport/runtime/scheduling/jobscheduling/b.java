package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.BaseBundle;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.asm.drm.Frame;
import com.google.android.datatransport.asm.store.f;
import com.google.android.datatransport.asm.util.util.m;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Adler32;

public class b
  implements c
{
  private final m a;
  private final android.content.Context c;
  private final SchedulerConfig i;
  
  public b(android.content.Context paramContext, m paramM, SchedulerConfig paramSchedulerConfig)
  {
    c = paramContext;
    a = paramM;
    i = paramSchedulerConfig;
  }
  
  private boolean c(JobScheduler paramJobScheduler, int paramInt1, int paramInt2)
  {
    paramJobScheduler = paramJobScheduler.getAllPendingJobs().iterator();
    while (paramJobScheduler.hasNext())
    {
      JobInfo localJobInfo = (JobInfo)paramJobScheduler.next();
      int j = localJobInfo.getExtras().getInt("attemptNumber");
      if (localJobInfo.getId() == paramInt1) {
        if (j >= paramInt2) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void a(com.google.android.datatransport.asm.Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, false);
  }
  
  public void a(com.google.android.datatransport.asm.Context paramContext, int paramInt, boolean paramBoolean)
  {
    Object localObject = new ComponentName(c, JobInfoSchedulerService.class);
    JobScheduler localJobScheduler = (JobScheduler)c.getSystemService("jobscheduler");
    int j = write(paramContext);
    if ((!paramBoolean) && (c(localJobScheduler, j, paramInt)))
    {
      f.d("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", paramContext);
      return;
    }
    long l = a.getValue(paramContext);
    localObject = i.a(new JobInfo.Builder(j, (ComponentName)localObject), paramContext.getValue(), l, paramInt);
    PersistableBundle localPersistableBundle = new PersistableBundle();
    localPersistableBundle.putInt("attemptNumber", paramInt);
    localPersistableBundle.putString("backendName", paramContext.getName());
    localPersistableBundle.putInt("priority", Frame.get(paramContext.getValue()));
    if (paramContext.get() != null) {
      localPersistableBundle.putString("extras", Base64.encodeToString(paramContext.get(), 0));
    }
    ((JobInfo.Builder)localObject).setExtras(localPersistableBundle);
    f.d("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", new Object[] { paramContext, Integer.valueOf(j), Long.valueOf(i.get(paramContext.getValue(), l, paramInt)), Long.valueOf(l), Integer.valueOf(paramInt) });
    localJobScheduler.schedule(((JobInfo.Builder)localObject).build());
  }
  
  int write(com.google.android.datatransport.asm.Context paramContext)
  {
    Adler32 localAdler32 = new Adler32();
    localAdler32.update(c.getPackageName().getBytes(Charset.forName("UTF-8")));
    localAdler32.update(paramContext.getName().getBytes(Charset.forName("UTF-8")));
    localAdler32.update(ByteBuffer.allocate(4).putInt(Frame.get(paramContext.getValue())).array());
    if (paramContext.get() != null) {
      localAdler32.update(paramContext.get());
    }
    return (int)localAdler32.getValue();
  }
}
