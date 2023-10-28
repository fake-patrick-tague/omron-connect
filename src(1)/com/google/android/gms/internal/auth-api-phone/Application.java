package com.google.android.gms.internal.auth-api-phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.util.phone.SmsRetrieverClient;
import com.google.android.gms.common.package_12.GoogleApi;
import com.google.android.gms.tasks.Task;

public final class Application
  extends SmsRetrieverClient
{
  public Application(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public Application(Context paramContext)
  {
    super(paramContext);
  }
  
  public final Task startSmsRetriever()
  {
    return doWrite(new GitOperation(this));
  }
}
