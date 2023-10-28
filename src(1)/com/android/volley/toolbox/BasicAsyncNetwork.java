package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AsyncNetwork;
import com.android.volley.AsyncNetwork.OnRequestComplete;
import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestTask;
import com.android.volley.VolleyError;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class BasicAsyncNetwork
  extends AsyncNetwork
{
  private final AsyncHttpStack mAsyncStack;
  private final ByteArrayPool mPool;
  
  private BasicAsyncNetwork(AsyncHttpStack paramAsyncHttpStack, ByteArrayPool paramByteArrayPool)
  {
    mAsyncStack = paramAsyncHttpStack;
    mPool = paramByteArrayPool;
  }
  
  private void onRequestFailed(Request paramRequest, AsyncNetwork.OnRequestComplete paramOnRequestComplete, IOException paramIOException, long paramLong, HttpResponse paramHttpResponse, byte[] paramArrayOfByte)
  {
    try
    {
      paramIOException = NetworkUtility.shouldRetryException(paramRequest, paramIOException, paramLong, paramHttpResponse, paramArrayOfByte);
      paramHttpResponse = getBlockingExecutor();
      paramHttpResponse.execute(new InvokeRetryPolicyTask(paramRequest, paramIOException, paramOnRequestComplete));
      return;
    }
    catch (VolleyError paramRequest)
    {
      paramOnRequestComplete.onError(paramRequest);
    }
  }
  
  private void onRequestSucceeded(Request paramRequest, long paramLong, HttpResponse paramHttpResponse, AsyncNetwork.OnRequestComplete paramOnRequestComplete)
  {
    int i = paramHttpResponse.getStatusCode();
    List localList = paramHttpResponse.getHeaders();
    if (i == 304)
    {
      paramOnRequestComplete.onSuccess(NetworkUtility.getNotModifiedNetworkResponse(paramRequest, SystemClock.elapsedRealtime() - paramLong, localList));
      return;
    }
    byte[] arrayOfByte = paramHttpResponse.getContentBytes();
    Object localObject1 = arrayOfByte;
    Object localObject2 = localObject1;
    if (arrayOfByte == null)
    {
      localObject2 = localObject1;
      if (paramHttpResponse.getContent() == null) {
        localObject2 = new byte[0];
      }
    }
    if (localObject2 != null)
    {
      onResponseRead(paramLong, i, paramHttpResponse, paramRequest, paramOnRequestComplete, localList, (byte[])localObject2);
      return;
    }
    localObject1 = paramHttpResponse.getContent();
    getBlockingExecutor().execute(new ResponseParsingTask((InputStream)localObject1, paramHttpResponse, paramRequest, paramOnRequestComplete, paramLong, localList, i));
  }
  
  private void onResponseRead(long paramLong, int paramInt, HttpResponse paramHttpResponse, Request paramRequest, AsyncNetwork.OnRequestComplete paramOnRequestComplete, List paramList, byte[] paramArrayOfByte)
  {
    NetworkUtility.logSlowRequests(SystemClock.elapsedRealtime() - paramLong, paramRequest, paramArrayOfByte, paramInt);
    if ((paramInt >= 200) && (paramInt <= 299))
    {
      paramOnRequestComplete.onSuccess(new NetworkResponse(paramInt, paramArrayOfByte, false, SystemClock.elapsedRealtime() - paramLong, paramList));
      return;
    }
    onRequestFailed(paramRequest, paramOnRequestComplete, new IOException(), paramLong, paramHttpResponse, paramArrayOfByte);
  }
  
  public void performRequest(final Request paramRequest, AsyncNetwork.OnRequestComplete paramOnRequestComplete)
  {
    if (getBlockingExecutor() != null)
    {
      final long l = SystemClock.elapsedRealtime();
      Map localMap = HttpHeaderParser.getCacheHeaders(paramRequest.getCacheEntry());
      mAsyncStack.executeRequest(paramRequest, localMap, new AsyncHttpStack.OnRequestComplete()
      {
        public void onAuthError(AuthFailureError paramAnonymousAuthFailureError)
        {
          val$callback.onError(paramAnonymousAuthFailureError);
        }
        
        public void onError(IOException paramAnonymousIOException)
        {
          BasicAsyncNetwork.this.onRequestFailed(paramRequest, val$callback, paramAnonymousIOException, l, null, null);
        }
        
        public void onSuccess(HttpResponse paramAnonymousHttpResponse)
        {
          BasicAsyncNetwork.this.onRequestSucceeded(paramRequest, l, paramAnonymousHttpResponse, val$callback);
        }
      });
      return;
    }
    throw new IllegalStateException("mBlockingExecuter must be set before making a request");
  }
  
  public void setBlockingExecutor(ExecutorService paramExecutorService)
  {
    super.setBlockingExecutor(paramExecutorService);
    mAsyncStack.setBlockingExecutor(paramExecutorService);
  }
  
  public void setNonBlockingExecutor(ExecutorService paramExecutorService)
  {
    super.setNonBlockingExecutor(paramExecutorService);
    mAsyncStack.setNonBlockingExecutor(paramExecutorService);
  }
  
  public static class Builder
  {
    private static final int DEFAULT_POOL_SIZE = 4096;
    private AsyncHttpStack mAsyncStack;
    private ByteArrayPool mPool;
    
    public Builder(AsyncHttpStack paramAsyncHttpStack)
    {
      mAsyncStack = paramAsyncHttpStack;
      mPool = null;
    }
    
    public BasicAsyncNetwork build()
    {
      if (mPool == null) {
        mPool = new ByteArrayPool(4096);
      }
      return new BasicAsyncNetwork(mAsyncStack, mPool, null);
    }
    
    public Builder setPool(ByteArrayPool paramByteArrayPool)
    {
      mPool = paramByteArrayPool;
      return this;
    }
  }
  
  private class InvokeRetryPolicyTask<T>
    extends RequestTask<T>
  {
    final AsyncNetwork.OnRequestComplete callback;
    final Request<T> request;
    final NetworkUtility.RetryInfo retryInfo;
    
    InvokeRetryPolicyTask(Request paramRequest, NetworkUtility.RetryInfo paramRetryInfo, AsyncNetwork.OnRequestComplete paramOnRequestComplete)
    {
      super();
      request = paramRequest;
      retryInfo = paramRetryInfo;
      callback = paramOnRequestComplete;
    }
    
    public void run()
    {
      Object localObject1 = request;
      Object localObject2 = retryInfo;
      try
      {
        NetworkUtility.attemptRetryOnException((Request)localObject1, (NetworkUtility.RetryInfo)localObject2);
        localObject1 = BasicAsyncNetwork.this;
        localObject2 = request;
        AsyncNetwork.OnRequestComplete localOnRequestComplete = callback;
        ((BasicAsyncNetwork)localObject1).performRequest((Request)localObject2, localOnRequestComplete);
        return;
      }
      catch (VolleyError localVolleyError)
      {
        callback.onError(localVolleyError);
      }
    }
  }
  
  private class ResponseParsingTask<T>
    extends RequestTask<T>
  {
    AsyncNetwork.OnRequestComplete callback;
    HttpResponse httpResponse;
    InputStream inputStream;
    Request<T> request;
    long requestStartMs;
    List<Header> responseHeaders;
    int statusCode;
    
    ResponseParsingTask(InputStream paramInputStream, HttpResponse paramHttpResponse, Request paramRequest, AsyncNetwork.OnRequestComplete paramOnRequestComplete, long paramLong, List paramList, int paramInt)
    {
      super();
      inputStream = paramInputStream;
      httpResponse = paramHttpResponse;
      request = paramRequest;
      callback = paramOnRequestComplete;
      requestStartMs = paramLong;
      responseHeaders = paramList;
      statusCode = paramInt;
    }
    
    public void run()
    {
      Object localObject1 = inputStream;
      Object localObject2 = httpResponse;
      try
      {
        int i = ((HttpResponse)localObject2).getContentLength();
        localObject2 = BasicAsyncNetwork.this;
        localObject1 = NetworkUtility.inputStreamToBytes((InputStream)localObject1, i, mPool);
        BasicAsyncNetwork.this.onResponseRead(requestStartMs, statusCode, httpResponse, request, callback, responseHeaders, (byte[])localObject1);
        return;
      }
      catch (IOException localIOException)
      {
        BasicAsyncNetwork.this.onRequestFailed(request, callback, localIOException, requestStartMs, httpResponse, null);
      }
    }
  }
}
