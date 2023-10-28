package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Label;
import androidx.constraintlayout.solver.widgets.m;
import java.util.Iterator;
import java.util.List;

class MethodWriter
  extends WidgetRun
{
  public MethodWriter(ConstraintWidget paramConstraintWidget)
  {
    super(paramConstraintWidget);
  }
  
  private void a(DependencyNode paramDependencyNode)
  {
    d.f.add(paramDependencyNode);
    b.add(d);
  }
  
  public void a(x paramX)
  {
    paramX = (m)b;
    int n = paramX.e();
    Iterator localIterator = d.b.iterator();
    int i = 0;
    int j = -1;
    while (localIterator.hasNext())
    {
      int k = nexta;
      int m;
      if (j != -1)
      {
        m = j;
        if (k >= j) {}
      }
      else
      {
        m = k;
      }
      j = m;
      if (i < k)
      {
        i = k;
        j = m;
      }
    }
    if ((n != 0) && (n != 2))
    {
      d.a(i + paramX.g());
      return;
    }
    d.a(j + paramX.g());
  }
  
  void b()
  {
    Object localObject1 = b;
    if ((localObject1 instanceof m))
    {
      d.p = true;
      localObject1 = (m)localObject1;
      int n = ((m)localObject1).e();
      boolean bool = ((m)localObject1).b();
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      Object localObject2;
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            if (n != 3) {
              return;
            }
            d.d = DependencyNode.Type.g;
            while (i < e)
            {
              localObject2 = b[i];
              if ((bool) || (((ConstraintWidget)localObject2).get() != 8))
              {
                localObject2 = e.a;
                f.add(d);
                d.b.add(localObject2);
              }
              i += 1;
            }
            a(b.e.d);
            a(b.e.a);
            return;
          }
          d.d = DependencyNode.Type.p;
          i = j;
          while (i < e)
          {
            localObject2 = b[i];
            if ((bool) || (((ConstraintWidget)localObject2).get() != 8))
            {
              localObject2 = e.d;
              f.add(d);
              d.b.add(localObject2);
            }
            i += 1;
          }
          a(b.e.d);
          a(b.e.a);
          return;
        }
        d.d = DependencyNode.Type.b;
        i = k;
        while (i < e)
        {
          localObject2 = b[i];
          if ((bool) || (((ConstraintWidget)localObject2).get() != 8))
          {
            localObject2 = d.a;
            f.add(d);
            d.b.add(localObject2);
          }
          i += 1;
        }
        a(b.d.d);
        a(b.d.a);
        return;
      }
      d.d = DependencyNode.Type.d;
      i = m;
      while (i < e)
      {
        localObject2 = b[i];
        if ((bool) || (((ConstraintWidget)localObject2).get() != 8))
        {
          localObject2 = d.d;
          f.add(d);
          d.b.add(localObject2);
        }
        i += 1;
      }
      a(b.d.d);
      a(b.d.a);
    }
  }
  
  boolean c()
  {
    return false;
  }
  
  public void e()
  {
    ConstraintWidget localConstraintWidget = b;
    if ((localConstraintWidget instanceof m))
    {
      int i = ((m)localConstraintWidget).e();
      if ((i != 0) && (i != 1))
      {
        b.remove(d.a);
        return;
      }
      b.e(d.a);
    }
  }
  
  void f()
  {
    l = null;
    d.a();
  }
}
