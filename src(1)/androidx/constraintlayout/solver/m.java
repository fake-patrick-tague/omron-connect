package androidx.constraintlayout.solver;

import java.util.Arrays;

public class m
  extends h
{
  private SolverVariable[] a = new SolverVariable['?'];
  private SolverVariable[] b = new SolverVariable['?'];
  private int c = 0;
  Item i;
  Label j = new Label(this, this);
  private int x = 128;
  
  public m(Item paramItem)
  {
    super(paramItem);
    i = paramItem;
  }
  
  private final void d(SolverVariable paramSolverVariable)
  {
    int k = c;
    SolverVariable[] arrayOfSolverVariable = b;
    if (k + 1 > arrayOfSolverVariable.length)
    {
      arrayOfSolverVariable = (SolverVariable[])Arrays.copyOf(arrayOfSolverVariable, arrayOfSolverVariable.length * 2);
      b = arrayOfSolverVariable;
      a = ((SolverVariable[])Arrays.copyOf(arrayOfSolverVariable, arrayOfSolverVariable.length * 2));
    }
    arrayOfSolverVariable = b;
    k = c;
    arrayOfSolverVariable[k] = paramSolverVariable;
    k += 1;
    c = k;
    if ((k > 1) && (1b > b))
    {
      int m = 0;
      k = 0;
      int n;
      for (;;)
      {
        n = c;
        if (k >= n) {
          break;
        }
        a[k] = b[k];
        k += 1;
      }
      Arrays.sort(a, 0, n, new DetailArret.1(this));
      k = m;
      while (k < c)
      {
        b[k] = a[k];
        k += 1;
      }
    }
    t = true;
    paramSolverVariable.c(this);
  }
  
  private final void visitMaxs(SolverVariable paramSolverVariable)
  {
    int k = 0;
    while (k < c)
    {
      if (b[k] == paramSolverVariable)
      {
        int m;
        for (;;)
        {
          m = c;
          if (k >= m - 1) {
            break;
          }
          SolverVariable[] arrayOfSolverVariable = b;
          m = k + 1;
          arrayOfSolverVariable[k] = arrayOfSolverVariable[m];
          k = m;
        }
        c = (m - 1);
        t = false;
        return;
      }
      k += 1;
    }
  }
  
  public SolverVariable a(ClassWriter paramClassWriter, boolean[] paramArrayOfBoolean)
  {
    int k = 0;
    int n;
    for (int m = -1; k < c; m = n)
    {
      paramClassWriter = b[k];
      if (paramArrayOfBoolean[b] != 0)
      {
        n = m;
      }
      else
      {
        j.b(paramClassWriter);
        if (m == -1)
        {
          n = m;
          if (!j.a()) {
            break label91;
          }
        }
        else
        {
          n = m;
          if (!j.a(b[m])) {
            break label91;
          }
        }
        n = k;
      }
      label91:
      k += 1;
    }
    if (m == -1) {
      return null;
    }
    return b[m];
  }
  
  public void a(ClassWriter paramClassWriter, h paramH, boolean paramBoolean)
  {
    paramClassWriter = c;
    if (paramClassWriter == null) {
      return;
    }
    i localI = b;
    int m = localI.f();
    int k = 0;
    while (k < m)
    {
      SolverVariable localSolverVariable = localI.a(k);
      float f = localI.b(k);
      j.b(localSolverVariable);
      if (j.a(paramClassWriter, f)) {
        d(localSolverVariable);
      }
      i += i * f;
      k += 1;
    }
    visitMaxs(paramClassWriter);
  }
  
  public void b(SolverVariable paramSolverVariable)
  {
    j.b(paramSolverVariable);
    j.b();
    j[r] = 1.0F;
    d(paramSolverVariable);
  }
  
  public void clear()
  {
    c = 0;
    i = 0.0F;
  }
  
  public boolean isEmpty()
  {
    return c == 0;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(" goal -> (");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(") : ");
    localObject1 = ((StringBuilder)localObject1).toString();
    int k = 0;
    while (k < c)
    {
      Object localObject2 = b[k];
      j.b((SolverVariable)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(" ");
      localObject1 = ((StringBuilder)localObject2).toString();
      k += 1;
    }
    return localObject1;
  }
}
