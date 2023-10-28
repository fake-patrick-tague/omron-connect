package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.package_12.Status;

@KeepForSdk
public abstract interface StatusExceptionMapper
{
  public abstract Exception getException(Status paramStatus);
}
