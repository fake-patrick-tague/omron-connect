package com.google.android.gms.common.internal.service;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface Socket
  extends IInterface
{
  public abstract void processMultiStatusBody(int paramInt)
    throws RemoteException;
}
