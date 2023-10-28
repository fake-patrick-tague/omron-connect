package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;

final class zzjd
  implements Runnable
{
  zzjd(zzjs paramZzjs, zzaw paramZzaw, String paramString, zzcf paramZzcf) {}
  
  public final void run()
  {
    zzjs localZzjs = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject6 = this$0;
    Object localObject2 = localZzjs;
    for (Object localObject1 = localObject4;; localObject1 = localObject3)
    {
      try
      {
        localObject5 = zzjs.getInstance((zzjs)localObject6);
        if (localObject5 != null) {
          break label81;
        }
        localObject5 = this$0;
        localObject2 = localZzjs;
        localObject1 = localObject4;
        ((zzfy)localObject5).zzay().iterator().append("Discarding data. Failed to send event to service to bundle");
        localObject2 = this$0.this$0;
        localObject1 = localObject3;
      }
      catch (Throwable localThrowable) {}catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Object localObject5;
          label81:
          localObject2 = localThrowable;
          this$0.this$0.zzay().iterator().append("Failed to send event to the service to bundle", localRemoteException);
          localObject2 = this$0.this$0;
        }
      }
      ((zzfy)localObject2).get().add(mName, localObject1);
      return;
      localObject3 = mPath;
      localObject6 = mType;
      localObject2 = localZzjs;
      localObject1 = localObject4;
      localObject3 = ((zzee)localObject5).get((zzaw)localObject3, (String)localObject6);
      localZzjs = this$0;
      localObject2 = localObject3;
      localObject1 = localObject3;
      zzjs.access$getCleanup(localZzjs);
      localObject2 = this$0.this$0;
    }
    this$0.this$0.get().add(mName, (byte[])localObject2);
    throw localThrowable;
  }
}
