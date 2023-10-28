package com.google.android.gms.internal.auth-api;

import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.BeginSignInResult;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zbar
  extends SparseArrayCompat
{
  zbar(zbau paramZbau, TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void convertStatus(Status paramStatus, BeginSignInResult paramBeginSignInResult)
    throws RemoteException
  {
    TaskUtil.setResultOrApiException(paramStatus, paramBeginSignInResult, mResult);
  }
}
