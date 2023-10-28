package com.google.android.gms.internal.auth-api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.util.identity.Topic;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.package_12.internal.ConnectionCallbacks;
import com.google.android.gms.common.package_12.internal.OnConnectionFailedListener;

public final class zbav
  extends GmsClient<zbag>
{
  private final Bundle mOrigData = new Bundle();
  
  public zbav(Context paramContext, Looper paramLooper, Topic paramTopic, ClientSettings paramClientSettings, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 212, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public final Feature[] getApiFeatures()
  {
    return zbaw.JSON_EXCEPTION;
  }
  
  protected final Bundle getGetServiceRequestExtraArgs()
  {
    return mOrigData;
  }
  
  public final int getMinApkVersion()
  {
    return 17895000;
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.identity.internal.ISignInService";
  }
  
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.identity.service.signin.START";
  }
  
  protected final boolean getUseDynamicLookup()
  {
    return true;
  }
  
  public final boolean usesClientTelemetry()
  {
    return true;
  }
}
