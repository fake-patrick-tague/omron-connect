package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.PendingResults;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public final class zzen
  implements BleApi
{
  public static final Status zzqh = new Status(5007);
  
  public zzen() {}
  
  public final PendingResult claimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return PendingResults.immediatePendingResult(zzqh, paramGoogleApiClient);
  }
  
  public final PendingResult claimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return PendingResults.immediatePendingResult(zzqh, paramGoogleApiClient);
  }
  
  public final PendingResult listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    return PendingResults.immediateFailedResult(BleDevicesResult.parseComments(zzqh), paramGoogleApiClient);
  }
  
  public final PendingResult startBleScan(GoogleApiClient paramGoogleApiClient, StartBleScanRequest paramStartBleScanRequest)
  {
    return PendingResults.immediatePendingResult(zzqh, paramGoogleApiClient);
  }
  
  public final PendingResult stopBleScan(GoogleApiClient paramGoogleApiClient, BleScanCallback paramBleScanCallback)
  {
    return PendingResults.immediatePendingResult(zzqh, paramGoogleApiClient);
  }
  
  public final PendingResult unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return PendingResults.immediatePendingResult(zzqh, paramGoogleApiClient);
  }
  
  public final PendingResult unclaimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return PendingResults.immediatePendingResult(zzqh, paramGoogleApiClient);
  }
}
