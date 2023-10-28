package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;

public final class zzcp
  extends Logger
  implements zzcn
{
  zzcp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IStatusCallback");
  }
  
  public final void onResult(Status paramStatus)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramStatus);
    close(1, localParcel);
  }
}
