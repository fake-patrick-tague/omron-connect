package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.package_12.Attribute;

public final class Common
{
  @KeepForSdk
  public static final com.google.android.gms.common.api.Api.ClientKey<zah> CLIENT_KEY;
  @KeepForSdk
  public static final Api<Api.ApiOptions.NoOptions> context;
  private static final Api.AbstractClientBuilder<zah, Api.ApiOptions.NoOptions> dateFormat;
  public static final Preferences prefs = new Preferences();
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    CLIENT_KEY = localClientKey;
    BackupWrapper.FroyoAndBeyond localFroyoAndBeyond = new BackupWrapper.FroyoAndBeyond();
    dateFormat = localFroyoAndBeyond;
    context = new Attribute("Common.API", localFroyoAndBeyond, localClientKey);
  }
  
  public Common() {}
}
