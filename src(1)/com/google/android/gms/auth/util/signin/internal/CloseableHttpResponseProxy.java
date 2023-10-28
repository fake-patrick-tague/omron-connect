package com.google.android.gms.auth.util.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.BasePendingResult;

final class CloseableHttpResponseProxy
  extends BasePackPushConnection
{
  CloseableHttpResponseProxy(AbstractHttpClient paramAbstractHttpClient) {}
  
  public final void close(Status paramStatus)
    throws RemoteException
  {
    original.setResult(paramStatus);
  }
}
