package com.google.android.gms.common.package_12.internal;

import c.e.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.AvailabilityException;
import com.google.android.gms.common.package_12.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;

public final class Metadata
{
  private final TaskCompletionSource<Map<com.google.android.gms.common.api.internal.ApiKey<?>, String>> TAG = new TaskCompletionSource();
  private final a<com.google.android.gms.common.api.internal.ApiKey<?>, ConnectionResult> data = new ArrayMap();
  private int size;
  private final a<com.google.android.gms.common.api.internal.ApiKey<?>, String> this$0 = new ArrayMap();
  private boolean version = false;
  
  public Metadata(Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      HasApiKey localHasApiKey = (HasApiKey)paramIterable.next();
      data.put(localHasApiKey.getApiKey(), null);
    }
    size = data.keySet().size();
  }
  
  public final Task getTask()
  {
    return TAG.getTask();
  }
  
  public final Set keySet()
  {
    return data.keySet();
  }
  
  public final void parse(ApiKey paramApiKey, ConnectionResult paramConnectionResult, String paramString)
  {
    data.put(paramApiKey, paramConnectionResult);
    this$0.put(paramApiKey, paramString);
    size -= 1;
    if (!paramConnectionResult.isSuccess()) {
      version = true;
    }
    if (size == 0)
    {
      if (version)
      {
        paramApiKey = new AvailabilityException(data);
        TAG.setException(paramApiKey);
        return;
      }
      TAG.setResult(this$0);
    }
  }
}
