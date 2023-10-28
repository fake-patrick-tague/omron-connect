package com.google.android.gms.internal.auth-api;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.BeginSignInResult;
import com.google.android.gms.common.package_12.Status;

public abstract interface Namespace
  extends IInterface
{
  public abstract void convertStatus(Status paramStatus, BeginSignInResult paramBeginSignInResult)
    throws RemoteException;
}
