package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AsyncHttpStack
  extends BaseHttpStack
{
  private ExecutorService mBlockingExecutor;
  private ExecutorService mNonBlockingExecutor;
  
  public AsyncHttpStack() {}
  
  public final HttpResponse executeRequest(Request paramRequest, Map paramMap)
    throws IOException, AuthFailureError
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final AtomicReference localAtomicReference = new AtomicReference();
    executeRequest(paramRequest, paramMap, new OnRequestComplete()
    {
      public void onAuthError(AuthFailureError paramAnonymousAuthFailureError)
      {
        paramAnonymousAuthFailureError = new AsyncHttpStack.Response(null, null, paramAnonymousAuthFailureError, null);
        localAtomicReference.set(paramAnonymousAuthFailureError);
        localCountDownLatch.countDown();
      }
      
      public void onError(IOException paramAnonymousIOException)
      {
        paramAnonymousIOException = new AsyncHttpStack.Response(null, paramAnonymousIOException, null, null);
        localAtomicReference.set(paramAnonymousIOException);
        localCountDownLatch.countDown();
      }
      
      public void onSuccess(HttpResponse paramAnonymousHttpResponse)
      {
        paramAnonymousHttpResponse = new AsyncHttpStack.Response(paramAnonymousHttpResponse, null, null, null);
        localAtomicReference.set(paramAnonymousHttpResponse);
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
      paramRequest = (Response)localAtomicReference.get();
      paramMap = httpResponse;
      if (paramMap != null) {
        return paramMap;
      }
      paramMap = ioException;
      if (paramMap != null) {
        throw paramMap;
      }
      throw authFailureError;
    }
    catch (InterruptedException paramRequest)
    {
      VolleyLog.e(paramRequest, "while waiting for CountDownLatch", new Object[0]);
      Thread.currentThread().interrupt();
      throw new InterruptedIOException(paramRequest.toString());
    }
  }
  
  public abstract void executeRequest(Request paramRequest, Map paramMap, OnRequestComplete paramOnRequestComplete);
  
  protected ExecutorService getBlockingExecutor()
  {
    return mBlockingExecutor;
  }
  
  protected ExecutorService getNonBlockingExecutor()
  {
    return mNonBlockingExecutor;
  }
  
  public void setBlockingExecutor(ExecutorService paramExecutorService)
  {
    mBlockingExecutor = paramExecutorService;
  }
  
  public void setNonBlockingExecutor(ExecutorService paramExecutorService)
  {
    mNonBlockingExecutor = paramExecutorService;
  }
  
  public static abstract interface OnRequestComplete
  {
    public abstract void onAuthError(AuthFailureError paramAuthFailureError);
    
    public abstract void onError(IOException paramIOException);
    
    public abstract void onSuccess(HttpResponse paramHttpResponse);
  }
  
  private static class Response
  {
    AuthFailureError authFailureError;
    HttpResponse httpResponse;
    IOException ioException;
    
    private Response(HttpResponse paramHttpResponse, IOException paramIOException, AuthFailureError paramAuthFailureError)
    {
      httpResponse = paramHttpResponse;
      ioException = paramIOException;
      authFailureError = paramAuthFailureError;
    }
  }
}
