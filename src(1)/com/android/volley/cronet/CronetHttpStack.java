package com.android.volley.cronet;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import com.android.volley.RequestTask;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.AsyncHttpStack;
import com.android.volley.toolbox.AsyncHttpStack.OnRequestComplete;
import com.android.volley.toolbox.ByteArrayPool;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.PoolingByteArrayOutputStream;
import com.android.volley.toolbox.UrlRewriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetEngine.Builder;
import org.chromium.net.CronetException;
import org.chromium.net.UploadDataProviders;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlRequest.Builder;
import org.chromium.net.UrlRequest.Callback;
import org.chromium.net.UrlResponseInfo;

public class CronetHttpStack
  extends AsyncHttpStack
{
  private final CronetEngine mCronetEngine;
  private final CurlCommandLogger mCurlCommandLogger;
  private final boolean mCurlLoggingEnabled;
  private final boolean mLogAuthTokensInCurlCommands;
  private final ByteArrayPool mPool;
  private final RequestListener mRequestListener;
  private final UrlRewriter mUrlRewriter;
  
  private CronetHttpStack(CronetEngine paramCronetEngine, ByteArrayPool paramByteArrayPool, UrlRewriter paramUrlRewriter, RequestListener paramRequestListener, boolean paramBoolean1, CurlCommandLogger paramCurlCommandLogger, boolean paramBoolean2)
  {
    mCronetEngine = paramCronetEngine;
    mPool = paramByteArrayPool;
    mUrlRewriter = paramUrlRewriter;
    mRequestListener = paramRequestListener;
    mCurlLoggingEnabled = paramBoolean1;
    mCurlCommandLogger = paramCurlCommandLogger;
    mLogAuthTokensInCurlCommands = paramBoolean2;
    paramRequestListener.initialize(this);
  }
  
  private void addBodyIfExists(CurlLoggedRequestParameters paramCurlLoggedRequestParameters, String paramString, byte[] paramArrayOfByte)
  {
    paramCurlLoggedRequestParameters.setBody(paramString, paramArrayOfByte);
  }
  
  private String generateCurlCommand(String paramString, CurlLoggedRequestParameters paramCurlLoggedRequestParameters)
  {
    StringBuilder localStringBuilder = new StringBuilder("curl ");
    localStringBuilder.append("-X ");
    localStringBuilder.append(paramCurlLoggedRequestParameters.getHttpMethod());
    localStringBuilder.append(" ");
    Iterator localIterator = paramCurlLoggedRequestParameters.getHeaders().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("--header \"");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(": ");
      if ((!mLogAuthTokensInCurlCommands) && (("Authorization".equals(localEntry.getKey())) || ("Cookie".equals(localEntry.getKey())))) {
        localStringBuilder.append("[REDACTED]");
      } else {
        localStringBuilder.append((String)localEntry.getValue());
      }
      localStringBuilder.append("\" ");
    }
    localStringBuilder.append("\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    if (paramCurlLoggedRequestParameters.getBody() != null) {
      if (paramCurlLoggedRequestParameters.getBody().length >= 1024)
      {
        localStringBuilder.append(" [REQUEST BODY TOO LARGE TO INCLUDE]");
      }
      else if (isBinaryContentForLogging(paramCurlLoggedRequestParameters))
      {
        paramString = Base64.encodeToString(paramCurlLoggedRequestParameters.getBody(), 2);
        paramCurlLoggedRequestParameters = new StringBuilder();
        paramCurlLoggedRequestParameters.append("echo '");
        paramCurlLoggedRequestParameters.append(paramString);
        paramCurlLoggedRequestParameters.append("' | base64 -d > /tmp/$$.bin; ");
        localStringBuilder.insert(0, paramCurlLoggedRequestParameters.toString()).append(" --data-binary @/tmp/$$.bin");
      }
      else
      {
        try
        {
          localStringBuilder.append(" --data-ascii \"");
          localStringBuilder.append(new String(paramCurlLoggedRequestParameters.getBody(), "UTF-8"));
          localStringBuilder.append("\"");
        }
        catch (UnsupportedEncodingException paramString)
        {
          throw new RuntimeException("Could not encode to UTF-8", paramString);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private int getContentLength(UrlResponseInfo paramUrlResponseInfo)
  {
    paramUrlResponseInfo = (List)paramUrlResponseInfo.getAllHeaders().get("Content-Length");
    if (paramUrlResponseInfo == null) {
      return 1024;
    }
    return Integer.parseInt((String)paramUrlResponseInfo.get(0));
  }
  
  public static List getHeaders(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramList.next();
      localArrayList.add(new Header((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }
  
  private int getPriority(Request paramRequest)
  {
    int i = 2.$SwitchMap$com$android$volley$Request$Priority[paramRequest.getPriority().ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3)) {
        return 3;
      }
      return 4;
    }
    return 2;
  }
  
  private boolean isBinaryContentForLogging(CurlLoggedRequestParameters paramCurlLoggedRequestParameters)
  {
    Object localObject = (String)paramCurlLoggedRequestParameters.getHeaders().get("Content-Encoding");
    if (localObject != null)
    {
      localObject = TextUtils.split((String)localObject, ",");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if ("gzip".equals(localObject[i].trim())) {
          return true;
        }
        i += 1;
      }
    }
    paramCurlLoggedRequestParameters = (String)paramCurlLoggedRequestParameters.getHeaders().get("Content-Type");
    return (paramCurlLoggedRequestParameters == null) || ((!paramCurlLoggedRequestParameters.startsWith("text/")) && (!paramCurlLoggedRequestParameters.startsWith("application/xml")) && (!paramCurlLoggedRequestParameters.startsWith("application/json")));
  }
  
  private void setHttpMethod(CurlLoggedRequestParameters paramCurlLoggedRequestParameters, Request paramRequest)
    throws AuthFailureError
  {
    switch (paramRequest.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case 7: 
      paramCurlLoggedRequestParameters.setHttpMethod("PATCH");
      addBodyIfExists(paramCurlLoggedRequestParameters, paramRequest.getBodyContentType(), paramRequest.getBody());
      return;
    case 6: 
      paramCurlLoggedRequestParameters.setHttpMethod("TRACE");
      return;
    case 5: 
      paramCurlLoggedRequestParameters.setHttpMethod("OPTIONS");
      return;
    case 4: 
      paramCurlLoggedRequestParameters.setHttpMethod("HEAD");
      return;
    case 3: 
      paramCurlLoggedRequestParameters.setHttpMethod("DELETE");
      return;
    case 2: 
      paramCurlLoggedRequestParameters.setHttpMethod("PUT");
      addBodyIfExists(paramCurlLoggedRequestParameters, paramRequest.getBodyContentType(), paramRequest.getBody());
      return;
    case 1: 
      paramCurlLoggedRequestParameters.setHttpMethod("POST");
      addBodyIfExists(paramCurlLoggedRequestParameters, paramRequest.getBodyContentType(), paramRequest.getBody());
      return;
    case 0: 
      paramCurlLoggedRequestParameters.setHttpMethod("GET");
      return;
    }
    byte[] arrayOfByte = paramRequest.getPostBody();
    if (arrayOfByte != null)
    {
      paramCurlLoggedRequestParameters.setHttpMethod("POST");
      addBodyIfExists(paramCurlLoggedRequestParameters, paramRequest.getPostBodyContentType(), arrayOfByte);
      return;
    }
    paramCurlLoggedRequestParameters.setHttpMethod("GET");
  }
  
  private void setRequestHeaders(CurlLoggedRequestParameters paramCurlLoggedRequestParameters, Request paramRequest, Map paramMap)
    throws AuthFailureError
  {
    paramCurlLoggedRequestParameters.putAllHeaders(paramMap);
    paramCurlLoggedRequestParameters.putAllHeaders(paramRequest.getHeaders());
  }
  
  public void executeRequest(Request paramRequest, Map paramMap, final AsyncHttpStack.OnRequestComplete paramOnRequestComplete)
  {
    if ((getBlockingExecutor() != null) && (getNonBlockingExecutor() != null))
    {
      UrlRequest.Callback local1 = new UrlRequest.Callback()
      {
        PoolingByteArrayOutputStream bytesReceived = null;
        WritableByteChannel receiveChannel = null;
        
        public void onFailed(UrlRequest paramAnonymousUrlRequest, UrlResponseInfo paramAnonymousUrlResponseInfo, CronetException paramAnonymousCronetException)
        {
          paramOnRequestComplete.onError((IOException)paramAnonymousCronetException);
        }
        
        public void onReadCompleted(UrlRequest paramAnonymousUrlRequest, UrlResponseInfo paramAnonymousUrlResponseInfo, ByteBuffer paramAnonymousByteBuffer)
        {
          paramAnonymousByteBuffer.flip();
          paramAnonymousUrlResponseInfo = receiveChannel;
          try
          {
            paramAnonymousUrlResponseInfo.write(paramAnonymousByteBuffer);
            paramAnonymousByteBuffer.clear();
            paramAnonymousUrlRequest.read(paramAnonymousByteBuffer);
            return;
          }
          catch (IOException paramAnonymousUrlResponseInfo)
          {
            paramAnonymousUrlRequest.cancel();
            paramOnRequestComplete.onError(paramAnonymousUrlResponseInfo);
          }
        }
        
        public void onRedirectReceived(UrlRequest paramAnonymousUrlRequest, UrlResponseInfo paramAnonymousUrlResponseInfo, String paramAnonymousString)
        {
          paramAnonymousUrlRequest.followRedirect();
        }
        
        public void onResponseStarted(UrlRequest paramAnonymousUrlRequest, UrlResponseInfo paramAnonymousUrlResponseInfo)
        {
          paramAnonymousUrlResponseInfo = new PoolingByteArrayOutputStream(mPool, CronetHttpStack.this.getContentLength(paramAnonymousUrlResponseInfo));
          bytesReceived = paramAnonymousUrlResponseInfo;
          receiveChannel = Channels.newChannel(paramAnonymousUrlResponseInfo);
          paramAnonymousUrlRequest.read(ByteBuffer.allocateDirect(1024));
        }
        
        public void onSucceeded(UrlRequest paramAnonymousUrlRequest, UrlResponseInfo paramAnonymousUrlResponseInfo)
        {
          paramAnonymousUrlRequest = CronetHttpStack.getHeaders(paramAnonymousUrlResponseInfo.getAllHeadersAsList());
          paramAnonymousUrlRequest = new HttpResponse(paramAnonymousUrlResponseInfo.getHttpStatusCode(), paramAnonymousUrlRequest, bytesReceived.toByteArray());
          paramOnRequestComplete.onSuccess(paramAnonymousUrlRequest);
        }
      };
      Object localObject = paramRequest.getUrl();
      String str = mUrlRewriter.rewriteUrl((String)localObject);
      if (str == null)
      {
        paramRequest = new StringBuilder();
        paramRequest.append("URL blocked by rewriter: ");
        paramRequest.append((String)localObject);
        paramOnRequestComplete.onError(new IOException(paramRequest.toString()));
        return;
      }
      localObject = mCronetEngine.newUrlRequestBuilder(str, local1, getNonBlockingExecutor()).allowDirectExecutor().disableCache().setPriority(getPriority(paramRequest));
      getBlockingExecutor().execute(new SetUpRequestTask(paramRequest, str, (UrlRequest.Builder)localObject, paramMap, paramOnRequestComplete));
      return;
    }
    throw new IllegalStateException("Must set blocking and non-blocking executors");
  }
  
  public static class Builder
  {
    private static final int DEFAULT_POOL_SIZE = 4096;
    private final Context context;
    private CronetEngine mCronetEngine;
    private CronetHttpStack.CurlCommandLogger mCurlCommandLogger;
    private boolean mCurlLoggingEnabled;
    private boolean mLogAuthTokensInCurlCommands;
    private ByteArrayPool mPool;
    private CronetHttpStack.RequestListener mRequestListener;
    private UrlRewriter mUrlRewriter;
    
    public Builder(Context paramContext)
    {
      context = paramContext;
    }
    
    public CronetHttpStack build()
    {
      if (mCronetEngine == null) {
        mCronetEngine = new CronetEngine.Builder(context).build();
      }
      if (mUrlRewriter == null) {
        mUrlRewriter = new UrlRewriter()
        {
          public String rewriteUrl(String paramAnonymousString)
          {
            return paramAnonymousString;
          }
        };
      }
      if (mRequestListener == null) {
        mRequestListener = new CronetHttpStack.RequestListener() {};
      }
      if (mPool == null) {
        mPool = new ByteArrayPool(4096);
      }
      if (mCurlCommandLogger == null) {
        mCurlCommandLogger = new CronetHttpStack.CurlCommandLogger()
        {
          public void logCurlCommand(String paramAnonymousString)
          {
            VolleyLog.v(paramAnonymousString, new Object[0]);
          }
        };
      }
      return new CronetHttpStack(mCronetEngine, mPool, mUrlRewriter, mRequestListener, mCurlLoggingEnabled, mCurlCommandLogger, mLogAuthTokensInCurlCommands, null);
    }
    
    public Builder setCronetEngine(CronetEngine paramCronetEngine)
    {
      mCronetEngine = paramCronetEngine;
      return this;
    }
    
    public Builder setCurlCommandLogger(CronetHttpStack.CurlCommandLogger paramCurlCommandLogger)
    {
      mCurlCommandLogger = paramCurlCommandLogger;
      return this;
    }
    
    public Builder setCurlLoggingEnabled(boolean paramBoolean)
    {
      mCurlLoggingEnabled = paramBoolean;
      return this;
    }
    
    public Builder setLogAuthTokensInCurlCommands(boolean paramBoolean)
    {
      mLogAuthTokensInCurlCommands = paramBoolean;
      return this;
    }
    
    public Builder setPool(ByteArrayPool paramByteArrayPool)
    {
      mPool = paramByteArrayPool;
      return this;
    }
    
    public Builder setRequestListener(CronetHttpStack.RequestListener paramRequestListener)
    {
      mRequestListener = paramRequestListener;
      return this;
    }
    
    public Builder setUrlRewriter(UrlRewriter paramUrlRewriter)
    {
      mUrlRewriter = paramUrlRewriter;
      return this;
    }
  }
  
  public static abstract interface CurlCommandLogger
  {
    public abstract void logCurlCommand(String paramString);
  }
  
  private static class CurlLoggedRequestParameters
  {
    private byte[] mBody;
    private final TreeMap<String, String> mHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private String mHttpMethod;
    
    private CurlLoggedRequestParameters() {}
    
    void applyToRequest(UrlRequest.Builder paramBuilder, ExecutorService paramExecutorService)
    {
      Object localObject = mHeaders.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramBuilder.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      paramBuilder.setHttpMethod(mHttpMethod);
      localObject = mBody;
      if (localObject != null) {
        paramBuilder.setUploadDataProvider(UploadDataProviders.create((byte[])localObject), paramExecutorService);
      }
    }
    
    byte[] getBody()
    {
      return mBody;
    }
    
    TreeMap getHeaders()
    {
      return mHeaders;
    }
    
    String getHttpMethod()
    {
      return mHttpMethod;
    }
    
    void putAllHeaders(Map paramMap)
    {
      mHeaders.putAll(paramMap);
    }
    
    void setBody(String paramString, byte[] paramArrayOfByte)
    {
      mBody = paramArrayOfByte;
      if ((paramArrayOfByte != null) && (!mHeaders.containsKey("Content-Type"))) {
        mHeaders.put("Content-Type", paramString);
      }
    }
    
    void setHttpMethod(String paramString)
    {
      mHttpMethod = paramString;
    }
  }
  
  public static abstract class RequestListener
  {
    private CronetHttpStack mStack;
    
    public RequestListener() {}
    
    protected Executor getBlockingExecutor()
    {
      return mStack.getBlockingExecutor();
    }
    
    protected Executor getNonBlockingExecutor()
    {
      return mStack.getNonBlockingExecutor();
    }
    
    void initialize(CronetHttpStack paramCronetHttpStack)
    {
      mStack = paramCronetHttpStack;
    }
    
    public void onRequestPrepared(Request paramRequest, UrlRequest.Builder paramBuilder) {}
  }
  
  private class SetUpRequestTask<T>
    extends RequestTask<T>
  {
    Map<String, String> additionalHeaders;
    UrlRequest.Builder builder;
    AsyncHttpStack.OnRequestComplete callback;
    String path;
    Request<T> request;
    
    SetUpRequestTask(Request paramRequest, String paramString, UrlRequest.Builder paramBuilder, Map paramMap, AsyncHttpStack.OnRequestComplete paramOnRequestComplete)
    {
      super();
      path = paramString;
      builder = paramBuilder;
      additionalHeaders = paramMap;
      callback = paramOnRequestComplete;
      request = paramRequest;
    }
    
    public void run()
    {
      Object localObject1 = CronetHttpStack.this;
      try
      {
        localObject1 = mRequestListener;
        Object localObject2 = request;
        Object localObject3 = builder;
        ((CronetHttpStack.RequestListener)localObject1).onRequestPrepared((Request)localObject2, (UrlRequest.Builder)localObject3);
        localObject1 = new CronetHttpStack.CurlLoggedRequestParameters(null);
        localObject2 = CronetHttpStack.this;
        localObject3 = request;
        ((CronetHttpStack)localObject2).setHttpMethod((CronetHttpStack.CurlLoggedRequestParameters)localObject1, (Request)localObject3);
        localObject2 = CronetHttpStack.this;
        localObject3 = request;
        Object localObject4 = additionalHeaders;
        ((CronetHttpStack)localObject2).setRequestHeaders((CronetHttpStack.CurlLoggedRequestParameters)localObject1, (Request)localObject3, (Map)localObject4);
        localObject2 = builder;
        localObject3 = CronetHttpStack.this;
        ((CronetHttpStack.CurlLoggedRequestParameters)localObject1).applyToRequest((UrlRequest.Builder)localObject2, ((CronetHttpStack)localObject3).getNonBlockingExecutor());
        localObject2 = builder;
        localObject2 = ((UrlRequest.Builder)localObject2).build();
        localObject3 = CronetHttpStack.this;
        boolean bool = mCurlLoggingEnabled;
        if (bool)
        {
          localObject3 = CronetHttpStack.this;
          localObject3 = mCurlCommandLogger;
          localObject4 = CronetHttpStack.this;
          String str = path;
          ((CronetHttpStack.CurlCommandLogger)localObject3).logCurlCommand(((CronetHttpStack)localObject4).generateCurlCommand(str, (CronetHttpStack.CurlLoggedRequestParameters)localObject1));
        }
        ((UrlRequest)localObject2).start();
        return;
      }
      catch (AuthFailureError localAuthFailureError)
      {
        callback.onAuthError(localAuthFailureError);
      }
    }
  }
}
