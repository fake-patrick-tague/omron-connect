package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.package_12.GoogleApiClient;

final class AbstractHttpClient
  extends CloseableHttpClient
{
  AbstractHttpClient(Preferences paramPreferences, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
}
