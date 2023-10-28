package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;

final class zzjk
  implements Runnable
{
  zzjk(zzjs paramZzjs, String paramString1, String paramString2, Item paramItem, zzcf paramZzcf) {}
  
  public final void run()
  {
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = this$0;
    Object localObject1 = localArrayList2;
    for (ArrayList localArrayList1 = localArrayList2;; localArrayList1 = localArrayList2)
    {
      try
      {
        localObject2 = zzjs.getInstance((zzjs)localObject3);
        if (localObject2 != null) {
          break label103;
        }
        localObject1 = localArrayList2;
        localObject2 = this$0;
        localObject1 = localArrayList2;
        localArrayList1 = localArrayList2;
        localObject2 = ((zzfy)localObject2).zzay().iterator();
        localObject3 = type;
        str = scope;
        localObject1 = localArrayList2;
        localArrayList1 = localArrayList2;
        ((zzem)localObject2).append("Failed to get conditional properties; not connected to service", localObject3, str);
        localObject1 = this$0.this$0;
        localArrayList1 = localArrayList2;
      }
      catch (Throwable localThrowable) {}catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Object localObject2;
          String str;
          label103:
          Item localItem;
          localObject1 = localThrowable;
          this$0.this$0.zzay().iterator().append("Failed to get conditional properties; remote exception", type, scope, localRemoteException);
          localObject1 = this$0.this$0;
        }
      }
      ((zzfy)localObject1).get().create(source, localArrayList1);
      return;
      localObject1 = localArrayList2;
      localObject3 = key;
      localObject1 = localArrayList2;
      localArrayList1 = localArrayList2;
      Preconditions.checkNotNull(localObject3);
      localObject3 = type;
      str = scope;
      localItem = key;
      localObject1 = localArrayList2;
      localArrayList1 = localArrayList2;
      localArrayList2 = zzlh.parse(((zzee)localObject2).get((String)localObject3, str, localItem));
      localObject2 = this$0;
      localObject1 = localArrayList2;
      localArrayList1 = localArrayList2;
      zzjs.access$getCleanup((zzjs)localObject2);
      localObject1 = this$0.this$0;
    }
    this$0.this$0.get().create(source, (ArrayList)localObject1);
    throw localThrowable;
  }
}
