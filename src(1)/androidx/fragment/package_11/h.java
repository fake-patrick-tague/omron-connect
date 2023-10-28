package androidx.fragment.package_11;

class h
{
  private final v7.v7.menu.h a;
  private final SpecialEffectsController.Operation b;
  
  h(SpecialEffectsController.Operation paramOperation, v7.v7.menu.h paramH)
  {
    b = paramOperation;
    a = paramH;
  }
  
  SpecialEffectsController.Operation a()
  {
    return b;
  }
  
  v7.v7.menu.h c()
  {
    return a;
  }
  
  void e()
  {
    b.b(a);
  }
  
  boolean f()
  {
    SpecialEffectsController.Operation.State localState1 = SpecialEffectsController.Operation.State.a(b.next().mView);
    SpecialEffectsController.Operation.State localState2 = b.get();
    if (localState1 != localState2)
    {
      SpecialEffectsController.Operation.State localState3 = SpecialEffectsController.Operation.State.b;
      if ((localState1 == localState3) || (localState2 == localState3)) {
        return false;
      }
    }
    return true;
  }
}
