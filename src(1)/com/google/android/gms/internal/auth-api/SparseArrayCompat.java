package com.google.android.gms.internal.auth-api;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.BeginSignInResult;
import com.google.android.gms.common.package_12.Status;

public abstract class SparseArrayCompat
  extends IExtensionHost.Stub
  implements Namespace
{
  public SparseArrayCompat()
  {
    super("com.google.android.gms.auth.api.identity.internal.IBeginSignInCallback");
  }
  
  protected final boolean get(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      convertStatus((Status)Cache.get(paramParcel1, Status.CREATOR), (BeginSignInResult)Cache.get(paramParcel1, BeginSignInResult.CREATOR));
      return true;
    }
    return false;
  }
}
