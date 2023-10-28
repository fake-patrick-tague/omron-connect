package com.google.android.datatransport.asm.util;

import com.google.android.datatransport.asm.asm.Label;
import com.google.android.datatransport.runtime.dagger.internal.ByteVector;
import com.google.android.datatransport.runtime.dagger.internal.b;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

public final class Type
  implements b<SchedulerConfig>
{
  private final g.a.a<com.google.android.datatransport.h.a0.a> c;
  
  public Type(g.a.a paramA)
  {
    c = paramA;
  }
  
  public static Type a(g.a.a paramA)
  {
    return new Type(paramA);
  }
  
  public static SchedulerConfig a(Label paramLabel)
  {
    return (SchedulerConfig)ByteVector.get(w.a(paramLabel), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public SchedulerConfig a()
  {
    return a((Label)c.get());
  }
}
