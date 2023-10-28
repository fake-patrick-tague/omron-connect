package com.google.android.gms.internal.auth-api;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.package_12.Status;

public abstract class zbac
  extends IExtensionHost.Stub
  implements zbad
{
  public zbac()
  {
    super("com.google.android.gms.auth.api.identity.internal.ISaveAccountLinkingTokenCallback");
  }
  
  protected final boolean get(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      handleException((Status)Cache.get(paramParcel1, Status.CREATOR), (SaveAccountLinkingTokenResult)Cache.get(paramParcel1, SaveAccountLinkingTokenResult.CREATOR));
      return true;
    }
    return false;
  }
}
