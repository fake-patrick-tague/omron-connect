package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.ClassWriter;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;

class a
{
  int c;
  int d;
  int j;
  WeakReference<ConstraintWidget> l;
  int n;
  int r;
  int s;
  
  public a(i paramI, ConstraintWidget paramConstraintWidget, ClassWriter paramClassWriter, int paramInt)
  {
    l = new WeakReference(paramConstraintWidget);
    j = paramClassWriter.set(a);
    c = paramClassWriter.set(c);
    d = paramClassWriter.set(l);
    r = paramClassWriter.set(b);
    s = paramClassWriter.set(t);
    n = paramInt;
  }
}
