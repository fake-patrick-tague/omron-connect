package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.fitness.IExtensionHost.Stub;
import com.google.android.gms.internal.fitness.Log;

public abstract class zzag
  extends IExtensionHost.Stub
  implements zzad
{
  public zzag()
  {
    super("com.google.android.gms.fitness.request.IBleScanCallback");
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return false;
      }
      onScanStopped();
      return true;
    }
    onDeviceFound((BleDevice)Log.unmarshall(paramParcel1, BleDevice.CREATOR));
    return true;
  }
}
