package com.google.android.gms.internal.oss_licenses;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class Version
  implements IInterface
{
  private final String key;
  private final IBinder mRemote;
  
  protected Version(IBinder paramIBinder, String paramString)
  {
    mRemote = paramIBinder;
    key = paramString;
  }
  
  public IBinder asBinder()
  {
    return mRemote;
  }
  
  protected final Parcel get()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(key);
    return localParcel;
  }
  
  protected final Parcel get(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      mRemote.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      paramParcel.recycle();
      return localParcel;
    }
    catch (Throwable localThrowable) {}catch (RuntimeException localRuntimeException)
    {
      localThrowable.recycle();
      throw localRuntimeException;
    }
    paramParcel.recycle();
    throw localThrowable;
  }
}
