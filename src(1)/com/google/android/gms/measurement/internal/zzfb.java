package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.SecureRandom;

public final class zzfb
{
  @VisibleForTesting
  final String buffer;
  private final String count;
  private final String current;
  private final long previous;
  
  private final void commit()
  {
    this$0.append();
    long l = this$0.this$0.zzav().currentTimeMillis();
    SharedPreferences.Editor localEditor = this$0.get().edit();
    localEditor.remove(count);
    localEditor.remove(current);
    localEditor.putLong(buffer, l);
    localEditor.apply();
  }
  
  private final long getLong()
  {
    return this$0.get().getLong(buffer, 0L);
  }
  
  public final void set(String paramString, long paramLong)
  {
    this$0.append();
    if (getLong() == 0L) {
      commit();
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    long l1 = this$0.get().getLong(count, 0L);
    if (l1 <= 0L)
    {
      paramString = this$0.get().edit();
      paramString.putString(current, str);
      paramString.putLong(count, 1L);
      paramString.apply();
      return;
    }
    paramLong = this$0.this$0.get().iterator().nextLong();
    l1 += 1L;
    long l2 = Long.MAX_VALUE / l1;
    paramString = this$0.get().edit();
    if ((0x7FFFFFFFFFFFFFFF & paramLong) < l2) {
      paramString.putString(current, str);
    }
    paramString.putLong(count, l1);
    paramString.apply();
  }
  
  public final Pair update()
  {
    this$0.append();
    Object localObject = this$0;
    zzfb localZzfb = this;
    ((zzgr)localObject).append();
    long l1 = localZzfb.getLong();
    if (l1 == 0L)
    {
      localZzfb.commit();
      l1 = 0L;
    }
    else
    {
      l1 = Math.abs(l1 - this$0.this$0.zzav().currentTimeMillis());
    }
    localZzfb = this;
    long l2 = previous;
    if (l1 < l2) {
      return null;
    }
    if (l1 > l2 + l2)
    {
      localZzfb.commit();
      return null;
    }
    localObject = this$0.get().getString(current, null);
    l1 = this$0.get().getLong(count, 0L);
    localZzfb.commit();
    if ((localObject != null) && (l1 > 0L)) {
      return new Pair(localObject, Long.valueOf(l1));
    }
    return zzfd.text;
  }
}
