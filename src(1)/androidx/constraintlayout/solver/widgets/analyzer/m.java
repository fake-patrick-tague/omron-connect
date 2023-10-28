package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.AnnotationWriter;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.List;

public class m
  extends WidgetRun
{
  public DependencyNode a;
  Label b;
  
  public m(ConstraintWidget paramConstraintWidget)
  {
    super(paramConstraintWidget);
    paramConstraintWidget = new DependencyNode(this);
    a = paramConstraintWidget;
    b = null;
    d.d = DependencyNode.Type.p;
    a.d = DependencyNode.Type.g;
    d = DependencyNode.Type.storage;
    j = 1;
  }
  
  public void a(x paramX)
  {
    int i = Type.d[this.i.ordinal()];
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject = b;
          a(paramX, c, b, 1);
        }
      }
      else {
        b(paramX);
      }
    }
    else {
      visitFrame(paramX);
    }
    paramX = c;
    float f1;
    if ((e) && (!i) && (f == ConstraintWidget.DimensionBehaviour.b))
    {
      paramX = b;
      i = n;
      if (i != 2)
      {
        if ((i == 3) && (d.c.i))
        {
          i = paramX.readUnsignedShort();
          float f2;
          if (i != -1)
          {
            if (i != 0)
            {
              if (i != 1)
              {
                i = 0;
                break label250;
              }
              paramX = b;
              f1 = d.c.a;
              f2 = paramX.p();
            }
            else
            {
              paramX = b;
              f1 = d.c.a * paramX.p();
              break label243;
            }
          }
          else
          {
            paramX = b;
            f1 = d.c.a;
            f2 = paramX.p();
          }
          f1 /= f2;
          label243:
          i = (int)(f1 + 0.5F);
          label250:
          c.a(i);
        }
      }
      else
      {
        paramX = paramX.listFiles();
        if (paramX != null)
        {
          paramX = e.c;
          if (i)
          {
            f1 = b.z;
            i = (int)(a * f1 + 0.5F);
            c.a(i);
          }
        }
      }
    }
    paramX = d;
    if (e)
    {
      localObject = a;
      if (!e) {
        return;
      }
      if ((i) && (i) && (c.i)) {
        return;
      }
      int j;
      if ((!c.i) && (f == ConstraintWidget.DimensionBehaviour.b))
      {
        paramX = b;
        if ((i == 0) && (!paramX.f()))
        {
          localObject = (DependencyNode)d.b.get(0);
          paramX = (DependencyNode)a.b.get(0);
          i = a;
          localObject = d;
          i += c;
          j = a + a.c;
          ((DependencyNode)localObject).a(i);
          a.a(j);
          c.a(j - i);
          return;
        }
      }
      if ((!c.i) && (f == ConstraintWidget.DimensionBehaviour.b) && (g == 1) && (d.b.size() > 0) && (a.b.size() > 0))
      {
        paramX = (DependencyNode)d.b.get(0);
        localObject = (DependencyNode)a.b.get(0);
        i = a;
        j = d.c;
        i = a + a.c - (i + j);
        paramX = c;
        j = a;
        if (i < j) {
          paramX.a(i);
        } else {
          paramX.a(j);
        }
      }
      if (!c.i) {
        return;
      }
      if ((d.b.size() > 0) && (a.b.size() > 0))
      {
        paramX = (DependencyNode)d.b.get(0);
        localObject = (DependencyNode)a.b.get(0);
        i = a + d.c;
        j = a + a.c;
        f1 = b.remove();
        if (paramX == localObject)
        {
          i = a;
          j = a;
          f1 = 0.5F;
        }
        int k = c.a;
        d.a((int)(i + 0.5F + (j - i - k) * f1));
        a.a(d.a + c.a);
      }
    }
  }
  
  void b()
  {
    Object localObject1 = b;
    if (k) {
      c.a(((ConstraintWidget)localObject1).length());
    }
    int i;
    if (!c.i)
    {
      f = b.size();
      if (b.q()) {
        b = new ValPixConverter(this);
      }
      localObject1 = f;
      if (localObject1 != ConstraintWidget.DimensionBehaviour.b)
      {
        if (localObject1 == ConstraintWidget.DimensionBehaviour.g)
        {
          localObject1 = b.listFiles();
          if ((localObject1 != null) && (((ConstraintWidget)localObject1).size() == ConstraintWidget.DimensionBehaviour.a))
          {
            i = ((ConstraintWidget)localObject1).length();
            int j = b.c.b();
            int k = b.b.b();
            a(d, e.d, b.c.b());
            a(a, e.a, -b.b.b());
            c.a(i - j - k);
            return;
          }
        }
        if (f == ConstraintWidget.DimensionBehaviour.a) {
          c.a(b.length());
        }
      }
    }
    else if (f == ConstraintWidget.DimensionBehaviour.g)
    {
      localObject1 = b.listFiles();
      if ((localObject1 != null) && (((ConstraintWidget)localObject1).size() == ConstraintWidget.DimensionBehaviour.a))
      {
        a(d, e.d, b.c.b());
        a(a, e.a, -b.b.b());
        return;
      }
    }
    Object localObject2 = c;
    boolean bool = i;
    if (bool)
    {
      localObject1 = b;
      if (k)
      {
        localObject2 = h;
        if ((2c != null) && (3c != null))
        {
          if (((ConstraintWidget)localObject1).f())
          {
            d.c = b.h[2].b();
            a.c = (-b.h[3].b());
          }
          else
          {
            localObject1 = a(b.h[2]);
            if (localObject1 != null) {
              a(d, (DependencyNode)localObject1, b.h[2].b());
            }
            localObject1 = a(b.h[3]);
            if (localObject1 != null) {
              a(a, (DependencyNode)localObject1, -b.h[3].b());
            }
            d.p = true;
            a.p = true;
          }
          if (!b.q()) {
            return;
          }
          a(a, d, b.newUTF8());
          return;
        }
        if (2c != null)
        {
          localObject1 = a(localObject2[2]);
          if (localObject1 == null) {
            return;
          }
          a(d, (DependencyNode)localObject1, b.h[2].b());
          a(a, d, c.a);
          if (!b.q()) {
            return;
          }
          a(a, d, b.newUTF8());
          return;
        }
        if (3c != null)
        {
          localObject1 = a(localObject2[3]);
          if (localObject1 != null)
          {
            a(a, (DependencyNode)localObject1, -b.h[3].b());
            a(d, a, -c.a);
          }
          if (!b.q()) {
            return;
          }
          a(a, d, b.newUTF8());
          return;
        }
        if (4c != null)
        {
          localObject1 = a(localObject2[4]);
          if (localObject1 == null) {
            return;
          }
          a(a, (DependencyNode)localObject1, 0);
          a(d, a, -b.newUTF8());
          a(a, d, c.a);
          return;
        }
        if (((localObject1 instanceof AnnotationWriter)) || (((ConstraintWidget)localObject1).listFiles() == null) || (b.a(ConstraintAnchor.Type.i).c != null)) {
          return;
        }
        localObject1 = b.listFiles().e.d;
        a(d, (DependencyNode)localObject1, b.max());
        a(a, d, c.a);
        if (!b.q()) {
          return;
        }
        a(a, d, b.newUTF8());
        return;
      }
    }
    if ((!bool) && (f == ConstraintWidget.DimensionBehaviour.b))
    {
      localObject1 = b;
      i = n;
      if (i != 2)
      {
        if ((i == 3) && (!((ConstraintWidget)localObject1).f()))
        {
          localObject1 = b;
          if (i != 3)
          {
            localObject1 = d.c;
            c.b.add(localObject1);
            f.add(c);
            localObject1 = c;
            p = true;
            f.add(d);
            c.f.add(a);
          }
        }
      }
      else
      {
        localObject1 = ((ConstraintWidget)localObject1).listFiles();
        if (localObject1 != null)
        {
          localObject1 = e.c;
          c.b.add(localObject1);
          f.add(c);
          localObject1 = c;
          p = true;
          f.add(d);
          c.f.add(a);
        }
      }
    }
    else
    {
      ((DependencyNode)localObject2).b(this);
    }
    localObject1 = b;
    localObject2 = h;
    if ((2c != null) && (3c != null))
    {
      if (((ConstraintWidget)localObject1).f())
      {
        d.c = b.h[2].b();
        a.c = (-b.h[3].b());
      }
      else
      {
        localObject1 = a(b.h[2]);
        localObject2 = a(b.h[3]);
        ((DependencyNode)localObject1).b(this);
        ((DependencyNode)localObject2).b(this);
        this.i = WidgetRun.RunType.e;
      }
      if (b.q()) {
        a(a, d, 1, b);
      }
    }
    else if (2c != null)
    {
      localObject1 = a(localObject2[2]);
      if (localObject1 != null)
      {
        a(d, (DependencyNode)localObject1, b.h[2].b());
        a(a, d, 1, c);
        if (b.q()) {
          a(a, d, 1, b);
        }
        localObject2 = f;
        localObject1 = ConstraintWidget.DimensionBehaviour.b;
        if ((localObject2 == localObject1) && (b.p() > 0.0F))
        {
          localObject2 = b.d;
          if (f == localObject1)
          {
            c.f.add(c);
            c.b.add(b.d.c);
            c.g = this;
          }
        }
      }
    }
    else if (3c != null)
    {
      localObject1 = a(localObject2[3]);
      if (localObject1 != null)
      {
        a(a, (DependencyNode)localObject1, -b.h[3].b());
        a(d, a, -1, c);
        if (b.q()) {
          a(a, d, 1, b);
        }
      }
    }
    else if (4c != null)
    {
      localObject1 = a(localObject2[4]);
      if (localObject1 != null)
      {
        a(a, (DependencyNode)localObject1, 0);
        a(d, a, -1, b);
        a(a, d, 1, c);
      }
    }
    else if ((!(localObject1 instanceof AnnotationWriter)) && (((ConstraintWidget)localObject1).listFiles() != null))
    {
      localObject1 = b.listFiles().e.d;
      a(d, (DependencyNode)localObject1, b.max());
      a(a, d, 1, c);
      if (b.q()) {
        a(a, d, 1, b);
      }
      localObject2 = f;
      localObject1 = ConstraintWidget.DimensionBehaviour.b;
      if ((localObject2 == localObject1) && (b.p() > 0.0F))
      {
        localObject2 = b.d;
        if (f == localObject1)
        {
          c.f.add(c);
          c.b.add(b.d.c);
          c.g = this;
        }
      }
    }
    if (c.b.size() == 0) {
      c.e = true;
    }
  }
  
  boolean c()
  {
    if (f == ConstraintWidget.DimensionBehaviour.b) {
      return b.n == 0;
    }
    return true;
  }
  
  void d()
  {
    m = false;
    d.a();
    d.i = false;
    a.a();
    a.i = false;
    a.a();
    a.i = false;
    c.i = false;
  }
  
  public void e()
  {
    DependencyNode localDependencyNode = d;
    if (i) {
      b.remove(a);
    }
  }
  
  void f()
  {
    l = null;
    d.a();
    a.a();
    a.a();
    c.a();
    m = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VerticalRun ");
    localStringBuilder.append(b.getString());
    return localStringBuilder.toString();
  }
}
