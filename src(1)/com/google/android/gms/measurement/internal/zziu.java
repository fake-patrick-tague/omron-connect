package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zziu
  implements Runnable
{
  zziu(zzjs paramZzjs, Item paramItem, boolean paramBoolean, zzlc paramZzlc) {}
  
  public final void run()
  {
    Object localObject = this$0;
    zzee localZzee = zzjs.getInstance((zzjs)localObject);
    if (localZzee == null)
    {
      this$0.zzay().iterator().append("Discarding data. Failed to set user property");
      return;
    }
    Preconditions.checkNotNull(val$controller);
    zzjs localZzjs = this$0;
    if (val$error) {
      localObject = null;
    } else {
      localObject = val$response;
    }
    localZzjs.loadData(localZzee, (AbstractSafeParcelable)localObject, val$controller);
    zzjs.access$getCleanup(this$0);
  }
}
