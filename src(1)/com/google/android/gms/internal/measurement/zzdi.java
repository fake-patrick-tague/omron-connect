package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class zzdi
  implements ThreadFactory
{
  private final ThreadFactory baseFactory = Executors.defaultThreadFactory();
  
  zzdi(zzee paramZzee) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = baseFactory.newThread(paramRunnable);
    paramRunnable.setName("ScionFrontendApi");
    return paramRunnable;
  }
}
