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

public final class OutlineItem
  extends zzj<zzbo>
{
  private static final com.google.android.gms.common.api.Api.ClientKey<zzk> CLIENT_KEY;
  public static final Api<Api.ApiOptions.NoOptions> label;
  private static final zzf.zza zzoy = zzf.zza.zzbn;
  public static final Api<Api.ApiOptions.HasGoogleSignInAccountOptions> zzoz;
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    CLIENT_KEY = localClientKey;
    label = new Attribute("Fitness.BLE_API", new SettingsActivity.2(), localClientKey);
    zzoz = new Attribute("Fitness.BLE_CLIENT", new ASN1Null(null), localClientKey);
  }
  
  private OutlineItem(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, zzoy, paramConnectionCallbacks, paramOnConnectionFailedListener, paramClientSettings);
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.fitness.internal.IGoogleFitBleApi";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.fitness.BleApi";
  }
}
