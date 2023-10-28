package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.Iterator;
import java.util.List;

class Label
  extends DependencyNode
{
  public int a;
  
  public Label(WidgetRun paramWidgetRun)
  {
    super(paramWidgetRun);
    if ((paramWidgetRun instanceof f))
    {
      d = DependencyNode.Type.i;
      return;
    }
    d = DependencyNode.Type.o;
  }
  
  public void a(int paramInt)
  {
    if (i) {
      return;
    }
    i = true;
    a = paramInt;
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext())
    {
      x localX = (x)localIterator.next();
      localX.a(localX);
    }
  }
}
