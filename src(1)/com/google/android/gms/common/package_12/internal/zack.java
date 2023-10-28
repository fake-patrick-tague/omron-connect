package com.google.android.gms.common.package_12.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.package_12.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zack
  extends RegisterListenerMethod
{
  zack(RegistrationMethods.Builder paramBuilder, ListenerHolder paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean, int paramInt)
  {
    super(paramListenerHolder, paramArrayOfFeature, paramBoolean, paramInt);
  }
  
  protected final void registerListener(Api.AnyClient paramAnyClient, TaskCompletionSource paramTaskCompletionSource)
    throws RemoteException
  {
    RegistrationMethods.Builder.get(mRemote).accept(paramAnyClient, paramTaskCompletionSource);
  }
}
