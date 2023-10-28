package androidx.lifecycle;

import java.util.List;
import java.util.Map;

@Deprecated
class ByteVector
{
  final Map<c.b, Lifecycle.Event> a;
  final Map<Lifecycle.Event, List<c.b>> b;
  
  ByteVector(Map paramMap) {}
  
  private static void a(List paramList, d paramD, Lifecycle.Event paramEvent, Object paramObject)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ((Handle)paramList.get(i)).toString(paramD, paramEvent, paramObject);
        i -= 1;
      }
    }
  }
  
  void a(d paramD, Lifecycle.Event paramEvent, Object paramObject)
  {
    a((List)b.get(paramEvent), paramD, paramEvent, paramObject);
    a((List)b.get(Lifecycle.Event.ON_ANY), paramD, paramEvent, paramObject);
  }
}
