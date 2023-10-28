package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ClassWriter;
import androidx.constraintlayout.solver.SolverVariable;

public class m
  extends Label
{
  private int a = 0;
  private boolean b = true;
  boolean j = false;
  private int k = 0;
  
  public m() {}
  
  public void a(ClassWriter paramClassWriter, boolean paramBoolean)
  {
    Object localObject1 = h;
    localObject1[0] = a;
    localObject1[2] = c;
    localObject1[1] = l;
    localObject1[3] = b;
    int i = 0;
    for (;;)
    {
      localObject1 = h;
      if (i >= localObject1.length) {
        break;
      }
      i = paramClassWriter.a(localObject1[i]);
      i += 1;
    }
    i = a;
    if ((i >= 0) && (i < 4))
    {
      localObject1 = localObject1[i];
      if (!j) {
        a();
      }
      if (j)
      {
        j = false;
        i = a;
        if ((i != 0) && (i != 1))
        {
          if ((i == 2) || (i == 3))
          {
            paramClassWriter.a(c.i, next);
            paramClassWriter.a(b.i, next);
          }
        }
        else
        {
          paramClassWriter.a(a.i, type);
          paramClassWriter.a(l.i, type);
        }
      }
      else
      {
        i = 0;
        Object localObject2;
        while (i < e)
        {
          localObject2 = b[i];
          if ((b) || (((ConstraintWidget)localObject2).m()))
          {
            m = a;
            if (((m == 0) || (m == 1)) && (((ConstraintWidget)localObject2).iterator() == ConstraintWidget.DimensionBehaviour.b) && (a.c != null) && (l.c != null)) {}
            do
            {
              paramBoolean = true;
              break;
              m = a;
            } while (((m == 2) || (m == 3)) && (((ConstraintWidget)localObject2).size() == ConstraintWidget.DimensionBehaviour.b) && (c.c != null) && (b.c != null));
          }
          i += 1;
        }
        paramBoolean = false;
        if ((!a.put()) && (!l.put())) {
          i = 0;
        } else {
          i = 1;
        }
        if ((!c.put()) && (!b.put())) {
          m = 0;
        } else {
          m = 1;
        }
        int n;
        if (!paramBoolean)
        {
          n = a;
          if (((n == 0) && (i != 0)) || ((n == 2) && (m != 0)) || ((n == 1) && (i != 0)) || ((n == 3) && (m != 0)))
          {
            m = 1;
            break label484;
          }
        }
        int m = 0;
        label484:
        i = 5;
        if (m == 0) {
          i = 4;
        }
        m = 0;
        while (m < e)
        {
          Object localObject3 = b[m];
          if ((b) || (((ConstraintWidget)localObject3).m()))
          {
            localObject2 = paramClassWriter.a(h[a]);
            localObject3 = h;
            int i1 = a;
            i = ((SolverVariable)localObject2);
            if ((c != null) && (c.b == this)) {
              n = a + 0;
            } else {
              n = 0;
            }
            if ((i1 != 0) && (i1 != 2)) {
              paramClassWriter.b(i, (SolverVariable)localObject2, k + n, paramBoolean);
            } else {
              paramClassWriter.a(i, (SolverVariable)localObject2, k - n, paramBoolean);
            }
            paramClassWriter.a(i, (SolverVariable)localObject2, k + n, i);
          }
          m += 1;
        }
        i = a;
        if (i == 0)
        {
          paramClassWriter.a(l.i, a.i, 0, 8);
          paramClassWriter.a(a.i, x.l.i, 0, 4);
          paramClassWriter.a(a.i, x.a.i, 0, 0);
          return;
        }
        if (i == 1)
        {
          paramClassWriter.a(a.i, l.i, 0, 8);
          paramClassWriter.a(a.i, x.a.i, 0, 4);
          paramClassWriter.a(a.i, x.l.i, 0, 0);
          return;
        }
        if (i == 2)
        {
          paramClassWriter.a(b.i, c.i, 0, 8);
          paramClassWriter.a(c.i, x.b.i, 0, 4);
          paramClassWriter.a(c.i, x.c.i, 0, 0);
          return;
        }
        if (i == 3)
        {
          paramClassWriter.a(c.i, b.i, 0, 8);
          paramClassWriter.a(c.i, x.c.i, 0, 4);
          paramClassWriter.a(c.i, x.b.i, 0, 0);
        }
      }
    }
  }
  
  public boolean a()
  {
    int i2 = 0;
    int i = 0;
    int n;
    ConstraintWidget localConstraintWidget;
    int i1;
    for (int m = 1;; m = n)
    {
      n = e;
      if (i >= n) {
        break;
      }
      localConstraintWidget = b[i];
      if ((!b) && (!localConstraintWidget.m()))
      {
        n = m;
      }
      else
      {
        n = a;
        if (((n == 0) || (n == 1)) && (!localConstraintWidget.h())) {}
        do
        {
          n = 0;
          break;
          i1 = a;
          if (i1 != 2)
          {
            n = m;
            if (i1 != 3) {
              break;
            }
          }
          n = m;
        } while (!localConstraintWidget.j());
      }
      i += 1;
    }
    if ((m != 0) && (n > 0))
    {
      i = 0;
      n = 0;
      while (i2 < e)
      {
        localConstraintWidget = b[i2];
        if ((b) || (localConstraintWidget.m()))
        {
          i1 = i;
          m = n;
          if (n == 0)
          {
            m = a;
            if (m == 0) {
              i = localConstraintWidget.a(ConstraintAnchor.Type.g).get();
            } else if (m == 1) {
              i = localConstraintWidget.a(ConstraintAnchor.Type.c).get();
            } else if (m == 2) {
              i = localConstraintWidget.a(ConstraintAnchor.Type.a).get();
            } else if (m == 3) {
              i = localConstraintWidget.a(ConstraintAnchor.Type.b).get();
            }
            m = 1;
            i1 = i;
          }
          int i3 = a;
          if (i3 == 0)
          {
            i = Math.min(i1, localConstraintWidget.a(ConstraintAnchor.Type.g).get());
            n = m;
          }
          else if (i3 == 1)
          {
            i = Math.max(i1, localConstraintWidget.a(ConstraintAnchor.Type.c).get());
            n = m;
          }
          else if (i3 == 2)
          {
            i = Math.min(i1, localConstraintWidget.a(ConstraintAnchor.Type.a).get());
            n = m;
          }
          else
          {
            i = i1;
            n = m;
            if (i3 == 3)
            {
              i = Math.max(i1, localConstraintWidget.a(ConstraintAnchor.Type.b).get());
              n = m;
            }
          }
        }
        i2 += 1;
      }
      i += k;
      m = a;
      if ((m != 0) && (m != 1)) {
        add(i, i);
      } else {
        a(i, i);
      }
      j = true;
      return true;
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    k = paramInt;
  }
  
  public boolean b()
  {
    return b;
  }
  
  protected void c()
  {
    int i = 0;
    while (i < e)
    {
      ConstraintWidget localConstraintWidget = b[i];
      int m = a;
      if ((m != 0) && (m != 1))
      {
        if ((m == 2) || (m == 3)) {
          localConstraintWidget.remove(1, true);
        }
      }
      else {
        localConstraintWidget.remove(0, true);
      }
      i += 1;
    }
  }
  
  public int e()
  {
    return a;
  }
  
  public int g()
  {
    return k;
  }
  
  public int getItemId()
  {
    int i = a;
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        if (i != 3) {
          return -1;
        }
      }
      else {
        return 1;
      }
    }
    else {
      return 0;
    }
    return 1;
  }
  
  public boolean h()
  {
    return j;
  }
  
  public boolean j()
  {
    return j;
  }
  
  public boolean m()
  {
    return true;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public void setTitle(int paramInt)
  {
    a = paramInt;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[Barrier] ");
    ((StringBuilder)localObject1).append(getString());
    ((StringBuilder)localObject1).append(" {");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 0;
    while (i < e)
    {
      ConstraintWidget localConstraintWidget = b[i];
      localObject2 = localObject1;
      if (i > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", ");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(localConstraintWidget.getString());
      localObject1 = ((StringBuilder)localObject1).toString();
      i += 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}");
    return ((StringBuilder)localObject2).toString();
  }
}
