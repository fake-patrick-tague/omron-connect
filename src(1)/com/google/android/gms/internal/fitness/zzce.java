package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public final class zzce
  extends Logger
  implements zzcc
{
  zzce(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
  }
  
  public final void openDB(ListSubscriptionsResult paramListSubscriptionsResult)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramListSubscriptionsResult);
    close(1, localParcel);
  }
}
