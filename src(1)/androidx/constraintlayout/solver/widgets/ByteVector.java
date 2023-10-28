package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Item;
import java.util.ArrayList;

public class ByteVector
  extends ConstraintWidget
{
  public ArrayList<ConstraintWidget> a = new ArrayList();
  
  public ByteVector() {}
  
  public void a()
  {
    Object localObject = a;
    if (localObject == null) {
      return;
    }
    int j = ((ArrayList)localObject).size();
    int i = 0;
    while (i < j)
    {
      localObject = (ConstraintWidget)a.get(i);
      if ((localObject instanceof ByteVector)) {
        ((ByteVector)localObject).a();
      }
      i += 1;
    }
  }
  
  public void a(ConstraintWidget paramConstraintWidget)
  {
    a.add(paramConstraintWidget);
    if (paramConstraintWidget.listFiles() != null) {
      ((ByteVector)paramConstraintWidget.listFiles()).add(paramConstraintWidget);
    }
    paramConstraintWidget.visitField(this);
  }
  
  public void add()
  {
    a.clear();
    super.add();
  }
  
  public void add(ConstraintWidget paramConstraintWidget)
  {
    a.remove(paramConstraintWidget);
    paramConstraintWidget.add();
  }
  
  public void b(Item paramItem)
  {
    super.b(paramItem);
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)a.get(i)).b(paramItem);
      i += 1;
    }
  }
  
  public void putInt()
  {
    a.clear();
  }
  
  public ArrayList read()
  {
    return a;
  }
}
