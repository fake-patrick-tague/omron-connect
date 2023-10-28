package com.google.android.gms.analytics.licenses;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.oss.licenses.zzn;

public final class Connection
  extends com.google.android.gms.common.api.GoogleApi<Api.ApiOptions.NoOptions>
{
  private static final com.google.android.gms.common.api.Api.ClientKey<zzn> CLIENT_KEY;
  private static final Api.AbstractClientBuilder<zzn, Api.ApiOptions.NoOptions> TAG;
  private static final Api<Api.ApiOptions.NoOptions> generator;
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    CLIENT_KEY = localClientKey;
    Transport localTransport = new Transport();
    TAG = localTransport;
    generator = new Attribute("OssLicensesService.API", localTransport, localClientKey);
  }
  
  Connection(Context paramContext)
  {
    super(paramContext, generator, null, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
}
