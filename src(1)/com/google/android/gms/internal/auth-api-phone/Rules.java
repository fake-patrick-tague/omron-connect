package com.google.android.gms.internal.auth-api-phone;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;

public abstract interface Rules
  extends IInterface
{
  public abstract void add(Status paramStatus)
    throws RemoteException;
}
