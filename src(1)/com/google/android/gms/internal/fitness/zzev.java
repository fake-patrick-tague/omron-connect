package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public abstract interface zzev
  extends IInterface
{
  public abstract void addUrls(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, zzcn paramZzcn)
    throws RemoteException;
  
  public abstract void addUrls(zzet paramZzet, zzcn paramZzcn)
    throws RemoteException;
  
  public abstract void cd(zzer paramZzer, zzbh paramZzbh)
    throws RemoteException;
}
