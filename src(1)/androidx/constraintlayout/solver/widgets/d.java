package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.ClassWriter;
import androidx.constraintlayout.solver.widgets.analyzer.Item;

public class d
  extends Label
{
  private boolean J = false;
  private int K = 0;
  private int L = 0;
  private int M = 0;
  protected ClassWriter a = new ClassWriter();
  private int b = 0;
  private int e = 0;
  private int f = 0;
  Item j = null;
  private int k = 0;
  private int m = 0;
  private int n = 0;
  private int s = 0;
  
  public d() {}
  
  public void a(f paramF)
  {
    b();
  }
  
  public void b()
  {
    int i = 0;
    while (i < e)
    {
      ConstraintWidget localConstraintWidget = b[i];
      if (localConstraintWidget != null) {
        localConstraintWidget.f(true);
      }
      i += 1;
    }
  }
  
  public boolean k()
  {
    return J;
  }
}
