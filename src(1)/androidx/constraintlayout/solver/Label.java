package androidx.constraintlayout.solver;

import java.util.Arrays;

class Label
  implements Comparable
{
  m a;
  SolverVariable e;
  
  public Label(m paramM1, m paramM2)
  {
    a = paramM2;
  }
  
  public final boolean a()
  {
    int i = 8;
    while (i >= 0)
    {
      float f = e.j[i];
      if (f > 0.0F) {
        return false;
      }
      if (f < 0.0F) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public final boolean a(SolverVariable paramSolverVariable)
  {
    int i = 8;
    while (i >= 0)
    {
      float f1 = j[i];
      float f2 = e.j[i];
      if (f2 == f1) {
        i -= 1;
      } else if (f2 < f1) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(SolverVariable paramSolverVariable, float paramFloat)
  {
    boolean bool = e.t;
    int j = 1;
    int i = 0;
    if (bool)
    {
      i = 0;
      while (i < 9)
      {
        float[] arrayOfFloat = e.j;
        arrayOfFloat[i] += j[i] * paramFloat;
        if (Math.abs(arrayOfFloat[i]) < 1.0E-4F) {
          e.j[i] = 0.0F;
        } else {
          j = 0;
        }
        i += 1;
      }
      if (j != 0)
      {
        m.a(d, e);
        return false;
      }
    }
    else
    {
      while (i < 9)
      {
        float f1 = j[i];
        if (f1 != 0.0F)
        {
          float f2 = f1 * paramFloat;
          f1 = f2;
          if (Math.abs(f2) < 1.0E-4F) {
            f1 = 0.0F;
          }
          e.j[i] = f1;
        }
        else
        {
          e.j[i] = 0.0F;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    Arrays.fill(e.j, 0.0F);
  }
  
  public void b(SolverVariable paramSolverVariable)
  {
    e = paramSolverVariable;
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (SolverVariable)paramObject;
    return e.b - b;
  }
  
  public String toString()
  {
    SolverVariable localSolverVariable = e;
    Object localObject1 = "[ ";
    Object localObject2 = localObject1;
    if (localSolverVariable != null)
    {
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= 9) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(e.j[i]);
        ((StringBuilder)localObject2).append(" ");
        localObject1 = ((StringBuilder)localObject2).toString();
        i += 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("] ");
    ((StringBuilder)localObject1).append(e);
    return ((StringBuilder)localObject1).toString();
  }
}
