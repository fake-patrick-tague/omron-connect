package androidx.constraintlayout.solver;

import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable
{
  private static int o;
  HashSet<b> N = null;
  public float a;
  public int b = -1;
  public boolean c = false;
  float[] d = new float[9];
  int e = -1;
  int f = -1;
  float g = 0.0F;
  public int h = 0;
  boolean i = false;
  float[] j = new float[9];
  h[] k = new h[16];
  int n = 0;
  private String p;
  Type q;
  public int r = 0;
  public boolean t;
  
  public SolverVariable(Type paramType, String paramString)
  {
    q = paramType;
  }
  
  static void b()
  {
    o += 1;
  }
  
  public void a()
  {
    p = null;
    q = Type.m;
    r = 0;
    b = -1;
    f = -1;
    a = 0.0F;
    c = false;
    i = false;
    e = -1;
    g = 0.0F;
    int i1 = n;
    int m = 0;
    while (m < i1)
    {
      k[m] = null;
      m += 1;
    }
    n = 0;
    h = 0;
    t = false;
    Arrays.fill(j, 0.0F);
  }
  
  public void a(ClassWriter paramClassWriter, float paramFloat)
  {
    a = paramFloat;
    c = true;
    i = false;
    e = -1;
    g = 0.0F;
    int i1 = n;
    f = -1;
    int m = 0;
    while (m < i1)
    {
      k[m].a(paramClassWriter, this, false);
      m += 1;
    }
    n = 0;
  }
  
  public final void a(ClassWriter paramClassWriter, h paramH)
  {
    int i1 = n;
    int m = 0;
    while (m < i1)
    {
      k[m].a(paramClassWriter, paramH, false);
      m += 1;
    }
    n = 0;
  }
  
  public final void a(h paramH)
  {
    int i2 = n;
    int m = 0;
    while (m < i2)
    {
      if (k[m] == paramH)
      {
        while (m < i2 - 1)
        {
          paramH = k;
          int i1 = m + 1;
          paramH[m] = paramH[i1];
          m = i1;
        }
        n -= 1;
        return;
      }
      m += 1;
    }
  }
  
  public final void c(h paramH)
  {
    int m = 0;
    int i1;
    for (;;)
    {
      i1 = n;
      if (m >= i1) {
        break;
      }
      if (k[m] == paramH) {
        return;
      }
      m += 1;
    }
    h[] arrayOfH = k;
    if (i1 >= arrayOfH.length) {
      k = ((h[])Arrays.copyOf(arrayOfH, arrayOfH.length * 2));
    }
    arrayOfH = k;
    m = n;
    arrayOfH[m] = paramH;
    n = (m + 1);
  }
  
  public void d(Type paramType, String paramString)
  {
    q = paramType;
  }
  
  public String toString()
  {
    if (p != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(p);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
  
  public static enum Type
  {
    static
    {
      Type localType1 = new Type("UNRESTRICTED", 0);
      u = localType1;
      Type localType2 = new Type("CONSTANT", 1);
      l = localType2;
      Type localType3 = new Type("SLACK", 2);
      b = localType3;
      Type localType4 = new Type("ERROR", 3);
      q = localType4;
      Type localType5 = new Type("UNKNOWN", 4);
      m = localType5;
      c = new Type[] { localType1, localType2, localType3, localType4, localType5 };
    }
  }
}
