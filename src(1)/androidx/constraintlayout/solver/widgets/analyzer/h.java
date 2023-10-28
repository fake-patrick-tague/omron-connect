package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.f;
import java.util.ArrayList;
import java.util.Iterator;

public class h
  extends WidgetRun
{
  ArrayList<WidgetRun> b = new ArrayList();
  private int k;
  
  public h(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    super(paramConstraintWidget);
    j = paramInt;
    a();
  }
  
  private void a()
  {
    Object localObject2 = b;
    Object localObject3;
    for (Object localObject1 = ((ConstraintWidget)localObject2).p(j);; localObject1 = ((ConstraintWidget)localObject1).p(j))
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
    }
    b = localObject3;
    b.add(localObject3.toString(j));
    for (localObject1 = localObject3.read(j); localObject1 != null; localObject1 = ((ConstraintWidget)localObject1).read(j)) {
      b.add(((ConstraintWidget)localObject1).toString(j));
    }
    localObject1 = b.iterator();
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WidgetRun)((Iterator)localObject1).next();
      i = j;
      if (i == 0) {
        b.A = this;
      } else if (i == 1) {
        b.Q = this;
      }
    }
    if ((j == 0) && (((f)b.listFiles()).c())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (b.size() > 1))
    {
      localObject1 = b;
      b = getsize1b;
    }
    if (j == 0) {
      i = b.getCount();
    } else {
      i = b.newClass();
    }
    k = i;
  }
  
  private ConstraintWidget d()
  {
    int i = b.size() - 1;
    while (i >= 0)
    {
      WidgetRun localWidgetRun = (WidgetRun)b.get(i);
      if (b.get() != 8) {
        return b;
      }
      i -= 1;
    }
    return null;
  }
  
  private ConstraintWidget flush()
  {
    int i = 0;
    while (i < b.size())
    {
      WidgetRun localWidgetRun = (WidgetRun)b.get(i);
      if (b.get() != 8) {
        return b;
      }
      i += 1;
    }
    return null;
  }
  
  public void a(x paramX)
  {
    if (d.i)
    {
      if (!a.i) {
        return;
      }
      paramX = b.listFiles();
      boolean bool;
      if ((paramX != null) && ((paramX instanceof f))) {
        bool = ((f)paramX).c();
      } else {
        bool = false;
      }
      int i12 = a.a - d.a;
      int i11 = b.size();
      int i = 0;
      for (;;)
      {
        j = -1;
        if (i >= i11) {
          break;
        }
        i6 = i;
        if (b.get(i)).b.get() != 8) {
          break label133;
        }
        i += 1;
      }
      int i6 = -1;
      label133:
      int i10 = i11 - 1;
      i = i10;
      for (;;)
      {
        i7 = j;
        if (i < 0) {
          break label188;
        }
        if (b.get(i)).b.get() != 8) {
          break;
        }
        i -= 1;
      }
      int i7 = i;
      label188:
      int i1 = 0;
      int i2;
      int i3;
      int i4;
      Label localLabel;
      label434:
      label446:
      float f2;
      while (i1 < 2)
      {
        i2 = 0;
        m = 0;
        i = 0;
        n = 0;
        f1 = 0.0F;
        while (i2 < i11)
        {
          paramX = (WidgetRun)b.get(i2);
          if (b.get() == 8)
          {
            i3 = i;
            j = m;
          }
          else
          {
            i4 = n + 1;
            j = m;
            if (i2 > 0)
            {
              j = m;
              if (i2 >= i6) {
                j = m + d.c;
              }
            }
            localLabel = c;
            n = a;
            i3 = n;
            if (f != ConstraintWidget.DimensionBehaviour.b) {
              m = 1;
            } else {
              m = 0;
            }
            if (m != 0)
            {
              i3 = this.j;
              if ((i3 == 0) && (!b.d.c.i)) {
                return;
              }
              if ((i3 == 1) && (!b.e.c.i)) {
                return;
              }
            }
            else
            {
              if ((g == 1) && (i1 == 0))
              {
                m = a;
                i += 1;
              }
              else
              {
                if (!i) {
                  break label434;
                }
                m = i3;
              }
              n = 1;
              break label446;
            }
            i3 = n;
            n = m;
            m = i3;
            if (n == 0)
            {
              n = i + 1;
              float f3 = b.P[this.j];
              i = n;
              m = j;
              f2 = f1;
              if (f3 >= 0.0F)
              {
                f2 = f1 + f3;
                i = n;
                m = j;
              }
            }
            else
            {
              m = j + m;
              f2 = f1;
            }
            i3 = i;
            j = m;
            n = i4;
            f1 = f2;
            if (i2 < i10)
            {
              i3 = i;
              j = m;
              n = i4;
              f1 = f2;
              if (i2 < i7)
              {
                j = m + -a.c;
                f1 = f2;
                n = i4;
                i3 = i;
              }
            }
          }
          i2 += 1;
          i = i3;
          m = j;
        }
        if ((m >= i12) && (i != 0))
        {
          i1 += 1;
        }
        else
        {
          j = i;
          i1 = n;
          break label641;
        }
      }
      i1 = 0;
      int m = 0;
      int j = 0;
      float f1 = 0.0F;
      label641:
      int n = d.a;
      if (bool) {
        n = a.a;
      }
      i = n;
      if (m > i12) {
        if (bool) {
          i = n + (int)((m - i12) / 2.0F + 0.5F);
        } else {
          i = n - (int)((m - i12) / 2.0F + 0.5F);
        }
      }
      if (j > 0)
      {
        f2 = i12 - m;
        i3 = (int)(f2 / j + 0.5F);
        int i8 = 0;
        int i5;
        for (i2 = 0; i8 < i11; i2 = i5)
        {
          paramX = (WidgetRun)b.get(i8);
          if (b.get() == 8)
          {
            i5 = i2;
          }
          else
          {
            i5 = i2;
            if (f == ConstraintWidget.DimensionBehaviour.b)
            {
              localLabel = c;
              i5 = i2;
              if (!i)
              {
                n = i3;
                if (f1 > 0.0F) {
                  n = (int)(b.P[this.j] * f2 / f1 + 0.5F);
                }
                ConstraintWidget localConstraintWidget;
                if (this.j == 0)
                {
                  localConstraintWidget = b;
                  i9 = w;
                  i5 = r;
                  if (g == 1) {
                    i4 = Math.min(n, a);
                  } else {
                    i4 = n;
                  }
                  i5 = Math.max(i5, i4);
                  i4 = i5;
                  if (i9 > 0) {
                    i4 = Math.min(i9, i5);
                  }
                  i5 = i2;
                  i9 = n;
                  if (i4 == n) {
                    break label1050;
                  }
                }
                else
                {
                  localConstraintWidget = b;
                  i9 = m;
                  i5 = s;
                  if (g == 1) {
                    i4 = Math.min(n, a);
                  } else {
                    i4 = n;
                  }
                  i5 = Math.max(i5, i4);
                  i4 = i5;
                  if (i9 > 0) {
                    i4 = Math.min(i9, i5);
                  }
                  i5 = i2;
                  i9 = n;
                  if (i4 == n) {
                    break label1050;
                  }
                }
                i5 = i2 + 1;
                int i9 = i4;
                label1050:
                c.a(i9);
              }
            }
          }
          i8 += 1;
        }
        n = j;
        if (i2 > 0)
        {
          i3 = j - i2;
          m = 0;
          j = 0;
          while (m < i11)
          {
            paramX = (WidgetRun)b.get(m);
            if (b.get() != 8)
            {
              n = j;
              if (m > 0)
              {
                n = j;
                if (m >= i6) {
                  n = j + d.c;
                }
              }
              n += c.a;
              j = n;
              if (m < i10)
              {
                j = n;
                if (m < i7) {
                  j = n + -a.c;
                }
              }
            }
            m += 1;
          }
          n = i3;
          m = j;
        }
        if ((k == 2) && (i2 == 0))
        {
          k = 0;
          i2 = n;
        }
        else
        {
          i2 = n;
        }
      }
      else
      {
        i2 = j;
      }
      j = i;
      if (m > i12) {
        k = 2;
      }
      if ((i1 > 0) && (i2 == 0) && (i6 == i7)) {
        k = 2;
      }
      i = k;
      if (i == 1)
      {
        if (i1 > 1) {
          i = (i12 - m) / (i1 - 1);
        } else if (i1 == 1) {
          i = (i12 - m) / 2;
        } else {
          i = 0;
        }
        n = i;
        if (i2 > 0) {
          n = 0;
        }
        i = 0;
        m = j;
        j = i;
        while (j < i11)
        {
          if (bool) {
            i = i11 - (j + 1);
          } else {
            i = j;
          }
          paramX = (WidgetRun)b.get(i);
          if (b.get() == 8)
          {
            d.a(m);
            a.a(m);
            i = m;
          }
          else
          {
            i = m;
            if (j > 0) {
              if (bool) {
                i = m - n;
              } else {
                i = m + n;
              }
            }
            m = i;
            if (j > 0)
            {
              m = i;
              if (j >= i6) {
                if (bool) {
                  m = i - d.c;
                } else {
                  m = i + d.c;
                }
              }
            }
            if (bool) {
              a.a(m);
            } else {
              d.a(m);
            }
            localLabel = c;
            i1 = a;
            i = i1;
            if (f == ConstraintWidget.DimensionBehaviour.b)
            {
              i = i1;
              if (g == 1) {
                i = a;
              }
            }
            if (bool) {
              m -= i;
            } else {
              m += i;
            }
            if (bool) {
              d.a(m);
            } else {
              a.a(m);
            }
            m = true;
            i = m;
            if (j < i10)
            {
              i = m;
              if (j < i7) {
                if (bool) {
                  i = m - -a.c;
                } else {
                  i = m + -a.c;
                }
              }
            }
          }
          j += 1;
          m = i;
        }
      }
      if (i == 0)
      {
        n = (i12 - m) / (i1 + 1);
        if (i2 > 0) {
          n = 0;
        }
        m = 0;
        i = j;
        j = m;
        while (j < i11)
        {
          if (bool) {
            m = i11 - (j + 1);
          } else {
            m = j;
          }
          paramX = (WidgetRun)b.get(m);
          if (b.get() == 8)
          {
            d.a(i);
            a.a(i);
          }
          else
          {
            if (bool) {
              m = i - n;
            } else {
              m = i + n;
            }
            i = m;
            if (j > 0)
            {
              i = m;
              if (j >= i6) {
                if (bool) {
                  i = m - d.c;
                } else {
                  i = m + d.c;
                }
              }
            }
            if (bool) {
              a.a(i);
            } else {
              d.a(i);
            }
            localLabel = c;
            i1 = a;
            m = i1;
            if (f == ConstraintWidget.DimensionBehaviour.b)
            {
              m = i1;
              if (g == 1) {
                m = Math.min(i1, a);
              }
            }
            if (bool) {
              m = i - m;
            } else {
              m = i + m;
            }
            if (bool) {
              d.a(m);
            } else {
              a.a(m);
            }
            i = m;
            if (j < i10)
            {
              i = m;
              if (j < i7) {
                if (bool) {
                  i = m - -a.c;
                } else {
                  i = m + -a.c;
                }
              }
            }
          }
          j += 1;
        }
      }
      if (i == 2)
      {
        if (this.j == 0) {
          f1 = b.height();
        } else {
          f1 = b.remove();
        }
        f2 = f1;
        if (bool) {
          f2 = 1.0F - f1;
        }
        i = (int)((i12 - m) * f2 + 0.5F);
        if ((i < 0) || (i2 > 0)) {
          i = 0;
        }
        if (bool) {
          i = j - i;
        } else {
          i = j + i;
        }
        j = 0;
        while (j < i11)
        {
          if (bool) {
            m = i11 - (j + 1);
          } else {
            m = j;
          }
          paramX = (WidgetRun)b.get(m);
          if (b.get() == 8)
          {
            d.a(i);
            a.a(i);
          }
          else
          {
            m = i;
            if (j > 0)
            {
              m = i;
              if (j >= i6) {
                if (bool) {
                  m = i - d.c;
                } else {
                  m = i + d.c;
                }
              }
            }
            if (bool) {
              a.a(m);
            } else {
              d.a(m);
            }
            localLabel = c;
            n = a;
            i = n;
            if (f == ConstraintWidget.DimensionBehaviour.b)
            {
              i = n;
              if (g == 1) {
                i = a;
              }
            }
            if (bool) {
              m -= i;
            } else {
              m += i;
            }
            if (bool) {
              d.a(m);
            } else {
              a.a(m);
            }
            i = m;
            if (j < i10)
            {
              i = m;
              if (j < i7) {
                if (bool) {
                  i = m - -a.c;
                } else {
                  i = m + -a.c;
                }
              }
            }
          }
          j += 1;
        }
      }
    }
  }
  
  void b()
  {
    Object localObject1 = b.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((WidgetRun)((Iterator)localObject1).next()).b();
    }
    int i = b.size();
    if (i < 1) {
      return;
    }
    Object localObject2 = b.get(0)).b;
    localObject1 = b.get(i - 1)).b;
    DependencyNode localDependencyNode;
    if (j == 0)
    {
      localObject2 = a;
      localObject1 = l;
      localDependencyNode = a((ConstraintAnchor)localObject2, 0);
      i = ((ConstraintAnchor)localObject2).b();
      localObject2 = flush();
      if (localObject2 != null) {
        i = a.b();
      }
      if (localDependencyNode != null) {
        a(d, localDependencyNode, i);
      }
      localObject2 = a((ConstraintAnchor)localObject1, 0);
      i = ((ConstraintAnchor)localObject1).b();
      localObject1 = d();
      if (localObject1 != null) {
        i = l.b();
      }
      if (localObject2 != null) {
        a(a, (DependencyNode)localObject2, -i);
      }
    }
    else
    {
      localObject2 = c;
      localObject1 = b;
      localDependencyNode = a((ConstraintAnchor)localObject2, 1);
      i = ((ConstraintAnchor)localObject2).b();
      localObject2 = flush();
      if (localObject2 != null) {
        i = c.b();
      }
      if (localDependencyNode != null) {
        a(d, localDependencyNode, i);
      }
      localObject2 = a((ConstraintAnchor)localObject1, 1);
      i = ((ConstraintAnchor)localObject1).b();
      localObject1 = d();
      if (localObject1 != null) {
        i = b.b();
      }
      if (localObject2 != null) {
        a(a, (DependencyNode)localObject2, -i);
      }
    }
    d.g = this;
    a.g = this;
  }
  
  boolean c()
  {
    int j = b.size();
    int i = 0;
    while (i < j)
    {
      if (!((WidgetRun)b.get(i)).c()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public long draw()
  {
    int j = b.size();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      WidgetRun localWidgetRun = (WidgetRun)b.get(i);
      l = l + d.c + localWidgetRun.draw() + a.c;
      i += 1;
    }
    return l;
  }
  
  public void e()
  {
    int i = 0;
    while (i < b.size())
    {
      ((WidgetRun)b.get(i)).e();
      i += 1;
    }
  }
  
  void f()
  {
    l = null;
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((WidgetRun)localIterator.next()).f();
    }
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ChainRun ");
    if (j == 0) {
      str = "horizontal : ";
    } else {
      str = "vertical : ";
    }
    ((StringBuilder)localObject1).append(str);
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (WidgetRun)((Iterator)localObject1).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("<");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(localObject2);
      str = localStringBuilder.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("> ");
      str = ((StringBuilder)localObject2).toString();
    }
    return str;
  }
}
