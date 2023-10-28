package com.google.android.gms.internal.auth-api;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.SavePasswordResult;
import com.google.android.gms.common.package_12.Status;

public abstract class zbae
  extends IExtensionHost.Stub
  implements zbaf
{
  public zbae()
  {
    super("com.google.android.gms.auth.api.identity.internal.ISavePasswordCallback");
  }
  
  protected final boolean get(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      convertStatus((Status)Cache.get(paramParcel1, Status.CREATOR), (SavePasswordResult)Cache.get(paramParcel1, SavePasswordResult.CREATOR));
      return true;
    }
    return false;
  }
}
