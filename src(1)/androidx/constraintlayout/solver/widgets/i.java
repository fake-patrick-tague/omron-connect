package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

public class i
{
  protected ConstraintWidget a;
  protected ConstraintWidget b;
  protected ArrayList<ConstraintWidget> c;
  protected boolean d;
  boolean e;
  private boolean f;
  protected int g;
  protected boolean h;
  protected ConstraintWidget i;
  protected int j;
  protected boolean k;
  int l;
  protected float m = 0.0F;
  private int n;
  int o;
  protected boolean p;
  int q;
  protected ConstraintWidget r;
  protected ConstraintWidget s;
  private boolean t = false;
  protected ConstraintWidget w;
  protected ConstraintWidget x;
  
  public i(ConstraintWidget paramConstraintWidget, int paramInt, boolean paramBoolean)
  {
    a = paramConstraintWidget;
    n = paramInt;
    t = paramBoolean;
  }
  
  private void a()
  {
    int i2 = n * 2;
    Object localObject1 = a;
    boolean bool = true;
    e = true;
    Object localObject2 = localObject1;
    int i1 = 0;
    while (i1 == 0)
    {
      g += 1;
      Object localObject4 = bottom;
      int i3 = n;
      Object localObject3 = null;
      localObject4[i3] = null;
      S[i3] = null;
      Object localObject5;
      if (((ConstraintWidget)localObject1).get() != 8)
      {
        q += 1;
        localObject5 = ((ConstraintWidget)localObject1).valueOf(n);
        localObject4 = ConstraintWidget.DimensionBehaviour.b;
        if (localObject5 != localObject4) {
          o += ((ConstraintWidget)localObject1).indexOf(n);
        }
        int i4 = o + h[i2].b();
        o = i4;
        localObject5 = h;
        i3 = i2 + 1;
        o = (i4 + localObject5[i3].b());
        i4 = l + h[i2].b();
        l = i4;
        l = (i4 + h[i3].b());
        if (b == null) {
          b = ((ConstraintWidget)localObject1);
        }
        i = ((ConstraintWidget)localObject1);
        localObject5 = u;
        i3 = n;
        if (localObject5[i3] == localObject4)
        {
          localObject4 = o;
          if ((localObject4[i3] == 0) || (localObject4[i3] == 3) || (localObject4[i3] == 2))
          {
            j += 1;
            localObject4 = P;
            float f1 = localObject4[i3];
            if (f1 > 0.0F) {
              m += localObject4[i3];
            }
            if (a((ConstraintWidget)localObject1, i3))
            {
              if (f1 < 0.0F) {
                h = true;
              } else {
                k = true;
              }
              if (c == null) {
                c = new ArrayList();
              }
              c.add(localObject1);
            }
            if (r == null) {
              r = ((ConstraintWidget)localObject1);
            }
            localObject4 = w;
            if (localObject4 != null) {
              S[n] = localObject1;
            }
            w = ((ConstraintWidget)localObject1);
          }
          if (n == 0)
          {
            if (i != 0) {
              e = false;
            } else if ((r != 0) || (w != 0)) {
              e = false;
            }
          }
          else if (n != 0) {
            e = false;
          } else if ((s != 0) || (m != 0)) {
            e = false;
          }
          if (right != 0.0F)
          {
            e = false;
            p = true;
          }
        }
      }
      if (localObject2 != localObject1) {
        bottom[n] = localObject1;
      }
      localObject4 = h[(i2 + 1)].c;
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = b;
        localObject5 = h;
        localObject2 = localObject3;
        if (c != null) {
          if (c.b != localObject1) {
            localObject2 = localObject3;
          } else {
            localObject2 = localObject4;
          }
        }
      }
      if (localObject2 == null)
      {
        localObject2 = localObject1;
        i1 = 1;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    localObject2 = b;
    if (localObject2 != null) {
      o -= h[i2].b();
    }
    localObject2 = i;
    if (localObject2 != null) {
      o -= h[(i2 + 1)].b();
    }
    s = ((ConstraintWidget)localObject1);
    if ((n == 0) && (t)) {
      x = ((ConstraintWidget)localObject1);
    } else {
      x = a;
    }
    if ((!k) || (!h)) {
      bool = false;
    }
    d = bool;
  }
  
  private static boolean a(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if ((paramConstraintWidget.get() != 8) && (u[paramInt] == ConstraintWidget.DimensionBehaviour.b))
    {
      paramConstraintWidget = o;
      if ((paramConstraintWidget[paramInt] == 0) || (paramConstraintWidget[paramInt] == 3)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    if (!f) {
      a();
    }
    f = true;
  }
}
