package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

public abstract interface zzci
  extends IInterface
{
  public abstract void openDB(SessionStopResult paramSessionStopResult)
    throws RemoteException;
}
