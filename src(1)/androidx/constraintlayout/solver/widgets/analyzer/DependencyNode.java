package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DependencyNode
  implements x
{
  public int a;
  List<DependencyNode> b = new ArrayList();
  int c;
  Type d = Type.minute;
  public boolean e = false;
  List<d> f = new ArrayList();
  public x g = null;
  public boolean i = false;
  int j = 1;
  Label k = null;
  public boolean p = false;
  WidgetRun u;
  
  public DependencyNode(WidgetRun paramWidgetRun)
  {
    u = paramWidgetRun;
  }
  
  public void a()
  {
    b.clear();
    f.clear();
    i = false;
    a = 0;
    e = false;
    p = false;
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
  
  public void a(x paramX)
  {
    paramX = b.iterator();
    while (paramX.hasNext()) {
      if (!nexti) {
        return;
      }
    }
    e = true;
    paramX = g;
    if (paramX != null) {
      paramX.a(this);
    }
    if (p)
    {
      u.a(this);
      return;
    }
    paramX = null;
    int m = 0;
    Iterator localIterator = b.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (DependencyNode)localIterator.next();
      if (!(localObject instanceof Label))
      {
        m += 1;
        paramX = (x)localObject;
      }
    }
    if ((paramX != null) && (m == 1) && (i))
    {
      localObject = k;
      if (localObject != null) {
        if (i) {
          c = (j * a);
        } else {
          return;
        }
      }
      a(a + c);
    }
    paramX = g;
    if (paramX != null) {
      paramX.a(this);
    }
  }
  
  public void b(x paramX)
  {
    f.add(paramX);
    if (i) {
      paramX.a(paramX);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(u.b.getString());
    localStringBuilder.append(":");
    localStringBuilder.append(d);
    localStringBuilder.append("(");
    Object localObject;
    if (i) {
      localObject = Integer.valueOf(a);
    } else {
      localObject = "unresolved";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(") <t=");
    localStringBuilder.append(b.size());
    localStringBuilder.append(":d=");
    localStringBuilder.append(f.size());
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
  
  static enum Type
  {
    static
    {
      Type localType1 = new Type("UNKNOWN", 0);
      minute = localType1;
      Type localType2 = new Type("HORIZONTAL_DIMENSION", 1);
      i = localType2;
      Type localType3 = new Type("VERTICAL_DIMENSION", 2);
      o = localType3;
      Type localType4 = new Type("LEFT", 3);
      d = localType4;
      Type localType5 = new Type("RIGHT", 4);
      b = localType5;
      Type localType6 = new Type("TOP", 5);
      p = localType6;
      Type localType7 = new Type("BOTTOM", 6);
      g = localType7;
      Type localType8 = new Type("BASELINE", 7);
      storage = localType8;
      e = new Type[] { localType1, localType2, localType3, localType4, localType5, localType6, localType7, localType8 };
    }
  }
}
