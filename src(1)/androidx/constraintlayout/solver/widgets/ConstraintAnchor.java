package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Item;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.SolverVariable.Type;
import androidx.constraintlayout.solver.widgets.analyzer.SignatureReader;
import androidx.constraintlayout.solver.widgets.analyzer.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor
{
  public int a = 0;
  public final ConstraintWidget b;
  public ConstraintAnchor c;
  public final Type d;
  int h = -1;
  SolverVariable i;
  private HashSet<ConstraintAnchor> j = null;
  private boolean k;
  private int m;
  
  public ConstraintAnchor(ConstraintWidget paramConstraintWidget, Type paramType)
  {
    b = paramConstraintWidget;
    d = paramType;
  }
  
  public void a()
  {
    Object localObject = c;
    if (localObject != null)
    {
      localObject = j;
      if (localObject != null)
      {
        ((HashSet)localObject).remove(this);
        if (c.j.size() == 0) {
          c.j = null;
        }
      }
    }
    j = null;
    c = null;
    a = 0;
    h = -1;
    k = false;
    m = 0;
  }
  
  public void a(int paramInt)
  {
    m = paramInt;
    k = true;
  }
  
  public void a(int paramInt, ArrayList paramArrayList, i paramI)
  {
    Object localObject = j;
    if (localObject != null)
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        SignatureReader.a(nextb, paramInt, paramArrayList, paramI);
      }
    }
  }
  
  public void a(Item paramItem)
  {
    paramItem = i;
    if (paramItem == null)
    {
      i = new SolverVariable(SolverVariable.Type.u, null);
      return;
    }
    paramItem.a();
  }
  
  public boolean a(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramConstraintAnchor == null)
    {
      a();
      return true;
    }
    if ((!paramBoolean) && (!b(paramConstraintAnchor))) {
      return false;
    }
    c = paramConstraintAnchor;
    if (j == null) {
      j = new HashSet();
    }
    paramConstraintAnchor = c.j;
    if (paramConstraintAnchor != null) {
      paramConstraintAnchor.add(this);
    }
    if (paramInt1 > 0) {
      a = paramInt1;
    } else {
      a = 0;
    }
    h = paramInt2;
    return true;
  }
  
  public int b()
  {
    if (b.get() == 8) {
      return 0;
    }
    if (h > -1)
    {
      ConstraintAnchor localConstraintAnchor = c;
      if ((localConstraintAnchor != null) && (b.get() == 8)) {
        return h;
      }
    }
    return a;
  }
  
  public boolean b(ConstraintAnchor paramConstraintAnchor)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    if (paramConstraintAnchor == null) {
      return false;
    }
    Type localType1 = paramConstraintAnchor.e();
    Type localType2 = d;
    boolean bool2;
    if (localType1 == localType2)
    {
      if (localType2 == Type.e)
      {
        if (paramConstraintAnchor.visitParameterAnnotation().q())
        {
          if (visitParameterAnnotation().q()) {
            break label318;
          }
          return false;
        }
      }
      else {
        return true;
      }
    }
    else
    {
      boolean bool1;
      switch (a.b[localType2.ordinal()])
      {
      default: 
        throw new AssertionError(d.name());
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        return false;
      case 4: 
      case 5: 
        if ((localType1 != Type.a) && (localType1 != Type.b)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        bool2 = bool1;
        if (!(paramConstraintAnchor.visitParameterAnnotation() instanceof h)) {
          break;
        }
        if (!bool1)
        {
          bool1 = bool3;
          if (localType1 != Type.C) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      case 2: 
      case 3: 
        if ((localType1 != Type.g) && (localType1 != Type.c)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        bool2 = bool1;
        if (!(paramConstraintAnchor.visitParameterAnnotation() instanceof h)) {
          break;
        }
        if (!bool1)
        {
          bool1 = bool4;
          if (localType1 != Type.q) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      case 1: 
        if ((localType1 == Type.e) || (localType1 == Type.q) || (localType1 == Type.C)) {
          break label322;
        }
        return true;
      }
    }
    return false;
    label318:
    return true;
    return bool2;
    label322:
    return false;
  }
  
  public SolverVariable c()
  {
    return i;
  }
  
  public Type e()
  {
    return d;
  }
  
  public int get()
  {
    if (!k) {
      return 0;
    }
    return m;
  }
  
  public final ConstraintAnchor getValue()
  {
    switch (a.b[d.ordinal()])
    {
    default: 
      throw new AssertionError(d.name());
    case 5: 
      return b.c;
    case 4: 
      return b.b;
    case 3: 
      return b.a;
    case 2: 
      return b.l;
    }
    return null;
  }
  
  public HashSet h()
  {
    return j;
  }
  
  public boolean i()
  {
    return k;
  }
  
  public void initialize()
  {
    k = false;
    m = 0;
  }
  
  public ConstraintAnchor p()
  {
    return c;
  }
  
  public boolean put()
  {
    Object localObject = j;
    if (localObject == null) {
      return false;
    }
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((ConstraintAnchor)((Iterator)localObject).next()).getValue().remove()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean remove()
  {
    return c != null;
  }
  
  public boolean size()
  {
    HashSet localHashSet = j;
    if (localHashSet == null) {
      return false;
    }
    return localHashSet.size() > 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.getString());
    localStringBuilder.append(":");
    localStringBuilder.append(d.toString());
    return localStringBuilder.toString();
  }
  
  public ConstraintWidget visitParameterAnnotation()
  {
    return b;
  }
  
  public static enum Type
  {
    static
    {
      Type localType1 = new Type("NONE", 0);
      d = localType1;
      Type localType2 = new Type("LEFT", 1);
      g = localType2;
      Type localType3 = new Type("TOP", 2);
      a = localType3;
      Type localType4 = new Type("RIGHT", 3);
      c = localType4;
      Type localType5 = new Type("BOTTOM", 4);
      b = localType5;
      Type localType6 = new Type("BASELINE", 5);
      e = localType6;
      Type localType7 = new Type("CENTER", 6);
      i = localType7;
      Type localType8 = new Type("CENTER_X", 7);
      q = localType8;
      Type localType9 = new Type("CENTER_Y", 8);
      C = localType9;
      p = new Type[] { localType1, localType2, localType3, localType4, localType5, localType6, localType7, localType8, localType9 };
    }
  }
}
