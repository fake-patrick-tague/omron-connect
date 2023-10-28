package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.package_12.internal.ConnectionCallbacks;
import com.google.android.gms.common.package_12.internal.OnConnectionFailedListener;
import com.google.android.gms.internal.base.Menu;

public final class IQ
  extends GmsClient<zai>
{
  private final TelemetryLoggingOptions reader;
  
  public IQ(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, TelemetryLoggingOptions paramTelemetryLoggingOptions, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 270, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    reader = paramTelemetryLoggingOptions;
  }
  
  public final Feature[] getApiFeatures()
  {
    return Menu.LAST;
  }
  
  protected final Bundle getGetServiceRequestExtraArgs()
  {
    return reader.readMessage();
  }
  
  public final int getMinApkVersion()
  {
    return 203400000;
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.common.internal.service.IClientTelemetryService";
  }
  
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.common.telemetry.service.START";
  }
  
  protected final boolean getUseDynamicLookup()
  {
    return true;
  }
}
