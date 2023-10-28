package com.google.android.datatransport.asm;

import com.google.android.datatransport.h.m;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.a;
import com.google.android.datatransport.runtime.firebase.transport.c;
import com.google.android.datatransport.runtime.firebase.transport.d;
import com.google.firebase.common.reflect.Label;

public final class RFC4519Style
  implements Label
{
  public static final Label c = new RFC4519Style();
  
  private RFC4519Style() {}
  
  public void a(com.google.firebase.common.reflect.e paramE)
  {
    paramE.a(m.class, Type.c);
    paramE.a(a.class, f.d);
    paramE.a(com.google.android.datatransport.runtime.firebase.transport.e.class, g.d);
    paramE.a(c.class, AnnotationWriter.g);
    paramE.a(LogEventDropped.class, b.c);
    paramE.a(com.google.android.datatransport.runtime.firebase.transport.b.class, w.a);
    paramE.a(d.class, ClassWriter.a);
  }
}
