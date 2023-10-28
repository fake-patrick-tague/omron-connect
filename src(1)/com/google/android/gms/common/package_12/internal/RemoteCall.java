package com.google.android.gms.common.package_12.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract interface RemoteCall<T, U>
{
  public abstract void accept(Object paramObject1, Object paramObject2)
    throws RemoteException;
}
