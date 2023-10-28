package com.google.android.gms.common.stats;

import android.content.ComponentName;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class LoggingConstants
{
  @Deprecated
  @KeepForSdk
  public static final String EXTRA_WAKE_LOCK_KEY = "WAKE_LOCK_KEY";
  public static final ComponentName cn = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
  
  private LoggingConstants() {}
}
