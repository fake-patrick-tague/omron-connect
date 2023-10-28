package com.google.android.gms.common.package_12;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final com.google.android.gms.common.api.PendingResult<?>[] mIconSize;
  private final Status mStatus;
  
  BatchResult(Status paramStatus, PendingResult[] paramArrayOfPendingResult)
  {
    mStatus = paramStatus;
    mIconSize = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return mStatus;
  }
  
  public Result take(BatchResultToken paramBatchResultToken)
  {
    boolean bool;
    if (mIconSize < mIconSize.length) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "The result token does not belong to this batch");
    return mIconSize[mIconSize].await(0L, TimeUnit.MILLISECONDS);
  }
}
