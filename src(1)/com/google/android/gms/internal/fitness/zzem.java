package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

public abstract interface zzem
  extends IInterface
{
  public abstract void openDB(BleDevicesResult paramBleDevicesResult)
    throws RemoteException;
}
