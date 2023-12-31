package com.android.volley;

public abstract interface ResponseDelivery
{
  public abstract void postError(Request paramRequest, VolleyError paramVolleyError);
  
  public abstract void postResponse(Request paramRequest, Response paramResponse);
  
  public abstract void postResponse(Request paramRequest, Response paramResponse, Runnable paramRunnable);
}
