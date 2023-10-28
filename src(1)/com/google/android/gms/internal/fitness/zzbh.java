package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

public abstract interface zzbh
  extends IInterface
{
  public abstract void init(DataSourcesResult paramDataSourcesResult)
    throws RemoteException;
}
