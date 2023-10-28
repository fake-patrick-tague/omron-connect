package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface Network
  extends IInterface
{
  public abstract IObjectWrapper get()
    throws RemoteException;
  
  public abstract int getPosition()
    throws RemoteException;
}
