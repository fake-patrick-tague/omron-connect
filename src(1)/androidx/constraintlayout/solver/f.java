package androidx.constraintlayout.solver;

import java.util.Arrays;

public class f
  implements i
{
  private static float h;
  private int a = 16;
  int[] b = new int[16];
  float[] c = new float[16];
  int[] d = new int[16];
  int[] e = new int[16];
  private final h g;
  int i = -1;
  protected final Item j;
  private int k = 16;
  private final int l = -1;
  int m = 0;
  int[] n = new int[16];
  int[] s = new int[16];
  
  f(h paramH, Item paramItem)
  {
    g = paramH;
    j = paramItem;
    clear();
  }
  
  private void a(int paramInt, SolverVariable paramSolverVariable, float paramFloat)
  {
    int i1 = c();
    b(i1, paramSolverVariable, paramFloat);
    if (paramInt != -1)
    {
      s[i1] = paramInt;
      arrayOfInt = e;
      arrayOfInt[i1] = arrayOfInt[paramInt];
      arrayOfInt[paramInt] = i1;
    }
    else
    {
      s[i1] = -1;
      if (m > 0)
      {
        e[i1] = i;
        i = i1;
      }
      else
      {
        e[i1] = -1;
      }
    }
    int[] arrayOfInt = e;
    if (arrayOfInt[i1] != -1) {
      s[arrayOfInt[i1]] = i1;
    }
    a(paramSolverVariable, i1);
  }
  
  private void a(SolverVariable paramSolverVariable, int paramInt)
  {
    int i3 = b % k;
    paramSolverVariable = n;
    int i2 = paramSolverVariable[i3];
    int i1 = i2;
    if (i2 == -1)
    {
      paramSolverVariable[i3] = paramInt;
    }
    else
    {
      for (;;)
      {
        paramSolverVariable = b;
        if (paramSolverVariable[i1] == -1) {
          break;
        }
        i1 = paramSolverVariable[i1];
      }
      paramSolverVariable[i1] = paramInt;
    }
    b[paramInt] = -1;
  }
  
  private void b()
  {
    int i2 = a * 2;
    d = Arrays.copyOf(d, i2);
    c = Arrays.copyOf(c, i2);
    s = Arrays.copyOf(s, i2);
    e = Arrays.copyOf(e, i2);
    b = Arrays.copyOf(b, i2);
    int i1 = a;
    while (i1 < i2)
    {
      d[i1] = -1;
      b[i1] = -1;
      i1 += 1;
    }
    a = i2;
  }
  
  private void b(int paramInt, SolverVariable paramSolverVariable, float paramFloat)
  {
    d[paramInt] = b;
    c[paramInt] = paramFloat;
    s[paramInt] = -1;
    e[paramInt] = -1;
    paramSolverVariable.c(g);
    h += 1;
    m += 1;
  }
  
  private int c()
  {
    int i1 = 0;
    while (i1 < a)
    {
      if (d[i1] == -1) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void d(SolverVariable paramSolverVariable)
  {
    int i3 = b;
    int i4 = i3 % k;
    paramSolverVariable = n;
    int i2 = paramSolverVariable[i4];
    if (i2 == -1) {
      return;
    }
    int i1 = i2;
    if (d[i2] == i3)
    {
      int[] arrayOfInt = b;
      paramSolverVariable[i4] = arrayOfInt[i2];
      arrayOfInt[i2] = -1;
      return;
    }
    for (;;)
    {
      paramSolverVariable = b;
      if ((paramSolverVariable[i1] == -1) || (d[paramSolverVariable[i1]] == i3)) {
        break;
      }
      i1 = paramSolverVariable[i1];
    }
    i2 = paramSolverVariable[i1];
    if ((i2 != -1) && (d[i2] == i3))
    {
      paramSolverVariable[i1] = paramSolverVariable[i2];
      paramSolverVariable[i2] = -1;
    }
  }
  
  public float a(SolverVariable paramSolverVariable)
  {
    int i1 = b(paramSolverVariable);
    if (i1 != -1) {
      return c[i1];
    }
    return 0.0F;
  }
  
  public float a(SolverVariable paramSolverVariable, boolean paramBoolean)
  {
    int i1 = b(paramSolverVariable);
    if (i1 == -1) {
      return 0.0F;
    }
    d(paramSolverVariable);
    float f = c[i1];
    if (i == i1) {
      i = e[i1];
    }
    d[i1] = -1;
    int[] arrayOfInt1 = s;
    if (arrayOfInt1[i1] != -1)
    {
      arrayOfInt2 = e;
      arrayOfInt2[arrayOfInt1[i1]] = arrayOfInt2[i1];
    }
    int[] arrayOfInt2 = e;
    if (arrayOfInt2[i1] != -1) {
      arrayOfInt1[arrayOfInt2[i1]] = arrayOfInt1[i1];
    }
    m -= 1;
    h -= 1;
    if (paramBoolean) {
      paramSolverVariable.a(g);
    }
    return f;
  }
  
  public float a(h paramH, boolean paramBoolean)
  {
    float f1 = a(c);
    a(c, paramBoolean);
    paramH = (f)b;
    int i4 = paramH.f();
    int i2 = 0;
    int i1 = 0;
    while (i2 < i4)
    {
      int[] arrayOfInt = d;
      int i3 = i2;
      if (arrayOfInt[i1] != -1)
      {
        float f2 = c[i1];
        a(j.n[arrayOfInt[i1]], f2 * f1, paramBoolean);
        i3 = i2 + 1;
      }
      i1 += 1;
      i2 = i3;
    }
    return f1;
  }
  
  public SolverVariable a(int paramInt)
  {
    int i3 = m;
    if (i3 == 0) {
      return null;
    }
    int i2 = i;
    int i1 = 0;
    while (i1 < i3)
    {
      if ((i1 == paramInt) && (i2 != -1)) {
        return j.n[d[i2]];
      }
      i2 = e[i2];
      if (i2 == -1) {
        return null;
      }
      i1 += 1;
    }
    return null;
  }
  
  public void a()
  {
    int i3 = m;
    int i2 = i;
    int i1 = 0;
    while (i1 < i3)
    {
      float[] arrayOfFloat = c;
      arrayOfFloat[i2] *= -1.0F;
      i2 = e[i2];
      if (i2 == -1) {
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(float paramFloat)
  {
    int i3 = m;
    int i2 = i;
    int i1 = 0;
    while (i1 < i3)
    {
      float[] arrayOfFloat = c;
      arrayOfFloat[i2] /= paramFloat;
      i2 = e[i2];
      if (i2 == -1) {
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(SolverVariable paramSolverVariable, float paramFloat)
  {
    float f = h;
    if ((paramFloat > -f) && (paramFloat < f))
    {
      a(paramSolverVariable, true);
      return;
    }
    int i1 = m;
    int i3 = 0;
    if (i1 == 0)
    {
      b(0, paramSolverVariable, paramFloat);
      a(paramSolverVariable, 0);
      i = 0;
      return;
    }
    i1 = b(paramSolverVariable);
    if (i1 != -1)
    {
      c[i1] = paramFloat;
      return;
    }
    if (m + 1 >= a) {
      b();
    }
    int i5 = m;
    i1 = i;
    int i2 = -1;
    int i4;
    for (;;)
    {
      i4 = i2;
      if (i3 >= i5) {
        break;
      }
      int[] arrayOfInt = d;
      int i6 = arrayOfInt[i1];
      i4 = b;
      if (i6 == i4)
      {
        c[i1] = paramFloat;
        return;
      }
      if (arrayOfInt[i1] < i4) {
        i2 = i1;
      }
      i1 = e[i1];
      if (i1 == -1)
      {
        i4 = i2;
        break;
      }
      i3 += 1;
    }
    a(i4, paramSolverVariable, paramFloat);
  }
  
  public void a(SolverVariable paramSolverVariable, float paramFloat, boolean paramBoolean)
  {
    float f = h;
    if ((paramFloat > -f) && (paramFloat < f)) {
      return;
    }
    int i1 = b(paramSolverVariable);
    if (i1 == -1)
    {
      a(paramSolverVariable, paramFloat);
      return;
    }
    float[] arrayOfFloat = c;
    arrayOfFloat[i1] += paramFloat;
    paramFloat = arrayOfFloat[i1];
    f = h;
    if ((paramFloat > -f) && (arrayOfFloat[i1] < f))
    {
      arrayOfFloat[i1] = 0.0F;
      a(paramSolverVariable, paramBoolean);
    }
  }
  
  public float b(int paramInt)
  {
    int i3 = m;
    int i2 = i;
    int i1 = 0;
    while (i1 < i3)
    {
      if (i1 == paramInt) {
        return c[i2];
      }
      i2 = e[i2];
      if (i2 == -1) {
        break;
      }
      i1 += 1;
    }
    return 0.0F;
  }
  
  public int b(SolverVariable paramSolverVariable)
  {
    if (m != 0)
    {
      if (paramSolverVariable == null) {
        return -1;
      }
      int i3 = b;
      int i1 = k;
      int i2 = n[(i3 % i1)];
      if (i2 == -1) {
        return -1;
      }
      i1 = i2;
      if (d[i2] == i3) {
        return i2;
      }
      for (;;)
      {
        paramSolverVariable = b;
        if ((paramSolverVariable[i1] == -1) || (d[paramSolverVariable[i1]] == i3)) {
          break;
        }
        i1 = paramSolverVariable[i1];
      }
      if (paramSolverVariable[i1] == -1) {
        return -1;
      }
      if (d[paramSolverVariable[i1]] == i3) {
        return paramSolverVariable[i1];
      }
    }
    return -1;
  }
  
  public boolean c(SolverVariable paramSolverVariable)
  {
    return b(paramSolverVariable) != -1;
  }
  
  public void clear()
  {
    int i2 = m;
    int i1 = 0;
    while (i1 < i2)
    {
      SolverVariable localSolverVariable = a(i1);
      if (localSolverVariable != null) {
        localSolverVariable.a(g);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < a)
    {
      d[i1] = -1;
      b[i1] = -1;
      i1 += 1;
    }
    i1 = 0;
    while (i1 < k)
    {
      n[i1] = -1;
      i1 += 1;
    }
    m = 0;
    i = -1;
  }
  
  public int f()
  {
    return m;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(hashCode());
    ((StringBuilder)localObject1).append(" { ");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i2 = m;
    int i1 = 0;
    while (i1 < i2)
    {
      localObject2 = a(i1);
      if (localObject2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" = ");
        localStringBuilder.append(b(i1));
        localStringBuilder.append(" ");
        localObject1 = localStringBuilder.toString();
        int i3 = b((SolverVariable)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("[p: ");
        localObject1 = ((StringBuilder)localObject2).toString();
        if (s[i3] != -1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(j.n[d[s[i3]]]);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("none");
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", n: ");
        localObject1 = ((StringBuilder)localObject2).toString();
        if (e[i3] != -1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(j.n[d[e[i3]]]);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("none");
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      i1 += 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" }");
    return ((StringBuilder)localObject2).toString();
  }
}
