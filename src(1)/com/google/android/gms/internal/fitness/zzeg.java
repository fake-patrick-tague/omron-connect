package com.google.android.gms.internal.fitness;

import com.google.android.gms.fitness.result.SessionReadResult;

final class zzeg
  extends zzcg
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<SessionReadResult> zzpa;
  
  private zzeg(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    zzpa = paramResultHolder;
  }
  
  public final void openDB(SessionReadResult paramSessionReadResult)
  {
    zzpa.setResult(paramSessionReadResult);
  }
}
