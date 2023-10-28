package com.google.android.gms.internal.ads_identifier;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface IPlayMedia_0_8
  extends IInterface
{
  public abstract String getName()
    throws RemoteException;
  
  public abstract boolean release(boolean paramBoolean)
    throws RemoteException;
  
  public abstract boolean stop()
    throws RemoteException;
}
