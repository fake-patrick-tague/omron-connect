package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ByteVector
{
  private androidx.constraintlayout.solver.widgets.f a;
  private boolean b = true;
  ArrayList<l> c = new ArrayList();
  private ArrayList<l> data = new ArrayList();
  private androidx.constraintlayout.solver.widgets.f f;
  private Item h = null;
  private boolean l = true;
  private ArrayList<WidgetRun> n = new ArrayList();
  private ClassWriter w = new ClassWriter();
  
  public ByteVector(androidx.constraintlayout.solver.widgets.f paramF)
  {
    a = paramF;
    f = paramF;
  }
  
  private int a(androidx.constraintlayout.solver.widgets.f paramF, int paramInt)
  {
    int j = c.size();
    long l1 = 0L;
    int i = 0;
    while (i < j)
    {
      l1 = Math.max(l1, ((l)c.get(i)).a(paramF, paramInt));
      i += 1;
    }
    return (int)l1;
  }
  
  private void a(ConstraintWidget paramConstraintWidget, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour1, int paramInt1, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour2, int paramInt2)
  {
    ClassWriter localClassWriter = w;
    i = paramDimensionBehaviour1;
    b = paramDimensionBehaviour2;
    f = paramInt1;
    j = paramInt2;
    h.a(paramConstraintWidget, localClassWriter);
    paramConstraintWidget.get(w.z);
    paramConstraintWidget.append(w.s);
    paramConstraintWidget.append(w.e);
    paramConstraintWidget.putShort(w.q);
  }
  
  private void a(DependencyNode paramDependencyNode1, int paramInt1, int paramInt2, DependencyNode paramDependencyNode2, ArrayList paramArrayList, l paramL)
  {
    Object localObject1 = u;
    if (l == null)
    {
      paramDependencyNode1 = a;
      if (localObject1 != d)
      {
        if (localObject1 == e) {
          return;
        }
        paramDependencyNode1 = paramL;
        if (paramL == null)
        {
          paramDependencyNode1 = new l((WidgetRun)localObject1, paramInt2);
          paramArrayList.add(paramDependencyNode1);
        }
        l = paramDependencyNode1;
        paramDependencyNode1.a((WidgetRun)localObject1);
        paramL = d.f.iterator();
        Object localObject2;
        while (paramL.hasNext())
        {
          localObject2 = (x)paramL.next();
          if ((localObject2 instanceof DependencyNode)) {
            a((DependencyNode)localObject2, paramInt1, 0, paramDependencyNode2, paramArrayList, paramDependencyNode1);
          }
        }
        paramL = a.f.iterator();
        while (paramL.hasNext())
        {
          localObject2 = (x)paramL.next();
          if ((localObject2 instanceof DependencyNode)) {
            a((DependencyNode)localObject2, paramInt1, 1, paramDependencyNode2, paramArrayList, paramDependencyNode1);
          }
        }
        if ((paramInt1 == 1) && ((localObject1 instanceof m)))
        {
          paramL = a.f.iterator();
          while (paramL.hasNext())
          {
            localObject2 = (x)paramL.next();
            if ((localObject2 instanceof DependencyNode)) {
              a((DependencyNode)localObject2, paramInt1, 2, paramDependencyNode2, paramArrayList, paramDependencyNode1);
            }
          }
        }
        paramL = d.b.iterator();
        while (paramL.hasNext())
        {
          localObject2 = (DependencyNode)paramL.next();
          if (localObject2 == paramDependencyNode2) {
            c = true;
          }
          a((DependencyNode)localObject2, paramInt1, 0, paramDependencyNode2, paramArrayList, paramDependencyNode1);
        }
        paramL = a.b.iterator();
        while (paramL.hasNext())
        {
          localObject2 = (DependencyNode)paramL.next();
          if (localObject2 == paramDependencyNode2) {
            c = true;
          }
          a((DependencyNode)localObject2, paramInt1, 1, paramDependencyNode2, paramArrayList, paramDependencyNode1);
        }
        if ((paramInt1 == 1) && ((localObject1 instanceof m))) {
          paramL = a.b.iterator();
        }
      }
    }
    else
    {
      while (paramL.hasNext())
      {
        localObject1 = (DependencyNode)paramL.next();
        try
        {
          a((DependencyNode)localObject1, paramInt1, 2, paramDependencyNode2, paramArrayList, paramDependencyNode1);
        }
        catch (Throwable paramDependencyNode1)
        {
          throw paramDependencyNode1;
        }
      }
      return;
    }
  }
  
  private void a(WidgetRun paramWidgetRun, int paramInt, ArrayList paramArrayList)
  {
    Object localObject = d.f.iterator();
    x localX;
    while (((Iterator)localObject).hasNext())
    {
      localX = (x)((Iterator)localObject).next();
      if ((localX instanceof DependencyNode)) {
        a((DependencyNode)localX, paramInt, 0, a, paramArrayList, null);
      } else if ((localX instanceof WidgetRun)) {
        a(d, paramInt, 0, a, paramArrayList, null);
      }
    }
    localObject = a.f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localX = (x)((Iterator)localObject).next();
      if ((localX instanceof DependencyNode)) {
        a((DependencyNode)localX, paramInt, 1, d, paramArrayList, null);
      } else if ((localX instanceof WidgetRun)) {
        a(a, paramInt, 1, d, paramArrayList, null);
      }
    }
    if (paramInt == 1)
    {
      paramWidgetRun = a.f.iterator();
      while (paramWidgetRun.hasNext())
      {
        localObject = (x)paramWidgetRun.next();
        if ((localObject instanceof DependencyNode)) {
          a((DependencyNode)localObject, paramInt, 2, null, paramArrayList, null);
        }
      }
    }
  }
  
  private boolean a(androidx.constraintlayout.solver.widgets.f paramF)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
      Object localObject1 = u;
      Object localObject2 = localObject1[0];
      Object localObject3 = localObject1[1];
      if (localConstraintWidget.get() == 8)
      {
        k = true;
      }
      else
      {
        if ((v < 1.0F) && (localObject2 == ConstraintWidget.DimensionBehaviour.b)) {
          i = 2;
        }
        if ((z < 1.0F) && (localObject3 == ConstraintWidget.DimensionBehaviour.b)) {
          n = 2;
        }
        if (localConstraintWidget.p() > 0.0F)
        {
          localObject1 = ConstraintWidget.DimensionBehaviour.b;
          if ((localObject2 == localObject1) && ((localObject3 == ConstraintWidget.DimensionBehaviour.c) || (localObject3 == ConstraintWidget.DimensionBehaviour.a)))
          {
            i = 3;
          }
          else if ((localObject3 == localObject1) && ((localObject2 == ConstraintWidget.DimensionBehaviour.c) || (localObject2 == ConstraintWidget.DimensionBehaviour.a)))
          {
            n = 3;
          }
          else if ((localObject2 == localObject1) && (localObject3 == localObject1))
          {
            if (i == 0) {
              i = 3;
            }
            if (n == 0) {
              n = 3;
            }
          }
        }
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.b;
        localObject1 = localObject2;
        if (localObject2 == localDimensionBehaviour1)
        {
          localObject1 = localObject2;
          if (i == 1) {
            if (a.c != null)
            {
              localObject1 = localObject2;
              if (l.c != null) {}
            }
            else
            {
              localObject1 = ConstraintWidget.DimensionBehaviour.c;
            }
          }
        }
        localObject2 = localObject3;
        if (localObject3 == localDimensionBehaviour1)
        {
          localObject2 = localObject3;
          if (n == 1) {
            if (c.c != null)
            {
              localObject2 = localObject3;
              if (b.c != null) {}
            }
            else
            {
              localObject2 = ConstraintWidget.DimensionBehaviour.c;
            }
          }
        }
        localObject3 = localObject2;
        Object localObject4 = d;
        f = ((ConstraintWidget.DimensionBehaviour)localObject1);
        int i = i;
        g = i;
        localObject4 = e;
        f = ((ConstraintWidget.DimensionBehaviour)localObject2);
        int j = n;
        g = j;
        localObject2 = ConstraintWidget.DimensionBehaviour.g;
        if (((localObject1 != localObject2) && (localObject1 != ConstraintWidget.DimensionBehaviour.a) && (localObject1 != ConstraintWidget.DimensionBehaviour.c)) || ((localObject3 != localObject2) && (localObject3 != ConstraintWidget.DimensionBehaviour.a) && (localObject3 != ConstraintWidget.DimensionBehaviour.c)))
        {
          ConstraintAnchor[] arrayOfConstraintAnchor;
          ConstraintWidget.DimensionBehaviour localDimensionBehaviour2;
          if (localObject1 == localDimensionBehaviour1)
          {
            localObject4 = ConstraintWidget.DimensionBehaviour.c;
            if ((localObject3 == localObject4) || (localObject3 == ConstraintWidget.DimensionBehaviour.a))
            {
              if (i == 3)
              {
                if (localObject3 == localObject4) {
                  a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject4, 0, (ConstraintWidget.DimensionBehaviour)localObject4, 0);
                }
                i = localConstraintWidget.length();
                j = (int)(i * right + 0.5F);
                localObject1 = ConstraintWidget.DimensionBehaviour.a;
                a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject1, j, (ConstraintWidget.DimensionBehaviour)localObject1, i);
                d.c.a(localConstraintWidget.getValue());
                e.c.a(localConstraintWidget.length());
                k = true;
                continue;
              }
              if (i == 1)
              {
                a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject4, 0, (ConstraintWidget.DimensionBehaviour)localObject3, 0);
                d.c.a = localConstraintWidget.getValue();
                continue;
              }
              if (i == 2)
              {
                localObject4 = u;
                arrayOfConstraintAnchor = localObject4[0];
                localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.a;
                if ((arrayOfConstraintAnchor == localDimensionBehaviour2) || (localObject4[0] == localObject2))
                {
                  a(localConstraintWidget, localDimensionBehaviour2, (int)(v * paramF.getValue() + 0.5F), (ConstraintWidget.DimensionBehaviour)localObject3, localConstraintWidget.length());
                  d.c.a(localConstraintWidget.getValue());
                  e.c.a(localConstraintWidget.length());
                  k = true;
                }
              }
              else
              {
                arrayOfConstraintAnchor = h;
                if ((0c == null) || (1c == null))
                {
                  a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject4, 0, (ConstraintWidget.DimensionBehaviour)localObject3, 0);
                  d.c.a(localConstraintWidget.getValue());
                  e.c.a(localConstraintWidget.length());
                  k = true;
                  continue;
                }
              }
            }
          }
          float f2;
          float f1;
          if (localObject3 == localDimensionBehaviour1)
          {
            localObject4 = ConstraintWidget.DimensionBehaviour.c;
            if ((localObject1 == localObject4) || (localObject1 == ConstraintWidget.DimensionBehaviour.a))
            {
              if (j == 3)
              {
                if (localObject1 == localObject4) {
                  a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject4, 0, (ConstraintWidget.DimensionBehaviour)localObject4, 0);
                }
                i = localConstraintWidget.getValue();
                f2 = right;
                f1 = f2;
                if (localConstraintWidget.readUnsignedShort() == -1) {
                  f1 = 1.0F / f2;
                }
                j = (int)(i * f1 + 0.5F);
                localObject1 = ConstraintWidget.DimensionBehaviour.a;
                a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject1, i, (ConstraintWidget.DimensionBehaviour)localObject1, j);
                d.c.a(localConstraintWidget.getValue());
                e.c.a(localConstraintWidget.length());
                k = true;
                continue;
              }
              if (j == 1)
              {
                a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject1, 0, (ConstraintWidget.DimensionBehaviour)localObject4, 0);
                e.c.a = localConstraintWidget.length();
                continue;
              }
              if (j == 2)
              {
                localObject4 = u;
                arrayOfConstraintAnchor = localObject4[1];
                localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.a;
                if ((arrayOfConstraintAnchor == localDimensionBehaviour2) || (localObject4[1] == localObject2))
                {
                  f1 = z;
                  a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject1, localConstraintWidget.getValue(), localDimensionBehaviour2, (int)(f1 * paramF.length() + 0.5F));
                  d.c.a(localConstraintWidget.getValue());
                  e.c.a(localConstraintWidget.length());
                  k = true;
                }
              }
              else
              {
                localObject2 = h;
                if ((2c == null) || (3c == null))
                {
                  a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject4, 0, (ConstraintWidget.DimensionBehaviour)localObject3, 0);
                  d.c.a(localConstraintWidget.getValue());
                  e.c.a(localConstraintWidget.length());
                  k = true;
                  continue;
                }
              }
            }
          }
          if ((localObject1 == localDimensionBehaviour1) && (localObject3 == localDimensionBehaviour1)) {
            if ((i != 1) && (j != 1))
            {
              if ((j == 2) && (i == 2))
              {
                localObject1 = u;
                localObject2 = localObject1[0];
                localObject3 = ConstraintWidget.DimensionBehaviour.a;
                if (((localObject2 == localObject3) || (localObject1[0] == localObject3)) && ((localObject1[1] == localObject3) || (localObject1[1] == localObject3)))
                {
                  f1 = v;
                  f2 = z;
                  a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject3, (int)(f1 * paramF.getValue() + 0.5F), (ConstraintWidget.DimensionBehaviour)localObject3, (int)(f2 * paramF.length() + 0.5F));
                  d.c.a(localConstraintWidget.getValue());
                  e.c.a(localConstraintWidget.length());
                  k = true;
                }
              }
            }
            else
            {
              localObject1 = ConstraintWidget.DimensionBehaviour.c;
              a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject1, 0, (ConstraintWidget.DimensionBehaviour)localObject1, 0);
              d.c.a = localConstraintWidget.getValue();
              e.c.a = localConstraintWidget.length();
            }
          }
        }
        else
        {
          if (localObject1 == localObject2)
          {
            i = paramF.getValue() - a.a - l.a;
            localObject1 = ConstraintWidget.DimensionBehaviour.a;
          }
          else
          {
            i = localConstraintWidget.getValue();
          }
          if (localObject3 == localObject2)
          {
            j = paramF.length() - c.a - b.a;
            localObject3 = ConstraintWidget.DimensionBehaviour.a;
          }
          else
          {
            j = localConstraintWidget.length();
          }
          a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject1, i, (ConstraintWidget.DimensionBehaviour)localObject3, j);
          d.c.a(localConstraintWidget.getValue());
          e.c.a(localConstraintWidget.length());
          k = true;
        }
      }
    }
    return false;
  }
  
  public void a()
  {
    Iterator localIterator = a.a.iterator();
    while (localIterator.hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
      if (!k)
      {
        Object localObject2 = u;
        int k = 0;
        Object localObject1 = localObject2[0];
        Object localObject3 = localObject2[1];
        int i = i;
        int m = n;
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.c;
        if ((localObject1 != localDimensionBehaviour) && ((localObject1 != ConstraintWidget.DimensionBehaviour.b) || (i != 1))) {
          i = 0;
        } else {
          i = 1;
        }
        int j;
        if (localObject3 != localDimensionBehaviour)
        {
          j = k;
          if (localObject3 == ConstraintWidget.DimensionBehaviour.b)
          {
            j = k;
            if (m != 1) {}
          }
        }
        else
        {
          j = 1;
        }
        localObject2 = d.c;
        boolean bool1 = i;
        Label localLabel = e.c;
        boolean bool2 = i;
        if ((bool1) && (bool2))
        {
          localObject1 = ConstraintWidget.DimensionBehaviour.a;
          a(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject1, a, (ConstraintWidget.DimensionBehaviour)localObject1, a);
          k = true;
        }
        else if ((bool1) && (j != 0))
        {
          a(localConstraintWidget, ConstraintWidget.DimensionBehaviour.a, a, localDimensionBehaviour, a);
          if (localObject3 == ConstraintWidget.DimensionBehaviour.b)
          {
            e.c.a = localConstraintWidget.length();
          }
          else
          {
            e.c.a(localConstraintWidget.length());
            k = true;
          }
        }
        else if ((bool2) && (i != 0))
        {
          a(localConstraintWidget, localDimensionBehaviour, a, ConstraintWidget.DimensionBehaviour.a, a);
          if (localObject1 == ConstraintWidget.DimensionBehaviour.b)
          {
            d.c.a = localConstraintWidget.getValue();
          }
          else
          {
            d.c.a(localConstraintWidget.getValue());
            k = true;
          }
        }
        if (k)
        {
          localObject1 = e.b;
          if (localObject1 != null) {
            ((Label)localObject1).a(localConstraintWidget.newUTF8());
          }
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    paramArrayList.clear();
    f.d.f();
    f.e.f();
    paramArrayList.add(f.d);
    paramArrayList.add(f.e);
    Object localObject1 = f;
    ByteVector localByteVector = this;
    Object localObject3 = a.iterator();
    localObject1 = null;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)((Iterator)localObject3).next();
      if ((localConstraintWidget instanceof androidx.constraintlayout.solver.widgets.h))
      {
        paramArrayList.add(new d(localConstraintWidget));
      }
      else
      {
        if (localConstraintWidget.equals())
        {
          if (A == null) {
            A = new h(localConstraintWidget, 0);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new HashSet();
          }
          ((HashSet)localObject2).add(A);
          localObject1 = localObject2;
        }
        else
        {
          paramArrayList.add(d);
        }
        if (localConstraintWidget.f())
        {
          if (Q == null) {
            Q = new h(localConstraintWidget, 1);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new HashSet();
          }
          ((HashSet)localObject2).add(Q);
        }
        else
        {
          paramArrayList.add(e);
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        if ((localConstraintWidget instanceof androidx.constraintlayout.solver.widgets.Label))
        {
          paramArrayList.add(new MethodWriter(localConstraintWidget));
          localObject1 = localObject2;
        }
      }
    }
    if (localObject1 != null) {
      paramArrayList.addAll((Collection)localObject1);
    }
    localObject1 = paramArrayList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((WidgetRun)((Iterator)localObject1).next()).f();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject1 = (WidgetRun)paramArrayList.next();
      localObject2 = b;
      localObject3 = f;
      if (localObject2 != localObject3) {
        ((WidgetRun)localObject1).b();
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool2 = paramBoolean & true;
    if ((b) || (l))
    {
      localObject1 = a.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConstraintWidget)((Iterator)localObject1).next();
        ((ConstraintWidget)localObject2).setTitle();
        k = false;
        d.d();
        e.d();
      }
      a.setTitle();
      localObject1 = a;
      k = false;
      d.d();
      a.e.d();
      l = false;
    }
    if (a(f)) {
      return false;
    }
    a.e(0);
    a.remove(0);
    Object localObject1 = a.valueOf(0);
    Object localObject2 = a.valueOf(1);
    if (b) {
      b();
    }
    int k = a.d();
    int j = a.max();
    a.d.d.a(k);
    a.e.d.a(j);
    a();
    Object localObject3 = ConstraintWidget.DimensionBehaviour.c;
    boolean bool1;
    if ((localObject1 == localObject3) || (localObject2 == localObject3))
    {
      bool1 = bool2;
      if (bool2)
      {
        localObject3 = n.iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (((WidgetRun)((Iterator)localObject3).next()).c());
        bool1 = false;
      }
      if ((bool1) && (localObject1 == ConstraintWidget.DimensionBehaviour.c))
      {
        a.add(ConstraintWidget.DimensionBehaviour.a);
        localObject3 = a;
        ((ConstraintWidget)localObject3).get(a((androidx.constraintlayout.solver.widgets.f)localObject3, 0));
        localObject3 = a;
        d.c.a(((ConstraintWidget)localObject3).getValue());
      }
      if ((bool1) && (localObject2 == ConstraintWidget.DimensionBehaviour.c))
      {
        a.a(ConstraintWidget.DimensionBehaviour.a);
        localObject3 = a;
        ((ConstraintWidget)localObject3).append(a((androidx.constraintlayout.solver.widgets.f)localObject3, 1));
        localObject3 = a;
        e.c.a(((ConstraintWidget)localObject3).length());
      }
    }
    Object localObject4 = a;
    ConstraintWidget.DimensionBehaviour[] arrayOfDimensionBehaviour = u;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour = arrayOfDimensionBehaviour[0];
    localObject3 = ConstraintWidget.DimensionBehaviour.a;
    int i;
    if ((localDimensionBehaviour != localObject3) && (arrayOfDimensionBehaviour[0] != ConstraintWidget.DimensionBehaviour.g))
    {
      bool1 = false;
    }
    else
    {
      i = ((ConstraintWidget)localObject4).getValue() + k;
      a.d.a.a(i);
      a.d.c.a(i - k);
      a();
      localObject4 = a;
      arrayOfDimensionBehaviour = u;
      if ((arrayOfDimensionBehaviour[1] == localObject3) || (arrayOfDimensionBehaviour[1] == ConstraintWidget.DimensionBehaviour.g))
      {
        i = ((ConstraintWidget)localObject4).length() + j;
        a.e.a.a(i);
        a.e.c.a(i - j);
      }
      a();
      i = 1;
    }
    localObject3 = n.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (WidgetRun)((Iterator)localObject3).next();
      if ((b != a) || (m)) {
        ((WidgetRun)localObject4).e();
      }
    }
    localObject3 = n.iterator();
    do
    {
      paramBoolean = bool3;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject4 = (WidgetRun)((Iterator)localObject3).next();
    } while ((i == 0) && (b == a));
    if (!d.i) {}
    for (;;)
    {
      paramBoolean = false;
      break label781;
      if ((a.i) || ((localObject4 instanceof d))) {
        if ((c.i) || ((localObject4 instanceof h)) || ((localObject4 instanceof d))) {
          break;
        }
      }
    }
    label781:
    a.add((ConstraintWidget.DimensionBehaviour)localObject1);
    a.a((ConstraintWidget.DimensionBehaviour)localObject2);
    return paramBoolean;
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    boolean bool3 = true;
    boolean bool2 = paramBoolean & true;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = a.valueOf(0);
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = a.valueOf(1);
    int j = a.d();
    int k = a.max();
    Object localObject2;
    if (bool2)
    {
      localObject1 = ConstraintWidget.DimensionBehaviour.c;
      if ((localDimensionBehaviour1 == localObject1) || (localDimensionBehaviour2 == localObject1))
      {
        localObject1 = n.iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (WidgetRun)((Iterator)localObject1).next();
        } while ((j != paramInt) || (((WidgetRun)localObject2).c()));
        boolean bool1 = false;
        if (paramInt == 0)
        {
          if ((bool1) && (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.c))
          {
            a.add(ConstraintWidget.DimensionBehaviour.a);
            localObject1 = a;
            ((ConstraintWidget)localObject1).get(a((androidx.constraintlayout.solver.widgets.f)localObject1, 0));
            localObject1 = a;
            d.c.a(((ConstraintWidget)localObject1).getValue());
          }
        }
        else if ((bool1) && (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.c))
        {
          a.a(ConstraintWidget.DimensionBehaviour.a);
          localObject1 = a;
          ((ConstraintWidget)localObject1).append(a((androidx.constraintlayout.solver.widgets.f)localObject1, 1));
          localObject1 = a;
          e.c.a(((ConstraintWidget)localObject1).length());
        }
      }
    }
    if (paramInt == 0)
    {
      localObject1 = a;
      localObject2 = u;
      if ((localObject2[0] == ConstraintWidget.DimensionBehaviour.a) || (localObject2[0] == ConstraintWidget.DimensionBehaviour.g))
      {
        i = ((ConstraintWidget)localObject1).getValue() + j;
        a.d.a.a(i);
        a.d.c.a(i - j);
        break label415;
      }
    }
    else
    {
      localObject1 = a;
      localObject2 = u;
      if ((localObject2[1] == ConstraintWidget.DimensionBehaviour.a) || (localObject2[1] == ConstraintWidget.DimensionBehaviour.g)) {
        break label375;
      }
    }
    int i = 0;
    break label417;
    label375:
    i = ((ConstraintWidget)localObject1).length() + k;
    a.e.a.a(i);
    a.e.c.a(i - k);
    label415:
    i = 1;
    label417:
    a();
    Object localObject1 = n.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WidgetRun)((Iterator)localObject1).next();
      if ((j == paramInt) && ((b != a) || (m))) {
        ((WidgetRun)localObject2).e();
      }
    }
    localObject1 = n.iterator();
    do
    {
      paramBoolean = bool3;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (WidgetRun)((Iterator)localObject1).next();
    } while ((j != paramInt) || ((i == 0) && (b == a)));
    if (!d.i) {}
    for (;;)
    {
      paramBoolean = false;
      break label612;
      if (a.i) {
        if (((localObject2 instanceof h)) || (c.i)) {
          break;
        }
      }
    }
    label612:
    a.add(localDimensionBehaviour1);
    a.a(localDimensionBehaviour2);
    return paramBoolean;
  }
  
  public void b()
  {
    a(n);
    c.clear();
    l.a = 0;
    a(a.d, 0, c);
    a(a.e, 1, c);
    b = false;
  }
  
  public void b(Item paramItem)
  {
    h = paramItem;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (b)
    {
      Object localObject1 = a.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ConstraintWidget)((Iterator)localObject1).next();
        ((ConstraintWidget)localObject2).setTitle();
        k = false;
        f localF = d;
        c.i = false;
        m = false;
        localF.d();
        localObject2 = e;
        c.i = false;
        m = false;
        ((m)localObject2).d();
      }
      a.setTitle();
      localObject1 = a;
      k = false;
      localObject1 = d;
      c.i = false;
      m = false;
      ((f)localObject1).d();
      localObject1 = a.e;
      c.i = false;
      m = false;
      ((m)localObject1).d();
      b();
    }
    if (a(f)) {
      return false;
    }
    a.e(0);
    a.remove(0);
    a.d.d.a(0);
    a.e.d.a(0);
    return true;
  }
  
  public void putByte()
  {
    l = true;
  }
  
  public void putShort()
  {
    b = true;
  }
}
