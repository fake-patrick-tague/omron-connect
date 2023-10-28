package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ByteVector;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.Label;
import androidx.constraintlayout.solver.widgets.f;
import androidx.constraintlayout.solver.widgets.h;
import androidx.constraintlayout.solver.widgets.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SignatureReader
{
  public static i a(ConstraintWidget paramConstraintWidget, int paramInt, ArrayList paramArrayList, i paramI)
  {
    int i;
    if (paramInt == 0) {
      i = E;
    } else {
      i = f;
    }
    int k = 0;
    int j;
    if ((i != -1) && ((paramI == null) || (i != b)))
    {
      j = 0;
      for (;;)
      {
        localObject = paramI;
        if (j >= paramArrayList.size()) {
          break;
        }
        localObject = (i)paramArrayList.get(j);
        if (((i)localObject).a() == i)
        {
          if (paramI != null)
          {
            paramI.a(paramInt, (i)localObject);
            paramArrayList.remove(paramI);
          }
          break;
        }
        j += 1;
      }
    }
    Object localObject = paramI;
    if (i != -1) {
      return paramI;
    }
    paramI = (i)localObject;
    if (localObject == null)
    {
      paramI = (i)localObject;
      if ((paramConstraintWidget instanceof Label))
      {
        j = ((Label)paramConstraintWidget).a(paramInt);
        paramI = (i)localObject;
        if (j != -1)
        {
          i = 0;
          for (;;)
          {
            paramI = (i)localObject;
            if (i >= paramArrayList.size()) {
              break;
            }
            paramI = (i)paramArrayList.get(i);
            if (paramI.a() == j) {
              break;
            }
            i += 1;
          }
        }
      }
      localObject = paramI;
      if (paramI == null) {
        localObject = new i(paramInt);
      }
      paramArrayList.add(localObject);
      paramI = (i)localObject;
    }
    if (paramI.a(paramConstraintWidget))
    {
      if ((paramConstraintWidget instanceof h))
      {
        localObject = (h)paramConstraintWidget;
        ConstraintAnchor localConstraintAnchor = ((h)localObject).a();
        i = k;
        if (((h)localObject).e() == 0) {
          i = 1;
        }
        localConstraintAnchor.a(i, paramArrayList, paramI);
      }
      if (paramInt == 0)
      {
        E = paramI.a();
        a.a(paramInt, paramArrayList, paramI);
        l.a(paramInt, paramArrayList, paramI);
      }
      else
      {
        f = paramI.a();
        c.a(paramInt, paramArrayList, paramI);
        t.a(paramInt, paramArrayList, paramI);
        b.a(paramInt, paramArrayList, paramI);
      }
      q.a(paramInt, paramArrayList, paramI);
    }
    return paramI;
  }
  
  private static i a(ArrayList paramArrayList, int paramInt)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      i localI = (i)paramArrayList.get(i);
      if (paramInt == b) {
        return localI;
      }
      i += 1;
    }
    return null;
  }
  
  public static boolean a(ConstraintWidget.DimensionBehaviour paramDimensionBehaviour1, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour2, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour3, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour4)
  {
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.a;
    if (paramDimensionBehaviour3 != localDimensionBehaviour1)
    {
      ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.c;
      if ((paramDimensionBehaviour3 != localDimensionBehaviour2) && ((paramDimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.g) || (paramDimensionBehaviour1 == localDimensionBehaviour2)))
      {
        i = 0;
        break label47;
      }
    }
    int i = 1;
    label47:
    if (paramDimensionBehaviour4 != localDimensionBehaviour1)
    {
      paramDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.c;
      if ((paramDimensionBehaviour4 != paramDimensionBehaviour1) && ((paramDimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.g) || (paramDimensionBehaviour2 == paramDimensionBehaviour1)))
      {
        j = 0;
        break label86;
      }
    }
    int j = 1;
    label86:
    if (i == 0) {
      return j != 0;
    }
    return true;
  }
  
  public static boolean a(f paramF, Item paramItem)
  {
    ArrayList localArrayList = paramF.read();
    int j = localArrayList.size();
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = (ConstraintWidget)localArrayList.get(i);
      if (!a(paramF.iterator(), paramF.size(), ((ConstraintWidget)localObject1).iterator(), ((ConstraintWidget)localObject1).size())) {
        return false;
      }
      i += 1;
    }
    if (c == null)
    {
      i = 0;
      Object localObject7 = null;
      localObject1 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject5 = null;
      Object localObject11;
      for (Object localObject4 = null; i < j; localObject4 = localObject11)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)localArrayList.get(i);
        if (!a(paramF.iterator(), paramF.size(), localConstraintWidget.iterator(), localConstraintWidget.size())) {
          f.a(localConstraintWidget, paramItem, h, ClassWriter.a);
        }
        boolean bool = localConstraintWidget instanceof h;
        Object localObject9 = localObject7;
        Object localObject8 = localObject3;
        if (bool)
        {
          localObject10 = (h)localConstraintWidget;
          localObject6 = localObject3;
          if (((h)localObject10).e() == 0)
          {
            localObject6 = localObject3;
            if (localObject3 == null) {
              localObject6 = new ArrayList();
            }
            ((ArrayList)localObject6).add(localObject10);
          }
          localObject9 = localObject7;
          localObject8 = localObject6;
          if (((h)localObject10).e() == 1)
          {
            localObject3 = localObject7;
            if (localObject7 == null) {
              localObject3 = new ArrayList();
            }
            ((ArrayList)localObject3).add(localObject10);
            localObject8 = localObject6;
            localObject9 = localObject3;
          }
        }
        localObject3 = localObject1;
        localObject6 = localObject2;
        if ((localConstraintWidget instanceof Label)) {
          if ((localConstraintWidget instanceof m))
          {
            localObject10 = (m)localConstraintWidget;
            localObject7 = localObject1;
            if (((m)localObject10).getItemId() == 0)
            {
              localObject7 = localObject1;
              if (localObject1 == null) {
                localObject7 = new ArrayList();
              }
              ((ArrayList)localObject7).add(localObject10);
            }
            localObject3 = localObject7;
            localObject6 = localObject2;
            if (((m)localObject10).getItemId() == 1)
            {
              localObject6 = localObject2;
              if (localObject2 == null) {
                localObject6 = new ArrayList();
              }
              ((ArrayList)localObject6).add(localObject10);
              localObject3 = localObject7;
            }
          }
          else
          {
            localObject7 = (Label)localConstraintWidget;
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = new ArrayList();
            }
            ((ArrayList)localObject3).add(localObject7);
            localObject6 = localObject2;
            if (localObject2 == null) {
              localObject6 = new ArrayList();
            }
            ((ArrayList)localObject6).add(localObject7);
          }
        }
        Object localObject10 = localObject5;
        if (a.c == null)
        {
          localObject10 = localObject5;
          if (l.c == null)
          {
            localObject10 = localObject5;
            if (!bool)
            {
              localObject10 = localObject5;
              if (!(localConstraintWidget instanceof m))
              {
                localObject1 = localObject5;
                if (localObject5 == null) {
                  localObject1 = new ArrayList();
                }
                ((ArrayList)localObject1).add(localConstraintWidget);
                localObject10 = localObject1;
              }
            }
          }
        }
        localObject11 = localObject4;
        if (c.c == null)
        {
          localObject11 = localObject4;
          if (b.c == null)
          {
            localObject11 = localObject4;
            if (t.c == null)
            {
              localObject11 = localObject4;
              if (!bool)
              {
                localObject11 = localObject4;
                if (!(localConstraintWidget instanceof m))
                {
                  localObject1 = localObject4;
                  if (localObject4 == null) {
                    localObject1 = new ArrayList();
                  }
                  ((ArrayList)localObject1).add(localConstraintWidget);
                  localObject11 = localObject1;
                }
              }
            }
          }
        }
        i += 1;
        localObject7 = localObject9;
        localObject1 = localObject3;
        localObject3 = localObject8;
        localObject2 = localObject6;
        localObject5 = localObject10;
      }
      Object localObject6 = new ArrayList();
      if (localObject7 != null)
      {
        paramItem = ((ArrayList)localObject7).iterator();
        while (paramItem.hasNext()) {
          a((h)paramItem.next(), 0, (ArrayList)localObject6, null);
        }
      }
      if (localObject1 != null)
      {
        paramItem = ((ArrayList)localObject1).iterator();
        while (paramItem.hasNext())
        {
          localObject1 = (Label)paramItem.next();
          localObject7 = a((ConstraintWidget)localObject1, 0, (ArrayList)localObject6, null);
          ((Label)localObject1).a((ArrayList)localObject6, 0, (i)localObject7);
          ((i)localObject7).a((ArrayList)localObject6);
        }
      }
      paramItem = paramF.a(ConstraintAnchor.Type.g);
      if (paramItem.h() != null)
      {
        paramItem = paramItem.h().iterator();
        while (paramItem.hasNext()) {
          a(nextb, 0, (ArrayList)localObject6, null);
        }
      }
      paramItem = paramF.a(ConstraintAnchor.Type.c);
      if (paramItem.h() != null)
      {
        paramItem = paramItem.h().iterator();
        while (paramItem.hasNext()) {
          a(nextb, 0, (ArrayList)localObject6, null);
        }
      }
      paramItem = paramF.a(ConstraintAnchor.Type.i);
      if (paramItem.h() != null)
      {
        paramItem = paramItem.h().iterator();
        while (paramItem.hasNext()) {
          a(nextb, 0, (ArrayList)localObject6, null);
        }
      }
      if (localObject5 != null)
      {
        paramItem = localObject5.iterator();
        while (paramItem.hasNext()) {
          a((ConstraintWidget)paramItem.next(), 0, (ArrayList)localObject6, null);
        }
      }
      if (localObject3 != null)
      {
        paramItem = ((ArrayList)localObject3).iterator();
        while (paramItem.hasNext()) {
          a((h)paramItem.next(), 1, (ArrayList)localObject6, null);
        }
      }
      if (localObject2 != null)
      {
        paramItem = ((ArrayList)localObject2).iterator();
        while (paramItem.hasNext())
        {
          localObject1 = (Label)paramItem.next();
          localObject2 = a((ConstraintWidget)localObject1, 1, (ArrayList)localObject6, null);
          ((Label)localObject1).a((ArrayList)localObject6, 1, (i)localObject2);
          ((i)localObject2).a((ArrayList)localObject6);
        }
      }
      paramItem = paramF.a(ConstraintAnchor.Type.a);
      if (paramItem.h() != null)
      {
        paramItem = paramItem.h().iterator();
        while (paramItem.hasNext()) {
          a(nextb, 1, (ArrayList)localObject6, null);
        }
      }
      paramItem = paramF.a(ConstraintAnchor.Type.e);
      if (paramItem.h() != null)
      {
        paramItem = paramItem.h().iterator();
        while (paramItem.hasNext()) {
          a(nextb, 1, (ArrayList)localObject6, null);
        }
      }
      paramItem = paramF.a(ConstraintAnchor.Type.b);
      if (paramItem.h() != null)
      {
        paramItem = paramItem.h().iterator();
        while (paramItem.hasNext()) {
          a(nextb, 1, (ArrayList)localObject6, null);
        }
      }
      paramItem = paramF.a(ConstraintAnchor.Type.i);
      if (paramItem.h() != null)
      {
        paramItem = paramItem.h().iterator();
        while (paramItem.hasNext()) {
          a(nextb, 1, (ArrayList)localObject6, null);
        }
      }
      if (localObject4 != null)
      {
        paramItem = localObject4.iterator();
        while (paramItem.hasNext()) {
          a((ConstraintWidget)paramItem.next(), 1, (ArrayList)localObject6, null);
        }
      }
      i = 0;
      while (i < j)
      {
        localObject1 = (ConstraintWidget)localArrayList.get(i);
        if (((ConstraintWidget)localObject1).hasNext())
        {
          paramItem = a((ArrayList)localObject6, E);
          localObject1 = a((ArrayList)localObject6, f);
          if ((paramItem != null) && (localObject1 != null))
          {
            paramItem.a(0, (i)localObject1);
            ((i)localObject1).a(2);
            ((ArrayList)localObject6).remove(paramItem);
          }
        }
        i += 1;
      }
      if (((ArrayList)localObject6).size() <= 1) {
        return false;
      }
      if (paramF.iterator() == ConstraintWidget.DimensionBehaviour.c)
      {
        localObject2 = ((ArrayList)localObject6).iterator();
        i = 0;
        paramItem = null;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (i)((Iterator)localObject2).next();
          if (((i)localObject1).b() != 1)
          {
            ((i)localObject1).e(false);
            j = ((i)localObject1).b(paramF.n(), 0);
            if (j > i)
            {
              paramItem = (Item)localObject1;
              i = j;
            }
          }
        }
        if (paramItem != null)
        {
          paramF.add(ConstraintWidget.DimensionBehaviour.a);
          paramF.get(i);
          paramItem.e(true);
          localObject1 = paramItem;
          break label1538;
        }
      }
      localObject1 = null;
      label1538:
      if (paramF.size() == ConstraintWidget.DimensionBehaviour.c)
      {
        localObject3 = ((ArrayList)localObject6).iterator();
        paramItem = null;
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (i)((Iterator)localObject3).next();
          if (((i)localObject2).b() != 0)
          {
            ((i)localObject2).e(false);
            j = ((i)localObject2).b(paramF.n(), 1);
            if (j > i)
            {
              paramItem = (Item)localObject2;
              i = j;
            }
          }
        }
        if (paramItem != null)
        {
          paramF.a(ConstraintWidget.DimensionBehaviour.a);
          paramF.append(i);
          paramItem.e(true);
          break label1648;
        }
      }
      paramItem = null;
      label1648:
      return (localObject1 != null) || (paramItem != null);
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
