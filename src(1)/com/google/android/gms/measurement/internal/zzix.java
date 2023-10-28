package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class zzix
  implements Runnable
{
  zzix(zzjs paramZzjs, AtomicReference paramAtomicReference, Item paramItem) {}
  
  public final void run()
  {
    localAtomicReference2 = thread;
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      boolean bool;
      Item localItem;
      try
      {
        localObject1 = this$0.this$0;
      }
      catch (Throwable localThrowable1) {}
      try
      {
        localObject1 = ((zzfy)localObject1).put().url();
        localObject2 = zzah.name;
        bool = ((zzai)localObject1).get((zzah)localObject2);
        if (!bool)
        {
          localObject1 = this$0.this$0;
          ((zzfy)localObject1).zzay().isEmpty().append("Analytics storage consent denied; will not get app instance id");
          localObject1 = this$0.this$0;
          ((zzfy)localObject1).add().add(null);
          localObject1 = this$0.this$0;
          localObject1 = ((zzfy)localObject1).put();
          localObject1 = type;
          ((zzfc)localObject1).put(null);
          localObject1 = thread;
          ((AtomicReference)localObject1).set(null);
        }
      }
      catch (RemoteException localRemoteException)
      {
        this$0.this$0.zzay().iterator().append("Failed to get app instance id", localRemoteException);
        localAtomicReference1 = thread;
        continue;
        return;
      }
    }
    try
    {
      thread.notify();
      return;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
    localObject2 = this$0;
    localObject1 = zzjs.getInstance((zzjs)localObject2);
    if (localObject1 == null)
    {
      localObject1 = this$0;
      ((zzfy)localObject1).zzay().iterator().append("Failed to get app instance id");
      thread.notify();
      return;
    }
    localObject2 = board;
    Preconditions.checkNotNull(localObject2);
    localObject2 = thread;
    localItem = board;
    ((AtomicReference)localObject2).set(((zzee)localObject1).get(localItem));
    localObject1 = thread;
    localObject1 = ((AtomicReference)localObject1).get();
    localObject1 = (String)localObject1;
    if (localObject1 != null)
    {
      localObject2 = this$0.this$0;
      ((zzfy)localObject2).add().add((String)localObject1);
      localObject2 = this$0.this$0;
      localObject2 = ((zzfy)localObject2).put();
      localObject2 = type;
      ((zzfc)localObject2).put((String)localObject1);
    }
    localObject1 = this$0;
    zzjs.access$getCleanup((zzjs)localObject1);
    localObject1 = thread;
    localObject1.notify();
    AtomicReference localAtomicReference1;
    thread.notify();
    throw localAtomicReference1;
  }
}
