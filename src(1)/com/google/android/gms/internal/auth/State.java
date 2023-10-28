package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public final class State
  extends Logger
  implements IInAppBillingService
{
  State(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.auth.IAuthManagerService");
  }
  
  public final Bundle get(Account paramAccount, String paramString, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    Log.write(localParcel, paramAccount);
    localParcel.writeString(paramString);
    Log.write(localParcel, paramBundle);
    paramAccount = transactAndReadException(5, localParcel);
    paramString = (Bundle)Log.get(paramAccount, Bundle.CREATOR);
    paramAccount.recycle();
    return paramString;
  }
  
  public final Bundle getData(Account paramAccount)
    throws RemoteException
  {
    Object localObject = obtainAndWriteInterfaceToken();
    Log.write((Parcel)localObject, paramAccount);
    paramAccount = transactAndReadException(7, (Parcel)localObject);
    localObject = (Bundle)Log.get(paramAccount, Bundle.CREATOR);
    paramAccount.recycle();
    return localObject;
  }
  
  public final Bundle getData(String paramString)
    throws RemoteException
  {
    Object localObject = obtainAndWriteInterfaceToken();
    ((Parcel)localObject).writeString(paramString);
    paramString = transactAndReadException(8, (Parcel)localObject);
    localObject = (Bundle)Log.get(paramString, Bundle.CREATOR);
    paramString.recycle();
    return localObject;
  }
  
  public final Bundle getData(String paramString, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    Log.write(localParcel, paramBundle);
    paramString = transactAndReadException(2, localParcel);
    paramBundle = (Bundle)Log.get(paramString, Bundle.CREATOR);
    paramString.recycle();
    return paramBundle;
  }
  
  public final AccountChangeEventsResponse getData(AccountChangeEventsRequest paramAccountChangeEventsRequest)
    throws RemoteException
  {
    Object localObject = obtainAndWriteInterfaceToken();
    Log.write((Parcel)localObject, paramAccountChangeEventsRequest);
    paramAccountChangeEventsRequest = transactAndReadException(3, (Parcel)localObject);
    localObject = (AccountChangeEventsResponse)Log.get(paramAccountChangeEventsRequest, AccountChangeEventsResponse.CREATOR);
    paramAccountChangeEventsRequest.recycle();
    return localObject;
  }
}
