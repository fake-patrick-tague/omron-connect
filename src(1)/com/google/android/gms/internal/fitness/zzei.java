package com.google.android.gms.internal.fitness;

import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzei
  extends zzcm
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<com.google.android.gms.common.api.Status> zzpa;
  
  public zzei(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    zzpa = paramResultHolder;
  }
  
  public static zzei getSessions(TaskCompletionSource paramTaskCompletionSource)
  {
    return new zzei(new zzel(paramTaskCompletionSource));
  }
  
  public static zzei getTransform(TaskCompletionSource paramTaskCompletionSource)
  {
    return new zzei(new zzek(paramTaskCompletionSource));
  }
  
  public final void onResult(com.google.android.gms.common.package_12.Status paramStatus)
  {
    zzpa.setResult(paramStatus);
  }
}
