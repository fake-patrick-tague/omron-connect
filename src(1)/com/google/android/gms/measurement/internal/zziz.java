package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zziz
  implements Runnable
{
  zziz(zzjs paramZzjs, Item paramItem) {}
  
  public final void run()
  {
    Object localObject2 = this$0;
    Object localObject1 = zzjs.getInstance((zzjs)localObject2);
    if (localObject1 == null)
    {
      this$0.zzay().iterator().append("Discarding data. Failed to send app launch");
      return;
    }
    localObject2 = val$media;
    try
    {
      Preconditions.checkNotNull(localObject2);
      localObject2 = val$media;
      ((zzee)localObject1).insertItem((Item)localObject2);
      localObject2 = this$0.this$0;
      ((zzfy)localObject2).getValue().doInBackground();
      localObject2 = this$0;
      Item localItem = val$media;
      ((zzjs)localObject2).loadData((zzee)localObject1, null, localItem);
      localObject1 = this$0;
      zzjs.access$getCleanup((zzjs)localObject1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this$0.this$0.zzay().iterator().append("Failed to send app launch to the service", localRemoteException);
    }
  }
}
