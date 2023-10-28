package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.List;

class l
{
  public static int a;
  WidgetRun b = null;
  public boolean c = false;
  public int d = 0;
  int e;
  int g = 0;
  WidgetRun i = null;
  ArrayList<WidgetRun> k = new ArrayList();
  
  public l(WidgetRun paramWidgetRun, int paramInt)
  {
    int j = a;
    g = j;
    a = j + 1;
    i = paramWidgetRun;
    b = paramWidgetRun;
    e = paramInt;
  }
  
  private long a(DependencyNode paramDependencyNode, long paramLong)
  {
    WidgetRun localWidgetRun = u;
    if ((localWidgetRun instanceof MethodWriter)) {
      return paramLong;
    }
    int m = f.size();
    int j = 0;
    long l2;
    for (long l1 = paramLong; j < m; l1 = l2)
    {
      Object localObject = (x)f.get(j);
      l2 = l1;
      if ((localObject instanceof DependencyNode))
      {
        localObject = (DependencyNode)localObject;
        if (u == localWidgetRun) {
          l2 = l1;
        } else {
          l2 = Math.max(l1, a((DependencyNode)localObject, c + paramLong));
        }
      }
      j += 1;
    }
    if (paramDependencyNode == d)
    {
      l2 = localWidgetRun.draw();
      paramDependencyNode = a;
      paramLong += l2;
      return Math.max(Math.max(l1, a(paramDependencyNode, paramLong)), paramLong - a.c);
    }
    return l1;
  }
  
  private long b(DependencyNode paramDependencyNode, long paramLong)
  {
    WidgetRun localWidgetRun = u;
    if ((localWidgetRun instanceof MethodWriter)) {
      return paramLong;
    }
    int m = f.size();
    int j = 0;
    long l2;
    for (long l1 = paramLong; j < m; l1 = l2)
    {
      Object localObject = (x)f.get(j);
      l2 = l1;
      if ((localObject instanceof DependencyNode))
      {
        localObject = (DependencyNode)localObject;
        if (u == localWidgetRun) {
          l2 = l1;
        } else {
          l2 = Math.min(l1, b((DependencyNode)localObject, c + paramLong));
        }
      }
      j += 1;
    }
    if (paramDependencyNode == a)
    {
      l2 = localWidgetRun.draw();
      paramDependencyNode = d;
      paramLong -= l2;
      return Math.min(Math.min(l1, b(paramDependencyNode, paramLong)), paramLong - d.c);
    }
    return l1;
  }
  
  public long a(androidx.constraintlayout.solver.widgets.f paramF, int paramInt)
  {
    WidgetRun localWidgetRun = i;
    boolean bool1 = localWidgetRun instanceof h;
    long l3 = 0L;
    if (bool1)
    {
      if (j != paramInt) {
        return 0L;
      }
    }
    else if (paramInt == 0)
    {
      if (!(localWidgetRun instanceof f)) {
        return 0L;
      }
    }
    else if (!(localWidgetRun instanceof m)) {
      return 0L;
    }
    if (paramInt == 0) {
      localObject = d;
    } else {
      localObject = e;
    }
    Object localObject = d;
    if (paramInt == 0) {
      paramF = d;
    } else {
      paramF = e;
    }
    paramF = a;
    bool1 = d.b.contains(localObject);
    boolean bool2 = i.a.b.contains(paramF);
    long l5 = i.draw();
    long l1;
    long l2;
    if ((bool1) && (bool2))
    {
      l1 = a(i.d, 0L);
      long l4 = b(i.a, 0L);
      l2 = l1 - l5;
      paramF = i;
      int j = a.c;
      l1 = l2;
      if (l2 >= -j) {
        l1 = l2 + j;
      }
      l2 = -l4;
      j = d.c;
      l4 = l2 - l5 - j;
      l2 = l4;
      if (l4 >= j) {
        l2 = l4 - j;
      }
      float f1 = b.height(paramInt);
      if (f1 > 0.0F) {
        l3 = ((float)l2 / f1 + (float)l1 / (1.0F - f1));
      }
      float f2 = (float)l3;
      l1 = (f2 * f1 + 0.5F);
      l2 = (f2 * (1.0F - f1) + 0.5F);
      paramF = i;
      l1 = d.c + (l1 + l5 + l2);
      paramInt = a.c;
    }
    else
    {
      if (bool1)
      {
        paramF = i.d;
        return Math.max(a(paramF, c), i.d.c + l5);
      }
      if (bool2)
      {
        paramF = i.a;
        l1 = b(paramF, c);
        l2 = -i.a.c;
        return Math.max(-l1, l2 + l5);
      }
      paramF = i;
      l1 = d.c + paramF.draw();
      paramInt = i.a.c;
    }
    return l1 - paramInt;
  }
  
  public void a(WidgetRun paramWidgetRun)
  {
    k.add(paramWidgetRun);
    b = paramWidgetRun;
  }
}
