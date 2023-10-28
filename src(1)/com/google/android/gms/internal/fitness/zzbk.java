package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

public final class zzbk
  extends Logger
  implements zzbi
{
  zzbk(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IDataTypeCallback");
  }
  
  public final void openDB(DataTypeResult paramDataTypeResult)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDataTypeResult);
    close(1, localParcel);
  }
}
