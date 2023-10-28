package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.JSONObject;
import com.google.android.gms.internal.common.Log;

public final class zzaa
  extends Log
  implements IGmsCallbacks
{
  zzaa(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  public final void init(int paramInt, Bundle paramBundle)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeInt(paramInt);
    localParcel.writeStrongBinder(paramIBinder);
    JSONObject.write(localParcel, paramBundle);
    setText(1, localParcel);
  }
  
  public final void read(int paramInt, IBinder paramIBinder, MediaDescriptionCompat paramMediaDescriptionCompat)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
