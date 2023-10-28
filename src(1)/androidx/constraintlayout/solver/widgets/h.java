package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ClassWriter;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class h
  extends ConstraintWidget
{
  private ConstraintAnchor c = c;
  private int d;
  private int e;
  protected float i = -1.0F;
  protected int j = -1;
  protected int k = -1;
  private boolean o;
  
  public h()
  {
    int m = 0;
    d = 0;
    e = 0;
    j.clear();
    j.add(c);
    int n = h.length;
    while (m < n)
    {
      h[m] = c;
      m += 1;
    }
  }
  
  public ConstraintAnchor a()
  {
    return c;
  }
  
  public ConstraintAnchor a(ConstraintAnchor.Type paramType)
  {
    switch (Type.c[paramType.ordinal()])
    {
    default: 
      break;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      return null;
    case 3: 
    case 4: 
      if (d == 0) {
        return c;
      }
      break;
    case 1: 
    case 2: 
      if (d == 1) {
        return c;
      }
      break;
    }
    throw new AssertionError(paramType.name());
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      i = paramFloat;
      k = -1;
      j = -1;
    }
  }
  
  public void a(int paramInt)
  {
    if (d == paramInt) {
      return;
    }
    d = paramInt;
    j.clear();
    if (d == 1) {
      c = a;
    } else {
      c = c;
    }
    j.add(c);
    int m = h.length;
    paramInt = 0;
    while (paramInt < m)
    {
      h[paramInt] = c;
      paramInt += 1;
    }
  }
  
  public void a(ClassWriter paramClassWriter, boolean paramBoolean)
  {
    Object localObject2 = (f)listFiles();
    if (localObject2 == null) {
      return;
    }
    ConstraintAnchor localConstraintAnchor = ((ConstraintWidget)localObject2).a(ConstraintAnchor.Type.g);
    Object localObject1 = ((ConstraintWidget)localObject2).a(ConstraintAnchor.Type.c);
    ConstraintWidget localConstraintWidget = x;
    int n = 1;
    int m;
    if ((localConstraintWidget != null) && (u[0] == ConstraintWidget.DimensionBehaviour.c)) {
      m = 1;
    } else {
      m = 0;
    }
    if (d == 0)
    {
      localConstraintAnchor = ((ConstraintWidget)localObject2).a(ConstraintAnchor.Type.a);
      localObject1 = ((ConstraintWidget)localObject2).a(ConstraintAnchor.Type.b);
      localObject2 = x;
      if ((localObject2 != null) && (u[1] == ConstraintWidget.DimensionBehaviour.c)) {
        m = n;
      } else {
        m = 0;
      }
    }
    if ((o) && (c.i()))
    {
      localObject2 = paramClassWriter.a(c);
      paramClassWriter.a((SolverVariable)localObject2, c.get());
      if (k != -1)
      {
        if (m != 0) {
          paramClassWriter.d(paramClassWriter.a(localObject1), (SolverVariable)localObject2, 0, 5);
        }
      }
      else if ((j != -1) && (m != 0))
      {
        localObject1 = paramClassWriter.a(localObject1);
        paramClassWriter.d((SolverVariable)localObject2, paramClassWriter.a(localConstraintAnchor), 0, 5);
        paramClassWriter.d((SolverVariable)localObject1, (SolverVariable)localObject2, 0, 5);
      }
      o = false;
      return;
    }
    if (k != -1)
    {
      localObject2 = paramClassWriter.a(c);
      paramClassWriter.a((SolverVariable)localObject2, paramClassWriter.a(localConstraintAnchor), k, 8);
      if (m != 0) {
        paramClassWriter.d(paramClassWriter.a(localObject1), (SolverVariable)localObject2, 0, 5);
      }
    }
    else if (j != -1)
    {
      localObject2 = paramClassWriter.a(c);
      localObject1 = paramClassWriter.a(localObject1);
      paramClassWriter.a((SolverVariable)localObject2, (SolverVariable)localObject1, -j, 8);
      if (m != 0)
      {
        paramClassWriter.d((SolverVariable)localObject2, paramClassWriter.a(localConstraintAnchor), 0, 5);
        paramClassWriter.d((SolverVariable)localObject1, (SolverVariable)localObject2, 0, 5);
      }
    }
    else if (i != -1.0F)
    {
      paramClassWriter.a(ClassWriter.a(paramClassWriter, paramClassWriter.a(c), paramClassWriter.a(localObject1), i));
    }
  }
  
  public int b()
  {
    return j;
  }
  
  public void b(int paramInt)
  {
    if (paramInt > -1)
    {
      i = -1.0F;
      k = -1;
      j = paramInt;
    }
  }
  
  public void b(ClassWriter paramClassWriter, boolean paramBoolean)
  {
    if (listFiles() == null) {
      return;
    }
    int m = paramClassWriter.set(c);
    if (d == 1)
    {
      e(m);
      remove(0);
      append(listFiles().length());
      get(0);
      return;
    }
    e(0);
    remove(m);
    get(listFiles().getValue());
    append(0);
  }
  
  public int c()
  {
    return k;
  }
  
  public void c(int paramInt)
  {
    c.a(paramInt);
    o = true;
  }
  
  public void d(int paramInt)
  {
    if (paramInt > -1)
    {
      i = -1.0F;
      k = paramInt;
      j = -1;
    }
  }
  
  public int e()
  {
    return d;
  }
  
  public float g()
  {
    return i;
  }
  
  public boolean h()
  {
    return o;
  }
  
  public boolean j()
  {
    return o;
  }
  
  public boolean m()
  {
    return true;
  }
}
