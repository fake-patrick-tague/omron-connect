package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.IDeathCallback_0_8.Stub;

public final class zzam
  extends IDeathCallback_0_8.Stub
{
  private final com.google.android.gms.common.api.internal.ListenerHolder<OnDataPointListener> zzrq;
  
  private zzam(com.google.android.gms.common.package_12.internal.ListenerHolder paramListenerHolder)
  {
    zzrq = ((com.google.android.gms.common.package_12.internal.ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
  }
  
  public final void openDB(DataPoint paramDataPoint)
  {
    zzrq.notifyListener(new zzal(this, paramDataPoint));
  }
  
  public final void release()
  {
    zzrq.clear();
  }
}
