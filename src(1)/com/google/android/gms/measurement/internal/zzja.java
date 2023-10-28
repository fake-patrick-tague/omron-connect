package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.RemoteException;

final class zzja
  implements Runnable
{
  zzja(zzjs paramZzjs, zzik paramZzik) {}
  
  public final void run()
  {
    Object localObject3 = this$0;
    Object localObject1 = zzjs.getInstance((zzjs)localObject3);
    if (localObject1 == null)
    {
      this$0.zzay().iterator().append("Failed to send current screen to service");
      return;
    }
    Object localObject4 = val$mPath;
    Object localObject2;
    if (localObject4 == null) {
      localObject2 = this$0;
    }
    try
    {
      ((zzee)localObject1).get(0L, null, null, ((zzfy)localObject2).zzau().getPackageName());
      break label117;
      long l = g;
      localObject2 = a;
      localObject4 = c;
      localObject3 = this$0;
      ((zzee)localObject1).get(l, (String)localObject2, (String)localObject4, ((zzfy)localObject3).zzau().getPackageName());
      label117:
      localObject1 = this$0;
      zzjs.access$getCleanup((zzjs)localObject1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this$0.this$0.zzay().iterator().append("Failed to send current screen to the service", localRemoteException);
    }
  }
}
