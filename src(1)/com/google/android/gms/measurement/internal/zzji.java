package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zzji
  implements Runnable
{
  zzji(zzjs paramZzjs, boolean paramBoolean1, Item paramItem, boolean paramBoolean2, zzac paramZzac1, zzac paramZzac2) {}
  
  public final void run()
  {
    Object localObject = this$0;
    zzee localZzee = zzjs.getInstance((zzjs)localObject);
    if (localZzee == null)
    {
      this$0.zzay().iterator().append("Discarding data. Failed to send conditional user property to service");
      return;
    }
    Preconditions.checkNotNull(val$finalPath);
    zzjs localZzjs = this$0;
    if (val$params) {
      localObject = null;
    } else {
      localObject = val$httpMethod;
    }
    localZzjs.loadData(localZzee, (AbstractSafeParcelable)localObject, val$finalPath);
    zzjs.access$getCleanup(this$0);
  }
}
