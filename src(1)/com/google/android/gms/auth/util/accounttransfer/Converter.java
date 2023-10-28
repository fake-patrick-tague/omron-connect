package com.google.android.gms.auth.util.accounttransfer;

final class Converter
  extends com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zza<com.google.android.gms.auth.api.accounttransfer.DeviceMetaData>
{
  Converter(Email paramEmail, AccountTransferClient.zzb paramZzb)
  {
    super(paramZzb);
  }
  
  public final void close(DeviceMetaData paramDeviceMetaData)
  {
    zzas.setResult(paramDeviceMetaData);
  }
}
