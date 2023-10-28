package androidx.recyclerview.widget;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class ClassWriter<T>
{
  private static final Executor THREAD_POOL_EXECUTOR = new ActivityChooserModel.SerialExecutor();
  private List<T> a = Collections.emptyList();
  private final a b;
  Executor c;
  final c<T> d;
  private List<T> f;
  int i;
  private final List<d.b<T>> q = new CopyOnWriteArrayList();
  
  public ClassWriter(a paramA, Trip paramTrip)
  {
    b = paramA;
    d = paramTrip;
    if (paramTrip.getConstructor() != null)
    {
      c = paramTrip.getConstructor();
      return;
    }
    c = THREAD_POOL_EXECUTOR;
  }
  
  private void a(List paramList, Runnable paramRunnable)
  {
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).a(paramList, a);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public void a(o paramO)
  {
    q.add(paramO);
  }
  
  public void a(List paramList)
  {
    b(paramList, null);
  }
  
  void a(List paramList, d paramD, Runnable paramRunnable)
  {
    List localList = a;
    f = paramList;
    a = Collections.unmodifiableList(paramList);
    paramD.a(b);
    a(localList, paramRunnable);
  }
  
  public void b(List paramList, Runnable paramRunnable)
  {
    int j = i + 1;
    i = j;
    List localList1 = f;
    if (paramList == localList1)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
    }
    else
    {
      List localList2 = a;
      if (paramList == null)
      {
        j = localList1.size();
        f = null;
        a = Collections.emptyList();
        b.b(0, j);
        a(localList2, paramRunnable);
        return;
      }
      if (localList1 == null)
      {
        f = paramList;
        a = Collections.unmodifiableList(paramList);
        b.a(0, paramList.size());
        a(localList2, paramRunnable);
        return;
      }
      d.getColorArray().execute(new LayoutManager(this, localList1, paramList, j, paramRunnable));
    }
  }
  
  public List get()
  {
    return a;
  }
}
