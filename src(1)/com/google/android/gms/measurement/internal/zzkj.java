package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

final class zzkj
{
  private long startTime;
  private final Clock this$0;
  
  public zzkj(Clock paramClock)
  {
    Preconditions.checkNotNull(paramClock);
    this$0 = paramClock;
  }
  
  public final void close()
  {
    startTime = 0L;
  }
  
  public final void onCreate()
  {
    startTime = this$0.elapsedRealtime();
  }
  
  public final boolean update(long paramLong)
  {
    if (startTime == 0L) {
      return true;
    }
    return this$0.elapsedRealtime() - startTime >= 3600000L;
  }
}
