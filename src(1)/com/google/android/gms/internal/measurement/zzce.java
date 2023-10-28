package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzce
  extends zzbn
  implements zzcf
{
  public zzce()
  {
    super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
  }
  
  protected final boolean getFromLocationName(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      Bundle localBundle = (Bundle)zzbo.get(paramParcel1, Bundle.CREATOR);
      zzbo.writeString(paramParcel1);
      append(localBundle);
      paramParcel2.writeNoException();
      return true;
    }
    return false;
  }
}
