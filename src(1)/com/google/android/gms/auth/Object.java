package com.google.android.gms.auth;

import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

abstract interface Object<T>
{
  public abstract java.lang.Object doInBackground(IBinder paramIBinder)
    throws RemoteException, IOException, GoogleAuthException;
}
