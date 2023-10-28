package com.google.android.gms.cloudmessaging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

abstract interface IMessengerCompat
  extends IInterface
{
  public static final String DESCRIPTOR = "com.google.android.gms.iid.IMessengerCompat";
  public static final int TRANSACTION_SEND = 1;
  
  public abstract void send(Message paramMessage)
    throws RemoteException;
  
  public static class Impl
    extends Binder
    implements IMessengerCompat
  {
    public IBinder asBinder()
    {
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    
    public void send(Message paramMessage)
      throws RemoteException
    {
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  public static class Proxy
    implements IMessengerCompat
  {
    private final IBinder mRemote;
    
    Proxy(IBinder paramIBinder)
    {
      mRemote = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return mRemote;
    }
    
    public void send(Message paramMessage)
      throws RemoteException
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
      localParcel.writeInt(1);
      paramMessage.writeToParcel(localParcel, 0);
      try
      {
        mRemote.transact(1, localParcel, null, 1);
        localParcel.recycle();
        return;
      }
      catch (Throwable paramMessage)
      {
        localParcel.recycle();
        throw paramMessage;
      }
    }
  }
}
