package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class Logger
  implements IInterface
{
  private final IBinder mRemote;
  private final String parent;
  
  protected Logger(IBinder paramIBinder, String paramString)
  {
    mRemote = paramIBinder;
    parent = paramString;
  }
  
  public IBinder asBinder()
  {
    return mRemote;
  }
  
  protected final void close(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    try
    {
      mRemote.transact(paramInt, paramParcel, null, 1);
      paramParcel.recycle();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramParcel.recycle();
      throw localThrowable;
    }
  }
  
  protected final Parcel getVersion()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(parent);
    return localParcel;
  }
  
  protected final void write(int paramInt, Parcel paramParcel)
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
