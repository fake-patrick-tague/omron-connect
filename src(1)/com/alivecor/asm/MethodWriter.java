package com.alivecor.asm;

import android.content.Context;

final class MethodWriter
  implements k
{
  private final MethodWriter D = this;
  private final h b;
  private final MethodVisitor f;
  private final o t;
  
  private MethodWriter(h paramH, MethodVisitor paramMethodVisitor, o paramO, Context paramContext)
  {
    t = paramO;
    f = paramMethodVisitor;
    b = paramH;
  }
  
  private f e()
  {
    return i.a(f);
  }
  
  public Attribute a()
  {
    return ClassWriter.a(t, c(), e());
  }
  
  public c c()
  {
    return ByteVector.a(b);
  }
}
