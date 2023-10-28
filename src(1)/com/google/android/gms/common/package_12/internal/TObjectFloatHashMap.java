package com.google.android.gms.common.package_12.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.zad;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final class TObjectFloatHashMap
  extends zad<Void>
{
  public final zaci lock;
  
  public TObjectFloatHashMap(zaci paramZaci, TaskCompletionSource paramTaskCompletionSource)
  {
    super(3, paramTaskCompletionSource);
    lock = paramZaci;
  }
  
  public final Feature[] get(zabq paramZabq)
  {
    return lock.this$0.getRequiredFeatures();
  }
  
  public final boolean putAll(zabq paramZabq)
  {
    return lock.this$0.putAll();
  }
  
  public final void setValue(zabq paramZabq)
    throws RemoteException
  {
    lock.this$0.registerListener(paramZabq.getContext(), this$0);
    ListenerHolder.ListenerKey localListenerKey = lock.this$0.getListenerKey();
    if (localListenerKey != null) {
      paramZabq.get().put(localListenerKey, lock);
    }
  }
}
