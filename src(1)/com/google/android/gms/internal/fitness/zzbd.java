package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

public final class zzbd
  extends Logger
  implements zzbb
{
  zzbd(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IDailyTotalCallback");
  }
  
  public final void openDB(DailyTotalResult paramDailyTotalResult)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDailyTotalResult);
    close(1, localParcel);
  }
}
