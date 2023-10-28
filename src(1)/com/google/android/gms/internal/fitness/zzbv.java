package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.GoalsReadRequest;

public final class zzbv
  extends Logger
  implements zzbs
{
  zzbv(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitGoalsApi");
  }
  
  public final void close(GoalsReadRequest paramGoalsReadRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramGoalsReadRequest);
    write(1, localParcel);
  }
}
