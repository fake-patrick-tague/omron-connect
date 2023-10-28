package com.google.android.gms.common.internal;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.service.Logger;

@KeepForSdk
public class TelemetryLogging
{
  private TelemetryLogging() {}
  
  public static TelemetryLoggingClient getClient(Context paramContext)
  {
    return getClient(paramContext, TelemetryLoggingOptions.client);
  }
  
  public static TelemetryLoggingClient getClient(Context paramContext, TelemetryLoggingOptions paramTelemetryLoggingOptions)
  {
    return new Logger(paramContext, paramTelemetryLoggingOptions);
  }
}
