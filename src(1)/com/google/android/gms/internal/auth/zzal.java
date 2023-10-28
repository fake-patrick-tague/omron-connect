package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.util.proxy.ProxyResponse;

public abstract interface zzal
  extends IInterface
{
  public abstract void Update(ProxyResponse paramProxyResponse)
    throws RemoteException;
  
  public abstract void Update(String paramString)
    throws RemoteException;
}
