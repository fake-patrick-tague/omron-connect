package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AsyncRequestQueue
  extends RequestQueue
{
  private static final int DEFAULT_BLOCKING_THREAD_POOL_SIZE = 4;
  private final AsyncCache mAsyncCache;
  private ExecutorService mBlockingExecutor;
  private final Object mCacheInitializationLock = new Object[0];
  private ExecutorFactory mExecutorFactory;
  private volatile boolean mIsCacheInitialized = false;
  private final AsyncNetwork mNetwork;
  private ExecutorService mNonBlockingExecutor;
  private ScheduledExecutorService mNonBlockingScheduledExecutor;
  private final List<Request<?>> mRequestsAwaitingCacheInitialization = new ArrayList();
  private final WaitingRequestManager mWaitingRequestManager = new WaitingRequestManager(this);
  
  private AsyncRequestQueue(Cache paramCache, AsyncNetwork paramAsyncNetwork, AsyncCache paramAsyncCache, ResponseDelivery paramResponseDelivery, ExecutorFactory paramExecutorFactory)
  {
    super(paramCache, paramAsyncNetwork, 0, paramResponseDelivery);
    mAsyncCache = paramAsyncCache;
    mNetwork = paramAsyncNetwork;
    mExecutorFactory = paramExecutorFactory;
  }
  
  private void finishRequest(Request paramRequest, Response paramResponse, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramRequest.addMarker("network-cache-written");
    }
    paramRequest.markDelivered();
    getResponseDelivery().postResponse(paramRequest, paramResponse);
    paramRequest.notifyListenerResponseReceived(paramResponse);
  }
  
  private static PriorityBlockingQueue getBlockingQueue()
  {
    new PriorityBlockingQueue(11, new Comparator()
    {
      public int compare(Runnable paramAnonymousRunnable1, Runnable paramAnonymousRunnable2)
      {
        if ((paramAnonymousRunnable1 instanceof RequestTask))
        {
          if ((paramAnonymousRunnable2 instanceof RequestTask)) {
            return ((RequestTask)paramAnonymousRunnable1).compareTo((RequestTask)paramAnonymousRunnable2);
          }
          return 1;
        }
        if ((paramAnonymousRunnable2 instanceof RequestTask)) {
          return -1;
        }
        return 0;
      }
    });
  }
  
  private void handleEntry(Cache.Entry paramEntry, Request paramRequest)
  {
    if (paramEntry == null)
    {
      paramRequest.addMarker("cache-miss");
      if (!mWaitingRequestManager.maybeAddToWaitingRequests(paramRequest)) {
        sendRequestOverNetwork(paramRequest);
      }
    }
    else
    {
      long l = System.currentTimeMillis();
      if (paramEntry.isExpired(l))
      {
        paramRequest.addMarker("cache-hit-expired");
        paramRequest.setCacheEntry(paramEntry);
        if (!mWaitingRequestManager.maybeAddToWaitingRequests(paramRequest)) {
          sendRequestOverNetwork(paramRequest);
        }
      }
      else
      {
        mBlockingExecutor.execute(new CacheParseTask(paramRequest, paramEntry, l));
      }
    }
  }
  
  private void onCacheInitializationComplete()
  {
    Object localObject = mCacheInitializationLock;
    try
    {
      ArrayList localArrayList = new ArrayList(mRequestsAwaitingCacheInitialization);
      mRequestsAwaitingCacheInitialization.clear();
      mIsCacheInitialized = true;
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        beginRequest((Request)((Iterator)localObject).next());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void beginRequest(Request paramRequest)
  {
    if (!mIsCacheInitialized)
    {
      Object localObject = mCacheInitializationLock;
      try
      {
        if (!mIsCacheInitialized)
        {
          mRequestsAwaitingCacheInitialization.add(paramRequest);
          return;
        }
      }
      catch (Throwable paramRequest)
      {
        throw paramRequest;
      }
    }
    if (paramRequest.shouldCache())
    {
      if (mAsyncCache != null)
      {
        mNonBlockingExecutor.execute(new CacheTask(paramRequest));
        return;
      }
      mBlockingExecutor.execute(new CacheTask(paramRequest));
      return;
    }
    sendRequestOverNetwork(paramRequest);
  }
  
  void sendRequestOverNetwork(Request paramRequest)
  {
    mNonBlockingExecutor.execute(new NetworkTask(paramRequest));
  }
  
  public void start()
  {
    stop();
    mNonBlockingExecutor = mExecutorFactory.createNonBlockingExecutor(getBlockingQueue());
    mBlockingExecutor = mExecutorFactory.createBlockingExecutor(getBlockingQueue());
    mNonBlockingScheduledExecutor = mExecutorFactory.createNonBlockingScheduledExecutor();
    mNetwork.setBlockingExecutor(mBlockingExecutor);
    mNetwork.setNonBlockingExecutor(mNonBlockingExecutor);
    mNetwork.setNonBlockingScheduledExecutor(mNonBlockingScheduledExecutor);
    if (mAsyncCache != null)
    {
      mNonBlockingExecutor.execute(new Runnable()
      {
        public void run()
        {
          mAsyncCache.initialize(new AsyncCache.OnWriteCompleteCallback()
          {
            public void onWriteComplete()
            {
              AsyncRequestQueue.this.onCacheInitializationComplete();
            }
          });
        }
      });
      return;
    }
    mBlockingExecutor.execute(new Runnable()
    {
      public void run()
      {
        getCache().initialize();
        mNonBlockingExecutor.execute(new Runnable()
        {
          public void run()
          {
            AsyncRequestQueue.this.onCacheInitializationComplete();
          }
        });
      }
    });
  }
  
  public void stop()
  {
    Object localObject = mNonBlockingExecutor;
    if (localObject != null)
    {
      ((ExecutorService)localObject).shutdownNow();
      mNonBlockingExecutor = null;
    }
    localObject = mBlockingExecutor;
    if (localObject != null)
    {
      ((ExecutorService)localObject).shutdownNow();
      mBlockingExecutor = null;
    }
    localObject = mNonBlockingScheduledExecutor;
    if (localObject != null)
    {
      ((ScheduledExecutorService)localObject).shutdownNow();
      mNonBlockingScheduledExecutor = null;
    }
  }
  
  public static class Builder
  {
    private AsyncCache mAsyncCache = null;
    private Cache mCache = null;
    private AsyncRequestQueue.ExecutorFactory mExecutorFactory = null;
    private final AsyncNetwork mNetwork;
    private ResponseDelivery mResponseDelivery = null;
    
    public Builder(AsyncNetwork paramAsyncNetwork)
    {
      if (paramAsyncNetwork != null)
      {
        mNetwork = paramAsyncNetwork;
        return;
      }
      throw new IllegalArgumentException("Network cannot be null");
    }
    
    private AsyncRequestQueue.ExecutorFactory getDefaultExecutorFactory()
    {
      new AsyncRequestQueue.ExecutorFactory()
      {
        private ThreadPoolExecutor getNewThreadPoolExecutor(int paramAnonymousInt, String paramAnonymousString, BlockingQueue paramAnonymousBlockingQueue)
        {
          return new ThreadPoolExecutor(0, paramAnonymousInt, 60L, TimeUnit.SECONDS, paramAnonymousBlockingQueue, getThreadFactory(paramAnonymousString));
        }
        
        private ThreadFactory getThreadFactory(final String paramAnonymousString)
        {
          new ThreadFactory()
          {
            public Thread newThread(Runnable paramAnonymous2Runnable)
            {
              paramAnonymous2Runnable = Executors.defaultThreadFactory().newThread(paramAnonymous2Runnable);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Volley-");
              localStringBuilder.append(paramAnonymousString);
              paramAnonymous2Runnable.setName(localStringBuilder.toString());
              return paramAnonymous2Runnable;
            }
          };
        }
        
        public ExecutorService createBlockingExecutor(BlockingQueue paramAnonymousBlockingQueue)
        {
          return getNewThreadPoolExecutor(4, "BlockingExecutor", paramAnonymousBlockingQueue);
        }
        
        public ExecutorService createNonBlockingExecutor(BlockingQueue paramAnonymousBlockingQueue)
        {
          return getNewThreadPoolExecutor(1, "Non-BlockingExecutor", paramAnonymousBlockingQueue);
        }
        
        public ScheduledExecutorService createNonBlockingScheduledExecutor()
        {
          return new ScheduledThreadPoolExecutor(0, getThreadFactory("ScheduledExecutor"));
        }
      };
    }
    
    public AsyncRequestQueue build()
    {
      Cache localCache = mCache;
      if ((localCache == null) && (mAsyncCache == null)) {
        throw new IllegalArgumentException("You must set one of the cache objects");
      }
      if (localCache == null) {
        mCache = new AsyncRequestQueue.ThrowingCache(null);
      }
      if (mResponseDelivery == null) {
        mResponseDelivery = new ExecutorDelivery(new Handler(Looper.getMainLooper()));
      }
      if (mExecutorFactory == null) {
        mExecutorFactory = getDefaultExecutorFactory();
      }
      return new AsyncRequestQueue(mCache, mNetwork, mAsyncCache, mResponseDelivery, mExecutorFactory, null);
    }
    
    public Builder setAsyncCache(AsyncCache paramAsyncCache)
    {
      mAsyncCache = paramAsyncCache;
      return this;
    }
    
    public Builder setCache(Cache paramCache)
    {
      mCache = paramCache;
      return this;
    }
    
    public Builder setExecutorFactory(AsyncRequestQueue.ExecutorFactory paramExecutorFactory)
    {
      mExecutorFactory = paramExecutorFactory;
      return this;
    }
    
    public Builder setResponseDelivery(ResponseDelivery paramResponseDelivery)
    {
      mResponseDelivery = paramResponseDelivery;
      return this;
    }
  }
  
  private class CacheParseTask<T>
    extends RequestTask<T>
  {
    Cache.Entry entry;
    long startTimeMillis;
    
    CacheParseTask(Request paramRequest, Cache.Entry paramEntry, long paramLong)
    {
      super();
      entry = paramEntry;
      startTimeMillis = paramLong;
    }
    
    public void run()
    {
      mRequest.addMarker("cache-hit");
      Object localObject = mRequest;
      Cache.Entry localEntry = entry;
      localObject = ((Request)localObject).parseNetworkResponse(new NetworkResponse(200, data, false, 0L, allResponseHeaders));
      mRequest.addMarker("cache-hit-parsed");
      if (!entry.refreshNeeded(startTimeMillis))
      {
        getResponseDelivery().postResponse(mRequest, (Response)localObject);
        return;
      }
      mRequest.addMarker("cache-hit-refresh-needed");
      mRequest.setCacheEntry(entry);
      intermediate = true;
      if (!mWaitingRequestManager.maybeAddToWaitingRequests(mRequest))
      {
        getResponseDelivery().postResponse(mRequest, (Response)localObject, new Runnable()
        {
          public void run()
          {
            AsyncRequestQueue.CacheParseTask localCacheParseTask = AsyncRequestQueue.CacheParseTask.this;
            this$0.sendRequestOverNetwork(mRequest);
          }
        });
        return;
      }
      getResponseDelivery().postResponse(mRequest, (Response)localObject);
    }
  }
  
  private class CachePutTask<T>
    extends RequestTask<T>
  {
    Response<?> response;
    
    CachePutTask(Request paramRequest, Response paramResponse)
    {
      super();
      response = paramResponse;
    }
    
    public void run()
    {
      if (mAsyncCache != null)
      {
        mAsyncCache.put(mRequest.getCacheKey(), response.cacheEntry, new AsyncCache.OnWriteCompleteCallback()
        {
          public void onWriteComplete()
          {
            AsyncRequestQueue.CachePutTask localCachePutTask = AsyncRequestQueue.CachePutTask.this;
            this$0.finishRequest(mRequest, response, true);
          }
        });
        return;
      }
      getCache().put(mRequest.getCacheKey(), response.cacheEntry);
      AsyncRequestQueue.this.finishRequest(mRequest, response, true);
    }
  }
  
  private class CacheTask<T>
    extends RequestTask<T>
  {
    CacheTask(Request paramRequest)
    {
      super();
    }
    
    public void run()
    {
      if (mRequest.isCanceled())
      {
        mRequest.finish("cache-discard-canceled");
        return;
      }
      mRequest.addMarker("cache-queue-take");
      if (mAsyncCache != null)
      {
        mAsyncCache.loop(mRequest.getCacheKey(), new AsyncCache.OnGetCompleteCallback()
        {
          public void onGetComplete(Cache.Entry paramAnonymousEntry)
          {
            AsyncRequestQueue.CacheTask localCacheTask = AsyncRequestQueue.CacheTask.this;
            this$0.handleEntry(paramAnonymousEntry, mRequest);
          }
        });
        return;
      }
      Cache.Entry localEntry = getCache().get(mRequest.getCacheKey());
      AsyncRequestQueue.this.handleEntry(localEntry, mRequest);
    }
  }
  
  public static abstract class ExecutorFactory
  {
    public ExecutorFactory() {}
    
    public abstract ExecutorService createBlockingExecutor(BlockingQueue paramBlockingQueue);
    
    public abstract ExecutorService createNonBlockingExecutor(BlockingQueue paramBlockingQueue);
    
    public abstract ScheduledExecutorService createNonBlockingScheduledExecutor();
  }
  
  private class NetworkParseTask<T>
    extends RequestTask<T>
  {
    NetworkResponse networkResponse;
    
    NetworkParseTask(Request paramRequest, NetworkResponse paramNetworkResponse)
    {
      super();
      networkResponse = paramNetworkResponse;
    }
    
    public void run()
    {
      Response localResponse = mRequest.parseNetworkResponse(networkResponse);
      mRequest.addMarker("network-parse-complete");
      if ((mRequest.shouldCache()) && (cacheEntry != null))
      {
        if (mAsyncCache != null)
        {
          mNonBlockingExecutor.execute(new AsyncRequestQueue.CachePutTask(AsyncRequestQueue.this, mRequest, localResponse));
          return;
        }
        mBlockingExecutor.execute(new AsyncRequestQueue.CachePutTask(AsyncRequestQueue.this, mRequest, localResponse));
        return;
      }
      AsyncRequestQueue.this.finishRequest(mRequest, localResponse, false);
    }
  }
  
  private class NetworkTask<T>
    extends RequestTask<T>
  {
    NetworkTask(Request paramRequest)
    {
      super();
    }
    
    public void run()
    {
      if (mRequest.isCanceled())
      {
        mRequest.finish("network-discard-cancelled");
        mRequest.notifyListenerResponseNotUsable();
        return;
      }
      final long l = SystemClock.elapsedRealtime();
      mRequest.addMarker("network-queue-take");
      mNetwork.performRequest(mRequest, new AsyncNetwork.OnRequestComplete()
      {
        public void onError(VolleyError paramAnonymousVolleyError)
        {
          paramAnonymousVolleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - l);
          ExecutorService localExecutorService = mBlockingExecutor;
          AsyncRequestQueue.NetworkTask localNetworkTask = AsyncRequestQueue.NetworkTask.this;
          localExecutorService.execute(new AsyncRequestQueue.ParseErrorTask(this$0, mRequest, paramAnonymousVolleyError));
        }
        
        public void onSuccess(NetworkResponse paramAnonymousNetworkResponse)
        {
          mRequest.addMarker("network-http-complete");
          if ((notModified) && (mRequest.hasHadResponseDelivered()))
          {
            mRequest.finish("not-modified");
            mRequest.notifyListenerResponseNotUsable();
            return;
          }
          ExecutorService localExecutorService = mBlockingExecutor;
          AsyncRequestQueue.NetworkTask localNetworkTask = AsyncRequestQueue.NetworkTask.this;
          localExecutorService.execute(new AsyncRequestQueue.NetworkParseTask(this$0, mRequest, paramAnonymousNetworkResponse));
        }
      });
    }
  }
  
  private class ParseErrorTask<T>
    extends RequestTask<T>
  {
    VolleyError volleyError;
    
    ParseErrorTask(Request paramRequest, VolleyError paramVolleyError)
    {
      super();
      volleyError = paramVolleyError;
    }
    
    public void run()
    {
      VolleyError localVolleyError = mRequest.parseNetworkError(volleyError);
      getResponseDelivery().postError(mRequest, localVolleyError);
      mRequest.notifyListenerResponseNotUsable();
    }
  }
  
  private static class ThrowingCache
    implements Cache
  {
    private ThrowingCache() {}
    
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
    
    public Cache.Entry get(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public void initialize()
    {
      throw new UnsupportedOperationException();
    }
    
    public void invalidate(String paramString, boolean paramBoolean)
    {
      throw new UnsupportedOperationException();
    }
    
    public void put(String paramString, Cache.Entry paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    public void remove(String paramString)
    {
      throw new UnsupportedOperationException();
    }
  }
}
