package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzby;

abstract class zzap
{
  private static volatile Handler sHandler;
  private volatile long d;
  private final Runnable r;
  private final zzgt t;
  
  zzap(zzgt paramZzgt)
  {
    Preconditions.checkNotNull(paramZzgt);
    t = paramZzgt;
    r = new zzao(this, paramZzgt);
  }
  
  private final Handler getHandler()
  {
    if (sHandler != null) {
      return sHandler;
    }
    try
    {
      if (sHandler == null) {
        sHandler = new zzby(t.zzau().getMainLooper());
      }
      Handler localHandler = sHandler;
      return localHandler;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  final void close()
  {
    d = 0L;
    getHandler().removeCallbacks(r);
  }
  
  public final void close(long paramLong)
  {
    close();
    if (paramLong >= 0L)
    {
      d = t.zzav().currentTimeMillis();
      if (!getHandler().postDelayed(r, paramLong)) {
        t.zzay().iterator().append("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public abstract void doFetch();
  
  public final boolean equals()
  {
    return d != 0L;
  }
}
