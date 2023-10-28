package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.List;

public abstract class WidgetRun
  implements x
{
  public DependencyNode a = new DependencyNode(this);
  ConstraintWidget b;
  Label c = new Label(this);
  public DependencyNode d = new DependencyNode(this);
  protected ConstraintWidget.DimensionBehaviour f;
  public int g;
  protected RunType i = RunType.i;
  public int j = 0;
  l l;
  boolean m = false;
  
  public WidgetRun(ConstraintWidget paramConstraintWidget)
  {
    b = paramConstraintWidget;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int k = g;
    if (k != 0)
    {
      if (k != 1)
      {
        ConstraintWidget localConstraintWidget;
        Object localObject1;
        float f1;
        if (k != 2)
        {
          if (k != 3) {
            return;
          }
          localConstraintWidget = b;
          localObject1 = d;
          Object localObject2 = f;
          ConstraintWidget.DimensionBehaviour localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.b;
          if ((localObject2 == localDimensionBehaviour) && (g == 3))
          {
            localObject2 = e;
            if ((f == localDimensionBehaviour) && (g == 3)) {
              return;
            }
          }
          if (paramInt1 == 0) {
            localObject1 = e;
          }
          if (c.i)
          {
            f1 = localConstraintWidget.p();
            if (paramInt1 == 1) {
              paramInt1 = (int)(c.a / f1 + 0.5F);
            } else {
              paramInt1 = (int)(f1 * c.a + 0.5F);
            }
            c.a(paramInt1);
          }
        }
        else
        {
          localObject1 = b.listFiles();
          if (localObject1 != null)
          {
            if (paramInt1 == 0) {
              localObject1 = d;
            } else {
              localObject1 = e;
            }
            localObject1 = c;
            if (i)
            {
              localConstraintWidget = b;
              if (paramInt1 == 0) {
                f1 = v;
              } else {
                f1 = z;
              }
              paramInt2 = (int)(a * f1 + 0.5F);
              c.a(a(paramInt2, paramInt1));
            }
          }
        }
      }
      else
      {
        paramInt1 = a(c.a, paramInt1);
        c.a(Math.min(paramInt1, paramInt2));
      }
    }
    else {
      c.a(a(paramInt2, paramInt1));
    }
  }
  
  protected final int a(int paramInt1, int paramInt2)
  {
    ConstraintWidget localConstraintWidget;
    int k;
    if (paramInt2 == 0)
    {
      localConstraintWidget = b;
      k = w;
      paramInt2 = Math.max(r, paramInt1);
      if (k > 0) {
        paramInt2 = Math.min(k, paramInt1);
      }
      if (paramInt2 != paramInt1) {
        return paramInt2;
      }
    }
    else
    {
      localConstraintWidget = b;
      k = m;
      paramInt2 = Math.max(s, paramInt1);
      if (k > 0) {
        paramInt2 = Math.min(k, paramInt1);
      }
      if (paramInt2 != paramInt1) {
        return paramInt2;
      }
    }
    return paramInt1;
  }
  
  protected final DependencyNode a(ConstraintAnchor paramConstraintAnchor)
  {
    Object localObject = c;
    if (localObject == null) {
      return null;
    }
    paramConstraintAnchor = b;
    localObject = d;
    int k = a.d[localObject.ordinal()];
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            if (k != 5) {
              return null;
            }
            return e.a;
          }
          return e.a;
        }
        return e.d;
      }
      return d.a;
    }
    return d.d;
  }
  
  protected final DependencyNode a(ConstraintAnchor paramConstraintAnchor, int paramInt)
  {
    Object localObject = c;
    if (localObject == null) {
      return null;
    }
    paramConstraintAnchor = b;
    if (paramInt == 0) {
      paramConstraintAnchor = d;
    } else {
      paramConstraintAnchor = e;
    }
    localObject = d;
    paramInt = a.d[localObject.ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          break label74;
        }
        if (paramInt != 5) {
          return null;
        }
      }
      return a;
    }
    label74:
    return d;
  }
  
  protected final void a(DependencyNode paramDependencyNode1, DependencyNode paramDependencyNode2, int paramInt)
  {
    b.add(paramDependencyNode2);
    c = paramInt;
    f.add(paramDependencyNode1);
  }
  
  protected final void a(DependencyNode paramDependencyNode1, DependencyNode paramDependencyNode2, int paramInt, Label paramLabel)
  {
    b.add(paramDependencyNode2);
    b.add(c);
    j = paramInt;
    k = paramLabel;
    f.add(paramDependencyNode1);
    f.add(paramDependencyNode1);
  }
  
  public void a(x paramX) {}
  
  protected void a(x paramX, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt)
  {
    paramX = a(paramConstraintAnchor1);
    DependencyNode localDependencyNode = a(paramConstraintAnchor2);
    if (i)
    {
      if (!i) {
        return;
      }
      int n = a + paramConstraintAnchor1.b();
      int k = a - paramConstraintAnchor2.b();
      int i1 = k - n;
      if ((!c.i) && (f == ConstraintWidget.DimensionBehaviour.b)) {
        b(paramInt, i1);
      }
      paramConstraintAnchor1 = c;
      if (!i) {
        return;
      }
      if (a == i1)
      {
        d.a(n);
        a.a(k);
        return;
      }
      paramConstraintAnchor1 = b;
      float f1;
      if (paramInt == 0) {
        f1 = paramConstraintAnchor1.height();
      } else {
        f1 = paramConstraintAnchor1.remove();
      }
      paramInt = n;
      if (paramX == localDependencyNode)
      {
        paramInt = a;
        k = a;
        f1 = 0.5F;
      }
      n = c.a;
      d.a((int)(paramInt + 0.5F + (k - paramInt - n) * f1));
      a.a(d.a + c.a);
    }
  }
  
  public boolean add()
  {
    return m;
  }
  
  abstract void b();
  
  protected void b(x paramX) {}
  
  abstract boolean c();
  
  public long draw()
  {
    Label localLabel = c;
    if (i) {
      return a;
    }
    return 0L;
  }
  
  abstract void e();
  
  abstract void f();
  
  protected void visitFrame(x paramX) {}
  
  static enum RunType
  {
    static
    {
      RunType localRunType1 = new RunType("NONE", 0);
      i = localRunType1;
      RunType localRunType2 = new RunType("START", 1);
      b = localRunType2;
      RunType localRunType3 = new RunType("END", 2);
      d = localRunType3;
      RunType localRunType4 = new RunType("CENTER", 3);
      e = localRunType4;
      a = new RunType[] { localRunType1, localRunType2, localRunType3, localRunType4 };
    }
  }
}
