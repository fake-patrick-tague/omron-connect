package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class DefaultClock
  implements Clock
{
  private static final DefaultClock SFTP = new DefaultClock();
  
  private DefaultClock() {}
  
  public static Clock getInstance()
  {
    return SFTP;
  }
  
  public final long currentThreadTimeMillis()
  {
    return SystemClock.currentThreadTimeMillis();
  }
  
  public final long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public final long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public final long nanoTime()
  {
    return System.nanoTime();
  }
}
