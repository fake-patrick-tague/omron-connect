package com.google.android.gms.common.internal;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public abstract interface Channel
{
  public abstract boolean isConnected();
}
