package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

final class zaaf
{
  private final TaskCompletionSource<Boolean> dialog = new TaskCompletionSource();
  private final com.google.android.gms.common.api.internal.ApiKey<?> resourcePath;
  
  public zaaf(ApiKey paramApiKey)
  {
    resourcePath = paramApiKey;
  }
  
  public final TaskCompletionSource create()
  {
    return dialog;
  }
  
  public final ApiKey getResourcePath()
  {
    return resourcePath;
  }
}
