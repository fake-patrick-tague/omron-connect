package com.alivecor.asm;

import com.alivecor.ai.m;
import dagger.internal.ClassWriter;
import g.a.a;

public final class ByteVector
{
  private final a<m> b;
  
  public ByteVector(a paramA)
  {
    b = paramA;
  }
  
  public static ByteVector a(a paramA)
  {
    return new ByteVector(paramA);
  }
  
  public static c a(h paramH)
  {
    return (c)ClassWriter.a(Frame.c(paramH));
  }
  
  public c a()
  {
    return a((h)b.get());
  }
}
