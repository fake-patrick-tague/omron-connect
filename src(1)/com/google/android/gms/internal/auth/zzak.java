package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.util.AuthProxy;
import com.google.android.gms.auth.util.AuthProxyOptions;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import java.util.Set;

public final class zzak
  extends GmsClient<zzan>
{
  private final Bundle zzbv;
  
  public zzak(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, AuthProxyOptions paramAuthProxyOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 16, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramAuthProxyOptions == null)
    {
      zzbv = new Bundle();
      return;
    }
    throw new NoSuchMethodError();
  }
  
  protected final Bundle getGetServiceRequestExtraArgs()
  {
    return zzbv;
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.internal.IAuthService";
  }
  
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.service.START";
  }
  
  public final boolean requiresSignIn()
  {
    ClientSettings localClientSettings = getClientSettings();
    return (!TextUtils.isEmpty(localClientSettings.getAccountName())) && (!localClientSettings.getApplicableScopes(AuthProxy.FIXED).isEmpty());
  }
}
