package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzci
  extends IInterface
{
  public abstract int get()
    throws RemoteException;
  
  public abstract void sendHit(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    throws RemoteException;
}
