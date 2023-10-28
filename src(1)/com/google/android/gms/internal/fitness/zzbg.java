package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

public abstract class zzbg
  extends IExtensionHost.Stub
  implements zzbh
{
  public zzbg()
  {
    super("com.google.android.gms.fitness.internal.IDataSourcesCallback");
  }
  
  public static zzbh asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
    if ((localIInterface instanceof zzbh)) {
      return (zzbh)localIInterface;
    }
    return new zzbj(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      init((DataSourcesResult)Log.unmarshall(paramParcel1, DataSourcesResult.CREATOR));
      return true;
    }
    return false;
  }
}
