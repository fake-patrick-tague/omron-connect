package com.google.android.datatransport.asm;

import android.content.Context;
import com.google.android.datatransport.asm.util.Label;
import com.google.android.datatransport.asm.util.util.DynamicTableModel.a;
import com.google.android.datatransport.asm.util.util.b;
import com.google.android.datatransport.asm.util.util.h;
import com.google.android.datatransport.asm.util.util.m;
import com.google.android.datatransport.h.y.j.r0;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.v;
import java.util.concurrent.Executor;

final class MethodWriter
  extends i
{
  private g.a.a<Executor> b;
  private g.a.a<Context> c;
  private g.a.a f;
  private g.a.a g;
  private g.a.a j;
  private g.a.a<String> k;
  private g.a.a<v> m;
  private g.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.t> n;
  private g.a.a<SchedulerConfig> q;
  private g.a.a<com.google.android.datatransport.h.t> r;
  private g.a.a<com.google.android.datatransport.h.y.c> s;
  private g.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.x> t;
  private g.a.a<r0> x;
  
  private MethodWriter(Context paramContext)
  {
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    b = com.google.android.datatransport.runtime.dagger.internal.ClassWriter.a(q.a());
    paramContext = com.google.android.datatransport.runtime.dagger.internal.Type.a(paramContext);
    c = paramContext;
    paramContext = com.google.android.datatransport.runtime.backends.ClassWriter.b(paramContext, com.google.android.datatransport.asm.asm.c.b(), com.google.android.datatransport.asm.asm.ByteVector.a());
    g = paramContext;
    f = com.google.android.datatransport.runtime.dagger.internal.ClassWriter.a(com.google.android.datatransport.runtime.backends.ByteVector.b(c, paramContext));
    j = DynamicTableModel.a.next(c, h.c(), com.google.android.datatransport.asm.util.util.ClassWriter.getPaddingLeft());
    k = com.google.android.datatransport.runtime.dagger.internal.ClassWriter.a(com.google.android.datatransport.asm.util.util.ByteVector.a(c));
    x = com.google.android.datatransport.runtime.dagger.internal.ClassWriter.a(b.a(com.google.android.datatransport.asm.asm.c.b(), com.google.android.datatransport.asm.asm.ByteVector.a(), com.google.android.datatransport.asm.util.util.c.valueOf(), j, k));
    paramContext = com.google.android.datatransport.asm.util.Type.a(com.google.android.datatransport.asm.asm.c.b());
    q = paramContext;
    paramContext = com.google.android.datatransport.asm.util.e.a(c, x, paramContext, com.google.android.datatransport.asm.asm.ByteVector.a());
    t = paramContext;
    g.a.a localA1 = b;
    g.a.a localA2 = f;
    g.a.a localA3 = x;
    s = Label.a(localA1, localA2, paramContext, localA3, localA3);
    paramContext = c;
    localA1 = f;
    localA2 = x;
    n = com.google.android.datatransport.runtime.scheduling.jobscheduling.ClassWriter.a(paramContext, localA1, localA2, t, b, localA2, com.google.android.datatransport.asm.asm.c.b(), com.google.android.datatransport.asm.asm.ByteVector.a(), x);
    paramContext = b;
    localA1 = x;
    m = com.google.android.datatransport.runtime.scheduling.jobscheduling.ByteVector.a(paramContext, localA1, t, localA1);
    r = com.google.android.datatransport.runtime.dagger.internal.ClassWriter.a(e.a(com.google.android.datatransport.asm.asm.c.b(), com.google.android.datatransport.asm.asm.ByteVector.a(), s, n, m));
  }
  
  public static x b()
  {
    return new d(null);
  }
  
  a a()
  {
    return (a)r.get();
  }
  
  m c()
  {
    return (m)x.get();
  }
}
