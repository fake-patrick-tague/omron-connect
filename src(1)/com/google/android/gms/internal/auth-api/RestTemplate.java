package com.google.android.gms.internal.auth-api;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.util.Auth;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.package_12.GoogleApiClient;

abstract class RestTemplate<R extends Result>
  extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<R, zbo>
{
  RestTemplate(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.CREDENTIALS_API, paramGoogleApiClient);
  }
  
  protected abstract void execute(Context paramContext, Session paramSession)
    throws DeadObjectException, RemoteException;
}
