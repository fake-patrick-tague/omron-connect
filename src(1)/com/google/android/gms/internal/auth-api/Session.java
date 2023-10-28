package com.google.android.gms.internal.auth-api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.credentials.CredentialRequest;

public final class Session
  extends Attribute
  implements IInterface
{
  Session(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
  }
  
  public final void setAttribute(Vector paramVector)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramVector);
    setValue(4, localParcel);
  }
  
  public final void setAttribute(Vector paramVector, CredentialRequest paramCredentialRequest)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramVector);
    Cache.remove(localParcel, paramCredentialRequest);
    setValue(1, localParcel);
  }
  
  public final void setAttribute(Vector paramVector, Element paramElement)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramVector);
    Cache.remove(localParcel, paramElement);
    setValue(2, localParcel);
  }
  
  public final void setAttribute(Vector paramVector, OperationResult paramOperationResult)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramVector);
    Cache.remove(localParcel, paramOperationResult);
    setValue(3, localParcel);
  }
}
