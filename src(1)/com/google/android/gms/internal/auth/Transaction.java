package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface Transaction
  extends IInterface
{
  public abstract void commit(Detail paramDetail, Artist paramArtist)
    throws RemoteException;
  
  public abstract void commit(Detail paramDetail, zzab paramZzab)
    throws RemoteException;
  
  public abstract void commit(Detail paramDetail, zzad paramZzad)
    throws RemoteException;
  
  public abstract void commit(Detail paramDetail, zzaf paramZzaf)
    throws RemoteException;
  
  public abstract void commit(Detail paramDetail, zzah paramZzah)
    throws RemoteException;
}
