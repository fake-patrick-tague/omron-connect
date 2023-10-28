package com.google.android.datatransport.asm.util;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.datatransport.asm.asm.Label;
import com.google.android.datatransport.asm.util.util.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.b;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.c;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.d;

public abstract class x
{
  static c a(Context paramContext, m paramM, SchedulerConfig paramSchedulerConfig, Label paramLabel)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new b(paramContext, paramM, paramSchedulerConfig);
    }
    return new d(paramContext, paramM, paramLabel, paramSchedulerConfig);
  }
}
