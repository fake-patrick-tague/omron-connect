package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class RootTelemetryConfigManager
{
  private static RootTelemetryConfigManager _theInstance;
  private static final RootTelemetryConfiguration available = new RootTelemetryConfiguration(0, false, false, 0, 0);
  private RootTelemetryConfiguration config;
  
  private RootTelemetryConfigManager() {}
  
  public static RootTelemetryConfigManager getInstance()
  {
    try
    {
      if (_theInstance == null) {
        _theInstance = new RootTelemetryConfigManager();
      }
      RootTelemetryConfigManager localRootTelemetryConfigManager = _theInstance;
      return localRootTelemetryConfigManager;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public RootTelemetryConfiguration getConfig()
  {
    return config;
  }
  
  public final void toString(RootTelemetryConfiguration paramRootTelemetryConfiguration)
  {
    if (paramRootTelemetryConfiguration == null) {}
    try
    {
      config = available;
      return;
    }
    catch (Throwable paramRootTelemetryConfiguration)
    {
      RootTelemetryConfiguration localRootTelemetryConfiguration;
      int i;
      int j;
      throw paramRootTelemetryConfiguration;
    }
    localRootTelemetryConfiguration = config;
    if (localRootTelemetryConfiguration != null)
    {
      i = localRootTelemetryConfiguration.getVersion();
      j = paramRootTelemetryConfiguration.getVersion();
      if (i >= j) {
        return;
      }
    }
    config = paramRootTelemetryConfiguration;
  }
}
