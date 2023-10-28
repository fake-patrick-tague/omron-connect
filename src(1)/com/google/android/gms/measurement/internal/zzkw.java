package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzke;
import java.util.ArrayList;
import java.util.List;

final class zzkw
{
  List cache;
  long index;
  List stack;
  zzgc this$0;
  
  private static final long getListTime(zzfs paramZzfs)
  {
    return paramZzfs.read() / 1000L / 60L / 60L;
  }
  
  public final boolean add(long paramLong, zzfs paramZzfs)
  {
    Preconditions.checkNotNull(paramZzfs);
    if (stack == null) {
      stack = new ArrayList();
    }
    if (cache == null) {
      cache = new ArrayList();
    }
    if ((!stack.isEmpty()) && (getListTime((zzfs)stack.get(0)) != getListTime(paramZzfs))) {
      return false;
    }
    long l = index + paramZzfs.zzbw();
    value.getInstance();
    if (l >= Math.max(0, ((Integer)zzeb.key.get(null)).intValue())) {
      return false;
    }
    index = l;
    stack.add(paramZzfs);
    cache.add(Long.valueOf(paramLong));
    int i = stack.size();
    value.getInstance();
    return i < Math.max(1, ((Integer)zzeb.time.get(null)).intValue());
  }
}
