package androidx.lifecycle;

import kotlin.x.d.i;

public final class SavedStateHandleAttacher
  implements LayoutManager
{
  private final g d;
  
  public SavedStateHandleAttacher(g paramG)
  {
    d = paramG;
  }
  
  public void b(d paramD, Lifecycle.Event paramEvent)
  {
    i.e(paramD, "source");
    i.e(paramEvent, "event");
    int i;
    if (paramEvent == Lifecycle.Event.ON_CREATE) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramD.getLifecycle().clear(this);
      d.b();
      return;
    }
    paramD = new StringBuilder();
    paramD.append("Next event must be ON_CREATE, it was ");
    paramD.append(paramEvent);
    throw new IllegalStateException(paramD.toString().toString());
  }
}
