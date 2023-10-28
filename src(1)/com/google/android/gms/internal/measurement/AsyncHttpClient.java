package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class AsyncHttpClient
{
  final Map context = new HashMap();
  
  public AsyncHttpClient() {}
  
  public final void get(String paramString, Callable paramCallable)
  {
    context.put(paramString, paramCallable);
  }
}
