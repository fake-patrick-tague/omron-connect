package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;

public abstract class zzcm
  extends IExtensionHost.Stub
  implements zzcn
{
  public zzcm()
  {
    super("com.google.android.gms.fitness.internal.IStatusCallback");
  }
  
  public static zzcn next(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
    if ((localIInterface instanceof zzcn)) {
      return (zzcn)localIInterface;
    }
    return new zzcp(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      onResult((Status)Log.unmarshall(paramParcel1, Status.CREATOR));
      return true;
    }
    return false;
  }
}
