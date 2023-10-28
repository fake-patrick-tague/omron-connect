package com.google.android.gms.auth.util.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface DiskLruCache
  extends IInterface
{
  public abstract void expand()
    throws RemoteException;
  
  public abstract void removeEntry()
    throws RemoteException;
}
