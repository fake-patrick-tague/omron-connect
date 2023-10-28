package androidx.lifecycle;

class e
{
  Lifecycle.State a;
  LayoutManager j;
  
  e(MenuItem paramMenuItem, Lifecycle.State paramState)
  {
    j = Frame.a(paramMenuItem);
    a = paramState;
  }
  
  void b(d paramD, Lifecycle.Event paramEvent)
  {
    Lifecycle.State localState = paramEvent.a();
    a = f.a(a, localState);
    j.b(paramD, paramEvent);
    a = localState;
  }
}
