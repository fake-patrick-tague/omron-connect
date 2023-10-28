package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.AnnotationWriter;
import androidx.constraintlayout.solver.widgets.ByteVector;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.Frame;
import androidx.constraintlayout.solver.widgets.d;
import androidx.constraintlayout.solver.widgets.f;
import androidx.constraintlayout.solver.widgets.h;
import androidx.constraintlayout.solver.widgets.m;
import java.util.ArrayList;

public class Attribute
{
  private final ArrayList<ConstraintWidget> a = new ArrayList();
  private ClassWriter b = new ClassWriter();
  private f j;
  
  public Attribute(f paramF)
  {
    j = paramF;
  }
  
  private void a(f paramF)
  {
    int i1 = a.size();
    boolean bool = paramF.b(64);
    Item localItem = paramF.r();
    int m = 0;
    while (m < i1)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)a.get(m);
      if ((!(localConstraintWidget instanceof h)) && (!(localConstraintWidget instanceof m)) && (!localConstraintWidget.getRangeOrigin()))
      {
        if (bool)
        {
          localObject1 = d;
          if (localObject1 != null)
          {
            localObject2 = e;
            if ((localObject2 != null) && (c.i) && (c.i)) {
              break label363;
            }
          }
        }
        Object localObject1 = localConstraintWidget.valueOf(0);
        int n = 1;
        Object localObject2 = localConstraintWidget.valueOf(1);
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.b;
        int i;
        if ((localObject1 == localDimensionBehaviour) && (i != 1) && (localObject2 == localDimensionBehaviour) && (n != 1)) {
          i = 1;
        } else {
          i = 0;
        }
        int k = i;
        if (i == 0)
        {
          k = i;
          if (paramF.b(1))
          {
            k = i;
            if (!(localConstraintWidget instanceof d))
            {
              k = i;
              if (localObject1 == localDimensionBehaviour)
              {
                k = i;
                if (i == 0)
                {
                  k = i;
                  if (localObject2 != localDimensionBehaviour)
                  {
                    k = i;
                    if (!localConstraintWidget.equals()) {
                      k = 1;
                    }
                  }
                }
              }
              i = k;
              if (localObject2 == localDimensionBehaviour)
              {
                i = k;
                if (n == 0)
                {
                  i = k;
                  if (localObject1 != localDimensionBehaviour)
                  {
                    i = k;
                    if (!localConstraintWidget.equals()) {
                      i = 1;
                    }
                  }
                }
              }
              if (localObject1 != localDimensionBehaviour)
              {
                k = i;
                if (localObject2 != localDimensionBehaviour) {}
              }
              else
              {
                k = i;
                if (right > 0.0F) {
                  k = n;
                }
              }
            }
          }
        }
        if (k == 0)
        {
          a(localItem, localConstraintWidget, ClassWriter.a);
          if (c != null) {
            break label372;
          }
        }
      }
      label363:
      m += 1;
      continue;
      label372:
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    localItem.a();
  }
  
  private void a(f paramF, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramF.replace();
    int k = paramF.getX();
    paramF.send(0);
    paramF.init(0);
    paramF.get(paramInt1);
    paramF.append(paramInt2);
    paramF.send(i);
    paramF.init(k);
    j.a();
  }
  
  private boolean a(Item paramItem, ConstraintWidget paramConstraintWidget, int paramInt)
  {
    b.i = paramConstraintWidget.iterator();
    b.b = paramConstraintWidget.size();
    b.f = paramConstraintWidget.getValue();
    b.j = paramConstraintWidget.length();
    ClassWriter localClassWriter = b;
    k = false;
    c = paramInt;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = i;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.b;
    int i;
    if (localDimensionBehaviour1 == localDimensionBehaviour2) {
      i = 1;
    } else {
      i = 0;
    }
    if (b == localDimensionBehaviour2) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((i != 0) && (right > 0.0F)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt != 0) && (right > 0.0F)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((i != 0) && (o[0] == 4)) {
      i = ConstraintWidget.DimensionBehaviour.a;
    }
    if ((paramInt != 0) && (o[1] == 4)) {
      b = ConstraintWidget.DimensionBehaviour.a;
    }
    paramItem.a(paramConstraintWidget, localClassWriter);
    paramConstraintWidget.get(b.z);
    paramConstraintWidget.append(b.s);
    paramConstraintWidget.append(b.e);
    paramConstraintWidget.putShort(b.q);
    paramItem = b;
    c = ClassWriter.a;
    return k;
  }
  
  public long a(f paramF, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    Item localItem = paramF.r();
    paramInt9 = a.size();
    int k = paramF.getValue();
    int m = paramF.length();
    boolean bool = Frame.b(paramInt1, 128);
    if ((!bool) && (!Frame.b(paramInt1, 64))) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramInt3 = paramInt1;
    Object localObject;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1;
    if (paramInt1 != 0)
    {
      paramInt2 = 0;
      for (;;)
      {
        paramInt3 = paramInt1;
        if (paramInt2 >= paramInt9) {
          break;
        }
        localObject = (ConstraintWidget)a.get(paramInt2);
        localDimensionBehaviour1 = ((ConstraintWidget)localObject).iterator();
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.b;
        if (localDimensionBehaviour1 == localDimensionBehaviour2) {
          paramInt3 = 1;
        } else {
          paramInt3 = 0;
        }
        if (((ConstraintWidget)localObject).size() == localDimensionBehaviour2) {
          paramInt8 = 1;
        } else {
          paramInt8 = 0;
        }
        if ((paramInt3 != 0) && (paramInt8 != 0) && (((ConstraintWidget)localObject).p() > 0.0F)) {
          paramInt3 = 1;
        } else {
          paramInt3 = 0;
        }
        if ((((ConstraintWidget)localObject).equals()) && (paramInt3 != 0)) {}
        while (((((ConstraintWidget)localObject).f()) && (paramInt3 != 0)) || ((localObject instanceof d)) || (((ConstraintWidget)localObject).equals()) || (((ConstraintWidget)localObject).f()))
        {
          paramInt3 = 0;
          break;
        }
        paramInt2 += 1;
      }
    }
    if ((paramInt3 != 0) && (androidx.constraintlayout.solver.ClassWriter.c != null)) {
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    if (((paramInt4 == 1073741824) && (paramInt6 == 1073741824)) || (bool)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int n = paramInt3 & paramInt1;
    int i5;
    int i9;
    if (n != 0)
    {
      paramInt1 = Math.min(paramF.next(), paramInt5);
      paramInt2 = Math.min(paramF.readLong(), paramInt7);
      if ((paramInt4 == 1073741824) && (paramF.getValue() != paramInt1))
      {
        paramF.get(paramInt1);
        paramF.visitEnum();
      }
      if ((paramInt6 == 1073741824) && (paramF.length() != paramInt2))
      {
        paramF.append(paramInt2);
        paramF.visitEnum();
      }
      if ((paramInt4 == 1073741824) && (paramInt6 == 1073741824))
      {
        i5 = paramF.b(bool);
        paramInt1 = 2;
      }
      else
      {
        int i7 = paramF.a(bool);
        i5 = i7;
        if (paramInt4 == 1073741824)
        {
          i5 = i7 & paramF.b(bool, 0);
          paramInt1 = 1;
        }
        else
        {
          paramInt1 = 0;
        }
        if (paramInt6 == 1073741824)
        {
          i5 = paramF.b(bool, 1) & i5;
          paramInt1 += 1;
        }
      }
      int i8 = i5;
      paramInt2 = paramInt1;
      if (i5 != 0)
      {
        if (paramInt4 == 1073741824) {
          i8 = 1;
        } else {
          i8 = 0;
        }
        if (paramInt6 == 1073741824) {
          bool = true;
        } else {
          bool = false;
        }
        paramF.add(i8, bool);
        i9 = i5;
        paramInt2 = paramInt1;
      }
    }
    else
    {
      i9 = 0;
      paramInt2 = 0;
    }
    if ((i9 == 0) || (paramInt2 != 2))
    {
      int i1 = paramF.intValue();
      if (paramInt9 > 0) {
        a(paramF);
      }
      write(paramF);
      int i2 = a.size();
      if (paramInt9 > 0) {
        a(paramF, "First pass", k, m);
      }
      if (i2 > 0)
      {
        localObject = paramF.iterator();
        localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.c;
        if (localObject == localDimensionBehaviour1) {
          paramInt6 = 1;
        } else {
          paramInt6 = 0;
        }
        if (paramF.size() == localDimensionBehaviour1) {
          paramInt7 = 1;
        } else {
          paramInt7 = 0;
        }
        paramInt2 = Math.max(paramF.getValue(), j.replace());
        paramInt1 = Math.max(paramF.length(), j.getX());
        paramInt5 = 0;
        paramInt3 = 0;
        int i;
        while (paramInt5 < i2)
        {
          localObject = (ConstraintWidget)a.get(paramInt5);
          if ((localObject instanceof d))
          {
            paramInt4 = ((ConstraintWidget)localObject).getValue();
            paramInt8 = ((ConstraintWidget)localObject).length();
            i5 = a(localItem, (ConstraintWidget)localObject, ClassWriter.d);
            if (c == null)
            {
              i = ((ConstraintWidget)localObject).getValue();
              paramInt9 = ((ConstraintWidget)localObject).length();
              if (i != paramInt4)
              {
                ((ConstraintWidget)localObject).get(i);
                paramInt3 = paramInt2;
                if (paramInt6 != 0)
                {
                  paramInt3 = paramInt2;
                  if (((ConstraintWidget)localObject).readShort() > paramInt2) {
                    paramInt3 = Math.max(paramInt2, ((ConstraintWidget)localObject).readShort() + ((ConstraintWidget)localObject).a(ConstraintAnchor.Type.c).b());
                  }
                }
                paramInt4 = 1;
                paramInt2 = paramInt3;
              }
              else
              {
                paramInt4 = i5 | paramInt3;
              }
              paramInt3 = paramInt1;
              if (paramInt9 != paramInt8)
              {
                ((ConstraintWidget)localObject).append(paramInt9);
                paramInt3 = paramInt1;
                if (paramInt7 != 0)
                {
                  paramInt3 = paramInt1;
                  if (((ConstraintWidget)localObject).getRectF() > paramInt1) {
                    paramInt3 = Math.max(paramInt1, ((ConstraintWidget)localObject).getRectF() + ((ConstraintWidget)localObject).a(ConstraintAnchor.Type.b).b());
                  }
                }
                paramInt4 = 1;
              }
              paramInt4 |= ((d)localObject).k();
              paramInt1 = paramInt3;
              paramInt3 = paramInt4;
            }
          }
          else
          {
            paramInt5 += 1;
            continue;
          }
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
        paramInt8 = 0;
        for (;;)
        {
          paramInt5 = paramInt3;
          paramInt9 = paramInt2;
          paramInt4 = paramInt1;
          if (paramInt8 >= 2) {
            break;
          }
          paramInt9 = 0;
          while (paramInt9 < i2)
          {
            localObject = (ConstraintWidget)a.get(paramInt9);
            if ((((localObject instanceof AnnotationWriter)) && (!(localObject instanceof d))) || ((localObject instanceof h)) || (((ConstraintWidget)localObject).get() == 8) || ((n != 0) && (d.c.i) && (e.c.i)) || ((localObject instanceof d)))
            {
              paramInt5 = paramInt3;
              i = paramInt2;
            }
            else
            {
              int i4 = ((ConstraintWidget)localObject).getValue();
              paramInt5 = ((ConstraintWidget)localObject).length();
              int i3 = ((ConstraintWidget)localObject).newUTF8();
              paramInt4 = ClassWriter.d;
              if (paramInt8 == 1) {
                paramInt4 = ClassWriter.r;
              }
              int i6 = a(localItem, (ConstraintWidget)localObject, paramInt4);
              if (c != null) {
                break label1330;
              }
              paramInt4 = ((ConstraintWidget)localObject).getValue();
              i = ((ConstraintWidget)localObject).length();
              if (paramInt4 != i4)
              {
                ((ConstraintWidget)localObject).get(paramInt4);
                paramInt3 = paramInt2;
                if (paramInt6 != 0)
                {
                  paramInt3 = paramInt2;
                  if (((ConstraintWidget)localObject).readShort() > paramInt2) {
                    paramInt3 = Math.max(paramInt2, ((ConstraintWidget)localObject).readShort() + ((ConstraintWidget)localObject).a(ConstraintAnchor.Type.c).b());
                  }
                }
                paramInt4 = 1;
                paramInt2 = paramInt3;
              }
              else
              {
                paramInt4 = i6 | paramInt3;
              }
              paramInt3 = paramInt1;
              if (i != paramInt5)
              {
                ((ConstraintWidget)localObject).append(i);
                paramInt3 = paramInt1;
                if (paramInt7 != 0)
                {
                  paramInt3 = paramInt1;
                  if (((ConstraintWidget)localObject).getRectF() > paramInt1) {
                    paramInt3 = Math.max(paramInt1, ((ConstraintWidget)localObject).getRectF() + ((ConstraintWidget)localObject).a(ConstraintAnchor.Type.b).b());
                  }
                }
                paramInt4 = 1;
              }
              paramInt5 = paramInt4;
              i = paramInt2;
              paramInt1 = paramInt3;
              if (((ConstraintWidget)localObject).q())
              {
                paramInt5 = paramInt4;
                i = paramInt2;
                paramInt1 = paramInt3;
                if (i3 != ((ConstraintWidget)localObject).newUTF8())
                {
                  paramInt5 = 1;
                  i = paramInt2;
                  paramInt1 = paramInt3;
                }
              }
            }
            paramInt9 += 1;
            paramInt3 = paramInt5;
            paramInt2 = i;
            continue;
            label1330:
            throw new NullPointerException("Null throw statement replaced by Soot");
          }
          paramInt5 = paramInt3;
          paramInt9 = paramInt2;
          paramInt4 = paramInt1;
          if (paramInt3 == 0) {
            break;
          }
          a(paramF, "intermediate pass", k, m);
          paramInt8 += 1;
          paramInt3 = 0;
        }
        if (paramInt5 != 0)
        {
          a(paramF, "2nd pass", k, m);
          if (paramF.getValue() < paramInt9)
          {
            paramF.get(paramInt9);
            paramInt1 = 1;
          }
          else
          {
            paramInt1 = 0;
          }
          if (paramF.length() < paramInt4)
          {
            paramF.append(paramInt4);
            paramInt1 = 1;
          }
          if (paramInt1 != 0) {
            a(paramF, "3rd pass", k, m);
          }
        }
      }
      paramF.a(i1);
    }
    return 0L;
  }
  
  public void write(f paramF)
  {
    a.clear();
    int k = a.size();
    int i = 0;
    while (i < k)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)a.get(i);
      ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = localConstraintWidget.iterator();
      ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.b;
      if ((localDimensionBehaviour1 == localDimensionBehaviour2) || (localConstraintWidget.size() == localDimensionBehaviour2)) {
        a.add(localConstraintWidget);
      }
      i += 1;
    }
    paramF.visitEnum();
  }
}
