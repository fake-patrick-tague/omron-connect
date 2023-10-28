package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

public final class FutureTask
  extends zzai
{
  private final Callable callable;
  
  public FutureTask(String paramString, Callable paramCallable)
  {
    super("internal.appMetadata");
    callable = paramCallable;
  }
  
  public final zzap get(Headers paramHeaders, List paramList)
  {
    paramHeaders = callable;
    try
    {
      paramHeaders = TFloatList.set(paramHeaders.call());
      return paramHeaders;
    }
    catch (Exception paramHeaders)
    {
      for (;;) {}
    }
    return zzap.this$0;
  }
}
