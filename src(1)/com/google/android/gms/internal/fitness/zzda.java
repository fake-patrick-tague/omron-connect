package com.google.android.gms.internal.fitness;

import com.google.android.gms.fitness.result.DataTypeResult;

final class zzda
  extends zzbl
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<DataTypeResult> zzpa;
  
  private zzda(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    zzpa = paramResultHolder;
  }
  
  public final void openDB(DataTypeResult paramDataTypeResult)
  {
    zzpa.setResult(paramDataTypeResult);
  }
}
