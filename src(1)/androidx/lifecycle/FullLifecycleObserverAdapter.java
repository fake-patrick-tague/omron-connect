package androidx.lifecycle;

class FullLifecycleObserverAdapter
  implements LayoutManager
{
  private final m a;
  private final LayoutManager j;
  
  FullLifecycleObserverAdapter(m paramM, LayoutManager paramLayoutManager)
  {
    a = paramM;
    j = paramLayoutManager;
  }
  
  public void b(d paramD, Lifecycle.Event paramEvent)
  {
    switch (a.o[paramEvent.ordinal()])
    {
    default: 
      break;
    case 7: 
      throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    case 6: 
      a.g(paramD);
      break;
    case 5: 
      a.a(paramD);
      break;
    case 4: 
      a.d(paramD);
      break;
    case 3: 
      a.b(paramD);
      break;
    case 2: 
      a.f(paramD);
      break;
    case 1: 
      a.e(paramD);
    }
    LayoutManager localLayoutManager = j;
    if (localLayoutManager != null) {
      localLayoutManager.b(paramD, paramEvent);
    }
  }
}
