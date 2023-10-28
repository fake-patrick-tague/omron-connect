package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.base.Log;
import com.google.android.gms.internal.base.Transport;

public final class Macro
  extends Transport
  implements IInterface
{
  Macro(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
  }
  
  public final void init(TelemetryData paramTelemetryData)
    throws RemoteException
  {
    Parcel localParcel = next();
    Log.writeValue(localParcel, paramTelemetryData);
    reset(1, localParcel);
  }
}
