package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.AnnotationWriter;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.List;

public class f
  extends WidgetRun
{
  private static int[] d = new int[2];
  
  public f(ConstraintWidget paramConstraintWidget)
  {
    super(paramConstraintWidget);
    d.d = DependencyNode.Type.d;
    a.d = DependencyNode.Type.b;
    j = 0;
  }
  
  private void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    paramInt1 = paramInt2 - paramInt1;
    paramInt2 = paramInt4 - paramInt3;
    if (paramInt5 != -1)
    {
      if (paramInt5 != 0)
      {
        if (paramInt5 != 1) {
          return;
        }
        paramInt2 = (int)(paramInt1 * paramFloat + 0.5F);
        paramArrayOfInt[0] = paramInt1;
        paramArrayOfInt[1] = paramInt2;
        return;
      }
      paramArrayOfInt[0] = ((int)(paramInt2 * paramFloat + 0.5F));
      paramArrayOfInt[1] = paramInt2;
      return;
    }
    paramInt3 = (int)(paramInt2 * paramFloat + 0.5F);
    paramInt4 = (int)(paramInt1 / paramFloat + 0.5F);
    if (paramInt3 <= paramInt1)
    {
      paramArrayOfInt[0] = paramInt3;
      paramArrayOfInt[1] = paramInt2;
      return;
    }
    if (paramInt4 <= paramInt2)
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt4;
    }
  }
  
  public void a(x paramX)
  {
    int i = YPositionMetric.a.a[this.i.ordinal()];
    Object localObject1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject1 = b;
          a(paramX, a, l, 0);
        }
      }
      else {
        b(paramX);
      }
    }
    else {
      visitFrame(paramX);
    }
    float f1;
    label245:
    label252:
    int j;
    int k;
    if ((!c.i) && (f == ConstraintWidget.DimensionBehaviour.b))
    {
      Object localObject2 = b;
      i = i;
      if (i != 2)
      {
        if (i == 3)
        {
          i = n;
          if ((i != 0) && (i != 3))
          {
            i = ((ConstraintWidget)localObject2).readUnsignedShort();
            float f2;
            if (i != -1)
            {
              if (i != 0)
              {
                if (i != 1)
                {
                  i = 0;
                  break label252;
                }
                paramX = b;
                f1 = e.c.a;
                f2 = paramX.p();
              }
              else
              {
                paramX = b;
                f1 = e.c.a / paramX.p();
                break label245;
              }
            }
            else
            {
              paramX = b;
              f1 = e.c.a;
              f2 = paramX.p();
            }
            f1 *= f2;
            i = (int)(f1 + 0.5F);
            c.a(i);
          }
          else
          {
            localObject1 = e;
            paramX = d;
            localObject1 = a;
            if (a.c != null) {
              i = 1;
            } else {
              i = 0;
            }
            if (c.c != null) {
              j = 1;
            } else {
              j = 0;
            }
            if (l.c != null) {
              k = 1;
            } else {
              k = 0;
            }
            int m;
            if (b.c != null) {
              m = 1;
            } else {
              m = 0;
            }
            int n = ((ConstraintWidget)localObject2).readUnsignedShort();
            if ((i != 0) && (j != 0) && (k != 0) && (m != 0))
            {
              f1 = b.p();
              int i1;
              int i2;
              int i3;
              int i4;
              if ((i) && (i))
              {
                localObject2 = d;
                if (!e) {
                  return;
                }
                if (!a.e) {
                  return;
                }
                i = b.get(0)).a;
                j = d.c;
                k = a.b.get(0)).a;
                m = a.c;
                i1 = a;
                i2 = c;
                i3 = a;
                i4 = c;
                a(d, i + j, k - m, i1 + i2, i3 - i4, f1, n);
                c.a(d[0]);
                b.e.c.a(d[1]);
                return;
              }
              localObject2 = d;
              if (i)
              {
                DependencyNode localDependencyNode = a;
                if (i) {
                  if (e)
                  {
                    if (!e) {
                      return;
                    }
                    i = a;
                    j = c;
                    k = a;
                    m = c;
                    i1 = b.get(0)).a;
                    i2 = c;
                    i3 = b.get(0)).a;
                    i4 = c;
                    a(d, i + j, k - m, i1 + i2, i3 - i4, f1, n);
                    c.a(d[0]);
                    b.e.c.a(d[1]);
                  }
                  else
                  {
                    return;
                  }
                }
              }
              localObject2 = d;
              if (e)
              {
                if ((!a.e) || (!e)) {
                  return;
                }
                if (!e) {
                  return;
                }
                i = b.get(0)).a;
                j = d.c;
                k = a.b.get(0)).a;
                m = a.c;
                i1 = b.get(0)).a;
                i2 = c;
                i3 = b.get(0)).a;
                i4 = c;
                a(d, i + j, k - m, i1 + i2, i3 - i4, f1, n);
                c.a(d[0]);
                b.e.c.a(d[1]);
              }
            }
            else if ((i != 0) && (k != 0))
            {
              if (d.e)
              {
                if (!a.e) {
                  return;
                }
                f1 = b.p();
                i = d.b.get(0)).a + d.c;
                j = a.b.get(0)).a - a.c;
                if ((n != -1) && (n != 0))
                {
                  if (n == 1)
                  {
                    j = a(j - i, 0);
                    i = j;
                    k = (int)(j / f1 + 0.5F);
                    j = a(k, 1);
                    if (k != j) {
                      i = (int)(j * f1 + 0.5F);
                    }
                    c.a(i);
                    b.e.c.a(j);
                  }
                }
                else
                {
                  j = a(j - i, 0);
                  i = j;
                  k = (int)(j * f1 + 0.5F);
                  j = a(k, 1);
                  if (k != j) {
                    i = (int)(j / f1 + 0.5F);
                  }
                  c.a(i);
                  b.e.c.a(j);
                }
              }
            }
            else if ((j != 0) && (m != 0))
            {
              if (e)
              {
                if (!e) {
                  return;
                }
                f1 = b.p();
                i = b.get(0)).a + c;
                j = b.get(0)).a - c;
                if (n != -1) {
                  if (n != 0)
                  {
                    if (n != 1) {
                      break label1582;
                    }
                  }
                  else
                  {
                    j = a(j - i, 1);
                    i = j;
                    k = (int)(j * f1 + 0.5F);
                    j = a(k, 0);
                    if (k != j) {
                      i = (int)(j / f1 + 0.5F);
                    }
                    c.a(j);
                    b.e.c.a(i);
                    break label1582;
                  }
                }
                j = a(j - i, 1);
                i = j;
                k = (int)(j / f1 + 0.5F);
                j = a(k, 0);
                if (k != j) {
                  i = (int)(j * f1 + 0.5F);
                }
                c.a(j);
                b.e.c.a(i);
              }
            }
          }
        }
      }
      else
      {
        paramX = ((ConstraintWidget)localObject2).listFiles();
        if (paramX != null)
        {
          paramX = d.c;
          if (i)
          {
            f1 = b.v;
            i = (int)(a * f1 + 0.5F);
            c.a(i);
          }
        }
      }
    }
    label1582:
    paramX = d;
    if (e)
    {
      localObject1 = a;
      if (!e) {
        return;
      }
      if ((i) && (i) && (c.i)) {
        return;
      }
      if ((!c.i) && (f == ConstraintWidget.DimensionBehaviour.b))
      {
        paramX = b;
        if ((i == 0) && (!paramX.equals()))
        {
          localObject1 = (DependencyNode)d.b.get(0);
          paramX = (DependencyNode)a.b.get(0);
          i = a;
          localObject1 = d;
          i += c;
          j = a + a.c;
          ((DependencyNode)localObject1).a(i);
          a.a(j);
          c.a(j - i);
          return;
        }
      }
      if ((!c.i) && (f == ConstraintWidget.DimensionBehaviour.b) && (g == 1) && (d.b.size() > 0) && (a.b.size() > 0))
      {
        paramX = (DependencyNode)d.b.get(0);
        localObject1 = (DependencyNode)a.b.get(0);
        i = a;
        j = d.c;
        i = Math.min(a + a.c - (i + j), c.a);
        paramX = b;
        k = w;
        j = Math.max(r, i);
        i = j;
        if (k > 0) {
          i = Math.min(k, j);
        }
        c.a(i);
      }
      if (!c.i) {
        return;
      }
      paramX = (DependencyNode)d.b.get(0);
      localObject1 = (DependencyNode)a.b.get(0);
      i = a + d.c;
      j = a + a.c;
      f1 = b.height();
      if (paramX == localObject1)
      {
        i = a;
        j = a;
        f1 = 0.5F;
      }
      k = c.a;
      d.a((int)(i + 0.5F + (j - i - k) * f1));
      a.a(d.a + c.a);
    }
  }
  
  void b()
  {
    Object localObject1 = b;
    if (k) {
      c.a(((ConstraintWidget)localObject1).getValue());
    }
    int i;
    if (!c.i)
    {
      localObject2 = b.iterator();
      f = ((ConstraintWidget.DimensionBehaviour)localObject2);
      if (localObject2 != ConstraintWidget.DimensionBehaviour.b)
      {
        localObject1 = ConstraintWidget.DimensionBehaviour.g;
        if (localObject2 == localObject1)
        {
          localObject2 = b.listFiles();
          if (((localObject2 != null) && (((ConstraintWidget)localObject2).iterator() == ConstraintWidget.DimensionBehaviour.a)) || (((ConstraintWidget)localObject2).iterator() == localObject1))
          {
            i = ((ConstraintWidget)localObject2).getValue();
            int j = b.a.b();
            int k = b.l.b();
            a(d, d.d, b.a.b());
            a(a, d.a, -b.l.b());
            c.a(i - j - k);
            return;
          }
        }
        if (f == ConstraintWidget.DimensionBehaviour.a) {
          c.a(b.getValue());
        }
      }
    }
    else
    {
      localObject2 = f;
      localObject1 = ConstraintWidget.DimensionBehaviour.g;
      if (localObject2 == localObject1)
      {
        localObject2 = b.listFiles();
        if (((localObject2 != null) && (((ConstraintWidget)localObject2).iterator() == ConstraintWidget.DimensionBehaviour.a)) || (((ConstraintWidget)localObject2).iterator() == localObject1))
        {
          a(d, d.d, b.a.b());
          a(a, d.a, -b.l.b());
          return;
        }
      }
    }
    localObject1 = c;
    if (i)
    {
      localObject2 = b;
      if (k)
      {
        localObject1 = h;
        if ((0c != null) && (1c != null))
        {
          if (((ConstraintWidget)localObject2).equals())
          {
            d.c = b.h[0].b();
            a.c = (-b.h[1].b());
            return;
          }
          localObject1 = a(b.h[0]);
          if (localObject1 != null) {
            a(d, (DependencyNode)localObject1, b.h[0].b());
          }
          localObject1 = a(b.h[1]);
          if (localObject1 != null) {
            a(a, (DependencyNode)localObject1, -b.h[1].b());
          }
          d.p = true;
          a.p = true;
          return;
        }
        if (0c != null)
        {
          localObject1 = a(localObject1[0]);
          if (localObject1 == null) {
            return;
          }
          a(d, (DependencyNode)localObject1, b.h[0].b());
          a(a, d, c.a);
          return;
        }
        if (1c != null)
        {
          localObject1 = a(localObject1[1]);
          if (localObject1 == null) {
            return;
          }
          a(a, (DependencyNode)localObject1, -b.h[1].b());
          a(d, a, -c.a);
          return;
        }
        if (((localObject2 instanceof AnnotationWriter)) || (((ConstraintWidget)localObject2).listFiles() == null) || (b.a(ConstraintAnchor.Type.i).c != null)) {
          return;
        }
        localObject1 = b.listFiles().d.d;
        a(d, (DependencyNode)localObject1, b.d());
        a(a, d, c.a);
        return;
      }
    }
    if (f == ConstraintWidget.DimensionBehaviour.b)
    {
      localObject2 = b;
      i = i;
      if (i != 2)
      {
        if (i == 3) {
          if (n == 3)
          {
            d.g = this;
            a.g = this;
            m localM = e;
            d.g = this;
            a.g = this;
            g = this;
            if (((ConstraintWidget)localObject2).f())
            {
              c.b.add(b.e.c);
              b.e.c.f.add(c);
              localObject1 = b.e;
              c.g = this;
              c.b.add(d);
              c.b.add(b.e.a);
              b.e.d.f.add(c);
              b.e.a.f.add(c);
            }
            else if (b.equals())
            {
              b.e.c.b.add(c);
              c.f.add(b.e.c);
            }
            else
            {
              b.e.c.b.add(c);
            }
          }
          else
          {
            localObject2 = e.c;
            b.add(localObject2);
            f.add(c);
            b.e.d.f.add(c);
            b.e.a.f.add(c);
            localObject1 = c;
            p = true;
            f.add(d);
            c.f.add(a);
            d.b.add(c);
            a.b.add(c);
          }
        }
      }
      else
      {
        localObject1 = ((ConstraintWidget)localObject2).listFiles();
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
    localObject1 = b;
    Object localObject2 = h;
    if ((0c != null) && (1c != null))
    {
      if (((ConstraintWidget)localObject1).equals())
      {
        d.c = b.h[0].b();
        a.c = (-b.h[1].b());
        return;
      }
      localObject1 = a(b.h[0]);
      localObject2 = a(b.h[1]);
      ((DependencyNode)localObject1).b(this);
      ((DependencyNode)localObject2).b(this);
      this.i = WidgetRun.RunType.e;
      return;
    }
    if (0c != null)
    {
      localObject1 = a(localObject2[0]);
      if (localObject1 != null)
      {
        a(d, (DependencyNode)localObject1, b.h[0].b());
        a(a, d, 1, c);
      }
    }
    else if (1c != null)
    {
      localObject1 = a(localObject2[1]);
      if (localObject1 != null)
      {
        a(a, (DependencyNode)localObject1, -b.h[1].b());
        a(d, a, -1, c);
      }
    }
    else if ((!(localObject1 instanceof AnnotationWriter)) && (((ConstraintWidget)localObject1).listFiles() != null))
    {
      localObject1 = b.listFiles().d.d;
      a(d, (DependencyNode)localObject1, b.d());
      a(a, d, 1, c);
    }
  }
  
  boolean c()
  {
    if (f == ConstraintWidget.DimensionBehaviour.b) {
      return b.i == 0;
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
    c.i = false;
  }
  
  public void e()
  {
    DependencyNode localDependencyNode = d;
    if (i) {
      b.e(a);
    }
  }
  
  void f()
  {
    l = null;
    d.a();
    a.a();
    c.a();
    m = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HorizontalRun ");
    localStringBuilder.append(b.getString());
    return localStringBuilder.toString();
  }
}
