package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzbi;
import com.google.android.gms.fitness.request.zzbm;

public final class zzbz
  extends Logger
  implements zzbw
{
  zzbz(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
  }
  
  public final void close(zzak paramZzak)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzak);
    write(3, localParcel);
  }
  
  public final void close(zzbi paramZzbi)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzbi);
    write(1, localParcel);
  }
  
  public final void close(zzbm paramZzbm)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzbm);
    write(2, localParcel);
  }
}
