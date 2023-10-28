package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;

public final class Preferences
{
  public Preferences() {}
  
  public final PendingResult getString(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.execute(new AbstractHttpClient(this, paramGoogleApiClient));
  }
}
