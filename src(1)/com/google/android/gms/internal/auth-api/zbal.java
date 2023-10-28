package com.google.android.gms.internal.auth-api;

import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.SavePasswordResult;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zbal
  extends zbae
{
  zbal(zbam paramZbam, TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void convertStatus(Status paramStatus, SavePasswordResult paramSavePasswordResult)
    throws RemoteException
  {
    TaskUtil.setResultOrApiException(paramStatus, paramSavePasswordResult, mResult);
  }
}
