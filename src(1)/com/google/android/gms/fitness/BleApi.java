package com.google.android.gms.fitness;

import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;

@Deprecated
public abstract interface BleApi
{
  public abstract PendingResult claimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice);
  
  public abstract PendingResult claimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult listClaimedBleDevices(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult startBleScan(GoogleApiClient paramGoogleApiClient, StartBleScanRequest paramStartBleScanRequest);
  
  public abstract PendingResult stopBleScan(GoogleApiClient paramGoogleApiClient, BleScanCallback paramBleScanCallback);
  
  public abstract PendingResult unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice);
  
  public abstract PendingResult unclaimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString);
}
