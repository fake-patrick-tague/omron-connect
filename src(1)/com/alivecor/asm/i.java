package com.alivecor.asm;

import com.alivecor.ai.w;
import dagger.internal.ClassWriter;
import g.a.a;

public final class i
{
  private final a<w> c;
  
  public i(a paramA)
  {
    c = paramA;
  }
  
  public static f a(MethodVisitor paramMethodVisitor)
  {
    return (f)ClassWriter.a(Frame.a(paramMethodVisitor));
  }
  
  public static i a(a paramA)
  {
    return new i(paramA);
  }
  
  public f a()
  {
    return a((MethodVisitor)c.get());
  }
}
