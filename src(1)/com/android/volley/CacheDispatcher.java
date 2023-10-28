package com.android.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher
  extends Thread
{
  private static final boolean DEBUG = VolleyLog.DEBUG;
  private final Cache mCache;
  private final BlockingQueue<Request<?>> mCacheQueue;
  private final ResponseDelivery mDelivery;
  private final BlockingQueue<Request<?>> mNetworkQueue;
  private volatile boolean mQuit = false;
  private final WaitingRequestManager mWaitingRequestManager;
  
  public CacheDispatcher(BlockingQueue paramBlockingQueue1, BlockingQueue paramBlockingQueue2, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    mCacheQueue = paramBlockingQueue1;
    mNetworkQueue = paramBlockingQueue2;
    mCache = paramCache;
    mDelivery = paramResponseDelivery;
    mWaitingRequestManager = new WaitingRequestManager(this, paramBlockingQueue2, paramResponseDelivery);
  }
  
  private void processRequest()
    throws InterruptedException
  {
    processRequest((Request)mCacheQueue.take());
  }
  
  void processRequest(final Request paramRequest)
    throws InterruptedException
  {
    paramRequest.addMarker("cache-queue-take");
    paramRequest.sendEvent(1);
    try
    {
      boolean bool = paramRequest.isCanceled();
      if (bool)
      {
        paramRequest.finish("cache-discard-canceled");
        paramRequest.sendEvent(2);
        return;
      }
      Cache.Entry localEntry = mCache.get(paramRequest.getCacheKey());
      if (localEntry == null)
      {
        paramRequest.addMarker("cache-miss");
        bool = mWaitingRequestManager.maybeAddToWaitingRequests(paramRequest);
        if (!bool) {
          mNetworkQueue.put(paramRequest);
        }
        paramRequest.sendEvent(2);
        return;
      }
      long l = System.currentTimeMillis();
      bool = localEntry.isExpired(l);
      if (bool)
      {
        paramRequest.addMarker("cache-hit-expired");
        paramRequest.setCacheEntry(localEntry);
        bool = mWaitingRequestManager.maybeAddToWaitingRequests(paramRequest);
        if (!bool) {
          mNetworkQueue.put(paramRequest);
        }
        paramRequest.sendEvent(2);
        return;
      }
      paramRequest.addMarker("cache-hit");
      Response localResponse = paramRequest.parseNetworkResponse(new NetworkResponse(data, responseHeaders));
      paramRequest.addMarker("cache-hit-parsed");
      bool = localResponse.isSuccess();
      if (!bool)
      {
        paramRequest.addMarker("cache-parsing-failed");
        mCache.invalidate(paramRequest.getCacheKey(), true);
        paramRequest.setCacheEntry(null);
        bool = mWaitingRequestManager.maybeAddToWaitingRequests(paramRequest);
        if (!bool) {
          mNetworkQueue.put(paramRequest);
        }
        paramRequest.sendEvent(2);
        return;
      }
      bool = localEntry.refreshNeeded(l);
      if (!bool)
      {
        mDelivery.postResponse(paramRequest, localResponse);
      }
      else
      {
        paramRequest.addMarker("cache-hit-refresh-needed");
        paramRequest.setCacheEntry(localEntry);
        intermediate = true;
        bool = mWaitingRequestManager.maybeAddToWaitingRequests(paramRequest);
        if (!bool) {
          mDelivery.postResponse(paramRequest, localResponse, new Runnable()
          {
            public void run()
            {
              Object localObject = CacheDispatcher.this;
              try
              {
                localObject = mNetworkQueue;
                Request localRequest = paramRequest;
                ((BlockingQueue)localObject).put(localRequest);
                return;
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;) {}
              }
              Thread.currentThread().interrupt();
            }
          });
        } else {
          mDelivery.postResponse(paramRequest, localResponse);
        }
      }
      paramRequest.sendEvent(2);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRequest.sendEvent(2);
      throw localThrowable;
    }
  }
  
  public void quit()
  {
    mQuit = true;
    interrupt();
  }
  
  public void run()
  {
    if (DEBUG) {
      VolleyLog.v("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    mCache.initialize();
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
      VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
    }
  }
}
