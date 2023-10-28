package com.google.android.gms.internal.fitness;

import com.google.android.gms.fitness.result.ListSubscriptionsResult;

final class zzdu
  extends zzcf
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<ListSubscriptionsResult> zzpa;
  
  private zzdu(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    zzpa = paramResultHolder;
  }
  
  public final void openDB(ListSubscriptionsResult paramListSubscriptionsResult)
  {
    zzpa.setResult(paramListSubscriptionsResult);
  }
}
