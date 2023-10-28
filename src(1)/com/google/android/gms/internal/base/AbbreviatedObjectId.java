package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AbbreviatedObjectId
  implements Optional
{
  private AbbreviatedObjectId() {}
  
  public final ExecutorService get(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2)
  {
    paramThreadFactory = new ThreadPoolExecutor(paramInt1, paramInt1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
    paramThreadFactory.allowCoreThreadTimeOut(true);
    return Executors.unconfigurableExecutorService(paramThreadFactory);
  }
  
  public final ExecutorService toString(int paramInt1, int paramInt2)
  {
    return get(4, Executors.defaultThreadFactory(), 2);
  }
  
  public final ExecutorService toString(ThreadFactory paramThreadFactory, int paramInt)
  {
    return get(1, paramThreadFactory, 1);
  }
}
