package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class StatusCallback
  extends IStatusCallback.Stub
{
  @KeepForSdk
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<com.google.android.gms.common.api.Status> mResultHolder;
  
  public StatusCallback(BaseImplementation.ResultHolder paramResultHolder)
  {
    mResultHolder = paramResultHolder;
  }
  
  public void onResult(com.google.android.gms.common.package_12.Status paramStatus)
  {
    mResultHolder.setResult(paramStatus);
  }
}
