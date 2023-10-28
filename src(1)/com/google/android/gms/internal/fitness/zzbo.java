package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.ImageManager.ImageListParam;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzai;
import com.google.android.gms.fitness.request.zzbg;
import com.google.android.gms.fitness.request.zzbk;

public abstract interface zzbo
  extends IInterface
{
  public abstract void close(ImageManager.ImageListParam paramImageListParam)
    throws RemoteException;
  
  public abstract void close(StartBleScanRequest paramStartBleScanRequest)
    throws RemoteException;
  
  public abstract void close(zzbg paramZzbg)
    throws RemoteException;
  
  public abstract void close(zzbk paramZzbk)
    throws RemoteException;
  
  public abstract void execute(zzai paramZzai)
    throws RemoteException;
}
