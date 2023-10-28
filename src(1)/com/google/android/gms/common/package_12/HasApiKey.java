package com.google.android.gms.common.package_12;

import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.package_12.internal.ApiKey;

public abstract interface HasApiKey<O extends Api.ApiOptions>
{
  public abstract ApiKey getApiKey();
}
