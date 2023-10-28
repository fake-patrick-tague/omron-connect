package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbq
  extends zzbn
  implements zzbr
{
  public static zzbr asInterface(IBinder paramIBinder)
  {
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    if ((localIInterface instanceof zzbr)) {
      return (zzbr)localIInterface;
    }
    return new zzbp(paramIBinder);
  }
}
