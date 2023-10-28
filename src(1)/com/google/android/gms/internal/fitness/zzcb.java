package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.zzap;
import com.google.android.gms.fitness.request.zzar;

public final class zzcb
  extends Logger
  implements zzby
{
  zzcb(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
  }
  
  public final void close(DataSourcesRequest paramDataSourcesRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDataSourcesRequest);
    write(1, localParcel);
  }
  
  public final void close(zzap paramZzap)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzap);
    write(2, localParcel);
  }
  
  public final void close(zzar paramZzar)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzar);
    write(3, localParcel);
  }
}
