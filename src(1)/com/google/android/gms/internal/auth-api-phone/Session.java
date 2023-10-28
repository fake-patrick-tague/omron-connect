package com.google.android.gms.internal.auth-api-phone;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class Session
  extends TaskApiCall<zzi, Void>
{
  private TaskCompletionSource<Void> proxy;
  
  private Session() {}
  
  protected abstract void execute(HttpHost paramHttpHost)
    throws RemoteException;
  
  protected final void write(Status paramStatus)
  {
    TaskUtil.setResultOrApiException(paramStatus, proxy);
  }
}
