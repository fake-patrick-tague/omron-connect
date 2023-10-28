package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzcd
  extends zzbm
  implements zzcf
{
  zzcd(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
  }
  
  public final void append(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramBundle);
    add(1, localParcel);
  }
}
