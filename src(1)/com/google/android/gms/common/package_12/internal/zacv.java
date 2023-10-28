package com.google.android.gms.common.package_12.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.package_12.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacv
  extends TaskApiCall
{
  zacv(TaskApiCall.Builder paramBuilder, Feature[] paramArrayOfFeature, boolean paramBoolean, int paramInt)
  {
    super(paramArrayOfFeature, paramBoolean, paramInt);
  }
  
  protected final void doExecute(Api.AnyClient paramAnyClient, TaskCompletionSource paramTaskCompletionSource)
    throws RemoteException
  {
    TaskApiCall.Builder.access$getAndroidModule(requestExecutor).accept(paramAnyClient, paramTaskCompletionSource);
  }
}
