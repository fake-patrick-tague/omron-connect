package com.google.android.gms.drm.identifier;

import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class IRCConnection
  extends Thread
{
  private final WeakReference<com.google.android.gms.ads.identifier.AdvertisingIdClient> TAG;
  boolean isListening;
  final CountDownLatch localAddress;
  private final long timeout;
  
  public IRCConnection(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
  {
    TAG = new WeakReference(paramAdvertisingIdClient);
    timeout = paramLong;
    localAddress = new CountDownLatch(1);
    isListening = false;
    start();
  }
  
  private final void dispose()
  {
    AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)TAG.get();
    if (localAdvertisingIdClient != null)
    {
      localAdvertisingIdClient.close();
      isListening = true;
    }
  }
  
  public final void run()
  {
    CountDownLatch localCountDownLatch = localAddress;
    long l = timeout;
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    try
    {
      boolean bool = localCountDownLatch.await(l, localTimeUnit);
      if (bool) {
        return;
      }
      dispose();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    dispose();
    return;
  }
}
