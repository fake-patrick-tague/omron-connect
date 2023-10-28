package com.google.android.gms.internal.fitness;

import android.util.Log;
import com.google.android.gms.fitness.result.DataReadResult;

final class zzdp
  extends zzbf
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<DataReadResult> zzpa;
  private int zzpt = 0;
  private DataReadResult zzpu;
  
  private zzdp(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    zzpa = paramResultHolder;
  }
  
  public final void openDB(DataReadResult paramDataReadResult)
  {
    try
    {
      if (Log.isLoggable("Fitness", 2))
      {
        i = zzpt;
        localObject = new StringBuilder(33);
        ((StringBuilder)localObject).append("Received batch result ");
        ((StringBuilder)localObject).append(i);
        Log.v("Fitness", ((StringBuilder)localObject).toString());
      }
      Object localObject = zzpu;
      if (localObject == null) {
        zzpu = paramDataReadResult;
      } else {
        ((DataReadResult)localObject).setData(paramDataReadResult);
      }
      int i = zzpt + 1;
      zzpt = i;
      if (i == zzpu.zzab()) {
        zzpa.setResult(zzpu);
      }
      return;
    }
    catch (Throwable paramDataReadResult)
    {
      throw paramDataReadResult;
    }
  }
}
