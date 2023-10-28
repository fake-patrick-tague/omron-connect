package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
public abstract class DataHolderNotifier<L>
  implements ListenerHolder.Notifier<L>
{
  private final DataHolder packet;
  
  protected DataHolderNotifier(DataHolder paramDataHolder)
  {
    packet = paramDataHolder;
  }
  
  public final void notifyListener(Object paramObject)
  {
    notifyListener(paramObject, packet);
  }
  
  protected abstract void notifyListener(Object paramObject, DataHolder paramDataHolder);
  
  public void onNotifyListenerFailed()
  {
    DataHolder localDataHolder = packet;
    if (localDataHolder != null) {
      localDataHolder.close();
    }
  }
}
