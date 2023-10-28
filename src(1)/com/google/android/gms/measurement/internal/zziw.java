package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zziw
  implements Runnable
{
  zziw(zzjs paramZzjs, Item paramItem) {}
  
  public final void run()
  {
    Object localObject = this$0;
    zzee localZzee = zzjs.getInstance((zzjs)localObject);
    if (localZzee == null)
    {
      this$0.zzay().iterator().append("Failed to reset data on the service: not connected to service");
      return;
    }
    localObject = val$item;
    try
    {
      Preconditions.checkNotNull(localObject);
      localObject = val$item;
      localZzee.put((Item)localObject);
    }
    catch (RemoteException localRemoteException)
    {
      this$0.this$0.zzay().iterator().append("Failed to reset data on the service: remote exception", localRemoteException);
    }
    zzjs.access$getCleanup(this$0);
  }
}
