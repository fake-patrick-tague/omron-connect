package com.android.volley;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

class WaitingRequestManager
  implements Request.NetworkRequestCompleteListener
{
  private final CacheDispatcher mCacheDispatcher;
  private final BlockingQueue<Request<?>> mNetworkQueue;
  private final RequestQueue mRequestQueue;
  private final ResponseDelivery mResponseDelivery;
  private final Map<String, List<Request<?>>> mWaitingRequests = new HashMap();
  
  WaitingRequestManager(CacheDispatcher paramCacheDispatcher, BlockingQueue paramBlockingQueue, ResponseDelivery paramResponseDelivery)
  {
    mRequestQueue = null;
    mResponseDelivery = paramResponseDelivery;
    mCacheDispatcher = paramCacheDispatcher;
    mNetworkQueue = paramBlockingQueue;
  }
  
  WaitingRequestManager(RequestQueue paramRequestQueue)
  {
    mRequestQueue = paramRequestQueue;
    mResponseDelivery = paramRequestQueue.getResponseDelivery();
    mCacheDispatcher = null;
    mNetworkQueue = null;
  }
  
  boolean maybeAddToWaitingRequests(Request paramRequest)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  public void onNoUsableResponseReceived(Request paramRequest)
  {
    try
    {
      Object localObject = paramRequest.getCacheKey();
      List localList = (List)mWaitingRequests.remove(localObject);
      if ((localList != null) && (!localList.isEmpty()))
      {
        if (VolleyLog.DEBUG) {
          VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", new Object[] { Integer.valueOf(localList.size()), localObject });
        }
        paramRequest = (Request)localList.remove(0);
        mWaitingRequests.put(localObject, localList);
        paramRequest.setNetworkRequestCompleteListener(this);
        localObject = mRequestQueue;
        if (localObject != null)
        {
          ((RequestQueue)localObject).sendRequestOverNetwork(paramRequest);
        }
        else if (mCacheDispatcher != null)
        {
          localObject = mNetworkQueue;
          if (localObject != null) {
            try
            {
              ((BlockingQueue)localObject).put(paramRequest);
            }
            catch (InterruptedException paramRequest)
            {
              VolleyLog.e("Couldn't add request to queue. %s", new Object[] { paramRequest.toString() });
              Thread.currentThread().interrupt();
              mCacheDispatcher.quit();
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramRequest)
    {
      throw paramRequest;
    }
  }
  
  public void onResponseReceived(Request paramRequest, Response paramResponse)
  {
    Object localObject = cacheEntry;
    if ((localObject != null) && (!((Cache.Entry)localObject).isExpired()))
    {
      paramRequest = paramRequest.getCacheKey();
      try
      {
        localObject = (List)mWaitingRequests.remove(paramRequest);
        if (localObject != null)
        {
          if (VolleyLog.DEBUG) {
            VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(((List)localObject).size()), paramRequest });
          }
          paramRequest = ((List)localObject).iterator();
          while (paramRequest.hasNext())
          {
            localObject = (Request)paramRequest.next();
            mResponseDelivery.postResponse((Request)localObject, paramResponse);
          }
        }
        return;
      }
      catch (Throwable paramRequest)
      {
        throw paramRequest;
      }
    }
    onNoUsableResponseReceived(paramRequest);
  }
}
