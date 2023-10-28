package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.asm.asm.Label;
import com.google.android.datatransport.runtime.dagger.internal.b;

public final class ClassWriter
  implements b<h>
{
  private final g.a.a<com.google.android.datatransport.h.a0.a> b;
  private final g.a.a<com.google.android.datatransport.h.a0.a> c;
  private final g.a.a<Context> j;
  
  public ClassWriter(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3)
  {
    j = paramA1;
    c = paramA2;
    b = paramA3;
  }
  
  public static h a(Context paramContext, Label paramLabel1, Label paramLabel2)
  {
    return new h(paramContext, paramLabel1, paramLabel2);
  }
  
  public static ClassWriter b(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3)
  {
    return new ClassWriter(paramA1, paramA2, paramA3);
  }
  
  public h a()
  {
    return a((Context)j.get(), (Label)c.get(), (Label)b.get());
  }
}
