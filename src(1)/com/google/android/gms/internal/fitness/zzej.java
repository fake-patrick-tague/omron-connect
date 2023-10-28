package com.google.android.gms.internal.fitness;

import com.google.android.gms.fitness.result.SessionStopResult;

final class zzej
  extends zzcl
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<SessionStopResult> zzpa;
  
  private zzej(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    zzpa = paramResultHolder;
  }
  
  public final void openDB(SessionStopResult paramSessionStopResult)
  {
    zzpa.setResult(paramSessionStopResult);
  }
}
