package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ClassWriter;

public class Frame
{
  static boolean[] d = new boolean[3];
  
  static void a(f paramF, ClassWriter paramClassWriter, ConstraintWidget paramConstraintWidget)
  {
    state = -1;
    end = -1;
    Object localObject = u[0];
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.c;
    int i;
    int j;
    if ((localObject != localDimensionBehaviour) && (u[0] == ConstraintWidget.DimensionBehaviour.g))
    {
      i = a.a;
      j = paramF.getValue() - l.a;
      localObject = a;
      i = paramClassWriter.a(localObject);
      localObject = l;
      i = paramClassWriter.a(localObject);
      paramClassWriter.a(a.i, i);
      paramClassWriter.a(l.i, j);
      state = 2;
      paramConstraintWidget.put(i, j);
    }
    if ((u[1] != localDimensionBehaviour) && (u[1] == ConstraintWidget.DimensionBehaviour.g))
    {
      i = c.a;
      j = paramF.length() - b.a;
      paramF = c;
      paramF.i = paramClassWriter.a(paramF);
      paramF = b;
      paramF.i = paramClassWriter.a(paramF);
      paramClassWriter.a(c.i, i);
      paramClassWriter.a(b.i, j);
      if ((key > 0) || (paramConstraintWidget.get() == 8))
      {
        paramF = t;
        paramF.i = paramClassWriter.a(paramF);
        paramClassWriter.a(t.i, key + i);
      }
      end = 2;
      paramConstraintWidget.remove(i, j);
    }
  }
  
  public static final boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}
