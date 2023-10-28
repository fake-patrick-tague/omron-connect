package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class zzed
  implements Application.ActivityLifecycleCallbacks
{
  zzed(zzee paramZzee) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    zzee.d(this$0, new zzdw(this, paramBundle, paramActivity));
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    zzee.d(this$0, new zzec(this, paramActivity));
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    zzee.d(this$0, new zzdz(this, paramActivity));
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    zzee.d(this$0, new zzdy(this, paramActivity));
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    zzbz localZzbz = new zzbz();
    zzee.d(this$0, new zzeb(this, paramActivity, localZzbz));
    paramActivity = localZzbz.get(50L);
    if (paramActivity != null) {
      paramBundle.putAll(paramActivity);
    }
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    zzee.d(this$0, new zzdx(this, paramActivity));
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    zzee.d(this$0, new zzea(this, paramActivity));
  }
}
