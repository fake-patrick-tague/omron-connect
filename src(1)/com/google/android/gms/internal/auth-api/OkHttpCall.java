package com.google.android.gms.internal.auth-api;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.util.credentials.CredentialRequest;
import com.google.android.gms.common.package_12.GoogleApiClient;

final class OkHttpCall
  extends zbm<CredentialRequestResult>
{
  OkHttpCall(HttpConnection paramHttpConnection, GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void execute(Context paramContext, Session paramSession)
    throws RemoteException
  {
    paramSession.setAttribute(new DownloadFile(this), requestFactory);
  }
}
