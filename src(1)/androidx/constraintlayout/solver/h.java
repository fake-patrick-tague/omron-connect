package androidx.constraintlayout.solver;

import java.util.ArrayList;

public class h
  implements l
{
  ArrayList<SolverVariable> a = new ArrayList();
  public i b;
  SolverVariable c = null;
  boolean e = false;
  boolean f = false;
  float i = 0.0F;
  
  public h() {}
  
  public h(Item paramItem)
  {
    b = new d(this, paramItem);
  }
  
  private SolverVariable a(boolean[] paramArrayOfBoolean, SolverVariable paramSolverVariable)
  {
    int k = b.f();
    Object localObject1 = null;
    int j = 0;
    float f2;
    for (float f1 = 0.0F; j < k; f1 = f2)
    {
      float f3 = b.b(j);
      Object localObject2 = localObject1;
      f2 = f1;
      if (f3 < 0.0F)
      {
        SolverVariable localSolverVariable = b.a(j);
        if (paramArrayOfBoolean != null)
        {
          localObject2 = localObject1;
          f2 = f1;
          if (paramArrayOfBoolean[b] != 0) {}
        }
        else
        {
          localObject2 = localObject1;
          f2 = f1;
          if (localSolverVariable != paramSolverVariable)
          {
            SolverVariable.Type localType = q;
            if (localType != SolverVariable.Type.b)
            {
              localObject2 = localObject1;
              f2 = f1;
              if (localType != SolverVariable.Type.q) {}
            }
            else
            {
              localObject2 = localObject1;
              f2 = f1;
              if (f3 < f1)
              {
                f2 = f3;
                localObject2 = localSolverVariable;
              }
            }
          }
        }
      }
      j += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private boolean a(SolverVariable paramSolverVariable, ClassWriter paramClassWriter)
  {
    return h <= 1;
  }
  
  SolverVariable a(ClassWriter paramClassWriter)
  {
    int k = b.f();
    Object localObject4 = null;
    int j = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    float f5 = 0.0F;
    float f4 = 0.0F;
    Object localObject2;
    for (Object localObject3 = null; j < k; localObject3 = localObject2)
    {
      float f1 = b.b(j);
      SolverVariable localSolverVariable = b.a(j);
      boolean bool1;
      Object localObject1;
      boolean bool2;
      float f2;
      float f3;
      if (q == SolverVariable.Type.u)
      {
        if (localObject4 == null) {}
        for (bool1 = a(localSolverVariable, paramClassWriter);; bool1 = a(localSolverVariable, paramClassWriter))
        {
          localObject1 = localSolverVariable;
          bool2 = bool3;
          f2 = f1;
          f3 = f4;
          localObject2 = localObject3;
          break label407;
          if (f5 <= f1) {
            break;
          }
        }
        localObject1 = localObject4;
        bool1 = bool4;
        bool2 = bool3;
        f2 = f5;
        f3 = f4;
        localObject2 = localObject3;
        if (!bool4)
        {
          localObject1 = localObject4;
          bool1 = bool4;
          bool2 = bool3;
          f2 = f5;
          f3 = f4;
          localObject2 = localObject3;
          if (a(localSolverVariable, paramClassWriter))
          {
            bool1 = true;
            localObject1 = localSolverVariable;
            bool2 = bool3;
            f2 = f1;
            f3 = f4;
            localObject2 = localObject3;
          }
        }
      }
      else
      {
        localObject1 = localObject4;
        bool1 = bool4;
        bool2 = bool3;
        f2 = f5;
        f3 = f4;
        localObject2 = localObject3;
        if (localObject4 == null)
        {
          localObject1 = localObject4;
          bool1 = bool4;
          bool2 = bool3;
          f2 = f5;
          f3 = f4;
          localObject2 = localObject3;
          if (f1 < 0.0F)
          {
            if (localObject3 == null) {}
            for (bool2 = a(localSolverVariable, paramClassWriter);; bool2 = a(localSolverVariable, paramClassWriter))
            {
              localObject1 = localObject4;
              bool1 = bool4;
              f2 = f5;
              f3 = f1;
              localObject2 = localSolverVariable;
              break label407;
              if (f4 <= f1) {
                break;
              }
            }
            localObject1 = localObject4;
            bool1 = bool4;
            bool2 = bool3;
            f2 = f5;
            f3 = f4;
            localObject2 = localObject3;
            if (!bool3)
            {
              localObject1 = localObject4;
              bool1 = bool4;
              bool2 = bool3;
              f2 = f5;
              f3 = f4;
              localObject2 = localObject3;
              if (a(localSolverVariable, paramClassWriter))
              {
                bool2 = true;
                localObject2 = localSolverVariable;
                f3 = f1;
                f2 = f5;
                bool1 = bool4;
                localObject1 = localObject4;
              }
            }
          }
        }
      }
      label407:
      j += 1;
      localObject4 = localObject1;
      bool4 = bool1;
      bool3 = bool2;
      f5 = f2;
      f4 = f3;
    }
    if (localObject4 != null) {
      return localObject4;
    }
    return localObject3;
  }
  
  public SolverVariable a(ClassWriter paramClassWriter, boolean[] paramArrayOfBoolean)
  {
    return a(paramArrayOfBoolean, null);
  }
  
  public h a(float paramFloat1, float paramFloat2, float paramFloat3, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4)
  {
    i = 0.0F;
    if ((paramFloat2 != 0.0F) && (paramFloat1 != paramFloat3))
    {
      if (paramFloat1 == 0.0F)
      {
        b.a(paramSolverVariable1, 1.0F);
        b.a(paramSolverVariable2, -1.0F);
        return this;
      }
      if (paramFloat3 == 0.0F)
      {
        b.a(paramSolverVariable3, 1.0F);
        b.a(paramSolverVariable4, -1.0F);
        return this;
      }
      paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
      b.a(paramSolverVariable1, 1.0F);
      b.a(paramSolverVariable2, -1.0F);
      b.a(paramSolverVariable4, paramFloat1);
      b.a(paramSolverVariable3, -paramFloat1);
      return this;
    }
    b.a(paramSolverVariable1, 1.0F);
    b.a(paramSolverVariable2, -1.0F);
    b.a(paramSolverVariable4, 1.0F);
    b.a(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public h a(ClassWriter paramClassWriter, int paramInt)
  {
    b.a(paramClassWriter.a(paramInt, "ep"), 1.0F);
    b.a(paramClassWriter.a(paramInt, "em"), -1.0F);
    return this;
  }
  
  public h a(SolverVariable paramSolverVariable, int paramInt)
  {
    if (paramInt < 0)
    {
      i = (paramInt * -1);
      b.a(paramSolverVariable, 1.0F);
      return this;
    }
    i = paramInt;
    b.a(paramSolverVariable, -1.0F);
    return this;
  }
  
  h a(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, float paramFloat)
  {
    b.a(paramSolverVariable1, -1.0F);
    b.a(paramSolverVariable2, paramFloat);
    return this;
  }
  
  public h a(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt)
  {
    int j = 0;
    int k = 0;
    if (paramInt != 0)
    {
      j = k;
      k = paramInt;
      if (paramInt < 0)
      {
        k = paramInt * -1;
        j = 1;
      }
      i = k;
    }
    if (j == 0)
    {
      b.a(paramSolverVariable1, -1.0F);
      b.a(paramSolverVariable2, 1.0F);
      return this;
    }
    b.a(paramSolverVariable1, 1.0F);
    b.a(paramSolverVariable2, -1.0F);
    return this;
  }
  
  h a(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2)
  {
    if (paramSolverVariable2 == paramSolverVariable3)
    {
      b.a(paramSolverVariable1, 1.0F);
      b.a(paramSolverVariable4, 1.0F);
      b.a(paramSolverVariable2, -2.0F);
      return this;
    }
    if (paramFloat == 0.5F)
    {
      b.a(paramSolverVariable1, 1.0F);
      b.a(paramSolverVariable2, -1.0F);
      b.a(paramSolverVariable3, -1.0F);
      b.a(paramSolverVariable4, 1.0F);
      if ((paramInt1 > 0) || (paramInt2 > 0))
      {
        i = (-paramInt1 + paramInt2);
        return this;
      }
    }
    else
    {
      if (paramFloat <= 0.0F)
      {
        b.a(paramSolverVariable1, -1.0F);
        b.a(paramSolverVariable2, 1.0F);
        i = paramInt1;
        return this;
      }
      if (paramFloat >= 1.0F)
      {
        b.a(paramSolverVariable4, -1.0F);
        b.a(paramSolverVariable3, 1.0F);
        i = (-paramInt2);
        return this;
      }
      i localI = b;
      float f1 = 1.0F - paramFloat;
      localI.a(paramSolverVariable1, f1 * 1.0F);
      b.a(paramSolverVariable2, f1 * -1.0F);
      b.a(paramSolverVariable3, -1.0F * paramFloat);
      b.a(paramSolverVariable4, 1.0F * paramFloat);
      if ((paramInt1 > 0) || (paramInt2 > 0)) {
        i = (-paramInt1 * f1 + paramInt2 * paramFloat);
      }
    }
    return this;
  }
  
  public h a(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int j = 0;
    int k = 0;
    if (paramInt != 0)
    {
      j = k;
      k = paramInt;
      if (paramInt < 0)
      {
        k = paramInt * -1;
        j = 1;
      }
      i = k;
    }
    if (j == 0)
    {
      b.a(paramSolverVariable1, -1.0F);
      b.a(paramSolverVariable2, 1.0F);
      b.a(paramSolverVariable3, 1.0F);
      return this;
    }
    b.a(paramSolverVariable1, 1.0F);
    b.a(paramSolverVariable2, -1.0F);
    b.a(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public h a(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    b.a(paramSolverVariable1, -1.0F);
    b.a(paramSolverVariable2, 1.0F);
    b.a(paramSolverVariable3, paramFloat);
    b.a(paramSolverVariable4, -paramFloat);
    return this;
  }
  
  String a()
  {
    if (c == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("0");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(c);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" = ");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject1 = localObject2;
    float f1 = i;
    int m = 0;
    if (f1 != 0.0F)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
      j = 1;
    }
    else
    {
      j = 0;
    }
    int n = b.f();
    int k = j;
    int j = m;
    while (j < n)
    {
      localObject2 = b.a(j);
      if (localObject2 != null)
      {
        float f2 = b.b(j);
        f1 = f2;
        m = f2 < 0.0F;
        if (m != 0)
        {
          String str = ((SolverVariable)localObject2).toString();
          if (k == 0)
          {
            localObject2 = localObject1;
            if (f2 >= 0.0F) {
              break label370;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("- ");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          else
          {
            if (m > 0)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(" + ");
              localObject2 = ((StringBuilder)localObject2).toString();
              break label370;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" - ");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          f1 = f2 * -1.0F;
          label370:
          if (f1 == 1.0F)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(str);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(f1);
            ((StringBuilder)localObject1).append(" ");
            ((StringBuilder)localObject1).append(str);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          k = 1;
        }
      }
      j += 1;
    }
    if (k == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0.0");
      return ((StringBuilder)localObject2).toString();
    }
    return localObject1;
  }
  
  public void a(ClassWriter paramClassWriter, SolverVariable paramSolverVariable, boolean paramBoolean)
  {
    if (!c) {
      return;
    }
    float f1 = b.a(paramSolverVariable);
    i += a * f1;
    b.a(paramSolverVariable, paramBoolean);
    if (paramBoolean) {
      paramSolverVariable.a(this);
    }
    if ((ClassWriter.d) && (b.f() == 0))
    {
      f = true;
      i = true;
    }
  }
  
  public void a(ClassWriter paramClassWriter, h paramH, boolean paramBoolean)
  {
    float f1 = b.a(paramH, paramBoolean);
    i += i * f1;
    if (paramBoolean) {
      c.a(this);
    }
    if ((ClassWriter.d) && (c != null) && (b.f() == 0))
    {
      f = true;
      i = true;
    }
  }
  
  void a(SolverVariable paramSolverVariable)
  {
    SolverVariable localSolverVariable = c;
    if (localSolverVariable != null)
    {
      b.a(localSolverVariable, -1.0F);
      c.f = -1;
      c = null;
    }
    float f1 = b.a(paramSolverVariable, true) * -1.0F;
    c = paramSolverVariable;
    if (f1 == 1.0F) {
      return;
    }
    i /= f1;
    b.a(f1);
  }
  
  public void a(l paramL)
  {
    if ((paramL instanceof h))
    {
      paramL = (h)paramL;
      c = null;
      b.clear();
      int j = 0;
      while (j < b.f())
      {
        SolverVariable localSolverVariable = b.a(j);
        float f1 = b.b(j);
        b.a(localSolverVariable, f1, true);
        j += 1;
      }
    }
  }
  
  h b(SolverVariable paramSolverVariable, int paramInt)
  {
    c = paramSolverVariable;
    float f1 = paramInt;
    a = f1;
    i = f1;
    f = true;
    return this;
  }
  
  public h b(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int j = 0;
    int k = 0;
    if (paramInt != 0)
    {
      j = k;
      k = paramInt;
      if (paramInt < 0)
      {
        k = paramInt * -1;
        j = 1;
      }
      i = k;
    }
    if (j == 0)
    {
      b.a(paramSolverVariable1, -1.0F);
      b.a(paramSolverVariable2, 1.0F);
      b.a(paramSolverVariable3, -1.0F);
      return this;
    }
    b.a(paramSolverVariable1, 1.0F);
    b.a(paramSolverVariable2, -1.0F);
    b.a(paramSolverVariable3, 1.0F);
    return this;
  }
  
  public h b(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    b.a(paramSolverVariable3, 0.5F);
    b.a(paramSolverVariable4, 0.5F);
    b.a(paramSolverVariable1, -0.5F);
    b.a(paramSolverVariable2, -0.5F);
    i = (-paramFloat);
    return this;
  }
  
  public void b()
  {
    c = null;
    b.clear();
    i = 0.0F;
    f = false;
  }
  
  public void b(ClassWriter paramClassWriter)
  {
    if (b.length == 0) {
      return;
    }
    int j = 0;
    while (j == 0)
    {
      int m = b.f();
      int k = 0;
      SolverVariable localSolverVariable;
      while (k < m)
      {
        localSolverVariable = b.a(k);
        if ((f != -1) || (c) || (i)) {
          a.add(localSolverVariable);
        }
        k += 1;
      }
      m = a.size();
      if (m > 0)
      {
        k = 0;
        while (k < m)
        {
          localSolverVariable = (SolverVariable)a.get(k);
          if (c) {
            a(paramClassWriter, localSolverVariable, true);
          } else if (i) {
            b(paramClassWriter, localSolverVariable, true);
          } else {
            a(paramClassWriter, b[f], true);
          }
          k += 1;
        }
        a.clear();
      }
      else
      {
        j = 1;
      }
    }
    if ((ClassWriter.d) && (c != null) && (b.f() == 0))
    {
      f = true;
      i = true;
    }
  }
  
  public void b(ClassWriter paramClassWriter, SolverVariable paramSolverVariable, boolean paramBoolean)
  {
    if (!i) {
      return;
    }
    float f1 = b.a(paramSolverVariable);
    i += g * f1;
    b.a(paramSolverVariable, paramBoolean);
    if (paramBoolean) {
      paramSolverVariable.a(this);
    }
    b.a(a.n[e], f1, paramBoolean);
    if ((ClassWriter.d) && (b.f() == 0))
    {
      f = true;
      i = true;
    }
  }
  
  public void b(SolverVariable paramSolverVariable)
  {
    int j = r;
    float f1 = 1.0F;
    if (j != 1) {
      if (j == 2) {
        f1 = 1000.0F;
      } else if (j == 3) {
        f1 = 1000000.0F;
      } else if (j == 4) {
        f1 = 1.0E9F;
      } else if (j == 5) {
        f1 = 1.0E12F;
      }
    }
    b.a(paramSolverVariable, f1);
  }
  
  boolean c()
  {
    SolverVariable localSolverVariable = c;
    return (localSolverVariable != null) && ((q == SolverVariable.Type.u) || (i >= 0.0F));
  }
  
  boolean c(ClassWriter paramClassWriter)
  {
    paramClassWriter = a(paramClassWriter);
    boolean bool;
    if (paramClassWriter == null)
    {
      bool = true;
    }
    else
    {
      a(paramClassWriter);
      bool = false;
    }
    if (b.f() == 0) {
      f = true;
    }
    return bool;
  }
  
  boolean c(SolverVariable paramSolverVariable)
  {
    return b.c(paramSolverVariable);
  }
  
  public void clear()
  {
    b.clear();
    c = null;
    i = 0.0F;
  }
  
  void d()
  {
    float f1 = i;
    if (f1 < 0.0F)
    {
      i = (f1 * -1.0F);
      b.a();
    }
  }
  
  public SolverVariable getItem(SolverVariable paramSolverVariable)
  {
    return a(null, paramSolverVariable);
  }
  
  public SolverVariable getKey()
  {
    return c;
  }
  
  public boolean isEmpty()
  {
    return (c == null) && (i == 0.0F) && (b.f() == 0);
  }
  
  h setTitle(SolverVariable paramSolverVariable, int paramInt)
  {
    b.a(paramSolverVariable, paramInt);
    return this;
  }
  
  public String toString()
  {
    return a();
  }
}
