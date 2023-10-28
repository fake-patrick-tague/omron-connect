package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public abstract interface zzcc
  extends IInterface
{
  public abstract void openDB(ListSubscriptionsResult paramListSubscriptionsResult)
    throws RemoteException;
}
