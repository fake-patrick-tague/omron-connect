package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

public abstract class zzba
  extends IExtensionHost.Stub
  implements zzbb
{
  public zzba()
  {
    super("com.google.android.gms.fitness.internal.IDailyTotalCallback");
  }
  
  public static zzbb asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
    if ((localIInterface instanceof zzbb)) {
      return (zzbb)localIInterface;
    }
    return new zzbd(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      openDB((DailyTotalResult)Log.unmarshall(paramParcel1, DailyTotalResult.CREATOR));
      return true;
    }
    return false;
  }
}
