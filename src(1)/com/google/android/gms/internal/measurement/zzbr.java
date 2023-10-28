package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzbr
  extends IInterface
{
  public abstract Bundle getSkuDetails(Bundle paramBundle)
    throws RemoteException;
}
