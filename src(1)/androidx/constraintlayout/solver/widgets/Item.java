package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ClassWriter;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.h;
import java.util.ArrayList;

public class Item
{
  static void a(f paramF, ClassWriter paramClassWriter, int paramInt1, int paramInt2, i paramI)
  {
    ConstraintWidget localConstraintWidget1 = a;
    ConstraintWidget localConstraintWidget3 = s;
    Object localObject1 = b;
    ConstraintWidget localConstraintWidget2 = i;
    Object localObject6 = x;
    float f1 = m;
    int n;
    if (u[paramInt1] == ConstraintWidget.DimensionBehaviour.c) {
      n = 1;
    } else {
      n = 0;
    }
    int i;
    int j;
    if (paramInt1 == 0)
    {
      i1 = count;
      if (i1 == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i1 == 1) {
        j = 1;
      } else {
        j = 0;
      }
      k = i;
      m = j;
      if (i1 != 2) {
        break label184;
      }
    }
    else
    {
      i1 = index;
      if (i1 == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i1 == 1) {
        j = 1;
      } else {
        j = 0;
      }
      k = i;
      m = j;
      if (i1 != 2) {
        break label184;
      }
    }
    int i1 = 1;
    int k = i;
    int m = j;
    break label187;
    label184:
    i1 = 0;
    label187:
    Object localObject3 = localConstraintWidget1;
    int i2 = 0;
    Object localObject7;
    Object localObject4;
    Object localObject2;
    Object localObject5;
    int i3;
    for (;;)
    {
      localObject7 = null;
      localObject4 = null;
      if (i2 != 0) {
        break;
      }
      localObject2 = h[paramInt2];
      if (i1 != 0) {
        i = 1;
      } else {
        i = 4;
      }
      int i5 = ((ConstraintAnchor)localObject2).b();
      j = i5;
      localObject7 = u[paramInt1];
      localObject5 = ConstraintWidget.DimensionBehaviour.b;
      if ((localObject7 == localObject5) && (o[paramInt1] == 0)) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      localObject7 = c;
      int i4 = j;
      if (localObject7 != null)
      {
        i4 = j;
        if (localObject3 != localConstraintWidget1) {
          i4 = i5 + ((ConstraintAnchor)localObject7).b();
        }
      }
      j = i;
      if (i1 != 0)
      {
        j = i;
        if (localObject3 != localConstraintWidget1)
        {
          j = i;
          if (localObject3 != localObject1) {
            j = 8;
          }
        }
      }
      localObject7 = c;
      if (localObject7 != null)
      {
        if (localObject3 == localObject1) {
          paramClassWriter.d(i, i, i4, 6);
        } else {
          paramClassWriter.d(i, i, i4, 8);
        }
        i = j;
        if (i3 != 0)
        {
          i = j;
          if (i1 == 0) {
            i = 5;
          }
        }
        paramClassWriter.a(i, c.i, i4, i);
      }
      if (n != 0)
      {
        if ((((ConstraintWidget)localObject3).get() != 8) && (u[paramInt1] == localObject5))
        {
          localObject2 = h;
          paramClassWriter.d(1i, i, 0, 5);
        }
        paramClassWriter.d(h[paramInt2].i, h[paramInt2].i, 0, 8);
      }
      localObject5 = h[(paramInt2 + 1)].c;
      localObject2 = localObject4;
      if (localObject5 != null)
      {
        localObject5 = b;
        localObject7 = h;
        localObject2 = localObject4;
        if (c != null) {
          if (c.b != localObject3) {
            localObject2 = localObject4;
          } else {
            localObject2 = localObject5;
          }
        }
      }
      if (localObject2 == null)
      {
        i2 = 1;
        localObject2 = localObject3;
      }
      localObject3 = localObject2;
    }
    if (localConstraintWidget2 != null)
    {
      localObject2 = h;
      j = paramInt2 + 1;
      if (c != null)
      {
        localObject2 = h[j];
        if ((u[paramInt1] == ConstraintWidget.DimensionBehaviour.b) && (o[paramInt1] == 0)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i != 0) && (i1 == 0))
        {
          localObject3 = c;
          if (b == paramF)
          {
            paramClassWriter.a(i, i, -((ConstraintAnchor)localObject2).b(), 5);
            break label833;
          }
        }
        if (i1 != 0)
        {
          localObject3 = c;
          if (b == paramF) {
            paramClassWriter.a(i, i, -((ConstraintAnchor)localObject2).b(), 4);
          }
        }
        label833:
        paramClassWriter.b(i, h[j].c.i, -((ConstraintAnchor)localObject2).b(), 6);
      }
    }
    if (n != 0)
    {
      paramF = h;
      i = paramInt2 + 1;
      paramF = i;
      localObject2 = h;
      paramClassWriter.d(paramF, i, localObject2[i].b(), 8);
    }
    localObject3 = c;
    label1112:
    Object localObject8;
    Object localObject9;
    if (localObject3 != null)
    {
      j = ((ArrayList)localObject3).size();
      if (j > 1)
      {
        float f2 = f1;
        if (h)
        {
          f2 = f1;
          if (!d) {
            f2 = j;
          }
        }
        float f3 = 0.0F;
        paramF = null;
        i = 0;
        while (i < j)
        {
          localObject2 = (ConstraintWidget)((ArrayList)localObject3).get(i);
          float f4 = P[paramInt1];
          f1 = f4;
          if (f4 < 0.0F)
          {
            if (d)
            {
              localObject2 = h;
              paramClassWriter.a(1i, i, 0, 4);
              break label1112;
            }
            f1 = 1.0F;
          }
          if (f1 == 0.0F)
          {
            localObject2 = h;
            paramClassWriter.a(1i, i, 0, 8);
            f1 = f3;
          }
          else
          {
            if (paramF != null)
            {
              localObject4 = h;
              paramF = i;
              n = paramInt2 + 1;
              localObject4 = i;
              localObject8 = h;
              localObject5 = i;
              localObject8 = i;
              localObject9 = paramClassWriter.c();
              ((h)localObject9).a(f3, f2, f1, paramF, (SolverVariable)localObject4, (SolverVariable)localObject5, (SolverVariable)localObject8);
              paramClassWriter.a((h)localObject9);
            }
            paramF = (f)localObject2;
          }
          i += 1;
          f3 = f1;
        }
      }
    }
    if ((localObject1 != null) && ((localObject1 == localConstraintWidget2) || (i1 != 0)))
    {
      paramF = h[paramInt2];
      paramI = h;
      i = paramInt2 + 1;
      paramI = paramI[i];
      paramF = c;
      if (paramF != null) {
        paramF = paramF.i;
      } else {
        paramF = null;
      }
      paramI = c;
      if (paramI != null) {
        paramI = i;
      } else {
        paramI = null;
      }
      localObject2 = h[paramInt2];
      localObject3 = h[i];
      if ((paramF != null) && (paramI != null))
      {
        if (paramInt1 == 0) {
          f1 = height;
        } else {
          f1 = left;
        }
        paramInt1 = ((ConstraintAnchor)localObject2).b();
        i = ((ConstraintAnchor)localObject3).b();
        paramClassWriter.a(i, paramF, paramInt1, f1, paramI, i, i, 7);
      }
    }
    else
    {
      if ((k != 0) && (localObject1 != null))
      {
        i = j;
        if ((i > 0) && (g == i)) {
          n = 1;
        } else {
          n = 0;
        }
        paramI = (i)localObject1;
        localObject4 = localObject1;
      }
      while (paramI != null)
      {
        for (localObject2 = bottom[paramInt1]; (localObject2 != null) && (((ConstraintWidget)localObject2).get() == 8); localObject2 = bottom[paramInt1]) {}
        if ((localObject2 == null) && (paramI != localConstraintWidget2)) {}
        for (;;)
        {
          break;
          localObject5 = h[paramInt2];
          localObject9 = i;
          paramF = c;
          if (paramF != null) {
            localObject3 = paramF.i;
          } else {
            localObject3 = null;
          }
          if (localObject4 != paramI)
          {
            paramF = h[(paramInt2 + 1)].i;
          }
          else
          {
            paramF = (f)localObject3;
            if (paramI == localObject1)
            {
              paramF = (f)localObject3;
              if (localObject4 == paramI)
              {
                paramF = h;
                if (c != null) {
                  paramF = c.i;
                } else {
                  paramF = null;
                }
              }
            }
          }
          i1 = ((ConstraintAnchor)localObject5).b();
          j = i1;
          localObject3 = h;
          i3 = paramInt2 + 1;
          i2 = localObject3[i3].b();
          i = i2;
          if (localObject2 != null)
          {
            localObject3 = h[paramInt2];
            localObject6 = h[i3].i;
            localObject5 = i;
          }
          else
          {
            localObject8 = h[i3].c;
            if (localObject8 != null) {
              localObject3 = i;
            } else {
              localObject3 = null;
            }
            localObject6 = h[i3].i;
            localObject5 = localObject3;
            localObject3 = localObject8;
          }
          if (localObject3 != null) {
            i = i2 + ((ConstraintAnchor)localObject3).b();
          }
          if (localObject4 != null) {
            j = i1 + h[i3].b();
          }
          if ((localObject9 != null) && (paramF != null) && (localObject5 != null) && (localObject6 != null))
          {
            if (paramI == localObject1) {
              j = h[paramInt2].b();
            }
            if (paramI == localConstraintWidget2) {
              i = h[i3].b();
            }
            if (n != 0) {
              i1 = 8;
            } else {
              i1 = 5;
            }
            paramClassWriter.a((SolverVariable)localObject9, paramF, j, 0.5F, (SolverVariable)localObject5, (SolverVariable)localObject6, i, i1);
          }
        }
        if (paramI.get() != 8) {
          localObject4 = paramI;
        }
        paramI = (i)localObject2;
        continue;
        i = 8;
        if ((m != 0) && (localObject1 != null))
        {
          j = j;
          if ((j > 0) && (g == j)) {
            j = 1;
          } else {
            j = 0;
          }
          paramI = (i)localObject1;
          localObject2 = localObject1;
          while (paramI != null)
          {
            for (paramF = bottom[paramInt1]; (paramF != null) && (paramF.get() == i); paramF = bottom[paramInt1]) {}
            if ((paramI != localObject1) && (paramI != localConstraintWidget2) && (paramF != null))
            {
              localObject3 = paramF;
              if (paramF == localConstraintWidget2) {
                localObject3 = null;
              }
              paramF = h[paramInt2];
              localObject8 = paramF.i;
              localObject4 = c;
              if (localObject4 != null) {
                localObject4 = i;
              }
              localObject4 = h;
              i2 = paramInt2 + 1;
              localObject9 = i;
              i1 = paramF.b();
              n = h[i2].b();
              i = n;
              if (localObject3 != null)
              {
                localObject4 = h[paramInt2];
                localObject5 = i;
                paramF = c;
                if (paramF != null) {
                  paramF = paramF.i;
                } else {
                  paramF = null;
                }
              }
              else
              {
                localObject6 = h[paramInt2];
                if (localObject6 != null) {
                  localObject4 = i;
                } else {
                  localObject4 = null;
                }
                paramF = h[i2].i;
                localObject5 = localObject4;
                localObject4 = localObject6;
              }
              if (localObject4 != null) {
                i = n + ((ConstraintAnchor)localObject4).b();
              }
              i2 = h[i2].b();
              if (j != 0) {
                n = 8;
              } else {
                n = 4;
              }
              if ((localObject8 != null) && (localObject9 != null) && (localObject5 != null) && (paramF != null)) {
                paramClassWriter.a((SolverVariable)localObject8, (SolverVariable)localObject9, i2 + i1, 0.5F, (SolverVariable)localObject5, paramF, i, n);
              }
              i = 8;
              paramF = (f)localObject3;
            }
            if (paramI.get() == i) {
              paramI = (i)localObject2;
            }
            localObject2 = paramI;
            paramI = paramF;
          }
          paramF = h[paramInt2];
          paramI = h[paramInt2].c;
          localObject2 = h;
          paramInt1 = paramInt2 + 1;
          localObject2 = localObject2[paramInt1];
          localObject3 = h[paramInt1].c;
          if (paramI != null) {
            if (localObject1 != localConstraintWidget2) {
              paramClassWriter.a(paramF.i, i, paramF.b(), 5);
            } else if (localObject3 != null) {
              paramClassWriter.a(paramF.i, i, paramF.b(), 0.5F, i, i, ((ConstraintAnchor)localObject2).b(), 5);
            }
          }
          if ((localObject3 != null) && (localObject1 != localConstraintWidget2)) {
            paramClassWriter.a(i, i, -((ConstraintAnchor)localObject2).b(), 5);
          }
        }
      }
    }
    if (((k != 0) || (m != 0)) && (localObject1 != null) && (localObject1 != localConstraintWidget2))
    {
      localObject4 = h;
      localObject3 = localObject4[paramInt2];
      paramF = h;
      paramInt1 = paramInt2 + 1;
      localObject2 = paramF[paramInt1];
      paramF = c;
      if (paramF != null) {
        paramI = paramF.i;
      } else {
        paramI = null;
      }
      paramF = c;
      if (paramF != null) {
        paramF = paramF.i;
      } else {
        paramF = null;
      }
      if (localConstraintWidget3 != localConstraintWidget2)
      {
        localObject5 = h[paramInt1].c;
        paramF = (f)localObject7;
        if (localObject5 != null) {
          paramF = i;
        }
      }
      if (localObject1 == localConstraintWidget2)
      {
        localObject3 = localObject4[paramInt2];
        localObject2 = localObject4[paramInt1];
      }
      if ((paramI != null) && (paramF != null))
      {
        paramInt2 = ((ConstraintAnchor)localObject3).b();
        paramInt1 = h[paramInt1].b();
        localObject1 = i;
        localObject2 = i;
        paramClassWriter.a((SolverVariable)localObject1, paramI, paramInt2, 0.5F, (SolverVariable)paramF, (SolverVariable)localObject2, paramInt1, 5);
      }
    }
  }
  
  public static void a(f paramF, ClassWriter paramClassWriter, ArrayList paramArrayList, int paramInt)
  {
    int k = 0;
    int i;
    i[] arrayOfI;
    int j;
    if (paramInt == 0)
    {
      i = l;
      arrayOfI = b;
      j = 0;
    }
    else
    {
      arrayOfI = m;
      j = 2;
      i = n;
    }
    while (k < i)
    {
      i localI = arrayOfI[k];
      localI.b();
      if ((paramArrayList == null) || (paramArrayList.contains(a))) {
        a(paramF, paramClassWriter, paramInt, j, localI);
      }
      k += 1;
    }
  }
}
