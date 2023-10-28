package com.google.android.gms.internal.auth-api;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;

public abstract interface zbab
  extends IInterface
{
  public abstract void convertStatus(Status paramStatus, PendingIntent paramPendingIntent)
    throws RemoteException;
}
