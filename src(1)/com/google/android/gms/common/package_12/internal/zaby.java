package com.google.android.gms.common.package_12.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.internal.base.Transport;

public final class zaby
  extends Transport
  implements IStatusCallback
{
  zaby(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
  }
  
  public final void onResult(Status paramStatus)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
