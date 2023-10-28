package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

public abstract class zzbl
  extends IExtensionHost.Stub
  implements zzbi
{
  public zzbl()
  {
    super("com.google.android.gms.fitness.internal.IDataTypeCallback");
  }
  
  public static zzbi asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
    if ((localIInterface instanceof zzbi)) {
      return (zzbi)localIInterface;
    }
    return new zzbk(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      openDB((DataTypeResult)Log.unmarshall(paramParcel1, DataTypeResult.CREATOR));
      return true;
    }
    return false;
  }
}
