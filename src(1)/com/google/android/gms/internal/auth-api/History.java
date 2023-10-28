package com.google.android.gms.internal.auth-api;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.util.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.package_12.GoogleApiClient;

final class History
  extends zbm<Status>
{
  History(HttpConnection paramHttpConnection, GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void execute(Context paramContext, Session paramSession)
    throws RemoteException
  {
    paramSession.setAttribute(new ArrayDeque(this), new Element(path));
  }
}
