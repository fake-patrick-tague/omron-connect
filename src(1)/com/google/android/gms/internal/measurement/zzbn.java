package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzbn
  extends Binder
  implements IInterface
{
  protected zzbn(String paramString)
  {
    attachInterface(this, paramString);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  protected boolean getFromLocationName(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 > 16777215)
    {
      if (super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
        return true;
      }
    }
    else {
      paramParcel1.enforceInterface(getInterfaceDescriptor());
    }
    return getFromLocationName(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
}
