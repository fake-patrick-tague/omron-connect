package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;

public abstract interface BlockingQueue
  extends GoogleApiClient.ConnectionCallbacks
{
  public abstract void put(ConnectionResult paramConnectionResult, Attribute paramAttribute, boolean paramBoolean);
}
