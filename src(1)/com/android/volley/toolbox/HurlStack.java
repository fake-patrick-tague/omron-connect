package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HurlStack
  extends BaseHttpStack
{
  private static final int HTTP_CONTINUE = 100;
  private final SSLSocketFactory mSslSocketFactory;
  private final UrlRewriter mUrlRewriter;
  
  public HurlStack()
  {
    this(null);
  }
  
  public HurlStack(UrlRewriter paramUrlRewriter)
  {
    this(paramUrlRewriter, null);
  }
  
  public HurlStack(UrlRewriter paramUrlRewriter, SSLSocketFactory paramSSLSocketFactory)
  {
    mUrlRewriter = paramUrlRewriter;
    mSslSocketFactory = paramSSLSocketFactory;
  }
  
  private void addBody(HttpURLConnection paramHttpURLConnection, Request paramRequest, byte[] paramArrayOfByte)
    throws IOException
  {
    paramHttpURLConnection.setDoOutput(true);
    if (!paramHttpURLConnection.getRequestProperties().containsKey("Content-Type")) {
      paramHttpURLConnection.setRequestProperty("Content-Type", paramRequest.getBodyContentType());
    }
    paramHttpURLConnection = new DataOutputStream(createOutputStream(paramRequest, paramHttpURLConnection, paramArrayOfByte.length));
    paramHttpURLConnection.write(paramArrayOfByte);
    paramHttpURLConnection.close();
  }
  
  private void addBodyIfExists(HttpURLConnection paramHttpURLConnection, Request paramRequest)
    throws IOException, AuthFailureError
  {
    byte[] arrayOfByte = paramRequest.getBody();
    if (arrayOfByte != null) {
      addBody(paramHttpURLConnection, paramRequest, arrayOfByte);
    }
  }
  
  static List convertHeaders(Map paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localEntry.getKey() != null)
      {
        Iterator localIterator = ((List)localEntry.getValue()).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(new Header((String)localEntry.getKey(), str));
        }
      }
    }
    return localArrayList;
  }
  
  private static boolean hasResponseBody(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 4) && ((100 > paramInt2) || (paramInt2 >= 200)) && (paramInt2 != 204) && (paramInt2 != 304);
  }
  
  private static InputStream inputStreamFromConnection(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      InputStream localInputStream = paramHttpURLConnection.getInputStream();
      return localInputStream;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return paramHttpURLConnection.getErrorStream();
  }
  
  private HttpURLConnection openConnection(URL paramURL, Request paramRequest)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = createConnection(paramURL);
    int i = paramRequest.getTimeoutMs();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if ("https".equals(paramURL.getProtocol()))
    {
      paramURL = mSslSocketFactory;
      if (paramURL != null) {
        ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramURL);
      }
    }
    return localHttpURLConnection;
  }
  
  protected HttpURLConnection createConnection(URL paramURL)
    throws IOException
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    return paramURL;
  }
  
  protected InputStream createInputStream(Request paramRequest, HttpURLConnection paramHttpURLConnection)
  {
    return new UrlConnectionInputStream(paramHttpURLConnection);
  }
  
  protected OutputStream createOutputStream(Request paramRequest, HttpURLConnection paramHttpURLConnection, int paramInt)
    throws IOException
  {
    return paramHttpURLConnection.getOutputStream();
  }
  
  public HttpResponse executeRequest(Request paramRequest, Map paramMap)
    throws IOException, AuthFailureError
  {
    String str = paramRequest.getUrl();
    Object localObject = str;
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    localHashMap.putAll(paramRequest.getHeaders());
    paramMap = mUrlRewriter;
    if (paramMap != null)
    {
      localObject = paramMap.rewriteUrl(str);
      if (localObject == null)
      {
        paramRequest = new StringBuilder();
        paramRequest.append("URL blocked by rewriter: ");
        paramRequest.append(str);
        throw new IOException(paramRequest.toString());
      }
    }
    paramMap = openConnection(new URL((String)localObject), paramRequest);
    int j = 0;
    int i = j;
    try
    {
      localObject = localHashMap.keySet().iterator();
      boolean bool;
      for (;;)
      {
        i = j;
        bool = ((Iterator)localObject).hasNext();
        if (!bool) {
          break;
        }
        i = j;
        str = (String)((Iterator)localObject).next();
        i = j;
        paramMap.setRequestProperty(str, (String)localHashMap.get(str));
      }
      i = j;
      setConnectionParametersForRequest(paramMap, paramRequest);
      i = j;
      int k = paramMap.getResponseCode();
      if (k != -1)
      {
        i = j;
        bool = hasResponseBody(paramRequest.getMethod(), k);
        if (!bool)
        {
          i = j;
          paramRequest = new HttpResponse(k, convertHeaders(paramMap.getHeaderFields()));
          paramMap.disconnect();
          return paramRequest;
        }
        i = 1;
        paramRequest = new HttpResponse(k, convertHeaders(paramMap.getHeaderFields()), paramMap.getContentLength(), createInputStream(paramRequest, paramMap));
        return paramRequest;
      }
      i = j;
      throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }
    catch (Throwable paramRequest)
    {
      if (i == 0) {
        paramMap.disconnect();
      }
      throw paramRequest;
    }
  }
  
  void setConnectionParametersForRequest(HttpURLConnection paramHttpURLConnection, Request paramRequest)
    throws IOException, AuthFailureError
  {
    switch (paramRequest.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case 7: 
      paramHttpURLConnection.setRequestMethod("PATCH");
      addBodyIfExists(paramHttpURLConnection, paramRequest);
      return;
    case 6: 
      paramHttpURLConnection.setRequestMethod("TRACE");
      return;
    case 5: 
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      return;
    case 4: 
      paramHttpURLConnection.setRequestMethod("HEAD");
      return;
    case 3: 
      paramHttpURLConnection.setRequestMethod("DELETE");
      return;
    case 2: 
      paramHttpURLConnection.setRequestMethod("PUT");
      addBodyIfExists(paramHttpURLConnection, paramRequest);
      return;
    case 1: 
      paramHttpURLConnection.setRequestMethod("POST");
      addBodyIfExists(paramHttpURLConnection, paramRequest);
      return;
    case 0: 
      paramHttpURLConnection.setRequestMethod("GET");
      return;
    }
    byte[] arrayOfByte = paramRequest.getPostBody();
    if (arrayOfByte != null)
    {
      paramHttpURLConnection.setRequestMethod("POST");
      addBody(paramHttpURLConnection, paramRequest, arrayOfByte);
    }
  }
  
  static class UrlConnectionInputStream
    extends FilterInputStream
  {
    private final HttpURLConnection mConnection;
    
    UrlConnectionInputStream(HttpURLConnection paramHttpURLConnection)
    {
      super();
      mConnection = paramHttpURLConnection;
    }
    
    public void close()
      throws IOException
    {
      super.close();
      mConnection.disconnect();
    }
  }
  
  public static abstract interface UrlRewriter
    extends UrlRewriter
  {}
}
