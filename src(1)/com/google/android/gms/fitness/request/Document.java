package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.BleDevice;

public final class Document
  extends zzag
{
  private final com.google.android.gms.common.api.internal.ListenerHolder<BleScanCallback> zzqi;
  
  private Document(com.google.android.gms.common.package_12.internal.ListenerHolder paramListenerHolder)
  {
    zzqi = ((com.google.android.gms.common.package_12.internal.ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
  }
  
  public final void onDeviceFound(BleDevice paramBleDevice)
  {
    zzqi.notifyListener(new Target(this, paramBleDevice));
  }
  
  public final void onScanStopped()
  {
    zzqi.notifyListener(new RequestListener(this));
  }
  
  public final void release()
  {
    zzqi.clear();
  }
}
