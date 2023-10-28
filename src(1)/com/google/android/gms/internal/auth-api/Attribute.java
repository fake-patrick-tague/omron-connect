package com.google.android.gms.internal.auth-api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class Attribute
  implements IInterface
{
  private final String mName;
  private final IBinder mRemote;
  
  protected Attribute(IBinder paramIBinder, String paramString)
  {
    mRemote = paramIBinder;
    mName = paramString;
  }
  
  public final IBinder asBinder()
  {
    return mRemote;
  }
  
  protected final Parcel getName()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(mName);
    return localParcel;
  }
  
  protected final void setValue(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      mRemote.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      paramParcel.recycle();
      localParcel.recycle();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramParcel.recycle();
      localParcel.recycle();
      throw localThrowable;
    }
  }
}
