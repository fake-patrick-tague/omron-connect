package com.google.android.gms.internal.auth-api;

final class ArrayDeque
  extends LongPreference
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<com.google.android.gms.common.api.Status> tail;
  
  ArrayDeque(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    tail = paramResultHolder;
  }
  
  public final void delete(com.google.android.gms.common.package_12.Status paramStatus)
  {
    tail.setResult(paramStatus);
  }
}
