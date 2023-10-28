package com.google.android.gms.internal.auth-api;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.credentials.Credential;
import com.google.android.gms.common.package_12.Status;

public abstract class Vector2D
  extends IExtensionHost.Stub
  implements Vector
{
  public Vector2D()
  {
    super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
  }
  
  protected final boolean get(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return false;
        }
        add((Status)Cache.get(paramParcel1, Status.CREATOR), paramParcel1.readString());
      }
      else
      {
        delete((Status)Cache.get(paramParcel1, Status.CREATOR));
      }
    }
    else {
      delete((Status)Cache.get(paramParcel1, Status.CREATOR), (Credential)Cache.get(paramParcel1, Credential.CREATOR));
    }
    paramParcel2.writeNoException();
    return true;
  }
}
