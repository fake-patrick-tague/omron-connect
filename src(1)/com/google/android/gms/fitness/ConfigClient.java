package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.internal.fitness.SpecialListsDueProperty.Unit;
import com.google.android.gms.internal.fitness.zzcw;
import com.google.android.gms.tasks.Task;

public class ConfigClient
  extends com.google.android.gms.common.api.GoogleApi<com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions>
{
  private static final ConfigApi zzke = new zzcw();
  
  ConfigClient(Activity paramActivity, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramActivity, SpecialListsDueProperty.Unit.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  protected ConfigClient(Context paramContext, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramContext, SpecialListsDueProperty.Unit.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task createCustomDataType(DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    return PendingResultUtil.toTask(zzke.createCustomDataType(asGoogleApiClient(), paramDataTypeCreateRequest), ContentSource.zzjz);
  }
  
  public Task disableFit()
  {
    return PendingResultUtil.toVoidTask(zzke.disableFit(asGoogleApiClient()));
  }
  
  public Task readDataType(String paramString)
  {
    return PendingResultUtil.toTask(zzke.readDataType(asGoogleApiClient(), paramString), MXParser.zzjz);
  }
}
