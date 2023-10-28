package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;

class AdaptedHttpStack
  extends BaseHttpStack
{
  private final HttpStack mHttpStack;
  
  AdaptedHttpStack(HttpStack paramHttpStack)
  {
    mHttpStack = paramHttpStack;
  }
  
  public HttpResponse executeRequest(Request paramRequest, Map paramMap)
    throws IOException, AuthFailureError
  {
    Object localObject1 = mHttpStack;
    try
    {
      paramRequest = ((HttpStack)localObject1).performRequest(paramRequest, paramMap);
      int j = paramRequest.getStatusLine().getStatusCode();
      paramMap = paramRequest.getAllHeaders();
      localObject1 = new ArrayList(paramMap.length);
      int k = paramMap.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = paramMap[i];
        ((List)localObject1).add(new com.android.volley.Header(localObject2.getName(), localObject2.getValue()));
        i += 1;
      }
      if (paramRequest.getEntity() == null) {
        return new HttpResponse(j, (List)localObject1);
      }
      long l = paramRequest.getEntity().getContentLength();
      if ((int)l == l) {
        return new HttpResponse(j, (List)localObject1, (int)paramRequest.getEntity().getContentLength(), paramRequest.getEntity().getContent());
      }
      paramRequest = new StringBuilder();
      paramRequest.append("Response too large: ");
      paramRequest.append(l);
      throw new IOException(paramRequest.toString());
    }
    catch (ConnectTimeoutException paramRequest)
    {
      throw new SocketTimeoutException(paramRequest.getMessage());
    }
  }
}
