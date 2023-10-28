package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.GoalsResult;

public abstract class zzbm
  extends IExtensionHost.Stub
  implements zzbn
{
  public zzbm()
  {
    super("com.google.android.gms.fitness.internal.IGoalsReadCallback");
  }
  
  public static zzbn asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoalsReadCallback");
    if ((localIInterface instanceof zzbn)) {
      return (zzbn)localIInterface;
    }
    return new zzbp(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      openDB((GoalsResult)Log.unmarshall(paramParcel1, GoalsResult.CREATOR));
      return true;
    }
    return false;
  }
}
