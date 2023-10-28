package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue
{
  private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
  private final Cache mCache;
  private CacheDispatcher mCacheDispatcher;
  private final PriorityBlockingQueue<Request<?>> mCacheQueue = new PriorityBlockingQueue();
  private final Set<Request<?>> mCurrentRequests = new HashSet();
  private final ResponseDelivery mDelivery;
  private final NetworkDispatcher[] mDispatchers;
  private final List<RequestEventListener> mEventListeners = new ArrayList();
  private final List<RequestFinishedListener> mFinishedListeners = new ArrayList();
  private final Network mNetwork;
  private final PriorityBlockingQueue<Request<?>> mNetworkQueue = new PriorityBlockingQueue();
  private final AtomicInteger mSequenceGenerator = new AtomicInteger();
  
  public RequestQueue(Cache paramCache, Network paramNetwork)
  {
    this(paramCache, paramNetwork, 4);
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt)
  {
    this(paramCache, paramNetwork, paramInt, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt, ResponseDelivery paramResponseDelivery)
  {
    mCache = paramCache;
    mNetwork = paramNetwork;
    mDispatchers = new NetworkDispatcher[paramInt];
    mDelivery = paramResponseDelivery;
  }
  
  public Request add(Request paramRequest)
  {
    paramRequest.setRequestQueue(this);
    Set localSet = mCurrentRequests;
    try
    {
      mCurrentRequests.add(paramRequest);
      paramRequest.setSequence(getSequenceNumber());
      paramRequest.addMarker("add-to-queue");
      sendRequestEvent(paramRequest, 0);
      beginRequest(paramRequest);
      return paramRequest;
    }
    catch (Throwable paramRequest)
    {
      throw paramRequest;
    }
  }
  
  public void addRequestEventListener(RequestEventListener paramRequestEventListener)
  {
    List localList = mEventListeners;
    try
    {
      mEventListeners.add(paramRequestEventListener);
      return;
    }
    catch (Throwable paramRequestEventListener)
    {
      throw paramRequestEventListener;
    }
  }
  
  public void addRequestFinishedListener(RequestFinishedListener paramRequestFinishedListener)
  {
    List localList = mFinishedListeners;
    try
    {
      mFinishedListeners.add(paramRequestFinishedListener);
      return;
    }
    catch (Throwable paramRequestFinishedListener)
    {
      throw paramRequestFinishedListener;
    }
  }
  
  void beginRequest(Request paramRequest)
  {
    if (!paramRequest.shouldCache())
    {
      sendRequestOverNetwork(paramRequest);
      return;
    }
    mCacheQueue.add(paramRequest);
  }
  
  public void cancelAll(RequestFilter paramRequestFilter)
  {
    Set localSet = mCurrentRequests;
    try
    {
      Iterator localIterator = mCurrentRequests.iterator();
      while (localIterator.hasNext())
      {
        Request localRequest = (Request)localIterator.next();
        if (paramRequestFilter.apply(localRequest)) {
          localRequest.cancel();
        }
      }
      return;
    }
    catch (Throwable paramRequestFilter)
    {
      throw paramRequestFilter;
    }
  }
  
  public void cancelAll(final Object paramObject)
  {
    if (paramObject != null)
    {
      cancelAll(new RequestFilter()
      {
        public boolean apply(Request paramAnonymousRequest)
        {
          return paramAnonymousRequest.getTag() == paramObject;
        }
      });
      return;
    }
    throw new IllegalArgumentException("Cannot cancelAll with a null tag");
  }
  
  /* Error */
  void finish(Request paramRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/android/volley/RequestQueue:mCurrentRequests	Ljava/util/Set;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 83	com/android/volley/RequestQueue:mCurrentRequests	Ljava/util/Set;
    //   11: aload_1
    //   12: invokeinterface 197 2 0
    //   17: pop
    //   18: aload_2
    //   19: monitorexit
    //   20: aload_0
    //   21: getfield 95	com/android/volley/RequestQueue:mFinishedListeners	Ljava/util/List;
    //   24: astore_2
    //   25: aload_2
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 95	com/android/volley/RequestQueue:mFinishedListeners	Ljava/util/List;
    //   31: invokeinterface 198 1 0
    //   36: astore_3
    //   37: aload_3
    //   38: invokeinterface 170 1 0
    //   43: ifeq +21 -> 64
    //   46: aload_3
    //   47: invokeinterface 174 1 0
    //   52: checkcast 17	com/android/volley/RequestQueue$RequestFinishedListener
    //   55: aload_1
    //   56: invokeinterface 201 2 0
    //   61: goto -24 -> 37
    //   64: aload_2
    //   65: monitorexit
    //   66: aload_0
    //   67: aload_1
    //   68: iconst_5
    //   69: invokevirtual 140	com/android/volley/RequestQueue:sendRequestEvent	(Lcom/android/volley/Request;I)V
    //   72: return
    //   73: astore_1
    //   74: aload_2
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	RequestQueue
    //   0	83	1	paramRequest	Request
    //   4	76	2	localObject	Object
    //   36	11	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   27	37	73	java/lang/Throwable
    //   37	61	73	java/lang/Throwable
    //   64	66	73	java/lang/Throwable
    //   74	76	73	java/lang/Throwable
    //   7	20	78	java/lang/Throwable
    //   79	81	78	java/lang/Throwable
  }
  
  public Cache getCache()
  {
    return mCache;
  }
  
  public ResponseDelivery getResponseDelivery()
  {
    return mDelivery;
  }
  
  public int getSequenceNumber()
  {
    return mSequenceGenerator.incrementAndGet();
  }
  
  public void removeRequestEventListener(RequestEventListener paramRequestEventListener)
  {
    List localList = mEventListeners;
    try
    {
      mEventListeners.remove(paramRequestEventListener);
      return;
    }
    catch (Throwable paramRequestEventListener)
    {
      throw paramRequestEventListener;
    }
  }
  
  public void removeRequestFinishedListener(RequestFinishedListener paramRequestFinishedListener)
  {
    List localList = mFinishedListeners;
    try
    {
      mFinishedListeners.remove(paramRequestFinishedListener);
      return;
    }
    catch (Throwable paramRequestFinishedListener)
    {
      throw paramRequestFinishedListener;
    }
  }
  
  void sendRequestEvent(Request paramRequest, int paramInt)
  {
    List localList = mEventListeners;
    try
    {
      Iterator localIterator = mEventListeners.iterator();
      while (localIterator.hasNext()) {
        ((RequestEventListener)localIterator.next()).onRequestEvent(paramRequest, paramInt);
      }
      return;
    }
    catch (Throwable paramRequest)
    {
      throw paramRequest;
    }
  }
  
  void sendRequestOverNetwork(Request paramRequest)
  {
    mNetworkQueue.add(paramRequest);
  }
  
  public void start()
  {
    stop();
    Object localObject = new CacheDispatcher(mCacheQueue, mNetworkQueue, mCache, mDelivery);
    mCacheDispatcher = ((CacheDispatcher)localObject);
    ((Thread)localObject).start();
    int i = 0;
    while (i < mDispatchers.length)
    {
      localObject = new NetworkDispatcher(mNetworkQueue, mNetwork, mCache, mDelivery);
      mDispatchers[i] = localObject;
      ((Thread)localObject).start();
      i += 1;
    }
  }
  
  public void stop()
  {
    Object localObject1 = mCacheDispatcher;
    if (localObject1 != null) {
      ((CacheDispatcher)localObject1).quit();
    }
    localObject1 = mDispatchers;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.quit();
      }
      i += 1;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RequestEvent
  {
    public static final int REQUEST_CACHE_LOOKUP_FINISHED = 2;
    public static final int REQUEST_CACHE_LOOKUP_STARTED = 1;
    public static final int REQUEST_FINISHED = 5;
    public static final int REQUEST_NETWORK_DISPATCH_FINISHED = 4;
    public static final int REQUEST_NETWORK_DISPATCH_STARTED = 3;
    public static final int REQUEST_QUEUED = 0;
  }
  
  public static abstract interface RequestEventListener
  {
    public abstract void onRequestEvent(Request paramRequest, int paramInt);
  }
  
  public static abstract interface RequestFilter
  {
    public abstract boolean apply(Request paramRequest);
  }
  
  @Deprecated
  public static abstract interface RequestFinishedListener<T>
  {
    public abstract void onRequestFinished(Request paramRequest);
  }
}
