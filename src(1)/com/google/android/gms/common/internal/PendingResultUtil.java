package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.Response;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class PendingResultUtil
{
  private static final EventFilter filter = new NameFilter();
  
  public PendingResultUtil() {}
  
  public static Task toResponseTask(PendingResult paramPendingResult, Response paramResponse)
  {
    return toTask(paramPendingResult, new AbstractConverter(paramResponse));
  }
  
  public static Task toTask(PendingResult paramPendingResult, ResultConverter paramResultConverter)
  {
    EventFilter localEventFilter = filter;
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramPendingResult.addStatusListener(new MainActivity.2(paramPendingResult, localTaskCompletionSource, paramResultConverter, localEventFilter));
    return localTaskCompletionSource.getTask();
  }
  
  public static Task toVoidTask(PendingResult paramPendingResult)
  {
    return toTask(paramPendingResult, new TypeConverter());
  }
  
  @KeepForSdk
  public static abstract interface ResultConverter<R extends com.google.android.gms.common.api.Result, T>
  {
    public abstract Object convert(com.google.android.gms.common.package_12.Result paramResult);
  }
}
