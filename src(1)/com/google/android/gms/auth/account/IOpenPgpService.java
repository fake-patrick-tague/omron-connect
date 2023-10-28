package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface IOpenPgpService
  extends IInterface
{
  public abstract void execute(HttpMethod paramHttpMethod, Account paramAccount)
    throws RemoteException;
  
  public abstract void execute(HttpMethod paramHttpMethod, String paramString)
    throws RemoteException;
  
  public abstract void execute(boolean paramBoolean)
    throws RemoteException;
}
