package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.GoalsResult;

public final class zzbp
  extends Logger
  implements zzbn
{
  zzbp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoalsReadCallback");
  }
  
  public final void openDB(GoalsResult paramGoalsResult)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramGoalsResult);
    close(1, localParcel);
  }
}
