package com.google.android.gms.internal.auth-api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.BeginSignInRequest;
import com.google.android.gms.auth.util.identity.GetSignInIntentRequest;
import com.google.android.gms.common.package_12.internal.IStatusCallback;

public final class zbag
  extends Attribute
  implements IInterface
{
  zbag(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
  }
  
  public final void setAttribute(Namespace paramNamespace, BeginSignInRequest paramBeginSignInRequest)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramNamespace);
    Cache.remove(localParcel, paramBeginSignInRequest);
    setValue(1, localParcel);
  }
  
  public final void setAttribute(zbab paramZbab, GetSignInIntentRequest paramGetSignInIntentRequest)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramZbab);
    Cache.remove(localParcel, paramGetSignInIntentRequest);
    setValue(3, localParcel);
  }
  
  public final void write(IStatusCallback paramIStatusCallback, String paramString)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramIStatusCallback);
    localParcel.writeString(paramString);
    setValue(2, localParcel);
  }
}
