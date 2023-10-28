package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ContextWrapper;
import android.os.BaseBundle;
import android.util.Base64;
import com.google.android.datatransport.asm.Context;
import com.google.android.datatransport.asm.Glide;
import com.google.android.datatransport.asm.a;
import com.google.android.datatransport.asm.drm.Frame;

public class JobInfoSchedulerService
  extends JobService
{
  public JobInfoSchedulerService() {}
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    Object localObject = paramJobParameters.getExtras().getString("backendName");
    String str = paramJobParameters.getExtras().getString("extras");
    int i = paramJobParameters.getExtras().getInt("priority");
    int j = paramJobParameters.getExtras().getInt("attemptNumber");
    a.a(getApplicationContext());
    localObject = Context.getInstance().get((String)localObject).get(Frame.get(i));
    if (str != null) {
      ((Glide)localObject).get(Base64.decode(str, 0));
    }
    a.a().getValue().init(((Glide)localObject).get(), j, new InitiationListener.1(this, paramJobParameters));
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    return true;
  }
}
