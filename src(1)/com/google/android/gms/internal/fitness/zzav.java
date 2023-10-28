package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;

public final class zzav
  extends zzj<zzca>
{
  private static final com.google.android.gms.common.api.Api.ClientKey<zzav> CLIENT_KEY;
  public static final Api<Api.ApiOptions.NoOptions> FIXED;
  private static final zzf.zza zzoy = zzf.zza.zzbm;
  public static final Api<Api.ApiOptions.HasGoogleSignInAccountOptions> zzoz;
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    CLIENT_KEY = localClientKey;
    FIXED = new Attribute("Fitness.SESSIONS_API", new zzax(null), localClientKey);
    zzoz = new Attribute("Fitness.SESSIONS_CLIENT", new zzaz(null), localClientKey);
  }
  
  private zzav(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, zzoy, paramConnectionCallbacks, paramOnConnectionFailedListener, paramClientSettings);
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.fitness.SessionsApi";
  }
}
