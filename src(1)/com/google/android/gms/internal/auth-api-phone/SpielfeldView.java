package com.google.android.gms.internal.auth-api-phone;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class SpielfeldView
  extends IOpenVPNAPIService.Stub.Proxy
  implements HttpHost
{
  SpielfeldView(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
  }
  
  public final void init(Rules paramRules)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    Storage.open(localParcel, paramRules);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
}
