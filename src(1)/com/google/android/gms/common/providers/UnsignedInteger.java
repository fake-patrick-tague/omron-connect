package com.google.android.gms.common.providers;

import com.google.android.gms.internal.common.InjectionPoint;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class UnsignedInteger
  implements PooledExecutorsProvider.PooledExecutorFactory
{
  UnsignedInteger() {}
  
  public final ScheduledExecutorService newSingleThreadScheduledExecutor()
  {
    InjectionPoint.forConstructorOf();
    return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
  }
}
