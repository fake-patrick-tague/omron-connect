package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

public abstract class zzep
  extends IExtensionHost.Stub
  implements zzem
{
  public zzep()
  {
    super("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
  }
  
  public static zzem asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
    if ((localIInterface instanceof zzem)) {
      return (zzem)localIInterface;
    }
    return new zzeo(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      openDB((BleDevicesResult)Log.unmarshall(paramParcel1, BleDevicesResult.CREATOR));
      return true;
    }
    return false;
  }
}
