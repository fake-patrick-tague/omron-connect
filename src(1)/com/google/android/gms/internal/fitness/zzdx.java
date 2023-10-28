package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.PendingResults;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.IDeathCallback_0_8;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzan;

public final class zzdx
  implements SensorsApi
{
  public zzdx() {}
  
  private final PendingResult enqueue(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, IDeathCallback_0_8 paramIDeathCallback_0_8, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.enqueue(new zzdz(this, paramGoogleApiClient, paramSensorRequest, paramIDeathCallback_0_8, paramPendingIntent));
  }
  
  private final PendingResult say(GoogleApiClient paramGoogleApiClient, IDeathCallback_0_8 paramIDeathCallback_0_8, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzdy(this, paramGoogleApiClient, paramIDeathCallback_0_8, paramPendingIntent));
  }
  
  public final PendingResult enqueue(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, PendingIntent paramPendingIntent)
  {
    return enqueue(paramGoogleApiClient, paramSensorRequest, null, paramPendingIntent);
  }
  
  public final PendingResult enqueue(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, OnDataPointListener paramOnDataPointListener)
  {
    return enqueue(paramGoogleApiClient, paramSensorRequest, zzan.get().call(paramOnDataPointListener, paramGoogleApiClient.getLooper()), null);
  }
  
  public final PendingResult findDataSources(GoogleApiClient paramGoogleApiClient, DataSourcesRequest paramDataSourcesRequest)
  {
    return paramGoogleApiClient.enqueue(new zzdw(this, paramGoogleApiClient, paramDataSourcesRequest));
  }
  
  public final PendingResult remove(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return say(paramGoogleApiClient, null, paramPendingIntent);
  }
  
  public final PendingResult remove(GoogleApiClient paramGoogleApiClient, OnDataPointListener paramOnDataPointListener)
  {
    paramOnDataPointListener = zzan.get().getString(paramOnDataPointListener, paramGoogleApiClient.getLooper());
    if (paramOnDataPointListener == null) {
      return PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, paramGoogleApiClient);
    }
    return say(paramGoogleApiClient, paramOnDataPointListener, null);
  }
}
