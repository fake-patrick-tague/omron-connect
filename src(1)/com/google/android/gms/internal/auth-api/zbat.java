package com.google.android.gms.internal.auth-api;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zbat
  extends zbaa
{
  zbat(zbau paramZbau, TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void convertStatus(Status paramStatus, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    TaskUtil.setResultOrApiException(paramStatus, paramPendingIntent, mResult);
  }
}
