package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.SignatureReader;
import androidx.constraintlayout.solver.widgets.analyzer.i;
import java.util.ArrayList;
import java.util.Arrays;

public class Label
  extends ConstraintWidget
  implements AnnotationWriter
{
  public ConstraintWidget[] b = new ConstraintWidget[4];
  public int e = 0;
  
  public Label() {}
  
  public int a(int paramInt)
  {
    int i = 0;
    while (i < e)
    {
      ConstraintWidget localConstraintWidget = b[i];
      int j;
      if (paramInt == 0)
      {
        j = E;
        if (j != -1) {
          return j;
        }
      }
      if (paramInt == 1)
      {
        j = f;
        if (j != -1) {
          return j;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public void a(ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget != this)
    {
      if (paramConstraintWidget == null) {
        return;
      }
      int i = e;
      ConstraintWidget[] arrayOfConstraintWidget = b;
      if (i + 1 > arrayOfConstraintWidget.length) {
        b = ((ConstraintWidget[])Arrays.copyOf(arrayOfConstraintWidget, arrayOfConstraintWidget.length * 2));
      }
      arrayOfConstraintWidget = b;
      i = e;
      arrayOfConstraintWidget[i] = paramConstraintWidget;
      e = (i + 1);
    }
  }
  
  public void a(f paramF) {}
  
  public void a(ArrayList paramArrayList, int paramInt, i paramI)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= e) {
        break;
      }
      paramI.a(b[i]);
      i += 1;
    }
    while (j < e)
    {
      SignatureReader.a(b[j], paramInt, paramArrayList, paramI);
      j += 1;
    }
  }
  
  public void put()
  {
    e = 0;
    Arrays.fill(b, null);
  }
}
