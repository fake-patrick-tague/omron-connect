package com.google.android.datatransport.asm.util;

import android.content.Context;
import com.google.android.datatransport.asm.asm.Label;
import com.google.android.datatransport.asm.util.util.m;
import com.google.android.datatransport.h.y.j.j0;
import com.google.android.datatransport.runtime.dagger.internal.ByteVector;
import com.google.android.datatransport.runtime.dagger.internal.b;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.c;

public final class e
  implements b<com.google.android.datatransport.runtime.scheduling.jobscheduling.x>
{
  private final g.a.a<SchedulerConfig> a;
  private final g.a.a<com.google.android.datatransport.h.a0.a> b;
  private final g.a.a<j0> c;
  private final g.a.a<Context> j;
  
  public e(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3, g.a.a paramA4)
  {
    j = paramA1;
    c = paramA2;
    a = paramA3;
    b = paramA4;
  }
  
  public static e a(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3, g.a.a paramA4)
  {
    return new e(paramA1, paramA2, paramA3, paramA4);
  }
  
  public static c a(Context paramContext, m paramM, SchedulerConfig paramSchedulerConfig, Label paramLabel)
  {
    return (c)ByteVector.get(x.a(paramContext, paramM, paramSchedulerConfig, paramLabel), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public c a()
  {
    return a((Context)j.get(), (m)c.get(), (SchedulerConfig)a.get(), (Label)b.get());
  }
}
