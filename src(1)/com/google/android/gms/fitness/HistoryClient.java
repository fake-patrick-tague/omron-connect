package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.internal.fitness.zzad;
import com.google.android.gms.internal.fitness.zzde;
import com.google.android.gms.tasks.Task;

public class HistoryClient
  extends com.google.android.gms.common.api.GoogleApi<com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions>
{
  private static final HistoryApi zzku = new zzde();
  
  HistoryClient(Activity paramActivity, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramActivity, zzad.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  protected HistoryClient(Context paramContext, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramContext, zzad.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task deleteData(DataDeleteRequest paramDataDeleteRequest)
  {
    return PendingResultUtil.toVoidTask(zzku.deleteData(asGoogleApiClient(), paramDataDeleteRequest));
  }
  
  public Task insertData(DataSet paramDataSet)
  {
    return PendingResultUtil.toVoidTask(zzku.insertData(asGoogleApiClient(), paramDataSet));
  }
  
  public Task readDailyTotal(DataType paramDataType)
  {
    return PendingResultUtil.toTask(zzku.readDailyTotal(asGoogleApiClient(), paramDataType), UnsignedInteger.zzjz);
  }
  
  public Task readDailyTotalFromLocalDevice(DataType paramDataType)
  {
    return PendingResultUtil.toTask(zzku.readDailyTotalFromLocalDevice(asGoogleApiClient(), paramDataType), RomkanHalfKatakana.zzjz);
  }
  
  public Task readData(DataReadRequest paramDataReadRequest)
  {
    return PendingResultUtil.toResponseTask(zzku.readData(asGoogleApiClient(), paramDataReadRequest), new DataReadResponse());
  }
  
  public Task registerDataUpdateListener(DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest)
  {
    return PendingResultUtil.toVoidTask(zzku.registerDataUpdateListener(asGoogleApiClient(), paramDataUpdateListenerRegistrationRequest));
  }
  
  public Task unregisterDataUpdateListener(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzku.unregisterDataUpdateListener(asGoogleApiClient(), paramPendingIntent));
  }
  
  public Task updateData(DataUpdateRequest paramDataUpdateRequest)
  {
    return PendingResultUtil.toVoidTask(zzku.updateData(asGoogleApiClient(), paramDataUpdateRequest));
  }
}
