package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

public abstract class zzbf
  extends IExtensionHost.Stub
  implements zzbc
{
  public zzbf()
  {
    super("com.google.android.gms.fitness.internal.IDataReadCallback");
  }
  
  public static zzbc asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
    if ((localIInterface instanceof zzbc)) {
      return (zzbc)localIInterface;
    }
    return new zzbe(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      openDB((DataReadResult)Log.unmarshall(paramParcel1, DataReadResult.CREATOR));
      return true;
    }
    return false;
  }
}
