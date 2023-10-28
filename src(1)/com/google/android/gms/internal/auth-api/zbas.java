package com.google.android.gms.internal.auth-api;

import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.IStatusCallback.Stub;
import com.google.android.gms.common.package_12.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zbas
  extends IStatusCallback.Stub
{
  zbas(zbau paramZbau, TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void onResult(Status paramStatus)
    throws RemoteException
  {
    TaskUtil.setResultOrApiException(paramStatus, issues);
  }
}
