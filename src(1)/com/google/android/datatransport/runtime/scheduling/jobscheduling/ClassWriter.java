package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.asm.util.util.m;
import com.google.android.datatransport.h.y.j.i0;
import com.google.android.datatransport.h.y.j.j0;
import java.util.concurrent.Executor;

public final class ClassWriter
  implements com.google.android.datatransport.runtime.dagger.internal.b<t>
{
  private final g.a.a<com.google.android.datatransport.h.a0.a> b;
  private final g.a.a<j0> c;
  private final g.a.a<com.google.android.datatransport.runtime.backends.e> d;
  private final g.a.a<com.google.android.datatransport.h.z.b> h;
  private final g.a.a<Executor> i;
  private final g.a.a<x> j;
  private final g.a.a<com.google.android.datatransport.h.a0.a> n;
  private final g.a.a<i0> t;
  private final g.a.a<Context> v;
  
  public ClassWriter(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3, g.a.a paramA4, g.a.a paramA5, g.a.a paramA6, g.a.a paramA7, g.a.a paramA8, g.a.a paramA9)
  {
    v = paramA1;
    d = paramA2;
    c = paramA3;
    j = paramA4;
    i = paramA5;
    h = paramA6;
    b = paramA7;
    n = paramA8;
    t = paramA9;
  }
  
  public static ClassWriter a(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3, g.a.a paramA4, g.a.a paramA5, g.a.a paramA6, g.a.a paramA7, g.a.a paramA8, g.a.a paramA9)
  {
    return new ClassWriter(paramA1, paramA2, paramA3, paramA4, paramA5, paramA6, paramA7, paramA8, paramA9);
  }
  
  public static f a(Context paramContext, com.google.android.datatransport.runtime.backends.Label paramLabel, m paramM, c paramC, Executor paramExecutor, com.google.android.datatransport.asm.params.c paramC1, com.google.android.datatransport.asm.asm.Label paramLabel1, com.google.android.datatransport.asm.asm.Label paramLabel2, com.google.android.datatransport.asm.util.util.e paramE)
  {
    return new f(paramContext, paramLabel, paramM, paramC, paramExecutor, paramC1, paramLabel1, paramLabel2, paramE);
  }
  
  public f a()
  {
    return a((Context)v.get(), (com.google.android.datatransport.runtime.backends.Label)d.get(), (m)c.get(), (c)j.get(), (Executor)i.get(), (com.google.android.datatransport.asm.params.c)h.get(), (com.google.android.datatransport.asm.asm.Label)b.get(), (com.google.android.datatransport.asm.asm.Label)n.get(), (com.google.android.datatransport.asm.util.util.e)t.get());
  }
}
