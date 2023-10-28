package com.google.android.gms.internal.auth-api;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.util.credentials.Credential;
import com.google.android.gms.common.package_12.Status;

public abstract interface Vector
  extends IInterface
{
  public abstract void add(Status paramStatus, String paramString)
    throws RemoteException;
  
  public abstract void delete(Status paramStatus)
    throws RemoteException;
  
  public abstract void delete(Status paramStatus, Credential paramCredential)
    throws RemoteException;
}
