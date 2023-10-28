package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzag;
import java.util.AbstractCollection;
import java.util.List;

final class Vec2
{
  private zzag body = zzag.empty();
  private long offset = -1L;
  private zzag state = zzag.empty();
  private String table = null;
  
  Vec2() {}
  
  final Vec2 add(long paramLong)
  {
    offset = paramLong;
    return this;
  }
  
  final Vec2 add(String paramString)
  {
    table = paramString;
    return this;
  }
  
  final Vec2 add(List paramList)
  {
    Preconditions.checkNotNull(paramList);
    body = zzag.create(paramList);
    return this;
  }
  
  final zzab add()
  {
    if (table != null)
    {
      if (offset >= 0L)
      {
        if ((state.isEmpty()) && (body.isEmpty())) {
          throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new zzab(table, offset, state, body, null);
      }
      throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
    }
    throw new IllegalStateException("packageName must be defined");
  }
  
  final Vec2 set(List paramList)
  {
    Preconditions.checkNotNull(paramList);
    state = zzag.create(paramList);
    return this;
  }
}
