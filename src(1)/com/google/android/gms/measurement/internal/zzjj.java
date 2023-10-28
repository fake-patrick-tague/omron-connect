package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzjj
  implements Runnable
{
  zzjj(zzjs paramZzjs, AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3, Item paramItem) {}
  
  public final void run()
  {
    localAtomicReference2 = id;
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      String str1;
      boolean bool;
      String str2;
      Item localItem;
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
          localObject1 = ((zzfy)localObject1).zzay().iterator();
          localObject2 = c;
          str1 = name;
          ((zzem)localObject1).append("(legacy) Failed to get conditional properties; not connected to service", null, localObject2, str1);
          localObject1 = id;
          ((AtomicReference)localObject1).set(Collections.emptyList());
        }
      }
      catch (RemoteException localRemoteException)
      {
        this$0.this$0.zzay().iterator().append("(legacy) Failed to get conditional properties; remote exception", null, c, localRemoteException);
        id.set(Collections.emptyList());
        localAtomicReference1 = id;
        continue;
        return;
      }
    }
    try
    {
      id.notify();
      return;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
    bool = TextUtils.isEmpty(null);
    if (bool)
    {
      localObject2 = url;
      Preconditions.checkNotNull(localObject2);
      localObject2 = id;
      str1 = c;
      str2 = name;
      localItem = url;
      ((AtomicReference)localObject2).set(((zzee)localObject1).get(str1, str2, localItem));
    }
    else
    {
      localObject2 = id;
      str1 = c;
      str2 = name;
      ((AtomicReference)localObject2).set(((zzee)localObject1).get(null, str1, str2));
    }
    localObject1 = this$0;
    zzjs.access$getCleanup((zzjs)localObject1);
    localObject1 = id;
    localObject1.notify();
    AtomicReference localAtomicReference1;
    id.notify();
    throw localAtomicReference1;
  }
}
