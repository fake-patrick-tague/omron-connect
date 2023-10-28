package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public abstract interface IInAppBillingService
  extends IInterface
{
  public abstract Bundle get(Account paramAccount, String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract Bundle getData(Account paramAccount)
    throws RemoteException;
  
  public abstract Bundle getData(String paramString)
    throws RemoteException;
  
  public abstract Bundle getData(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract AccountChangeEventsResponse getData(AccountChangeEventsRequest paramAccountChangeEventsRequest)
    throws RemoteException;
}
