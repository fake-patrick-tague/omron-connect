package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class zadc
{
  public static final Status LOG_TAG = new Status(8, "The connection to Google Play services was lost");
  @VisibleForTesting
  final Set<com.google.android.gms.common.api.internal.BasePendingResult<?>> data = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  private final zadb state = new zadb(this);
  
  public zadc() {}
  
  final void close(BasePendingResult paramBasePendingResult)
  {
    data.add(paramBasePendingResult);
    paramBasePendingResult.next(state);
  }
  
  public final void write()
  {
    Object localObject1 = data;
    int i = 0;
    localObject1 = (BasePendingResult[])((Set)localObject1).toArray(new BasePendingResult[0]);
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localObject2.next(null);
      if (localObject2.isCancelled()) {
        data.remove(localObject2);
      }
      i += 1;
    }
  }
}
