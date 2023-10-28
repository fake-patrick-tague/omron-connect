package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzjf
  implements Runnable
{
  zzjf(zzjs paramZzjs, Item paramItem) {}
  
  public final void run()
  {
    Object localObject2 = this$0;
    Object localObject1 = zzjs.getInstance((zzjs)localObject2);
    if (localObject1 == null)
    {
      this$0.zzay().iterator().append("Failed to send measurementEnabled to service");
      return;
    }
    localObject2 = val$item;
    try
    {
      Preconditions.checkNotNull(localObject2);
      localObject2 = val$item;
      ((zzee)localObject1).add((Item)localObject2);
      localObject1 = this$0;
      zzjs.access$getCleanup((zzjs)localObject1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this$0.this$0.zzay().iterator().append("Failed to send measurementEnabled to the service", localRemoteException);
    }
  }
}
