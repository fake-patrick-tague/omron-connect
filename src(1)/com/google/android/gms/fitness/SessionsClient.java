package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResponse;
import com.google.android.gms.internal.fitness.zzav;
import com.google.android.gms.internal.fitness.zzeb;
import com.google.android.gms.tasks.Task;

public class SessionsClient
  extends com.google.android.gms.common.api.GoogleApi<com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions>
{
  private static final SessionsApi zzla = new zzeb();
  
  SessionsClient(Activity paramActivity, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramActivity, zzav.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  protected SessionsClient(Context paramContext, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramContext, zzav.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task insertSession(SessionInsertRequest paramSessionInsertRequest)
  {
    return PendingResultUtil.toVoidTask(zzla.insertSession(asGoogleApiClient(), paramSessionInsertRequest));
  }
  
  public Task readSession(SessionReadRequest paramSessionReadRequest)
  {
    return PendingResultUtil.toResponseTask(zzla.readSession(asGoogleApiClient(), paramSessionReadRequest), new SessionReadResponse());
  }
  
  public Task registerForSessions(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzla.registerForSessions(asGoogleApiClient(), paramPendingIntent));
  }
  
  public Task startSession(com.google.android.gms.fitness.data.Session paramSession)
  {
    return PendingResultUtil.toVoidTask(zzla.startSession(asGoogleApiClient(), paramSession));
  }
  
  public Task stopSession(String paramString)
  {
    return PendingResultUtil.toTask(zzla.stopSession(asGoogleApiClient(), paramString), Session.zzjz);
  }
  
  public Task unregisterForSessions(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzla.unregisterForSessions(asGoogleApiClient(), paramPendingIntent));
  }
}
