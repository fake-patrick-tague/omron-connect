package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

public final class zzeo
  extends Logger
  implements zzem
{
  zzeo(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
  }
  
  public final void openDB(BleDevicesResult paramBleDevicesResult)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramBleDevicesResult);
    close(1, localParcel);
  }
}
