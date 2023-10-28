package androidx.core.content.asm;

import androidx.core.graphics.ColorUtils;

class m
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final float f;
  private final float j;
  private final float k;
  private final float l;
  
  m(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    j = paramFloat1;
    k = paramFloat2;
    l = paramFloat3;
    b = paramFloat4;
    e = paramFloat5;
    f = paramFloat6;
    a = paramFloat7;
    c = paramFloat8;
    d = paramFloat9;
  }
  
  private static m a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return a(paramFloat1, paramFloat2, paramFloat3, ClassWriter.u);
  }
  
  private static m a(float paramFloat1, float paramFloat2, float paramFloat3, ClassWriter paramClassWriter)
  {
    float f1 = 4.0F / paramClassWriter.c();
    double d1 = paramFloat1 / 100.0D;
    float f2 = (float)Math.sqrt(d1);
    float f3 = paramClassWriter.d();
    float f4 = paramClassWriter.put();
    float f5 = paramFloat2 * paramClassWriter.put();
    float f6 = (float)Math.sqrt(paramFloat2 / (float)Math.sqrt(d1) * paramClassWriter.c() / (paramClassWriter.d() + 4.0F));
    float f7 = 3.1415927F * paramFloat3 / 180.0F;
    float f8 = 1.7F * paramFloat1 / (0.007F * paramFloat1 + 1.0F);
    float f9 = (float)Math.log(f5 * 0.0228D + 1.0D) * 43.85965F;
    d1 = f7;
    return new m(paramFloat3, paramFloat2, paramFloat1, f1 * f2 * (f3 + 4.0F) * f4, f5, f6 * 50.0F, f8, f9 * (float)Math.cos(d1), f9 * (float)Math.sin(d1));
  }
  
  static m a(int paramInt)
  {
    return a(paramInt, ClassWriter.u);
  }
  
  static m a(int paramInt, ClassWriter paramClassWriter)
  {
    float[] arrayOfFloat = l.draw(paramInt);
    float[][] arrayOfFloat1 = l.i;
    float f13 = arrayOfFloat[0];
    float f14 = arrayOfFloat1[0][0];
    float f15 = arrayOfFloat[1];
    float f16 = arrayOfFloat1[0][1];
    float f17 = arrayOfFloat[2];
    float f18 = arrayOfFloat1[0][2];
    float f7 = arrayOfFloat[0];
    float f8 = arrayOfFloat1[1][0];
    float f9 = arrayOfFloat[1];
    float f10 = arrayOfFloat1[1][1];
    float f11 = arrayOfFloat[2];
    float f12 = arrayOfFloat1[1][2];
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat1[2][0];
    float f3 = arrayOfFloat[1];
    float f4 = arrayOfFloat1[2][1];
    float f5 = arrayOfFloat[2];
    float f6 = arrayOfFloat1[2][2];
    f13 = paramClassWriter.get()[0] * (f13 * f14 + f15 * f16 + f17 * f18);
    f7 = paramClassWriter.get()[1] * (f7 * f8 + f9 * f10 + f11 * f12);
    f2 = paramClassWriter.get()[2] * (f1 * f2 + f3 * f4 + f5 * f6);
    f1 = (float)Math.pow(paramClassWriter.newUTF8() * Math.abs(f13) / 100.0D, 0.42D);
    f4 = (float)Math.pow(paramClassWriter.newUTF8() * Math.abs(f7) / 100.0D, 0.42D);
    f3 = (float)Math.pow(paramClassWriter.newUTF8() * Math.abs(f2) / 100.0D, 0.42D);
    f1 = Math.signum(f13) * 400.0F * f1 / (f1 + 27.13F);
    f5 = Math.signum(f7) * 400.0F * f4 / (f4 + 27.13F);
    f2 = Math.signum(f2) * 400.0F * f3 / (f3 + 27.13F);
    double d1 = f1;
    double d2 = f5;
    double d3 = f2;
    f3 = (float)(d1 * 11.0D + d2 * -12.0D + d3) / 11.0F;
    f4 = (float)(f1 + f5 - d3 * 2.0D) / 9.0F;
    f5 *= 20.0F;
    f6 = (f1 * 20.0F + f5 + 21.0F * f2) / 20.0F;
    f7 = (f1 * 40.0F + f5 + f2) / 20.0F;
    f2 = (float)Math.atan2(f4, f3) * 180.0F / 3.1415927F;
    if (f2 < 0.0F) {
      f1 = f2 + 360.0F;
    }
    for (;;)
    {
      break;
      f1 = f2;
      if (f2 >= 360.0F) {
        f1 = f2 - 360.0F;
      }
    }
    f5 = 3.1415927F * f1 / 180.0F;
    f7 = (float)Math.pow(f7 * paramClassWriter.visitAnnotation() / paramClassWriter.d(), paramClassWriter.c() * paramClassWriter.b()) * 100.0F;
    f8 = 4.0F / paramClassWriter.c();
    f9 = (float)Math.sqrt(f7 / 100.0F);
    f10 = paramClassWriter.d();
    f11 = paramClassWriter.put();
    f2 = f1;
    if (f1 < 20.14D) {
      f2 = 360.0F + f1;
    }
    f2 = (float)(Math.cos(f2 * 3.141592653589793D / 180.0D + 2.0D) + 3.8D) * 0.25F * 3846.1538F * paramClassWriter.f() * paramClassWriter.a() * (float)Math.sqrt(f3 * f3 + f4 * f4) / (f6 + 0.305F);
    f4 = (float)Math.pow(1.64D - Math.pow(0.29D, paramClassWriter.visitAttribute()), 0.73D) * (float)Math.pow(f2, 0.9D);
    f2 = f4 * (float)Math.sqrt(f7 / 100.0D);
    f3 = f2 * paramClassWriter.put();
    f4 = (float)Math.sqrt(f4 * paramClassWriter.c() / (paramClassWriter.d() + 4.0F));
    f6 = 1.7F * f7 / (0.007F * f7 + 1.0F);
    f12 = (float)Math.log(0.0228F * f3 + 1.0F) * 43.85965F;
    d1 = f5;
    return new m(f1, f2, f7, f11 * (f8 * f9 * (f10 + 4.0F)), f3, f4 * 50.0F, f6, f12 * (float)Math.cos(d1), f12 * (float)Math.sin(d1));
  }
  
  static int d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return draw(paramFloat1, paramFloat2, paramFloat3, ClassWriter.u);
  }
  
  static int draw(float paramFloat1, float paramFloat2, float paramFloat3, ClassWriter paramClassWriter)
  {
    if ((paramFloat2 >= 1.0D) && (Math.round(paramFloat3) > 0.0D) && (Math.round(paramFloat3) < 100.0D))
    {
      float f1;
      if (paramFloat1 < 0.0F) {
        f1 = 0.0F;
      } else {
        f1 = Math.min(360.0F, paramFloat1);
      }
      Object localObject = null;
      int i = 1;
      float f2 = 0.0F;
      paramFloat1 = paramFloat2;
      if (Math.abs(f2 - paramFloat2) >= 0.4F)
      {
        m localM = draw(f1, paramFloat1, paramFloat3);
        if (i != 0)
        {
          if (localM != null) {
            return localM.a(paramClassWriter);
          }
          i = 0;
        }
        for (;;)
        {
          paramFloat1 = (paramFloat2 - f2) / 2.0F + f2;
          break;
          if (localM == null)
          {
            paramFloat2 = paramFloat1;
          }
          else
          {
            localObject = localM;
            f2 = paramFloat1;
          }
        }
      }
      if (localObject == null) {
        return l.draw(paramFloat3);
      }
      return localObject.a(paramClassWriter);
    }
    return l.draw(paramFloat3);
  }
  
  private static m draw(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f5 = 1000.0F;
    float f2 = 0.0F;
    Object localObject1 = null;
    float f1 = 100.0F;
    float f3 = 1000.0F;
    while (Math.abs(f2 - f1) > 0.01F)
    {
      float f6 = (f1 - f2) / 2.0F + f2;
      int i = a(f6, paramFloat2, paramFloat1).b();
      float f10 = l.a(i);
      float f9 = Math.abs(paramFloat3 - f10);
      float f7 = f5;
      Object localObject2 = localObject1;
      float f4 = f3;
      if (f9 < 0.2F)
      {
        m localM = a(i);
        float f8 = localM.a(a(localM.d(), localM.a(), paramFloat1));
        f7 = f5;
        localObject2 = localObject1;
        f4 = f3;
        if (f8 <= 1.0F)
        {
          localObject2 = localM;
          f7 = f9;
          f4 = f8;
        }
      }
      if ((f7 == 0.0F) && (f4 == 0.0F)) {
        return localObject2;
      }
      if (f10 < paramFloat3)
      {
        f2 = f6;
        f5 = f7;
        localObject1 = localObject2;
        f3 = f4;
      }
      else
      {
        f1 = f6;
        f5 = f7;
        localObject1 = localObject2;
        f3 = f4;
      }
    }
    return localObject1;
  }
  
  float a()
  {
    return k;
  }
  
  float a(m paramM)
  {
    float f1 = getItemId() - paramM.getItemId();
    float f2 = c() - paramM.c();
    float f3 = e() - paramM.e();
    return (float)(Math.pow(Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3), 0.63D) * 1.41D);
  }
  
  int a(ClassWriter paramClassWriter)
  {
    if ((a() != 0.0D) && (d() != 0.0D)) {
      f1 = a() / (float)Math.sqrt(d() / 100.0D);
    } else {
      f1 = 0.0F;
    }
    float f2 = (float)Math.pow(f1 / Math.pow(1.64D - Math.pow(0.29D, paramClassWriter.visitAttribute()), 0.73D), 1.1111111111111112D);
    double d1 = h() * 3.1415927F / 180.0F;
    float f3 = (float)(Math.cos(2.0D + d1) + 3.8D);
    float f1 = paramClassWriter.d();
    float f6 = (float)Math.pow(d() / 100.0D, 1.0D / paramClassWriter.c() / paramClassWriter.b());
    float f4 = paramClassWriter.f();
    float f5 = paramClassWriter.a();
    f1 = f1 * f6 / paramClassWriter.visitAnnotation();
    f6 = (float)Math.sin(d1);
    float f7 = (float)Math.cos(d1);
    f3 = (0.305F + f1) * 23.0F * f2 / (f3 * 0.25F * 3846.1538F * f4 * f5 * 23.0F + 11.0F * f2 * f7 + f2 * 108.0F * f6);
    f2 = f7 * f3;
    f3 *= f6;
    f5 = f1 * 460.0F;
    f1 = (451.0F * f2 + f5 + 288.0F * f3) / 1403.0F;
    f4 = (f5 - 891.0F * f2 - 261.0F * f3) / 1403.0F;
    f6 = (f5 - f2 * 220.0F - f3 * 6300.0F) / 1403.0F;
    f3 = (float)Math.max(0.0D, Math.abs(f1) * 27.13D / (400.0D - Math.abs(f1)));
    f1 = Math.signum(f1);
    f2 = 100.0F / paramClassWriter.newUTF8();
    f3 = (float)Math.pow(f3, 2.380952380952381D);
    f7 = (float)Math.max(0.0D, Math.abs(f4) * 27.13D / (400.0D - Math.abs(f4)));
    f4 = Math.signum(f4);
    f5 = 100.0F / paramClassWriter.newUTF8();
    f7 = (float)Math.pow(f7, 2.380952380952381D);
    float f9 = (float)Math.max(0.0D, Math.abs(f6) * 27.13D / (400.0D - Math.abs(f6)));
    f6 = Math.signum(f6);
    float f8 = 100.0F / paramClassWriter.newUTF8();
    f9 = (float)Math.pow(f9, 2.380952380952381D);
    f1 = f1 * f2 * f3 / paramClassWriter.get()[0];
    f2 = f4 * f5 * f7 / paramClassWriter.get()[1];
    f3 = f6 * f8 * f9 / paramClassWriter.get()[2];
    paramClassWriter = l.k;
    f4 = paramClassWriter[0][0];
    f5 = paramClassWriter[0][1];
    f6 = paramClassWriter[0][2];
    f7 = paramClassWriter[1][0];
    f8 = paramClassWriter[1][1];
    f9 = paramClassWriter[1][2];
    float f10 = paramClassWriter[2][0];
    float f11 = paramClassWriter[2][1];
    float f12 = paramClassWriter[2][2];
    return ColorUtils.XYZToColor(f4 * f1 + f5 * f2 + f6 * f3, f7 * f1 + f8 * f2 + f9 * f3, f1 * f10 + f2 * f11 + f3 * f12);
  }
  
  int b()
  {
    return a(ClassWriter.u);
  }
  
  float c()
  {
    return c;
  }
  
  float d()
  {
    return l;
  }
  
  float e()
  {
    return d;
  }
  
  float getItemId()
  {
    return a;
  }
  
  float h()
  {
    return j;
  }
}
