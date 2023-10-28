package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

public final class zzbe
  extends Logger
  implements zzbc
{
  zzbe(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IDataReadCallback");
  }
  
  public final void openDB(DataReadResult paramDataReadResult)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDataReadResult);
    close(1, localParcel);
  }
}
