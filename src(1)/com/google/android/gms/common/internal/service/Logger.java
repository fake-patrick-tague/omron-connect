package com.google.android.gms.common.internal.service;

import android.content.Context;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.common.package_12.internal.TaskApiCall;
import com.google.android.gms.common.package_12.internal.TaskApiCall.Builder;
import com.google.android.gms.internal.base.Menu;
import com.google.android.gms.tasks.Task;

public final class Logger
  extends com.google.android.gms.common.api.GoogleApi<TelemetryLoggingOptions>
  implements TelemetryLoggingClient
{
  private static final com.google.android.gms.common.api.Api.ClientKey<zap> enabled;
  private static final Api.AbstractClientBuilder<zap, TelemetryLoggingOptions> name;
  private static final Api<TelemetryLoggingOptions> pid;
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    enabled = localClientKey;
    BackupWrapper.PreFroyo localPreFroyo = new BackupWrapper.PreFroyo();
    name = localPreFroyo;
    pid = new Attribute("ClientTelemetry.API", localPreFroyo, localClientKey);
  }
  
  public Logger(Context paramContext, TelemetryLoggingOptions paramTelemetryLoggingOptions)
  {
    super(paramContext, pid, paramTelemetryLoggingOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public final Task getLocation(TelemetryData paramTelemetryData)
  {
    TaskApiCall.Builder localBuilder = TaskApiCall.builder();
    localBuilder.setFeatures(new Feature[] { Menu.FIRST });
    localBuilder.setAutoResolveMissingFeatures(false);
    localBuilder.bssid(new NameFilter(paramTelemetryData));
    return doBestEffortWrite(localBuilder.build());
  }
}
