package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.PendingResults;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;

public final class zzco
  implements BleApi
{
  public zzco() {}
  
  public final PendingResult claimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return paramGoogleApiClient.execute(new zzcs(this, paramGoogleApiClient, paramBleDevice));
  }
  
  public final PendingResult claimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.execute(new zzct(this, paramGoogleApiClient, paramString));
  }
  
  public final PendingResult listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.enqueue(new zzcu(this, paramGoogleApiClient));
  }
  
  public final PendingResult startBleScan(GoogleApiClient paramGoogleApiClient, StartBleScanRequest paramStartBleScanRequest)
  {
    return paramGoogleApiClient.enqueue(new zzcr(this, paramGoogleApiClient, paramStartBleScanRequest, com.google.android.gms.fitness.request.Status.parse().get((BleScanCallback)Preconditions.checkNotNull(paramStartBleScanRequest.zzaa()), paramGoogleApiClient.getLooper())));
  }
  
  public final PendingResult stopBleScan(GoogleApiClient paramGoogleApiClient, BleScanCallback paramBleScanCallback)
  {
    paramBleScanCallback = com.google.android.gms.fitness.request.Status.parse().read(paramBleScanCallback, paramGoogleApiClient.getLooper());
    if (paramBleScanCallback == null) {
      return PendingResults.immediatePendingResult(com.google.android.gms.common.package_12.Status.RESULT_SUCCESS, paramGoogleApiClient);
    }
    return paramGoogleApiClient.enqueue(new zzcq(this, paramGoogleApiClient, paramBleScanCallback));
  }
  
  public final PendingResult unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return unclaimBleDevice(paramGoogleApiClient, paramBleDevice.getAddress());
  }
  
  public final PendingResult unclaimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.execute(new zzcv(this, paramGoogleApiClient, paramString));
  }
}
