package com.google.android.gms.cloudmessaging;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public final class Element
  implements Parcelable
{
  public static final Parcelable.Creator<zzd> CREATOR = new DiscreteSeekBar.CustomState.1();
  Messenger mCallbacks;
  IMessengerCompat mReceiver;
  
  public Element(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      mCallbacks = new Messenger(paramIBinder);
      return;
    }
    mReceiver = new IMessengerCompat.Proxy(paramIBinder);
  }
  
  public final void add(Message paramMessage)
    throws RemoteException
  {
    Messenger localMessenger = mCallbacks;
    if (localMessenger != null)
    {
      localMessenger.send(paramMessage);
      return;
    }
    mReceiver.send(paramMessage);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = getObject().equals(((Element)paramObject).getObject());
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public final IBinder getObject()
  {
    Messenger localMessenger = mCallbacks;
    if (localMessenger != null) {
      return localMessenger.getBinder();
    }
    return mReceiver.asBinder();
  }
  
  public final int hashCode()
  {
    return getObject().hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Messenger localMessenger = mCallbacks;
    if (localMessenger != null)
    {
      paramParcel.writeStrongBinder(localMessenger.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(mReceiver.asBinder());
  }
}
