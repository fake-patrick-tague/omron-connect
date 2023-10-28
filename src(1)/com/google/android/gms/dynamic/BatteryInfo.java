package com.google.android.gms.dynamic;

final class BatteryInfo
  implements Object
{
  BatteryInfo(DeferredLifecycleHelper paramDeferredLifecycleHelper) {}
  
  public final void onCreateView(LifecycleDelegate paramLifecycleDelegate)
  {
    DeferredLifecycleHelper.instantiate(context).onResume();
  }
  
  public final int type()
  {
    return 5;
  }
}
