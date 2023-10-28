package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache.Entry;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

final class NetworkUtility
{
  private static final int SLOW_REQUEST_THRESHOLD_MS = 3000;
  
  private NetworkUtility() {}
  
  static void attemptRetryOnException(Request paramRequest, RetryInfo paramRetryInfo)
    throws VolleyError
  {
    RetryPolicy localRetryPolicy = paramRequest.getRetryPolicy();
    int i = paramRequest.getTimeoutMs();
    try
    {
      localRetryPolicy.retry(errorToRetry);
      paramRequest.addMarker(String.format("%s-retry [timeout=%s]", new Object[] { logPrefix, Integer.valueOf(i) }));
      return;
    }
    catch (VolleyError localVolleyError)
    {
      paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { logPrefix, Integer.valueOf(i) }));
      throw localVolleyError;
    }
  }
  
  static NetworkResponse getNotModifiedNetworkResponse(Request paramRequest, long paramLong, List paramList)
  {
    paramRequest = paramRequest.getCacheEntry();
    if (paramRequest == null) {
      return new NetworkResponse(304, null, true, paramLong, paramList);
    }
    paramList = HttpHeaderParser.combineHeaders(paramList, paramRequest);
    return new NetworkResponse(304, data, true, paramLong, paramList);
  }
  
  static byte[] inputStreamToBytes(InputStream paramInputStream, int paramInt, ByteArrayPool paramByteArrayPool)
    throws IOException
  {
    PoolingByteArrayOutputStream localPoolingByteArrayOutputStream = new PoolingByteArrayOutputStream(paramByteArrayPool, paramInt);
    for (;;)
    {
      byte[] arrayOfByte1;
      try
      {
        byte[] arrayOfByte2 = paramByteArrayPool.getBuf(1024);
        arrayOfByte1 = arrayOfByte2;
        byte[] arrayOfByte3;
        try
        {
          paramInt = paramInputStream.read(arrayOfByte2);
          if (paramInt != -1)
          {
            localPoolingByteArrayOutputStream.write(arrayOfByte2, 0, paramInt);
            continue;
          }
          arrayOfByte3 = localPoolingByteArrayOutputStream.toByteArray();
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        arrayOfByte1 = null;
      }
      try
      {
        paramInputStream.close();
      }
      catch (IOException paramInputStream) {}
    }
    VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
    paramByteArrayPool.returnBuf(arrayOfByte2);
    localPoolingByteArrayOutputStream.close();
    return arrayOfByte3;
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
    }
    catch (IOException paramInputStream)
    {
      for (;;) {}
    }
    VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
    paramByteArrayPool.returnBuf(arrayOfByte1);
    localPoolingByteArrayOutputStream.close();
    throw localThrowable2;
  }
  
  static void logSlowRequests(long paramLong, Request paramRequest, byte[] paramArrayOfByte, int paramInt)
  {
    if ((VolleyLog.DEBUG) || (paramLong > 3000L))
    {
      if (paramArrayOfByte != null) {
        paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
      } else {
        paramArrayOfByte = "null";
      }
      VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramRequest, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramInt), Integer.valueOf(paramRequest.getRetryPolicy().getCurrentRetryCount()) });
    }
  }
  
  static RetryInfo shouldRetryException(Request paramRequest, IOException paramIOException, long paramLong, HttpResponse paramHttpResponse, byte[] paramArrayOfByte)
    throws VolleyError
  {
    if ((paramIOException instanceof SocketTimeoutException)) {
      return new RetryInfo("socket", new TimeoutError(), null);
    }
    if (!(paramIOException instanceof MalformedURLException))
    {
      if (paramHttpResponse != null)
      {
        int i = paramHttpResponse.getStatusCode();
        VolleyLog.e("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), paramRequest.getUrl() });
        if (paramArrayOfByte != null)
        {
          paramIOException = paramHttpResponse.getHeaders();
          paramIOException = new NetworkResponse(i, paramArrayOfByte, false, SystemClock.elapsedRealtime() - paramLong, paramIOException);
          if ((i != 401) && (i != 403))
          {
            if ((i >= 400) && (i <= 499)) {
              throw new ClientError(paramIOException);
            }
            if ((i >= 500) && (i <= 599) && (paramRequest.shouldRetryServerErrors())) {
              return new RetryInfo("server", new ServerError(paramIOException), null);
            }
            throw new ServerError(paramIOException);
          }
          return new RetryInfo("auth", new AuthFailureError(paramIOException), null);
        }
        return new RetryInfo("network", new NetworkError(), null);
      }
      if (paramRequest.shouldRetryConnectionErrors()) {
        return new RetryInfo("connection", new NoConnectionError(), null);
      }
      throw new NoConnectionError(paramIOException);
    }
    paramHttpResponse = new StringBuilder();
    paramHttpResponse.append("Bad URL ");
    paramHttpResponse.append(paramRequest.getUrl());
    throw new RuntimeException(paramHttpResponse.toString(), paramIOException);
  }
  
  static class RetryInfo
  {
    private final VolleyError errorToRetry;
    private final String logPrefix;
    
    private RetryInfo(String paramString, VolleyError paramVolleyError)
    {
      logPrefix = paramString;
      errorToRetry = paramVolleyError;
    }
  }
}
