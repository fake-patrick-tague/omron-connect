package com.google.android.gms.internal.auth-api;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.package_12.Status;

public abstract interface zbad
  extends IInterface
{
  public abstract void handleException(Status paramStatus, SaveAccountLinkingTokenResult paramSaveAccountLinkingTokenResult)
    throws RemoteException;
}
