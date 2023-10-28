package com.google.android.gms.internal.auth-api;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.package_12.GoogleApiClient;

final class SyncOperation
  extends zbm<Status>
{
  SyncOperation(HttpConnection paramHttpConnection, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void execute(Context paramContext, Session paramSession)
    throws RemoteException
  {
    paramSession.setAttribute(new ArrayDeque(this));
  }
}
