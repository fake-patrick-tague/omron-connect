package androidx.lifecycle;

@Deprecated
class ReflectiveGenericLifecycleObserver
  implements LayoutManager
{
  private final ByteVector d;
  private final Object o;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    o = paramObject;
    d = c.d.b(paramObject.getClass());
  }
  
  public void b(d paramD, Lifecycle.Event paramEvent)
  {
    d.a(paramD, paramEvent, o);
  }
}
