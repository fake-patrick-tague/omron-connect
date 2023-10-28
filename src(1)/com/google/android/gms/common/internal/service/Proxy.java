package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.Log;
import com.google.android.gms.internal.base.Transport;

public final class Proxy
  extends Transport
  implements IInterface
{
  Proxy(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.service.ICommonService");
  }
  
  public final void close(Socket paramSocket)
    throws RemoteException
  {
    Parcel localParcel = next();
    Log.get(localParcel, paramSocket);
    reset(1, localParcel);
  }
}
