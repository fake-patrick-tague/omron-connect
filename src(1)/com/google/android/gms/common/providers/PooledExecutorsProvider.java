package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@Deprecated
@KeepForSdk
public class PooledExecutorsProvider
{
  private static PooledExecutorFactory _theInstance;
  
  private PooledExecutorsProvider() {}
  
  public static PooledExecutorFactory getInstance()
  {
    try
    {
      if (_theInstance == null) {
        _theInstance = new UnsignedInteger();
      }
      PooledExecutorFactory localPooledExecutorFactory = _theInstance;
      return localPooledExecutorFactory;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static abstract interface PooledExecutorFactory
  {
    public abstract ScheduledExecutorService newSingleThreadScheduledExecutor();
  }
}
