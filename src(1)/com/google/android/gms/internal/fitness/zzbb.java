package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

public abstract interface zzbb
  extends IInterface
{
  public abstract void openDB(DailyTotalResult paramDailyTotalResult)
    throws RemoteException;
}
