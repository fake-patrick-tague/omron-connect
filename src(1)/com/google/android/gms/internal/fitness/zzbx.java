package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.CustomTile.ExpandedItem;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.Site;
import com.google.android.gms.fitness.request.StorageVolume;

public final class zzbx
  extends Logger
  implements zzbu
{
  zzbx(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
  }
  
  public final void close(CustomTile.ExpandedItem paramExpandedItem)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramExpandedItem);
    write(7, localParcel);
  }
  
  public final void close(DataDeleteRequest paramDataDeleteRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDataDeleteRequest);
    write(3, localParcel);
  }
  
  public final void close(DataReadRequest paramDataReadRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDataReadRequest);
    write(1, localParcel);
  }
  
  public final void close(DataUpdateRequest paramDataUpdateRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDataUpdateRequest);
    write(9, localParcel);
  }
  
  public final void close(Site paramSite)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramSite);
    write(11, localParcel);
  }
  
  public final void close(StorageVolume paramStorageVolume)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramStorageVolume);
    write(2, localParcel);
  }
  
  public final void execute(DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDataUpdateListenerRegistrationRequest);
    write(10, localParcel);
  }
}
