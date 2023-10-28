package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzcg
  extends zzbm
  implements zzci
{
  zzcg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
  }
  
  public final int get()
    throws RemoteException
  {
    Parcel localParcel = get(2, next());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
  
  public final void sendHit(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.get(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    add(1, localParcel);
  }
}
