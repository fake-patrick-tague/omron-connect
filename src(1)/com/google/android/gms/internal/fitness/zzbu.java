package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.CustomTile.ExpandedItem;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.Site;
import com.google.android.gms.fitness.request.StorageVolume;

public abstract interface zzbu
  extends IInterface
{
  public abstract void close(CustomTile.ExpandedItem paramExpandedItem)
    throws RemoteException;
  
  public abstract void close(DataDeleteRequest paramDataDeleteRequest)
    throws RemoteException;
  
  public abstract void close(DataReadRequest paramDataReadRequest)
    throws RemoteException;
  
  public abstract void close(DataUpdateRequest paramDataUpdateRequest)
    throws RemoteException;
  
  public abstract void close(Site paramSite)
    throws RemoteException;
  
  public abstract void close(StorageVolume paramStorageVolume)
    throws RemoteException;
  
  public abstract void execute(DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest)
    throws RemoteException;
}
