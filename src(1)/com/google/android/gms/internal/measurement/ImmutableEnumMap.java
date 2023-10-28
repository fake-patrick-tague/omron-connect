package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class ImmutableEnumMap
  extends zzai
{
  final Map delegate = new HashMap();
  private final AsyncHttpClient type;
  
  public ImmutableEnumMap(AsyncHttpClient paramAsyncHttpClient)
  {
    super("require");
    type = paramAsyncHttpClient;
  }
  
  public final zzap get(Headers paramHeaders, List paramList)
  {
    ByteVector.set("require", 1, paramList);
    paramList = paramHeaders.get((zzap)paramList.get(0)).getValue();
    if (delegate.containsKey(paramList)) {
      return (zzap)delegate.get(paramList);
    }
    paramHeaders = type;
    if (context.containsKey(paramList)) {
      paramHeaders = (Callable)context.get(paramList);
    }
    try
    {
      paramHeaders = paramHeaders.call();
      paramHeaders = (zzap)paramHeaders;
    }
    catch (Exception paramHeaders)
    {
      for (;;) {}
    }
    throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(paramList)));
    paramHeaders = zzap.this$0;
    if ((paramHeaders instanceof zzai))
    {
      delegate.put(paramList, (zzai)paramHeaders);
      return paramHeaders;
    }
    return paramHeaders;
  }
}
