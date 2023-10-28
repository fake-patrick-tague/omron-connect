package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BasicNetwork
  implements Network
{
  private static final int DEFAULT_POOL_SIZE = 4096;
  private final BaseHttpStack mBaseHttpStack;
  @Deprecated
  protected final HttpStack mHttpStack;
  protected final ByteArrayPool mPool;
  
  public BasicNetwork(BaseHttpStack paramBaseHttpStack)
  {
    this(paramBaseHttpStack, new ByteArrayPool(4096));
  }
  
  public BasicNetwork(BaseHttpStack paramBaseHttpStack, ByteArrayPool paramByteArrayPool)
  {
    mBaseHttpStack = paramBaseHttpStack;
    mHttpStack = paramBaseHttpStack;
    mPool = paramByteArrayPool;
  }
  
  public BasicNetwork(HttpStack paramHttpStack)
  {
    this(paramHttpStack, new ByteArrayPool(4096));
  }
  
  public BasicNetwork(HttpStack paramHttpStack, ByteArrayPool paramByteArrayPool)
  {
    mHttpStack = paramHttpStack;
    mBaseHttpStack = new AdaptedHttpStack(paramHttpStack);
    mPool = paramByteArrayPool;
  }
  
  protected static Map convertHeaders(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    while (i < paramArrayOfHeader.length)
    {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
    return localTreeMap;
  }
  
  public NetworkResponse performRequest(Request paramRequest)
    throws VolleyError
  {
    long l1 = SystemClock.elapsedRealtime();
    Object localObject2;
    for (;;)
    {
      Collections.emptyList();
      localObject2 = null;
      try
      {
        Object localObject1 = HttpHeaderParser.getCacheHeaders(paramRequest.getCacheEntry());
        Object localObject3 = mBaseHttpStack;
        localObject3 = ((BaseHttpStack)localObject3).executeRequest(paramRequest, (Map)localObject1);
        localObject1 = localObject2;
        try
        {
          int i = ((HttpResponse)localObject3).getStatusCode();
          localObject1 = localObject2;
          List localList = ((HttpResponse)localObject3).getHeaders();
          if (i == 304)
          {
            localObject1 = localObject2;
            l2 = SystemClock.elapsedRealtime();
            localObject1 = localObject2;
            localObject2 = NetworkUtility.getNotModifiedNetworkResponse(paramRequest, l2 - l1, localList);
            return localObject2;
          }
          localObject1 = localObject2;
          InputStream localInputStream = ((HttpResponse)localObject3).getContent();
          if (localInputStream != null)
          {
            localObject1 = localObject2;
            int j = ((HttpResponse)localObject3).getContentLength();
            ByteArrayPool localByteArrayPool = mPool;
            localObject1 = localObject2;
            localObject2 = NetworkUtility.inputStreamToBytes(localInputStream, j, localByteArrayPool);
          }
          else
          {
            localObject2 = new byte[0];
          }
          localObject1 = localObject2;
          long l2 = SystemClock.elapsedRealtime();
          localObject1 = localObject2;
          NetworkUtility.logSlowRequests(l2 - l1, paramRequest, (byte[])localObject2, i);
          if ((i >= 200) && (i <= 299))
          {
            localObject1 = localObject2;
            l2 = SystemClock.elapsedRealtime();
            localObject1 = localObject2;
            localObject2 = new NetworkResponse(i, (byte[])localObject2, false, l2 - l1, localList);
            return localObject2;
          }
          localObject1 = localObject2;
          throw new IOException();
        }
        catch (IOException localIOException2)
        {
          localObject2 = localObject3;
          localObject3 = localIOException2;
        }
        NetworkUtility.attemptRetryOnException(paramRequest, NetworkUtility.shouldRetryException(paramRequest, localIOException1, l1, (HttpResponse)localObject2, (byte[])localObject1));
      }
      catch (IOException localIOException1)
      {
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
}
