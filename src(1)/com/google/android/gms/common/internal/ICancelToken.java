package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.IExtensionHost.Stub;

public abstract interface ICancelToken
  extends IInterface
{
  public abstract void cancel()
    throws RemoteException;
  
  public static abstract class Stub
    extends IExtensionHost.Stub
    implements ICancelToken
  {
    public Stub()
    {
      super();
    }
    
    public static ICancelToken asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
      if ((localIInterface instanceof ICancelToken)) {
        return (ICancelToken)localIInterface;
      }
      return new INotificationSideChannel.Stub.Proxy(paramIBinder);
    }
    
    protected final boolean execute(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 == 2)
      {
        cancel();
        return true;
      }
      return false;
    }
  }
}
