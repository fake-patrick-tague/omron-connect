package com.android.volley;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AsyncNetwork
  implements Network
{
  private ExecutorService mBlockingExecutor;
  private ExecutorService mNonBlockingExecutor;
  private ScheduledExecutorService mNonBlockingScheduledExecutor;
  
  protected AsyncNetwork() {}
  
  protected ExecutorService getBlockingExecutor()
  {
    return mBlockingExecutor;
  }
  
  protected ExecutorService getNonBlockingExecutor()
  {
    return mNonBlockingExecutor;
  }
  
  protected ScheduledExecutorService getNonBlockingScheduledExecutor()
  {
    return mNonBlockingScheduledExecutor;
  }
  
  public NetworkResponse performRequest(Request paramRequest)
    throws VolleyError
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final AtomicReference localAtomicReference1 = new AtomicReference();
    final AtomicReference localAtomicReference2 = new AtomicReference();
    performRequest(paramRequest, new OnRequestComplete()
    {
      public void onError(VolleyError paramAnonymousVolleyError)
      {
        localAtomicReference2.set(paramAnonymousVolleyError);
        localCountDownLatch.countDown();
      }
      
      public void onSuccess(NetworkResponse paramAnonymousNetworkResponse)
      {
        localAtomicReference1.set(paramAnonymousNetworkResponse);
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
      if (localAtomicReference1.get() != null) {
        return (NetworkResponse)localAtomicReference1.get();
      }
      if (localAtomicReference2.get() != null) {
        throw ((VolleyError)localAtomicReference2.get());
      }
      throw new VolleyError("Neither response entry was set");
    }
    catch (InterruptedException paramRequest)
    {
      VolleyLog.e(paramRequest, "while waiting for CountDownLatch", new Object[0]);
      Thread.currentThread().interrupt();
      throw new VolleyError(paramRequest);
    }
  }
  
  public abstract void performRequest(Request paramRequest, OnRequestComplete paramOnRequestComplete);
  
  public void setBlockingExecutor(ExecutorService paramExecutorService)
  {
    mBlockingExecutor = paramExecutorService;
  }
  
  public void setNonBlockingExecutor(ExecutorService paramExecutorService)
  {
    mNonBlockingExecutor = paramExecutorService;
  }
  
  public void setNonBlockingScheduledExecutor(ScheduledExecutorService paramScheduledExecutorService)
  {
    mNonBlockingScheduledExecutor = paramScheduledExecutorService;
  }
  
  public static abstract interface OnRequestComplete
  {
    public abstract void onError(VolleyError paramVolleyError);
    
    public abstract void onSuccess(NetworkResponse paramNetworkResponse);
  }
}
