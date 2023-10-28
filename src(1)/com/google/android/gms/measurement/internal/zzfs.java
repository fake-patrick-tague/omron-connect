package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzfs
  implements Thread.UncaughtExceptionHandler
{
  private final String mApp;
  
  public zzfs(zzfv paramZzfv, String paramString)
  {
    Preconditions.checkNotNull(paramString);
    mApp = paramString;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      mContext.this$0.zzay().iterator().append(mApp, paramThrowable);
      return;
    }
    catch (Throwable paramThread)
    {
      throw paramThread;
    }
  }
}
