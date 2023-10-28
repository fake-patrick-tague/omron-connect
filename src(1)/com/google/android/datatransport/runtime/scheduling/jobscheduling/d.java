package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.util.Base64;
import com.google.android.datatransport.asm.asm.Label;
import com.google.android.datatransport.asm.drm.Frame;
import com.google.android.datatransport.asm.store.f;
import com.google.android.datatransport.asm.util.util.m;

public class d
  implements c
{
  private AlarmManager a;
  private final Label b;
  private final android.content.Context c;
  private final SchedulerConfig i;
  private final m s;
  
  d(android.content.Context paramContext, m paramM, AlarmManager paramAlarmManager, Label paramLabel, SchedulerConfig paramSchedulerConfig)
  {
    c = paramContext;
    s = paramM;
    a = paramAlarmManager;
    b = paramLabel;
    i = paramSchedulerConfig;
  }
  
  public d(android.content.Context paramContext, m paramM, Label paramLabel, SchedulerConfig paramSchedulerConfig)
  {
    this(paramContext, paramM, (AlarmManager)paramContext.getSystemService("alarm"), paramLabel, paramSchedulerConfig);
  }
  
  public void a(com.google.android.datatransport.asm.Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, false);
  }
  
  public void a(com.google.android.datatransport.asm.Context paramContext, int paramInt, boolean paramBoolean)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.appendQueryParameter("backendName", paramContext.getName());
    localBuilder.appendQueryParameter("priority", String.valueOf(Frame.get(paramContext.getValue())));
    if (paramContext.get() != null) {
      localBuilder.appendQueryParameter("extras", Base64.encodeToString(paramContext.get(), 0));
    }
    Intent localIntent = new Intent(c, AlarmManagerSchedulerBroadcastReceiver.class);
    localIntent.setData(localBuilder.build());
    localIntent.putExtra("attemptNumber", paramInt);
    if ((!paramBoolean) && (a(localIntent)))
    {
      f.d("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", paramContext);
      return;
    }
    long l1 = s.getValue(paramContext);
    long l2 = i.get(paramContext.getValue(), l1, paramInt);
    f.d("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", new Object[] { paramContext, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(paramInt) });
    paramContext = c;
    if (Build.VERSION.SDK_INT >= 23) {
      paramInt = 67108864;
    } else {
      paramInt = 0;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, 0, localIntent, paramInt);
    a.set(3, b.a() + l2, paramContext);
  }
  
  boolean a(Intent paramIntent)
  {
    int j;
    if (Build.VERSION.SDK_INT >= 23) {
      j = 603979776;
    } else {
      j = 536870912;
    }
    return PendingIntent.getBroadcast(c, 0, paramIntent, j) != null;
  }
}
