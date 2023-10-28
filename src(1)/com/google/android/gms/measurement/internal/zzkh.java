package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.BaseBundle;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzoz;

final class zzkh
{
  zzkh(zzki paramZzki) {}
  
  final void add(long paramLong, boolean paramBoolean)
  {
    this$0.append();
    zzki.check(this$0);
    if (this$0.this$0.put().get(paramLong))
    {
      this$0.this$0.put().notes.put(true);
      zzoz.isEmpty();
      if (this$0.this$0.append().get(null, zzeb.zzas)) {
        this$0.this$0.getInstance().delete();
      }
    }
    this$0.this$0.put().index.put(paramLong);
    if (this$0.this$0.put().notes.get()) {
      update(paramLong, paramBoolean);
    }
  }
  
  final void isAlive()
  {
    this$0.append();
    if (this$0.this$0.put().get(this$0.this$0.zzav().currentTimeMillis()))
    {
      this$0.this$0.put().notes.put(true);
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if (importance == 100)
      {
        this$0.this$0.zzay().next().append("Detected application was in foreground");
        update(this$0.this$0.zzav().currentTimeMillis(), false);
      }
    }
  }
  
  final void update(long paramLong, boolean paramBoolean)
  {
    this$0.append();
    if (!this$0.this$0.size()) {
      return;
    }
    this$0.this$0.put().index.put(paramLong);
    long l = this$0.this$0.zzav().elapsedRealtime();
    this$0.this$0.zzay().next().append("Session started, time", Long.valueOf(l));
    Object localObject = Long.valueOf(paramLong / 1000L);
    this$0.this$0.add().set("auto", "_sid", localObject, paramLong);
    this$0.this$0.put().notes.put(false);
    Bundle localBundle = new Bundle();
    localBundle.putLong("_sid", ((Long)localObject).longValue());
    if ((this$0.this$0.append().get(null, zzeb.g)) && (paramBoolean)) {
      localBundle.putLong("_aib", 1L);
    }
    this$0.this$0.add().e("auto", "_s", paramLong, localBundle);
    zznv.play_next();
    if (this$0.this$0.append().get(null, zzeb.zzac))
    {
      localObject = this$0.this$0.put().count.getValue();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localBundle = new Bundle();
        localBundle.putString("_ffr", (String)localObject);
        this$0.this$0.add().e("auto", "_ssr", paramLong, localBundle);
      }
    }
  }
}
