package androidx.lifecycle;

class SingleGeneratedAdapterObserver
  implements LayoutManager
{
  private final Attribute j;
  
  SingleGeneratedAdapterObserver(Attribute paramAttribute)
  {
    j = paramAttribute;
  }
  
  public void b(d paramD, Lifecycle.Event paramEvent)
  {
    j.a(paramD, paramEvent, false, null);
    j.a(paramD, paramEvent, true, null);
  }
}
