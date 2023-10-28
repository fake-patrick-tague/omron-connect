package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface Logger
  extends IInterface
{
  public abstract void e(TransportInformation paramTransportInformation)
    throws RemoteException;
}
