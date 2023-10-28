package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Request<T>
  implements Comparable<Request<T>>
{
  private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
  private Cache.Entry mCacheEntry;
  private boolean mCanceled;
  private final int mDefaultTrafficStatsTag;
  private Response.ErrorListener mErrorListener;
  private final VolleyLog.MarkerLog mEventLog;
  private final Object mLock;
  private final int mMethod;
  private NetworkRequestCompleteListener mRequestCompleteListener;
  private RequestQueue mRequestQueue;
  private boolean mResponseDelivered;
  private RetryPolicy mRetryPolicy;
  private Integer mSequence;
  private boolean mShouldCache;
  private boolean mShouldRetryConnectionErrors;
  private boolean mShouldRetryServerErrors;
  private Object mTag;
  private final String mUrl;
  
  public Request(int paramInt, String paramString, Response.ErrorListener paramErrorListener)
  {
    VolleyLog.MarkerLog localMarkerLog;
    if (VolleyLog.MarkerLog.ENABLED) {
      localMarkerLog = new VolleyLog.MarkerLog();
    } else {
      localMarkerLog = null;
    }
    mEventLog = localMarkerLog;
    mLock = new Object();
    mShouldCache = true;
    mCanceled = false;
    mResponseDelivered = false;
    mShouldRetryServerErrors = false;
    mShouldRetryConnectionErrors = false;
    mCacheEntry = null;
    mMethod = paramInt;
    mUrl = paramString;
    mErrorListener = paramErrorListener;
    setRetryPolicy(new DefaultRetryPolicy());
    mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(paramString);
  }
  
  public Request(String paramString, Response.ErrorListener paramErrorListener)
  {
    this(-1, paramString, paramErrorListener);
  }
  
  private byte[] encodeParameters(Map paramMap, String paramString)
  {
    Object localObject1 = new StringBuilder();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      Object localObject2;
      for (;;)
      {
        boolean bool = paramMap.hasNext();
        if (!bool) {
          break label195;
        }
        localObject2 = paramMap.next();
        localObject2 = (Map.Entry)localObject2;
        Object localObject3 = ((Map.Entry)localObject2).getKey();
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((Map.Entry)localObject2).getValue();
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((Map.Entry)localObject2).getKey();
        localObject3 = (String)localObject3;
        ((StringBuilder)localObject1).append(URLEncoder.encode((String)localObject3, paramString));
        ((StringBuilder)localObject1).append('=');
        localObject2 = ((Map.Entry)localObject2).getValue();
        localObject2 = (String)localObject2;
        ((StringBuilder)localObject1).append(URLEncoder.encode((String)localObject2, paramString));
        ((StringBuilder)localObject1).append('&');
      }
      paramMap = ((Map.Entry)localObject2).getKey();
      localObject1 = ((Map.Entry)localObject2).getValue();
      paramMap = new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", new Object[] { paramMap, localObject1 }));
      throw paramMap;
      label195:
      paramMap = ((StringBuilder)localObject1).toString().getBytes(paramString);
      return paramMap;
    }
    catch (UnsupportedEncodingException paramMap)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Encoding not supported: ");
      ((StringBuilder)localObject1).append(paramString);
      throw new RuntimeException(((StringBuilder)localObject1).toString(), paramMap);
    }
  }
  
  private static int findDefaultTrafficStatsTag(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null) {
          return paramString.hashCode();
        }
      }
    }
    return 0;
  }
  
  public void addMarker(String paramString)
  {
    if (VolleyLog.MarkerLog.ENABLED) {
      mEventLog.add(paramString, Thread.currentThread().getId());
    }
  }
  
  public void cancel()
  {
    Object localObject = mLock;
    try
    {
      mCanceled = true;
      mErrorListener = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int compareTo(Request paramRequest)
  {
    Priority localPriority1 = getPriority();
    Priority localPriority2 = paramRequest.getPriority();
    if (localPriority1 == localPriority2) {
      return mSequence.intValue() - mSequence.intValue();
    }
    return localPriority2.ordinal() - localPriority1.ordinal();
  }
  
  public void deliverError(VolleyError paramVolleyError)
  {
    Object localObject = mLock;
    try
    {
      Response.ErrorListener localErrorListener = mErrorListener;
      if (localErrorListener != null)
      {
        localErrorListener.onErrorResponse(paramVolleyError);
        return;
      }
    }
    catch (Throwable paramVolleyError)
    {
      throw paramVolleyError;
    }
  }
  
  protected abstract void deliverResponse(Object paramObject);
  
  void finish(final String paramString)
  {
    RequestQueue localRequestQueue = mRequestQueue;
    if (localRequestQueue != null) {
      localRequestQueue.finish(this);
    }
    if (VolleyLog.MarkerLog.ENABLED)
    {
      final long l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            mEventLog.add(paramString, l);
            mEventLog.finish(toString());
          }
        });
        return;
      }
      mEventLog.add(paramString, l);
      mEventLog.finish(toString());
    }
  }
  
  public byte[] getBody()
    throws AuthFailureError
  {
    Map localMap = getParams();
    if ((localMap != null) && (localMap.size() > 0)) {
      return encodeParameters(localMap, getParamsEncoding());
    }
    return null;
  }
  
  public String getBodyContentType()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("application/x-www-form-urlencoded; charset=");
    localStringBuilder.append(getParamsEncoding());
    return localStringBuilder.toString();
  }
  
  public Cache.Entry getCacheEntry()
  {
    return mCacheEntry;
  }
  
  public String getCacheKey()
  {
    String str = getUrl();
    int i = getMethod();
    Object localObject = str;
    if (i != 0)
    {
      if (i == -1) {
        return str;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Integer.toString(i));
      ((StringBuilder)localObject).append('-');
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public Response.ErrorListener getErrorListener()
  {
    Object localObject = mLock;
    try
    {
      Response.ErrorListener localErrorListener = mErrorListener;
      return localErrorListener;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Map getHeaders()
    throws AuthFailureError
  {
    return Collections.emptyMap();
  }
  
  public int getMethod()
  {
    return mMethod;
  }
  
  protected Map getParams()
    throws AuthFailureError
  {
    return null;
  }
  
  protected String getParamsEncoding()
  {
    return "UTF-8";
  }
  
  public byte[] getPostBody()
    throws AuthFailureError
  {
    Map localMap = getPostParams();
    if ((localMap != null) && (localMap.size() > 0)) {
      return encodeParameters(localMap, getPostParamsEncoding());
    }
    return null;
  }
  
  public String getPostBodyContentType()
  {
    return getBodyContentType();
  }
  
  protected Map getPostParams()
    throws AuthFailureError
  {
    return getParams();
  }
  
  protected String getPostParamsEncoding()
  {
    return getParamsEncoding();
  }
  
  public Priority getPriority()
  {
    return Priority.NORMAL;
  }
  
  public RetryPolicy getRetryPolicy()
  {
    return mRetryPolicy;
  }
  
  public final int getSequence()
  {
    Integer localInteger = mSequence;
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalStateException("getSequence called before setSequence");
  }
  
  public Object getTag()
  {
    return mTag;
  }
  
  public final int getTimeoutMs()
  {
    return getRetryPolicy().getCurrentTimeout();
  }
  
  public int getTrafficStatsTag()
  {
    return mDefaultTrafficStatsTag;
  }
  
  public String getUrl()
  {
    return mUrl;
  }
  
  public boolean hasHadResponseDelivered()
  {
    Object localObject = mLock;
    try
    {
      boolean bool = mResponseDelivered;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean isCanceled()
  {
    Object localObject = mLock;
    try
    {
      boolean bool = mCanceled;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void markDelivered()
  {
    Object localObject = mLock;
    try
    {
      mResponseDelivered = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void notifyListenerResponseNotUsable()
  {
    Object localObject = mLock;
    try
    {
      NetworkRequestCompleteListener localNetworkRequestCompleteListener = mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null)
      {
        localNetworkRequestCompleteListener.onNoUsableResponseReceived(this);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void notifyListenerResponseReceived(Response paramResponse)
  {
    Object localObject = mLock;
    try
    {
      NetworkRequestCompleteListener localNetworkRequestCompleteListener = mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null)
      {
        localNetworkRequestCompleteListener.onResponseReceived(this, paramResponse);
        return;
      }
    }
    catch (Throwable paramResponse)
    {
      throw paramResponse;
    }
  }
  
  protected VolleyError parseNetworkError(VolleyError paramVolleyError)
  {
    return paramVolleyError;
  }
  
  protected abstract Response parseNetworkResponse(NetworkResponse paramNetworkResponse);
  
  void sendEvent(int paramInt)
  {
    RequestQueue localRequestQueue = mRequestQueue;
    if (localRequestQueue != null) {
      localRequestQueue.sendRequestEvent(this, paramInt);
    }
  }
  
  public Request setCacheEntry(Cache.Entry paramEntry)
  {
    mCacheEntry = paramEntry;
    return this;
  }
  
  void setNetworkRequestCompleteListener(NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    Object localObject = mLock;
    try
    {
      mRequestCompleteListener = paramNetworkRequestCompleteListener;
      return;
    }
    catch (Throwable paramNetworkRequestCompleteListener)
    {
      throw paramNetworkRequestCompleteListener;
    }
  }
  
  public Request setRequestQueue(RequestQueue paramRequestQueue)
  {
    mRequestQueue = paramRequestQueue;
    return this;
  }
  
  public Request setRetryPolicy(RetryPolicy paramRetryPolicy)
  {
    mRetryPolicy = paramRetryPolicy;
    return this;
  }
  
  public final Request setSequence(int paramInt)
  {
    mSequence = Integer.valueOf(paramInt);
    return this;
  }
  
  public final Request setShouldCache(boolean paramBoolean)
  {
    mShouldCache = paramBoolean;
    return this;
  }
  
  public final Request setShouldRetryConnectionErrors(boolean paramBoolean)
  {
    mShouldRetryConnectionErrors = paramBoolean;
    return this;
  }
  
  public final Request setShouldRetryServerErrors(boolean paramBoolean)
  {
    mShouldRetryServerErrors = paramBoolean;
    return this;
  }
  
  public Request setTag(Object paramObject)
  {
    mTag = paramObject;
    return this;
  }
  
  public final boolean shouldCache()
  {
    return mShouldCache;
  }
  
  public final boolean shouldRetryConnectionErrors()
  {
    return mShouldRetryConnectionErrors;
  }
  
  public final boolean shouldRetryServerErrors()
  {
    return mShouldRetryServerErrors;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("0x");
    ((StringBuilder)localObject).append(Integer.toHexString(getTrafficStatsTag()));
    String str = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled()) {
      localObject = "[X] ";
    } else {
      localObject = "[ ] ";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(getUrl());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(getPriority());
    localStringBuilder.append(" ");
    localStringBuilder.append(mSequence);
    return localStringBuilder.toString();
  }
  
  public static abstract interface Method
  {
    public static final int DELETE = 3;
    public static final int DEPRECATED_GET_OR_POST = -1;
    public static final int GET = 0;
    public static final int HEAD = 4;
    public static final int OPTIONS = 5;
    public static final int PATCH = 7;
    public static final int POST = 1;
    public static final int PUT = 2;
    public static final int TRACE = 6;
  }
  
  static abstract interface NetworkRequestCompleteListener
  {
    public abstract void onNoUsableResponseReceived(Request paramRequest);
    
    public abstract void onResponseReceived(Request paramRequest, Response paramResponse);
  }
  
  public static enum Priority
  {
    static
    {
      Priority localPriority1 = new Priority("LOW", 0);
      LOW = localPriority1;
      Priority localPriority2 = new Priority("NORMAL", 1);
      NORMAL = localPriority2;
      Priority localPriority3 = new Priority("HIGH", 2);
      HIGH = localPriority3;
      Priority localPriority4 = new Priority("IMMEDIATE", 3);
      IMMEDIATE = localPriority4;
      $VALUES = new Priority[] { localPriority1, localPriority2, localPriority3, localPriority4 };
    }
  }
}
