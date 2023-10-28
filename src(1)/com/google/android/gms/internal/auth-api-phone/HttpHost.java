package com.google.android.gms.internal.auth-api-phone;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface HttpHost
  extends IInterface
{
  public abstract void init(Rules paramRules)
    throws RemoteException;
}
