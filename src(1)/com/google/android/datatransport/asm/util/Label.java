package com.google.android.datatransport.asm.util;

import com.google.android.datatransport.asm.util.util.m;
import com.google.android.datatransport.h.y.j.j0;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import g.a.a;
import java.util.concurrent.Executor;

public final class Label
  implements com.google.android.datatransport.runtime.dagger.internal.b<com.google.android.datatransport.h.y.c>
{
  private final a<j0> a;
  private final a<com.google.android.datatransport.h.z.b> b;
  private final a<x> c;
  private final a<Executor> i;
  private final a<e> j;
  
  public Label(a paramA1, a paramA2, a paramA3, a paramA4, a paramA5)
  {
    i = paramA1;
    j = paramA2;
    c = paramA3;
    a = paramA4;
    b = paramA5;
  }
  
  public static Label a(a paramA1, a paramA2, a paramA3, a paramA4, a paramA5)
  {
    return new Label(paramA1, paramA2, paramA3, paramA4, paramA5);
  }
  
  public static i a(Executor paramExecutor, com.google.android.datatransport.runtime.backends.Label paramLabel, com.google.android.datatransport.runtime.scheduling.jobscheduling.c paramC, m paramM, com.google.android.datatransport.asm.params.c paramC1)
  {
    return new i(paramExecutor, paramLabel, paramC, paramM, paramC1);
  }
  
  public i a()
  {
    return a((Executor)i.get(), (com.google.android.datatransport.runtime.backends.Label)j.get(), (com.google.android.datatransport.runtime.scheduling.jobscheduling.c)c.get(), (m)a.get(), (com.google.android.datatransport.asm.params.c)b.get());
  }
}
