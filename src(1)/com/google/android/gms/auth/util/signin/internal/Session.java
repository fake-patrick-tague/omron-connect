package com.google.android.gms.auth.util.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions;
import com.google.android.gms.internal.auth-api.Attribute;
import com.google.android.gms.internal.auth-api.Cache;

public final class Session
  extends Attribute
  implements IInterface
{
  Session(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
  }
  
  public final void clear(Transaction paramTransaction, GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramTransaction);
    Cache.remove(localParcel, paramGoogleSignInOptions);
    setValue(102, localParcel);
  }
  
  public final void get(Transaction paramTransaction, GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramTransaction);
    Cache.remove(localParcel, paramGoogleSignInOptions);
    setValue(101, localParcel);
  }
  
  public final void setAttribute(Transaction paramTransaction, GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramTransaction);
    Cache.remove(localParcel, paramGoogleSignInOptions);
    setValue(103, localParcel);
  }
}
