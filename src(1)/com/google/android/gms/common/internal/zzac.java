package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

final class zzac
  implements IGmsServiceBroker
{
  private final IBinder mRemote;
  
  zzac(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return mRemote;
  }
  
  public final void getService(IGmsCallbacks paramIGmsCallbacks, GetServiceRequest paramGetServiceRequest)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
      if (paramIGmsCallbacks != null) {
        paramIGmsCallbacks = paramIGmsCallbacks.asBinder();
      } else {
        paramIGmsCallbacks = null;
      }
      localParcel1.writeStrongBinder(paramIGmsCallbacks);
      if (paramGetServiceRequest != null)
      {
        localParcel1.writeInt(1);
        PaymentIntent.Output.1.toString(paramGetServiceRequest, localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      mRemote.transact(46, localParcel1, localParcel2, 0);
      localParcel2.readException();
      localParcel2.recycle();
      localParcel1.recycle();
      return;
    }
    catch (Throwable paramIGmsCallbacks)
    {
      localParcel2.recycle();
      localParcel1.recycle();
      throw paramIGmsCallbacks;
    }
  }
}
