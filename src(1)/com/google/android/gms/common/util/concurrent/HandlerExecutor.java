package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.Util;
import java.util.concurrent.Executor;

@KeepForSdk
public class HandlerExecutor
  implements Executor
{
  private final Handler mainHandler;
  
  public HandlerExecutor(Looper paramLooper)
  {
    mainHandler = new Util(paramLooper);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    mainHandler.post(paramRunnable);
  }
}
