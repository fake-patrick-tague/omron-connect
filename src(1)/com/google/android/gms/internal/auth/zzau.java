package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.GoogleApiClient;

final class zzau
  extends zzaq
{
  zzau(zzar paramZzar, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void e(Context paramContext, zzan paramZzan)
    throws RemoteException
  {
    paramZzan.output(new zzav(this));
  }
}
