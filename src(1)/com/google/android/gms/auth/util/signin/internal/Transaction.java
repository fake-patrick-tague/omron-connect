package com.google.android.gms.auth.util.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.common.package_12.Status;

public abstract interface Transaction
  extends IInterface
{
  public abstract void add(Status paramStatus)
    throws RemoteException;
  
  public abstract void close(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
    throws RemoteException;
  
  public abstract void close(Status paramStatus)
    throws RemoteException;
}
