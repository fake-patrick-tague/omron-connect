package com.google.android.gms.internal.fitness;

import com.google.android.gms.fitness.result.DataSourcesResult;

public final class ChartData
  extends zzbg
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<DataSourcesResult> zzpa;
  
  public ChartData(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    zzpa = paramResultHolder;
  }
  
  public final void init(DataSourcesResult paramDataSourcesResult)
  {
    zzpa.setResult(paramDataSourcesResult);
  }
}
