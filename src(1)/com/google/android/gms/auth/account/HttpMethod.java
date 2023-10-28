package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface HttpMethod
  extends IInterface
{
  public abstract void execute(Account paramAccount)
    throws RemoteException;
  
  public abstract void execute(boolean paramBoolean)
    throws RemoteException;
}
