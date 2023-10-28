package com.google.android.gms.common.package_12.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends com.google.android.gms.common.api.Api.AnyClient, L>
{
  private final Feature[] child;
  private final int data;
  private final com.google.android.gms.common.api.internal.ListenerHolder<L> sources;
  private final boolean value;
  
  protected RegisterListenerMethod(ListenerHolder paramListenerHolder)
  {
    this(paramListenerHolder, null, false, 0);
  }
  
  protected RegisterListenerMethod(ListenerHolder paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    this(paramListenerHolder, paramArrayOfFeature, paramBoolean, 0);
  }
  
  protected RegisterListenerMethod(ListenerHolder paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean, int paramInt)
  {
    sources = paramListenerHolder;
    child = paramArrayOfFeature;
    value = paramBoolean;
    data = paramInt;
  }
  
  public void clearListener()
  {
    sources.clear();
  }
  
  public final int getCommand()
  {
    return data;
  }
  
  public ListenerHolder.ListenerKey getListenerKey()
  {
    return sources.getListenerKey();
  }
  
  public Feature[] getRequiredFeatures()
  {
    return child;
  }
  
  public final boolean putAll()
  {
    return value;
  }
  
  protected abstract void registerListener(com.google.android.gms.common.package_12.Api.AnyClient paramAnyClient, TaskCompletionSource paramTaskCompletionSource)
    throws RemoteException;
}
