package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

public abstract class zzcl
  extends IExtensionHost.Stub
  implements zzci
{
  public zzcl()
  {
    super("com.google.android.gms.fitness.internal.ISessionStopCallback");
  }
  
  public static zzci asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
    if ((localIInterface instanceof zzci)) {
      return (zzci)localIInterface;
    }
    return new zzck(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      openDB((SessionStopResult)Log.unmarshall(paramParcel1, SessionStopResult.CREATOR));
      return true;
    }
    return false;
  }
}
