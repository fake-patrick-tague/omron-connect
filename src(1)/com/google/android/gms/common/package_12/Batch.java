package com.google.android.gms.common.package_12;

import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends com.google.android.gms.common.api.internal.BasePendingResult<com.google.android.gms.common.api.BatchResult>
{
  private final Object index;
  private boolean isOnline;
  private int maxIndex;
  private boolean mute;
  private final com.google.android.gms.common.api.PendingResult<?>[] tasks;
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = tasks;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, tasks);
  }
  
  public final class Builder
  {
    private List<com.google.android.gms.common.api.PendingResult<?>> buf = new ArrayList();
    
    public Builder() {}
    
    public Batch build()
    {
      return new Batch(buf, Batch.this, null);
    }
    
    public BatchResultToken setPlaylist(PendingResult paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(buf.size());
      buf.add(paramPendingResult);
      return localBatchResultToken;
    }
  }
}
