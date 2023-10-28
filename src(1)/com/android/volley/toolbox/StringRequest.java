package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class StringRequest
  extends Request<String>
{
  private Response.Listener<String> mListener;
  private final Object mLock = new Object();
  
  public StringRequest(int paramInt, String paramString, Response.Listener paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramErrorListener);
    mListener = paramListener;
  }
  
  public StringRequest(String paramString, Response.Listener paramListener, Response.ErrorListener paramErrorListener)
  {
    this(0, paramString, paramListener, paramErrorListener);
  }
  
  public void cancel()
  {
    super.cancel();
    Object localObject = mLock;
    try
    {
      mListener = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected void deliverResponse(String paramString)
  {
    Object localObject = mLock;
    try
    {
      Response.Listener localListener = mListener;
      if (localListener != null)
      {
        localListener.onResponse(paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  protected Response parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    Object localObject = data;
    Map localMap = headers;
    try
    {
      localObject = new String((byte[])localObject, HttpHeaderParser.parseCharset(localMap));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    localObject = new String(data);
    return Response.success(localObject, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
  }
}
