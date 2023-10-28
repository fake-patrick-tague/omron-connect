package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzoe;

final class zzkg
{
  @VisibleForTesting
  protected long count;
  private final zzap text;
  @VisibleForTesting
  protected long value;
  
  public zzkg(zzki paramZzki)
  {
    text = new zzkf(this, this$0);
    long l = this$0.zzav().elapsedRealtime();
    value = l;
    count = l;
  }
  
  final void onSuccess(long paramLong)
  {
    text.close();
  }
  
  final void pack()
  {
    text.close();
    value = 0L;
    count = 0L;
  }
  
  final void put(long paramLong)
  {
    this$0.append();
    text.close();
    value = paramLong;
    count = paramLong;
  }
  
  public final boolean update(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this$0.append();
    this$0.next();
    zzoe.showMessageDetails();
    if (this$0.this$0.append().get(null, zzeb.zzad))
    {
      if (this$0.this$0.size()) {
        this$0.this$0.put().index.put(this$0.this$0.zzav().currentTimeMillis());
      }
    }
    else {
      this$0.this$0.put().index.put(this$0.this$0.zzav().currentTimeMillis());
    }
    long l = paramLong - value;
    if ((!paramBoolean1) && (l < 1000L))
    {
      this$0.this$0.zzay().next().append("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(l));
      return false;
    }
    if (!paramBoolean2)
    {
      l = paramLong - count;
      count = paramLong;
    }
    this$0.this$0.zzay().next().append("Recording user engagement, ms", Long.valueOf(l));
    Bundle localBundle = new Bundle();
    localBundle.putLong("_et", l);
    paramBoolean1 = this$0.this$0.append().d();
    zzlh.add(this$0.this$0.d().get(paramBoolean1 ^ true), localBundle, true);
    if (!paramBoolean2) {
      this$0.this$0.add().put("auto", "_e", localBundle);
    }
    value = paramLong;
    text.close();
    text.close(3600000L);
    return true;
  }
}
