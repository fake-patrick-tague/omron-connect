package com.android.volley;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher
  extends Thread
{
  private final Cache mCache;
  private final ResponseDelivery mDelivery;
  private final Network mNetwork;
  private final BlockingQueue<Request<?>> mQueue;
  private volatile boolean mQuit = false;
  
  public NetworkDispatcher(BlockingQueue paramBlockingQueue, Network paramNetwork, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    mQueue = paramBlockingQueue;
    mNetwork = paramNetwork;
    mCache = paramCache;
    mDelivery = paramResponseDelivery;
  }
  
  private void addTrafficStatsTag(Request paramRequest)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramRequest.getTrafficStatsTag());
    }
  }
  
  private void parseAndDeliverNetworkError(Request paramRequest, VolleyError paramVolleyError)
  {
    paramVolleyError = paramRequest.parseNetworkError(paramVolleyError);
    mDelivery.postError(paramRequest, paramVolleyError);
  }
  
  private void processRequest()
    throws InterruptedException
  {
    processRequest((Request)mQueue.take());
  }
  
  void processRequest(Request paramRequest)
  {
    long l1 = SystemClock.elapsedRealtime();
    paramRequest.sendEvent(3);
    try
    {
      paramRequest.addMarker("network-queue-take");
      boolean bool = paramRequest.isCanceled();
      if (bool)
      {
        paramRequest.finish("network-discard-cancelled");
        paramRequest.notifyListenerResponseNotUsable();
        paramRequest.sendEvent(4);
        return;
      }
      addTrafficStatsTag(paramRequest);
      Object localObject1 = mNetwork;
      localObject1 = ((Network)localObject1).performRequest(paramRequest);
      paramRequest.addMarker("network-http-complete");
      bool = notModified;
      if (bool)
      {
        bool = paramRequest.hasHadResponseDelivered();
        if (bool)
        {
          paramRequest.finish("not-modified");
          paramRequest.notifyListenerResponseNotUsable();
          paramRequest.sendEvent(4);
          return;
        }
      }
      localObject1 = paramRequest.parseNetworkResponse((NetworkResponse)localObject1);
      paramRequest.addMarker("network-parse-complete");
      bool = paramRequest.shouldCache();
      if (bool)
      {
        localObject2 = cacheEntry;
        if (localObject2 != null)
        {
          localObject2 = mCache;
          String str = paramRequest.getCacheKey();
          Cache.Entry localEntry = cacheEntry;
          ((Cache)localObject2).put(str, localEntry);
          paramRequest.addMarker("network-cache-written");
        }
      }
      paramRequest.markDelivered();
      Object localObject2 = mDelivery;
      ((ResponseDelivery)localObject2).postResponse(paramRequest, (Response)localObject1);
      paramRequest.notifyListenerResponseReceived((Response)localObject1);
    }
    catch (Throwable localThrowable)
    {
      break label316;
    }
    catch (Exception localException)
    {
      VolleyLog.e(localException, "Unhandled exception %s", new Object[] { ((Exception)localException).toString() });
      VolleyError localVolleyError1 = new VolleyError(localException);
      l2 = SystemClock.elapsedRealtime();
      localVolleyError1.setNetworkTimeMs(l2 - l1);
      mDelivery.postError(paramRequest, localVolleyError1);
      paramRequest.notifyListenerResponseNotUsable();
    }
    catch (VolleyError localVolleyError2)
    {
      long l2 = SystemClock.elapsedRealtime();
      localVolleyError2.setNetworkTimeMs(l2 - l1);
      parseAndDeliverNetworkError(paramRequest, localVolleyError2);
      paramRequest.notifyListenerResponseNotUsable();
    }
    paramRequest.sendEvent(4);
    return;
    label316:
    paramRequest.sendEvent(4);
    throw localVolleyError2;
  }
  
  public void quit()
  {
    mQuit = true;
    interrupt();
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    for (;;)
    {
      try
      {
        processRequest();
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
      }
      if (mQuit)
      {
        Thread.currentThread().interrupt();
        return;
      }
      VolleyLog.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
    }
  }
}
