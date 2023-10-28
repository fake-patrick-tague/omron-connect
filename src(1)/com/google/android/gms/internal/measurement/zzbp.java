package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbp
  extends zzbm
  implements zzbr
{
  zzbp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
  }
  
  public final Bundle getSkuDetails(Bundle paramBundle)
    throws RemoteException
  {
    Object localObject = next();
    zzbo.get((Parcel)localObject, paramBundle);
    paramBundle = get(1, (Parcel)localObject);
    localObject = (Bundle)zzbo.get(paramBundle, Bundle.CREATOR);
    paramBundle.recycle();
    return localObject;
  }
}
