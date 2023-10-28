package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.work.Attribute;
import androidx.work.ByteVector;
import androidx.work.ListenableWorker;
import androidx.work.ListenableWorker.a;
import androidx.work.ListenableWorker.a.a;
import androidx.work.ListenableWorker.a.b;
import androidx.work.ListenableWorker.a.c;
import androidx.work.Pair;
import androidx.work.WorkInfo.State;
import androidx.work.WorkerParameters;
import androidx.work.WorkerParameters.a;
import androidx.work.impl.asm.h;
import androidx.work.impl.asm.n;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.TigerDigest;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.b;
import com.google.common.util.concurrent.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class i
  implements Runnable
{
  static final String a = androidx.work.Log.getInstance("WorkerWrapper");
  private String b;
  private String c;
  private androidx.work.f d;
  private List<e> e;
  private WorkerParameters.a f;
  android.content.Context g;
  ListenableWorker h;
  androidx.work.impl.utils.asm.f i;
  private androidx.work.impl.foreground.Item j;
  private volatile boolean k;
  h l;
  private WorkDatabase n;
  private androidx.work.impl.asm.Item p;
  private androidx.work.impl.asm.i r;
  c<ListenableWorker.a> t = null;
  b<Boolean> v = androidx.work.impl.utils.futures.Context.getInstance();
  ListenableWorker.a w = ListenableWorker.a.crossProduct();
  private List<String> x;
  private androidx.work.impl.asm.Object y;
  
  i(e paramE)
  {
    g = a;
    i = f;
    j = j;
    c = c;
    e = e;
    f = i;
    h = h;
    d = d;
    paramE = n;
    n = paramE;
    r = paramE.a();
    p = n.b();
    y = n.getValue();
  }
  
  private String a(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("Work [ id=");
    localStringBuilder.append(c);
    localStringBuilder.append(", tags={ ");
    paramList = paramList.iterator();
    int m = 1;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (m != 0) {
        m = 0;
      } else {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(str);
    }
    localStringBuilder.append(" } ]");
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (c()) {
      return;
    }
    n.add();
    try
    {
      java.lang.Object localObject1 = r.a(c);
      l = ((h)localObject1);
      if (localObject1 == null)
      {
        androidx.work.Log.get().get(a, String.format("Didn't find WorkSpec for id %s", new java.lang.Object[] { c }), new Throwable[0]);
        a(false);
        n.remove();
        n.clear();
        return;
      }
      java.lang.Object localObject2 = p;
      WorkInfo.State localState = WorkInfo.State.a;
      if (localObject2 != localState)
      {
        d();
        n.remove();
        androidx.work.Log.get().append(a, String.format("%s is not in ENQUEUED state. Nothing more to do.", new java.lang.Object[] { l.x }), new Throwable[0]);
        n.clear();
        return;
      }
      boolean bool = ((h)localObject1).j();
      if (!bool)
      {
        bool = l.c();
        if (!bool) {}
      }
      else
      {
        long l1 = System.currentTimeMillis();
        localObject1 = l;
        long l2 = w;
        int m;
        if (l2 == 0L) {
          m = 1;
        } else {
          m = 0;
        }
        if (m == 0)
        {
          l2 = ((h)localObject1).a();
          if (l1 < l2)
          {
            androidx.work.Log.get().append(a, String.format("Delaying execution for %s because it is being executed before schedule.", new java.lang.Object[] { l.x }), new Throwable[0]);
            a(true);
            n.remove();
            n.clear();
            return;
          }
        }
      }
      n.remove();
      n.clear();
      if (l.j()) {}
      for (localObject1 = l.c;; localObject1 = ((Attribute)localObject1).a((List)localObject2))
      {
        break;
        localObject1 = d.b().a(l.m);
        if (localObject1 == null)
        {
          androidx.work.Log.get().get(a, String.format("Could not create Input Merger %s", new java.lang.Object[] { l.m }), new Throwable[0]);
          clear();
          return;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).add(l.c);
        ((List)localObject2).addAll(r.getAll(c));
      }
      localObject2 = new WorkerParameters(UUID.fromString(c), (androidx.work.Label)localObject1, x, f, l.e, d.d(), i, d.p(), new TigerDigest(n, i), new androidx.work.impl.utils.Label(n, j, i));
      if (h == null) {
        h = d.p().create(g, l.x, (WorkerParameters)localObject2);
      }
      localObject1 = h;
      if (localObject1 == null)
      {
        androidx.work.Log.get().get(a, String.format("Could not create Worker %s", new java.lang.Object[] { l.x }), new Throwable[0]);
        clear();
        return;
      }
      if (((ListenableWorker)localObject1).post())
      {
        androidx.work.Log.get().get(a, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new java.lang.Object[] { l.x }), new Throwable[0]);
        clear();
        return;
      }
      h.put();
      if (l())
      {
        if (c()) {
          return;
        }
        localObject1 = androidx.work.impl.utils.futures.Context.getInstance();
        localObject2 = new androidx.work.impl.utils.i(g, l, h, ((WorkerParameters)localObject2).getInstance(), i);
        i.get().execute((Runnable)localObject2);
        localObject2 = ((androidx.work.impl.utils.i)localObject2).p();
        ((com.google.common.util.concurrent.Object)localObject2).addListener(new a(this, (com.google.common.util.concurrent.Object)localObject2, (androidx.work.impl.utils.futures.Context)localObject1), i.get());
        ((AbstractFuture)localObject1).addListener(new Plot.a(this, (androidx.work.impl.utils.futures.Context)localObject1, b), i.a());
        return;
      }
      d();
      return;
    }
    catch (Throwable localThrowable)
    {
      n.clear();
      throw localThrowable;
    }
  }
  
  private void a(ListenableWorker.a paramA)
  {
    if ((paramA instanceof ListenableWorker.a.c))
    {
      androidx.work.Log.get().a(a, String.format("Worker result SUCCESS for %s", new java.lang.Object[] { b }), new Throwable[0]);
      if (l.j())
      {
        add();
        return;
      }
      onDraw();
      return;
    }
    if ((paramA instanceof ListenableWorker.a.b))
    {
      androidx.work.Log.get().a(a, String.format("Worker result RETRY for %s", new java.lang.Object[] { b }), new Throwable[0]);
      close();
      return;
    }
    androidx.work.Log.get().a(a, String.format("Worker result FAILURE for %s", new java.lang.Object[] { b }), new Throwable[0]);
    if (l.j())
    {
      add();
      return;
    }
    clear();
  }
  
  private void a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    while (!localLinkedList.isEmpty())
    {
      paramString = (String)localLinkedList.remove();
      if (r.get(paramString) != WorkInfo.State.c) {
        r.a(WorkInfo.State.d, new String[] { paramString });
      }
      localLinkedList.addAll(p.a(paramString));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    java.lang.Object localObject = n;
    i localI = this;
    ((RoomDatabase)localObject).add();
    try
    {
      localObject = n;
      boolean bool = ((WorkDatabase)localObject).a().b();
      if (!bool) {
        androidx.work.impl.utils.Context.get(g, RescheduleReceiver.class, false);
      }
      if (paramBoolean)
      {
        r.a(WorkInfo.State.a, new String[] { c });
        r.add(c, -1L);
      }
      localObject = l;
      if (localObject != null)
      {
        localObject = h;
        if (localObject != null)
        {
          bool = ((ListenableWorker)localObject).a();
          if (bool) {
            j.clear(c);
          }
        }
      }
      localObject = n;
      ((RoomDatabase)localObject).remove();
      n.clear();
      v.get(Boolean.valueOf(paramBoolean));
      return;
    }
    catch (Throwable localThrowable)
    {
      n.clear();
      throw localThrowable;
    }
  }
  
  private void add()
  {
    n.add();
    try
    {
      r.a(c, System.currentTimeMillis());
      r.a(WorkInfo.State.a, new String[] { c });
      r.clear(c);
      r.add(c, -1L);
      n.remove();
      n.clear();
      a(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      n.clear();
      a(false);
      throw localThrowable;
    }
  }
  
  private boolean c()
  {
    if (k)
    {
      androidx.work.Log.get().append(a, String.format("Work interrupted for %s", new java.lang.Object[] { b }), new Throwable[0]);
      WorkInfo.State localState = r.get(c);
      if (localState == null)
      {
        a(false);
        return true;
      }
      a(localState.next() ^ true);
      return true;
    }
    return false;
  }
  
  private void close()
  {
    n.add();
    try
    {
      r.a(WorkInfo.State.a, new String[] { c });
      r.a(c, System.currentTimeMillis());
      r.add(c, -1L);
      n.remove();
      n.clear();
      a(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      n.clear();
      a(true);
      throw localThrowable;
    }
  }
  
  private void d()
  {
    WorkInfo.State localState = r.get(c);
    if (localState == WorkInfo.State.b)
    {
      androidx.work.Log.get().append(a, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new java.lang.Object[] { c }), new Throwable[0]);
      a(true);
      return;
    }
    androidx.work.Log.get().append(a, String.format("Status for %s is %s; not doing any work", new java.lang.Object[] { c, localState }), new Throwable[0]);
    a(false);
  }
  
  private boolean l()
  {
    n.add();
    try
    {
      WorkInfo.State localState1 = r.get(c);
      WorkInfo.State localState2 = WorkInfo.State.a;
      boolean bool = true;
      if (localState1 == localState2)
      {
        r.a(WorkInfo.State.b, new String[] { c });
        r.add(c);
      }
      else
      {
        bool = false;
      }
      n.remove();
      n.clear();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      n.clear();
      throw localThrowable;
    }
  }
  
  private void onDraw()
  {
    n.add();
    try
    {
      r.a(WorkInfo.State.i, new String[] { c });
      java.lang.Object localObject = ((ListenableWorker.a.c)w).a();
      r.a(c, (androidx.work.Label)localObject);
      long l1 = System.currentTimeMillis();
      localObject = p.a(c).iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject).hasNext();
        if (!bool) {
          break;
        }
        String str = (String)((Iterator)localObject).next();
        WorkInfo.State localState1 = r.get(str);
        WorkInfo.State localState2 = WorkInfo.State.p;
        if (localState1 == localState2)
        {
          bool = p.save(str);
          if (bool)
          {
            androidx.work.Log.get().a(a, String.format("Setting status to enqueued for %s", new java.lang.Object[] { str }), new Throwable[0]);
            r.a(WorkInfo.State.a, new String[] { str });
            r.a(str, l1);
          }
        }
      }
      n.remove();
      n.clear();
      a(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      n.clear();
      a(false);
      throw localThrowable;
    }
  }
  
  void b()
  {
    if (!c())
    {
      n.add();
      try
      {
        WorkInfo.State localState1 = r.get(c);
        n.c().a(c);
        if (localState1 == null)
        {
          a(false);
        }
        else
        {
          WorkInfo.State localState2 = WorkInfo.State.b;
          if (localState1 == localState2)
          {
            a(w);
          }
          else
          {
            boolean bool = localState1.next();
            if (!bool) {
              close();
            }
          }
        }
        n.remove();
        n.clear();
      }
      catch (Throwable localThrowable)
      {
        n.clear();
        throw localThrowable;
      }
    }
    java.lang.Object localObject = e;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((l)((Iterator)localObject).next()).a(c);
      }
      Log.a(d, n, e);
    }
  }
  
  void clear()
  {
    n.add();
    try
    {
      a(c);
      androidx.work.Label localLabel = ((ListenableWorker.a.a)w).a();
      r.a(c, localLabel);
      n.remove();
      n.clear();
      a(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      n.clear();
      a(false);
      throw localThrowable;
    }
  }
  
  public void e()
  {
    k = true;
    c();
    java.lang.Object localObject = t;
    boolean bool;
    if (localObject != null)
    {
      bool = ((Future)localObject).isDone();
      t.cancel(true);
    }
    else
    {
      bool = false;
    }
    localObject = h;
    if ((localObject != null) && (!bool))
    {
      ((ListenableWorker)localObject).onPostInit();
      return;
    }
    localObject = String.format("WorkSpec %s is already done. Not interrupting.", new java.lang.Object[] { l });
    androidx.work.Log.get().append(a, (String)localObject, new Throwable[0]);
  }
  
  public com.google.common.util.concurrent.Object f()
  {
    return v;
  }
  
  public void run()
  {
    List localList = y.get(c);
    x = localList;
    b = a(localList);
    a();
  }
}
