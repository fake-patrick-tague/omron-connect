package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface IGmsCallbacks
  extends IInterface
{
  public abstract void init(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void read(int paramInt, IBinder paramIBinder, MediaDescriptionCompat paramMediaDescriptionCompat)
    throws RemoteException;
}
