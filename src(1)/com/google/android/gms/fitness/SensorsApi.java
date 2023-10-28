package com.google.android.gms.fitness;

import android.app.PendingIntent;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;

@Deprecated
public abstract interface SensorsApi
{
  public abstract PendingResult enqueue(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, PendingIntent paramPendingIntent);
  
  public abstract PendingResult enqueue(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, OnDataPointListener paramOnDataPointListener);
  
  public abstract PendingResult findDataSources(GoogleApiClient paramGoogleApiClient, DataSourcesRequest paramDataSourcesRequest);
  
  public abstract PendingResult remove(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult remove(GoogleApiClient paramGoogleApiClient, OnDataPointListener paramOnDataPointListener);
}
