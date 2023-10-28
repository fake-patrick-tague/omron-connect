package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

public final class zzck
  extends Logger
  implements zzci
{
  zzck(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.ISessionStopCallback");
  }
  
  public final void openDB(SessionStopResult paramSessionStopResult)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramSessionStopResult);
    close(1, localParcel);
  }
}
