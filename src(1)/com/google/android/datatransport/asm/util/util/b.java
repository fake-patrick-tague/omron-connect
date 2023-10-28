package com.google.android.datatransport.asm.util.util;

import com.google.android.datatransport.asm.asm.Label;
import com.google.android.datatransport.h.y.j.k0;
import com.google.android.datatransport.h.y.j.r0;
import com.google.android.datatransport.h.y.j.t0;

public final class b
  implements com.google.android.datatransport.runtime.dagger.internal.b<r0>
{
  private final g.a.a<t0> a;
  private final g.a.a<com.google.android.datatransport.h.a0.a> b;
  private final g.a.a<k0> c;
  private final g.a.a<String> j;
  private final g.a.a<com.google.android.datatransport.h.a0.a> l;
  
  public b(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3, g.a.a paramA4, g.a.a paramA5)
  {
    l = paramA1;
    b = paramA2;
    c = paramA3;
    a = paramA4;
    j = paramA5;
  }
  
  public static Log a(Label paramLabel1, Label paramLabel2, Object paramObject1, Object paramObject2, g.a.a paramA)
  {
    return new Log(paramLabel1, paramLabel2, (f)paramObject1, (DatabaseHelper)paramObject2, paramA);
  }
  
  public static b a(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3, g.a.a paramA4, g.a.a paramA5)
  {
    return new b(paramA1, paramA2, paramA3, paramA4, paramA5);
  }
  
  public Log a()
  {
    return a((Label)l.get(), (Label)b.get(), c.get(), a.get(), j);
  }
}
