package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.fitness.data.BleDevice;

final class Target
  implements ListenerHolder.Notifier<BleScanCallback>
{
  Target(Document paramDocument, BleDevice paramBleDevice) {}
  
  public final void onNotifyListenerFailed() {}
}
