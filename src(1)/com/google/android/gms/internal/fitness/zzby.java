package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.zzap;
import com.google.android.gms.fitness.request.zzar;

public abstract interface zzby
  extends IInterface
{
  public abstract void close(DataSourcesRequest paramDataSourcesRequest)
    throws RemoteException;
  
  public abstract void close(zzap paramZzap)
    throws RemoteException;
  
  public abstract void close(zzar paramZzar)
    throws RemoteException;
}
