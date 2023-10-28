package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaa
  extends Logger
  implements Transaction
{
  zzaa(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
  }
  
  public final void commit(Detail paramDetail, Artist paramArtist)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    Log.get(localParcel, paramDetail);
    Log.write(localParcel, paramArtist);
    transactAndReadExceptionReturnVoid(7, localParcel);
  }
  
  public final void commit(Detail paramDetail, zzab paramZzab)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    Log.get(localParcel, paramDetail);
    Log.write(localParcel, paramZzab);
    transactAndReadExceptionReturnVoid(9, localParcel);
  }
  
  public final void commit(Detail paramDetail, zzad paramZzad)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    Log.get(localParcel, paramDetail);
    Log.write(localParcel, paramZzad);
    transactAndReadExceptionReturnVoid(6, localParcel);
  }
  
  public final void commit(Detail paramDetail, zzaf paramZzaf)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    Log.get(localParcel, paramDetail);
    Log.write(localParcel, paramZzaf);
    transactAndReadExceptionReturnVoid(5, localParcel);
  }
  
  public final void commit(Detail paramDetail, zzah paramZzah)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    Log.get(localParcel, paramDetail);
    Log.write(localParcel, paramZzah);
    transactAndReadExceptionReturnVoid(8, localParcel);
  }
}
