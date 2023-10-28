package com.google.android.gms.common.package_12.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.internal.base.IExtensionHost.Stub;
import com.google.android.gms.internal.base.Log;

public abstract interface IStatusCallback
  extends IInterface
{
  public abstract void onResult(Status paramStatus)
    throws RemoteException;
  
  public abstract class Stub
    extends IExtensionHost.Stub
    implements IStatusCallback
  {
    public Stub()
    {
      super();
    }
    
    public static IStatusCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
      if ((localIInterface instanceof IStatusCallback)) {
        return (IStatusCallback)localIInterface;
      }
      return new zaby(paramIBinder);
    }
    
    protected final boolean execute(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 == 1)
      {
        onResult((Status)Log.get(paramParcel1, Status.CREATOR));
        return true;
      }
      return false;
    }
  }
}
