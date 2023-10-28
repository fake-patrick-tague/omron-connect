package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.asm.util.util.m;
import com.google.android.datatransport.h.y.j.j0;
import g.a.a;
import java.util.concurrent.Executor;

public final class ByteVector
  implements com.google.android.datatransport.runtime.dagger.internal.b<v>
{
  private final a<Executor> a;
  private final a<x> b;
  private final a<j0> c;
  private final a<com.google.android.datatransport.h.z.b> n;
  
  public ByteVector(a paramA1, a paramA2, a paramA3, a paramA4)
  {
    a = paramA1;
    c = paramA2;
    b = paramA3;
    n = paramA4;
  }
  
  public static ByteVector a(a paramA1, a paramA2, a paramA3, a paramA4)
  {
    return new ByteVector(paramA1, paramA2, paramA3, paramA4);
  }
  
  public static Plot a(Executor paramExecutor, m paramM, c paramC, com.google.android.datatransport.asm.params.c paramC1)
  {
    return new Plot(paramExecutor, paramM, paramC, paramC1);
  }
  
  public Plot a()
  {
    return a((Executor)a.get(), (m)c.get(), (c)b.get(), (com.google.android.datatransport.asm.params.c)n.get());
  }
}
