package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.base.Log;
import com.google.android.gms.internal.base.Transport;

public final class RealmObject
  extends Transport
  implements IInterface
{
  RealmObject(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
  }
  
  public final IObjectWrapper getChat(IObjectWrapper paramIObjectWrapper, Contact paramContact)
    throws RemoteException
  {
    Parcel localParcel = next();
    Log.get(localParcel, paramIObjectWrapper);
    Log.writeValue(localParcel, paramContact);
    paramIObjectWrapper = get(2, localParcel);
    paramContact = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    return paramContact;
  }
}
