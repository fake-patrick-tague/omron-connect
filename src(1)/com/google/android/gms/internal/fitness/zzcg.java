package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

public abstract class zzcg
  extends IExtensionHost.Stub
  implements zzch
{
  public zzcg()
  {
    super("com.google.android.gms.fitness.internal.ISessionReadCallback");
  }
  
  public static zzch asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
    if ((localIInterface instanceof zzch)) {
      return (zzch)localIInterface;
    }
    return new zzcj(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      openDB((SessionReadResult)Log.unmarshall(paramParcel1, SessionReadResult.CREATOR));
      return true;
    }
    return false;
  }
}
