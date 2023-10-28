package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.common.package_12.internal.ListenerHolders;
import com.google.android.gms.common.package_12.internal.RegistrationMethods;
import com.google.android.gms.common.package_12.internal.RegistrationMethods.Builder;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.internal.fitness.zzap;
import com.google.android.gms.internal.fitness.zzdx;
import com.google.android.gms.tasks.Task;

public class SensorsClient
  extends com.google.android.gms.common.api.GoogleApi<com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions>
{
  private static final SensorsApi zzkw = new zzdx();
  
  SensorsClient(Activity paramActivity, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramActivity, zzap.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  protected SensorsClient(Context paramContext, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramContext, zzap.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task findDataSources(DataSourcesRequest paramDataSourcesRequest)
  {
    return PendingResultUtil.toTask(zzkw.findDataSources(asGoogleApiClient(), paramDataSourcesRequest), Romkan.zzjz);
  }
  
  public Task items(SensorRequest paramSensorRequest, PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzkw.enqueue(asGoogleApiClient(), paramSensorRequest, paramPendingIntent));
  }
  
  public Task onCreateView(SensorRequest paramSensorRequest, OnDataPointListener paramOnDataPointListener)
  {
    paramOnDataPointListener = registerListener(paramOnDataPointListener, OnDataPointListener.class.getSimpleName());
    return doRegisterEventListener(RegistrationMethods.builder().withHolder(paramOnDataPointListener).register(new IQTypeFilter(this, paramOnDataPointListener, paramSensorRequest)).unregister(new SocketConnector(this, paramOnDataPointListener)).build());
  }
  
  public Task remove(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzkw.remove(asGoogleApiClient(), paramPendingIntent));
  }
  
  public Task remove(OnDataPointListener paramOnDataPointListener)
  {
    return doUnregisterEventListener(ListenerHolders.createListenerKey(paramOnDataPointListener, OnDataPointListener.class.getSimpleName()));
  }
}
