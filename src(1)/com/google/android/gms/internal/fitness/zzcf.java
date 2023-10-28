package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public abstract class zzcf
  extends IExtensionHost.Stub
  implements zzcc
{
  public zzcf()
  {
    super("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
  }
  
  public static zzcc asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
    if ((localIInterface instanceof zzcc)) {
      return (zzcc)localIInterface;
    }
    return new zzce(paramIBinder);
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      openDB((ListSubscriptionsResult)Log.unmarshall(paramParcel1, ListSubscriptionsResult.CREATOR));
      return true;
    }
    return false;
  }
}
