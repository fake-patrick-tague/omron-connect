package com.android.volley;

public class Response<T>
{
  public final Cache.Entry cacheEntry;
  public final VolleyError error;
  public boolean intermediate = false;
  public final T result;
  
  private Response(VolleyError paramVolleyError)
  {
    result = null;
    cacheEntry = null;
    error = paramVolleyError;
  }
  
  private Response(Object paramObject, Cache.Entry paramEntry)
  {
    result = paramObject;
    cacheEntry = paramEntry;
    error = null;
  }
  
  public static Response error(VolleyError paramVolleyError)
  {
    return new Response(paramVolleyError);
  }
  
  public static Response success(Object paramObject, Cache.Entry paramEntry)
  {
    return new Response(paramObject, paramEntry);
  }
  
  public boolean isSuccess()
  {
    return error == null;
  }
  
  public static abstract interface ErrorListener
  {
    public abstract void onErrorResponse(VolleyError paramVolleyError);
  }
  
  public static abstract interface Listener<T>
  {
    public abstract void onResponse(Object paramObject);
  }
}
