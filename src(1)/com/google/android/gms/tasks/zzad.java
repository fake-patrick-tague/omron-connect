package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzad<T>
  implements zzae<T>
{
  private final CountDownLatch ready = new CountDownLatch(1);
  
  private zzad() {}
  
  public final void await()
    throws InterruptedException
  {
    ready.await();
  }
  
  public final boolean await(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return ready.await(paramLong, paramTimeUnit);
  }
  
  public final void onCanceled()
  {
    ready.countDown();
  }
  
  public final void onFailure(Exception paramException)
  {
    ready.countDown();
  }
  
  public final void onSuccess(Object paramObject)
  {
    ready.countDown();
  }
}
