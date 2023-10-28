package com.google.android.gms.fitness;

import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;

@Deprecated
public abstract interface RecordingApi
{
  public abstract PendingResult listSubscriptions(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult listSubscriptions(GoogleApiClient paramGoogleApiClient, DataType paramDataType);
  
  public abstract PendingResult subscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource);
  
  public abstract PendingResult subscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType);
  
  public abstract PendingResult unsubscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource);
  
  public abstract PendingResult unsubscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType);
  
  public abstract PendingResult unsubscribe(GoogleApiClient paramGoogleApiClient, Subscription paramSubscription);
}
