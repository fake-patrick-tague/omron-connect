package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.package_12.Releasable;
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;

@KeepForSdk
public abstract class DataHolderResult
  implements Result, Releasable
{
  @KeepForSdk
  protected final DataHolder mDataHolder;
  @KeepForSdk
  protected final Status mStatus;
  
  protected DataHolderResult(DataHolder paramDataHolder)
  {
    this(paramDataHolder, new Status(paramDataHolder.getStatusCode()));
  }
  
  protected DataHolderResult(DataHolder paramDataHolder, Status paramStatus)
  {
    mStatus = paramStatus;
    mDataHolder = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return mStatus;
  }
  
  public void release()
  {
    DataHolder localDataHolder = mDataHolder;
    if (localDataHolder != null) {
      localDataHolder.close();
    }
  }
}
