package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

final class Preference
  implements Object
{
  Preference(DeferredLifecycleHelper paramDeferredLifecycleHelper, Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public final void onCreateView(LifecycleDelegate paramLifecycleDelegate)
  {
    DeferredLifecycleHelper.instantiate(mContext).onInflate(mActivity, mSavedFragmentState, mFromLayout);
  }
  
  public final int type()
  {
    return 0;
  }
}
