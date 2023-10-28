package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.data.Subscription.zza;

public final class zzdo
  implements RecordingApi
{
  public zzdo() {}
  
  private final PendingResult empty(GoogleApiClient paramGoogleApiClient, Subscription paramSubscription)
  {
    return paramGoogleApiClient.enqueue(new zzdt(this, paramGoogleApiClient, paramSubscription));
  }
  
  public final PendingResult listSubscriptions(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.enqueue(new zzdr(this, paramGoogleApiClient));
  }
  
  public final PendingResult listSubscriptions(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return paramGoogleApiClient.enqueue(new zzdq(this, paramGoogleApiClient, paramDataType));
  }
  
  public final PendingResult subscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return empty(paramGoogleApiClient, new Subscription.zza().setNegativeButton(paramDataSource).create());
  }
  
  public final PendingResult subscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return empty(paramGoogleApiClient, new Subscription.zza().setNegativeButton(paramDataType).create());
  }
  
  public final PendingResult unsubscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return paramGoogleApiClient.execute(new zzdv(this, paramGoogleApiClient, paramDataSource));
  }
  
  public final PendingResult unsubscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return paramGoogleApiClient.execute(new zzds(this, paramGoogleApiClient, paramDataType));
  }
  
  public final PendingResult unsubscribe(GoogleApiClient paramGoogleApiClient, Subscription paramSubscription)
  {
    if (paramSubscription.getDataType() == null) {
      return unsubscribe(paramGoogleApiClient, (DataSource)Preconditions.checkNotNull(paramSubscription.getDataSource()));
    }
    return unsubscribe(paramGoogleApiClient, (DataType)Preconditions.checkNotNull(paramSubscription.getDataType()));
  }
}
