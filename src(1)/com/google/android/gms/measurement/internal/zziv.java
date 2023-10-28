package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class zziv
  implements Runnable
{
  zziv(zzjs paramZzjs, AtomicReference paramAtomicReference, Item paramItem, boolean paramBoolean) {}
  
  public final void run()
  {
    localAtomicReference2 = buf;
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      Item localItem;
      boolean bool;
      try
      {
        localObject2 = this$0;
      }
      catch (Throwable localThrowable1) {}
      try
      {
        localObject1 = zzjs.getInstance((zzjs)localObject2);
        if (localObject1 == null)
        {
          localObject1 = this$0;
          ((zzfy)localObject1).zzay().iterator().append("Failed to get all user properties; not connected to service");
        }
      }
      catch (RemoteException localRemoteException)
      {
        this$0.this$0.zzay().iterator().append("Failed to get all user properties; remote exception", localRemoteException);
        localAtomicReference1 = buf;
        continue;
        return;
      }
    }
    try
    {
      buf.notify();
      return;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
    localObject2 = _in;
    Preconditions.checkNotNull(localObject2);
    localObject2 = buf;
    localItem = _in;
    bool = _connection;
    ((AtomicReference)localObject2).set(((zzee)localObject1).get(localItem, bool));
    localObject1 = this$0;
    zzjs.access$getCleanup((zzjs)localObject1);
    localObject1 = buf;
    localObject1.notify();
    AtomicReference localAtomicReference1;
    buf.notify();
    throw localAtomicReference1;
  }
}
