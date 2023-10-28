package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzbi;
import com.google.android.gms.fitness.request.zzbm;

public abstract interface zzbw
  extends IInterface
{
  public abstract void close(zzak paramZzak)
    throws RemoteException;
  
  public abstract void close(zzbi paramZzbi)
    throws RemoteException;
  
  public abstract void close(zzbm paramZzbm)
    throws RemoteException;
}
