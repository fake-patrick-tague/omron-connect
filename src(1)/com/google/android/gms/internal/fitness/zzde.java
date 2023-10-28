package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import java.util.List;

public final class zzde
  implements HistoryApi
{
  public zzde() {}
  
  private final PendingResult playNext(GoogleApiClient paramGoogleApiClient, DataType paramDataType, boolean paramBoolean)
  {
    return paramGoogleApiClient.enqueue(new zzdn(this, paramGoogleApiClient, paramDataType, paramBoolean));
  }
  
  public final PendingResult deleteData(GoogleApiClient paramGoogleApiClient, DataDeleteRequest paramDataDeleteRequest)
  {
    return paramGoogleApiClient.enqueue(new zzdg(this, paramGoogleApiClient, paramDataDeleteRequest));
  }
  
  public final PendingResult insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet)
  {
    Preconditions.checkNotNull(paramDataSet, "Must set the data set");
    Preconditions.checkState(paramDataSet.getDataPoints().isEmpty() ^ true, "Cannot use an empty data set");
    Preconditions.checkNotNull(paramDataSet.getDataSource().get(), "Must set the app package name for the data source");
    return paramGoogleApiClient.enqueue(new zzdh(this, paramGoogleApiClient, paramDataSet, false));
  }
  
  public final PendingResult readDailyTotal(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return playNext(paramGoogleApiClient, paramDataType, false);
  }
  
  public final PendingResult readDailyTotalFromLocalDevice(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return playNext(paramGoogleApiClient, paramDataType, true);
  }
  
  public final PendingResult readData(GoogleApiClient paramGoogleApiClient, DataReadRequest paramDataReadRequest)
  {
    return paramGoogleApiClient.enqueue(new zzdk(this, paramGoogleApiClient, paramDataReadRequest));
  }
  
  public final PendingResult registerDataUpdateListener(GoogleApiClient paramGoogleApiClient, DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest)
  {
    return paramGoogleApiClient.enqueue(new zzdi(this, paramGoogleApiClient, paramDataUpdateListenerRegistrationRequest));
  }
  
  public final PendingResult unregisterDataUpdateListener(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzdl(this, paramGoogleApiClient, paramPendingIntent));
  }
  
  public final PendingResult updateData(GoogleApiClient paramGoogleApiClient, DataUpdateRequest paramDataUpdateRequest)
  {
    Preconditions.checkNotNull(paramDataUpdateRequest.getDataSet(), "Must set the data set");
    Preconditions.checkNotZero(paramDataUpdateRequest.getAsLong(), "Must set a non-zero value for startTimeMillis/startTime");
    Preconditions.checkNotZero(paramDataUpdateRequest.getDataLength(), "Must set a non-zero value for endTimeMillis/endTime");
    return paramGoogleApiClient.enqueue(new zzdj(this, paramGoogleApiClient, paramDataUpdateRequest));
  }
}
