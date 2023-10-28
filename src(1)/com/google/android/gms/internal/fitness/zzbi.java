package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

public abstract interface zzbi
  extends IInterface
{
  public abstract void openDB(DataTypeResult paramDataTypeResult)
    throws RemoteException;
}
