package com.google.android.gms.internal.auth-api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;

public abstract class zbaa
  extends IExtensionHost.Stub
  implements zbab
{
  public zbaa()
  {
    super("com.google.android.gms.auth.api.identity.internal.IGetSignInIntentCallback");
  }
  
  protected final boolean get(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      convertStatus((Status)Cache.get(paramParcel1, Status.CREATOR), (PendingIntent)Cache.get(paramParcel1, PendingIntent.CREATOR));
      return true;
    }
    return false;
  }
}
