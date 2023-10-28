package com.google.android.gms.internal.auth-api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.util.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.util.Auth.AuthCredentialsOptions.Builder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;

public final class Configurable
  extends GmsClient<zbt>
{
  private final Auth.AuthCredentialsOptions dateFormat;
  
  public Configurable(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 68, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    paramContext = paramAuthCredentialsOptions;
    if (paramAuthCredentialsOptions == null) {
      paramContext = Auth.AuthCredentialsOptions.PARAM_ERROR;
    }
    paramContext = new Auth.AuthCredentialsOptions.Builder(paramContext);
    paramContext.encrypt(zbax.encrypt());
    dateFormat = new Auth.AuthCredentialsOptions(paramContext);
  }
  
  final Auth.AuthCredentialsOptions getDateFormat()
  {
    return dateFormat;
  }
  
  protected final Bundle getGetServiceRequestExtraArgs()
  {
    return dateFormat.doInBackground();
  }
  
  public final int getMinApkVersion()
  {
    return 12800000;
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
  }
  
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.credentials.service.START";
  }
}
