package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

public final class zzcj
  extends Logger
  implements zzch
{
  zzcj(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.ISessionReadCallback");
  }
  
  public final void openDB(SessionReadResult paramSessionReadResult)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramSessionReadResult);
    close(1, localParcel);
  }
}
