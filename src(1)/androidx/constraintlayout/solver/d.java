package androidx.constraintlayout.solver;

import java.util.Arrays;

public class d
  implements i
{
  private static float i;
  private float[] a = new float[8];
  private int[] b = new int[8];
  private final h e;
  private boolean f = false;
  private int g = -1;
  protected final Item j;
  private int k = -1;
  int m = 0;
  private int[] n = new int[8];
  private SolverVariable o = null;
  private int q = 8;
  
  d(h paramH, Item paramItem)
  {
    e = paramH;
    j = paramItem;
  }
  
  public final float a(SolverVariable paramSolverVariable)
  {
    int i2 = k;
    int i1 = 0;
    while ((i2 != -1) && (i1 < m))
    {
      if (n[i2] == b) {
        return a[i2];
      }
      i2 = b[i2];
      i1 += 1;
    }
    return 0.0F;
  }
  
  public final float a(SolverVariable paramSolverVariable, boolean paramBoolean)
  {
    if (o == paramSolverVariable) {
      o = null;
    }
    int i1 = k;
    if (i1 == -1) {
      return 0.0F;
    }
    int i2 = 0;
    int i3 = -1;
    while ((i1 != -1) && (i2 < m))
    {
      if (n[i1] == b)
      {
        if (i1 == k)
        {
          k = b[i1];
        }
        else
        {
          arrayOfInt = b;
          arrayOfInt[i3] = arrayOfInt[i1];
        }
        if (paramBoolean) {
          paramSolverVariable.a(e);
        }
        h -= 1;
        m -= 1;
        n[i1] = -1;
        if (f) {
          g = i1;
        }
        return a[i1];
      }
      int[] arrayOfInt = b;
      i2 += 1;
      i3 = i1;
      i1 = arrayOfInt[i1];
    }
    return 0.0F;
  }
  
  public float a(h paramH, boolean paramBoolean)
  {
    float f1 = a(c);
    a(c, paramBoolean);
    paramH = b;
    int i2 = paramH.f();
    int i1 = 0;
    while (i1 < i2)
    {
      SolverVariable localSolverVariable = paramH.a(i1);
      a(localSolverVariable, paramH.a(localSolverVariable) * f1, paramBoolean);
      i1 += 1;
    }
    return f1;
  }
  
  public SolverVariable a(int paramInt)
  {
    int i2 = k;
    int i1 = 0;
    while ((i2 != -1) && (i1 < m))
    {
      if (i1 == paramInt) {
        return j.n[n[i2]];
      }
      i2 = b[i2];
      i1 += 1;
    }
    return null;
  }
  
  public void a()
  {
    int i2 = k;
    int i1 = 0;
    while ((i2 != -1) && (i1 < m))
    {
      float[] arrayOfFloat = a;
      arrayOfFloat[i2] *= -1.0F;
      i2 = b[i2];
      i1 += 1;
    }
  }
  
  public void a(float paramFloat)
  {
    int i2 = k;
    int i1 = 0;
    while ((i2 != -1) && (i1 < m))
    {
      float[] arrayOfFloat = a;
      arrayOfFloat[i2] /= paramFloat;
      i2 = b[i2];
      i1 += 1;
    }
  }
  
  public final void a(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      a(paramSolverVariable, true);
      return;
    }
    int i1 = k;
    if (i1 == -1)
    {
      k = 0;
      a[0] = paramFloat;
      n[0] = b;
      b[0] = -1;
      h += 1;
      paramSolverVariable.c(e);
      m += 1;
      if (!f)
      {
        i1 = g + 1;
        g = i1;
        paramSolverVariable = n;
        if (i1 >= paramSolverVariable.length)
        {
          f = true;
          g = (paramSolverVariable.length - 1);
        }
      }
    }
    else
    {
      int i2 = 0;
      int i4 = -1;
      int i3;
      while ((i1 != -1) && (i2 < m))
      {
        arrayOfInt = n;
        int i5 = arrayOfInt[i1];
        i3 = b;
        if (i5 == i3)
        {
          a[i1] = paramFloat;
          return;
        }
        if (arrayOfInt[i1] < i3) {
          i4 = i1;
        }
        i1 = b[i1];
        i2 += 1;
      }
      i1 = g;
      if (f)
      {
        arrayOfInt = n;
        if (arrayOfInt[i1] != -1) {
          i1 = arrayOfInt.length;
        }
      }
      else
      {
        i1 += 1;
      }
      int[] arrayOfInt = n;
      i2 = i1;
      if (i1 >= arrayOfInt.length)
      {
        i2 = i1;
        if (m < arrayOfInt.length)
        {
          i3 = 0;
          for (;;)
          {
            arrayOfInt = n;
            i2 = i1;
            if (i3 >= arrayOfInt.length) {
              break;
            }
            if (arrayOfInt[i3] == -1)
            {
              i2 = i3;
              break;
            }
            i3 += 1;
          }
        }
      }
      arrayOfInt = n;
      i1 = i2;
      if (i2 >= arrayOfInt.length)
      {
        i1 = arrayOfInt.length;
        i2 = q * 2;
        q = i2;
        f = false;
        g = (i1 - 1);
        a = Arrays.copyOf(a, i2);
        n = Arrays.copyOf(n, q);
        b = Arrays.copyOf(b, q);
      }
      n[i1] = b;
      a[i1] = paramFloat;
      if (i4 != -1)
      {
        arrayOfInt = b;
        arrayOfInt[i1] = arrayOfInt[i4];
        arrayOfInt[i4] = i1;
      }
      else
      {
        b[i1] = k;
        k = i1;
      }
      h += 1;
      paramSolverVariable.c(e);
      i1 = m + 1;
      m = i1;
      if (!f) {
        g += 1;
      }
      paramSolverVariable = n;
      if (i1 >= paramSolverVariable.length) {
        f = true;
      }
      if (g >= paramSolverVariable.length)
      {
        f = true;
        g = (paramSolverVariable.length - 1);
      }
    }
  }
  
  public void a(SolverVariable paramSolverVariable, float paramFloat, boolean paramBoolean)
  {
    float f1 = i;
    if ((paramFloat > -f1) && (paramFloat < f1)) {
      return;
    }
    int i1 = k;
    if (i1 == -1)
    {
      k = 0;
      a[0] = paramFloat;
      n[0] = b;
      b[0] = -1;
      h += 1;
      paramSolverVariable.c(e);
      m += 1;
      if (!f)
      {
        i1 = g + 1;
        g = i1;
        paramSolverVariable = n;
        if (i1 >= paramSolverVariable.length)
        {
          f = true;
          g = (paramSolverVariable.length - 1);
        }
      }
    }
    else
    {
      int i2 = 0;
      int i4 = -1;
      int i3;
      while ((i1 != -1) && (i2 < m))
      {
        localObject = n;
        int i5 = localObject[i1];
        i3 = b;
        if (i5 == i3)
        {
          localObject = a;
          f1 = localObject[i1] + paramFloat;
          float f2 = i;
          paramFloat = f1;
          if (f1 > -f2)
          {
            paramFloat = f1;
            if (f1 < f2) {
              paramFloat = 0.0F;
            }
          }
          localObject[i1] = paramFloat;
          if (paramFloat != 0.0F) {
            return;
          }
          if (i1 == k)
          {
            k = b[i1];
          }
          else
          {
            localObject = b;
            localObject[i4] = localObject[i1];
          }
          if (paramBoolean) {
            paramSolverVariable.a(e);
          }
          if (f) {
            g = i1;
          }
          h -= 1;
          m -= 1;
          return;
        }
        if (localObject[i1] < i3) {
          i4 = i1;
        }
        i1 = b[i1];
        i2 += 1;
      }
      i1 = g;
      if (f)
      {
        localObject = n;
        if (localObject[i1] != -1) {
          i1 = localObject.length;
        }
      }
      else
      {
        i1 += 1;
      }
      Object localObject = n;
      i2 = i1;
      if (i1 >= localObject.length)
      {
        i2 = i1;
        if (m < localObject.length)
        {
          i3 = 0;
          for (;;)
          {
            localObject = n;
            i2 = i1;
            if (i3 >= localObject.length) {
              break;
            }
            if (localObject[i3] == -1)
            {
              i2 = i3;
              break;
            }
            i3 += 1;
          }
        }
      }
      localObject = n;
      i1 = i2;
      if (i2 >= localObject.length)
      {
        i1 = localObject.length;
        i2 = q * 2;
        q = i2;
        f = false;
        g = (i1 - 1);
        a = Arrays.copyOf(a, i2);
        n = Arrays.copyOf(n, q);
        b = Arrays.copyOf(b, q);
      }
      n[i1] = b;
      a[i1] = paramFloat;
      if (i4 != -1)
      {
        localObject = b;
        localObject[i1] = localObject[i4];
        localObject[i4] = i1;
      }
      else
      {
        b[i1] = k;
        k = i1;
      }
      h += 1;
      paramSolverVariable.c(e);
      m += 1;
      if (!f) {
        g += 1;
      }
      i1 = g;
      paramSolverVariable = n;
      if (i1 >= paramSolverVariable.length)
      {
        f = true;
        g = (paramSolverVariable.length - 1);
      }
    }
  }
  
  public float b(int paramInt)
  {
    int i2 = k;
    int i1 = 0;
    while ((i2 != -1) && (i1 < m))
    {
      if (i1 == paramInt) {
        return a[i2];
      }
      i2 = b[i2];
      i1 += 1;
    }
    return 0.0F;
  }
  
  public boolean c(SolverVariable paramSolverVariable)
  {
    int i2 = k;
    if (i2 == -1) {
      return false;
    }
    int i1 = 0;
    while ((i2 != -1) && (i1 < m))
    {
      if (n[i2] == b) {
        return true;
      }
      i2 = b[i2];
      i1 += 1;
    }
    return false;
  }
  
  public final void clear()
  {
    int i2 = k;
    int i1 = 0;
    while ((i2 != -1) && (i1 < m))
    {
      SolverVariable localSolverVariable = j.n[n[i2]];
      if (localSolverVariable != null) {
        localSolverVariable.a(e);
      }
      i2 = b[i2];
      i1 += 1;
    }
    k = -1;
    g = -1;
    f = false;
    m = 0;
  }
  
  public int f()
  {
    return m;
  }
  
  public String toString()
  {
    int i2 = k;
    String str = "";
    int i1 = 0;
    while ((i2 != -1) && (i1 < m))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" -> ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(a[i2]);
      localStringBuilder.append(" : ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(j.n[n[i2]]);
      str = localStringBuilder.toString();
      i2 = b[i2];
      i1 += 1;
    }
    return str;
  }
}
