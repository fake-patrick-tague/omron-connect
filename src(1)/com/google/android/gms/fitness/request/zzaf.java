package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.fitness.Log;
import com.google.android.gms.internal.fitness.Logger;

public final class zzaf
  extends Logger
  implements zzad
{
  zzaf(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.request.IBleScanCallback");
  }
  
  public final void onDeviceFound(BleDevice paramBleDevice)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramBleDevice);
    close(1, localParcel);
  }
  
  public final void onScanStopped()
    throws RemoteException
  {
    close(2, getVersion());
  }
}
