package com.google.android.gms.dynamic;

final class FragmentManagerImpl
  implements Object
{
  FragmentManagerImpl(DeferredLifecycleHelper paramDeferredLifecycleHelper) {}
  
  public final void onCreateView(LifecycleDelegate paramLifecycleDelegate)
  {
    DeferredLifecycleHelper.instantiate(mHost).onStart();
  }
  
  public final int type()
  {
    return 4;
  }
}
