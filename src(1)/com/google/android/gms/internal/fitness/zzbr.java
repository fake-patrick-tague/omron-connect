package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.ImageManager.ImageListParam;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzai;
import com.google.android.gms.fitness.request.zzbg;
import com.google.android.gms.fitness.request.zzbk;

public final class zzbr
  extends Logger
  implements zzbo
{
  zzbr(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitBleApi");
  }
  
  public final void close(ImageManager.ImageListParam paramImageListParam)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramImageListParam);
    write(3, localParcel);
  }
  
  public final void close(StartBleScanRequest paramStartBleScanRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramStartBleScanRequest);
    write(1, localParcel);
  }
  
  public final void close(zzbg paramZzbg)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzbg);
    write(2, localParcel);
  }
  
  public final void close(zzbk paramZzbk)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzbk);
    write(4, localParcel);
  }
  
  public final void execute(zzai paramZzai)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzai);
    write(5, localParcel);
  }
}
