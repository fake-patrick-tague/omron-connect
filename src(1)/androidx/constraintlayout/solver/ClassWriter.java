package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class ClassWriter
{
  public static long G;
  public static long H;
  public static boolean I;
  public static Edge c;
  public static boolean d;
  public static boolean e;
  public static boolean h;
  public static boolean j;
  private static int t;
  public boolean B = false;
  final Item a;
  h[] b = null;
  int f = 0;
  public boolean i = false;
  private l k;
  private boolean[] l = new boolean[32];
  private HashMap<String, SolverVariable> m = null;
  private int n = 32;
  private int o = 32;
  private int p = 32;
  private int q = 0;
  int r = 0;
  int s = 1;
  private l v;
  public boolean w = false;
  private SolverVariable[] x = new SolverVariable[t];
  
  public ClassWriter()
  {
    draw();
    Item localItem = new Item();
    a = localItem;
    k = new m(localItem);
    if (h)
    {
      v = new ByteVector(this, localItem);
      return;
    }
    v = new h(localItem);
  }
  
  private int a(l paramL)
    throws Exception
  {
    int i1 = 0;
    while (i1 < f)
    {
      paramL = b;
      if ((c.q != SolverVariable.Type.u) && (i < 0.0F))
      {
        i1 = 1;
        break label66;
      }
      i1 += 1;
    }
    i1 = 0;
    label66:
    if (i1 != 0)
    {
      int i5 = 0;
      i1 = 0;
      while (i5 == 0) {
        if (c == null)
        {
          int i11 = i1 + 1;
          float f1 = Float.MAX_VALUE;
          i1 = 0;
          int i2 = -1;
          int i3 = -1;
          int i9;
          SolverVariable localSolverVariable;
          for (int i4 = 0; i1 < f; i4 = i9)
          {
            paramL = b[i1];
            float f2;
            int i7;
            int i8;
            if (c.q == SolverVariable.Type.u)
            {
              f2 = f1;
              i7 = i2;
              i8 = i3;
              i9 = i4;
            }
            else if (f)
            {
              f2 = f1;
              i7 = i2;
              i8 = i3;
              i9 = i4;
            }
            else
            {
              f2 = f1;
              i7 = i2;
              i8 = i3;
              i9 = i4;
              if (i < 0.0F)
              {
                int i10;
                float f3;
                if (e)
                {
                  int i12 = b.f();
                  i10 = 0;
                  for (;;)
                  {
                    f2 = f1;
                    i7 = i2;
                    i8 = i3;
                    i9 = i4;
                    if (i10 >= i12) {
                      break;
                    }
                    localSolverVariable = b.a(i10);
                    f3 = b.a(localSolverVariable);
                    if (f3 <= 0.0F)
                    {
                      f2 = f1;
                      i7 = i2;
                      i8 = i3;
                      i9 = i4;
                    }
                    else
                    {
                      i6 = 0;
                      for (;;)
                      {
                        f2 = f1;
                        i7 = i2;
                        i8 = i3;
                        i9 = i4;
                        if (i6 >= 9) {
                          break;
                        }
                        f2 = d[i6] / f3;
                        if ((f2 >= f1) || (i6 != i4))
                        {
                          i7 = i4;
                          if (i6 <= i4) {}
                        }
                        else
                        {
                          i3 = b;
                          i7 = i6;
                          i2 = i1;
                          f1 = f2;
                        }
                        i6 += 1;
                        i4 = i7;
                      }
                    }
                    i10 += 1;
                    f1 = f2;
                    i2 = i7;
                    i3 = i8;
                    i4 = i9;
                  }
                }
                int i6 = 1;
                for (;;)
                {
                  f2 = f1;
                  i7 = i2;
                  i8 = i3;
                  i9 = i4;
                  if (i6 >= s) {
                    break;
                  }
                  localSolverVariable = a.n[i6];
                  f3 = b.a(localSolverVariable);
                  if (f3 <= 0.0F)
                  {
                    f2 = f1;
                    i8 = i2;
                    i9 = i3;
                    i10 = i4;
                  }
                  else
                  {
                    i7 = 0;
                    for (;;)
                    {
                      f2 = f1;
                      i8 = i2;
                      i9 = i3;
                      i10 = i4;
                      if (i7 >= 9) {
                        break;
                      }
                      f2 = d[i7] / f3;
                      if ((f2 >= f1) || (i7 != i4))
                      {
                        i8 = i4;
                        if (i7 <= i4) {}
                      }
                      else
                      {
                        i3 = i6;
                        i8 = i7;
                        i2 = i1;
                        f1 = f2;
                      }
                      i7 += 1;
                      i4 = i8;
                    }
                  }
                  i6 += 1;
                  f1 = f2;
                  i2 = i8;
                  i3 = i9;
                  i4 = i10;
                }
              }
            }
            i1 += 1;
            f1 = f2;
            i2 = i7;
            i3 = i8;
          }
          if (i2 != -1)
          {
            paramL = b[i2];
            c.f = -1;
            if (c == null)
            {
              paramL.a(a.n[i3]);
              localSolverVariable = c;
              f = i2;
              localSolverVariable.a(this, paramL);
            }
            else
            {
              throw new NullPointerException("Null throw statement replaced by Soot");
            }
          }
          else
          {
            i5 = 1;
          }
          i1 = i11;
          if (i11 > s / 2)
          {
            i5 = 1;
            i1 = i11;
          }
        }
        else
        {
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
      }
      return i1;
    }
    return 0;
  }
  
  private final int a(l paramL, boolean paramBoolean)
  {
    int i1;
    if (c == null)
    {
      i1 = 0;
      while (i1 < s)
      {
        l[i1] = false;
        i1 += 1;
      }
      int i2 = 0;
      i1 = 0;
      for (;;)
      {
        if (i2 != 0) {
          break label422;
        }
        if (c != null) {
          break;
        }
        int i5 = i1 + 1;
        if (i5 >= s * 2) {
          return i5;
        }
        if (paramL.getKey() != null) {
          l[getKeyb] = true;
        }
        SolverVariable localSolverVariable = paramL.a(this, l);
        Object localObject;
        if (localSolverVariable != null)
        {
          localObject = l;
          i1 = b;
          if (localObject[i1] != 0) {
            return i5;
          }
          localObject[i1] = 1;
        }
        if (localSolverVariable != null)
        {
          float f1 = Float.MAX_VALUE;
          i1 = 0;
          int i4;
          for (int i3 = -1; i1 < f; i3 = i4)
          {
            localObject = b[i1];
            float f2;
            if (c.q == SolverVariable.Type.u)
            {
              f2 = f1;
              i4 = i3;
            }
            else if (f)
            {
              f2 = f1;
              i4 = i3;
            }
            else
            {
              f2 = f1;
              i4 = i3;
              if (((h)localObject).c(localSolverVariable))
              {
                float f3 = b.a(localSolverVariable);
                f2 = f1;
                i4 = i3;
                if (f3 < 0.0F)
                {
                  f3 = -i / f3;
                  f2 = f1;
                  i4 = i3;
                  if (f3 < f1)
                  {
                    i4 = i1;
                    f2 = f3;
                  }
                }
              }
            }
            i1 += 1;
            f1 = f2;
          }
          i1 = i5;
          if (i3 > -1)
          {
            localObject = b[i3];
            c.f = -1;
            if (c == null)
            {
              ((h)localObject).a(localSolverVariable);
              localSolverVariable = c;
              f = i3;
              localSolverVariable.a(this, (h)localObject);
              i1 = i5;
            }
            else
            {
              throw new NullPointerException("Null throw statement replaced by Soot");
            }
          }
        }
        else
        {
          i2 = 1;
          i1 = i5;
        }
      }
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
    label422:
    return i1;
  }
  
  private SolverVariable a(SolverVariable.Type paramType, String paramString)
  {
    SolverVariable localSolverVariable = (SolverVariable)a.j.a();
    if (localSolverVariable == null)
    {
      localSolverVariable = new SolverVariable(paramType, paramString);
      localSolverVariable.d(paramType, paramString);
      paramType = localSolverVariable;
    }
    else
    {
      localSolverVariable.a();
      localSolverVariable.d(paramType, paramString);
      paramType = localSolverVariable;
    }
    int i1 = q;
    int i2 = t;
    if (i1 >= i2)
    {
      i1 = i2 * 2;
      t = i1;
      x = ((SolverVariable[])Arrays.copyOf(x, i1));
    }
    paramString = x;
    i1 = q;
    q = (i1 + 1);
    paramString[i1] = paramType;
    return paramType;
  }
  
  public static h a(ClassWriter paramClassWriter, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, float paramFloat)
  {
    return paramClassWriter.c().a(paramSolverVariable1, paramSolverVariable2, paramFloat);
  }
  
  private final void d(h paramH)
  {
    int i1;
    if ((d) && (f))
    {
      c.a(this, i);
    }
    else
    {
      Object localObject = b;
      i1 = f;
      localObject[i1] = paramH;
      localObject = c;
      f = i1;
      f = (i1 + 1);
      ((SolverVariable)localObject).a(this, paramH);
    }
    if ((d) && (i))
    {
      int i2;
      for (i1 = 0; i1 < f; i1 = i2 + 1)
      {
        if (b[i1] == null) {
          System.out.println("WTF");
        }
        paramH = b;
        i2 = i1;
        if (paramH[i1] != null)
        {
          i2 = i1;
          if (f)
          {
            paramH = paramH[i1];
            c.a(this, i);
            if (h) {
              a.c.a(paramH);
            } else {
              a.b.a(paramH);
            }
            b[i1] = null;
            i2 = i1 + 1;
            int i3 = i2;
            int i4;
            for (;;)
            {
              i4 = f;
              if (i2 >= i4) {
                break;
              }
              paramH = b;
              i3 = i2 - 1;
              paramH[i3] = paramH[i2];
              if (c.f == i2) {
                c.f = i3;
              }
              i3 = i2;
              i2 += 1;
            }
            if (i3 < i4) {
              b[i3] = null;
            }
            f = (i4 - 1);
            i2 = i1 - 1;
          }
        }
      }
      i = false;
    }
  }
  
  private void draw()
  {
    boolean bool = h;
    int i1 = 0;
    int i2 = 0;
    h localH;
    if (bool)
    {
      i1 = i2;
      while (i1 < f)
      {
        localH = b[i1];
        if (localH != null) {
          a.c.a(localH);
        }
        b[i1] = null;
        i1 += 1;
      }
    }
    while (i1 < f)
    {
      localH = b[i1];
      if (localH != null) {
        a.b.a(localH);
      }
      b[i1] = null;
      i1 += 1;
    }
  }
  
  public static Edge get()
  {
    return c;
  }
  
  private void visit()
  {
    int i1 = n * 2;
    n = i1;
    b = ((h[])Arrays.copyOf(b, i1));
    Item localItem = a;
    n = ((SolverVariable[])Arrays.copyOf(n, n));
    i1 = n;
    l = new boolean[i1];
    o = i1;
    p = i1;
    if (c == null) {
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  private void visitMaxs()
  {
    int i1 = 0;
    while (i1 < f)
    {
      h localH = b[i1];
      c.a = i;
      i1 += 1;
    }
  }
  
  public SolverVariable a(int paramInt, String paramString)
  {
    if (c == null)
    {
      if (s + 1 >= o) {
        visit();
      }
      paramString = a(SolverVariable.Type.q, paramString);
      int i1 = r + 1;
      r = i1;
      s += 1;
      b = i1;
      r = paramInt;
      a.n[i1] = paramString;
      k.b(paramString);
      return paramString;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public SolverVariable a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if (s + 1 >= o) {
      visit();
    }
    if ((paramObject instanceof ConstraintAnchor))
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)paramObject;
      SolverVariable localSolverVariable = localConstraintAnchor.c();
      paramObject = localSolverVariable;
      if (localSolverVariable == null)
      {
        localConstraintAnchor.a(a);
        paramObject = localConstraintAnchor.c();
      }
      int i1 = b;
      if ((i1 == -1) || (i1 > r) || (a.n[i1] == null))
      {
        if (i1 != -1) {
          paramObject.a();
        }
        i1 = r + 1;
        r = i1;
        s += 1;
        b = i1;
        q = SolverVariable.Type.u;
        a.n[i1] = paramObject;
        return paramObject;
      }
    }
    else
    {
      return null;
    }
    return paramObject;
  }
  
  public h a(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    if ((I) && (paramInt2 == 8) && (c) && (f == -1))
    {
      paramSolverVariable1.a(this, a + paramInt1);
      return null;
    }
    h localH = c();
    localH.a(paramSolverVariable1, paramSolverVariable2, paramInt1);
    if (paramInt2 != 8) {
      localH.a(this, paramInt2);
    }
    a(localH);
    return localH;
  }
  
  public void a()
  {
    int i1 = 0;
    for (;;)
    {
      localObject = a;
      SolverVariable[] arrayOfSolverVariable = n;
      if (i1 >= arrayOfSolverVariable.length) {
        break;
      }
      localObject = arrayOfSolverVariable[i1];
      if (localObject != null) {
        ((SolverVariable)localObject).a();
      }
      i1 += 1;
    }
    j.a(x, q);
    q = 0;
    Arrays.fill(a.n, null);
    Object localObject = m;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    r = 0;
    k.clear();
    s = 1;
    i1 = 0;
    while (i1 < f)
    {
      localObject = b;
      if (localObject[i1] != null) {
        e = false;
      }
      i1 += 1;
    }
    draw();
    f = 0;
    if (h)
    {
      v = new ByteVector(this, a);
      return;
    }
    v = new h(a);
  }
  
  public void a(SolverVariable paramSolverVariable, int paramInt)
  {
    if ((I) && (f == -1))
    {
      float f1 = paramInt;
      paramSolverVariable.a(this, f1);
      paramInt = 0;
      while (paramInt < r + 1)
      {
        localObject = a.n[paramInt];
        if ((localObject != null) && (i) && (e == b)) {
          ((SolverVariable)localObject).a(this, g + f1);
        }
        paramInt += 1;
      }
      return;
    }
    int i1 = f;
    if (i1 != -1)
    {
      localObject = b[i1];
      if (f)
      {
        i = paramInt;
        return;
      }
      if (b.f() == 0)
      {
        f = true;
        i = paramInt;
        return;
      }
      localObject = c();
      ((h)localObject).a(paramSolverVariable, paramInt);
      a((h)localObject);
      return;
    }
    Object localObject = c();
    ((h)localObject).b(paramSolverVariable, paramInt);
    a((h)localObject);
  }
  
  public void a(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, int paramInt3)
  {
    h localH = c();
    localH.a(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramInt3 != 8) {
      localH.a(this, paramInt3);
    }
    a(localH);
  }
  
  public void a(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    h localH = c();
    SolverVariable localSolverVariable = b();
    r = 0;
    localH.b(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    a(localH);
  }
  
  public void a(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat, int paramInt)
  {
    h localH = c();
    localH.a(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramSolverVariable4, paramFloat);
    if (paramInt != 8) {
      localH.a(this, paramInt);
    }
    a(localH);
  }
  
  public void a(h paramH)
  {
    if (paramH == null) {
      return;
    }
    if (c == null)
    {
      int i1 = f;
      int i2 = 1;
      if ((i1 + 1 >= p) || (s + 1 >= o)) {
        visit();
      }
      i1 = 0;
      if (!f)
      {
        paramH.b(this);
        if (paramH.isEmpty()) {
          return;
        }
        paramH.d();
        if (paramH.c(this))
        {
          SolverVariable localSolverVariable = d();
          c = localSolverVariable;
          i1 = f;
          d(paramH);
          if (f == i1 + 1)
          {
            v.a(paramH);
            a(v, true);
            i1 = i2;
            if (f != -1) {
              break label259;
            }
            if (c == localSolverVariable)
            {
              localSolverVariable = paramH.getItem(localSolverVariable);
              if (localSolverVariable != null) {
                if (c == null) {
                  paramH.a(localSolverVariable);
                } else {
                  throw new NullPointerException("Null throw statement replaced by Soot");
                }
              }
            }
            if (!f) {
              c.a(this, paramH);
            }
            if (h) {
              a.c.a(paramH);
            } else {
              a.b.a(paramH);
            }
            f -= 1;
            i1 = i2;
            break label259;
          }
        }
        i1 = 0;
        label259:
        if (!paramH.c()) {
          return;
        }
      }
      if (i1 == 0) {
        d(paramH);
      }
    }
    else
    {
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  void a(h paramH, int paramInt1, int paramInt2)
  {
    paramH.setTitle(a(paramInt2, null), paramInt1);
  }
  
  public void a(ConstraintWidget paramConstraintWidget1, ConstraintWidget paramConstraintWidget2, float paramFloat, int paramInt)
  {
    Object localObject1 = ConstraintAnchor.Type.g;
    SolverVariable localSolverVariable1 = a(paramConstraintWidget1.a((ConstraintAnchor.Type)localObject1));
    Object localObject4 = ConstraintAnchor.Type.a;
    SolverVariable localSolverVariable3 = a(paramConstraintWidget1.a((ConstraintAnchor.Type)localObject4));
    Object localObject3 = ConstraintAnchor.Type.c;
    SolverVariable localSolverVariable2 = a(paramConstraintWidget1.a((ConstraintAnchor.Type)localObject3));
    Object localObject2 = ConstraintAnchor.Type.b;
    paramConstraintWidget1 = a(paramConstraintWidget1.a((ConstraintAnchor.Type)localObject2));
    localObject1 = a(paramConstraintWidget2.a((ConstraintAnchor.Type)localObject1));
    localObject4 = a(paramConstraintWidget2.a((ConstraintAnchor.Type)localObject4));
    localObject3 = a(paramConstraintWidget2.a((ConstraintAnchor.Type)localObject3));
    paramConstraintWidget2 = a(paramConstraintWidget2.a((ConstraintAnchor.Type)localObject2));
    localObject2 = c();
    double d1 = paramFloat;
    double d2 = Math.sin(d1);
    double d3 = paramInt;
    ((h)localObject2).b(localSolverVariable3, paramConstraintWidget1, (SolverVariable)localObject4, paramConstraintWidget2, (float)(d2 * d3));
    a((h)localObject2);
    paramConstraintWidget1 = c();
    paramConstraintWidget1.b(localSolverVariable1, localSolverVariable2, (SolverVariable)localObject1, (SolverVariable)localObject3, (float)(Math.cos(d1) * d3));
    a(paramConstraintWidget1);
  }
  
  public SolverVariable b()
  {
    if (c == null)
    {
      if (s + 1 >= o) {
        visit();
      }
      SolverVariable localSolverVariable = a(SolverVariable.Type.b, null);
      int i1 = r + 1;
      r = i1;
      s += 1;
      b = i1;
      a.n[i1] = localSolverVariable;
      return localSolverVariable;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void b(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    h localH = c();
    SolverVariable localSolverVariable = b();
    r = 0;
    localH.b(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    if (paramInt2 != 8) {
      a(localH, (int)(b.a(localSolverVariable) * -1.0F), paramInt2);
    }
    a(localH);
  }
  
  public void b(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    h localH = c();
    SolverVariable localSolverVariable = b();
    r = 0;
    localH.a(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    a(localH);
  }
  
  void b(l paramL)
    throws Exception
  {
    if (c == null)
    {
      a(paramL);
      a(paramL, false);
      visitMaxs();
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public h c()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a3 = a2\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  public SolverVariable d()
  {
    if (c == null)
    {
      if (s + 1 >= o) {
        visit();
      }
      SolverVariable localSolverVariable = a(SolverVariable.Type.b, null);
      int i1 = r + 1;
      r = i1;
      s += 1;
      b = i1;
      a.n[i1] = localSolverVariable;
      return localSolverVariable;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void d(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    h localH = c();
    SolverVariable localSolverVariable = b();
    r = 0;
    localH.a(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    if (paramInt2 != 8) {
      a(localH, (int)(b.a(localSolverVariable) * -1.0F), paramInt2);
    }
    a(localH);
  }
  
  public void f()
    throws Exception
  {
    if (c == null)
    {
      if (k.isEmpty())
      {
        visitMaxs();
        return;
      }
      if ((!B) && (!w))
      {
        b(k);
        return;
      }
      if (c == null)
      {
        int i2 = 0;
        int i1 = 0;
        while (i1 < f)
        {
          if (!b[i1].f)
          {
            i1 = i2;
            break label93;
          }
          i1 += 1;
        }
        i1 = 1;
        label93:
        if (i1 == 0)
        {
          b(k);
          return;
        }
        if (c == null)
        {
          visitMaxs();
          return;
        }
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public Item newUTF8()
  {
    return a;
  }
  
  public int set(Object paramObject)
  {
    paramObject = ((ConstraintAnchor)paramObject).c();
    if (paramObject != null) {
      return (int)(a + 0.5F);
    }
    return 0;
  }
}
