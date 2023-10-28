package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.GoalsReadRequest;

public abstract interface zzbs
  extends IInterface
{
  public abstract void close(GoalsReadRequest paramGoalsReadRequest)
    throws RemoteException;
}
