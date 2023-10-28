package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.IExtensionHost.Stub;
import com.google.android.gms.internal.common.JSONObject;

public abstract interface IAccountAccessor
  extends IInterface
{
  public abstract Account get()
    throws RemoteException;
  
  public static abstract class Stub
    extends IExtensionHost.Stub
    implements IAccountAccessor
  {
    public Stub()
    {
      super();
    }
    
    public static IAccountAccessor asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
      if ((localIInterface instanceof IAccountAccessor)) {
        return (IAccountAccessor)localIInterface;
      }
      return new IStatusBarCustomTileHolder.Stub.Proxy(paramIBinder);
    }
    
    protected final boolean execute(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 == 2)
      {
        paramParcel1 = get();
        paramParcel2.writeNoException();
        JSONObject.writeValue(paramParcel2, paramParcel1);
        return true;
      }
      return false;
    }
  }
}
