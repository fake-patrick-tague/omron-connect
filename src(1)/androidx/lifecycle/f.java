package androidx.lifecycle;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class f
  extends Lifecycle
{
  private Lifecycle.State a;
  private c.b.a.b.a<l, n.a> b = new v7.support.v7.asm.a();
  private boolean c = false;
  private int d = 0;
  private final boolean f;
  private boolean i = false;
  private ArrayList<Lifecycle.State> m = new ArrayList();
  private final WeakReference<m> w;
  
  public f(d paramD)
  {
    this(paramD, true);
  }
  
  private f(d paramD, boolean paramBoolean)
  {
    w = new WeakReference(paramD);
    a = Lifecycle.State.i;
    f = paramBoolean;
  }
  
  static Lifecycle.State a(Lifecycle.State paramState1, Lifecycle.State paramState2)
  {
    if ((paramState2 != null) && (paramState2.compareTo(paramState1) < 0)) {
      return paramState2;
    }
    return paramState1;
  }
  
  private void a()
  {
    d localD = (d)w.get();
    if (localD != null)
    {
      while (!b())
      {
        i = false;
        if (a.compareTo(b.m().getValue()).a) < 0) {
          a(localD);
        }
        Map.Entry localEntry = b.g();
        if ((!i) && (localEntry != null) && (a.compareTo(getValuea) > 0)) {
          b(localD);
        }
      }
      i = false;
      return;
    }
    throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
  }
  
  private void a(d paramD)
  {
    Iterator localIterator = b.descendingIterator();
    while ((localIterator.hasNext()) && (!i))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      e localE = (e)localEntry.getValue();
      while ((a.compareTo(a) > 0) && (!i) && (b.contains((MenuItem)localEntry.getKey())))
      {
        Lifecycle.Event localEvent = Lifecycle.Event.b(a);
        if (localEvent == null) {
          break label124;
        }
        b(localEvent.a());
        localE.b(paramD, localEvent);
        d();
      }
      continue;
      label124:
      paramD = new StringBuilder();
      paramD.append("no event down from ");
      paramD.append(a);
      throw new IllegalStateException(paramD.toString());
    }
  }
  
  private void a(String paramString)
  {
    if (f)
    {
      if (v7.support.v7.util.f.a().close()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Method ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" must be called on the main thread");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  private Lifecycle.State b(MenuItem paramMenuItem)
  {
    paramMenuItem = b.getValue(paramMenuItem);
    Object localObject = null;
    if (paramMenuItem != null) {
      paramMenuItem = getValuea;
    } else {
      paramMenuItem = null;
    }
    if (!m.isEmpty())
    {
      localObject = m;
      localObject = (Lifecycle.State)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return a(a(a, paramMenuItem), (Lifecycle.State)localObject);
  }
  
  private void b(Lifecycle.State paramState)
  {
    m.add(paramState);
  }
  
  private void b(d paramD)
  {
    v7.support.v7.asm.d localD = b.a();
    while ((localD.hasNext()) && (!i))
    {
      Map.Entry localEntry = (Map.Entry)localD.next();
      e localE = (e)localEntry.getValue();
      while ((a.compareTo(a) < 0) && (!i) && (b.contains((MenuItem)localEntry.getKey())))
      {
        b(a);
        Lifecycle.Event localEvent = Lifecycle.Event.a(a);
        if (localEvent == null) {
          break label123;
        }
        localE.b(paramD, localEvent);
        d();
      }
      continue;
      label123:
      paramD = new StringBuilder();
      paramD.append("no event up from ");
      paramD.append(a);
      throw new IllegalStateException(paramD.toString());
    }
  }
  
  private boolean b()
  {
    if (b.size() == 0) {
      return true;
    }
    Lifecycle.State localState1 = b.m().getValue()).a;
    Lifecycle.State localState2 = b.g().getValue()).a;
    return (localState1 == localState2) && (a == localState2);
  }
  
  private void d()
  {
    ArrayList localArrayList = m;
    localArrayList.remove(localArrayList.size() - 1);
  }
  
  private void d(Lifecycle.State paramState)
  {
    Lifecycle.State localState = a;
    if (localState == paramState) {
      return;
    }
    if ((localState == Lifecycle.State.i) && (paramState == Lifecycle.State.c))
    {
      paramState = new StringBuilder();
      paramState.append("no event down from ");
      paramState.append(a);
      throw new IllegalStateException(paramState.toString());
    }
    a = paramState;
    if ((!c) && (d == 0))
    {
      c = true;
      a();
      c = false;
      if (a == Lifecycle.State.c) {
        b = new v7.support.v7.asm.a();
      }
    }
    else
    {
      i = true;
    }
  }
  
  public void a(Lifecycle.State paramState)
  {
    a("markState");
    c(paramState);
  }
  
  public void a(MenuItem paramMenuItem)
  {
    a("addObserver");
    Object localObject2 = a;
    Object localObject1 = Lifecycle.State.c;
    if (localObject2 != localObject1) {
      localObject1 = Lifecycle.State.i;
    }
    localObject2 = new e(paramMenuItem, (Lifecycle.State)localObject1);
    if ((e)b.b(paramMenuItem, localObject2) != null) {
      return;
    }
    d localD = (d)w.get();
    if (localD == null) {
      return;
    }
    int j;
    if ((d == 0) && (!c)) {
      j = 0;
    } else {
      j = 1;
    }
    localObject1 = b(paramMenuItem);
    d += 1;
    while ((a.compareTo((Enum)localObject1) < 0) && (b.contains(paramMenuItem)))
    {
      b(a);
      localObject1 = Lifecycle.Event.a(a);
      if (localObject1 != null)
      {
        ((e)localObject2).b(localD, (Lifecycle.Event)localObject1);
        d();
        localObject1 = b(paramMenuItem);
      }
      else
      {
        paramMenuItem = new StringBuilder();
        paramMenuItem.append("no event up from ");
        paramMenuItem.append(a);
        throw new IllegalStateException(paramMenuItem.toString());
      }
    }
    if (j == 0) {
      a();
    }
    d -= 1;
  }
  
  public void append(Lifecycle.Event paramEvent)
  {
    a("handleLifecycleEvent");
    d(paramEvent.a());
  }
  
  public Lifecycle.State c()
  {
    return a;
  }
  
  public void c(Lifecycle.State paramState)
  {
    a("setCurrentState");
    d(paramState);
  }
  
  public void clear(MenuItem paramMenuItem)
  {
    a("removeObserver");
    b.a(paramMenuItem);
  }
}
