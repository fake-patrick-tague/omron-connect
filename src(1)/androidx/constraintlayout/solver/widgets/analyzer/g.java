package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ByteVector;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.f;
import androidx.constraintlayout.solver.widgets.h;
import androidx.constraintlayout.solver.widgets.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class g
{
  private static ClassWriter b = new ClassWriter();
  
  private static void a(ConstraintWidget paramConstraintWidget, Item paramItem)
  {
    if ((!(paramConstraintWidget instanceof f)) && (paramConstraintWidget.l()) && (a(paramConstraintWidget))) {
      f.a(paramConstraintWidget, paramItem, new ClassWriter(), ClassWriter.a);
    }
    Object localObject2 = paramConstraintWidget.a(ConstraintAnchor.Type.a);
    Object localObject1 = paramConstraintWidget.a(ConstraintAnchor.Type.b);
    int k = ((ConstraintAnchor)localObject2).get();
    int j = ((ConstraintAnchor)localObject1).get();
    Object localObject3;
    ConstraintWidget localConstraintWidget;
    boolean bool;
    Object localObject4;
    int i;
    if ((((ConstraintAnchor)localObject2).h() != null) && (((ConstraintAnchor)localObject2).i()))
    {
      localObject2 = ((ConstraintAnchor)localObject2).h().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ConstraintAnchor)((Iterator)localObject2).next();
        localConstraintWidget = b;
        bool = a(localConstraintWidget);
        if ((localConstraintWidget.l()) && (bool)) {
          f.a(localConstraintWidget, paramItem, new ClassWriter(), ClassWriter.a);
        }
        localObject4 = localConstraintWidget.size();
        Object localObject5 = ConstraintWidget.DimensionBehaviour.b;
        if ((localObject4 == localObject5) && (!bool))
        {
          if ((localConstraintWidget.size() == localObject5) && (m >= 0) && (s >= 0) && ((localConstraintWidget.get() == 8) || ((n == 0) && (localConstraintWidget.p() == 0.0F))) && (!localConstraintWidget.f()) && (!localConstraintWidget.getRangeOrigin()))
          {
            if (localObject3 == c)
            {
              localObject4 = b.c;
              if ((localObject4 != null) && (((ConstraintAnchor)localObject4).i())) {}
            }
            else
            {
              if (localObject3 != b) {
                break label328;
              }
              localObject3 = c.c;
              if ((localObject3 == null) || (!((ConstraintAnchor)localObject3).i())) {
                break label328;
              }
            }
            i = 1;
            break label330;
            label328:
            i = 0;
            label330:
            if ((i != 0) && (!localConstraintWidget.f())) {
              a(paramConstraintWidget, paramItem, localConstraintWidget);
            }
          }
        }
        else if (!localConstraintWidget.l())
        {
          localObject4 = c;
          if ((localObject3 == localObject4) && (b.c == null))
          {
            i = ((ConstraintAnchor)localObject4).b() + k;
            localConstraintWidget.add(i, localConstraintWidget.length() + i);
            a(localConstraintWidget, paramItem);
          }
          else
          {
            localObject5 = b;
            if ((localObject3 == localObject5) && (c == null))
            {
              i = k - ((ConstraintAnchor)localObject5).b();
              localConstraintWidget.add(i - localConstraintWidget.length(), i);
              a(localConstraintWidget, paramItem);
            }
            else if (localObject3 == localObject4)
            {
              localObject3 = c;
              if ((localObject3 != null) && (((ConstraintAnchor)localObject3).i())) {
                a(paramItem, localConstraintWidget);
              }
            }
          }
        }
      }
    }
    if ((paramConstraintWidget instanceof h)) {
      return;
    }
    if ((((ConstraintAnchor)localObject1).h() != null) && (((ConstraintAnchor)localObject1).i()))
    {
      localObject1 = ((ConstraintAnchor)localObject1).h().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConstraintAnchor)((Iterator)localObject1).next();
        localConstraintWidget = b;
        bool = a(localConstraintWidget);
        if ((localConstraintWidget.l()) && (bool)) {
          f.a(localConstraintWidget, paramItem, new ClassWriter(), ClassWriter.a);
        }
        if (localObject2 == c)
        {
          localObject3 = b.c;
          if ((localObject3 != null) && (((ConstraintAnchor)localObject3).i())) {}
        }
        else
        {
          if (localObject2 != b) {
            break label679;
          }
          localObject3 = c.c;
          if ((localObject3 == null) || (!((ConstraintAnchor)localObject3).i())) {
            break label679;
          }
        }
        i = 1;
        break label681;
        label679:
        i = 0;
        label681:
        localObject3 = localConstraintWidget.size();
        localObject4 = ConstraintWidget.DimensionBehaviour.b;
        if ((localObject3 == localObject4) && (!bool))
        {
          if ((localConstraintWidget.size() == localObject4) && (m >= 0) && (s >= 0) && ((localConstraintWidget.get() == 8) || ((n == 0) && (localConstraintWidget.p() == 0.0F))) && (!localConstraintWidget.f()) && (!localConstraintWidget.getRangeOrigin()) && (i != 0) && (!localConstraintWidget.f())) {
            a(paramConstraintWidget, paramItem, localConstraintWidget);
          }
        }
        else if (!localConstraintWidget.l())
        {
          localObject3 = c;
          if ((localObject2 == localObject3) && (b.c == null))
          {
            i = ((ConstraintAnchor)localObject3).b() + j;
            localConstraintWidget.add(i, localConstraintWidget.length() + i);
            a(localConstraintWidget, paramItem);
          }
          else
          {
            localObject4 = b;
            if ((localObject2 == localObject4) && (c == null))
            {
              i = j - ((ConstraintAnchor)localObject4).b();
              localConstraintWidget.add(i - localConstraintWidget.length(), i);
              a(localConstraintWidget, paramItem);
            }
            else if ((i != 0) && (!localConstraintWidget.f()))
            {
              a(paramItem, localConstraintWidget);
            }
          }
        }
      }
    }
    paramConstraintWidget = paramConstraintWidget.a(ConstraintAnchor.Type.e);
    if (paramConstraintWidget.h() != null)
    {
      if (paramConstraintWidget.i())
      {
        i = paramConstraintWidget.get();
        paramConstraintWidget = paramConstraintWidget.h().iterator();
      }
    }
    else
    {
      while (paramConstraintWidget.hasNext())
      {
        localObject1 = (ConstraintAnchor)paramConstraintWidget.next();
        localObject2 = b;
        bool = a((ConstraintWidget)localObject2);
        if ((((ConstraintWidget)localObject2).l()) && (bool)) {
          f.a((ConstraintWidget)localObject2, paramItem, new ClassWriter(), ClassWriter.a);
        }
        if (((((ConstraintWidget)localObject2).size() != ConstraintWidget.DimensionBehaviour.b) || (bool)) && (!((ConstraintWidget)localObject2).l()) && (localObject1 == t)) {
          ((ConstraintWidget)localObject2).set(i);
        }
        try
        {
          a((ConstraintWidget)localObject2, paramItem);
        }
        catch (Throwable paramConstraintWidget)
        {
          throw paramConstraintWidget;
        }
      }
      return;
    }
  }
  
  private static void a(ConstraintWidget paramConstraintWidget1, Item paramItem, ConstraintWidget paramConstraintWidget2)
  {
    float f = paramConstraintWidget2.remove();
    int k = c.c.get() + c.b();
    int m = b.c.get() - b.b();
    if (m >= k)
    {
      int j = paramConstraintWidget2.length();
      int i = j;
      if (paramConstraintWidget2.get() != 8)
      {
        int n = n;
        if (n == 2)
        {
          if ((paramConstraintWidget1 instanceof f)) {
            i = paramConstraintWidget1.length();
          } else {
            i = paramConstraintWidget1.listFiles().length();
          }
          i = (int)(f * 0.5F * i);
        }
        else
        {
          i = j;
          if (n == 0) {
            i = m - k;
          }
        }
        j = Math.max(s, i);
        i = j;
        n = m;
        if (n > 0) {
          i = Math.min(n, j);
        }
      }
      j = k + (int)(f * (m - k - i) + 0.5F);
      paramConstraintWidget2.add(j, i + j);
      a(paramConstraintWidget2, paramItem);
    }
  }
  
  private static void a(ConstraintWidget paramConstraintWidget, Item paramItem, boolean paramBoolean)
  {
    if ((!(paramConstraintWidget instanceof f)) && (paramConstraintWidget.l()) && (a(paramConstraintWidget))) {
      f.a(paramConstraintWidget, paramItem, new ClassWriter(), ClassWriter.a);
    }
    Object localObject2 = paramConstraintWidget.a(ConstraintAnchor.Type.g);
    Object localObject1 = paramConstraintWidget.a(ConstraintAnchor.Type.c);
    int k = ((ConstraintAnchor)localObject2).get();
    int j = ((ConstraintAnchor)localObject1).get();
    Object localObject3;
    ConstraintWidget localConstraintWidget;
    boolean bool;
    Object localObject4;
    int i;
    if ((((ConstraintAnchor)localObject2).h() != null) && (((ConstraintAnchor)localObject2).i()))
    {
      localObject2 = ((ConstraintAnchor)localObject2).h().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ConstraintAnchor)((Iterator)localObject2).next();
        localConstraintWidget = b;
        bool = a(localConstraintWidget);
        if ((localConstraintWidget.l()) && (bool)) {
          f.a(localConstraintWidget, paramItem, new ClassWriter(), ClassWriter.a);
        }
        localObject4 = localConstraintWidget.iterator();
        Object localObject5 = ConstraintWidget.DimensionBehaviour.b;
        if ((localObject4 == localObject5) && (!bool))
        {
          if ((localConstraintWidget.iterator() == localObject5) && (w >= 0) && (r >= 0) && ((localConstraintWidget.get() == 8) || ((i == 0) && (localConstraintWidget.p() == 0.0F))) && (!localConstraintWidget.equals()) && (!localConstraintWidget.getRangeOrigin()))
          {
            if (localObject3 == a)
            {
              localObject4 = l.c;
              if ((localObject4 != null) && (((ConstraintAnchor)localObject4).i())) {}
            }
            else
            {
              if (localObject3 != l) {
                break label329;
              }
              localObject3 = a.c;
              if ((localObject3 == null) || (!((ConstraintAnchor)localObject3).i())) {
                break label329;
              }
            }
            i = 1;
            break label331;
            label329:
            i = 0;
            label331:
            if ((i != 0) && (!localConstraintWidget.equals())) {
              b(paramConstraintWidget, paramItem, localConstraintWidget, paramBoolean);
            }
          }
        }
        else if (!localConstraintWidget.l())
        {
          localObject4 = a;
          if ((localObject3 == localObject4) && (l.c == null))
          {
            i = ((ConstraintAnchor)localObject4).b() + k;
            localConstraintWidget.a(i, localConstraintWidget.getValue() + i);
            a(localConstraintWidget, paramItem, paramBoolean);
          }
          else
          {
            localObject5 = l;
            if ((localObject3 == localObject5) && (c == null))
            {
              i = k - ((ConstraintAnchor)localObject5).b();
              localConstraintWidget.a(i - localConstraintWidget.getValue(), i);
              a(localConstraintWidget, paramItem, paramBoolean);
            }
            else if (localObject3 == localObject4)
            {
              localObject3 = c;
              if ((localObject3 != null) && (((ConstraintAnchor)localObject3).i()) && (!localConstraintWidget.equals())) {
                b(paramItem, localConstraintWidget, paramBoolean);
              }
            }
          }
        }
      }
    }
    if ((paramConstraintWidget instanceof h)) {
      return;
    }
    if ((((ConstraintAnchor)localObject1).h() != null) && (((ConstraintAnchor)localObject1).i()))
    {
      localObject1 = ((ConstraintAnchor)localObject1).h().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConstraintAnchor)((Iterator)localObject1).next();
        localConstraintWidget = b;
        bool = a(localConstraintWidget);
        if ((localConstraintWidget.l()) && (bool)) {
          f.a(localConstraintWidget, paramItem, new ClassWriter(), ClassWriter.a);
        }
        if (localObject2 == a)
        {
          localObject3 = l.c;
          if ((localObject3 != null) && (((ConstraintAnchor)localObject3).i())) {}
        }
        else
        {
          if (localObject2 != l) {
            break label692;
          }
          localObject3 = a.c;
          if ((localObject3 == null) || (!((ConstraintAnchor)localObject3).i())) {
            break label692;
          }
        }
        i = 1;
        break label694;
        label692:
        i = 0;
        label694:
        localObject3 = localConstraintWidget.iterator();
        localObject4 = ConstraintWidget.DimensionBehaviour.b;
        if ((localObject3 == localObject4) && (!bool))
        {
          if ((localConstraintWidget.iterator() == localObject4) && (w >= 0) && (r >= 0) && ((localConstraintWidget.get() == 8) || ((i == 0) && (localConstraintWidget.p() == 0.0F))) && (!localConstraintWidget.equals()) && (!localConstraintWidget.getRangeOrigin()) && (i != 0) && (!localConstraintWidget.equals())) {
            b(paramConstraintWidget, paramItem, localConstraintWidget, paramBoolean);
          }
        }
        else if (!localConstraintWidget.l())
        {
          localObject3 = a;
          if ((localObject2 == localObject3) && (l.c == null))
          {
            i = ((ConstraintAnchor)localObject3).b() + j;
            localConstraintWidget.a(i, localConstraintWidget.getValue() + i);
            a(localConstraintWidget, paramItem, paramBoolean);
          }
          else
          {
            localObject4 = l;
            if ((localObject2 == localObject4) && (c == null))
            {
              i = j - ((ConstraintAnchor)localObject4).b();
              localConstraintWidget.a(i - localConstraintWidget.getValue(), i);
              a(localConstraintWidget, paramItem, paramBoolean);
            }
            else if ((i != 0) && (!localConstraintWidget.equals()))
            {
              b(paramItem, localConstraintWidget, paramBoolean);
            }
          }
        }
      }
    }
  }
  
  private static void a(Item paramItem, ConstraintWidget paramConstraintWidget)
  {
    float f = paramConstraintWidget.remove();
    int m = c.c.get();
    int i = m;
    int k = b.c.get();
    int j = k;
    int i1 = c.b();
    int n = b.b();
    if (m == k)
    {
      f = 0.5F;
    }
    else
    {
      i = i1 + m;
      j = k - n;
    }
    n = paramConstraintWidget.length();
    k = j - i - n;
    if (i > j) {
      k = i - j - n;
    }
    i1 = (int)(f * k + 0.5F);
    k = i + i1;
    m = k + n;
    if (i > j)
    {
      k = i - i1;
      m = k - n;
    }
    paramConstraintWidget.add(k, m);
    a(paramConstraintWidget, paramItem);
  }
  
  public static void a(f paramF, Item paramItem)
  {
    Object localObject2 = paramF.iterator();
    Object localObject1 = paramF.size();
    paramF.init();
    ArrayList localArrayList = paramF.read();
    int i2 = localArrayList.size();
    int i1 = 0;
    int i = 0;
    while (i < i2)
    {
      ((ConstraintWidget)localArrayList.get(i)).init();
      i += 1;
    }
    boolean bool = paramF.c();
    if (localObject2 == ConstraintWidget.DimensionBehaviour.a) {
      paramF.a(0, paramF.getValue());
    } else {
      paramF.f(0);
    }
    int j = 0;
    int k = 0;
    int m;
    int n;
    for (i = 0; j < i2; i = n)
    {
      localObject2 = (ConstraintWidget)localArrayList.get(j);
      if ((localObject2 instanceof h))
      {
        localObject2 = (h)localObject2;
        m = k;
        n = i;
        if (((h)localObject2).e() == 1)
        {
          if (((h)localObject2).c() != -1) {
            ((h)localObject2).c(((h)localObject2).c());
          } else if ((((h)localObject2).b() != -1) && (paramF.h())) {
            ((h)localObject2).c(paramF.getValue() - ((h)localObject2).b());
          } else if (paramF.h()) {
            ((h)localObject2).c((int)(((h)localObject2).g() * paramF.getValue() + 0.5F));
          }
          m = 1;
          n = i;
        }
      }
      else
      {
        m = k;
        n = i;
        if ((localObject2 instanceof m))
        {
          m = k;
          n = i;
          if (((m)localObject2).getItemId() == 0)
          {
            n = 1;
            m = k;
          }
        }
      }
      j += 1;
      k = m;
    }
    if (k != 0)
    {
      j = 0;
      while (j < i2)
      {
        localObject2 = (ConstraintWidget)localArrayList.get(j);
        if ((localObject2 instanceof h))
        {
          localObject2 = (h)localObject2;
          if (((h)localObject2).e() == 1) {
            a((ConstraintWidget)localObject2, paramItem, bool);
          }
        }
        j += 1;
      }
    }
    a(paramF, paramItem, bool);
    if (i != 0)
    {
      i = 0;
      while (i < i2)
      {
        localObject2 = (ConstraintWidget)localArrayList.get(i);
        if ((localObject2 instanceof m))
        {
          localObject2 = (m)localObject2;
          if (((m)localObject2).getItemId() == 0) {
            a((m)localObject2, paramItem, 0, bool);
          }
        }
        i += 1;
      }
    }
    if (localObject1 == ConstraintWidget.DimensionBehaviour.a) {
      paramF.add(0, paramF.length());
    } else {
      paramF.visitMaxs(0);
    }
    j = 0;
    k = 0;
    for (i = 0; j < i2; i = n)
    {
      localObject1 = (ConstraintWidget)localArrayList.get(j);
      if ((localObject1 instanceof h))
      {
        localObject1 = (h)localObject1;
        m = k;
        n = i;
        if (((h)localObject1).e() == 0)
        {
          if (((h)localObject1).c() != -1) {
            ((h)localObject1).c(((h)localObject1).c());
          } else if ((((h)localObject1).b() != -1) && (paramF.j())) {
            ((h)localObject1).c(paramF.length() - ((h)localObject1).b());
          } else if (paramF.j()) {
            ((h)localObject1).c((int)(((h)localObject1).g() * paramF.length() + 0.5F));
          }
          m = 1;
          n = i;
        }
      }
      else
      {
        m = k;
        n = i;
        if ((localObject1 instanceof m))
        {
          m = k;
          n = i;
          if (((m)localObject1).getItemId() == 1)
          {
            n = 1;
            m = k;
          }
        }
      }
      j += 1;
      k = m;
    }
    if (k != 0)
    {
      j = 0;
      while (j < i2)
      {
        localObject1 = (ConstraintWidget)localArrayList.get(j);
        if ((localObject1 instanceof h))
        {
          localObject1 = (h)localObject1;
          if (((h)localObject1).e() == 0) {
            a((ConstraintWidget)localObject1, paramItem);
          }
        }
        j += 1;
      }
    }
    a(paramF, paramItem);
    j = i1;
    if (i != 0)
    {
      i = 0;
      for (;;)
      {
        j = i1;
        if (i >= i2) {
          break;
        }
        paramF = (ConstraintWidget)localArrayList.get(i);
        if ((paramF instanceof m))
        {
          paramF = (m)paramF;
          if (paramF.getItemId() == 1) {
            a(paramF, paramItem, 1, bool);
          }
        }
        i += 1;
      }
    }
    while (j < i2)
    {
      paramF = (ConstraintWidget)localArrayList.get(j);
      if ((paramF.l()) && (a(paramF)))
      {
        f.a(paramF, paramItem, b, ClassWriter.a);
        a(paramF, paramItem, bool);
        a(paramF, paramItem);
      }
      j += 1;
    }
  }
  
  private static void a(m paramM, Item paramItem, int paramInt, boolean paramBoolean)
  {
    if (paramM.a())
    {
      if (paramInt == 0)
      {
        a(paramM, paramItem, paramBoolean);
        return;
      }
      a(paramM, paramItem);
    }
  }
  
  private static boolean a(ConstraintWidget paramConstraintWidget)
  {
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = paramConstraintWidget.iterator();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = paramConstraintWidget.size();
    if (paramConstraintWidget.listFiles() != null) {
      localObject = (f)paramConstraintWidget.listFiles();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((ConstraintWidget)localObject).iterator();
      ConstraintWidget.DimensionBehaviour localDimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.a;
    }
    if (localObject != null)
    {
      ((ConstraintWidget)localObject).size();
      localObject = ConstraintWidget.DimensionBehaviour.a;
    }
    Object localObject = ConstraintWidget.DimensionBehaviour.a;
    int i;
    if ((localDimensionBehaviour1 != localObject) && (localDimensionBehaviour1 != ConstraintWidget.DimensionBehaviour.c) && ((localDimensionBehaviour1 != ConstraintWidget.DimensionBehaviour.b) || (paramConstraintWidget.i != 0) || (right != 0.0F) || (!paramConstraintWidget.equals(0))) && (!paramConstraintWidget.h())) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((localDimensionBehaviour2 != localObject) && (localDimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.c) && ((localDimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.b) || (n != 0) || (right != 0.0F) || (!paramConstraintWidget.equals(1))) && (!paramConstraintWidget.j())) {
      j = 0;
    } else {
      j = 1;
    }
    if (right > 0.0F)
    {
      if (i != 0) {
        break label216;
      }
      if (j != 0) {
        return true;
      }
    }
    label216:
    return (i != 0) && (j != 0);
  }
  
  private static void b(ConstraintWidget paramConstraintWidget1, Item paramItem, ConstraintWidget paramConstraintWidget2, boolean paramBoolean)
  {
    float f = paramConstraintWidget2.height();
    int k = a.c.get() + a.b();
    int m = l.c.get() - l.b();
    if (m >= k)
    {
      int j = paramConstraintWidget2.getValue();
      int i = j;
      if (paramConstraintWidget2.get() != 8)
      {
        int n = i;
        if (n == 2)
        {
          if ((paramConstraintWidget1 instanceof f)) {
            i = paramConstraintWidget1.getValue();
          } else {
            i = paramConstraintWidget1.listFiles().getValue();
          }
          i = (int)(paramConstraintWidget2.height() * 0.5F * i);
        }
        else
        {
          i = j;
          if (n == 0) {
            i = m - k;
          }
        }
        j = Math.max(r, i);
        i = j;
        n = w;
        if (n > 0) {
          i = Math.min(n, j);
        }
      }
      j = k + (int)(f * (m - k - i) + 0.5F);
      paramConstraintWidget2.a(j, i + j);
      a(paramConstraintWidget2, paramItem, paramBoolean);
    }
  }
  
  private static void b(Item paramItem, ConstraintWidget paramConstraintWidget, boolean paramBoolean)
  {
    float f = paramConstraintWidget.height();
    int m = a.c.get();
    int i = m;
    int k = l.c.get();
    int j = k;
    int i1 = a.b();
    int n = l.b();
    if (m == k)
    {
      f = 0.5F;
    }
    else
    {
      i = i1 + m;
      j = k - n;
    }
    m = paramConstraintWidget.getValue();
    k = j - i - m;
    if (i > j) {
      k = i - j - m;
    }
    n = (int)(f * k + 0.5F) + i;
    k = n + m;
    if (i > j) {
      k = n - m;
    }
    paramConstraintWidget.a(n, k);
    a(paramConstraintWidget, paramItem, paramBoolean);
  }
}
