package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;

final class zziy
  implements Runnable
{
  zziy(zzjs paramZzjs, Item paramItem, zzcf paramZzcf) {}
  
  public final void run()
  {
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject3 = null;
    localObject5 = localObject6;
    for (;;)
    {
      try
      {
        localObject8 = this$0.this$0;
        localObject5 = localObject6;
        localObject1 = localObject7;
      }
      catch (Throwable localThrowable)
      {
        Object localObject8;
        Object localObject1;
        Object localObject9;
        boolean bool;
        Object localObject4;
        Object localObject2;
        this$0.this$0.get().c(d, (String)localObject5);
        throw localObject2;
      }
      try
      {
        localObject8 = ((zzfy)localObject8).put().url();
        localObject9 = zzah.name;
        localObject5 = localObject6;
        localObject1 = localObject7;
        bool = ((zzai)localObject8).get((zzah)localObject9);
        if (bool) {
          continue;
        }
        localObject5 = localObject6;
        localObject8 = this$0.this$0;
        localObject5 = localObject6;
        localObject1 = localObject7;
        ((zzfy)localObject8).zzay().isEmpty().append("Analytics storage consent denied; will not get app instance id");
        localObject5 = localObject6;
        localObject8 = this$0.this$0;
        localObject5 = localObject6;
        localObject1 = localObject7;
        ((zzfy)localObject8).add().add(null);
        localObject5 = localObject6;
        localObject8 = this$0.this$0;
        localObject5 = localObject6;
        localObject1 = localObject7;
        localObject8 = ((zzfy)localObject8).put();
        localObject8 = type;
        localObject5 = localObject6;
        localObject1 = localObject7;
        ((zzfc)localObject8).put(null);
        localObject1 = this$0.this$0;
      }
      catch (RemoteException localRemoteException)
      {
        localObject5 = localThrowable;
        this$0.this$0.zzay().iterator().append("Failed to get app instance id", localRemoteException);
        localObject5 = this$0.this$0;
        localObject4 = localThrowable;
        localObject2 = localObject5;
        continue;
      }
      ((zzfy)localObject1).get().c(d, (String)localObject3);
      return;
      localObject9 = this$0;
      localObject5 = localObject6;
      localObject1 = localObject7;
      localObject8 = zzjs.getInstance((zzjs)localObject9);
      if (localObject8 == null)
      {
        localObject8 = this$0;
        localObject5 = localObject6;
        localObject1 = localObject7;
        ((zzfy)localObject8).zzay().iterator().append("Failed to get app instance id");
        localObject1 = this$0.this$0;
      }
      else
      {
        localObject5 = localObject6;
        localObject3 = i;
        localObject5 = localObject6;
        localObject1 = localObject7;
        Preconditions.checkNotNull(localObject3);
        localObject3 = i;
        localObject5 = localObject6;
        localObject1 = localObject7;
        localObject6 = ((zzee)localObject8).get((Item)localObject3);
        localObject3 = localObject6;
        if (localObject6 != null)
        {
          localObject5 = localObject3;
          localObject7 = this$0.this$0;
          localObject5 = localObject3;
          localObject1 = localObject3;
          ((zzfy)localObject7).add().add((String)localObject6);
          localObject5 = localObject3;
          localObject7 = this$0.this$0;
          localObject5 = localObject3;
          localObject1 = localObject3;
          localObject7 = ((zzfy)localObject7).put();
          localObject5 = localObject3;
          localObject7 = type;
          localObject5 = localObject3;
          localObject1 = localObject3;
          ((zzfc)localObject7).put((String)localObject6);
        }
        localObject6 = this$0;
        localObject5 = localObject3;
        localObject1 = localObject3;
        zzjs.access$getCleanup((zzjs)localObject6);
        localObject1 = this$0.this$0;
      }
    }
  }
}
