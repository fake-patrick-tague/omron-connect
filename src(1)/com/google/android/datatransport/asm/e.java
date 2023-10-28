package com.google.android.datatransport.asm;

import com.google.android.datatransport.asm.asm.Label;
import com.google.android.datatransport.asm.util.Menu;
import com.google.android.datatransport.runtime.dagger.internal.b;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Plot;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.f;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.v;

public final class e
  implements b<com.google.android.datatransport.h.t>
{
  private final g.a.a<v> a;
  private final g.a.a<com.google.android.datatransport.h.y.e> b;
  private final g.a.a<com.google.android.datatransport.h.a0.a> c;
  private final g.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.t> d;
  private final g.a.a<com.google.android.datatransport.h.a0.a> j;
  
  public e(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3, g.a.a paramA4, g.a.a paramA5)
  {
    j = paramA1;
    c = paramA2;
    b = paramA3;
    d = paramA4;
    a = paramA5;
  }
  
  public static a a(Label paramLabel1, Label paramLabel2, Menu paramMenu, f paramF, Plot paramPlot)
  {
    return new a(paramLabel1, paramLabel2, paramMenu, paramF, paramPlot);
  }
  
  public static e a(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3, g.a.a paramA4, g.a.a paramA5)
  {
    return new e(paramA1, paramA2, paramA3, paramA4, paramA5);
  }
  
  public a a()
  {
    return a((Label)j.get(), (Label)c.get(), (Menu)b.get(), (f)d.get(), (Plot)a.get());
  }
}
