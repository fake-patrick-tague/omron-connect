package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.IExtensionHost.Stub;

public abstract class zzae
  extends IExtensionHost.Stub
  implements zzaf
{
  public static zzaf asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
    if ((localIInterface instanceof zzaf)) {
      return (zzaf)localIInterface;
    }
    return new zzad(paramIBinder);
  }
}
