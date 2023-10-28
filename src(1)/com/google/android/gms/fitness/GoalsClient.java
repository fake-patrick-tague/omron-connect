package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.internal.fitness.SpecialListsProgressProperty.OPERATION;
import com.google.android.gms.internal.fitness.zzdd;
import com.google.android.gms.tasks.Task;

public class GoalsClient
  extends com.google.android.gms.common.api.GoogleApi<com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions>
{
  private static final GoalsApi zzkn = new zzdd();
  
  GoalsClient(Activity paramActivity, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramActivity, SpecialListsProgressProperty.OPERATION.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  protected GoalsClient(Context paramContext, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramContext, SpecialListsProgressProperty.OPERATION.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task readCurrentGoals(GoalsReadRequest paramGoalsReadRequest)
  {
    return PendingResultUtil.toTask(zzkn.readCurrentGoals(asGoogleApiClient(), paramGoalsReadRequest), RomkanFullKatakana.zzjz);
  }
}
