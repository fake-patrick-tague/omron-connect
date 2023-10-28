package com.alivecor.asm;

import com.alivecor.ai.l;
import com.alivecor.ai.q;
import com.alivecor.ai.v;
import g.a.a;

public final class ClassWriter
{
  private final a<v> b;
  private final a<l> c;
  private final a<q> j;
  
  public ClassWriter(a paramA1, a paramA2, a paramA3)
  {
    j = paramA1;
    c = paramA2;
    b = paramA3;
  }
  
  public static Attribute a(o paramO, c paramC, f paramF)
  {
    return (Attribute)dagger.internal.ClassWriter.a(Frame.a(paramO, paramC, paramF));
  }
  
  public static ClassWriter visitSource(a paramA1, a paramA2, a paramA3)
  {
    return new ClassWriter(paramA1, paramA2, paramA3);
  }
  
  public Attribute a()
  {
    return a((o)j.get(), (c)c.get(), (f)b.get());
  }
}
