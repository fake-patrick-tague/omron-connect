package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;

public abstract interface zzcn
  extends IInterface
{
  public abstract void onResult(Status paramStatus)
    throws RemoteException;
}
