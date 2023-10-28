package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzaj;
import com.google.android.gms.internal.fitness.zzdo;
import com.google.android.gms.tasks.Task;

public class RecordingClient
  extends com.google.android.gms.common.api.GoogleApi<com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions>
{
  private static final RecordingApi zzkv = new zzdo();
  
  RecordingClient(Activity paramActivity, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramActivity, zzaj.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  protected RecordingClient(Context paramContext, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramContext, zzaj.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task listSubscriptions()
  {
    return PendingResultUtil.toTask(zzkv.listSubscriptions(asGoogleApiClient()), MainActivity.21.zzjz);
  }
  
  public Task listSubscriptions(DataType paramDataType)
  {
    return PendingResultUtil.toTask(zzkv.listSubscriptions(asGoogleApiClient(), paramDataType), SymbolList.zzjz);
  }
  
  public Task subscribe(DataSource paramDataSource)
  {
    return PendingResultUtil.toVoidTask(zzkv.subscribe(asGoogleApiClient(), paramDataSource));
  }
  
  public Task subscribe(DataType paramDataType)
  {
    return PendingResultUtil.toVoidTask(zzkv.subscribe(asGoogleApiClient(), paramDataType));
  }
  
  public Task unsubscribe(DataSource paramDataSource)
  {
    return PendingResultUtil.toVoidTask(zzkv.unsubscribe(asGoogleApiClient(), paramDataSource));
  }
  
  public Task unsubscribe(DataType paramDataType)
  {
    return PendingResultUtil.toVoidTask(zzkv.unsubscribe(asGoogleApiClient(), paramDataType));
  }
  
  public Task unsubscribe(Subscription paramSubscription)
  {
    return PendingResultUtil.toVoidTask(zzkv.unsubscribe(asGoogleApiClient(), paramSubscription));
  }
}
