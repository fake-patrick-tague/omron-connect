package com.google.android.material.bottomappbar;

import org.org.org.ui.asm.ClassWriter;
import org.org.org.ui.asm.a;

public class MethodWriter
  extends a
  implements Cloneable
{
  private float b;
  private float c;
  private float f;
  private float g;
  private float t;
  
  void a(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      c = paramFloat;
      return;
    }
    throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, ClassWriter paramClassWriter)
  {
    float f1 = b;
    if (f1 == 0.0F)
    {
      paramClassWriter.a(paramFloat1, 0.0F);
      return;
    }
    f1 = (t * 2.0F + f1) / 2.0F;
    float f2 = paramFloat3 * f;
    paramFloat2 += g;
    paramFloat3 = c * paramFloat3 + (1.0F - paramFloat3) * f1;
    if (paramFloat3 / f1 >= 1.0F)
    {
      paramClassWriter.a(paramFloat1, 0.0F);
      return;
    }
    float f3 = f1 + f2;
    float f5 = paramFloat3 + f2;
    float f6 = (float)Math.sqrt(f3 * f3 - f5 * f5);
    f3 = paramFloat2 - f6;
    float f4 = paramFloat2 + f6;
    f5 = (float)Math.toDegrees(Math.atan(f6 / f5));
    f6 = 90.0F - f5;
    paramClassWriter.a(f3, 0.0F);
    float f7 = f2 * 2.0F;
    paramClassWriter.a(f3 - f2, 0.0F, f3 + f2, f7, 270.0F, f5);
    paramClassWriter.a(paramFloat2 - f1, -f1 - paramFloat3, paramFloat2 + f1, f1 - paramFloat3, 180.0F - f6, f6 * 2.0F - 180.0F);
    paramClassWriter.a(f4 - f2, 0.0F, f4 + f2, f7, 270.0F - f5, f5);
    paramClassWriter.a(paramFloat1, 0.0F);
  }
  
  public float b()
  {
    return b;
  }
  
  void b(float paramFloat)
  {
    g = paramFloat;
  }
  
  float c()
  {
    return c;
  }
  
  float e()
  {
    return t;
  }
  
  public void e(float paramFloat)
  {
    b = paramFloat;
  }
  
  float f()
  {
    return f;
  }
  
  void visitMaxs(float paramFloat)
  {
    t = paramFloat;
  }
  
  void visitVarInsn(float paramFloat)
  {
    f = paramFloat;
  }
}
