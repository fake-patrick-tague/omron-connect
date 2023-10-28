package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

public final class zzbj
  extends Logger
  implements zzbh
{
  zzbj(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
  }
  
  public final void init(DataSourcesResult paramDataSourcesResult)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDataSourcesResult);
    close(1, localParcel);
  }
}
