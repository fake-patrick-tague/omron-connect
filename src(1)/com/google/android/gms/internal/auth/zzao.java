package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.proxy.ProxyRequest;

public final class zzao
  extends Logger
  implements zzan
{
  zzao(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.internal.IAuthService");
  }
  
  public final void lock(zzal paramZzal, ProxyRequest paramProxyRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    Log.get(localParcel, paramZzal);
    Log.write(localParcel, paramProxyRequest);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
  
  public final void output(zzal paramZzal)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    Log.get(localParcel, paramZzal);
    transactAndReadExceptionReturnVoid(3, localParcel);
  }
}
