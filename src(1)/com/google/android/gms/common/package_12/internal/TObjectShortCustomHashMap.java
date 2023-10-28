package com.google.android.gms.common.package_12.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.zad;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final class TObjectShortCustomHashMap
  extends zad<Boolean>
{
  public final com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey<?> key;
  
  public TObjectShortCustomHashMap(ListenerHolder.ListenerKey paramListenerKey, TaskCompletionSource paramTaskCompletionSource)
  {
    super(4, paramTaskCompletionSource);
    key = paramListenerKey;
  }
  
  public final Feature[] get(zabq paramZabq)
  {
    paramZabq = (zaci)paramZabq.get().get(key);
    if (paramZabq == null) {
      return null;
    }
    return this$0.getRequiredFeatures();
  }
  
  public final boolean putAll(zabq paramZabq)
  {
    paramZabq = (zaci)paramZabq.get().get(key);
    return (paramZabq != null) && (this$0.putAll());
  }
  
  public final void setValue(zabq paramZabq)
    throws RemoteException
  {
    zaci localZaci = (zaci)paramZabq.get().remove(key);
    if (localZaci != null)
    {
      value.unregisterListener(paramZabq.getContext(), this$0);
      this$0.clearListener();
      return;
    }
    this$0.trySetResult(Boolean.FALSE);
  }
}
