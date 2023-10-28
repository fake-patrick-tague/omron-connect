package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.proxy.ProxyResponse;

public abstract class zzam
  extends IExtensionHost.Stub
  implements zzal
{
  public zzam()
  {
    super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return false;
      }
      Update(paramParcel1.readString());
    }
    else
    {
      Update((ProxyResponse)Log.get(paramParcel1, ProxyResponse.CREATOR));
    }
    paramParcel2.writeNoException();
    return true;
  }
}
