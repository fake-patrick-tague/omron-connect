package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.h;
import java.util.List;

class d
  extends WidgetRun
{
  public d(ConstraintWidget paramConstraintWidget)
  {
    super(paramConstraintWidget);
    d.f();
    e.f();
    j = ((h)paramConstraintWidget).e();
  }
  
  private void a(DependencyNode paramDependencyNode)
  {
    d.f.add(paramDependencyNode);
    b.add(d);
  }
  
  public void a(x paramX)
  {
    paramX = d;
    if (!e) {
      return;
    }
    if (i) {
      return;
    }
    paramX = (DependencyNode)b.get(0);
    h localH = (h)b;
    int i = (int)(a * localH.g() + 0.5F);
    d.a(i);
  }
  
  void b()
  {
    Object localObject = (h)b;
    int i = ((h)localObject).c();
    int j = ((h)localObject).b();
    ((h)localObject).g();
    if (((h)localObject).e() == 1)
    {
      if (i != -1)
      {
        d.b.add(b.x.d.d);
        b.x.d.d.f.add(d);
        d.c = i;
      }
      else if (j != -1)
      {
        d.b.add(b.x.d.a);
        b.x.d.a.f.add(d);
        d.c = (-j);
      }
      else
      {
        localObject = d;
        p = true;
        b.add(b.x.d.a);
        b.x.d.a.f.add(d);
      }
      a(b.d.d);
      a(b.d.a);
      return;
    }
    if (i != -1)
    {
      d.b.add(b.x.e.d);
      b.x.e.d.f.add(d);
      d.c = i;
    }
    else if (j != -1)
    {
      d.b.add(b.x.e.a);
      b.x.e.a.f.add(d);
      d.c = (-j);
    }
    else
    {
      localObject = d;
      p = true;
      b.add(b.x.e.a);
      b.x.e.a.f.add(d);
    }
    a(b.e.d);
    a(b.e.a);
  }
  
  boolean c()
  {
    return false;
  }
  
  public void e()
  {
    if (((h)b).e() == 1)
    {
      b.e(d.a);
      return;
    }
    b.remove(d.a);
  }
  
  void f()
  {
    d.a();
  }
}
