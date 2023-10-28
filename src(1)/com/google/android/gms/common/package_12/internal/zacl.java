package com.google.android.gms.common.package_12.internal;

import android.os.RemoteException;
import com.google.android.gms.common.package_12.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacl
  extends UnregisterListenerMethod
{
  zacl(RegistrationMethods.Builder paramBuilder, ListenerHolder.ListenerKey paramListenerKey)
  {
    super(paramListenerKey);
  }
  
  protected final void unregisterListener(Api.AnyClient paramAnyClient, TaskCompletionSource paramTaskCompletionSource)
    throws RemoteException
  {
    RegistrationMethods.Builder.getCauses(mSensorManager).accept(paramAnyClient, paramTaskCompletionSource);
  }
}
