package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.util.proxy.ProxyRequest;

public abstract interface zzan
  extends IInterface
{
  public abstract void lock(zzal paramZzal, ProxyRequest paramProxyRequest)
    throws RemoteException;
  
  public abstract void output(zzal paramZzal)
    throws RemoteException;
}
