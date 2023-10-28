package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzaw;
import com.google.android.gms.fitness.request.zzay;
import com.google.android.gms.fitness.request.zzba;
import com.google.android.gms.fitness.request.zzbc;

public abstract interface zzca
  extends IInterface
{
  public abstract void close(SessionInsertRequest paramSessionInsertRequest)
    throws RemoteException;
  
  public abstract void close(SessionReadRequest paramSessionReadRequest)
    throws RemoteException;
  
  public abstract void close(zzay paramZzay)
    throws RemoteException;
  
  public abstract void close(zzba paramZzba)
    throws RemoteException;
  
  public abstract void close(zzbc paramZzbc)
    throws RemoteException;
  
  public abstract void execute(zzaw paramZzaw)
    throws RemoteException;
}
