package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.ClassWriter;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Item;
import androidx.constraintlayout.solver.widgets.f;
import java.util.ArrayList;
import java.util.Iterator;

public class i
{
  static int a;
  int b = -1;
  ArrayList<ConstraintWidget> c = new ArrayList();
  int e = 0;
  boolean f = false;
  ArrayList<n.a> j = null;
  private int k = -1;
  
  public i(int paramInt)
  {
    int i = a;
    a = i + 1;
    b = i;
    e = paramInt;
  }
  
  private int a(ClassWriter paramClassWriter, ArrayList paramArrayList, int paramInt)
  {
    int m = 0;
    f localF = (f)((ConstraintWidget)paramArrayList.get(0)).listFiles();
    paramClassWriter.a();
    localF.a(paramClassWriter, false);
    int i = 0;
    while (i < paramArrayList.size())
    {
      ((ConstraintWidget)paramArrayList.get(i)).a(paramClassWriter, false);
      i += 1;
    }
    if ((paramInt == 0) && (l > 0)) {
      Item.a(localF, paramClassWriter, paramArrayList, 0);
    }
    if ((paramInt == 1) && (n > 0)) {
      Item.a(localF, paramClassWriter, paramArrayList, 1);
    }
    try
    {
      paramClassWriter.f();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    j = new ArrayList();
    i = m;
    while (i < paramArrayList.size())
    {
      a localA = new a(this, (ConstraintWidget)paramArrayList.get(i), paramClassWriter, paramInt);
      j.add(localA);
      i += 1;
    }
    if (paramInt == 0)
    {
      i = paramClassWriter.set(a);
      paramInt = paramClassWriter.set(l);
      paramClassWriter.a();
    }
    for (;;)
    {
      return paramInt - i;
      i = paramClassWriter.set(c);
      paramInt = paramClassWriter.set(b);
      paramClassWriter.a();
    }
  }
  
  private String getItem()
  {
    int i = e;
    if (i == 0) {
      return "Horizontal";
    }
    if (i == 1) {
      return "Vertical";
    }
    if (i == 2) {
      return "Both";
    }
    return "Unknown";
  }
  
  public int a()
  {
    return b;
  }
  
  public void a(int paramInt)
  {
    e = paramInt;
  }
  
  public void a(int paramInt, i paramI)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
      paramI.a(localConstraintWidget);
      if (paramInt == 0) {
        E = paramI.a();
      } else {
        f = paramI.a();
      }
    }
    k = b;
  }
  
  public void a(ArrayList paramArrayList)
  {
    int m = c.size();
    if ((k != -1) && (m > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        i localI = (i)paramArrayList.get(i);
        if (k == b) {
          a(e, localI);
        }
        i += 1;
      }
    }
    if (m == 0) {
      paramArrayList.remove(this);
    }
  }
  
  public boolean a(ConstraintWidget paramConstraintWidget)
  {
    if (c.contains(paramConstraintWidget)) {
      return false;
    }
    c.add(paramConstraintWidget);
    return true;
  }
  
  public int b()
  {
    return e;
  }
  
  public int b(ClassWriter paramClassWriter, int paramInt)
  {
    if (c.size() == 0) {
      return 0;
    }
    return a(paramClassWriter, c, paramInt);
  }
  
  public void e(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getItem());
    ((StringBuilder)localObject1).append(" [");
    ((StringBuilder)localObject1).append(b);
    ((StringBuilder)localObject1).append("] <");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = c.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" ");
      localStringBuilder.append(localConstraintWidget.getString());
      localObject1 = localStringBuilder.toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" >");
    return ((StringBuilder)localObject2).toString();
  }
}
