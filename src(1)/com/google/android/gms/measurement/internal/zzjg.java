package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzjg
  implements Runnable
{
  zzjg(zzjs paramZzjs, Item paramItem) {}
  
  public final void run()
  {
    Object localObject2 = this$0;
    Object localObject1 = zzjs.getInstance((zzjs)localObject2);
    if (localObject1 == null)
    {
      this$0.zzay().iterator().append("Failed to send consent settings to service");
      return;
    }
    localObject2 = connection;
    try
    {
      Preconditions.checkNotNull(localObject2);
      localObject2 = connection;
      ((zzee)localObject1).execute((Item)localObject2);
      localObject1 = this$0;
      zzjs.access$getCleanup((zzjs)localObject1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this$0.this$0.zzay().iterator().append("Failed to send consent settings to the service", localRemoteException);
    }
  }
}
