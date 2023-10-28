package com.google.android.gms.dynamic;

import android.os.Bundle;

final class Fragment
  implements Object
{
  Fragment(DeferredLifecycleHelper paramDeferredLifecycleHelper, Bundle paramBundle) {}
  
  public final void onCreateView(LifecycleDelegate paramLifecycleDelegate)
  {
    DeferredLifecycleHelper.instantiate(mHost).onCreate(mSavedFragmentState);
  }
  
  public final int type()
  {
    return 1;
  }
}
