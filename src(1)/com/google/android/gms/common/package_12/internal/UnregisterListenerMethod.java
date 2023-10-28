package com.google.android.gms.common.package_12.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class UnregisterListenerMethod<A extends com.google.android.gms.common.api.Api.AnyClient, L>
{
  private final com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey<L> roomJid;
  
  protected UnregisterListenerMethod(ListenerHolder.ListenerKey paramListenerKey)
  {
    roomJid = paramListenerKey;
  }
  
  public ListenerHolder.ListenerKey getListenerKey()
  {
    return roomJid;
  }
  
  protected abstract void unregisterListener(com.google.android.gms.common.package_12.Api.AnyClient paramAnyClient, TaskCompletionSource paramTaskCompletionSource)
    throws RemoteException;
}
