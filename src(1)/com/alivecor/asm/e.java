package com.alivecor.asm;

import android.content.Context;
import com.alivecor.ai.m;
import com.alivecor.ai.q;
import com.alivecor.ai.w;
import dagger.internal.ClassWriter;

final class e
  implements g
{
  private Context a;
  private h b;
  private MethodVisitor d;
  private o f;
  
  private e() {}
  
  public k a()
  {
    ClassWriter.put(b, m.class);
    ClassWriter.put(d, w.class);
    ClassWriter.put(f, q.class);
    ClassWriter.put(a, Context.class);
    return new MethodWriter(b, d, f, a, null);
  }
  
  public e b(Context paramContext)
  {
    a = ((Context)ClassWriter.create(paramContext));
    return this;
  }
  
  public e b(MethodVisitor paramMethodVisitor)
  {
    d = ((MethodVisitor)ClassWriter.create(paramMethodVisitor));
    return this;
  }
  
  public e b(h paramH)
  {
    b = ((h)ClassWriter.create(paramH));
    return this;
  }
  
  public e b(o paramO)
  {
    f = ((o)ClassWriter.create(paramO));
    return this;
  }
}
