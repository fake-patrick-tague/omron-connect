package androidx.lifecycle;

import androidx.savedstate.ClassWriter;

final class SavedStateHandleController
  implements LayoutManager
{
  private final String c;
  private boolean d = false;
  private final Item o;
  
  SavedStateHandleController(String paramString, Item paramItem)
  {
    c = paramString;
    o = paramItem;
  }
  
  Item a()
  {
    return o;
  }
  
  void a(ClassWriter paramClassWriter, Lifecycle paramLifecycle)
  {
    if (!d)
    {
      d = true;
      paramLifecycle.a(this);
      paramClassWriter.a(c, o.a());
      return;
    }
    throw new IllegalStateException("Already attached to lifecycleOwner");
  }
  
  public void b(d paramD, Lifecycle.Event paramEvent)
  {
    if (paramEvent == Lifecycle.Event.ON_DESTROY)
    {
      d = false;
      paramD.getLifecycle().clear(this);
    }
  }
  
  boolean b()
  {
    return d;
  }
}
