package com.google.android.gms.internal.fitness;

import com.google.android.gms.fitness.result.BleDevicesResult;

final class zzcx
  extends zzep
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<BleDevicesResult> zzpa;
  
  private zzcx(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    zzpa = paramResultHolder;
  }
  
  public final void openDB(BleDevicesResult paramBleDevicesResult)
  {
    zzpa.setResult(paramBleDevicesResult);
  }
}
