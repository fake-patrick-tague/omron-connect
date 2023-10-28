package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.net.Uri;
import android.os.BaseBundle;
import android.util.Base64;
import com.google.android.datatransport.asm.Glide;
import com.google.android.datatransport.asm.a;
import com.google.android.datatransport.asm.drm.Frame;

public class AlarmManagerSchedulerBroadcastReceiver
  extends BroadcastReceiver
{
  public AlarmManagerSchedulerBroadcastReceiver() {}
  
  public void onReceive(android.content.Context paramContext, Intent paramIntent)
  {
    String str2 = paramIntent.getData().getQueryParameter("backendName");
    String str1 = paramIntent.getData().getQueryParameter("extras");
    int i = Integer.valueOf(paramIntent.getData().getQueryParameter("priority")).intValue();
    int j = paramIntent.getExtras().getInt("attemptNumber");
    a.a(paramContext);
    paramContext = com.google.android.datatransport.asm.Context.getInstance().get(str2).get(Frame.get(i));
    if (str1 != null) {
      paramContext.get(Base64.decode(str1, 0));
    }
    a.a().getValue().init(paramContext.get(), j, MainActivity.10.a);
  }
}
